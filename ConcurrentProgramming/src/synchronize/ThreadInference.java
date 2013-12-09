/**
 * 
 */
package synchronize;

/**
 * @author luongnv89
 * 
 */
public class ThreadInference extends Thread {

	private Counter counter = new Counter();

	public static void threadMsg(String msg) {
		System.out.println(Thread.currentThread().getName() + ": " + msg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public synchronized void run() {
//		synchronized (counter) {
			try {
				counter.increase();
				threadMsg("welcome");
				Thread.sleep(1000);
				threadMsg(""+counter.getValue());
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" : Something wrong");
				e.printStackTrace();
			}
//		}
		
		
	}

}
