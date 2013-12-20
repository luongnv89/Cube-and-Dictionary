/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import csc5021.abstracts.AssociatedAbstract;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 * 
 */
public class AssociatedAbstractTest {

	protected AssociatedAbstract program;
	protected Cube cube;
	protected Dictionary dic4;
	protected Dictionary dic4_ok;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		cube = new Cube("cube5.txt");
//		dic4_ok = new Dictionary("dic4_ok.txt");
//		dic4 = new Dictionary("dic4.txt");
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_word(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated() {
		assertFalse(program.associated(cube, dic4));
	}
	
	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_word(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_word() {
		assertFalse(program.associated_word(cube, "ABABA"));
		assertTrue(program.associated_word(cube, "ABCD"));
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_direction2(Cube, String)}
	 * .
	 */
	@Test
	public void testAssociated_direction2() {
		assertTrue(program.associated_direction2(cube, "GEF"));
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_direction1(Cube, String)}
	 * .
	 */
	@Test
	public void testAssociated_direction1() {
		assertTrue(program.associated_direction1(cube, "APF"));
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_directionOYZ(Cube, String)}
	 * .
	 */
	@Test
	public void testAssociated_directionOYZ() {
		assertTrue(program.associated_directionOYZ(cube, "GHK"));
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_directionOXZ(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_directionOXZ() {
		assertTrue(program.associated_directionOXZ(cube, "BBE"));
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_directionOXY(csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_directionOXY() {
		assertTrue(program.associated_directionOXY(cube, "DGD"));
	}

	/**
	 * Test method for
	 * {@link csc5021.abstracts.AssociatedAbstract#associated_line(int, int, int, int, int, int, csc5021.objects.Cube, java.lang.String)}
	 * .
	 */
	@Test
	public void testAssociated_line() {

		assertFalse(program.associated_line(0, 0, 0, 0, 0, 0, cube, "ABCDE"));
		// OYZ
		// ABCIA
		assertTrue(program.associated_line(0, 0, 0, 0, 0, 4, cube, "ABCIA"));

		// ADGDG
		assertTrue(program.associated_line(0, 0, 0, 0, 4, 0, cube, "GDGDA"));

		// AEKME
		assertTrue(program.associated_line(0, 0, 0, 0, 4, 4, cube, "EMKEA"));

		// AJKEG
		assertTrue(program.associated_line(0, 0, 4, 0, 4, 0, cube, "GEKJA"));

		// OXY
		// AADGG
		assertTrue(program.associated_line(0, 0, 0, 4, 0, 0, cube, "GGDAA"));

		// AGDGD
		assertTrue(program.associated_line(0, 0, 0, 4, 4, 0, cube, "DGDGA"));

		// GADDG
		assertTrue(program.associated_line(4, 0, 0, 0, 4, 0, cube, "GDDAG"));

		// OXZ
		// ABFPE
		assertTrue(program.associated_line(0, 0, 0, 4, 0, 4, cube, "EPFBA"));

		// AOFHG
		assertTrue(program.associated_line(0, 0, 4, 4, 0, 0, cube, "GHFOA"));

		// OCDK
		// DHFPA
		assertTrue(program.associated_line(4, 4, 0, 0, 0, 4, cube, "APFHD"));

		// AHFLI
		assertTrue(program.associated_line(4, 4, 4, 0, 0, 0, cube, "ILFHA"));

		// ABFE
		// GEFIE
		assertTrue(program.associated_line(0, 4, 0, 4, 0, 4, cube, "GEFIE"));

		// ERFBG
		assertTrue(program.associated_line(0, 4, 4, 4, 0, 0, cube, "ERFBG"));
	}

}
