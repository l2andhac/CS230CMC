package cmc.controller;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.Admin;
import cmc.entity.University;
import cmc.entity.User;
import dblibrary.project.csci230.UniversityDBLibrary;

public class AdminFunctionalityControllerTest {

	private static AdminFunctionalityController afc;
	private static DBController dbc;
	private static UniversityDBLibrary univDBlib;
	private static User u;
	private static Admin a;
	
	@BeforeClass
	public static void beforeTest() throws Exception{
		afc = new AdminFunctionalityController();
		dbc = new DBController();
		univDBlib = new UniversityDBLibrary("l2andhac", "CSCI230");
	}
	
	@Before
	public void setUp() throws Exception {
		u = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(u);
		a = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
		dbc.addAccount(a);
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeAccount("dummyAdmin");
		//......
	}

	@Test
	public void testAdminFunctionalityController() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchoolInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllSchoolsNumberOfSchools() {
		Set<University> allSchools = afc.viewAllSchools();
		String[][] univs = univDBlib.university_getUniversities();
		int numSchools = univs.length;
		assertTrue("The number of schools in the databse should be: " + numSchools,allSchools.size() == numSchools);
	}
	
	@Test
	public void testViewAllSchools() {
		Set<University> allSchools = afc.viewAllSchools();
		University univ = afc.viewSchoolDetails("AUBURN");
		assertTrue("AUBURN should be one of the Unviersities viewed", allSchools.contains(univ));
	}

	@Test
	public void testViewAllAccounts() {
		Set<String> allAccounts = afc.viewAllAccounts();
		int expectedSize = dbc.getTotalNumberOfAccounts();
		assertTrue("dummyUser should be one of the accounts viewed", allAccounts.contains("dummyUser"));
		assertTrue("dummyAdmin should be one of the accounts viewed", allAccounts.contains("dummyAdmin"));
		assertTrue("size of the set should be " + expectedSize, allAccounts.size() == expectedSize);
	}

	@Test
	public void testAddAccountAdmin() {
		assertTrue("the admin account was added", dbc.viewAllAccounts().contains("dummyAdmin"));	
	}
	
	@Test
	public void testAddAccountUser() {
		assertTrue("the user account was added", dbc.viewAllAccounts().contains("dummyUser"));	
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddExistingUserAccount() {
		dbc.addAccount(u);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddExistingAdminAccount() {
		dbc.addAccount(a);
	}

}
