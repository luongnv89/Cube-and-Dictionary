/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import csc5021.program.SequenceAssociated;

/**
 * @author luongnv89
 * 
 */
public class SequencesTest extends MethodClassTest {
	/**
	 * Test method for
	 * {@link csc5021.program.SequenceAssociated#associated(csc5021.objects.Cube, csc5021.objects.Dictionary)}
	 * .
	 */
	@Test
	public void testAssociated() {
		assertTrue(((SequenceAssociated) program).associated(cube, dic4_ok));
		assertFalse(((SequenceAssociated) program).associated(cube, dic4));
	}

}
