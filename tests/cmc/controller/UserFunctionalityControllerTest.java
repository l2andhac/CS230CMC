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
import cmc.entity.Search;
import cmc.entity.University;
import cmc.entity.User;

public class UserFunctionalityControllerTest {

	private static UserFunctionalityController ufc;
	private static DBController dbc;
	private User u;
	List<String> foci2;
	
	@BeforeClass
	public static void beforeTest() throws Exception{
		ufc = new UserFunctionalityController();
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		u = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(u);
		foci2 = new ArrayList<String>();
		foci2.add("BUSINESS-ADMINISTRATION");
		University univ = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		SavedSchool s = new SavedSchool(univ, "time");
		dbc.addSavedSchool(u, s);
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		//......
	}

	@Test
	public void testViewSchoolDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserFunctionalityController() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewUserInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchForFriends() {
		fail("Not yet implemented");
	}

	@Test
	public void testRequestDeactivation() {
		ufc.requestDeactivation(u);
		assertTrue("The user should be deactivated", u.getStatus() == 'd');
	}

	@Test
	public void testSearchSchool() {
		Search so = new Search("", "CALI", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, null);
		Set<University> matches = ufc.searchSchool(so);
		System.out.println(matches.size());
		//University expected = dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY");
		//assertTrue("The results should contain Berkeley", matches.contains(expected));
		assertTrue("There should be 12 schools in matches", matches.size() == 12);
	}

	@Test
	public void testSortResults() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveSchool() {
		fail("Not yet implemented");
		
		
		
		
		
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSavedSchools() { //this test fails. I do not fully understand why
		List<SavedSchool> savedSchools = ufc.viewSavedSchools(u);
		List<SavedSchool> actualSavedSchools = new ArrayList<SavedSchool>();
		University aUniv = dbc.getSchool("UNIVERSITE DE OUAGADOUGOU");
		SavedSchool aSavedSchool = new SavedSchool(aUniv, "timeStamp");
		actualSavedSchools.add(aSavedSchool);
		
		assertTrue("The list of school saved by user should match the schools "
				+ "that are actually saved", actualSavedSchools.equals(savedSchools));
	}

	@Test
	public void testCompareSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testRequestForSecondSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowRecSchools() {
		fail("Not yet implemented");
	}

}
