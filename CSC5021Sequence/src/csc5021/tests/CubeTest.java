/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 * 
 */
public class CubeTest {

	Cube cube;
	Dictionary dic;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cube = new Cube("cube5.txt");
		dic = new Dictionary("dic5.txt");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(int)}.
	 */
	@Test
	public void testCubeInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Cube(java.lang.String)}.
	 */
	@Test
	public void testCubeString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getSize()}.
	 */
	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getValues()}.
	 */
	@Test
	public void testGetValues() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariant() {
		fail("Not yet implemented");
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
	 */
	@Test
	public void testSaveToFile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#initRandomly()}.
	 */
	@Test
	public void testInitRandomly() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Cube#associated(csc5021.objects.Dictionary)}.
	 */
	@Test
	public void testAssociated() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Cube#associated_word(java.lang.String)}.
	 */
	@Test
	public void testAssociated_word() {
		assertFalse(cube.associated_word("ABABA"));
		assertTrue(cube.associated_word("ABCD"));
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Cube#associated_line(int, int, int, int, int, int, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_line() {

		assertFalse(cube.associated_line(0, 0, 0, 0, 0, 0, "ABCDE"));
		// OYZ
		// ABCIA
		assertTrue(cube.associated_line(0, 0, 0, 0, 0, 4, "ABCIA"));

		// ADGDG
		assertTrue(cube.associated_line(0, 0, 0, 0, 4, 0, "GDGDA"));

		// AEKME
		assertTrue(cube.associated_line(0, 0, 0, 0, 4, 4, "EMKEA"));

		// AJKEG
		assertTrue(cube.associated_line(0, 0, 4, 0, 4, 0, "GEKJA"));

		// OXY
		// AADGG
		assertTrue(cube.associated_line(0, 0, 0, 4, 0, 0, "GGDAA"));

		// AGDGD
		assertTrue(cube.associated_line(0, 0, 0, 4, 4, 0, "DGDGA"));

		// GADDG
		assertTrue(cube.associated_line(4, 0, 0, 0, 4, 0, "GDDAG"));

		// OXZ
		// ABFPE
		assertTrue(cube.associated_line(0, 0, 0, 4, 0, 4, "EPFBA"));

		// AOFHG
		assertTrue(cube.associated_line(0, 0, 4, 4, 0, 0, "GHFOA"));

		// OCDK
		// DHFPA
		assertTrue(cube.associated_line(4, 4, 0, 0, 0, 4, "APFHD"));

		// AHFLI
		assertTrue(cube.associated_line(4, 4, 4, 0, 0, 0, "ILFHA"));

		// ABFE
		// GEFIE
		assertTrue(cube.associated_line(0, 4, 0, 4, 0, 4, "GEFIE"));

		// ERFBG
		assertTrue(cube.associated_line(0, 4, 4, 4, 0, 0, "ERFBG"));
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Cube#getString(int, int, int, int, int, int, boolean)}
	 * .
	 */
	@Test
	public void testGetString() {

		String str = cube.getString(0, 0, 0, 0, 0, 0, true);
		assertTrue(str.equals("A"));
		// OYZ
		// ABCIA
		String str1 = cube.getString(0, 0, 0, 0, 0, 4, true);
		assertTrue(str1.equals("ABCIA") || str1.contains("AICBA"));

		// ADGDG
		String str3 = cube.getString(0, 0, 0, 0, 4, 0, true);
		assertTrue(str3.equals("ADGDG") || str3.equals("GDGDA"));

		// AEKME
		String str5 = cube.getString(0, 0, 0, 0, 4, 4, true);
		assertTrue(str5.equals("AEKME") || str5.equals("EMKEA"));

		// AJKEG
		String str7 = cube.getString(0, 0, 4, 0, 4, 0, true);
		assertTrue(str7.equals("AJKEG") || str7.equals("GEKJA"));

		// OXY
		// AADGG
		String str9 = cube.getString(0, 0, 0, 4, 0, 0, true);
		assertTrue(str9.equals("AADGG") || str9.equals("GGDAA"));

		// AGDGD
		String str11 = cube.getString(0, 0, 0, 4, 4, 0, true);
		assertTrue(str11.equals("AGDGD") || str11.equals("DGDGA"));

		// GADDG
		String str13 = cube.getString(4, 0, 0, 0, 4, 0, true);
		assertTrue(str13.equals("GADDG") || str13.contains("GDDAG"));

		// OXZ
		// ABFPE
		String str15 = cube.getString(0, 0, 0, 4, 0, 4, true);
		assertTrue(str15.equals("ABFPE") || str15.contains("EPFBA"));

		// AOFHG
		String str17 = cube.getString(0, 0, 4, 4, 0, 0, true);
		assertTrue(str17.equals("AOFHG") || str17.contains("GHFOA"));

		// OCDK
		// DHFPA
		String str19 = cube.getString(4, 4, 0, 0, 0, 4, true);
		assertTrue(str19.equals("DHFPA") || str19.contains("APFHD"));

		// AHFLI
		String str21 = cube.getString(4, 4, 4, 0, 0, 0, true);
		assertTrue(str21.equals("AHFLI") || str21.contains("ILFHA"));

		// ABFE
		// GEFIE
		String str23 = cube.getString(0, 4, 0, 4, 0, 4, true);
		assertTrue(str23.equals("GEFIE") || str23.contains("EIFEG"));

		// ERFBG
		String str25 = cube.getString(0, 4, 4, 4, 0, 0, true);
		assertTrue(str25.equals("ERFBG") || str25.contains("GBFRE"));
	}

}
