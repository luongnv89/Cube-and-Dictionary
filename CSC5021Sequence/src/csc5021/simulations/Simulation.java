/**
 * 
 */
package csc5021.simulations;

import csc5021.interfaces.HasInvariant;
import csc5021.objects.Dictionary;
import csc5021.objects.Lattice;

/**
 * @author luongnv89
 *
 */
public class Simulation implements HasInvariant{

	Lattice latice;
	Dictionary dictionary;
	
	
	/**
	 * @param latice
	 * @param dictionary
	 */
	public Simulation(Lattice latice, Dictionary dictionary) {
		this.latice = latice;
		this.dictionary = dictionary;
	}

	public boolean associated(){
		if(latice.getSize()<dictionary.getLengthOfWord())
			return false;
		for(int i=0;i<dictionary.getListWord().size();i++){
			if(!latice.associated(dictionary.getListWord().get(i)))
				return false;
		}
		return true;
	}


	@Override
	public boolean invariant() {
		// TODO Auto-generated method stub
		return false;
	}

}
