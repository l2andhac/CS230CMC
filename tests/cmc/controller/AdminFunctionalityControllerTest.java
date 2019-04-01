package cmc.controller;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import cmc.entity.*;
import dblibrary.project.csci230.UniversityDBLibrary;

public class AdminFunctionalityControllerTest {

	private static AdminFunctionalityController afc;
	private static DBController dbc;
	private University univ1, univ2;
	List<String> foci1, foci2;
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
		afc.addAccount(u);
		
		foci1 = new ArrayList<String>();
		//foci2.add("BUSINESS-ADMINISTRATION");
		this.univ1 = new University("UNIVERSITE DE BOBO", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci1);
		foci2 = new ArrayList<String>();
		dbc.addSchool(univ1);
		foci2.add("BUSINESS-ADMINISTRATION");
		this.univ2 = new University("UNIVERSITE I2E", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(univ2);
		
		a = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
		afc.addAccount(a);
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeAccount("dummyAdmin");
		dbc.removeSchool(this.univ2);
		//......
	}

	@Test
	public void testAdminFunctionalityController() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		afc.removeSchool("UNIVERSITE DE BOBO");
		boolean removed = dbc.findSchoolName("UNIVERSITE DE BOBO");
		assertTrue("The school has been successfully removed", 
				 removed == false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveSchoolSavedByUser() {
		afc.removeSchool("STANFORD");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveSchoolWithEmphasis() {
		afc.removeSchool("UNIVERSITE I2E");
	}

	@Test
	public void testAddSchool() {
		List<String>foci3 = new ArrayList<String>();
		University univ4 = new University("ADDED UNIVERSITY", "MINNESOTA", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci3);
		afc.addSchool(univ4);
		assertTrue("The school with a name that was not previously in the database is now in the database", dbc.findSchoolName("ADDED UNIVERSITY"));
		dbc.removeSchool(univ4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddSchoolForExistingSchool() {
		afc.addSchool(univ2);
	}

	@Test
	public void testEditSchoolInfo() {
		int oldNumOfStudents = univ1.getNumStudents();
		University modifiedUniversity = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 20000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, null);
		afc.editSchoolInfo(modifiedUniversity);
		assertFalse("The school has been edited and the sumber of students has changed", modifiedUniversity.getNumStudents()==oldNumOfStudents);
	}

	@Test
	public void testViewAllSchoolsNumberOfSchools() {
		Set<University> allSchools = afc.viewAllSchools();
		int numSchools = dbc.getTotalNumberOfSchools();
		assertTrue("The number of schools in the databse should be: " + numSchools, allSchools.size() == numSchools);
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
		afc.addAccount(u);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddExistingAdminAccount() {
		afc.addAccount(a);
	}

}
