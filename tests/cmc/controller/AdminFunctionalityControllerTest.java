package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Admin;
import cmc.entity.University;
import cmc.entity.User;

public class AdminFunctionalityControllerTest {

	private static AdminFunctionalityController afc;
	private static DBController dbc;
	private University univ1, univ2;
	List<String> foci1, foci2;
	
	@BeforeClass
	public static void beforeTest() throws Exception{
		afc = new AdminFunctionalityController();
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		User u = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		dbc.addAccount(u);
		Admin a = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
		dbc.addAccount(u);
		
		foci1 = new ArrayList<String>();
		//foci2.add("BUSINESS-ADMINISTRATION");
		this.univ1 = new University("UNIVERSITE DE BOBO", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci1);
		foci2 = new ArrayList<String>();
		dbc.addSchool(univ1);
		foci2.add("BUSINESS-ADMINISTRATION");
		this.univ2 = new University("UNIVERSITE I2E", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(univ2);
		
		//.......
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeAccount("dummyUser");
		dbc.removeAccount("dummyAdmin");
		dbc.removeSchool(this.univ2);
		//......
	}

	@Test
	public void testAdminFunctionalityController() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		afc.removeSchool("UNIVERSITE DE BOBO");
		boolean removed = dbc.findSchoolName("UNIVERSITE DE BOBO");
		assertTrue("The school has been successfully removed", 
				 removed == false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveSchoolSavedByUser() {
		afc.removeSchool("STANFORD");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveSchoolWithEmphasis() {
		afc.removeSchool("UNIVERSITE I2E");
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchoolInfo() {
		fail("Not yet implemented");
	}

	public void testViewAllSchoolsNumberOfSchools() {
		Set<University> allSchools = afc.viewAllSchools();
		assertTrue("The number of schools in the databse should be: " + dbc.getTotalNumberOfSchools(),allSchools.size() == dbc.getTotalNumberOfSchools());
	}
	
	@Test
	public void testViewAllSchools() {
		Set<University> allSchools = afc.viewAllSchools();
		University univ = afc.viewSchoolDetails("AUBURN");
		assertTrue("AUBURN should be one of the Unviersities viewed", allSchools.contains(univ));
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
