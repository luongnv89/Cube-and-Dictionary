/**
 * 
 */
package louis.threads;

/**
 * @author luongnv89
 * 
 */
public class MessageLoopThread implements Runnable {

	@Override
	public void run() {
		String[] msgs = { "This is message 1", "This is message 2", "This is message 5", "This is message 8",
				"This is message 10" };
		try {
			for (int i = 0; i < msgs.length; i++) {
				System.out.println(Thread.currentThread().getName() + " : " + msgs[i]);
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " : " + "I wasn't finish");
		}

	}

}
