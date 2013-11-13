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

	Dictionary dic1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dic1 = new Dictionary(10, 20);
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(int, int)}.
	 */
	@Test
	public void testDictionaryIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(java.util.ArrayList)}.
	 */
	@Test
	public void testDictionaryArrayListOfString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#Dictionary(java.lang.String)}.
	 */
	@Test
	public void testDictionaryString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getLength()}.
	 */
	@Test
	public void testGetLength() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getSize()}.
	 */
	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#getWordByIndex(int)}.
	 */
	@Test
	public void testGetWordByIndex() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#invariant()}.
	 */
	@Test
	public void testInvariant() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Dictionary#showContent()}.
	 */
	@Test
	public void testShowContent() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link csc5021.objects.Dictionary#saveToFile(String)}
	 */
	@Test
	public void testSaveToFile() {
		dic1.saveToFile("dic_"+String.valueOf(System.currentTimeMillis())+".txt");
	}
	

}
