package cmc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
	private DBController dbController;

	@Before
	public void setUp() throws Exception {
		this.dbController = new DBController();
	}

	@After
	public void tearDown() throws Exception {
		this.dbController = null;
	}

	@Test
	public void testDBController() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchool() {
		fail("Not yet implemented");
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
		int actualNumOfSchool = 180;
		int testNumOfSchool = dbController.getTotalNumberOfSchools();
		AssertTrue("The method should return a total of "+actualNumOfSchool+" schools.", actualNumOfSchool == testNumOfSchool);
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
