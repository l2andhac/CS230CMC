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
	
	@Test
	public void testSearchForFriendsUserNotFound() {
		List<SavedSchool> s = ufc.searchForFriends(null);
		assertTrue("The user is not found so it returns null", s == null);
		
		
	}

	@Test
	public void testRequestDeactivation() {
		ufc.requestDeactivation(u);
		assertTrue("The user should be deactivated", u.getStatus() == 'D');
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
	public void testSortResultsForExpenses() {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
	    Search s = new Search("","CALI", "URBAN", "STATE", 60000, 5000, 25, 60, -1, -1, -1, 
	    		  -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	    Set<University> listOfMatches = ufc.searchSchool(s);
	    
	    List<University> list = ufc.sortResults(listOfMatches, 'e');
	    University univ1 = dbc.getSchool("SAN JOSE STATE");
	    University univ2 = dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY");
	    University univ3 = dbc.getSchool("UNIVERSITY OF CALIFORNIA LOS ANGELES");
	    assertTrue("The first university on the sorted list should be SAN JOSE STATE", 
	    		list.get(0).getSchoolName().equals(univ1.getSchoolName()));
	    assertTrue("The second university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY", 
	    		list.get(1).getSchoolName().equals(univ2.getSchoolName()));
	    assertTrue("The third university on the sorted list should be UNIVERSITY OF CALIFORNIA LOS ANGELES", 
	    		list.get(2).getSchoolName().equals(univ3.getSchoolName()));
	    
	}
	
	@Test
	public void testSortResultsForAdmission() {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
	    Search s = new Search("","CALI", "URBAN", "STATE", 60000, 5000, 25, 60, -1, -1, -1, 
	    		  -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	    Set<University> listOfMatches = ufc.searchSchool(s);
	    List<University> list = ufc.sortResults(listOfMatches, 'a');
	    University univ1 = dbc.getSchool("SAN JOSE STATE");
	    University univ2 = dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY");
	    University univ3 = dbc.getSchool("UNIVERSITY OF CALIFORNIA LOS ANGELES");
	    assertTrue("The first university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY", 
	    		list.get(0).getSchoolName().equals(univ2.getSchoolName()));
	    assertTrue("The second university on the sorted list should be SAN JOSE STATE", 
	    		list.get(1).getSchoolName().equals(univ1.getSchoolName()));
	    assertTrue("The third university on the sorted list should be UNIVERSITY OF CALIFORNIA LOS ANGELES", 
	    		list.get(2).getSchoolName().equals(univ3.getSchoolName()));
	}
	
	@Test
	public void testSortResultsForNumberOfStudents() {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
	    Search s = new Search("","CALI", "URBAN", "STATE", 60000, 5000, 25, 60, -1, -1, -1, 
	    		  -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	    Set<University> listOfMatches = ufc.searchSchool(s);
	    List<University> list = ufc.sortResults(listOfMatches, 'n');
	    University univ1 = dbc.getSchool("SAN JOSE STATE");
	    University univ2 = dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY");
	    University univ3 = dbc.getSchool("UNIVERSITY OF CALIFORNIA LOS ANGELES");
	    assertTrue("The first university on the sorted list should be SAN JOSE STATE", 
	    		list.get(0).getSchoolName().equals(univ1.getSchoolName()));
	    //UNIVERSITY OF CALIFORNIA BERKELEY and UNIVERSITY OF CALIFORNIA LOS ANGELES have the same number of students (40000)
	    assertTrue("The second university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY "
	    		+ "or UNIVERSITY OF CALIFORNIA LOS ANGELES", 
	    		list.get(1).getSchoolName().equals(univ2.getSchoolName()) || list.get(1).getSchoolName().equals(univ3.getSchoolName()));
	    assertTrue("The third university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY"
	    		+ " or UNIVERSITY OF CALIFORNIA LOS ANGELES", 
	    		list.get(2).getSchoolName().equals(univ2.getSchoolName()) || list.get(2).getSchoolName().equals(univ3.getSchoolName()));
	}

	@Test
	public void testSaveSchool() {
		dbc.removeSavedSchool(u, s.getSchoolName());
		assertFalse("saved school is no longer in the list", dbc.getSavedSchools(u).contains(univ));
		ufc.saveSchool(univ, u);
		assertTrue("saved school is in the list", dbc.getSavedSchools(u).contains(univ));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSaveSchoolListIsNull() {
		User u2 = new User("Dummy", "Hoeschen", "dummyHoeschen", "password", 'Y');
		dbc.addAccount(u);
		ufc.saveSchool(univ, u2);
		dbc.removeAccount("dummyHoeschen");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSaveSchoolAlreadySaved() {
		
		ufc.saveSchool(univ, u);
		
	}

	@Test
	public void testRemoveSavedSchool() {
		assertTrue("saved school is in the list", dbc.getSavedSchools(u).contains(univ));
		ufc.removeSavedSchool(univ.getSchoolName(), u);
		assertFalse("saved school is no longer in the list", dbc.getSavedSchools(u).contains(dbc.getSchool(univ.getSchoolName())));
	}

	@Test
	public void testViewSavedSchools() { //this test fails. I do not fully understand why
		User aUser = (User) dbc.findAccount("dummyUser2");
		List<SavedSchool> savedSchools = ufc.viewSavedSchools(aUser);
		//List<SavedSchool> actualSavedSchools = new ArrayList<SavedSchool>();
		University aUniv = dbc.getSchool("BETHEL UNIVERSITY");
		SavedSchool aSavedSchool = new SavedSchool(aUniv, "time");
		//actualSavedSchools.add(aSavedSchool);
		
		assertTrue("The list of school saved by user should match the schools "
				+ "that are actually saved", savedSchools.get(0).getSchoolName().equals((aSavedSchool.getSchoolName())));
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
