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
import dblibrary.project.csci230.UniversityDBLibrary;

public class UserFunctionalityControllerTest {

	private static UserFunctionalityController ufc;
	private static DBController dbc;
	private User u;
	private University univ;
	private SavedSchool s;
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
		univ = new University("A Dummy School", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		s = new SavedSchool(univ, "time");
		dbc.addSavedSchool(u, s);
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeSavedSchool(u, s.getSchoolName());
		//......
	}

	@Test
	public void testViewSchoolDetailsSchoolNotFound() {
		assertTrue(ufc.viewSchoolDetails("laksdjflaksj") == null);
	}
	
	@Test
	public void testViewSchoolDetailsSchoolFound() {
		Boolean t = dbc.addSchool(univ);
		System.out.println(t);
		System.out.println(ufc.viewSchoolDetails(univ.getSchoolName()).toString());
		System.out.println(univ.toString());
		assertTrue(ufc.viewSchoolDetails(univ.getSchoolName()).toString().equals(univ.toString()));	
		dbc.removeSchool(univ);
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
	public void testSearchForFriendsUserFound() {
		List<SavedSchool> s = ufc.searchForFriends("dummyUser");
		assertTrue("The two lists should contain the same schools", s == dbc.getSavedSchools(u));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchForFriendsUserNotFound() {
		List<SavedSchool> s = ufc.searchForFriends(null);
		
		
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
		dbc.removeSavedSchool(u, s.getSchoolName());
		assertFalse("saved school is no longer in the list", dbc.getSavedSchools(u).contains(univ));
		ufc.saveSchool(univ, u);
		assertTrue("saved school is in the list", dbc.getSavedSchools(u).contains(univ));
	}

	@Test
	public void testRemoveSavedSchool() {
		assertTrue("saved school is in the list", dbc.getSavedSchools(u).contains(univ));
		ufc.removeSavedSchool(univ.getSchoolName(), u);
		assertFalse("saved school is no longer in the list", dbc.getSavedSchools(u).contains(dbc.getSchool(univ.getSchoolName())));
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
