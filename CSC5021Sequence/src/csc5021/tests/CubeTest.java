/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 *
 */
public class CubeTest {

	Cube cube100;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cube100 = new Cube(100);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(int)}.
	 * @throws Exception 
	 */
	@Test
	public void testLatticeInt() throws Exception {
		Cube latticeInt = new Cube(4);
		latticeInt.showValues();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(char[][][])}.
	 */
	@Test
	public void testLatticeCharArrayArrayArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testLatticeString() throws Exception {
		Cube stringLattice = new Cube("cube5.txt");
		stringLattice.showValues();
	}


	/**
	 * Test method for {@link csc5021.objects.Cube#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(cube100.getSize()==3);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getValues()}.
	 */
	@Test
	public void testGetValues() {
		assertTrue(cube100.getValues().length>0);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(cube100.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#showValues()}.
	 */
	@Test
	public void testShowLatice() {
		cube100.showValues();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#initRandomly()}.
	 * @throws Exception 
	 */
	@Test
	public void testInitialRandomly() throws Exception {
		long startTime = System.currentTimeMillis();
		Cube myLattice = new Cube(1000);
		long totalTime = System.currentTimeMillis() - startTime;
		myLattice.showValues();
		System.out.println(totalTime);
	}
	
	@Test
	public void testMaxMemory(){
		System.out.println(java.lang.Runtime.getRuntime().availableProcessors());
		System.out.println(java.lang.Runtime.getRuntime().totalMemory());
		System.out.println(java.lang.Runtime.getRuntime().maxMemory());
	}
	
	@Test
	public void testAssociated() throws Exception{
		Cube myCube = new Cube("cube5.txt");
		Dictionary myDic = new Dictionary("dictionary_3_5.txt");
		System.out.println(myCube.associated(myDic));
	}
	
	/**
	 * Test method for {@link csc5021.objects.Cube#saveToFile(String)}.
	 */
	@Test
	public void testSaveToFile() {
		cube100.saveToFile("cube_"+String.valueOf(System.currentTimeMillis())+".txt");
	}

}
