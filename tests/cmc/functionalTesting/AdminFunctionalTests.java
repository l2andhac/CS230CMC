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

import cmc.controller.AdminFunctionalityController;
import cmc.controller.DBController;
import cmc.entity.Admin;
import cmc.entity.University;
import cmc.entity.User;
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
		List<String> foci = new ArrayList<String>();
		ai.addSchool("AA DUMMY SCHOOL", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		University u = new University("AA DUMMY SCHOOL", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		assertTrue("The school AA DUMMY SCHOOL has been added to the database", dbc.findSchoolName("AA DUMMY SCHOOL"));
		dbc.removeSchool(u);
	}
		

	@Test
	public void testEditSchool() {
		University univ = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 20000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, null);
		boolean added = dbc.addSchool(univ);
		int oldNumOfStudents = univ.getNumStudents();
		String oldLocation = univ.getLocation();
		
		ai.editSchool("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "SUBURBAN", "STATE", 5000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1);
		University uni2 = dbc.getSchool("UNIVERSITE DE OUAGADOUGOU");
		int newNumOfStudents = uni2.getNumStudents();
		String newLocation = uni2.getLocation();
		
		assertFalse("The school has been edited and the number of students has changed", newNumOfStudents==oldNumOfStudents);
		assertFalse("The school has been edited and the location has changed", oldLocation.equals(newLocation));
		dbc.removeSchool(univ);
	}

	@Test
	public void testViewAllSchools() {
		Set<University> allSchools = ai.viewAllSchools();
		int expectedSize = dbc.getTotalNumberOfSchools();
		assertTrue("There should be " + expectedSize + " schools in the database", allSchools.size() == expectedSize);
		List<String> foci = new ArrayList<String>();
		University u = new University("DummySchool", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbc.addSchool(u);
		allSchools = ai.viewAllSchools();
		assertTrue("There should be " + (expectedSize + 1) + " schools in the database", allSchools.size() == expectedSize + 1);
		boolean found = false;
		for (University uni:allSchools) {
			if (uni.equals(u)) {
				found = true;
			}
		}
		assertTrue("DummySchool should be found", found == true);
		dbc.removeSchool(u);
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
	public void testEditAccountInfoForUser() {
		User u = new User("Steffi", "Tapsoba", "suser", "password", 'Y');
		dbc.addAccount((User) u);
		User user1 = (User) dbc.findAccount("suser");
		ai.editAccountInfo("suser", "Ettel", "Tapsoba", "password2", 'u', 'Y');
		User user2 = (User) dbc.findAccount("suser");
		assertFalse("The first name of the user suser has been edited", user1.getFirstName().equals(user2.getFirstName()));
		assertFalse("The password of the user suser has been edited", user1.getPassword().equals(user2.getPassword()));
		dbc.removeAccount("suser");
		

	}
	
	
	@Test
	public void testEditAccountInfoForAdmin() {
		Admin ad = new Admin("Rinsinda", "Lene", "radmin", "password", 'N');
		dbc.addAccount((Admin) ad);
		Admin admin1 = (Admin) dbc.findAccount("radmin");
		ai.editAccountInfo("radmin", "Rinsinda", "Tapsoba", "password", 'a', 'Y');
		Admin admin2 = (Admin) dbc.findAccount("radmin");
		assertFalse("The last name of the admin radmin has been edited", admin1.getLastName().equals(admin2.getLastName()));
		assertFalse("The status of the admin radmin has been edited", admin1.getStatus()==admin2.getStatus());
		dbc.removeAccount("radmin");

	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidType() {
		User u = new User("Dolen", "Lene", "duser", "password", 'Y');
		dbc.addAccount((User) u);
		ai.editAccountInfo("duser", "Dolen", "Lene", "password", 's', 'Y');
		
		dbc.removeAccount("duser");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditAccountInfoFailsForInvalidStatus() {
		User u = new User("Winnie", "Tapsoba", "wuser", "password", 'Y');
		dbc.addAccount((User) u);
		ai.editAccountInfo("wuser", "Winnie", "Tapsoba", "password", 'u', 'X');

		dbc.removeAccount("wuser");

	}
	

	@Test
	public void testViewSchoolDetails() {
		List<String> foci = new ArrayList<String>();
		University u = new University("DummySchool", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbc.addSchool(u);
		University retU = ai.viewSchoolDetails(u.getSchoolName());
		assertTrue("Schools should be equal", u.equals(retU));
		dbc.removeSchool(u);
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
