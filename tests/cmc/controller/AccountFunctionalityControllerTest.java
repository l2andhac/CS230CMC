package cmc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.User;

public class AccountFunctionalityControllerTest {
	
	private AccountFunctionalityController afc;
	private DBController dbc;
	
	@BeforeClass
	public void beforeTest() throws Exception{
		afc = new AccountFunctionalityController();
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		User u = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(u);
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		//......
	}

	@Test
	public void testAccountFunctionalityController() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogOn() {
		fail("Not yet implemented");
	}

	@Test
	public void testRequestNewAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testForgotPassword() {
		fail("Not yet implemented");
		
		
		
		
		
	}

	@Test
	public void testViewAccountInfoAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAccountInfoString() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSchoolDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditAccountInfo() {
		fail("Not yet implemented");
	}

}
