/**
 *
 */
package csc5021.mapreduce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Progressable;

import csc5021.utilities.Utils;

/**
 * @author luongnv89
 */

public class MapReduce {

	static String hdfsURL = "hdfs://localhost.localdomain:8020";
	static int cubeSize;
	static String inputDataset;
	static String cubePath;
	static String dicPath;
	public static String logFile = "log_";

	static Configuration conf;

	public static void main(String[] args) throws Exception {

		// Config
		long startTime = System.currentTimeMillis();
		conf = new Configuration();
		dicPath = args[0];
		System.out.println("Dictionary path: " + dicPath);
		cubePath = args[1];
		System.out.println("Cube path: " + cubePath);
		inputDataset = "data_" + startTime;
		System.out.println("Input data: " + inputDataset);
		logFile += startTime;
		System.out.println("Log file: " + logFile);
		loadDictionary();
		extractCubeData();
		System.out.println("Finished setup....: " + String.valueOf(System.currentTimeMillis() - startTime));

		System.out.println("Create new job");

		// FileSystem hdfs = FileSystem.get(new URI(hdfsURL), conf);
		// Path file = new Path(hdfsURL + "/" + inputDataset + "/" +
		// "empty.txt");
		// OutputStream os = hdfs.create(file, new Progressable() {
		// public void progress() {
		// System.out.println("create new data file: " + inputDataset + "/" +
		// "empty.txt");
		// }
		// });
		// BufferedWriter brHDFS = new BufferedWriter(new OutputStreamWriter(os,
		// "UTF-8"));
		// brHDFS.write("This is some text from Louis");
		// brHDFS.close();

		Job job = new Job(conf, "MapReduce");
		job.setJarByClass(MapReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path("/" + inputDataset));
		FileOutputFormat.setOutputPath(job, new Path("/" + inputDataset + "/output"));
		System.out.println("Setup job configuration ... waiting for completed!");
		job.waitForCompletion(true);
		long totalTime = System.currentTimeMillis() - startTime;

		if (ShareMemory.getListWords().isEmpty()) {
			System.out.println("ASSOCIATED!");
			Utils.writeToFile("\nTotal executed time: " + String.valueOf(totalTime) + "\nASSOCIATED!");
		} else {
			System.out.println("NO ASSOCIATED!");
			Utils.writeToFile("\nTotal executed time: " + String.valueOf(totalTime) + "\nNO ASSOCIATED!"
					+ "\nThe list of words which could not found: \n");
			for (int i = 0; i < ShareMemory.getListWords().size(); i++) {
				Utils.writeToFile(ShareMemory.getListWords().get(i) + " ; ");
			}
		}
	}

	private static void extractCubeData() {
		System.out.println("Extract cube data from : " + cubePath);
		splitByZ();
		System.out.println("Splited by Z");
		splitByX();
		System.out.println("Splited by X");
		splitByY();
		System.out.println("Splited by Y");
		splitByCrossXY();
		System.out.println("Splited by cross XY");
		revertfiles();
		System.out.println("Revert some file");
		extractStringAllFile();
		System.out.println("Extracted all file");
	}

	private static void extractStringAllFile() {
		System.out.println("Extract string...");
		for (int i = 0; i < cubeSize; i++) {
			extractString("z_" + i);
			extractString("revert_y_" + i);
			extractString("x_" + i);
		}

		for (int sumxy = 0; sumxy < 2 * cubeSize; sumxy++) {
			extractString("sumxy_" + sumxy);
			extractString("revert_sumxy_" + sumxy);

		}
		for (int subxy = -(cubeSize - 1); subxy < cubeSize; subxy++) {
			extractString("subxy_" + subxy);
			extractString("revert_subxy_" + subxy);

		}
	}

	private static void revertfiles() {

		for (int i = 0; i < cubeSize; i++) {
			revertFile("y_" + i);
			File file = new File("y_" + i);
			file.delete();
		}

		for (int i = 0; i < 2 * cubeSize; i++) {
			revertFile("sumxy_" + i);
		}
		for (int subxy = -(cubeSize - 1); subxy < cubeSize; subxy++) {
			revertFile("subxy_" + subxy);
		}

	}

	private static void extractString(final String filePath) {
		ArrayList<StringBuffer> listStringBuffers = new ArrayList<StringBuffer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			FileSystem hdfs = FileSystem.get(new URI(hdfsURL), conf);
			Path file = new Path(hdfsURL + "/" + inputDataset + "/" + "extract_" + filePath);
			OutputStream os = hdfs.create(file, new Progressable() {
				public void progress() {
					System.out.println("create new data file: " + inputDataset + "/" + "extract_" + filePath);
				}
			});
			BufferedWriter brHDFS = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

			String line = br.readLine();

			int offset = 0;
			while (line != null) {
				// Normal string
				brHDFS.write(line + "\n");
				// Cross string
				char[] array = line.toCharArray();
				for (int i = 0; i < array.length; i++) {
					if (listStringBuffers.size() <= i + offset) {
						listStringBuffers.add(new StringBuffer());
					}
					listStringBuffers.get(i + offset).append(array[i]);
				}
				line = br.readLine();
				offset++;
			}
			br.close();
			// Write cross string to file
			while (!listStringBuffers.isEmpty()) {
				brHDFS.write(listStringBuffers.get(0).toString() + "\n");
				listStringBuffers.remove(0);
			}
			brHDFS.close();
			hdfs.close();
			File delFile = new File(filePath);
			delFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void revertFile(String filePath) {
		ArrayList<StringBuffer> listStringBuffers = new ArrayList<StringBuffer>();
		int size;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			size = line.length();
			for (int i = 0; i < size; i++) {
				listStringBuffers.add(new StringBuffer());
			}
			while (line != null) {
				char[] array = line.toCharArray();
				for (int i = 0; i < size; i++) {
					listStringBuffers.get(i).append(array[i]);
				}
				line = br.readLine();
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter("revert_" + filePath));
			while (!listStringBuffers.isEmpty()) {
				bw.write(listStringBuffers.get(0).toString() + "\n");
				listStringBuffers.remove(0);
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void splitByCrossXY() {
		for (int z = 0; z < cubeSize; z++) {
			try {
				BufferedReader bfZ = new BufferedReader(new FileReader("z_" + z));
				String line = bfZ.readLine();
				for (int y = 0; y < cubeSize; y++) {
					char[] array = line.toCharArray();
					for (int x = 0; x < cubeSize; x++) {
						BufferedWriter bfSumXY = new BufferedWriter(new FileWriter("sumxy_" + (x + y), true));
						BufferedWriter bfSubXY = new BufferedWriter(new FileWriter("subxy_" + (x - y), true));
						bfSumXY.write(array[x]);
						bfSumXY.close();
						bfSubXY.write(array[x]);
						bfSubXY.close();
					}
					line = bfZ.readLine();
				}
				bfZ.close();
				for (int sumxy = 0; sumxy < 2 * cubeSize; sumxy++) {
					BufferedWriter bfX = new BufferedWriter(new FileWriter("sumxy_" + sumxy, true));
					bfX.write("\n");
					bfX.close();
				}

				for (int subxy = -(cubeSize - 1); subxy < cubeSize; subxy++) {
					BufferedWriter bfX = new BufferedWriter(new FileWriter("subxy_" + subxy, true));
					bfX.write("\n");
					bfX.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void splitByX() {
		for (int z = 0; z < cubeSize; z++) {
			try {
				BufferedReader bfZ = new BufferedReader(new FileReader("z_" + z));
				String line = bfZ.readLine();
				for (int y = 0; y < cubeSize; y++) {
					char[] array = line.toCharArray();
					for (int x = 0; x < cubeSize; x++) {
						BufferedWriter bfX = new BufferedWriter(new FileWriter("x_" + x, true));
						bfX.write(array[x]);
						bfX.close();
					}
					line = bfZ.readLine();
				}
				bfZ.close();
				for (int x = 0; x < cubeSize; x++) {
					BufferedWriter bfX = new BufferedWriter(new FileWriter("x_" + x, true));
					bfX.write("\n");
					bfX.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void splitByY() {
		for (int z = 0; z < cubeSize; z++) {
			try {
				BufferedReader bfZ = new BufferedReader(new FileReader("z_" + z));
				String line = bfZ.readLine();
				for (int y = 0; y < cubeSize; y++) {
					BufferedWriter bfY = new BufferedWriter(new FileWriter("y_" + y, true));
					bfY.write(line + "\n");
					bfY.close();
					bfZ.readLine();
				}
				bfZ.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static void splitByZ() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(cubePath));
			String line = bf.readLine();
			int cube_size = line.length();
			cubeSize = cube_size;
			for (int z = 0; z < cube_size; z++) {
				String zFile = "z_" + z;
				BufferedWriter bw = new BufferedWriter(new FileWriter(zFile, true));
				for (int y = 0; y < cube_size; y++) {
					bw.write(line + "\n");
					line = bf.readLine();
				}
				bw.close();
			}
			bf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void loadDictionary() {
		System.out.println("Load dictionary from: " + dicPath);
		// System.out.println("Load dictionary from: " + dicPath);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(dicPath));
			String line = br.readLine();

			while (line != null) {
				ShareMemory.getListWords().add(line);
				line = br.readLine();
			}

			System.out.println("\nCreated dictionary: \nWord length: " + ShareMemory.getListWords().get(0).length());
			System.out.println("\nSize: " + ShareMemory.getListWords().size());
			System.out.println("Finished loading dictionary!");
		} catch (Exception e) {
			System.out.println("Cannot load dictionary data!");
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
