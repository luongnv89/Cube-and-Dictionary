/**
 * 
 */
package csc5021.utils;

import java.util.Random;

/**
 * @author luongnv89
 * 
 */
public class Utils {
	public static String getWordRandomly(int word_length) {
		StringBuffer bf = new StringBuffer();
		while (bf.length() < word_length) {
			Random random = new Random();
			int char_code = 33 + random.nextInt(126-33);
			bf.append((char)char_code);
		}
		return bf.toString();
	}
}
