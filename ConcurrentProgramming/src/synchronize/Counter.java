/**
 * 
 */
package synchronize;

/**
 * @author luongnv89
 * 
 */
public class Counter {
	private static int count = 0;

	public void increase() {
		count++;
	}

	public int getValue() {
		return count;
	}
}
