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
		assertTrue("The user should be deactivated", u.getStatus() == 'D');
	}

	@Test
	public void testSearchSchool() {
		fail("Not yet implemented");
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
	    for(int i = 0; i<list.size(); i++) {
	      	System.out.println(list.get(i));
	      }
	    University univ1 = dbc.getSchool("SAN JOSE STATE");
	    System.out.println(univ1.toString());
	    University univ2 = dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY");
	    University univ3 = dbc.getSchool("UNIVERSITY OF CALIFORNIA LOS ANGELES");
	    assertTrue("The first university on the sorted list should be SAN JOSE STATE", 
	    		list.get(0).equals(univ1));
	    assertTrue("The second university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY", 
	    		list.get(1).equals(univ2));
	    assertTrue("The third university on the sorted list should be UNIVERSITY OF CALIFORNIA LOS ANGELES", 
	    		list.get(3).equals(univ3));
	    
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
	    assertTrue("The first university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY", 
	    		list.get(0).equals(dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY")));
	    assertTrue("The second university on the sorted list should be SAN JOSE STATE", 
	    		list.get(1).equals(dbc.getSchool("SAN JOSE STATE")));
	    assertTrue("The third university on the sorted list should be UNIVERSITY OF CALIFORNIA LOS ANGELES", 
	    		list.get(3).equals(dbc.getSchool("UNIVERSITY OF CALIFORNIA LOS ANGELES")));
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
	    assertTrue("The first university on the sorted list should be SAN JOSE STATE", 
	    		list.get(0).equals(dbc.getSchool("SAN JOSE STATE")));
//	    assertTrue("The second university on the sorted list should be UNIVERSITY OF CALIFORNIA BERKELEY", 
//	    		list.get(0).equals(dbc.getSchool("UNIVERSITY OF CALIFORNIA BERKELEY")));
//	    assertTrue("The third university on the sorted list should be SAN JOSE STATE", 
//	    		list.get(0).equals(dbc.getSchool("SAN JOSE STATE")));
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
		User aUser = (User) dbc.findAccount("dummyUser2");
		List<SavedSchool> savedSchools = ufc.viewSavedSchools(aUser);
		//List<SavedSchool> actualSavedSchools = new ArrayList<SavedSchool>();
		University aUniv = dbc.getSchool("BETHEL UNIVERSITY");
		SavedSchool aSavedSchool = new SavedSchool(aUniv, "time");
		//actualSavedSchools.add(aSavedSchool);
		
		assertTrue("The list of school saved by user should match the schools "
				+ "that are actually saved", savedSchools.contains(aSavedSchool));
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
