package cmc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ForgotPasswordControllerTest {

	ForgotPasswordController fpc; 
	@Before
	public void setUp() throws Exception {
		fpc = new ForgotPasswordController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateRandomPassword() {  ///tests the length to be 6
		String actual = fpc.generateRandomPassword();
		assertTrue("The random password is a string with a length of 6", actual.length() == 6);
	}

	@Test
	public void testCheckIfEmail() {
		assertTrue("This should be an email ie contains @", fpc.checkIfEmail("fakeEmail@fake.com"));
		assertFalse("This should not be an email ie does not contain @", fpc.checkIfEmail("notEmail"));
	}

	@Test
	public void testEmailNewPassword() {
		fail("Not yet implemented");
	}

}
