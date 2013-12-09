/**
 * 
 */
package louis.threads;

/**
 * @author luongnv89
 * 
 */
public class ThreadPriority extends Thread {

	public static int sleepingTime = 5000;
	public static int priority = 3;

	public ThreadPriority() {
		sleepingTime += 1000;
		priority += 1;
		this.setPriority(priority);
		System.out.println("Create thread: " + this.getName() + " \nPriority: " + this.getPriority());
	}

	public void run() {
		System.out.println(this.getName() + " starting...");
		try {
			System.out.println(this.getName() + " has priority: " + this.getPriority() + "\n It is going to sleep...");
			sleep(sleepingTime);
//			join();
			System.out.println(this.getName() + " wake up!");
		} catch (InterruptedException e) {
			System.out.println("Something wrong: " + e.toString());
			e.printStackTrace();
		}

		
	}
}
