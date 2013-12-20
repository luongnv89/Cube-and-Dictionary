/**
 * 
 */
package csc5021.program;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import csc5021.interfaces.Associated;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.utilities.Utilities;

/**
 * Content all the methods which are used to check the associated of a cube and
 * a word
 * 
 * @author luongnv89
 * 
 */
public abstract class AssociatedAbstract implements Associated {
	/**
	 * Check is the cube associated with a word?
	 * 
	 * @param cube
	 * @param word
	 * @return true if the cube is associated with the input word <br>
	 *         false otherwise
	 */
	public boolean associated_word(Cube cube, String word) {
		boolean word_associated = false;

		if (!word_associated)
			word_associated = associated_directionOYZ(cube, word);
		if (!word_associated)
			word_associated = associated_directionOXZ(cube, word);
		if (!word_associated)
			word_associated = associated_directionOXY(cube, word);
		// OCDK
		if (!word_associated)
			word_associated = associated_direction1(cube, word);
		// ABFE
		if (!word_associated)
			word_associated = associated_direction2(cube, word);
		// System.out.println("Word: " + word + " associated? " +
		// String.valueOf(word_associated));
		return word_associated;
	}

	/**
	 * The plane ABFE is created by 4 points: <li>A: (0,4,0) <li>B: (0,4,4) <li>
	 * F: (4,0,4) <li>E: (4,0,0) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the ABFE plane <br>
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean associated_direction2(Cube cube, String word) {
		for (int deltaX = word.length() - 1; deltaX < cube.getSize(); deltaX++) {
			if (associated_plane2(0, deltaX, 0, deltaX, 0, 0, cube, word))
				return true;
			if (deltaX < cube.getSize() - 1) {
				if (associated_plane2(cube.getSize() - 1 - deltaX, cube.getSize() - 1, 0, cube.getSize() - 1,
						cube.getSize() - 1 - deltaX, 0, cube, word))
					return true;
			}
		}

		return false;
	}

	/**
	 * The plane ABFE is created by 4 points: <li>A: (0,4,0) <li>B: (0,4,4) <li>
	 * F: (4,0,4) <li>E: (4,0,0) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the ABFE plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the ABFE plane and they parallel with AF <li>The lines are
	 * in the plane which is parallel with the ABFE plane and they parallel with
	 * BE
	 * 
	 * @param x0
	 * @param y0
	 * @param z0
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param cube
	 * @param word
	 * @return
	 */
	private boolean associated_plane2(int x0, int y0, int z0, int x1, int y1, int z1, Cube cube, String word) {
		int deltaX = Math.abs(x1 - x0);

		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {
			// AF
			if (associated_line(x0, y0, cube.getSize() - 1 - deltaZ, x0 + deltaZ, y0 - deltaZ, cube.getSize() - 1,
					cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x1 - deltaZ, y1 + deltaZ, 0, x1, y1, deltaZ, cube, word))
					return true;
			}

			// BE
			if (associated_line(x0, y0, deltaZ, x0 + deltaZ, y0 - deltaZ, 0, cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x1 - deltaZ, y1 + deltaZ, cube.getSize() - 1, x1, y1, cube.getSize() - 1 - deltaZ,
						cube, word))
					return true;
			}
		}

		for (int z = deltaX; z < cube.getSize(); z++) {
			// AF
			if (associated_line(x0, y0, z - deltaX, x1, y1, z, cube, word))
				return true;
			// BE
			if (associated_line(x0, y0, z, x1, y1, z - deltaX, cube, word))
				return true;
		}
		return false;
	}

	/**
	 * The plane OCDK is created by 4 points: <li>O: (0,0,0) <li>C: (4,4,0) <li>
	 * D: (4,4,4) <li>K: (0,0,4) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OCDK plane <br>
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean associated_direction1(Cube cube, String word) {
		for (int deltaXY = word.length() - 1; deltaXY < cube.getSize(); deltaXY++) {
			if (associated_plane1(cube.getSize() - 1 - deltaXY, 0, cube.getSize() - 1, deltaXY, cube, word))
				return true;
			if (deltaXY < cube.getSize() - 1) {
				if (associated_plane1(0, cube.getSize() - 1 - deltaXY, deltaXY, cube.getSize() - 1, cube, word))
					return true;
			}
		}
		return false;
	}

	/**
	 * The plane OCDK is created by 4 points: <li>O: (0,0,0) <li>C: (4,4,0) <li>
	 * D: (4,4,4) <li>K: (0,0,4) <br>
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OCDK plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the ABFE plane and they parallel with OD <li>The lines are
	 * in the plane which is parallel with the ABFE plane and they parallel with
	 * CK
	 * 
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @param cube
	 * @param word
	 * @return
	 */
	private boolean associated_plane1(int x0, int y0, int x1, int y1, Cube cube, String word) {
		int deltaX = Math.abs(x1 - x0);
		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {
			// OD
			if (associated_line(x1 - deltaZ, y1 - deltaZ, 0, x1, y1, deltaZ, cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x0, y0, cube.getSize() - 1 - deltaZ, x0 + deltaZ, y0 + deltaZ, cube.getSize() - 1,
						cube, word))
					return true;
			}

			// CK
			if (associated_line(x0, y0, deltaZ, x0 + deltaZ, y0 + deltaZ, 0, cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x1 - deltaZ, y1 - deltaZ, cube.getSize() - 1, x1, y1, cube.getSize() - 1 - deltaZ,
						cube, word))
					return true;
			}
		}

		for (int z1 = deltaX; z1 < cube.getSize(); z1++) {
			// OD
			if (associated_line(x0, y0, z1 - deltaX, x1, y1, z1, cube, word))
				return true;
			// CK
			if (associated_line(x0, y0, z1, x1, y1, z1 - deltaX, cube, word))
				return true;
		}

		return false;
	}

	/**
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OYZ plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OYZ plane and they present by y = constant <li>The
	 * lines are in the plane which is parallel with the OYZ plane and they
	 * present by y-z=constant <li>The lines are in the plane which is parallel
	 * with the OYZ plane and they present by y+z=constant
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean associated_directionOYZ(Cube cube, String word) {
		for (int x = 0; x < cube.getSize(); x++) {

			for (int y = 0; y < cube.getSize(); y++) {
				// The line in plane which is presented by y = constant
				if (associated_line(x, y, 0, x, y, cube.getSize() - 1, cube, word))
					return true;
			}

			for (int deltaYZ = word.length() - 1; deltaYZ < cube.getSize(); deltaYZ++) {

				// The line in plane which is presented by y-z = constant;
				if (associated_line(x, cube.getSize() - 1 - deltaYZ, 0, x, cube.getSize() - 1, deltaYZ, cube, word))
					return true;
				if (deltaYZ < cube.getSize() - 1) {
					if (associated_line(x, 0, cube.getSize() - 1 - deltaYZ, x, deltaYZ, cube.getSize() - 1, cube, word))
						return true;
				}
				// The line in plane which is presented by x+z = constant;
				if (associated_line(x, 0, deltaYZ, x, deltaYZ, 0, cube, word))
					return true;
				if (deltaYZ < cube.getSize() - 1) {
					if (associated_line(x, cube.getSize() - 1 - deltaYZ, cube.getSize() - 1, x, cube.getSize() - 1,
							cube.getSize() - 1 - deltaYZ, cube, word))
						return true;
				}
			}

		}
		return false;
	}

	/**
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OXZ plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OXZ plane and they present by z = constant <li>The
	 * lines are in the plane which is parallel with the OXZ plane and they
	 * present by x-z=constant <li>The lines are in the plane which is parallel
	 * with the OXZ plane and they present by x+z=constant
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean associated_directionOXZ(Cube cube, String word) {

		for (int y = 0; y < cube.getSize(); y++) {

			for (int z = 0; z < cube.getSize(); z++) {
				// The line in plane which is presented by z = constant;
				if (associated_line(0, y, z, cube.getSize() - 1, y, z, cube, word))
					return true;
			}

			for (int deltaXZ = word.length() - 1; deltaXZ < cube.getSize(); deltaXZ++) {

				// The line in plane which is presented by x-z = constant;
				if (associated_line(cube.getSize() - 1 - deltaXZ, y, 0, cube.getSize() - 1, y, deltaXZ, cube, word))
					return true;
				if (deltaXZ < cube.getSize() - 1) {
					if (associated_line(0, y, cube.getSize() - 1 - deltaXZ, deltaXZ, y, cube.getSize() - 1, cube, word))
						return true;
				}
				// The line in plane which is presented by x+z = constant;
				if (associated_line(0, y, deltaXZ, deltaXZ, y, 0, cube, word))
					return true;
				if (deltaXZ < cube.getSize() - 1) {
					if (associated_line(cube.getSize() - 1 - deltaXZ, y, cube.getSize() - 1, cube.getSize() - 1, y,
							cube.getSize() - 1 - deltaXZ, cube, word))
						return true;
				}
			}

		}
		return false;
	}

	/**
	 * Checking the associated of a word with the plane of cube which is
	 * parallel with the OXY plane <br>
	 * Only check the lines below: <li>The lines are in the plane which is
	 * parallel with the OXY plane and they present by x = constant <li>The
	 * lines are in the plane which is parallel with the OXY plane and they
	 * present by x-y=constant <li>The lines are in the plane which is parallel
	 * with the OXY plane and they present by x+y=constant
	 * 
	 * @param cube
	 * @param word
	 * @return true if there is existing a line of plane which content the word <br>
	 *         false otherwise
	 */
	public boolean associated_directionOXY(Cube cube, String word) {
		for (int z = 0; z < cube.getSize(); z++) {

			for (int x = 0; x < cube.getSize(); x++) {
				// The line in plane which is presented by x=constant
				if (associated_line(x, 0, z, x, cube.getSize() - 1, z, cube, word))
					return true;
			}

			for (int deltaX = word.length() - 1; deltaX < cube.getSize(); deltaX++) {
				// The line in plane which is presented by x-y = constant;
				if (associated_line(cube.getSize() - 1 - deltaX, 0, z, cube.getSize() - 1, deltaX, z, cube, word))
					return true;
				if (deltaX < cube.getSize() - 1) {
					if (associated_line(0, cube.getSize() - 1 - deltaX, z, deltaX, cube.getSize() - 1, z, cube, word))
						return true;
				}
				// The line in plane which is presented by x+y = constant;
				if (associated_line(0, deltaX, z, deltaX, 0, z, cube, word))
					return true;
				if (deltaX < cube.getSize() - 1) {
					if (associated_line(cube.getSize() - 1 - deltaX, cube.getSize() - 1, z, cube.getSize() - 1,
							cube.getSize() - 1 - deltaX, z, cube, word))
						return true;
				}
			}

		}
		return false;
	}

	/**
	 * Checking the associated of a word with a line from the point (x0,y0,z0)
	 * to the point (x1,y1,z1) of cube
	 * 
	 * @param x0
	 * @param y0
	 * @param z0
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param cube
	 * @param word
	 * @return true if the string composed by the line of cube content the word <br>
	 *         false otherwise
	 */
	public boolean associated_line(int x0, int y0, int z0, int x1, int y1, int z1, Cube cube, String word) {
		if (x0 == x1 && y0 == y1 && z0 == z1)
			return false;
		String string1 = cube.getString(x0, y0, z0, x1, y1, z1);
		return string1.contains(word) || ((String) Utilities.revert(string1)).contains(word);
	}

	public static Dictionary generateAssociatedDictionary(int wordL, int size, Cube cube) throws Exception {
		if (!cube.invariant()) {
			throw new Exception("The input cube is not valid!");
		}
		if (wordL < Dictionary.MIN_LENGTH || wordL > Dictionary.MAX_LENGTH) {
			throw new Exception("The input word length of dictionary is not valid! " + wordL);
		}
		if (size < Dictionary.MIN_SIZE || size > Dictionary.MAX_SIZE) {
			throw new Exception("The input size of dictionary is not valid! " + size);
		}

		int wordLength = wordL-1;
		ArrayList<String> listWords = new ArrayList<>();
		Random ran = new Random();
		int nbWords = size;
		int oxy = ran.nextInt(size);
		nbWords -= oxy;
		listWords.addAll(generatedOXY(wordLength, oxy, cube, listWords));
		if (nbWords > 0) {
			int oyz = ran.nextInt(nbWords);
			nbWords -= oyz;
			listWords.addAll(generatedOYZ(wordLength, oyz, cube, listWords));
		}
		if (nbWords > 0) {
			int oxz = ran.nextInt(nbWords);
			nbWords -= oxz;
			listWords.addAll(generatedOXZ(wordLength, oxz, cube, listWords));
		}
		if (nbWords > 0) {
			int o1 = nbWords;
			listWords.addAll(generatedO1(wordLength, o1, cube, listWords));
		}

		return new Dictionary(listWords);
	}

	private static Collection<? extends String> generatedO1(int wordLength, int o1, Cube cube,
			ArrayList<String> listWords) {
		ArrayList<String> listWord = new ArrayList<>();
		int count = 0;
		while (listWord.size() < o1&&count<10) {
			count++;
			Random ran = new Random();
			int dx = ran.nextInt(1) > 0 ? 1 : -1;
			int dy = ran.nextInt(1) > 0 ? 1 : -1;
			int dz = ran.nextInt(1) > 0 ? 1 : -1;
			int y = ran.nextInt(cube.getSize() + dy * wordLength);
			int z = ran.nextInt(cube.getSize() + dz * wordLength);
			int x = ran.nextInt(cube.getSize() + dx * wordLength);
			
			String word = cube.getString(x, y, z, x - dx * wordLength, y - dy * wordLength, z - dz * wordLength);
			if (!listWords.contains(word) && !listWord.contains(word)) {
				listWord.add(word);
				count =0;
			} else {
				String word2 = cube.getString(x + wordLength, y, z, x, y, z);
				if (!listWords.contains(word2) && !listWord.contains(word2)) {
					listWord.add(word2);
					count =0;
				}
			}
		}
		return listWord;
	}

	private static Collection<? extends String> generatedOXZ(int wordLength, int oxz, Cube cube,
			ArrayList<String> listWords) {
		ArrayList<String> listWord = new ArrayList<>();
		int count=0;
		while (listWord.size() < oxz&&count<10) {
			count++;
			Random ran = new Random();
			int y = ran.nextInt(cube.getSize());
			int z = ran.nextInt(cube.getSize());
			int x = ran.nextInt(cube.getSize() - wordLength);
			String word = cube.getString(x, y, z, x + wordLength, y, z);
			if (!listWords.contains(word) && !listWord.contains(word)) {
				listWord.add(word);
				count =0;
			} else {
				String word2 = cube.getString(x + wordLength, y, z, x, y, z);
				if (!listWords.contains(word2) && !listWord.contains(word2)) {
					listWord.add(word2);
					count=0;
				}
			}
		}
		return listWord;
	}

	private static Collection<? extends String> generatedOYZ(int wordLength, int oyz, Cube cube,
			ArrayList<String> listWords) {
		ArrayList<String> listWord = new ArrayList<>();
		int count=0;
		while (listWord.size() < oyz&&count<10) {
			count++;
			Random ran = new Random();
			int x = ran.nextInt(cube.getSize());
			int y = ran.nextInt(cube.getSize());
			int z = ran.nextInt(cube.getSize() - wordLength);
			String word = cube.getString(x, y, z, x, y, z + wordLength);
			if (!listWords.contains(word) && !listWord.contains(word)) {
				listWord.add(word);
				count=0;
			} else {
				String word2 = cube.getString(x, y, z + wordLength, x, y, z);
				if (!listWords.contains(word2) && !listWord.contains(word2)) {
					listWord.add(word2);
					count =0;
				}
			}
		}
		return listWord;
	}

	private static Collection<? extends String> generatedOXY(int wordLength, int oxy, Cube cube,
			ArrayList<String> listWords) {
		ArrayList<String> listWord = new ArrayList<>();
		int count=0;
		while (listWord.size() < oxy&&count<10) {
			count++;
			Random ran = new Random();
			int z = ran.nextInt(cube.getSize());
			int x = ran.nextInt(cube.getSize());
			int y = ran.nextInt(cube.getSize() - wordLength);
			String word = cube.getString(x, y, z, x, y + wordLength, z);
			if (!listWords.contains(word) && !listWord.contains(word)) {
				count=0;
				listWord.add(word);
			} else {
				String word2 = cube.getString(x, y + wordLength, z, x, y, z);
				if (!listWords.contains(word2) && !listWord.contains(word2)) {
					count=0;
					listWord.add(word2);
				}
			}
		}
		return listWord;
	}
}
