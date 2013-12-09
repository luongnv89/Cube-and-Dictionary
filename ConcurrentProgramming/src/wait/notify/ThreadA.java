/**
 * 
 */
package wait.notify;

/**
 * @author luongnv89
 *
 */
public class ThreadA {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadB threadb = new ThreadB();
		threadb.start();
		synchronized (threadb) {
			try {
				System.out.println("Waiting for thread b completed!");
				threadb.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total: " + threadb.getTotal());

	}

}
