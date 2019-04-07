package cmc.functionalTesting;

import static org.junit.Assert.*;

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
