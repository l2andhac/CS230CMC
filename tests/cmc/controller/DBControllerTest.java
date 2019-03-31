package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.SavedSchool;
import cmc.entity.University;
import cmc.entity.User;
import cmc.entity.Admin;
import cmc.entity.Account;
import cmc.controller.DBController;
import cmc.controller.SearchController;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
	
	private static UniversityDBLibrary univDBlib;
	  // instance variable for a searchController
	private SearchController searchController;
	private static DBController dbc;
	List<String> foci2;
	University u, u2;
	SavedSchool s;
	User dummy;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		univDBlib = new UniversityDBLibrary("l2andhac", "CSCI230");
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		
		//makes University without a focus
		foci2 = new ArrayList<String>();
		u = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		boolean added = dbc.addSchool(u);
		
		//makes University with a focus
		foci2.add("ENGINEERING");
		u2 = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(u2);
		
		//makes new User
		dummy = new User("Dummy", "Will", "dummyUser2", "password", 'Y');
		dbc.addAccount(dummy);
		
		
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeSchool(u);
		dbc.removeSchool(u2);
		dbc.removeAccount("dummyUser2");
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
	public void testFindAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllSchools() {
		Set<University> allSchools = dbc.getAllSchools();
		//University univ = dbc.viewSchool("AUBURN");
		//assertTrue("AUBURN should be one of the Unviersities in the set", allSchools.contains(univ));
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSavedSchools() {

		//tests user with 1 or more SavedSchool with emphases
		//makes u2 a SavedSchool
	    SavedSchool s = new SavedSchool(u2, "time");	
		//add u2to dummy's list
		dbc.addSavedSchool(dummy, s);
		List<SavedSchool> saved = new ArrayList<SavedSchool>();
		saved.add(s);
		assertTrue("The list of dummy's SavedSchools should match list 'saved'", dbc.getSavedSchools(dummy).contains(s));
		//fail("Not yet implemented");
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
	public void testChangeAccount() {
		fail("Not yet implemented");
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
	    Account account = new Account ("Dummy", "WillAgain", "anotherDummy", "password", 'a','Y');
	    dbc.addAccount(account);
	    assertTrue("account is in the database", dbc.viewAllAccounts().contains(account.getUsername()));
	    dbc.removeAccount("anotherDummy");
	}

	@Test
	public void testRequestNewAccount() {
		User user = new User ("Dummy", "WillAgain", "anotherDummy", "password", 'p');
	    dbc.addAccount(user);
	    assertTrue("account is in the database", dbc.viewAllAccounts().contains(user.getUsername()));
	    dbc.removeAccount("anotherDummy");

	}

	@Test
	public void testGetTotalNumberOfSchools() {
		int actualNumOfSchool = 182; //actually it is 180 but since I added "UNIVERSITE OF OUAGADOUGOU" in the test class it is 181
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
		assertTrue("BETHEL UNIVERSITY contains the emphasis ENGINEERING", dbc.getEmphases(u2).contains("ENGINEERING"));
		//fail("Not yet implemented");
	}

}
