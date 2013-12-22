/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;

/**
 * Test for class {@link Cube}
 * @author luongnv89
 * 
 */
public class CubeTest {
	Cube cubeTooSmall;
	Cube cubeValid;
	Cube cubeInvalidCharacter;
	Cube cubeInvalidLattice;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cubeValid = new Cube("cube_10");
		cubeInvalidLattice = new Cube("cube_110_invalid_lattice");
		cubeTooSmall = new Cube("cube_3_too_small");
		cubeInvalidCharacter = new Cube("cube_10_invalid_character");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testCubeIntExceptionTooSmall() throws Exception {
		Cube intCube = new Cube(2);
		assertTrue(intCube.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testCubeIntExceptionTooBig() throws Exception {
		Cube intCube = new Cube(10001);
		assertTrue(intCube.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCubeInt() throws Exception {
		Cube intCube = new Cube(4);
		assertTrue(intCube.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(java.lang.String)}.
	 */
	@Test
	public void testCubeString() {
		Cube stringCube = new Cube("cube_10");
		assertTrue(stringCube.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(cubeValid.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariantInvalidSize() {
		assertFalse(cubeTooSmall.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariantInvalidCharacter() {
		assertFalse(cubeInvalidCharacter.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariantInvalidLattice() {
		assertFalse(cubeInvalidLattice.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#saveToFile(java.lang.String)}
	 * .
	 */
	@Test
	public void testSaveToFile() {
		Cube cube = new Cube("cube_10");
		cube.saveToFile("cube_10_test_Save_to_file_" + System.currentTimeMillis());
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Cube#getString(int, int, int, int, int, int)}.
	 */
	@Test
	public void testGetString() {
		Cube cube110A = new Cube("cube_110_invalid_lattice");
		String str10 = "AAAAAAAAAA";

		assertTrue(cube110A.getString(0, 0, 0, 9, 0, 0).equals(str10));
		assertTrue(cube110A.getString(0, 0, 0, 0, 9, 0).equals(str10));
		assertTrue(cube110A.getString(0, 0, 0, 0, 0, 9).equals(str10));
		assertTrue(cube110A.getString(0, 0, 0, 9, 9, 0).equals(str10));
		assertTrue(cube110A.getString(0, 0, 0, 9, 0, 9).equals(str10));
		assertTrue(cube110A.getString(0, 0, 0, 0, 9, 9).equals(str10));
		assertTrue(cube110A.getString(0, 0, 0, 9, 9, 9).equals(str10));

		assertTrue(cube110A.getString(18, 0, 0, 9, 0, 0).equals(str10));
		assertTrue(cube110A.getString(0, 18, 0, 0, 9, 0).equals(str10));
		assertTrue(cube110A.getString(0, 0, 18, 0, 0, 9).equals(str10));
		assertTrue(cube110A.getString(18, 18, 0, 9, 9, 0).equals(str10));
		assertTrue(cube110A.getString(18, 0, 18, 9, 0, 9).equals(str10));
		assertTrue(cube110A.getString(0, 18, 18, 0, 9, 9).equals(str10));
		assertTrue(cube110A.getString(18, 18, 18, 9, 9, 9).equals(str10));
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(cubeValid.getSize() == 10);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getValues()}.
	 */
	@Test
	public void testGetValues() {
		char[][][] array = cubeValid.getValues();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					System.out.print(array[i][j][k]);
				}
				System.out.println();
			}
		}
	}
}
