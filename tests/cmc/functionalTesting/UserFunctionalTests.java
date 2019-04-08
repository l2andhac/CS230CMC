package cmc.functionalTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;
import java.util.TreeMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.controller.DBController;
import cmc.entity.Admin;
import cmc.entity.Search;
import cmc.entity.SavedSchool;
import cmc.entity.University;
import cmc.entity.User;
import cmc.interaction.AccountInteraction;
import cmc.interaction.AdminInteraction;
import cmc.interaction.UserInteraction;

public class UserFunctionalTests {
	private UserInteraction ui, uie;
	private static DBController dbc;
	private User u, ue;
	private University univ;
	private University univ1;
	private ArrayList<String> foci;
	private static AccountInteraction accInt;
	private User deactUser;
	private ArrayList<String> foci2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbc = new DBController();
		accInt = new AccountInteraction();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		u = new User("Dummy", "Jordre", "DummyUser", "Password", 'Y');
		ui = new UserInteraction(u);
		dbc.addAccount(u);
		
		ue = new User("Dummy", "Bear", "DummyUser@email.com", "Password", 'Y');
		dbc.addAccount(ue);

		foci = new ArrayList<String>();
		univ = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, 650, 650, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
	    dbc.addSchool(univ);

		deactUser = new User("Dummy", "Dempsey", "deactUser", "password", 'N');
		dbc.addAccount(deactUser);
		foci2 = new ArrayList<String>();
		foci2.add("ENGINEERING");
		univ1 = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(univ1);
	}
	
	@After
	public void tearDown() throws Exception {
		foci = new ArrayList<String>();
		dbc.removeSchool(univ);
		dbc.removeAccount("DummyUser");
		dbc.removeAccount("deactUser");
		dbc.removeAccount("DummyUser@email.com");
		List<String> foci = new ArrayList<String>();

		if (dbc.findSchoolName(univ.getSchoolName()) == true) {
			univ1 = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500,
					95.0, 70.0, 2, 1, 1, foci);
			dbc.editSchool(univ1);
			dbc.removeSchool(univ1);
		}
	}

	@Test
	public void testSearchForFriends() {
		User u2 = new User("Dummy", "Worm", "DummyUserSS", "Password", 'Y');
		dbc.addAccount(u2);
		List<String> foci = new ArrayList<String>();
		University univ = new University("AA DUMMY SCHOOL", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbc.addSchool(univ);
		SavedSchool s = new SavedSchool(univ, "");	
		dbc.addSavedSchool(u2, s);
		List<SavedSchool> saved = ui.searchForFriends("DummyUserSS");
		List<SavedSchool> list = dbc.getSavedSchools(u2);
		assertTrue("The two lists should contain the same schools", saved.get(0).equals(list.get(0)));
		dbc.removeSavedSchool(u2, "AA DUMMY SCHOOL");
		dbc.removeSchool(univ);
		dbc.removeAccount("DummyUserSS");
	}
	
	@Test
	public void testSearchForFriendsFriendDoesNotExist() {
		assertTrue("When a User tries to search for a friend that doesn't exist, return null", ui.searchForFriends("nothing")==null);
	}

	@Test
	public void testRequestDeactivation() {
		ui.requestDeactivation();
		User foundUser = (User) dbc.findAccount("DummyUser");
		assertTrue("The user's status in the database should be /'D/'", foundUser.getStatus() == 'D');
		assertTrue("The user objects status should be /'D/'", u.getStatus() == 'D');
	}

	//Come back to this one :)
	@Test
	public void testSearchSchool() {
		Set<University> matches = ui.searchSchool("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8001, 7999, 31, 29, 700, 600, 700, 600, 5001, 4999, 11, 9, 11000, 10000, 96, 94, 71, 69, 3, 1, 5, 1, 5, 1,foci);
		boolean isMatch = false;
		for(University s: matches) {
			if(s.getSchoolName().equals("BETHEL UNIVERSITY")) {
				isMatch = true;
			}
			
		}
		assertTrue("Bethel University should be the only school to match the search criteria", matches.size() == 1 && isMatch);
	}
	
	@Test
	public void testSearchSchoolNoMatch() {
		Set<University> matches = ui.searchSchool("BETHELLLLLLLLL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8001, 7999, 31, 29, 700, 600, 700, 600, 5001, 4999, 11, 9, 11000, 10000, 96, 94, 71, 69, 3, 1, 5, 1, 5, 1,foci);
		assertTrue("No school should match the search criteria", matches.size() == 0);
	}
	
	@Test
	 public void testSearchSchoolSuccess() {
		Set<University> actual = ui.searchSchool("Carleton College", "FOREIGN", "URBAN", "STATE", 8001, 7999, 31, 29, 700, 600, 700, 600, 5001, 4999, 11, 9, 11000, 10000, 96, 94, 71, 69, 3, 1, 5, 1, 5, 1,foci2);
		boolean found = false;
		for(University university: actual) {
			if(university.getSchoolName().equals(univ1.getSchoolName()))
				found = true;
		}
		assertTrue("The searched for school was found", found);
	}
	
	
	@Test
	public void testSearchSchoolNoFieldsFilledOut() {
		Set<University> actual = ui.searchSchool("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, null);
		assertTrue("No fields were filled out so the search returns a null list", actual == null);
	}
	

	@Test
	public void testSortResultsExpenses() {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
	    Set<University> listOfMatches = ui.searchSchool("","CALI", "URBAN", "STATE", 60000, 5000, 60, 25, -1, -1, -1, 
	    		  -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	    
	    List<University> list = ui.sortResults(listOfMatches, 'e');
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
	
	public void testSortResultsAdmission() {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
	    Set<University> listOfMatches = ui.searchSchool("","CALI", "URBAN", "STATE", 60000, 5000, 60, 25, -1, -1, -1, 
	    		  -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	    
	    List<University> list = ui.sortResults(listOfMatches, 'a');
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
	
	public void testSortResultsNumberOfStudents() {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
	    Set<University> listOfMatches = ui.searchSchool("","CALI", "URBAN", "STATE", 60000, 5000, 60, 25, -1, -1, -1, 
	    		  -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	    
	    List<University> list = ui.sortResults(listOfMatches, 'n');
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
		ui.logOn("DummyUser", "Password");
		ui.saveSchool(univ);
		List<SavedSchool> list = ui.viewSavedSchools();
		boolean isMatch = false;
		for(SavedSchool s: list) {
			if(s.getSchoolName().equals(univ.getSchoolName())) {
				isMatch = true;
			}
			
		}
		assertTrue("the school was added",isMatch);
		ui.removeSavedSchool(univ.getSchoolName());
		ui.logOff();
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSaveSchoolAlreadySaved() {
		ui.logOn("DummyUser", "Password");
		ui.saveSchool(univ);
		ui.saveSchool(univ);
		ui.logOff();
		ui.removeSavedSchool(univ.getSchoolName());
	}

	@Test
	public void testRemoveSavedSchool() {
		University u1 = dbc.getSchool("NOTRE DAME");
		University u2 = dbc.getSchool("UNIVERSITE SAINT JOSEPH");
		University u3 = dbc.getSchool("BARD");
		SavedSchool s1 = new SavedSchool(u1, "time");
		SavedSchool s2= new SavedSchool(u2, "time");
		SavedSchool s3 = new SavedSchool(u3, "time");
		dbc.addSavedSchool(u, s1);
		dbc.addSavedSchool(u, s2);
		dbc.addSavedSchool(u, s3);
		
		boolean found = false;
		for (SavedSchool saved: dbc.getSavedSchools(u)) {
			if(s2.equals(saved)) {
				found = true;
			}
		}
		assertTrue("UNIVERSITE SAINT JOSEPH is in the list of saved schools by the user DummyUser", found==true);
		ui.removeSavedSchool("UNIVERSITE SAINT JOSEPH");
		boolean removed = true;
		for (SavedSchool saved: dbc.getSavedSchools(u)) {
			if(s2.equals(saved)) {
				removed = false;
			}
		}
	
		assertTrue("The university UNIVERSITE SAINT JOSEPH has been removed from the list of saved school of the user DummyUser", removed == true);
	}

	@Test
	public void testViewSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareSavedSchools() {
		SavedSchool ss = new SavedSchool(univ, "dummyUser");
		dbc.addSavedSchool(u, ss);
		List<University> schoolsToCompare = ui.compareSavedSchools(univ.getSchoolName());
		int count = 0;
		for(University s: schoolsToCompare) {
			if(s.getSchoolName().equals("BETHEL UNIVERSITY") || s.getSchoolName().equals("AUBURN")) {
				count++;
			}
		}
		assertTrue("The list should contain Bethel University and Auburn", count == 2);
		dbc.removeSavedSchool(u, "BETHEL UNIVERSITY");
	}

	//Do we still want Auburn hard-coded in?
	@Test (expected = IllegalArgumentException.class)
	public void testCompareSavedSchoolsUserOnlyHasOneSavedSchool() {
		List<University> schoolsToCompare = ui.compareSavedSchools(null);
		/*boolean found = false;
		for(University s: schoolsToCompare) {
			if(s.getSchoolName().equals("AUBURN")) {
				found = true;
		}
		}
		assertTrue("The list should contain only Auburn", schoolsToCompare.size() == 1 && found);*/
	}
	
	@Test
	public void testShowRecSchools() {
		TreeMap<Double, String> distanceMap = (TreeMap<Double, String>) ui.showRecSchools("BARD");
		assertTrue("the 1st top reccomended school is correct", distanceMap.get(0.9187483974528865).equals("CLARKSON UNIVERSITY"));
		assertTrue("the 2nd top reccomended school is correct", distanceMap.get(1.6593616556037012).equals("VASSAR"));
		assertTrue("the 3rd top reccomended school is correct", distanceMap.get(2.0355617927803262).equals("COLLEGE OF NEWROCHELLE"));
		assertTrue("the 4th top reccomended school is correct", distanceMap.get(2.15830527289677).equals("HAMPSHIRE COLLEGE"));
		assertTrue("the 5th top reccomended school is correct", distanceMap.get(2.1765192224298806).equals("TOURO"));
		assertTrue("the size of the map should be 5", distanceMap.keySet().size() == 5);
	}

	@Test
	public void testViewAccountInfo() {
		ui.logOn("DummyUser", "Password");
		assertTrue("user can view their info",ui.viewAccountInfo().equals(u.toString()));
		ui.logOff();
	}

	@Test
	public void testEditAccountInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSchoolDetails() {
		List<String> foci = new ArrayList<String>();
		University u = new University("DummySchool", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbc.addSchool(u);
		University retU = ui.viewSchoolDetails(u.getSchoolName());
		assertTrue("Schools should be equal", u.equals(retU));
		dbc.removeSchool(u);
	}

	@Test
	public void testLogOff() {
		ui.logOn("DummyUser", "Password");
		ui.logOff();
		assertFalse("User should be logged off", u.isLoggedOn());
	}

	@Test
	public void testLogOnSuccess() {
		UserInteraction actual = (UserInteraction) accInt.logOn("DummyUser", "Password");
		assertTrue("Admin has successfully logged on", actual.getUsername().equals("DummyUser"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnInvalidUsername() {
		UserInteraction actual = (UserInteraction) accInt.logOn("Kate", "password");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnInvalidPassword() {
		UserInteraction actual = (UserInteraction) accInt.logOn("DummyUser", "kate");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLogOnDeactivatedUser() {
		UserInteraction actual = (UserInteraction) accInt.logOn("deactUser", "password");
	}

	@Test
	public void testRequestNewAccount() {
		assertTrue("user can request new account",accInt.requestNewAccount("Dummy", "Hoeschen", "dummyHoeschen", "password"));
		dbc.removeAccount("dummyHoeschen");
	}
	
	@Test  (expected = IllegalArgumentException.class)
	public void testRequestNewAccountAlreadyTaken() {
		assertFalse("user cannnot request new account",accInt.requestNewAccount("Dummy", "Jordre", "DummyUser", "Password"));
	}

	@Test
	public void testForgotPassword() {
		assertTrue("A user with an email can correctly receive a new password if they forgot theirs", ui.forgotPassword("DummyUser@email.com"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForgotPasswordNoEmail() {
		ui.forgotPassword("DummyUser");
	}

}
