/**
 * 
 */
package csc5021.objects;

/**
 * @author luongnv89
 *
 */
public class AssociatedShared {
	private static boolean associated = true;
	private static Cube cube;
	private static Dictionary dic;
	
	/**
	 * @return the cube
	 */
	public static Cube getCube() {
		return cube;
	}

	/**
	 * @param cube the cube to set
	 */
	public static void setCube(Cube cube) {
		AssociatedShared.cube = cube;
	}

	/**
	 * @return the dic
	 */
	public static Dictionary getDic() {
		return dic;
	}

	/**
	 * @param dic the dic to set
	 */
	public static void setDic(Dictionary dic) {
		AssociatedShared.dic = dic;
	}

	public static void setAssociated(boolean asso){
		associated = asso;
	}
	
	public static boolean getAssociated(){
		return associated;
	}
	
	public static void setup(Cube c, Dictionary d){
		AssociatedShared.cube = c;
		AssociatedShared.dic = d;
	}
	
	public static boolean readyToWork(){
		return (AssociatedShared.cube!=null&&AssociatedShared.dic!=null);
	}

}
