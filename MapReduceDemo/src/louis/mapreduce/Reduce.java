package louis.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Context context) 
      throws IOException, InterruptedException {
    	Utils.writeToFile("Reduce: \nkey: " + String.valueOf(key) + "\nContext: " + context.toString()
				+ "\n", "Log.txt");
        int sum = 0;
        for (IntWritable val : values) {
        	Utils.writeToFile("Value: " + String.valueOf(val) + " ; ", "Log.txt");
            sum += val.get();
        }
        context.write(key, new IntWritable(sum));
        Utils.writeToFile("\nkey: " + String.valueOf(key) + "\nSum: " + String.valueOf(sum)+"\n", "Log.txt");
    }
 }