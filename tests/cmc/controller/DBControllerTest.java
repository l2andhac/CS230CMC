package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.Admin;
import cmc.entity.University;
import cmc.entity.User;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
	
	private static UniversityDBLibrary univDBlib;
	  // instance variable for a searchController
	private SearchController searchController;
	private static DBController dbc;
	List<String> foci2;
	University u;
	Admin admin;
	User user;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		univDBlib = new UniversityDBLibrary("l2andhac", "CSCI230");
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		foci2 = new ArrayList<String>();
		u = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		boolean added = dbc.addSchool(u);
		user = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		admin = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeSchool(u);
		dbc.removeAccount("dummyAdmin");
		dbc.removeAccount("dummyUser");
	}

	@Test
	public void testDBController() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchool() {
		foci2.add("BUSINESS-ADMINISTRATION");
		University originalUniversity = dbc.getSchool("UNIVERSITE DE OUAGADOUGOU");
		University modifiedUniversity = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.editSchool(modifiedUniversity); //modified number of students from 8000 to 10000, with foci2 BUSINESS-ADMINISTRATION
		University newUniversity = dbc.getSchool("UNIVERSITE DE OUAGADOUGOU");
		assertFalse("the original school AUGSBURG is different from the modified school AUGSBURG which "
				+ "now have 8000 students instead of 10000", originalUniversity.equals(newUniversity));
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSchoolSaved() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountAdminFound() {
		dbc.addAccount(admin);
		Admin actual = (Admin)dbc.findAccount("dummyAdmin");
		assertTrue("The account found is the correct admin,", 
				actual.equals(admin));
	}
	
	@Test
	public void testFindAccountUserFound() {
		dbc.addAccount(user);
		Account actual = dbc.findAccount("dummyUser");
		assertTrue("The account found is the correct user,", 
				actual.equals(user));
	}
	
	@Test
	public void testFindAccountFails() {
		Account actual = dbc.findAccount("kate");
		assertTrue("The account does not exist, so a null account"
				+ "is returned", actual == null);
	}

	@Test
	public void testGetAllSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSchoolName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSearchedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeAccountFirstName() {
		dbc.addAccount(user);
		user.setFirstName("newDummy");
		dbc.changeAccount(user);
		assertTrue("The first name is now changed for the user",
				user.getFirstName().equals("newDummy"));
	}
	
	@Test
	public void testChangeAccountLastName() {
		dbc.addAccount(user);
		user.setLastName("Rothstein");
		dbc.changeAccount(user);
		assertTrue("The last name is now changed for the user",
				user.getLastName().equals("Rothstein"));
	}
	
	@Test
	public void testChangeAccountPassword() {
		dbc.addAccount(admin);
		admin.setPassword("123455");
		dbc.changeAccount(admin);
		assertTrue("The password is now changed for the admin",
				admin.getPassword().equals("123455"));
	}
	
	@Test
	public void testChangeAccountStatus() {
		dbc.addAccount(admin);
		admin.setStatus('N');
		dbc.changeAccount(admin);
		//assertTrue("The status is now changed for the admin",
				//admin.getSatus().equals('N'));
	}

	@Test
	public void testHasEmphasis() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testRequestNewAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalNumberOfSchools() {
		int actualNumOfSchool = 181; //actually it is 180 but since I added "UNIVERSITE OF OUAGADOUGOU" in the test class it is 181
		int testNumOfSchool = dbc.getTotalNumberOfSchools();
		assertTrue("The method should return a total of "+actualNumOfSchool+" schools.", actualNumOfSchool == testNumOfSchool);
	}

	@Test
	public void testFindRecSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testBubbleSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmphases() {
		fail("Not yet implemented");
	}

}
