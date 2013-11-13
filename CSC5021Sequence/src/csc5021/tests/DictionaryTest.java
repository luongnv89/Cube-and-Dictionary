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
		dictionary = new Dictionary(5,5);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(int)}.
	 * @throws Exception 
	 */
	@Test
	public void testDictionaryString() throws Exception {
		Dictionary newDictionary = new Dictionary("dictionary_3_5.txt");
		newDictionary.showContent();
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
	 * Test method for {@link csc5021.objects.Dictionary#getLength()}.
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
