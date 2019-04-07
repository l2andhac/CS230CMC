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
		dbc.removeAccount("DummyUser");
		dbc.removeAccount("deactUser");
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
		Set<University> actual = ui.searchSchool("Carleton College", "FOREIGN", "URBAN", "STATE", 8000,8000, 30, 30, -1, -1, -1, -1, 5000, 5000, 10, 11, 10500, 10500, 95, 95, 70, 70, 2, 2, 1, 1, 1, 1, foci2);
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
	@Test
	public void testCompareSavedSchoolsUserOnlyHasOneSavedSchool() {
		List<University> schoolsToCompare = ui.compareSavedSchools(null);
		boolean found = false;
		for(University s: schoolsToCompare) {
			if(s.getSchoolName().equals("AUBURN")) {
				found = true;
		}
		}
		assertTrue("The list should contain only Auburn", schoolsToCompare.size() == 1 && found);
	}
	
	@Test
	public void testShowRecSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAccountInfo() {
		ui.logOn("DummyUser", "password");
		assertTrue("user can view their info",ui.viewAccountInfo().equals(u.toString()));
		ui.logOff();
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
		assertTrue("user can request new account",accInt.requestNewAccount("Dummy", "Hoeschen", "dummyHoeschen", "password"));
		dbc.removeAccount("dummyHoeschen");
	}
	
	@Test
	public void testRequestNewAccountAlreadyTaken() {
		assertFalse("user cannnot request new account",accInt.requestNewAccount("Dummy", "Jordre", "DummyUser", "Password"));
	}

	@Test
	public void testForgotPassword() {
		fail("Not yet implemented");
	}

}
