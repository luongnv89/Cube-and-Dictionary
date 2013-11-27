/**
 * 
 */
package louis.tests;

import louis.threads.SimpleThread;

import org.junit.Before;
import org.junit.Test;

/**
 * @author luongnv89
 * 
 */
public class SimpleThreadTest {

	SimpleThread mythread1;
	SimpleThread mythread2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mythread1 = new SimpleThread();
		mythread2 = new SimpleThread();
		System.out.println("Created 2 threads");

	}

	@Test
	public void test() {
		System.out.println("Starting the thread...");
		mythread1.start();
		mythread2.start();
		System.out.println("End of thread!");
	}

}
