/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.program.Sequences;

/**
 * @author luongnv89
 * 
 */
public class SequencesTest {
	Sequences seq;
	Cube cube;
	Dictionary dic4;
	Dictionary dic4_ok;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		seq = new Sequences();
		cube = new Cube("cube5.txt");
		dic4_ok = new Dictionary("dic4_ok.txt");
		dic4 = new Dictionary("dic4.txt");
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated(csc5021.objects.Cube, csc5021.objects.Dictionary)}
	 * .
	 */
	@Test
	public void testAssociated() {
		assertTrue(seq.associated(cube, dic4_ok));
		assertFalse(seq.associated(cube, dic4));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_word(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_word() {
		assertFalse(seq.associated_word(cube, "ABABA"));
		assertTrue(seq.associated_word(cube, "ABCD"));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_direction2(Cube, String)} .
	 */
	@Test
	public void testAssociated_direction2() {
		assertTrue(seq.associated_direction2(cube, "GEF"));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_direction1(Cube, String)} .
	 */
	@Test
	public void testAssociated_direction1() {
		assertTrue(seq.associated_direction1(cube, "APF"));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_directionOYZ(Cube, String)} .
	 */
	@Test
	public void testAssociated_directionOYZ() { 
		assertTrue(seq.associated_directionOYZ(cube, "GHK"));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_directionOXZ(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_directionOXZ() {
		assertTrue(seq.associated_directionOXZ(cube, "BBE"));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_directionOXY(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_directionOXY() {
		assertTrue(seq.associated_directionOXY(cube, "DGD"));
	}

	/**
	 * Test method for
	 * {@link csc5021.program.Sequences#associated_line(int, int, int, int, int, int, csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_line() {

		assertFalse(seq.associated_line(0, 0, 0, 0, 0, 0, cube, "ABCDE"));
		// OYZ
		// ABCIA
		assertTrue(seq.associated_line(0, 0, 0, 0, 0, 4, cube, "ABCIA"));

		// ADGDG
		assertTrue(seq.associated_line(0, 0, 0, 0, 4, 0, cube, "GDGDA"));

		// AEKME
		assertTrue(seq.associated_line(0, 0, 0, 0, 4, 4, cube, "EMKEA"));

		// AJKEG
		assertTrue(seq.associated_line(0, 0, 4, 0, 4, 0, cube, "GEKJA"));

		// OXY
		// AADGG
		assertTrue(seq.associated_line(0, 0, 0, 4, 0, 0, cube, "GGDAA"));

		// AGDGD
		assertTrue(seq.associated_line(0, 0, 0, 4, 4, 0, cube, "DGDGA"));

		// GADDG
		assertTrue(seq.associated_line(4, 0, 0, 0, 4, 0, cube, "GDDAG"));

		// OXZ
		// ABFPE
		assertTrue(seq.associated_line(0, 0, 0, 4, 0, 4, cube, "EPFBA"));

		// AOFHG
		assertTrue(seq.associated_line(0, 0, 4, 4, 0, 0, cube, "GHFOA"));

		// OCDK
		// DHFPA
		assertTrue(seq.associated_line(4, 4, 0, 0, 0, 4, cube, "APFHD"));

		// AHFLI
		assertTrue(seq.associated_line(4, 4, 4, 0, 0, 0, cube, "ILFHA"));

		// ABFE
		// GEFIE
		assertTrue(seq.associated_line(0, 4, 0, 4, 0, 4, cube, "GEFIE"));

		// ERFBG
		assertTrue(seq.associated_line(0, 4, 4, 4, 0, 0, cube, "ERFBG"));
	}
}
