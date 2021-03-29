package domain;

import Story1.test.domain.SpelerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, Story1.test.domain.CirkelTest.class})
public class AllTests {

}
