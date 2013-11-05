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

	/**
	 * Get randomly a char value from A-Z
	 * @return
	 */
	public static char getRandomCharater() {
		int index = (new Random()).nextInt(25)+65;
		return Character.toChars(index)[0];
	}

	/**
	 * Check a word is composed by the character from A-Z
	 * @param word
	 * @return true if all the character of word is in A-Z
	 * <br>false otherwise 
	 */
	public static boolean validWord(String word) {
		char[] array = word.toUpperCase().toCharArray();
		for(int i=0;i<array.length;i++){
			int index = Character.toUpperCase(array[0]);
			if(index<65||index>90){
				return false;
			}
		}
		return true;
	}

	/**
	 * Create new word with the input length and the values is randomly
	 * @param lengthOfWord
	 * @return
	 */
	public static String createNewWord(int lengthOfWord) {
		String str="";
		for(int i=0;i<lengthOfWord;i++){
			str +=getRandomCharater();
		}
		return str;
	}
}
