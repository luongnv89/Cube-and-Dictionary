/**
 * 
 */
package csc5021.objects;

import java.util.ArrayList;

import csc5021.interfaces.HasInvariant;
import csc5021.utilities.Utilities;

/**
 * The {@link Lattice} class present a lattice with the size is
 * {@link Lattice#size} and the content values is {@link Lattice#values}
 * 
 * @author luongnv89
 * 
 */
public class Lattice implements HasInvariant {
	
	public static final int MAX_SIZE = 10000;
	public static final int MIN_SIZE= 4;
	
	/**
	 * Size of lattice
	 */
	int size;
	/**
	 * Values of lattice
	 */
	char[][][] values;

	/**
	 * Constructor a Lattice by size. The values of Lattice is randomly
	 * @param size
	 */
	public Lattice(int size) {
		if (size < 3) {
			System.out
					.println("The input size of lattice is invalid (It should be greater than 2). The size will be default: 3");
			this.size = 3;
		} else {
			this.size = size;
		}
		values = new char[this.size][this.size][this.size];
		initRandomly();
	}
	

	/**
	 * Constructor a Lattice by values 
	 * @param values
	 */
	public Lattice(char[][][] values) {
		this.values = values;
		this.size = values[0][0].length;
	}

	/**
	 * Constructor a Lattice by an input string which present the values of Lattice
	 * @param str
	 * @throws Exception 
	 */
	public Lattice(String str) throws Exception{
		int mySize = Utilities.getCubeSize(str.length());
		if(mySize!=-1){
			this.size = mySize;
			values = new char[this.size][this.size][this.size];
			char[] array = str.toUpperCase().toCharArray();
			for(int i=0;i<mySize;i++){
				for(int j=0;j<mySize;j++){
					for(int k=0;k<mySize;k++){
						values[i][j][k]=array[i*mySize*mySize+j*mySize+k];
					}
				}
				
			}
		}
		else{
			throw new Exception("The input string has invalid length!");
		}
	}

	
	/**
	 * Coppy a Lattice
	 * @param copy
	 */
	public Lattice(Lattice copy){
		this.size = copy.getSize();
		this.values = copy.getValues();
	}

	
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @return the values
	 */
	public char[][][] getValues() {
		return values;
	}


	@Override
	public boolean invariant() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Show the value of lattice
	 */
	public void showLatice(){
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				for(int k=0;k<this.size;k++){
					System.out.print(values[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	/**
	 * create randomly values for lattice
	 * TODO: Init randomly
	 */
	public void initRandomly(){
		ArrayList<MyCharacter> listCharacter = new ArrayList<>();
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				for(int k=0;k<this.size;k++){
					char newChar = Utilities.getRandomCharater();
					for(int l=0;l<listCharacter.size();l++){
						if(listCharacter.get(l).getC()==newChar){
							listCharacter.get(l).increase();
							break;
						}
					}
					values[i][j][k] = 
				}
			}
		}
	}


	public boolean associated(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}

class MyCharacter{
	char c;
	int nb;
	/**
	 * @return the nb
	 */
	public int getNb() {
		return nb;
	}
	/**
	 * @param nb the nb to set
	 */
	public void setNb(int nb) {
		this.nb = nb;
	}
	/**
	 * @return the c
	 */
	public char getC() {
		return c;
	}
	
	public void increase(){
		this.nb++;
	}
}
