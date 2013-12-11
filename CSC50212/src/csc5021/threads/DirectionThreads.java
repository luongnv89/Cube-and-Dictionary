/**
 * 
 */
package csc5021.threads;

import csc5021.objects.CubeDirection;

/**
 * @author luongnv89
 *
 */
public class DirectionThreads extends Thread {

	int wordIndex;
	CubeDirection direction;
	/**
	 * @param wordIndex
	 * @param direction
	 */
	public DirectionThreads(int wordIndex, CubeDirection direction) {
		this.wordIndex = wordIndex;
		this.direction = direction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		
	}
	
	
	
}
