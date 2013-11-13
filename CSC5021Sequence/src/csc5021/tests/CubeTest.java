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

	Cube lattice;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lattice = new Cube(3);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#Lattice(int)}.
	 */
	@Test
	public void testLatticeInt() {
		Cube latticeInt = new Cube(4);
		latticeInt.showLatice();
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
		stringLattice.showLatice();
	}


	/**
	 * Test method for {@link csc5021.objects.Cube#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(lattice.getSize()==3);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#getValues()}.
	 */
	@Test
	public void testGetValues() {
		assertTrue(lattice.getValues().length>0);
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(lattice.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#showLatice()}.
	 */
	@Test
	public void testShowLatice() {
		lattice.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Cube#initRandomly()}.
	 */
	@Test
	public void testInitialRandomly() {
		long startTime = System.currentTimeMillis();
		Cube myLattice = new Cube(1000);
		long totalTime = System.currentTimeMillis() - startTime;
		myLattice.showLatice();
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

}
