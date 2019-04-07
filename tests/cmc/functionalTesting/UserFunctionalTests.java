package cmc.functionalTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.controller.DBController;
import cmc.entity.Admin;
import cmc.entity.Search;
import cmc.entity.University;
import cmc.entity.User;
import cmc.interaction.AdminInteraction;
import cmc.interaction.UserInteraction;

public class UserFunctionalTests {
	private UserInteraction ui;
	private static DBController dbc;
	private User u;
	private University univ;
	private ArrayList<String> foci;
	
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
		foci = new ArrayList<String>();
		univ = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, 650, 650, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
	    dbc.addSchool(univ);
	}
	
	@After
	public void tearDown() throws Exception {
		foci = new ArrayList<String>();
		dbc.removeSchool(univ);
		dbc.removeAccount("DummyUser");
	}

	@Test
	public void testSearchForFriends() {
		fail("Not yet implemented");
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
		ui.logOn("DummyUser", "Password");
		ui.logOff();
		assertFalse("User should be logged off", u.isLoggedOn());
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
