/**
 * 
 */
package louis.tests;

import louis.threads.MessageLoopThread;

import org.junit.Before;
import org.junit.Test;

/**
 * @author luongnv89
 * 
 */
public class MessageLoopThreadTest {
	MessageLoopThread msgThread;
	Thread newThread;
	Thread newThread2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		msgThread = new MessageLoopThread();
		newThread = new Thread(msgThread);
		newThread2 = new Thread(msgThread);
	}

	@Test
	public void test() {
		long startTime = System.currentTimeMillis();
		newThread.start();
		newThread2.start();

		while (newThread.isAlive()) {
			System.out.println(Thread.currentThread().getName() + " : I am still waiting...");
			try {
				newThread.join(1000);
				newThread2.join(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((System.currentTimeMillis() - startTime >= 100000) && (newThread.isAlive()||newThread2.isAlive())) {
				System.out.println(Thread.currentThread().getName() + " : I am very tired. I cannot wait any more");
				newThread.interrupt();
				newThread2.interrupt();
				try {
					newThread.join();
					newThread2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println(Thread.currentThread().getName() + " : It's over!");
	}

}
