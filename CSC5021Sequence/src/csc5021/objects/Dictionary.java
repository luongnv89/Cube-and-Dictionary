/**
 * 
 */
package csc5021.objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
	private static int MAX_SIZE = 1000;
	/**
	 * Minimum number of word of dictionary
	 */
	private static final int MIN_SIZE = 3;
	/**
	 * Maximum length of a word in dictionary
	 */
	private static final int MAX_LENGTH = 100;
	/**
	 * Minimum length of a word in dictionary
	 */
	private static final int MIN_LENGTH = 2;
	/**
	 * The length of word in the dictionary, it fix for every word, from 2 to
	 * 100
	 */
	int length;

	/**
	 * List all word in the dictionary Using ArrayList to store list of word, it
	 * can be dynamically add, remove, edit the word of dictionary easier There
	 * isn't any couple of word have same value
	 */
	ArrayList<String> listWord;

	/**
	 * Constructor a new dictionary
	 * 
	 * @param lengthOfWord length of words of dictionary
	 * @param size the initial size of dictionary. The initial words of dictionary are generated randomly
	 */
	public Dictionary(int lengthOfWord, int size) {
		if (lengthOfWord == 2)
			MAX_SIZE = 600;

		if (lengthOfWord < MIN_LENGTH || lengthOfWord > MAX_LENGTH) {
			System.out
					.println("The length of word isnt valid. The default value will be set for dictionary");
			this.length = 3;
		} else {
			this.length = lengthOfWord;
		}
		listWord = new ArrayList<>();
		initRandomly(size);
	}

	/**
	 * Constructor a dictionary by input list word
	 * 
	 * @param listWord
	 * @throws Exception
	 */
	public Dictionary(ArrayList<String> listWord) throws Exception {
		boolean ok = true;
		int length = listWord.get(0).length();
		for (int i = 0; i < listWord.size(); i++) {
			if (listWord.get(i).length() != length
					|| !Utilities.validWord(listWord.get(i))) {
				ok = false;
				break;
			}
		}
		if (ok) {
			this.listWord = listWord;
			this.length = length;
		} else {
			throw new Exception("The input listword is invalid");
		}
	}

	/**
	 * Create a new dictionary from an input text file.
	 * 
	 * @param pathFile
	 * @throws Exception
	 */
	public Dictionary(String pathFile) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(pathFile));
		try {
			String line = br.readLine();
			if (line == null || line.length() < 3) {
				throw new Exception("The input file is invalid!");
			} else {
				this.length = line.length();
				this.listWord = new ArrayList<>();
				while (line != null) {
					if (line.length() != length || !Utilities.validWord(line)) {
						throw new Exception("Invalid word: " + line);
					} else {
						listWord.add(line);
						line = br.readLine();
					}
				}
			}
		} finally {
			br.close();
		}
	}

	/**
	 * Init randomly the list words of dictionary
	 */
	private void initRandomly(int sizeOfDict) {
		listWord.clear();
		// Init the size of dictionary
		int sizeOfDictionary = (new Random()).nextInt(sizeOfDict);
		if (sizeOfDictionary < MIN_SIZE)
			sizeOfDictionary = MIN_SIZE;

		for (int i = 0; i < sizeOfDictionary; i++) {
			boolean ok = false;
			int retry = 0;
			while (!ok) {
				String newWord = Utilities.createNewWord(this.length);
				if (!listWord.contains(newWord)) {
					listWord.add(newWord);
					ok = true;
					retry = 0;
				} else {
					retry++;
					if (retry == 5)
						ok = true;
				}
			}
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
		return listWord.size();
	}

	/**
	 * Get word in dictionary which has index equal "index"
	 * 
	 * @param index
	 * @return the word has index equal "index"
	 */
	public String getWordByIndex(int index) {
		return listWord.get(index);
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
		//Check size of dictionary
		if (size < MIN_SIZE || size > MAX_SIZE) {
			System.out.println("The size of dictionary isn't valid: " + size
					+ "\n It must be smaller than 1001 and bigger than 2");
			return false;
		}
		//Check length of words of dictionary
		if (this.length < 2 || this.length > 100) {
			System.out
					.println("The length of word isn't valid: "
							+ length
							+ "\nThe length of word must be longer than 1 and shorter than 101");
			return false;
		}
		//Check valid of each word in dictionary
		for (int i = 0; i < size; i++) {
			String currWord = getWordByIndex(i);
			if (currWord.length() != length || !Utilities.validWord(currWord)) {
				System.out.println("There is a invalid word in dictionary: "
						+ currWord);
				return false;
			}
		}
		return true;
	}

	/**
	 * Show the content of dictionary
	 */
	public void showContent() {
		String str = "";
		str += "Index \t Value \n";
		for (int i = 0; i < listWord.size(); i++) {
			str += i + " \t " + listWord.get(i) + "\n";
		}
		System.out.println(str);
	}
	
	/**
	 * Save the content of dictionary to a file
	 * @param pathFile
	 * 
	 */
	public void saveToFile(String pathFile) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(pathFile));
			for (int i = 0; i < listWord.size(); i++) {
				out.write(getWordByIndex(i)+"\n");
			}
			out.close();
		} catch (IOException e) {
		}
	}

}
