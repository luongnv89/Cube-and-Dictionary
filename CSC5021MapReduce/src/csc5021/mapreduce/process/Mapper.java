/**
 * 
 */
package csc5021.mapreduce.process;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;

import csc5021.mapreduce.objects.Job;
import csc5021.mapreduce.objects.Plane_feature;

/**
 * @author luongnv89
 *
 */
public class Mapper {
	JobsClientManager jobClient;
	
	ArrayList<Job> listWaitingJobs = new ArrayList<>();
	
	private void map(Job job) throws Exception{
		String word = jobClient.getDic().getWordByIndex(job.getWord_index());
		String planeFeature = job.getPlaneFeture();
		int delta = job.getDelta();
		
		switch (planeFeature) {
		case "PLANE_OXY":
			
			break;
		case "PLANE_OYZ":

		default:
			break;
		}
	}

	/**
	 * @param jobClient the jobClient to set
	 */
	public void setJobClient(JobsClientManager jobClient) {
		this.jobClient = jobClient;
	}

	
}
