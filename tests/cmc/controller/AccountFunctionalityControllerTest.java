package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.University;
import cmc.entity.User;

public class AccountFunctionalityControllerTest {
	
	private static AccountFunctionalityController afc;
	private static DBController dbc;
	private User user;
	private static University u;
	private static ArrayList<String> foci2;
	
	@BeforeClass
	public static void beforeTest() throws Exception{
		afc = new AccountFunctionalityController();
		dbc = new DBController();
		//makes a university without emphasis
		foci2 = new ArrayList<String>();
		u = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
	}
	
	@Before
	public void setUp() throws Exception {
		this.user = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(this.u);
		dbc.addSchool(this.u);
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeSchool(u);
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
	public void testRequestNewAccountForNonExistingAccount() {
		User aUser = new User("Winnie", "Tapsoba", "wtapsoba", "password",'Y');
		char initStatus = aUser.getStatus();
		afc.requestNewAccount(aUser);
		char newStatus = aUser.getStatus();
		assertFalse("The initial status of the user should be different to the "
				+ "status after request", initStatus == newStatus);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRequestNewAccountForExistingAccount() {
		afc.requestNewAccount(this.user);
				
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
	public void testViewSchoolDetailsValidInput() {	////?
		University actual = afc.viewSchoolDetails("UNIVERSITE DE OUAGADOUGOU");
		assertTrue("The school name input is in the database, and returns a correct University",
				actual.toString() == u.toString());
	}
	
	@Test
	public void testViewSchoolDetailsInvalidInput() {	
		University actual = afc.viewSchoolDetails("U");
		assertTrue("The school name input is not in the database, and returns a null University",
				actual == null);
	}

	@Test
	public void testEditAccountInfo() {
		fail("Not yet implemented");
	}

}
