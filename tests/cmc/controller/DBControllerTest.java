package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.SavedSchool;
import cmc.entity.University;
import cmc.entity.User;
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
		
		//makes new User
		dummy = new User("Dummy", "Will", "dummyUser2", "password", 'Y');
		dbc.addAccount(dummy);
		
		//makes u2 a SavedSchool
		SavedSchool s = new SavedSchool(u2, "time");
		
		//add u2to dummy's list
		dbc.addSavedSchool(dummy, s);
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeSchool(u);
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
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSavedSchools() {
		//tests user with 1 or more SavedSchool with emphases
		List<SavedSchool> saved = new ArrayList<SavedSchool>();
		saved.add(s);
		assertEquals("The list of dummy's SavedSchools should match list 'saved'", saved, dbc.getSavedSchools(dummy));
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
