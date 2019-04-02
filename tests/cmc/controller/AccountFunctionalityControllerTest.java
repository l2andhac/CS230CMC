package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Admin;
import cmc.entity.University;
import cmc.entity.User;

public class AccountFunctionalityControllerTest {
	
	private static AccountFunctionalityController afc;
	private static DBController dbc;
	private User user, emailUser, user2;
	private Admin admin2;
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
		dbc.addAccount(this.user);
		dbc.addSchool(this.u);
		user2 = new User("dummy", "Dempsey", "dummyuser", "password", 'P');
		admin2 = new Admin("dummy", "Dempsey", "dummyadmin", "123456", 'D');
		dbc.addAccount(user2);
		dbc.addAccount(admin2);
		
		this.emailUser = new User("Dummy", "Email", "dummyUser@email.com", "password", 'Y');
		dbc.addAccount(emailUser);
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeSchool(u);
		dbc.removeAccount("dummyUser@email.com");
		dbc.removeAccount("dummyuser");
		dbc.removeAccount("dummyadmin");
	}

	@Test
	public void testLogOn() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRequestNewAccountForNonExistingAccount() {
		User aUser = new User("Winnie", "Tapsoba", "wtapsoba", "password",'Y');
		char initStatus = aUser.getStatus();
		afc.requestNewAccount(aUser);
		char newStatus = aUser.getStatus();
		assertFalse("The initial status of the user should be different to the "
				+ "status after request", initStatus == newStatus);
		dbc.removeAccount("wtapsoba");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRequestNewAccountForExistingAccount() {
		afc.requestNewAccount(this.user);
				
	}

	@Test
	public void testForgotPassword() {
		assertTrue("A new password was correctly emailed", afc.forgotPassword("dummyUser@email.com"));
			
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForgotPasswordNoAccount() {
		afc.forgotPassword("accountNotFound");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForgotPasswordUsernameNotEmail() {
		afc.forgotPassword("dummyUser");
	}

	@Test
	public void testViewAccountInfoAccount() {
		//fail("Not yet implemented");
	}

	@Test
	public void testViewAccountInfoString() {
		//fail("Not yet implemented");
	}

	@Test
	public void testViewSchoolDetailsValidInput() {	
		University actual = afc.viewSchoolDetails("UNIVERSITE DE OUAGADOUGOU");
		assertTrue("The school name input is in the database, and returns a correct University",
				actual.equals(u));
	}
	
	@Test
	public void testViewSchoolDetailsInvalidInput() {	
		University actual = afc.viewSchoolDetails("U");
		assertTrue("The school name input is not in the database, and returns a null University",
				actual == null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidUsername() {
		afc.editAccountInfo("Kate", "Kate", "Dempsey", "password", 'a', 'Y');
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidUsername2() {
		afc.editAccountInfo("Steffi", "Steffi", "Tapsoba", "password", 'u', 'N');
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidType() {
		afc.editAccountInfo("dummyuser", "dummy", "Dempsey", "password", 'q', 'P');
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidType2() {
		afc.editAccountInfo("dummyadmin", "dummy", "Dempsey", "123456", 'p', 'D');
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidStatus() {
		afc.editAccountInfo("dummyadmin", "dummy", "Dempsey", "123456", 'a', 'O');
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidStatus2() {
		afc.editAccountInfo("dummyuser", "dummy", "Dempsey", "password", 'u', 'y');
	}
	
	@Test 
	public void testEditAccountInfoChangeStatus() {
		afc.editAccountInfo("dummyuser", "dummy", "Dempsey", "password", 'u', 'D');
		assertTrue("The status of the account was changed to D", user2.getStatus() == 'D');
	}
	
	@Test 
	public void testEditAccountInfoChangeFirstName() {
		afc.editAccountInfo("dummyAdmin", "Kate", "Dempsey", "123456",  'a', 'Y');
		assertTrue("The First Name of the account was changed to Kate", user2.getFirstName() == "Kate");
	}

}
