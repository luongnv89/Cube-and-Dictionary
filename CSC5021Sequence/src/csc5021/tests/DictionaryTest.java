/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 *
 */
public class DictionaryTest {
	Dictionary dictionary;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dictionary = new Dictionary(5);
		dictionary.initRandomly();
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(int)}.
	 */
	@Test
	public void testDictionary() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#initRandomly()}.
	 */
	@Test
	public void testInitRandomly() {
		dictionary.initRandomly();
		dictionary.showContent();
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#modifyWord(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testModifyWord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#addNewWord(java.lang.String)}.
	 */
	@Test
	public void testAddNewWord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#findWord(java.lang.String)}.
	 */
	@Test
	public void testFindWord() {
		System.out.println(dictionary.findWord("ABCDE"));
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getLengthOfWord()}.
	 */
	@Test
	public void testGetLengthOfWord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getListWord()}.
	 */
	@Test
	public void testGetListWord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#invariant()}.
	 */
	@Test
	public void testInvariant() {
		fail("Not yet implemented");
	}

}
