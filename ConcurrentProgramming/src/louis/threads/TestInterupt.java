/**
 * 
 */
package louis.threads;

/**
 * @author luongnv89
 *
 */
public class TestInterupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread[] = new Thread[100];
		for(int i=0;i<100;i++){
			thread[i] = new Thread(new SimpleRunable());
			thread[i].start();
		}
		System.out.println("End");
	}

}
