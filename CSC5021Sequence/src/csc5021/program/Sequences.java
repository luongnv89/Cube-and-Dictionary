/**
 * 
 */
package csc5021.program;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.utilities.Utilities;

/**
 * @author luongnv89
 * 
 */
public class Sequences {

	public boolean associated(Cube cube, Dictionary dic) {
		if (dic.getLength() > cube.getSize()) {
			System.out
					.println("The cube is not associated with the dictionary!\nThe size of cube and the length of word of dictionary are not the same");
			return false;
		} else {
			for (int i = 0; i < dic.getSize(); i++) {
				if (!associated_word(cube, dic.getWordByIndex(i))) {
					System.out
							.println("The cube is not associated with the dictionary!\nThere is a word not associated: "
									+ dic.getWordByIndex(i));
					return false;
				}
			}
		}
		System.out.println("The cube is associated with the dictionary!");
		return true;
	}

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
			word_associated = associated_plane1(cube, word);
		// ABFE
		if (!word_associated)
			word_associated = associated_plane2(cube, word);
		System.out.println("Word: " + word + " associated? " + String.valueOf(word_associated));
		return word_associated;
	}

	public boolean associated_plane2(Cube cube, String word) {
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

	public boolean associated_plane2(int i, int j, int k, int l, int m, int n, Cube cube, String word) {
		if (associated_AF(i, j, k, l, m, n, cube, word))
			return true;
		if (associated_BE(i, j, k, l, m, n, cube, word))
			return true;
		return false;
	}

	public boolean associated_AF(int x0, int y0, int z0, int x1, int y1, int z1, Cube cube, String word) {
		int deltaX = Math.abs(x1 - x0);

		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {

			if (associated_line(x0, y0, cube.getSize() - 1 - deltaZ, x0 + deltaZ, y0 - deltaZ, cube.getSize() - 1,
					cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x1 - deltaZ, y1 + deltaZ, 0, x1, y1, deltaZ, cube, word))
					return true;
			}
		}

		for (int z = deltaX; z < cube.getSize(); z++) {

			if (associated_line(x0, y0, z - deltaX, x1, y1, z, cube, word))
				return true;
		}
		return false;
	}

	public boolean associated_BE(int x0, int y0, int z0, int x1, int y1, int z1, Cube cube, String word) {
		int deltaX = Math.abs(x1 - x0);

		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {

			if (associated_line(x0, y0, deltaZ, x0 + deltaZ, y0 - deltaZ, 0, cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x1 - deltaZ, y1 + deltaZ, cube.getSize() - 1, x1, y1, cube.getSize() - 1 - deltaZ,
						cube, word))
					return true;
			}
		}

		for (int z = deltaX; z < cube.getSize(); z++) {

			if (associated_line(x0, y0, z, x1, y1, z - deltaX, cube, word))
				return true;
		}

		return false;
	}

	public boolean associated_plane1(Cube cube, String word) {
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

	public boolean associated_plane1(int i, int j, int k, int deltaXY, Cube cube, String word) {
		if (associated_CK(i, j, k, deltaXY, cube, word))
			return true;
		if (associated_OD(i, j, k, deltaXY, cube, word))
			return true;
		return false;
	}

	public boolean associated_OD(int x0, int y0, int x1, int y1, Cube cube, String word) {
		int deltaX = Math.abs(x1 - x0);
		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {

			if (associated_line(x1 - deltaZ, y1 - deltaZ, 0, x1, y1, deltaZ, cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x0, y0, cube.getSize() - 1 - deltaZ, x0 + deltaZ, y0 + deltaZ, cube.getSize() - 1,
						cube, word))
					return true;
			}
		}

		for (int z1 = deltaX; z1 < cube.getSize(); z1++) {

			if (associated_line(x0, y0, z1 - deltaX, x1, y1, z1, cube, word))
				return true;
		}

		return false;
	}

	public boolean associated_CK(int x0, int y0, int x1, int y1, Cube cube, String word) {
		int deltaX = Math.abs(x1 - x0);
		for (int deltaZ = word.length() - 1; deltaZ < deltaX; deltaZ++) {

			if (associated_line(x0, y0, deltaZ, x0 + deltaZ, y0 + deltaZ, 0, cube, word))
				return true;
			if (deltaZ < deltaX - 1) {
				if (associated_line(x1 - deltaZ, y1 - deltaZ, cube.getSize() - 1, x1, y1, cube.getSize() - 1 - deltaZ,
						cube, word))
					return true;
			}
		}

		for (int z0 = deltaX; z0 < cube.getSize(); z0++) {

			if (associated_line(x0, y0, z0, x1, y1, z0 - deltaX, cube, word))
				return true;
		}
		return false;
	}

	public boolean associated_directionOYZ(Cube cube, String word) {
		// x from 0-> size of cube
		for (int x = 0; x < cube.getSize(); x++) {
			// The plan is parallel with Oyz

			// The line in plane which is parallel with Oz
			// y from 0> size of cube
			for (int y = 0; y < cube.getSize(); y++) {
				// System.out.println(getString(x, y, 0, x, y, cube.getSize() -
				// 1,true));
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

	public boolean associated_directionOXZ(Cube cube, String word) {
		// y from 0-> size of cube
		for (int y = 0; y < cube.getSize(); y++) {
			// The plan is parallel with Oxz

			// The line in plane which is parallel with Ox
			// z from 0-> size of cube
			for (int z = 0; z < cube.getSize(); z++) {
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

	public boolean associated_directionOXY(Cube cube, String word) {
		// z from 0->cube.getSize() of cube
		for (int z = 0; z < cube.getSize(); z++) {
			// The plan is parallel with Oxy

			// The line in plane which is parallel with Oy
			// x from 0-> size of cube
			for (int x = 0; x < cube.getSize(); x++) {
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

	public boolean associated_line(int x0, int y0, int z0, int x1, int y1, int z1, Cube cube, String word) {
		if (x0 == x1 && y0 == y1 && z0 == z1)
			return false;
		String string1 = cube.getString(x0, y0, z0, x1, y1, z1);
		return string1.contains(word) || ((String) Utilities.revert(string1)).contains(word);
	}

}
