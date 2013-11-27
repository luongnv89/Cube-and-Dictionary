/**
 * 
 */
package csc5021.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import csc5021.interfaces.HasInvariant;

/**
 * @author luongnv89
 * 
 */
public class Cube implements HasInvariant {
	int size;
	int[][][] content;

	/**
	 * @param size
	 */
	public Cube(int size) {
		this.size = size;
		content = new int[this.size][this.size][this.size];
		for (int z = 0; z < this.size; z++) {
			ArrayList<Integer> char_codes = new ArrayList<>();
			while (char_codes.size() < 2) {
				for (int y = 0; y < this.size; y++) {
					for (int x = 0; x < this.size; x++) {
						boolean stop = false;
						while (!stop) {
							Random random = new Random();
							int char_code = 21 + random.nextInt(126);
							if (!char_codes.contains(char_code)) {
								if (char_codes.size() < 100) {
									char_codes.add(char_code);
									content[x][y][z] = (char) char_code;
									stop = true;
								}
							} else {
								content[x][y][z] = (char) char_code;
								stop = true;
							}

						}
					}
				}
			}

		}
	}

	/**
	 * @throws Exception
	 * 
	 */
	public Cube(String path) throws Exception {
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(path));
			String sCurrentLine = br.readLine();
			if (sCurrentLine.length() < 4 || sCurrentLine.length() > 1000) {
				throw new Exception("The size of cube is invalid. Size: " + this.size);
			}
			this.size = sCurrentLine.length();
			content = new int[this.size][this.size][this.size];

			for (int z = 0; z < this.size; z++) {
				int y = 0;
				while (sCurrentLine != null && y < this.size) {
					char array[] = sCurrentLine.toCharArray();
					if (array.length != this.size)
						throw new Exception("The array size is invalid. Array size: " + array.length
								+ "\nSize of cube: " + this.size);
					for (int x = 0; x < array.length; x++) {
						content[x][y][z] = array[x];
					}
					y++;
				}
			}

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
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the content
	 */
	public int[][][] getContent() {
		return content;
	}

	@Override
	public boolean invariant() {
		if (this.size < 4 || this.size > 1000) {
			System.out.println("The size of cube is invalid: " + this.size);
			return false;
		}
		for (int z = 0; z < this.size; z++) {
			ArrayList<Integer> char_codes = new ArrayList<>();
			for (int y = 0; y < this.size; y++) {
				for (int x = 0; x < this.size; x++) {
					int char_code = (int) content[x][y][z];
					if (char_code < 21 || char_code > 126) {
						System.out.println("There is an invalid character: " + content[x][y][z]);
						return false;
					}
					if (!char_codes.contains(char_code)) {
						char_codes.add(char_code);
					}
				}
			}
			if (char_codes.size() < 2 || char_codes.size() > 100) {
				System.out.println("There is an invalid lattice in cube. The size of lattice number " + z + " is "
						+ char_codes.size());
				return false;
			}
		}
		return true;
	}

	public boolean inside(int x0, int y0, int z0) {
		return ((x0 >= 0) && (x0 < this.size)) && ((y0 >= 0) && (y0 < this.size)) && ((z0 >= 0) && (z0 < this.size));
	}

}
