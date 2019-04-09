package cmc.entity;

import org.junit.runner.RunWith;
import cmc.controller.AllControllerTests;
import cmc.functionalTesting.AdminFunctionalTests;
import cmc.functionalTesting.UserFunctionalTests;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, SavedSchoolTest.class, SearchTest.class, UniversityTest.class,
		UserTest.class, AllControllerTests.class, AdminFunctionalTests.class, UserFunctionalTests.class})
public class AllEntityTests {

}
