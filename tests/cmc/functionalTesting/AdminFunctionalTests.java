package cmc.functionalTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.controller.AdminFunctionalityController;
import cmc.controller.DBController;
import cmc.entity.Admin;
import cmc.interaction.AdminInteraction;

public class AdminFunctionalTests {

	private AdminInteraction ai;
	private static DBController dbc;
	private Admin a;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbc = new DBController();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		a = new Admin("Dummy", "Jordre", "DummyAdmin", "Password", 'Y');
		ai = new AdminInteraction(a);
		dbc.addAccount(a);
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("DummyAdmin");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
		//List<String> foci = new ArrayList<String>();
		//ai.addSchool("AA DUMMY SCHOOL", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		//assertTrue("The school AA DUMMY SCHOOL has been added to the database", dbc.findSchoolName("AA DUMMY SCHOOL"));
		//there is no way to get the school to remove so removeSchool in dbc either needs to take a string,
		//or addSchool has to return the school it adds
		//dbc.removeSchool();
	}
		

	@Test
	public void testEditSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAccount() {
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
	public void testForgotPassword() {
		fail("Not yet implemented");
	}

}
