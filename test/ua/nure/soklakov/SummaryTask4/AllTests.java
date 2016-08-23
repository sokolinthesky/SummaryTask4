package ua.nure.soklakov.SummaryTask4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nure.soklakov.SummaryTask4.dao.impl.PatientDaoImplTest;
import ua.nure.soklakov.SummaryTask4.dao.impl.UserDaoImplTest;

@RunWith(Suite.class)
@SuiteClasses({ UserDaoImplTest.class, PatientDaoImplTest.class, PathTest.class })
public class AllTests {

	@Test
	public void testMock() {
	}
}
