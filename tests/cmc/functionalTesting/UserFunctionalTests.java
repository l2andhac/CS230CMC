package cmc.functionalTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;


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
	private UserInteraction ui;
	private static DBController dbc;
	private User u;
	private University univ;
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

		foci = new ArrayList<String>();
		univ = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, 650, 650, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
	    dbc.addSchool(univ);

		deactUser = new User("Dummy", "Dempsey", "deactUser", "password", 'N');
		dbc.addAccount(deactUser);
		foci2 = new ArrayList<String>();
		foci2.add("ENGINEERING");
		univ = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(univ);
	}
	
	@After
	public void tearDown() throws Exception {
		foci = new ArrayList<String>();
		dbc.removeSchool(univ);
		dbc.removeAccount("DummyUser");
		dbc.removeAccount("DummyUser");
		dbc.removeAccount("deactUser");
		List<String> foci = new ArrayList<String>();

		if (dbc.findSchoolName(univ.getSchoolName()) == true) {
			univ = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500,
					95.0, 70.0, 2, 1, 1, foci);
			dbc.editSchool(univ);
			dbc.removeSchool(univ);
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
	public void testSearchSchoolSuccess() {
		Set<University> actual = ui.searchSchool("Carleton College", "FOREIGN", "URBAN", "STATE", 8000,8000, 30, 30, -1, -1, -1, -1, 5000, 5000, 10, 11, 10500, 10500, 95, 95, 70, 70, 2, 2, 1, 1, 1, 1, foci2);
		boolean found = false;
		for(University university: actual) {
			if(university.getSchoolName().equals(univ.getSchoolName()))
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
	public void testSearchSchoolNoMatches() {
		fail("Not yet implemented");
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
	public void testViewSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareSavedSchools() {
		List<University> schoolsToCompare = ui.compareSavedSchools(univ.getSchoolName());
		boolean contains = false;
		for(University s: schoolsToCompare) {
			if(s.getSchoolName().equals("BETHEL UNIVERSITY") || s.getSchoolName().equals("AUBURN")) {
				contains = true;
			}
			else {
				contains = false;
			}
		}
		assertTrue("The list should contain Bethel University and Auburn", contains);
	}

	@Test
	public void testShowRecSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAccountInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditAccountInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSchoolDetails() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testForgotPassword() {
		fail("Not yet implemented");
	}

}
