/**
 * 
 */
package csc5021.mapreduce.process;

import csc5021.interfaces.HasInvariant;
import csc5021.mapreduce.objects.Cube;
import csc5021.mapreduce.objects.Dictionary;
import csc5021.mapreduce.objects.Job;
import csc5021.mapreduce.objects.Plane_feature;

/**
 * @author luongnv89
 * 
 */
public class JobsClientManager implements HasInvariant {
	Cube cube;
	Dictionary dic;
	Mapper map;

	
	/**
	 * @param cubePath
	 * @param dicPath
	 * @throws Exception
	 */
	public JobsClientManager(String cubePath, String dicPath, Mapper map) throws Exception {
		this.cube = new Cube(cubePath);
		this.dic = new Dictionary(dicPath);
		this.map = map;
		this.map.setJobClient(this);

	}

	public void createJobs() {
		if (this.invariant())
			for (int word_index = 0; word_index < dic.getSize(); word_index++) {
				for (int feature_index = 0; feature_index < Plane_feature.features.length; feature_index++) {
					switch (feature_index) {
					case 0:
					case 1:
					case 2:
						for (int delta = 0; delta < cube.getSize(); delta++) {
							submitJob(new Job(word_index, Plane_feature.features[feature_index], delta), map);
						}
						break;
					case 3:
					case 4:
						for (int delta = dic.getLength(); delta < 2 * cube.getSize() - dic.getLength() - 1; delta++) {
							submitJob(new Job(word_index, Plane_feature.features[feature_index], delta), map);
						}
						break;
					case 5:
					case 6:
						for (int delta = dic.getLength() - cube.getSize(); delta < cube.getSize() - dic.getLength(); delta++) {
							submitJob(new Job(word_index, Plane_feature.features[feature_index], delta), map);
						}
						break;
					default:
						System.out.println("Cannot find the plane feature");
						break;
					}
				}
			}
	}

	private void submitJob(Job job, Mapper map) {
		map.listWaitingJobs.add(job);
	}

	@Override
	public boolean invariant() {
		if (cube.getSize() < dic.getLength()) {
			System.out.println("The size of cube is smaller than the lenght of word of dictionary");
			return false;
		} else
			return cube.invariant() && dic.invariant();
	}

	/**
	 * @return the cube
	 */
	public Cube getCube() {
		return cube;
	}

	/**
	 * @param cube the cube to set
	 */
	public void setCube(Cube cube) {
		this.cube = cube;
	}

	/**
	 * @return the dic
	 */
	public Dictionary getDic() {
		return dic;
	}

	/**
	 * @param dic the dic to set
	 */
	public void setDic(Dictionary dic) {
		this.dic = dic;
	}
	
	

}
