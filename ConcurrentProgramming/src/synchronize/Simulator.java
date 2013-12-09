/**
 * 
 */
package synchronize;

/**
 * @author luongnv89
 *
 */
public class Simulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadInference myThread1 = new ThreadInference();
		Thread myT1 = new Thread(myThread1);
		myT1.start();
		Thread myT2 = new Thread(myThread1);
		myT2.start();
	}

}
