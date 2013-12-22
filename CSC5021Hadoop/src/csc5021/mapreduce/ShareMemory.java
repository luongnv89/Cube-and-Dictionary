/**
 * 
 */
package csc5021.mapreduce;

import java.util.ArrayList;

/**
 * @author luongnv89
 * 
 */
public class ShareMemory {
	private static ArrayList<String> listWords = new ArrayList<String>();
	private static boolean associated = true;
	
	
	/**
	 * @return the listWords
	 */
	public static ArrayList<String> getListWords() {
		return listWords;
	}
	/**
	 * @param listWords the listWords to set
	 */
	public static void setListWords(ArrayList<String> listWords) {
		ShareMemory.listWords = listWords;
	}
	/**
	 * @return the associated
	 */
	public static boolean isAssociated() {
		return associated;
	}
	/**
	 * @param associated the associated to set
	 */
	public static void setAssociated(boolean associated) {
		ShareMemory.associated = associated;
	}
	
	
}
