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
	SimpleThread mythread3;
	SimpleThread mythread4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mythread1 = new SimpleThread();
		mythread2 = new SimpleThread();
		mythread3 = new SimpleThread();
		mythread4 = new SimpleThread();
		System.out.println("Created 2 threads");

	}

	@Test
	public void testJoin() {
		System.out.println("Starting the thread...");
		mythread1.start();
		try {
			mythread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mythread2.start();
		try {
			mythread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of thread!");
	}

	@Test
	public void test() {
		System.out.println("Starting the thread...");
		mythread3.start();
		mythread4.start();
		System.out.println("End of thread!");
	}

}
