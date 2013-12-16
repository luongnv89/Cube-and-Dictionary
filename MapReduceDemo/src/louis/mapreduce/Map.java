package louis.mapreduce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		Utils.writeToFile("Map: \nline" + line + "\nkey: " + String.valueOf(key) + "\nContext: " + context.toString()
				+ "\n", "Log.txt");
		StringTokenizer tokenizer = new StringTokenizer(line);
		ArrayList<String> listInterestingWord = new ArrayList<>();
		listInterestingWord.add("the");
		listInterestingWord.add("a");
		listInterestingWord.add("an");
		listInterestingWord.add("Nelson");
		// listInterestingWord.add("the");

		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			if (listInterestingWord.contains(word)) {
				context.write(new Text(word), new IntWritable(1));
			}
		}
//		context.write(new Text(String.valueOf(line.hashCode())), new IntWritable(1));
	}
}
