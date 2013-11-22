/**
 * 
 */
package csc5021.program;

import csc5021.interfaces.Associated;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * @author luongnv89
 * 
 */
public class PerformanceCompare {

	static Cube cube;
	static Dictionary dic;
	static SequenceAssociated seq = new SequenceAssociated();;
	static ParallelAssociated par = new ParallelAssociated();;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println("Seting up the testing environment....");
		long start = System.currentTimeMillis();
//		setup(900, 20, 900);
		 setup("cube_900.txt", "dic_20_900.txt");
		long setupTime = System.currentTimeMillis() - start;
//		writeToFile();
		System.out.println("The setup time: " + String.valueOf(setupTime) + " ms");
		System.out.println("The information of sequence program:");
		System.out.println(runtest(seq));
		System.out.println("The information of parallel program:");
		System.out.println(runtest(par));
	}

	private static void writeToFile() {
		cube.saveToFile("cube_" + cube.getSize() + "_" + String.valueOf(System.currentTimeMillis()));
		dic.saveToFile("dic_" + dic.getLength() + "_" + dic.getSize() + "_"
				+ String.valueOf(System.currentTimeMillis()));
	}

	private static boolean runtest(Associated program) {
		boolean associated;
		long startTime = System.currentTimeMillis();
		associated = program.associated(cube, dic);
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time: " + String.valueOf(totalTime) + " ms");
		return associated;
	}

	public static void setup(String pathCube, String pathDic) throws Exception {
		System.out.println("Creating the cube...");
		cube = new Cube(pathCube);
		System.out.println("Finish creating the cube.\nCreating the dictionary...");
		dic = new Dictionary(pathDic);
		System.out.println("Setup finished!");
	}

	public static void setup(int cubeSize, int wordLength, int dicSize) throws Exception {
		System.out.println("Creating the cube...");
		cube = new Cube(cubeSize);
		System.out.println("Finish creating the cube.\nCreating the dictionary...");
		dic = new Dictionary(wordLength, dicSize);
		System.out.println("Setup finished!");
	};
}
