/**
 * 
 */
package csc5021.programs;

import csc5021.interfaces.Associated;
import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.sequence.SequenceAssociated;
import csc5021.threads.ParallelAssociated;

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
		// setup(200, 6, 50);
		setup("data/cube/cube_500", "data/dic_associated/dic_associated_c_500_l_100_s_20");
		long setupTime = System.currentTimeMillis() - start;
//		writeToFile();
		System.out.println("The setup time: " + String.valueOf(setupTime) + " ms");
		System.out.println(runtest(par, "PARALLEL"));
		System.out.println(runtest(seq, "SEQUENCE"));
		System.exit(0);
	}

	private static void writeToFile() {
		cube.saveToFile("cube_" + cube.getSize() + "_" + String.valueOf(System.currentTimeMillis()));
		dic.saveToFile("dic_" + dic.getLength() + "_" + dic.getSize() + "_"
				+ String.valueOf(System.currentTimeMillis()));
	}

	private static boolean runtest(Associated program, String name) {
		boolean associated;
		long startTime = System.currentTimeMillis();
		associated = program.associated(cube, dic);
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println(name + " - Total time: " + String.valueOf(totalTime) + " ms");
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