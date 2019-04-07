package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Account;
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
	public static void beforeClass() throws Exception{
		afc = new AccountFunctionalityController();
		dbc = new DBController();
		//makes a university without emphasis
		foci2 = new ArrayList<String>();
		u = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
	}
	
	@Before
	public void setUp() throws Exception {
		this.user = new User("Dummy", "Jordre", "dummyuser7", "password", 'Y');
		dbc.addAccount(this.user);
		dbc.addSchool(this.u);
		user2 = new User("dummy", "Dempsey", "dummyuser77", "password", 'P');
		admin2 = new Admin("dummy", "Dempsey", "dummyadmin", "123456", 'D');
		dbc.addAccount(user2);
		dbc.addAccount(admin2);
		
		this.emailUser = new User("Dummy", "Email", "dummyuser7@email.com", "password", 'Y');
		dbc.addAccount(emailUser);
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyuser7");
		if (dbc.findSchoolName(u.getSchoolName()) == true) {
			u = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
			dbc.editSchool(u);
			dbc.removeSchool(u);
		}
		dbc.removeAccount("dummyuser7@email.com");
		dbc.removeAccount("dummyuser77");
		dbc.removeAccount("dummyadmin");
	}

	@Test
	public void testLogOn() {
		assertTrue("user is logged in", afc.logOn("dummyuser7","password").isLoggedOn());
	}
	
	@Test
	public void testLogOnAdmin() {
		assertTrue("admin is logged in", afc.logOn("dummyadmin","123456").isLoggedOn());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnWrongPassword() {
		afc.logOn("dummyuser7","password2");
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
		assertTrue("A new password was correctly emailed", afc.forgotPassword("dummyuser7@email.com"));
			
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForgotPasswordNoAccount() {
		afc.forgotPassword("accountNotFound");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForgotPasswordUsernameNotEmail() {
		afc.forgotPassword("dummyuser7");
	}

	@Test
	public void testViewAccountInfoAccount() {
		String actual = afc.viewAccountInfo(user2);
		assertTrue("The account information is correctly output", user2.toString().equals(actual));
	}

	@Test
	public void testViewAccountInfoString() {
		String actual = afc.viewAccountInfo("dummyuser7");
		Account a = dbc.findAccount("dummyuser7");
		assertTrue("The account info is correctly output", user.equals(a));
		//How to do this without the account to use the toString
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
		afc.editAccountInfo("dummyuser77", "dummy", "Dempsey", "password", 'q', 'P');
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
		afc.editAccountInfo("dummyuser77", "dummy", "Dempsey", "password", 'u', 'y');
	}
	
	@Test 
	public void testEditAccountInfoChangeStatus() {
		afc.editAccountInfo("dummyuser77", "dummy", "Dempsey", "password", 'u', 'D');
		//had to add this line to make it work
		Account a = dbc.findAccount("dummyuser77");
		assertTrue("The status of the account was changed to D", a.getStatus() == 'D');
	}
	
	@Test 
	public void testEditAccountInfoChangeFirstName() { 
		afc.editAccountInfo("dummyadmin", "Kate", "Dempsey", "123456",  'a', 'Y');
		Account a = dbc.findAccount("dummyadmin");
		assertTrue("The First Name of the account was changed to Kate", a.getFirstName().equals("Kate"));
	}
	
	@Test 
	public void testEditAccountInfoChangeLastName() { 
		afc.editAccountInfo("dummyuser77", "dummy", "Will", "password",  'u', 'Y');
		Account a = dbc.findAccount("dummyuser77");
		assertTrue("The Last Name of the account was changed to Will", a.getLastName().equals("Will"));
	}
	
	@Test 
	public void testEditAccountInfoChangePassword() { 
		afc.editAccountInfo("dummyadmin", "dummy", "Dempsey", "password",  'a', 'Y');
		Account a = dbc.findAccount("dummyadmin");
		assertTrue("The Password of the account was changed to password", a.getPassword().equals("password"));
	}
	
	@Test 
	public void testEditAccountInfoChangeType() { 
		afc.editAccountInfo("dummyuser77", "dummy", "Dempsey", "password",  'a', 'P');
		Account a = dbc.findAccount("dummyuser77");
		assertTrue("The Type of the account was changed to a", a.getUserType() == 'a');
	}

}
