package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.SavedSchool;
import cmc.entity.University;
import cmc.entity.User;
import cmc.entity.Admin;
import cmc.entity.Account;
import cmc.controller.DBController;
import cmc.controller.SearchController;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
	
	private static UniversityDBLibrary univDBlib;
	  // instance variable for a searchController
	private SearchController searchController;
	private static DBController dbc;
	List<String> foci2;
	Admin admin;
	User user;
	University u, u2;
	SavedSchool s;
	User dummy;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		univDBlib = new UniversityDBLibrary("l2andhac", "CSCI230");
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		
		//makes University without a focus
		foci2 = new ArrayList<String>();
		u = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		boolean added = dbc.addSchool(u);
		user = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		admin = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
		
		//makes University with a focus
		foci2.add("ENGINEERING");
		u2 = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(u2);
		
		//makes new User
		dummy = new User("Dummy", "Will", "dummyUser2", "password", 'Y');
		dbc.addAccount(dummy);
		
		
	}

	@After
	public void tearDown() throws Exception {
		dbc.removeSchool(u);
		dbc.removeAccount("dummyAdmin");
		dbc.removeAccount("dummyUser");
		dbc.removeSchool(u2);
		dbc.removeAccount("dummyUser2");
	}

	@Test
	public void testDBController() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditSchool() {
		foci2.add("BUSINESS-ADMINISTRATION");
		University originalUniversity = dbc.getSchool("UNIVERSITE DE OUAGADOUGOU");
		University modifiedUniversity = new University("UNIVERSITE DE OUAGADOUGOU", "FOREIGN", "URBAN", "STATE", 10000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.editSchool(modifiedUniversity); //modified number of students from 8000 to 10000, with foci2 BUSINESS-ADMINISTRATION
		University newUniversity = dbc.getSchool("UNIVERSITE DE OUAGADOUGOU");
		assertFalse("the original school AUGSBURG is different from the modified school AUGSBURG which "
				+ "now have 8000 students instead of 10000", originalUniversity.equals(newUniversity));
	}

	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSchoolSaved() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountAdminFound() {
		dbc.addAccount(admin);
		Admin actual = (Admin)dbc.findAccount("dummyAdmin");
		assertTrue("The account found is the correct admin,", 
				actual.equals(admin));
	}
	
	@Test
	public void testFindAccountUserFound() {
		dbc.addAccount(user);
		Account actual = dbc.findAccount("dummyUser");
		assertTrue("The account found is the correct user,", 
				actual.equals(user));
	}
	
	@Test
	public void testFindAccountFails() {
		Account actual = dbc.findAccount("kate");
		assertTrue("The account does not exist, so a null account"
				+ "is returned", actual == null);
	}

	@Test
	public void testGetAllSchools() {
		AdminFunctionalityController afc = new AdminFunctionalityController();
		Set<University> allSchools = dbc.getAllSchools();
		University univ = afc.viewSchoolDetails("AUBURN");
        assertTrue("AUBURN should be one of the Unviersities in the set", allSchools.contains(univ));
	}

	@Test
	public void testRemoveSavedSchool() {
		
		SavedSchool s = new SavedSchool(u2, "time");	
		dbc.addSavedSchool(user, s);
		List<SavedSchool> saved = new ArrayList<SavedSchool>();
		saved.add(s);
		dbc.removeSavedSchool(user, "BETHEL UNIVERSITY");
		List<SavedSchool> list = dbc.getSavedSchools(user);
		assertTrue("The saved school has been successfully removed", list.contains(s)==false);
	}

	@Test
	public void testGetSavedSchools() {

		//tests user with 1 or more SavedSchool with emphases
		//makes u2 a SavedSchool
	    SavedSchool s = new SavedSchool(u2, "time");	
		//add u2to dummy's list
		dbc.addSavedSchool(dummy, s);
		List<SavedSchool> saved = new ArrayList<SavedSchool>();
		saved.add(s);
		assertTrue("The list of dummy's SavedSchools should match list 'saved'", dbc.getSavedSchools(dummy).contains(s));
		dbc.removeSavedSchool(dummy, "BETHEL UNIVERSITY");
	}

	@Test
	public void testFindSchoolName() {
		fail("Not yet implemented");
		
		
		
		
		
		
	}

	@Test
	public void testFindSearchedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeAccountFirstName() {
		dbc.addAccount(user);
		user.setFirstName("newDummy");
		dbc.changeAccount(user);
		assertTrue("The first name is now changed for the user",
				user.getFirstName().equals("newDummy"));
	}
	
	@Test
	public void testChangeAccountLastName() {
		dbc.addAccount(user);
		user.setLastName("Rothstein");
		dbc.changeAccount(user);
		assertTrue("The last name is now changed for the user",
				user.getLastName().equals("Rothstein"));
	}
	
	@Test
	public void testChangeAccountPassword() {
		dbc.addAccount(admin);
		admin.setPassword("123455");
		dbc.changeAccount(admin);
		assertTrue("The password is now changed for the admin",
				admin.getPassword().equals("123455"));
	}
	
	@Test
	public void testChangeAccountStatus() {
		dbc.addAccount(admin);
		admin.setStatus('N');
		dbc.changeAccount(admin);
		//assertTrue("The status is now changed for the admin",
				//admin.getSatus().equals('N'));
	}

	@Test
	public void testHasEmphasis() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAccount() {
	    Account account = new Account ("Dummy", "WillAgain", "anotherDummy", "password", 'a','Y');
	    dbc.addAccount(account);
	    assertTrue("account is in the database", dbc.viewAllAccounts().contains(account.getUsername()));
	    dbc.removeAccount("anotherDummy");
	}

	@Test
	public void testRequestNewAccount() {
		User user = new User ("Dummy", "WillAgain", "anotherDummy", "password", 'p');
	    dbc.addAccount(user);
	    assertTrue("account is in the database", dbc.viewAllAccounts().contains(user.getUsername()));
	    dbc.removeAccount("anotherDummy");

	}

	@Test
	public void testGetTotalNumberOfSchools() {
		int actualNumOfSchool = 186; //actually it is 185 but since I added "UNIVERSITE OF OUAGADOUGOU" in the test class it is 186
		int testNumOfSchool = dbc.getTotalNumberOfSchools();
		assertTrue("The method should return a total of "+actualNumOfSchool+" schools.", actualNumOfSchool == testNumOfSchool);
	}

	@Test
	public void testFindRecSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testBubbleSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindDistance() {
		double calculatedDistance = Math.round(2.597544927);
		University univ1 = dbc.getSchool("NEWYORK IT");
		University univ2 = dbc.getSchool("BARD");
		double cmcDistance = Math.round(dbc.findDistance(univ1, univ2));
		assertTrue("The distance between NEWYORK IT and BARD should"
				+ " be "+calculatedDistance+".", calculatedDistance==cmcDistance );
	}

	@Test
	public void testGetEmphases() {
		assertTrue("BETHEL UNIVERSITY contains the emphasis ENGINEERING", dbc.getEmphases(u2).contains("ENGINEERING"));
		//fail("Not yet implemented");
	}

}
