/**
 * 
 */
package csc5021.program;

import csc5021.interfaces.Associated;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * Present a sequences program which can check the associated of a cube and a
 * dictionary
 * 
 * @author luongnv89
 * 
 */
public class SequenceAssociated extends AssociatedAbstract implements Associated{

	@Override
	public boolean associated(Cube cube, Dictionary dic) {
		if (!(cube.invariant() && dic.invariant())) {
			// System.out.println("The input is not valid!");
			return false;
		} else if (dic.getLength() > cube.getSize()) {
			// System.out
			// .println("The cube is not associated with the dictionary!\nThe size of cube and the length of word of dictionary are not the same");
			return false;
		} else {
			for (int i = 0; i < dic.getSize(); i++) {
				if (!associated_word(cube, dic.getWordByIndex(i))) {
					System.out.println("The cube is not associated with the dictionary!\nThe word index: " + i
							+ "\nThere is a word not associated: " + dic.getWordByIndex(i));
					return false;
				}
			}
		}
		// System.out.println("The cube is associated with the dictionary!");
		return true;
	}

}
