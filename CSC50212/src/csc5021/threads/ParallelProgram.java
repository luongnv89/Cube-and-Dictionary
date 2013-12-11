/**
 * 
 */
package csc5021.threads;

import java.util.ArrayList;

import csc5021.objects.AssociatedShared;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 *
 */
public class ParallelProgram {
	
	static Cube cube;
	static Dictionary dic;
	static int nbWordThreads = 10;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		initial();
		ArrayList<Thread> listThreads = new ArrayList<>();
		
		if(!AssociatedShared.readyToWork()){
			System.out.println("You need to setup cube and data first!");
		}
		else{
			//Create threads
			for(int wordIndex=0;wordIndex<dic.getDic_size();wordIndex++){
				WordThreads wordThread = new WordThreads(wordIndex);
				listThreads.add(wordThread);
			}
			for(int threadIndex = 0;threadIndex<dic.getDic_size()/nbWordThreads;threadIndex++){
				
			}
		}
		
	}


	private static void initial() {
		// Setup for cube and dictionary
		try {
			cube = new Cube("cubes/cube_100.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dic = new Dictionary("dics/dic_10_50.txt");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		AssociatedShared.setCube(cube);
		AssociatedShared.setDic(dic);
		
	}

}
