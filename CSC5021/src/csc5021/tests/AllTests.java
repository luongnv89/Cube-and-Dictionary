package csc5021.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CubeTest.class, DictionaryTest.class, ParallelTest.class, SequentialTest.class, UtilitiesTest.class })
public class AllTests {

}
