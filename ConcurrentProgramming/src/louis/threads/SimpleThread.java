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
		for(int i=0;i<100;i++){
			System.out.println("Message " + i+" from: " + this.getName());
		}
		try {
			System.out.println(this.getName()+" is going to sleep for 5 seconds");
			this.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getName()+ " wake up after sleep 5 seconds");
	}
}
