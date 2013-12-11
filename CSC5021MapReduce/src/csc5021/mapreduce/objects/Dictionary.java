/**
 * 
 */
package csc5021.mapreduce.objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import csc5021.interfaces.HasInvariant;
import csc5021.utilities.Utilities;

/**
 * @author luongnv89
 * 
 */
public class Dictionary implements HasInvariant {
	/**
	 * The maximum number of word of dictionary </br>The minimum of size is:
	 * A2_25 = 600 when the length of word is 2. <br>
	 * If the length of word is bigger than 2, the maximum of size of dictionary
	 * is 1000
	 */
	public static int MAX_SIZE = 1000;
	/**
	 * Minimum number of word of dictionary
	 */
	public static final int MIN_SIZE = 3;
	/**
	 * Maximum length of a word in dictionary
	 */
	public static final int MAX_LENGTH = 100;
	/**
	 * Minimum length of a word in dictionary
	 */
	public static final int MIN_LENGTH = 2;
	/**
	 * The length of word in the dictionary, it fix for every word, from 2 to
	 * 100
	 */
	int length;

	String path;

	int size;

	/**
	 * Constructor a new dictionary
	 * 
	 * @param lengthOfWord
	 *            length of words of dictionary
	 * @param size
	 *            the initial size of dictionary. The initial words of
	 *            dictionary are generated randomly
	 */
	public Dictionary(int lengthOfWord, int size, String path) {
		if (lengthOfWord == 2)
			MAX_SIZE = 600;

		if (lengthOfWord < MIN_LENGTH || lengthOfWord > MAX_LENGTH) {
			System.out.println("The length of word isnt valid. The default value will be set for dictionary");
			this.length = 3;
		} else {
			this.length = lengthOfWord;
		}
		this.path = path;
	}

	/**
	 * Create a new dictionary from an input text file.
	 * 
	 * @param pathFile
	 * @throws Exception
	 */
	public Dictionary(String pathFile) throws Exception {
		this.path = pathFile;
		BufferedReader br = new BufferedReader(new FileReader(pathFile));
		try {
			String line = br.readLine();
			if (line == null || line.length() < MIN_LENGTH) {
				throw new Exception("The input file is invalid!");
			} else {
				this.length = line.length();
				int s = 0;
				while (line != null) {
					if (line.length() != length || !Utilities.validWord(line)) {
						throw new Exception("Invalid word: " + line);
					} else {
						s++;
					}
				}
				this.size = s;
			}
		} finally {
			br.close();
		}
	}

	/**
	 * @return the lengthOfWord
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Get size of dictionary
	 * 
	 * @return the size of dictionary
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Get word in dictionary which has index equal "index"
	 * 
	 * @param index
	 * @return the word has index equal "index"
	 * @throws Exception
	 */
	public String getWordByIndex(int index) throws Exception {
		if (index >= 0 && index < this.size) {
			BufferedReader br = new BufferedReader(new FileReader(this.path));
			try {
				String line = br.readLine();

				int word_index = 0;
				while (line != null && index <= word_index) {
					if (word_index == index)
						return line;
					word_index++;
				}

			} finally {
				br.close();
			}
		}
		System.out.println("Cannot find the word with index = " + index);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see csc5021.interfaces.HasInvariant#invariant()
	 * 
	 * @return <br>false if there is some word of dictionary which aren't valid
	 * word. <br>false if the size of dictionary isn't valid! <br> false if the
	 * size of word of dictionary is shorter than 2 or longer than 100
	 */
	@Override
	public boolean invariant() {
		int size = getSize();
		// Check size of dictionary
		if (size < MIN_SIZE || size > MAX_SIZE) {
			System.out.println("The size of dictionary isn't valid: " + size
					+ "\n It must be smaller than 1001 and bigger than 2");
			return false;
		}
		// Check length of words of dictionary
		if (this.length < 2 || this.length > 100) {
			System.out.println("The length of word isn't valid: " + length
					+ "\nThe length of word must be longer than 1 and shorter than 101");
			return false;
		}
		// Check valid of each word in dictionary
		for (int i = 0; i < size; i++) {
			String currWord = null;
			try {
				currWord = getWordByIndex(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (currWord.length() != length || !Utilities.validWord(currWord)) {
				System.out.println("There is a invalid word in dictionary: " + currWord);
				return false;
			}
		}
		return true;
	}

}
