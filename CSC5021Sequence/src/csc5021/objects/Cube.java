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

import csc5021.interfaces.HasInvariant;
import csc5021.utilities.Utilities;

/**
 * The {@link Cube} class present a lattice with the size is {@link Cube#size}
 * and the content values is {@link Cube#values}
 * 
 * @author luongnv89
 * 
 */
public class Cube implements HasInvariant {

	public static final int MAX_SIZE = 10000;
	public static final int MIN_SIZE = 4;
	private static final int MAX_DIFF_LETTERS = 100;

	/**
	 * Size of lattice
	 */
	int size;
	/**
	 * Values of lattice
	 */
	char[][][] values;

	/**
	 * Constructor a Lattice by size. The values of Lattice is randomly
	 * 
	 * @param size
	 * @throws Exception
	 */
	public Cube(int size) throws Exception {
		if (size < MIN_SIZE) {
			throw new Exception("The size of cube is invalid: " + size
					+ "\nIt must be bigger than 3 and smaller than 1001");
		} else {
			this.size = size;
		}
		values = new char[this.size][this.size][this.size];
		initRandomly();
	}

	/**
	 * Create a cube from text file
	 * 
	 * @param pathFile
	 * @throws Exception
	 */
	public Cube(String pathFile) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(pathFile));
		try {
			String line = br.readLine();
			if (line == null || line.length() < 3) {
				throw new Exception("The input file is invalid!");
			} else {
				this.size = line.length();
				values = new char[this.size][this.size][this.size];
				// for each lattice
				for (int i = 0; i < this.size; i++) {
					// for each row of lattice
					for (int j = 0; j < this.size; j++) {
						char[] array = line.toCharArray();
						for (int k = 0; k < this.size; k++) {
							values[i][j][k] = array[k];
						}
						line = br.readLine();
					}
				}
			}
		} finally {
			br.close();
		}
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the values
	 */
	public char[][][] getValues() {
		return values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see csc5021.interfaces.HasInvariant#invariant()
	 * 
	 * @return <br> false if the size of cube is invalid <br> false if there are
	 * some lattice has less than 2 different letters or more than 100 different
	 * letters
	 */
	@Override
	public boolean invariant() {
		if (this.size < MIN_SIZE || this.size > MAX_SIZE) {
			System.out.println("The size of cube is invalid");
			return false;
		}
		return true;
	}

	/**
	 * Show the value of lattice
	 */
	public void showValues() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				for (int k = 0; k < this.size; k++) {
					System.out.print(values[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	/**
	 * Save the value of cube to a file
	 * 
	 * @param pathFile
	 * 
	 */
	public void saveToFile(String pathFile) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(pathFile));
			for (int i = 0; i < this.size; i++) {
				for (int j = 0; j < this.size; j++) {
					for (int k = 0; k < this.size; k++) {
						out.write(values[i][j][k]);
					}
					out.write("\n");
				}
			}
			out.close();
		} catch (IOException e) {
		}
	}

	/**
	 * create randomly values for lattice
	 */
	public void initRandomly() {
		for (int i = 0; i < this.size; i++) {
			ArrayList<Character> listLetters = new ArrayList<>();
			for (int j = 0; j < this.size; j++) {
				for (int k = 0; k < this.size; k++) {
					boolean char_ok = false;
					while (!char_ok) {
						char newChar = Utilities.getRandomCharater();
						if (!listLetters.contains(newChar)) {
							if (listLetters.size() < MAX_DIFF_LETTERS) {
								listLetters.add(newChar);
								char_ok = true;
								values[i][j][k] = newChar;
							}
						} else {
							char_ok = true;
							values[i][j][k] = newChar;
						}
					}

				}
			}
		}
	}

	/**
	 * Check is the cube associated with a dictionary
	 * 
	 * @param dic
	 * @return
	 */
	public boolean associated(Dictionary dic) {
		if (dic.getLength() > this.size)
			return false;
		else {
			for (int i = 0; i < dic.getSize(); i++) {
				if (!associated_word(dic.getWordByIndex(i)))
					return false;
			}
		}
		return true;
	}

	/**
	 * Check is the cube associated with a word?
	 * 
	 * @param string
	 * @return true if the cube is associated with the input word <br>
	 *         false otherwise
	 */
	public boolean associated_word(String string) {
		boolean word_associated = false;

		if (!word_associated)
			word_associated = associated_directionOX(string);
		if (!word_associated)
			word_associated = associated_directionOY(string);
		if (!word_associated)
			word_associated = associated_directionOZ(string);
		if (!word_associated)
			word_associated = associated_plane1(string);
		if (!word_associated)
			word_associated = associated_plane2(string);
		System.out.println("Word: " + string + " associated? "
				+ String.valueOf(word_associated));
		return word_associated;
	}

	private boolean associated_plane2(String string) {
		for (int sumXY = string.length() - 1; sumXY < size; sumXY++) {
			if (associated_AF(0, sumXY - 1, string))
				return true;
			if (associated_BE(0, sumXY - 1, string))
				return true;
		}
		for (int sumXY = size; sumXY <= 2 * size - string.length() - 1; sumXY++) {
			if (associated_AF(sumXY - size, size - 1, string))
				return true;
			if (associated_BE(sumXY - size, size - 1, string))
				return true;
		}
		return false;
	}

	private boolean associated_BE(int x0, int y0, String str) {
		int deltaX = x0 + y0 + 1;

		for (int deltaZ = str.length() - 1; deltaZ < deltaX; deltaZ++) {
			if (associated_line(x0, y0, deltaZ - 1, x0 + deltaZ - 1, y0
					- deltaZ + 1, 0, str))
				return true;
		}

		for (int z = deltaX; z < size - 1; z++) {
			if (associated_line(x0, y0, z, x0 + deltaX, y0 - deltaX,
					z - deltaX, str))
				return true;
		}

		for (int x = x0; x <= x0 + deltaX - str.length() + 1; x++) {
			if (associated_line(x, y0 - (x - x0), size - 1, x0 + deltaX, y0
					- deltaX, size - 1 - (x0 + deltaX - x), str))
				return true;
		}

		return false;
	}

	private boolean associated_AF(int x0, int y0, String str) {
		int deltaX = x0 + y0 + 1;

		for (int sumYZ = str.length() - 1; sumYZ < deltaX; sumYZ++) {
			if (associated_line(deltaX + x0 - sumYZ + 1, y0 - deltaX + sumYZ
					- 1, 0, x0 + deltaX, y0 - deltaX, sumYZ - y0 + deltaX, str))
				return true;
		}

		for (int sumYZ = deltaX; sumYZ < y0 - deltaX + size - 1; sumYZ++) {
			if (associated_line(x0, y0, sumYZ - y0, x0 + deltaX, y0 - deltaX,
					sumYZ - y0 + deltaX, str))
				return true;
		}

		for (int sumYZ = y0 - deltaX + size - 1; sumYZ <= y0 + size
				- str.length(); sumYZ++) {
			if (associated_line(x0, y0, sumYZ - y0, deltaX - sumYZ + size - 1,
					sumYZ - size + 1, size - 1, str))
				return true;
		}

		return false;
	}

	private boolean associated_plane1(String string) {
		for (int subXY = 0; subXY < size - string.length(); subXY++) {
			if (associated_OD(subXY, 0, size - 1, size - subXY, string))
				return true;
			if (associated_CK(subXY, 0, size - 1, size - subXY, string))
				return true;
		}
		for (int subXY = string.length() - size; subXY > 0; subXY--) {
			if (associated_OD(0, subXY, size - 1 - subXY, size - 1, string))
				return true;
			if (associated_CK(0, subXY, size - 1 - subXY, size - 1, string))
				return true;
		}
		return false;
	}

	private boolean associated_CK(int x0, int y0, int x1, int y1, String string) {
		int deltaX = x1 - x0;
		for (int deltaZ = string.length(); deltaZ <= deltaX; deltaZ++) {
			if (associated_line(x0, y0, deltaZ - 1, x0 + deltaZ - 1, y0
					+ deltaZ - 1, 0, string))
				return true;
			if (associated_line(x1 - deltaZ + 1, y1 - deltaZ + 1, size - 1, x1,
					y1, size - 1 - deltaZ + 1, string))
				return true;
		}

		for (int z0 = deltaX; z0 < size; z0++) {
			if (associated_line(x0, y0, z0, x1, y1, z0 - deltaX, string))
				return true;
		}
		return false;
	}

	private boolean associated_OD(int x0, int y0, int x1, int y1, String string) {
		int deltaX = x1 - x0;
		for (int deltaZ = string.length() - 1; deltaZ <= deltaX; deltaZ++) {
			if (associated_line(x1 - deltaZ + 1, y1 - deltaZ + 1, 0, x1, y1,
					deltaZ - 1, string))
				return true;
			if (associated_line(x0, y0, size - deltaZ, x0 + deltaZ - 1, y0
					+ deltaZ - 1, size - 1, string))
				return true;
		}

		for (int z1 = deltaX - 1; z1 < size; z1++) {
			if (associated_line(x0, y0, z1 - deltaX, x1, y1, z1, string))
				return true;
		}

		return false;
	}

	/**
	 * Consider all the plan which is parallel with the Oxy plan In each plan,
	 * consider the strings which is parallel with Oy axis
	 * 
	 * @param string
	 * @return
	 */
	private boolean associated_directionOZ(String string) {
		// z from 0-> size of cube
		for (int z = 0; z < this.size; z++) {
			// The plan is parallel with Oxy

			// The line in plane which is parallel with Oy
			// x from 0-> size of cube
			for (int x = 0; x < this.size; x++) {
				if (associated_line(x, 0, z, x, this.size - 1, z, string))
					return true;
			}

			// The line in plane which is presented by x-z = constant;
			for (int subXY = 0; subXY <= string.length() - 1; subXY++) {
				if (associated_line(subXY - 1, 0, z, size - 1, size - subXY, z,
						string))
					return true;
			}

			for (int subYX = 0; subYX <= string.length() - 1; subYX++) {
				if (associated_line(0, subYX - 1, z, size - subYX, size - 1, z,
						string))
					return true;
			}

			// The line in plane which is presented by x+z = constant;
			for (int sumXY = string.length() - 1; sumXY < size; sumXY++) {
				if (associated_line(sumXY - 1, 0, z, 0, sumXY - 1, z, string))
					return true;
			}
			for (int sumXY = size + 1; sumXY < 2 * size - string.length() - 1; sumXY++) {
				if (associated_line(size - 1, sumXY - size, z, sumXY - size,
						size - 1, z, string))
					return true;
			}
		}
		return false;
	}

	/**
	 * Consider all the plan which is parallel with the Oxz plan In each plan,
	 * consider the strings which is parallel with Ox axis
	 * 
	 * @param string
	 * @return
	 */
	private boolean associated_directionOY(String string) {
		// y from 0-> size of cube
		for (int y = 0; y < this.size; y++) {
			// The plan is parallel with Oxz

			// The line in plane which is parallel with Ox
			// z from 0-> size of cube
			for (int z = 0; z < this.size; z++) {
				if (associated_line(0, y, z, this.size - 1, y, z, string))
					return true;
			}

			// The line in plane which is presented by x-z = constant;
			for (int subXZ = 0; subXZ <= string.length() - 1; subXZ++) {
				if (associated_line(subXZ - 1, y, 0, size - 1, y, size - subXZ,
						string))
					return true;
			}

			for (int subZX = 0; subZX <= string.length() - 1; subZX++) {
				if (associated_line(0, y, subZX - 1, size - subZX, y, size - 1,
						string))
					return true;
			}
			// The line in plane which is presented by x+z = constant;
			for (int sumXZ = string.length() - 1; sumXZ < size; sumXZ++) {
				if (associated_line(sumXZ - 1, y, 0, 0, y, sumXZ - 1, string))
					return true;
			}
			for (int sumXZ = size + 1; sumXZ < 2 * size - string.length() - 1; sumXZ++) {
				if (associated_line(size - 1, y, sumXZ - size, sumXZ - size, y,
						size - 1, string))
					return true;
			}
		}
		return false;
	}

	/**
	 * Consider all the plan which is parallel with the Oyz plan In each plan,
	 * consider the strings which is parallel with Oz axis
	 * 
	 * @param string
	 * @return
	 */
	private boolean associated_directionOX(String string) {
		// x from 0-> size of cube
		for (int x = 0; x < this.size; x++) {
			// The plan is parallel with Oyz

			// The line in plane which is parallel with Oz
			// y from 0> size of cube
			for (int y = 0; y < this.size; y++) {
				if (associated_line(x, y, 0, x, y, this.size - 1, string))
					return true;
			}

			// The line in plane which is presented by y-z = constant;
			for (int subYZ = 0; subYZ <= string.length() - 1; subYZ++) {
				if (associated_line(x, subYZ, 0, x, size - 1, size - subYZ,
						string))
					return true;
			}

			for (int subZY = 0; subZY <= string.length() - 1; subZY++) {
				if (associated_line(x, 0, subZY, x, size - subZY, size - 1,
						string))
					return true;
			}
			// The line in plane which is presented by y+z = constant;
			for (int sumYZ = string.length() - 1; sumYZ < size; sumYZ++) {
				if (associated_line(x, sumYZ - 1, 0, x, 0, sumYZ - 1, string))
					return true;
			}
			for (int sumYZ = size + 1; sumYZ < 2 * size - string.length() - 1; sumYZ++) {
				if (associated_line(x, size - 1, sumYZ - size, x, sumYZ - size,
						size - 1, string))
					return true;
			}

		}
		return false;
	}

	public boolean associated_line(int x0, int y0, int z0, int x1, int y1,
			int z1, String str) {
		if (x0 == x1 && y0 == y1 && z0 == z1)
			return false;
		String string1 = "";
		String string2 = "";
		if (x0 == x1) {
			if (y0 == y1) {
				int max;
				int min;
				if (z0 < z1) {
					min = z0;
					max = z1;
				} else {
					min = z1;
					max = z0;
				}
				for (int i = 0; i <= max - min; i++) {
					string1 += values[x0][y0][min + i];
					string2 += values[x0][y0][max - i];
				}
			} else if (z0 == z1) {
				int max;
				int min;
				if (y0 < y1) {
					min = y0;
					max = y1;
				} else {
					min = y1;
					max = y0;
				}
				for (int i = 0; i <= max - min; i++) {
					string1 += values[x0][min + i][z0];
					string2 += values[x0][max - i][z0];
				}
			} else {
				int max;
				int min;
				if (y0 < y1) {
					min = y0;
					max = y1;
				} else {
					min = y1;
					max = y0;
				}
				for (int i = 0; i <= max - min; i++) {
					string1 += values[x0][min + i][z0 + (z1 - z0)
							* (min + i - y0) / (y1 - y0)];
					string2 += values[x0][max - i][z0 + (z1 - z0)
							* (min - i - y0) / (y1 - y0)];
				}
			}
		} else {
			int max;
			int min;
			if (x0 < x1) {
				min = x0;
				max = x1;
			} else {
				min = x1;
				max = x0;
			}
			if (y0 == y1) {
				if (z0 == z1) {
					for (int i = 0; i <= max - min; i++) {
						string1 += values[min + i][y0][z0];
						string2 += values[max - i][y0][z0];
					}
				} else {
					for (int i = 0; i <= max - min; i++) {
						string1 += values[min + i][y0][z0 + (z1 - z0)
								* (min + i - x0) / (x1 - x0)];
						string2 += values[max - i][y0][z0 + (z1 - z0)
								* (min - i - x0) / (x1 - x0)];
					}
				}
			} else {
				if (z0 == z1) {
					for (int i = 0; i <= max - min; i++) {
						string1 += values[min + i][y0 + (y1 - y0)
								* (min + i - x0) / (x1 - x0)][z0];
						string2 += values[max - i][y0 + (y1 - y0)
								* (min - i - x0) / (x1 - x0)][z0];
					}
				} else {
					for (int i = 0; i <= max - min; i++) {
						string1 += values[min + i][y0 + (y1 - y0)
								* (min + i - x0) / (x1 - x0)][z0 + (z1 - z0)
								* (min + i - x0) / (x1 - x0)];
						string2 += values[max - i][y0 + (y1 - y0)
								* (min - i - x0) / (x1 - x0)][z0 + (z1 - z0)
								* (min - i - x0) / (x1 - x0)];
					}
				}
			}
		}
		return string1.contains(str) || string2.contains(str);

	}
}
