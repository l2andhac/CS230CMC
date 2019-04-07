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
	private static AccountInteraction accInt;
	private User deactUser;
	private University univ;
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
		deactUser = new User("Dummy", "Dempsey", "deactUser", "password", 'N');
		dbc.addAccount(deactUser);
		foci2 = new ArrayList<String>();
		foci2.add("ENGINEERING");
		univ = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(univ);
	}
	@After
	public void tearDown() throws Exception {
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

	@Test
	public void testSearchSchoolSuccess() {
		Set<University> actual = ui.searchSchool("Carleton College", "FOREIGN", "URBAN", "STATE", 8000,8000, 30, 30, -1, -1, -1, -1, 5000, 5000, 10, 11, 10500, 10500, 95, 95, 70, 70, 2, 2, 1, 1, 1, 1, foci2);
		assertTrue("The searched for school was found", actual.contains(univ));
	}
	
	@Test
	public void testSearchSchoolNoFieldsFilledOut() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
