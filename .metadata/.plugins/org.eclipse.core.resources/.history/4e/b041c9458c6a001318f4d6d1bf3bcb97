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
	Dictionary dic5;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dic5 = new Dictionary("dic5.txt");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(int, int)}.
	 */
	@Test
	public void testDictionaryIntInt() {
		Dictionary newDic = new Dictionary(5, 10);
		assertEquals(newDic.getLength(), 5);
		assertEquals(newDic.getSize(), 10);
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#Dictionary(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testDictionaryStringInvalid() throws Exception {
		Dictionary dic4 = new Dictionary("dic5_invalid.txt");
		dic4.showContent();
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#Dictionary(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class) 
	public void testDictionaryStringInvalidLetter() throws Exception {
		Dictionary dic4 = new Dictionary("dic5_invalid_letter.txt");
		dic4.showContent(); 
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#Dictionary(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDictionaryString() throws Exception {
		Dictionary dic4 = new Dictionary("dic4.txt");
		dic4.showContent();
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getLength()}.
	 */
	@Test
	public void testGetLength() {
		assertTrue(dic5.getLength() == 5);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(dic5.getSize() == 21);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getWordByIndex(int)}.
	 */
	@Test
	public void testGetWordByIndex() {
		assertTrue(dic5.getWordByIndex(0).equals("ABCIA"));
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(dic5.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#showContent()}.
	 */
	@Test
	public void testShowContent() {
		dic5.showContent();
	}

	/**
	 * Test method for
	 * {@link csc5021.objects.Dictionary#saveToFile(java.lang.String)}.
	 */
	@Test
	public void testSaveToFile() {
		Dictionary dic6 = new Dictionary(6, 60);
		dic6.saveToFile("dic6.txt");
		dic6.showContent();
	}

}
