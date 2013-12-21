/**
 * 
 */
package csc5021.solutions;

import java.util.ArrayList;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;

/**
 * Present the parallel program which is checking the associated of a cube and a
 * dictionary
 * 
 * @author luongnv89
 * 
 */
public class Parallel extends SolutionAbstracts {
	private static final int NUMBER_THREADS = 50;
	private boolean associated = true;
	private long startTime = System.currentTimeMillis();
	private ArrayList<Thread> listThreads;

	public Parallel(Cube cube, Dictionary dic) {
		super(cube, dic);
		listThreads = new ArrayList<Thread>();
	}

	/**
	 * @param cubePath
	 * @param dicPath
	 * @throws Exception
	 */
	public Parallel(String cubePath, String dicPath) throws Exception {
		super(cubePath, dicPath);
		listThreads = new ArrayList<Thread>();
	}

	@Override
	public boolean checkAssociatedOfDictionary() {

		if (!dic.invariant() || !cube.invariant()) {
			return false;
		} else if (dic.getLength() > cube.getSize()) {
			return false;
		} else {
			// Parallel
			for (int i = 0; i < dic.getSize(); i++) {

				if (associated) {

					final int word_index = i;
					Thread word_thread = new Thread(new Runnable() {
						@Override
						public void run() {
							System.out.println("Thread " + word_index + " started...");
							if (!checkAssociatedOfWord(dic.getWordByIndex(word_index))) {
								System.out.println("There is a word not associated: " + dic.getWordByIndex(word_index)
										+ "\nStop at thread: " + word_index + " at time: "
										+ String.valueOf(System.currentTimeMillis() - startTime));
								associated = false;
								System.out.println("Interupt all alive threds....");
								for (int t = 0; t < listThreads.size(); t++) {
									if (listThreads.get(t).isAlive())
										listThreads.get(t).interrupt();
								}
							}
							System.out.println("Thread " + word_index + " stoped!!!");

						}
					});
					listThreads.add(word_thread);
					listThreads.get(listThreads.size() - 1).start();

					// Check if there is some slot for new thread
					while (!moveToNextWord() && associated) {
						System.out.println("Waiting for other thread finished!");
						// try {
						// Thread.sleep(100);
						// } catch (InterruptedException e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }

					}

				}
			}

			while (isThereAliveThreads()) {
				System.out.println("Waiting for all thread finished!");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return associated;
	}

	/**
	 * Check if all the child threads are dead!
	 * 
	 * @return false if there is any thread still alive <br>
	 *         true otherwise
	 */
	private boolean isThereAliveThreads() {
		removeFinishThread();
		System.out.println("Number of alive threads: " + listThreads.size());
		if (listThreads.size() > 0)
			return true;
		return false;
	}

	/**
	 * Check if can create new thread
	 * 
	 * @return true if there are some slot for new thread <br>
	 *         false if there are {@link Parallel#NUMBER_THREADS} threads still
	 *         running.
	 */
	private boolean moveToNextWord() {
		removeFinishThread();
		if (listThreads.size() < NUMBER_THREADS)
			return true;
		return false;
	}

	/**
	 * 
	 */
	private void removeFinishThread() {
		for (int i = 0; i < listThreads.size(); i++) {
			if (!listThreads.get(i).isAlive())
				listThreads.remove(i);
		}
	}
}