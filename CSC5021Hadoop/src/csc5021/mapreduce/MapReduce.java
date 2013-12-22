/**
 *
 */
package csc5021.mapreduce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
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

/**
 * @author luongnv89
 */

public class MapReduce {

	/**
	 * The local host address of hadoop
	 */
	static String hdfsURL = "hdfs://localhost.localdomain:8020";
	/**
	 * The size of cube
	 */
	static int cubeSize;
	/**
	 * The path of input dataset
	 */
	static Path inputDataset;
	/**
	 * Result path
	 */
	static Path outputData;

	static Path result;
	/**
	 * The path of input cube
	 */
	static String cubePath;
	/**
	 * The path of input dic
	 */
	static String dicPath;
	/**
	 * The path of log file
	 */
	public static String logFile = "log_";

	/**
	 * Configuration
	 */
	static Configuration conf;

	public static ArrayList<String> listWords = new ArrayList<String>();

	public static void main(String[] args) throws Exception {

		// Config
		long startTime = System.currentTimeMillis();
		conf = new Configuration();
		dicPath = args[0];
		System.out.println("Dictionary path: " + dicPath);
		cubePath = args[1];
		System.out.println("Cube path: " + cubePath);
		inputDataset = new Path(hdfsURL + "/data_" + startTime);
		outputData = new Path(hdfsURL + "/data_" + startTime + "/output");
		result = new Path(hdfsURL + "/data_" + startTime + "/output/part-r-00000");
		System.out.println("Input data: " + inputDataset);
		logFile += startTime;
		System.out.println("Log file: " + logFile);

		extractCubeData();

		writeDictionary();

		System.out.println("Finished setup....: " + String.valueOf(System.currentTimeMillis() - startTime));
		
		//Create Mapreduce job
		Job job = new Job(conf, "MapReduce");
		job.setJarByClass(MapReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, inputDataset);
		FileOutputFormat.setOutputPath(job, outputData);
		
		
		System.out.println("Setup job configuration ... waiting for completed!");
		job.waitForCompletion(true);
		
		
		long totalTime = System.currentTimeMillis() - startTime;
		
		//Extract result from output file
		FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost.localdomain:8020"), new Configuration());
		InputStream os = hdfs.open(result);
		BufferedReader brHDFS = new BufferedReader(new InputStreamReader(os, "UTF-8"));
		String word = brHDFS.readLine();
		boolean associated = true;
		while (word != null && associated) {
			if (word.contains("0"))
				associated = false;
			word = brHDFS.readLine();
		}
		if (associated)
			System.out.println("ASSOCIATED! \nTotal time: " + String.valueOf(totalTime));
		else {
			System.out.println("NO ASSOCIATED! \nTotal time: " + String.valueOf(totalTime));
		}
	}

	/**
	 * Extract all possible string from cube
	 */
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

	/**
	 * Extract all possible from all file which is generated from cube
	 */
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

	/**
	 * Change the column and row of some file which is generated from cube
	 */
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

	/**
	 * Extract the vertical string and cross - right-top -> left-bottom string
	 * from input file. The input file will be deleted after extracted all
	 * string.
	 * 
	 * @param filePath
	 */
	private static void extractString(final String filePath) {
		ArrayList<StringBuffer> listStringBuffers = new ArrayList<StringBuffer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			FileSystem hdfs = FileSystem.get(new URI(hdfsURL), conf);
			Path file = new Path(inputDataset + "/" + "extract_" + filePath);
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

	/**
	 * Change the column and row of an input file.
	 * 
	 * @param filePath
	 */
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

	/**
	 * Split the cube by the planes: <br>
	 * THe planes which has equation is: x+y=constant<br>
	 * THe planes which has equation is: x-y=constant
	 */
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

	/**
	 * Split the cube by the planes which is parallel with OYZ
	 */
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

	/**
	 * Split cube by the planes which is parallel with OXZ
	 */
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

	/**
	 * Split cube by the planes which is parallel with OXY
	 */
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

	/**
	 * Load dictionary
	 */
	private static void writeDictionary() {
		System.out.println("Save dictionary from: " + dicPath + " to HDFS!");
		try {
			BufferedReader br = new BufferedReader(new FileReader(dicPath));

			FileSystem hdfs = FileSystem.get(new URI(hdfsURL), conf);
			Path file = new Path(hdfsURL + "/dic");
			if (hdfs.exists(file)) {
				hdfs.delete(file, true);
			}
			OutputStream os = hdfs.create(file, new Progressable() {
				public void progress() {
					System.out.println("write new word to dictionary !");
				}
			});
			BufferedWriter brHDFS = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

			String line = br.readLine();

			while (line != null) {
				// Normal string
				brHDFS.write(line + "\n");

				line = br.readLine();
			}
			br.close();
			brHDFS.close();
			hdfs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
