/**
 * 
 */
package louis.threads;

/**
 * @author luongnv89
 *
 */
public class SimpleThread extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Message " + i+" from: " + this.getName());
		}
	}
}
