/**
 *
 */
package csc5021.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import csc5021.mapreduce.MapReduce;

/**
 * @author luongnv89
 */
public class Utils {
    public static void writeToFile(String msg) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(MapReduce.logFile, true));
            out.write(msg);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String revertLine(String line) {
        StringBuffer str = new StringBuffer();
        char[] array = line.toCharArray();
        for (int i = 0; i < array.length; i++) {
            str.append(array[array.length - i - 1]);
        }
        return str.toString();
    }
}
