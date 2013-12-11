/**
 * 
 */
package csc5021.mapreduce.objects;

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

	/**
	 * Maximum size of cube
	 */
	public static final int MAX_SIZE = 1000;
	/**
	 * Minimum size of cube
	 */
	public static final int MIN_SIZE = 4;
	/**
	 * Maximum number of different letters on a lattice of cube
	 */
	private static final int MAX_DIFF_LETTERS = 100;

	/**
	 * Size of lattice
	 */
	int size;
	/**
	 * Values of lattice
	 */
	String path;

	/**
	 * Constructor a Cube by size. The values of Cube is randomly
	 * 
	 * @param size
	 * @throws Exception
	 */
	public Cube(int size, String path) throws Exception {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new Exception("The size of cube is invalid: " + size
					+ "\nIt must be bigger than 3 and smaller than 1001");
		} else {
			this.size = size;
			this.path = path;
		}
	}

	/**
	 * Create a cube from text file
	 * 
	 * @param pathFile
	 * @throws Exception
	 */
	public Cube(String pathFile) throws Exception {
		this.path = pathFile;
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(pathFile));

		String line = br.readLine();
		if (line == null || line.length() < 3) {
			throw new Exception("The input file is invalid!");
		} else {
			this.size = line.length();
		}

	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
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
		//Check size of cube
		if (this.size < MIN_SIZE || this.size > MAX_SIZE) {
			System.out.println("The size of cube is invalid");
			return false;
		}
		
		//Check constrain of the number of letters in a lattice by the Ox, Oy, Oz direction
		// x = 0-> size-1
//		for (int i = 0; i < this.size; i++) {
//			int nbLetters = 0;
//			ArrayList<Character> listCharacter = new ArrayList<>();
//			// Check the number of letters of this lattice
//			for (int j = 0; j < this.size; j++) {
//				for (int k = 0; k < this.size; k++) {
//					if (!listCharacter.contains(values[i][j][k])) {
//						nbLetters++;
//						listCharacter.add(values[i][j][k]);
//					}
//				}
//			}
//			if (nbLetters < 2 || nbLetters > 100) {
//				System.out
//						.println("Invalid cube! There are " + nbLetters + " different letters in lattice of x : " + i);
//				return false;
//			}
//		}

		return true;
	}

	

//	/**
//	 * 
//	 * Get string is composed by the characters from the point (x0,y0,z0) to the
//	 * point (x1,y1,z1) of cube <br>
//	 * In this case, we assume that two points are in a line of cube
//	 * 
//	 * @param x0
//	 * @param y0
//	 * @param z0
//	 * @param x1
//	 * @param y1
//	 * @param z1
//	 * @return
//	 */
//	public String getString(int x0, int y0, int z0, int x1, int y1, int z1) {
//		if (x0 == x1 && y0 == y1 && z0 == z1)
//			return String.valueOf(values[x0][y0][z0]);
//		StringBuffer stringbf = new StringBuffer();
//		if (x0 == x1) {
//			if (y0 == y1) {
//				int max = z1 > z0 ? z1 : z0;
//				int min = max == z1 ? z0 : z1;
//
//				for (int i = 0; i <= max - min; i++) {
//					stringbf.append(values[x0][y0][min + i]);
//				}
//			} else if (z0 == z1) {
//				int max = y1 > y0 ? y1 : y0;
//				int min = y1 == max ? y0 : y1;
//
//				for (int i = 0; i <= max - min; i++) {
//					stringbf.append(values[x0][min + i][z0]);
//				}
//			} else {
//				int max = y1 > y0 ? y1 : y0;
//				int min = y1 == max ? y0 : y1;
//				for (int i = 0; i <= max - min; i++) {
//					stringbf.append(values[x0][min + i][z0 + (z1 - z0) * (min + i - y0) / (y1 - y0)]);
//				}
//			}
//		} else {
//			int max = x1 > x0 ? x1 : x0;
//			int min = x1 == max ? x0 : x1;
//			if (y0 == y1) {
//				if (z0 == z1) {
//					for (int i = 0; i <= max - min; i++) {
//						stringbf.append(values[min + i][y0][z0]);
//
//					}
//				} else {
//					for (int i = 0; i <= max - min; i++) {
//						stringbf.append(values[min + i][y0][z0 + (z1 - z0) * (min + i - x0) / (x1 - x0)]);
//
//					}
//				}
//			} else {
//				if (z0 == z1) {
//					for (int i = 0; i <= max - min; i++) {
//						stringbf.append(values[min + i][y0 + (y1 - y0) * (min + i - x0) / (x1 - x0)][z0]);
//
//					}
//				} else {
//					for (int i = 0; i <= max - min; i++) {
//						stringbf.append(values[min + i][y0 + (y1 - y0) * (min + i - x0) / (x1 - x0)][z0 + (z1 - z0)
//								* (min + i - x0) / (x1 - x0)]);
//					}
//				}
//			}
//		}
//		// System.out.println(stringbf.toString());
//		return stringbf.toString();
//	}

}
