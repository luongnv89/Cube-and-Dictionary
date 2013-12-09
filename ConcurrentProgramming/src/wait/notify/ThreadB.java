/**
 * 
 */
package wait.notify;

/**
 * @author luongnv89
 *
 */
public class ThreadB extends Thread{
	int total=0;
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		synchronized (this) {
			for(int i=0;i<100;i++){
				try {
					Thread.sleep(100);
					total+=i;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			notify();
		}
		
	}
	
	public int getTotal(){
		return total;
	}

}
