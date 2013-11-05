/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import csc5021.utilities.Utilities;

/**
 * @author luongnv89
 * 
 */
public class UtilitiesTest {

	/**
	 * Test method for {@link csc5021.utilities.Utilities#getCubeSize(int)}.
	 */
	@Test
	public void testGetCubeSize() {
		assertTrue(Utilities.getCubeSize(8) == 2);
		assertTrue(Utilities.getCubeSize(27)==3);
		assertTrue(Utilities.getCubeSize(7) == -1);
	}

	/**
	 * Test method for {@link csc5021.utilities.Utilities#getRandomCharater()}.
	 */
	@Test
	public void testGetRandomCharater() {
		for (int i = 0; i < 100; i++)
			System.out.println(Utilities.getRandomCharater());
	}

}
