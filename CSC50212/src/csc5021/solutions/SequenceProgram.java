/**
 * 
 */
package csc5021.solutions;

import csc5021.interfaces.HasInvariant;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 * 
 */
public class SequenceProgram implements HasInvariant {
	Cube cube;
	Dictionary dic;

	/**
	 * @param cube
	 * @param dic
	 */
	public SequenceProgram(Cube cube, Dictionary dic) {
		this.cube = cube;
		this.dic = dic;
	}

	public boolean associated() {
		if (!this.invariant()) {
			System.out.println("The initial of program is not valid!");
			return false;
		} else {
			for (int word_index = 0; word_index < dic.getDic_size(); word_index++) {
				if (!associated_word(cube, dic.getWord_list().get(word_index))) {
					System.out.println("Cannot find the word: " + dic.getWord_list().get(word_index)
							+ " in cube!\n NO ASSOCIATED!");
					return false;
				}
			}
			System.out.println("ASSOCIATED!!!");
			return true;
		}
	}

	private boolean associated_word(Cube cube2, String word) {
		char first_char = word.charAt(0);
		for (int z = 0; z < cube2.getSize(); z++) {
			for (int y = 0; y < cube2.getSize(); y++) {
				for (int x = 0; x < cube2.getSize(); x++) {
					if (first_char == cube2.getContent()[x][y][z]) {
						if (associated_point(cube2, word, x, y, z))
							return true;
					}
				}
			}
		}

		return false;
	}

	private boolean associated_point(Cube cube2, String word, int x, int y, int z) {
		int delta = word.length();
		char[] array = word.toCharArray();
		for (int z0 = z - delta; z0 <= z + delta; z0 += delta) {
			for (int y0 = y - delta; y0 <= y + delta; y0 += delta) {
				for (int x0 = x - delta; x0 <= x + delta; x0 += delta) {
					if (cube2.inside(x0, y0, z0) && !(x == x0 && y == y0 && z == z0)) {
						
						int rx = 0;
						if (x == x0)
							rx = 0;
						else
							rx = (x0 - x) / Math.abs(x0 - x);

						int ry = 0;
						if (y == y0)
							ry = 0;
						else
							ry = (y0 - y) / Math.abs(y0 - y);

						int rz = 0;
						if (z == z0)
							rz = 0;
						else
							rz = (z0 - z) / Math.abs(z0 - z);

						for (int i = 0; i < array.length; i++) {
							if (array[i] == cube2.getContent()[x + rx * i][y + ry * i][z + rz * i])
								return true;
						}

					}
				}
			}
		}
		return false;
	}

	/**
	 * @param cube
	 *            the cube to set
	 */
	public void setCube(Cube cube) {
		this.cube = cube;
	}

	/**
	 * @param dic
	 *            the dic to set
	 */
	public void setDic(Dictionary dic) {
		this.dic = dic;
	}

	/**
	 * @return the cube
	 */
	public Cube getCube() {
		return cube;
	}

	/**
	 * @return the dic
	 */
	public Dictionary getDic() {
		return dic;
	}

	@Override
	public boolean invariant() {
		if (cube.getSize() < dic.getWord_length()) {
			System.out
					.println("The size of cube is smaller than the word_length of dictionary. The program cannot run!");
			return false;
		}

		return cube.invariant() && dic.invariant();
	}

}
