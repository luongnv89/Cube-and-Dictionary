/**
 * 
 */
package csc5021.objects;

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
	private static int MAX_SIZE;
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
	int lengthOfWord;

	/**
	 * List all word in the dictionary Using ArrayList to store list of word, it
	 * can be dynamically add, remove, edit the word of dictionary easier There
	 * isn't any couple of word have same value
	 */
	ArrayList<String> listWord;

	/**
	 * Constructor a new dictionary with the list word is empty at the beginning
	 * 
	 * @param lengthOfWord
	 */
	public Dictionary(int lengthOfWord) {
		if (lengthOfWord == 2)
			MAX_SIZE = 600;
		else
			MAX_SIZE = 1000;

		if (lengthOfWord < MIN_LENGTH || lengthOfWord > MAX_LENGTH) {
			System.out
					.println("The length of word isnt valid. The default value will be set for dictionary");
			this.lengthOfWord = 3;
		} else {
			this.lengthOfWord = lengthOfWord;
		}
		listWord = new ArrayList<>();
	}

	/**
	 * Constructor a dictionary by input list word
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
			this.lengthOfWord = length;
		} else {
			throw new Exception("The input listword is invalid");
		}
	}

	
	/**
	 * Init randomly the list words of dictionary
	 */
	public void initRandomly(int sizeOfDict) {
		listWord.clear();
		// Init the size of dictionary
		int sizeOfDictionary = (new Random()).nextInt(sizeOfDict);
		if (sizeOfDictionary < MIN_SIZE)
			sizeOfDictionary = MIN_SIZE;

		for (int i = 0; i < sizeOfDictionary; i++) {
			boolean ok = false;
			int retry = 0;
			while (!ok) {
				String newWord = Utilities.createNewWord(this.lengthOfWord);
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
	 * Modify a word in the dictionary by a new word
	 * 
	 * @param originalWord
	 * @param newWord
	 */
	public void modifyWord(String originalWord, String newWord) {
		if (listWord.contains(newWord)) {
			System.out.println(newWord
					+ " already in the dictionary. No new word in dictionary");
		} else {
			if (newWord.length() != this.lengthOfWord) {
				System.out
						.println("The length of new word is invalid. No new word in dictionary");
			} else if (!Utilities.validWord(newWord)) {
				System.out.println("The new word isn't valid: " + newWord
						+ " . No new word in dictionary");
			} else {
				int index = findWord(originalWord);
				listWord.remove(index);
				listWord.add(index, newWord);
				System.out.println("New word in the dictionary at index: "
						+ index + " with new word is: " + newWord);
			}
		}
	}

	/**
	 * Add a new word to dictionary
	 * 
	 * @param word
	 */
	public void addNewWord(String word) {
		if (this.listWord.size() >= MAX_SIZE) {
			System.out
					.println("The size of dictionary is maximum value. Cannot add new word.");
		} else {
			if (word.length() != lengthOfWord) {
				System.out
						.println("The length of word is invalid. The word isn't added to dictionary");
			} else if (!Utilities.validWord(word)) {
				System.out.println("The word isn't valid: " + word);
			} else {
				listWord.add(word.toUpperCase());
			}
		}
	}

	/**
	 * Find a word in dictionary
	 * 
	 * @param searchingWord
	 *            word to search
	 * @return index of word in the dictionary <br>
	 *         -1 if the word doesn't exist in the dictionary
	 */
	public int findWord(String searchingWord) {
		if (searchingWord.length() != lengthOfWord)
			return -1;
		else if (Utilities.validWord(searchingWord))
			return -1;
		else {
			for (int i = 0; i < listWord.size(); i++) {
				if (listWord.get(i).equals(searchingWord))
					return i;
			}
			return -1;
		}
	}

	/**
	 * @return the lengthOfWord
	 */
	public int getLengthOfWord() {
		return lengthOfWord;
	}

	/**
	 * @return the listWord
	 */
	public ArrayList<String> getListWord() {
		return listWord;
	}

	@Override
	public boolean invariant() {
		// TODO Auto-generated method stub
		return false;
	}

	public void showContent() {
		String str = "";
		str += "Index \t Value \n";
		for (int i = 0; i < listWord.size(); i++) {
			str += i + " \t " + listWord.get(i) + "\n";
		}
		System.out.println(str);
	}

}
