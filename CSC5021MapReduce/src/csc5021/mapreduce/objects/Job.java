/**
 * 
 */
package csc5021.mapreduce.objects;

/**
 * @author luongnv89
 *
 */
public class Job {
	int word_index;
	String planeFeture;
	int delta;
	boolean isCompleted = false;
	boolean result = false;
	
	
	
	/**
	 * @param word_index
	 * @param planeFeture
	 * @param delta
	 */
	public Job(int word_index, String planeFeture, int delta) {
		this.word_index = word_index;
		this.planeFeture = planeFeture;
		this.delta = delta;
	}
	/**
	 * @return the word_index
	 */
	public int getWord_index() {
		return word_index;
	}
	/**
	 * @param word_index the word_index to set
	 */
	public void setWord_index(int word_index) {
		this.word_index = word_index;
	}
	/**
	 * @return the planeFeture
	 */
	public String getPlaneFeture() {
		return planeFeture;
	}
	/**
	 * @param planeFeture the planeFeture to set
	 */
	public void setPlaneFeture(String planeFeture) {
		this.planeFeture = planeFeture;
	}
	/**
	 * @return the delta
	 */
	public int getDelta() {
		return delta;
	}
	/**
	 * @param delta the delta to set
	 */
	public void setDelta(int delta) {
		this.delta = delta;
	}
	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}
	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}
	
	

	
}
