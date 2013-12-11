/**
 * 
 */
package csc5021.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import csc5021.mapreduce.objects.Cube;
import csc5021.mapreduce.objects.Dictionary;

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
	 * 
	 * @return
	 */
	public static char getRandomCharater() {
		int index = (new Random()).nextInt(25) + 65;
		return Character.toChars(index)[0];
	}

	/**
	 * Check a word is composed by the character from A-Z
	 * 
	 * @param word
	 * @return true if all the character of word is in A-Z <br>
	 *         false otherwise
	 */
	public static boolean validWord(String word) {
		char[] array = word.toUpperCase().toCharArray();
		for (int i = 0; i < array.length; i++) {
			int index = Character.toUpperCase(array[i]);
			if (index < 65 || index > 90) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Create new word with the input length and the values is randomly
	 * 
	 * @param lengthOfWord
	 * @return
	 */
	public static String createNewWord(int lengthOfWord) {
		String str = "";
		for (int i = 0; i < lengthOfWord; i++) {
			str += getRandomCharater();
		}
		return str;
	}

	public static String revert(String string1) {
		StringBuffer str = new StringBuffer();
		char[] array = string1.toCharArray();
		for (int i = 0; i < array.length; i++) {
			str.append(array[array.length - i - 1]);
		}
		return str.toString();
	}

	public static Dictionary generateDictionary(int length, int sizeOfDict, String path) {
		ArrayList<String> listWord = new ArrayList<>();
		// Init the size of dictionary
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			for (int i = 0; i < sizeOfDict; i++) {
				boolean ok = false;
				int retry = 0;
				while (!ok) {
					String newWord = Utilities.createNewWord(length);
					if (!listWord.contains(newWord)) {
						listWord.add(newWord);
						out.write(listWord.get(i) + "\n");
						ok = true;
						retry = 0;
					} else {
						retry++;
						if (retry == 5)
							ok = true;
					}
				}
			}

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new Dictionary(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cannot generate!");
		return null;
	}

	public static Cube generateCue(int size, String path) {
		if (size >= Cube.MIN_SIZE && size <= Cube.MAX_SIZE) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(path));
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						char[] chars = new char[size];
						for (int k = 0; k < size; k++) {
							chars[k] = Utilities.getRandomCharater();
						}
						out.write(chars);
						out.write("\n");
					}
				}
				out.close();
				return new Cube(size, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Cannot generate cube!");
		return null;
	}

}
