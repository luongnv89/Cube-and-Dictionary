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
	 * @return <br> false if the size of cube is invalid
	 * <br> false if there are some lattice has less than 2 different letters or more than 100 different letters
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
			word_associated = associated_directionOXY1(string);
		if (!word_associated)
			word_associated = associated_directionOXY2(string);
		if (!word_associated)
			word_associated = associated_directionOXZ1(string);
		if (!word_associated)
			word_associated = associated_directionOXZ2(string);
		if (!word_associated)
			word_associated = associated_directionOYZ1(string);
		if (!word_associated)
			word_associated = associated_directionOYZ2(string);
		System.out.println("Word: " + string + " associated? "
				+ String.valueOf(word_associated));
		return word_associated;
	}

	private boolean associated_directionOYZ2(String string) {
		for (int subYZ = -(this.size - string.length()); subYZ < this.size
				- string.length(); subYZ++) {
			// From x = 0 to x = size of cube
			for (int i = 0; i < this.size; i++) {
				String string_lattice1 = getStringOYZ2(i, subYZ,
						string.length(), true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOYZ2(i, subYZ,
							string.length(), false);
					if (string_lattice2.contains(string))
						return true;
				}
			}

		}
		return false;
	}

	private String getStringOYZ2(int x, int subYZ, int length, boolean b) {
		String str = "";
		// y>z
		if (subYZ > 0) {
			if (b) {
				for (int y = subYZ; y < this.size; y++) {
					str += this.values[x][y][y - subYZ];
				}
			} else {
				for (int y = this.size - 1; y >= subYZ; y--) {
					str += this.values[x][y][y - subYZ];
				}
			}
		}
		// y<z
		else {
			if (b) {
				for (int y = 0; y < this.size + subYZ; y++) {
					str += this.values[x][y][y - subYZ];
				}
			} else {
				for (int y = this.size + subYZ - 1; y >= 0; y--) {
					str += this.values[x][y][y - subYZ];
				}
			}
		}
		return str;
	}

	private boolean associated_directionOYZ1(String string) {
		for (int sumOYZ = string.length(); sumOYZ < 2 * this.size
				- string.length(); sumOYZ++) {
			// From x = 0 to x = size of cube
			for (int i = 0; i < this.size; i++) {
				String string_lattice1 = getStringOYZ1(i, sumOYZ,
						string.length(), true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOYZ1(i, sumOYZ,
							string.length(), false);
					if (string_lattice2.contains(string))
						return true;
				}
			}
		}
		return false;
	}

	private String getStringOYZ1(int i, int sumOYZ, int length, boolean b) {
		String str = "";
		if (sumOYZ < this.size) {
			if (b) {
				// from y to z
				for (int y = sumOYZ; y >= 0; y--) {
					str += this.values[i][y][sumOYZ - y];
				}
			} else {
				// from z to y
				for (int y = 0; y <= sumOYZ; y++) {
					str += this.values[i][y][sumOYZ - y];
				}
			}
		} else {
			if (b) {
				// from y to z
				for (int y = sumOYZ - this.size + 1; y < this.size; y++) {
					str += this.values[i][y][sumOYZ - y];
				}
			} else {
				// from z to y
				for (int y = this.size - 1; y >= sumOYZ - this.size + 1; y--) {
					str += this.values[i][y][sumOYZ - y];
				}
			}
		}
		return str;
	}

	private boolean associated_directionOXZ2(String string) {
		for (int subOZ2 = -(this.size - string.length()); subOZ2 < this.size
				- string.length(); subOZ2++) {

			// From y = 0 to y = size of cube
			for (int i = 0; i < this.size; i++) {
				String string_lattice1 = getStringOXZ2(i, subOZ2,
						string.length(), true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOXZ2(i, subOZ2,
							string.length(), false);
					if (string_lattice2.contains(string))
						return true;
				}
			}

		}
		return false;
	}

	private String getStringOXZ2(int y, int subOZ2, int length, boolean b) {
		String str = "";
		// x>y
		if (subOZ2 > 0) {
			if (b) {
				for (int x = subOZ2; x < this.size; x++) {
					str += this.values[x][y][x - subOZ2];
				}
			} else {
				for (int x = this.size - 1; x >= subOZ2; x--) {
					str += this.values[x][y][x - subOZ2];
				}
			}
		}
		// x<z
		else {
			if (b) {
				for (int x = 0; x < this.size + subOZ2; x++) {
					str += this.values[x][y][x - subOZ2];
				}
			} else {
				for (int x = this.size + subOZ2 - 1; x >= 0; x--) {
					str += this.values[x][y][x - subOZ2];
				}
			}
		}
		return str;
	}

	private boolean associated_directionOXZ1(String string) {
		for (int sumOXZ = string.length(); sumOXZ < 2 * this.size
				- string.length(); sumOXZ++) {
			// From y = 0 to y = size of cube
			for (int i = 0; i < this.size; i++) {
				String string_lattice1 = getStringOXZ1(i, sumOXZ,
						string.length(), true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOXZ1(i, sumOXZ,
							string.length(), false);
					if (string_lattice2.contains(string))
						return true;
				}
			}
		}
		return false;
	}

	private String getStringOXZ1(int i, int sumOXZ, int length, boolean b) {
		String str = "";
		if (sumOXZ < this.size) {
			if (b) {
				// from x to z
				for (int x = sumOXZ; x >= 0; x--) {
					str += this.values[x][i][sumOXZ - x];
				}
			} else {
				// from z to x
				for (int x = 0; x <= sumOXZ; x++) {
					str += this.values[x][i][sumOXZ - x];
				}
			}
		} else {
			if (b) {
				// from x to z
				for (int x = sumOXZ - this.size + 1; x < this.size; x++) {
					str += this.values[x][i][sumOXZ - x];
				}
			} else {
				// from z to x
				for (int x = this.size - 1; x >= sumOXZ - this.size + 1; x--) {
					str += this.values[x][i][sumOXZ - x];
				}
			}
		}
		return str;
	}

	private boolean associated_directionOXY2(String string) {
		for (int subXY = -(this.size - string.length()); subXY < this.size
				- string.length(); subXY++) {

			// From z = 0 to z = size of cube
			for (int i = 0; i < this.size; i++) {
				String string_lattice1 = getStringOXY2(i, subXY,
						string.length(), true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOXY2(i, subXY,
							string.length(), false);
					if (string_lattice2.contains(string))
						return true;
				}
			}

		}
		return false;
	}

	private String getStringOXY2(int z, int subXY, int length, boolean b) {
		String str = "";
		// x>y
		if (subXY > 0) {
			if (b) {
				for (int x = subXY; x < this.size; x++) {
					str += this.values[x][x - subXY][z];
				}
			} else {
				for (int x = this.size - 1; x >= subXY; x--) {
					str += this.values[x][x - subXY][z];
				}
			}
		}
		// x<y
		else {
			if (b) {
				for (int x = 0; x < this.size + subXY; x++) {
					str += this.values[x][x - subXY][z];
				}
			} else {
				for (int x = this.size + subXY - 1; x >= 0; x--) {
					str += this.values[x][x - subXY][z];
				}
			}
		}
		return str;
	}

	private boolean associated_directionOXY1(String string) {
		for (int sumXY = string.length(); sumXY < 2 * this.size
				- string.length(); sumXY++) {
			// From z = 0 to z = size of cube
			for (int i = 0; i < this.size; i++) {
				String string_lattice1 = getStringOXY1(i, sumXY,
						string.length(), true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOXY1(i, sumXY,
							string.length(), false);
					if (string_lattice2.contains(string))
						return true;
				}
			}
		}
		return false;
	}

	private String getStringOXY1(int i, int sumXY, int length, boolean direction) {
		String str = "";
		if (sumXY < this.size) {
			if (direction) {
				// from x to y
				for (int x = sumXY; x >= 0; x--) {
					str += this.values[x][sumXY - x][i];
				}
			} else {
				// /from y to x
				// from x to y
				for (int x = 0; x <= sumXY; x++) {
					str += this.values[x][sumXY - x][i];
				}
			}
		} else {
			if (direction) {
				// from x to y
				for (int x = sumXY - this.size + 1; x < this.size; x++) {
					str += this.values[x][sumXY - x][i];
				}
			} else {
				// /from y to x
				// from x to y
				for (int x = this.size - 1; x >= sumXY - this.size + 1; x--) {
					str += this.values[x][sumXY - x][i];
				}
			}
		}
		return str;

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
			// x from 0-> size of cube
			for (int x = 0; x < this.size; x++) {
				String string_lattice1 = getStringOZ(x, z, true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOZ(x, z, false);
					if (string_lattice2.contains(string))
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get the string of cube which in the line has the equation is: <br>
	 * x = param x <br>
	 * z = param z
	 * 
	 * @param x
	 * @param z
	 * @param direction
	 *            the direction to compose the string
	 * @return
	 */
	private String getStringOZ(int x, int z, boolean direction) {
		String str = "";
		if (direction) {
			for (int y = 0; y < this.size; y++) {
				str += this.values[x][y][z];
			}
		} else {
			for (int y = this.size - 1; y >= 0; y--) {
				str += this.values[x][y][z];
			}
		}
		return str;
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
			// z from 0-> size of cube
			for (int z = 0; z < this.size; z++) {
				String string_lattice1 = getStringOY(y, z, true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOY(y, z, false);
					if (string_lattice2.contains(string))
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get the string of cube which in the line has the equation is: <br>
	 * y = param y <br>
	 * z = param z
	 * 
	 * @param y
	 * @param z
	 * @param direction
	 *            the direction to compose the string
	 * @return
	 */
	private String getStringOY(int y, int z, boolean direction) {
		String str = "";
		if (direction) {
			for (int x = 0; x < this.size; x++) {
				str += this.values[x][y][z];
			}
		} else {
			for (int x = this.size - 1; x >= 0; x--) {
				str += this.values[x][y][z];
			}
		}
		return str;
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
			// y from 0> size of cube
			for (int y = 0; y < this.size; y++) {
				String string_lattice1 = getStringOX(x, y, true);
				if (string_lattice1.contains(string))
					return true;
				else {
					String string_lattice2 = getStringOX(x, y, false);
					if (string_lattice2.contains(string))
						return true;
				}

			}
		}
		return false;
	}

	/**
	 * Get the string of cube which in the line has the equation is: <br>
	 * x = param x <br>
	 * y = param y
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 *            the direction to compose the string
	 * @return
	 */
	private String getStringOX(int x, int y, boolean direction) {
		String str = "";
		if (direction) {
			for (int z = 0; z < this.size; z++) {
				str += this.values[x][y][z];
			}
		} else {
			for (int z = this.size - 1; z >= 0; z--) {
				str += this.values[x][y][z];
			}
		}
		return str;
	}

}
