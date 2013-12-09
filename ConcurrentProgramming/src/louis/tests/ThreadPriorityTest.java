/**
 * 
 */
package louis.tests;

import louis.threads.ThreadPriority;

import org.junit.Test;

/**
 * @author luongnv89
 * 
 */
public class ThreadPriorityTest {

	@Test
	public void test() {
		ThreadPriority t1, t2, t3;
		t1 = new ThreadPriority();
		t1.start();

		t2 = new ThreadPriority();
		t2.start();

		t3 = new ThreadPriority();
		t3.start();
	}

}
