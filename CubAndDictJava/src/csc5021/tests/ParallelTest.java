/**
 * 
 */
package csc5021.tests;

import org.junit.Before;

import csc5021.solutions.Parallel;

/**
 * Test for class {@link Parallel}
 * 
 * @author luongnv89
 * 
 */
public class ParallelTest extends SolutionAbstractsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		solution_associated = new Parallel(cube, dic_associated);
		solution_no_associated = new Parallel(cubePath, dicNoAssociatedPath);
		solution_dic_invalid = new Parallel(cube, dic_invalid);
		solution_dic_too_long = new Parallel(cube, dic_too_long);
		solution_cube_invalid = new Parallel(cube_invalid, dic_associated);
	}

}
