package cmc.functionalTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
import cmc.interaction.AdminInteraction;
import cmc.interaction.UserInteraction;

public class UserFunctionalTests {
	private UserInteraction ui;
	private static DBController dbc;
	private User u;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbc = new DBController();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		u = new User("Dummy", "Jordre", "DummyUser", "Password", 'Y');
		ui = new UserInteraction(u);
		dbc.addAccount(u);
	}
	@After
	public void tearDown() throws Exception {
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
	public void testSearchSchool() {
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
	public void testLogOn() {
		fail("Not yet implemented");
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
