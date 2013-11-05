/**
 * 
 */
package csc5021.utilities;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author luongnv89
 * 
 */
public class Utilities {
	public static int getCubeSize(int length) {
		int uperBound = (int) Math.sqrt(length);
		int lowerBound = (int) Math.sqrt(uperBound);
		for (int i = lowerBound; i <= uperBound; i++) {
			if (i * i * i == length)
				return i;
			if (i * i * i > length)
				return -1;
		}
		return -1;
	}

	public static char getRandomCharater() {
		int index = (new Random()).nextInt(25)+65;
		return Character.toChars(index)[0];
	}
}
