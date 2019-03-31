package cmc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.User;

public class AccountControllerTest {

	private AccountController ac;
	private DBController dbc;
	
	@BeforeClass
	public void beforeTest() throws Exception{
		ac = new AccountController();
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
	public void testAccountController() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogOn() {
		fail("Not yet implemented");
	}

}
