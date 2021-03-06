package domain;

import domain.SpelerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, DriehoekTest.class, LijnStukTest.class, RechthoekTest.class, TekeningTest.class, OmhullendeTest.class, HintWoordTest.class,
        HintLetterTest.class, WoordenLijstTest.class})
public class AllTests {

}
