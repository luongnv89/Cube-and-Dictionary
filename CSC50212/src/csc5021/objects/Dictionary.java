/**
 * 
 */
package csc5021.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import csc5021.interfaces.HasInvariant;
import csc5021.utils.Utils;

/**
 * @author luongnv89
 * 
 */
public class Dictionary implements HasInvariant {
	int word_length;
	int dic_size;
	ArrayList<String> word_list;

	/**
	 * @param word_length
	 * @param dic_size
	 */
	public Dictionary(int word_length, int dic_size) {
		this.word_length = word_length;
		this.dic_size = dic_size;
		word_list = new ArrayList<>();
		while (word_list.size() < dic_size) {
			String word = Utils.getWordRandomly(word_length);
			if (!word_list.contains(word))
				word_list.add(word);
		}
	}

	/**
	 * @param word_list
	 */
	public Dictionary(ArrayList<String> word_list) {
		this.word_list = word_list;
		this.dic_size = this.word_list.size();
		this.word_length = word_list.get(0).length();
	}

	public Dictionary(String path) {

		BufferedReader br = null;

		try {

			String sCurrentLine;
			this.word_list = new ArrayList<>();

			br = new BufferedReader(new FileReader(path));

			while ((sCurrentLine = br.readLine()) != null) {
				if (!this.word_list.contains(sCurrentLine)) {
					this.word_list.add(sCurrentLine);
				}
			}
			this.word_length = this.word_list.get(0).length();
			this.dic_size = this.word_list.size();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @return the word_length
	 */
	public int getWord_length() {
		return word_length;
	}

	/**
	 * @return the dic_size
	 */
	public int getDic_size() {
		return dic_size;
	}

	/**
	 * @return the word_list
	 */
	public ArrayList<String> getWord_list() {
		return word_list;
	}

	@Override
	public boolean invariant() {
		if (this.word_length < 2 || this.word_length > 100) {
			System.out.println("The word length is not valid: " + this.word_length);
			return false;
		}

		if (this.dic_size < 3 || this.dic_size > 1000) {
			System.out.println("The size of dictionary is not valid: " + this.dic_size);
			return false;
		}

		if (this.dic_size != this.word_list.size()) {
			System.out.println("The size of dictionary and the size of word list are not the same! \nDic size: "
					+ this.dic_size + "\nWord list size: " + this.word_list.size());
			return false;
		}

		for (int i = 0; i < this.word_list.size(); i++) {
			char[] array = this.word_list.get(i).toCharArray();
			if (array.length != this.word_length) {
				System.out
						.println("There is an invalid word in dictionary. The length of word and the word_length of dictionary are not the same!\nInvalid word: "
								+ this.word_list.get(i)
								+ "\nLength of word: "
								+ array.length
								+ "\nword_length of dictionary: " + this.word_length);
				return false;
			}
			for (int j = 0; j < array.length; j++) {
				int char_code = (int) array[i];
				if (char_code < 33 || char_code > 126) {
					System.out.println("There is an invalid word indictionary.\nInvalid word: " + this.word_list.get(i)
							+ "\nThere is an invalid character in word: " + array[j]);
					return false;
				}
			}
		}

		return true;
	}

}
