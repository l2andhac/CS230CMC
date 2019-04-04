package cmc.entity;

import org.junit.runner.RunWith;
import cmc.controller.*;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, SavedSchoolTest.class, SearchTest.class, UniversityTest.class,
		UserTest.class, AllControllerTests.class})
public class AllEntityTests {

}
