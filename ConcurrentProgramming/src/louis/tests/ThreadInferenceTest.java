/**
 * 
 */
package louis.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import synchronize.ThreadInference;

/**
 * @author luongnv89
 *
 */
public class ThreadInferenceTest {
	ThreadInference myThread1;
	Thread myT1;
	Thread myT2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myThread1 = new ThreadInference();
		myT1 = new Thread(myThread1);
		myT1.start();
		myT2 = new Thread(myThread1);
		myT2.start();
	}

	
	@Test
	public void testThreadMsg(){
		ThreadInference.threadMsg("Hello!");
	}

}
