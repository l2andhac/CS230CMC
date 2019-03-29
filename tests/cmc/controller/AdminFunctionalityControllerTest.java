package cmc.controller;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Admin;
import cmc.entity.University;
import cmc.entity.User;

public class AdminFunctionalityControllerTest {

	private AdminFunctionalityController afc;
	private DBController dbc;
	
	@BeforeClass
	public void beforeTest() throws Exception{
		afc = new AdminFunctionalityController();
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		User u = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(u);
		Admin a = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
		dbc.addAccount(u);
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeAccount("dummyAdmin");
		//......
	}

	@Test
	public void testAdminFunctionalityController() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchoolInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllSchoolsNumberOfSchools() {
		Set<University> allSchools = dbc.viewAllSchools();
		assertTrue("The number of schools in the databse should be: " + dbc.getTotalNumberOfSchools(),allSchools.size() == dbc.getTotalNumberOfSchools());
	}
	
	@Test
	public void testViewAllSchools() {
		Set<University> allSchools = dbc.viewAllSchools();
		University univ = afc.viewSchoolDetails("AUBURN");
		assertTrue("AUBURN should be one of the Unviersities viewed", allSchools.contains(univ);
	}

	@Test
	public void testViewAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAccount() {
		fail("Not yet implemented");
	}

}
