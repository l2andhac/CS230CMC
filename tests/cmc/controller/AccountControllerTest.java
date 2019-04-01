package cmc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Admin;
import cmc.entity.User;
import cmc.controller.*;

public class AccountControllerTest {

	private static AccountController ac;
	private static DBController dbc;
	User dd;
	
	@BeforeClass
	public static void beforeTest() throws Exception{
		ac = new AccountController();
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		User ud = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(ud);
		User pd = new User("PendingDummy", "Jordre", "pendingDummyUser", "password", 'P');
		dbc.addAccount(pd);
		dd = new User("DeactivatedDummy", "Jordre", "deactivatedDummyUser", "password", 'N');
		dbc.addAccount(dd);
		Admin ad = new Admin("DummyAdmin", "Jordre", "dummyAdmin", "password", 'Y');
		dbc.addAccount(ad);		
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeAccount("pendingDummyUser");
		dbc.removeAccount("deactivatedDummyUser");
		dbc.removeAccount("dummyAdmin");
	}

	@Test
	public void testLogOn() {
		assertTrue("user is logged in", ac.logOn("dummyUser","password").isLoggedOn());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnWrongPassword() {
		ac.logOn("dummyUser","password2");
	}
	
	@Test
	public void testLogOnAdmin() {
		assertTrue("admin is logged in", ac.logOn("dummyAdmin","password").isLoggedOn());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnPending() {
		ac.logOn("pendingDummyUser","password");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnDeactivated() {
		ac.logOn(dd.getUsername(),"password");
	}
	
}
