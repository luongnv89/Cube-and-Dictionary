/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import csc5021.utilities.Utilities;

/**
 * Test for class {@link Utilities}
 * @author luongnv89
 * 
 */
public class UtilitiesTest {

	/**
	 * Test method for {@link csc5021.utilities.Utilities#getRandomCharater()}.
	 */
	@Test
	public void testGetRandomCharater() {
		for (int i = 0; i < 10; i++) {
			char c = Utilities.getRandomCharater();
			System.out.println(c);
			assertTrue(Utilities.validCharacter(c));
		}
	}

	/**
	 * Test method for
	 * {@link csc5021.utilities.Utilities#validWord(java.lang.String)}.
	 */
	@Test
	public void testValidWord() {
		assertTrue(Utilities.validWord("ABCD"));
		assertFalse(Utilities.validWord("1ABCD"));
		assertFalse(Utilities.validWord("ABCDe"));
	}

	/**
	 * Test method for {@link csc5021.utilities.Utilities#validCharacter(char)}.
	 */
	@Test
	public void testValidCharacter() {
		assertFalse(Utilities.validCharacter('a'));
		assertTrue(Utilities.validCharacter('A'));
		assertFalse(Utilities.validCharacter('w'));
		assertTrue(Utilities.validCharacter('W'));
		assertTrue(Utilities.validCharacter('Z'));
		assertFalse(Utilities.validCharacter('z'));
		assertFalse(Utilities.validCharacter('1'));
	}

	/**
	 * Test method for {@link csc5021.utilities.Utilities#createNewWord(int)}.
	 */
	@Test
	public void testCreateNewWord() {
		for (int i = 0; i < 10; i++) {
			String w = Utilities.createNewWord(5);
			assertTrue(w.length() == 5);
			assertTrue(Utilities.validWord(w));
			System.out.println(w);
		}
	}

	/**
	 * Test method for
	 * {@link csc5021.utilities.Utilities#revert(java.lang.String)}.
	 */
	@Test
	public void testRevert() {
		String str = "ABCD";
		String rstr = "DCBA";
		assertTrue(rstr.equals(Utilities.revert(str)));
	}

	/**
	 * Test method for
	 * {@link csc5021.utilities.Utilities#recordTest(java.lang.String, int, int, int, boolean, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testRecordTest() {
		Utilities.recordTest("PAR", 10, 10, 10, false, "123", "recordTest_test.txt");
	}

	/**
	 * Test method for
	 * {@link csc5021.utilities.Utilities#invalidLattices(int, java.lang.String)}
	 * .
	 */
	@Test
	public void testInvalidLattices() {
		Utilities.invalidLattices(110, "cube_110_invalid_lattice");
	}

}
