/**
 * 
 */
package csc5021.mapreduce.objects;

import java.util.HashMap;

/**
 * @author luongnv89
 * 
 */
public class Plane {
	
	HashMap<String, Character> listPoints;

	/**
	 * @param listPoints
	 */
	public Plane(HashMap<String, Character> listPoints) {
		this.listPoints = listPoints;
	}

	public char getChar(int x, int y, int z) {
		String key = String.valueOf(x) + "," + String.valueOf(y) + "," + String.valueOf(z);
		char char_ret = listPoints.get(key);
		return char_ret;
	}
}
