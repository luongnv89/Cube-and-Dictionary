/**
 * 
 */
package csc5021.tests;

import org.junit.Before;

import csc5021.solutions.Sequential;

/**
 * Test for class {@link Sequential}
 * 
 * @author luongnv89
 * 
 */
public class SequentialTest extends SolutionAbstractsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		solution_associated = new Sequential(cube, dic_associated);
		solution_no_associated = new Sequential(cubePath, dicNoAssociatedPath);
		solution_dic_invalid = new Sequential(cube, dic_invalid);
		solution_dic_too_long = new Sequential(cube, dic_too_long);
		solution_cube_invalid = new Sequential(cube_invalid, dic_associated);
	}
}
