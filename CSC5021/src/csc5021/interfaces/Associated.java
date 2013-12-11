/**
 * 
 */
package csc5021.interfaces;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 * 
 */
public interface Associated {
	/**
	 * Checking is the cube associated with the dictionary?
	 * 
	 * @param cube
	 * @param dic
	 * @return true if the cube associated with the dictionary <br>
	 *         false otherwise
	 */
	public boolean associated(Cube cube, Dictionary dic);
}