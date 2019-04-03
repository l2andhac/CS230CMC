package cmc.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountControllerTest.class, AccountFunctionalityControllerTest.class,
		AdminFunctionalityControllerTest.class, DBControllerTest.class, ForgotPasswordControllerTest.class,
		SearchControllerTest.class, UserFunctionalityControllerTest.class })
public class AllControllerTests {

}
