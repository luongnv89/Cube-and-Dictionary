package csc5021.mapreduce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
	/**
	 * The specific path of dictionary
	 */
	String dictionaryPath = "hdfs://localhost.localdomain:8020/dic";

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ArrayList<String> listWords = null;
		try {
			listWords = loadDictionary(dictionaryPath);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = value.toString();

		if (line.length() >= listWords.get(0).length()) {
			ArrayList<String> listFound = new ArrayList<String>();
			for (int i = 0; i < listWords.size(); i++) {
				String word = listWords.get(i);
				Text wordText = new Text();
				wordText.set(word);
				if (line.contains(word) || revert(line).contains(word)) {
					listFound.add(word);
					context.write(wordText, new IntWritable(1));
				} else {
					context.write(wordText, new IntWritable(0));
				}
			}
		}
	}

	/**
	 * Read dictionary from HDFS system file
	 * 
	 * @param dictionaryPath2
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private ArrayList<String> loadDictionary(String dictionaryPath2) throws IOException, URISyntaxException {
		ArrayList<String> listWord = new ArrayList<String>();
		FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost.localdomain:8020"), new Configuration());
		Path file = new Path(dictionaryPath);
		InputStream os = hdfs.open(file);
		BufferedReader brHDFS = new BufferedReader(new InputStreamReader(os, "UTF-8"));
		String word = brHDFS.readLine();
		while (word != null) {
			listWord.add(word);
			word = brHDFS.readLine();
		}
		return listWord;
	}

	/**
	 * Revert a string
	 * 
	 * @param string1
	 * @return the revert of input string
	 */
	public static String revert(String string1) {
		StringBuffer str = new StringBuffer();
		char[] array = string1.toCharArray();
		for (int i = 0; i < array.length; i++) {
			str.append(array[array.length - i - 1]);
		}
		return str.toString();
	}

}
