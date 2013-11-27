/**
 * 
 */
package louis.tests;

import louis.threads.SimpleRunable;

import org.junit.Before;
import org.junit.Test;

/**
 * @author luongnv89
 * 
 */
public class SimpleRunableTest {
	SimpleRunable myRunable;
	Thread myThread1;
	Thread myThread2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myRunable = new SimpleRunable();
		myThread1 = new Thread(myRunable);
		System.out.println("Created a thread 1");
		myThread2 = new Thread(myRunable);
		System.out.println("Created a thread 2");
	}

	@Test
	public void test() {
		myThread1.start();
		myThread2.start();
		System.out.println("Started thread...");
		System.out.println("End of thread");
	}

}
