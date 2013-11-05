/**
 * 
 */
package csc5021.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc5021.objects.Lattice;

/**
 * @author luongnv89
 *
 */
public class LatticeTest {

	Lattice lattice;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lattice = new Lattice(3);
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#Lattice(int)}.
	 */
	@Test
	public void testLatticeInt() {
		Lattice latticeInt = new Lattice(4);
		latticeInt.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#Lattice(char[][][])}.
	 */
	@Test
	public void testLatticeCharArrayArrayArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#Lattice(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testLatticeString() throws Exception {
		Lattice stringLattice = new Lattice("ABCDEFGHKABCDEFGHKABCDEFGHK");
		stringLattice.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#Lattice(csc5021.objects.Lattice)}.
	 */
	@Test
	public void testLatticeLattice() {
		Lattice latticeCoppy = new Lattice(lattice);
		lattice.showLatice();
		System.out.println("Coppy:");
		latticeCoppy.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(lattice.getSize()==3);
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#getValues()}.
	 */
	@Test
	public void testGetValues() {
		assertTrue(lattice.getValues().length>0);
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(lattice.invariant());
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#showLatice()}.
	 */
	@Test
	public void testShowLatice() {
		lattice.showLatice();
	}

	/**
	 * Test method for {@link csc5021.objects.Lattice#initRandomly()}.
	 */
	@Test
	public void testInitialRandomly() {
		fail("Not yet implemented");
	}

}
