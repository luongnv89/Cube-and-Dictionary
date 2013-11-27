/**
 * 
 */
package louis.threads;

import java.util.Random;

/**
 * @author luongnv89
 * 
 */
public class SimpleRunable implements Runnable {
	static boolean done = false;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started!");
		Random ran = new Random();
		int num;
		while (!isDone()) {
			num = ran.nextInt(100);
			if (num >= 90) {
				System.out.println(Thread.currentThread().getName() + " has finished!");
				setDone(true);
			}
		}

	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done
	 *            the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

}
