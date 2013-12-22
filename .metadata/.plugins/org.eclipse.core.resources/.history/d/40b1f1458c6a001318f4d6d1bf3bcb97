/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;

/**
 * @author luongnv89
 * 
 */
public class CubeTest {

	Cube cube;
	Cube cubeToSmall;
	Cube latticeInvalid;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cube = new Cube("cube5.txt");
		latticeInvalid = new Cube("cube5_lattice_invalid.txt");
		cubeToSmall = new Cube("cube3.txt");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCubeInt() throws Exception {
		Cube newCube = new Cube(5);
		newCube.showValues();
		assertTrue(newCube.getSize() == 5);
		System.out.println("Create new dictionary...");
		Cube newCube500 = new Cube(400);
		System.out.println("Created a new Cube. Saving to the file...");
		assertTrue(newCube500.invariant());
		newCube500.saveToFile("cube400.txt");
		System.out.println("Finished!");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testCubeIntSizeToSmall() throws Exception {
		Cube newCube = new Cube(3);
		newCube.showValues();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testCubeIntSizeTooBig() throws Exception {
		Cube newCube = new Cube(1001);
		newCube.showValues();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCubeString() throws Exception {
		Cube newCube = new Cube("cube6.txt");
		newCube.showValues();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(cube.getSize() == 5);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getValues()}.
	 */
	@Test
	public void testGetValues() {
		assertNotNull(cube.getValues());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(cube.invariant());
		assertFalse(cubeToSmall.invariant());
		assertFalse(latticeInvalid.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#showValues()}.
	 */
	@Test
	public void testShowValues() {
		cube.showValues();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#saveToFile(java.lang.String)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveToFile() throws Exception {
		Cube newCube = new Cube(6);
		newCube.saveToFile("cube6.txt");
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Cube#getString(int, int, int, int, int, int, boolean)}
	 * .
	 */
	@Test
	public void testGetString() {

		String str = cube.getString(0, 0, 0, 0, 0, 0);
		assertTrue(str.equals("A"));
		// OYZ
		// ABCIA
		String str1 = cube.getString(0, 0, 0, 0, 0, 4);
		assertTrue(str1.equals("ABCIA") || str1.contains("AICBA"));

		// ADGDG
		String str3 = cube.getString(0, 0, 0, 0, 4, 0);
		assertTrue(str3.equals("ADGDG") || str3.equals("GDGDA"));

		// AEKME
		String str5 = cube.getString(0, 0, 0, 0, 4, 4);
		assertTrue(str5.equals("AEKME") || str5.equals("EMKEA"));

		// AJKEG
		String str7 = cube.getString(0, 0, 4, 0, 4, 0);
		assertTrue(str7.equals("AJKEG") || str7.equals("GEKJA"));

		// OXY
		// AADGG
		String str9 = cube.getString(0, 0, 0, 4, 0, 0);
		assertTrue(str9.equals("AADGG") || str9.equals("GGDAA"));

		// AGDGD
		String str11 = cube.getString(0, 0, 0, 4, 4, 0);
		assertTrue(str11.equals("AGDGD") || str11.equals("DGDGA"));

		// GADDG
		String str13 = cube.getString(4, 0, 0, 0, 4, 0);
		assertTrue(str13.equals("GADDG") || str13.contains("GDDAG"));

		// OXZ
		// ABFPE
		String str15 = cube.getString(0, 0, 0, 4, 0, 4);
		assertTrue(str15.equals("ABFPE") || str15.contains("EPFBA"));

		// AOFHG
		String str17 = cube.getString(0, 0, 4, 4, 0, 0);
		assertTrue(str17.equals("AOFHG") || str17.contains("GHFOA"));

		// OCDK
		// DHFPA
		String str19 = cube.getString(4, 4, 0, 0, 0, 4);
		assertTrue(str19.equals("DHFPA") || str19.contains("APFHD"));

		// AHFLI
		String str21 = cube.getString(4, 4, 4, 0, 0, 0);
		assertTrue(str21.equals("AHFLI") || str21.contains("ILFHA"));

		// ABFE
		// GEFIE
		String str23 = cube.getString(0, 4, 0, 4, 0, 4);
		assertTrue(str23.equals("GEFIE") || str23.contains("EIFEG"));

		// ERFBG
		String str25 = cube.getString(0, 4, 4, 4, 0, 0);
		assertTrue(str25.equals("ERFBG") || str25.contains("GBFRE"));
	}

}
