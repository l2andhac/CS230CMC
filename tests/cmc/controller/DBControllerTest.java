package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.*;
import cmc.controller.*;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
	
	private static UniversityDBLibrary univDBlib;
	  // instance variable for a searchController
	private SearchController searchController;
	private static DBController dbc;
	private Search search;

	List<String> foci, foci2;

	private Admin admin, admin2;
	private User user, user2;
	private University u, u2;
	private SavedSchool s;
	private User dummy;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		univDBlib = new UniversityDBLibrary("l2andhac", "csci230");
		dbc = new DBController();
	}
	
	@Before
	public void setUp() throws Exception {
		
		//makes University without a focus
		foci = new ArrayList<String>();
		u = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		boolean added = dbc.addSchool(u);
		user = new User("Dummy", "Jordre", "dummyUser", "password", 'Y');
		admin = new Admin("Dummy", "Jordre", "dummyAdmin", "password", 'Y');
		dbc.addAccount(user);
		dbc.addAccount(admin);
		foci2 = new ArrayList<String>();

		foci2.add("ENGINEERING");
		u2 = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.addSchool(u2);
		s = new SavedSchool(u2, "time");
		
		//makes new User
		dummy = new User("Dummy", "Will", "dummyUser2", "password", 'Y');
		dbc.addAccount(dummy);
		

	}

	@After
	public void tearDown() throws Exception {
		dbc.removeSavedSchool(user, u.getSchoolName());
		dbc.removeSavedSchool(user, u2.getSchoolName());

		foci = new ArrayList<String>();

		if (dbc.findSchoolName(u.getSchoolName()) == true) {
			u = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500,
					95.0, 70.0, 2, 1, 1, foci);
			dbc.editSchool(u);
			dbc.removeSchool(u);
		}
		dbc.removeAccount("dummyAdmin");
		dbc.removeAccount("dummyUser");
		if (dbc.findSchoolName(u2.getSchoolName()) == true) {
			u2 = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5,
					10500, 95.0, 70.0, 2, 1, 1, foci);
			dbc.editSchool(u2);
			dbc.removeSchool(u2);
		}
		dbc.removeAccount("dummyUser2");
	}


	@Test
	public void testEditSchool() {
		foci2.add("BUSINESS-ADMINISTRATION");
		University originalUniversity = dbc.getSchool(u.getSchoolName());
		University modifiedUniversity = new University(u.getSchoolName(), "MINNESOTA", "URBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci2);
		dbc.editSchool(modifiedUniversity); //modified number of students from 8000 to 10000, with foci2 BUSINESS-ADMINISTRATION
		University newUniversity = dbc.getSchool(u.getSchoolName());
		assertFalse("the original school is different from the modified school which "
				+ "now have 8000 students instead of 10000", originalUniversity.equals(newUniversity));
		assertTrue("the new school should be in minnesota", newUniversity.getState().equals("MINNESOTA"));
		assertTrue("the original school should be foreign", newUniversity.getState().equals("MINNESOTA"));
	}
	
	@Test
	public void testEditSchoolToAddAndRemoveEmphases() {
		foci.add("ENGINEERING");
		foci.add("LIBERAL ARTS");
		foci.add("COMPUTER SCIENCE");
		u = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbc.editSchool(u);
		University retU = dbc.getSchool(u.getSchoolName());
		assertTrue("Emphases should include engineering", retU.getEmphases().contains("ENGINEERING"));
		assertTrue("Emphases should include liberal arts", retU.getEmphases().contains("LIBERAL ARTS"));
		assertTrue("Emphases should include computer science", retU.getEmphases().contains("COMPUTER SCIENCE"));
		foci = new ArrayList<String>();
		u = new University("Carleton College", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbc.editSchool(u);
		retU = dbc.getSchool(u.getSchoolName());
		assertTrue("Emphases should be empty", retU.getEmphases().size() == 0);
	}

	@Test
	public void testAddSchoolForUniqueName() {
		List<String> l = new ArrayList<String>(); 
		University u3 = new University("HAMLINE UNIVERSITY", "FOREIGN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, l);
		assertTrue("School should be added", dbc.addSchool(u3));
		dbc.removeSchool(u3);
	}
	
	@Test
	public void testAddSchoolForTakenSchoolName() {
		assertFalse("School should not be added", dbc.addSchool(u));
	}

	@Test
	public void testRemoveSchoolWithEmphasis() {
		dbc.removeSchool(u2);
		assertTrue("University should not be removed", dbc.findSchoolName("BETHEL UNIVERSITY"));
	}

	@Test
	public void testRemoveSchoolWithSavedSchool() {
		s = new SavedSchool(u, "time");
		dbc.addSavedSchool(dummy, s);
		dbc.removeSchool(u);
		assertTrue("University should not be removed", dbc.findSchoolName("Carleton College"));
		dbc.removeSavedSchool(dummy, "Carleton College");
	}
	
	@Test
	public void testRemoveSchoolWithoutSavedSchool() {
		dbc.removeSchool(u);
		assertFalse("University should be removed", dbc.findSchoolName("Carleton College"));
	}
	
	@Test
	public void testIsSchoolSavedForTrue() {
		dbc.addSavedSchool(user,  s);
		assertTrue("School should be saved", dbc.isSchoolSaved(s));
	}
	
	@Test
	public void testIsSchoolSavedForFalse() {
		assertFalse("School should not be saved", dbc.isSchoolSaved(u));
	}

	@Test
	public void testGetAllSchoolsNumberOfSchools() {
		Set<University> allSchools = dbc.getAllSchools();
		int numSchools = dbc.getTotalNumberOfSchools();
		assertTrue("The number of schools in the databse should be: " + numSchools,allSchools.size() == numSchools);
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
		Account actual = dbc.findAccount(user.getUsername());
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
		University univ = dbc.getSchool("AUBURN");
		boolean found = false;
		for (University u:allSchools) {
			if(u.equals(univ)) {
				found = true;
			}
		}
        assertTrue("AUBURN should be one of the Unviersities in the set", found);
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

		//tests user with 1 or more SavedSchool
		//makes u2 a SavedSchool
	    SavedSchool s = new SavedSchool(u, "");	
		//add u2to dummy's list
		dbc.addSavedSchool(dummy, s);
		List<SavedSchool> saved = new ArrayList<SavedSchool>();
		saved.add(s);
		assertTrue("The list of dummy's SavedSchools should match list 'saved'", dbc.getSavedSchools(dummy).toString().equals(saved.toString()));
		dbc.removeSavedSchool(dummy, s.getSchoolName());
	}
	
	@Test
	public void testGetSavedSchoolsEmptyList() {
		assertFalse("The dummy has no SavedSchools", dbc.getSavedSchools(dummy).toString().equals(""));
	}

	@Test
	public void testFindSchoolName() {
		assertTrue("School name is correctly found", dbc.findSchoolName("AUBURN"));	
	}
	
	@Test
	public void testFindSchoolNameNotFound() {
		assertFalse("School name is NOT correctly found", dbc.findSchoolName("AUBURNX"));	
	}

	@Test
	public void testFindSearchedSchoolFound() {
		search = new Search("BETHEL", "MINNESOTA", "SUBURBAN", "PRIVATE", -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1,foci2);
		Set<University> s = new HashSet<University>();
		s.add(u2);
		//System.out.println(s);
		Set<University> searchedSchools = dbc.findSearchedSchool(search);
		//System.out.println(searchedSchools);
		assertTrue("School matches the search criteria", searchedSchools.toString().equals(s.toString()) && searchedSchools.size() == 1);
	}
	
	@Test
	public void testFindSearchedSchoolNotFound() {
		search = new Search("NOWHERE UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 8000, 30, 30, -1, -1, -1, -1, 5000, 5000, 11, 10, 10500, 10500, 95, 95, 70, 70, 2,2, 1, 1, 1, 1,foci2);
		Set<University> searchedSchools = dbc.findSearchedSchool(search);
		assertTrue("No school matches the search criteria", searchedSchools.size() == 0);
	}

	@Test
	public void testAddSavedSchool() {
		dbc.addSavedSchool(user, s);
		List<SavedSchool> savedList = dbc.getSavedSchools(user);
		//System.out.println(savedList);
		//System.out.println(s);
		boolean found = false;
		for(SavedSchool school:savedList) {
			if (school.toString().equals(s.toString())) {
				found = true;
			}
		}
		assertTrue("saved school was added", found);
	}

	@Test
	public void testGetSchoolNotFound() {
		assertTrue("School should not be found", dbc.getSchool("lkjjasdflsakdj") == null);
	}
	
	@Test
	public void testGetSchoolNoEmphases() {
		University retU = dbc.getSchool(u.getSchoolName());		
		assertTrue("School should be found", retU.equals(u));
	}
	
	@Test
	public void testGetSchoolWithEmphases() {
		University retU = dbc.getSchool(u2.getSchoolName());
		assertTrue("School should be found", retU.equals(u2));
		assertTrue("Emphases should match", retU.getEmphases().contains("ENGINEERING"));
	}

	@Test
	public void testViewAllAccounts() {
		Set<String> allAccounts = dbc.viewAllAccounts();
		int expectedSize = dbc.getTotalNumberOfAccounts();
		assertTrue("dummyUser should be one of the accounts viewed", allAccounts.contains("dummyUser2"));
		assertTrue("size of the set should be " + expectedSize, allAccounts.size() == expectedSize);
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
		assertTrue("The status is now changed for the admin",
				admin.getStatus()=='N');
	}
	
	@Test
	public void testChangeAccountType() {
		dbc.addAccount(admin);
		admin.setUserType('u');
		dbc.changeAccount(admin);
		assertTrue("The type is now changed for the admin to a user",
				admin.getUserType()=='u');
	}

	@Test
	public void testHasEmphasisTrue() {
		assertTrue("The university entered has an emphasis", dbc.hasEmphasis(u2));
	}
	
	@Test
	public void testHasEmphasisFalse() {
		assertFalse("The university entered does not have an emphasis", dbc.hasEmphasis(u));
	}

	@Test
	public void testFindUsernameTrue() {
		assertTrue("The username entered is a part of the database", dbc.findUsername("dummyUser"));
	}
	
	@Test
	public void testFindUsernameFalse() {
		assertFalse("The username entered is not a part of the database", dbc.findUsername("kate"));
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
		String [][] list = univDBlib.university_getUniversities(); //actually it is 185 but since I added "UNIVERSITE OF OUAGADOUGOU" in the test class it is 186
		int actual = list.length;
		int testNumOfSchool = dbc.getTotalNumberOfSchools();
		assertTrue("The method should return a total of "+actual+" schools.", actual == testNumOfSchool);
	}

        @Test
	public void testFindRecSchools() {
		TreeMap<Double, String> distanceMap = (TreeMap<Double, String>) dbc.findRecSchools("BARD");
		  
		assertTrue("the 1st top reccomended school is correct", distanceMap.get(0.9187483974528865).equals("CLARKSON UNIVERSITY"));
		assertTrue("the 2nd top reccomended school is correct", distanceMap.get(1.6593616556037012).equals("VASSAR"));
		assertTrue("the 3rd top reccomended school is correct", distanceMap.get(2.0355617927803262).equals("COLLEGE OF NEWROCHELLE"));
		assertTrue("the 4th top reccomended school is correct", distanceMap.get(2.15830527289677).equals("HAMPSHIRE COLLEGE"));
		assertTrue("the 5th top reccomended school is correct", distanceMap.get(2.1765192224298806).equals("TOURO"));
	}


	@Test
	public void testFindDistance() {
		double calculatedDistance = 2.5975449265179846;
		University univ1 = dbc.getSchool("NEWYORK IT");
		University univ2 = dbc.getSchool("BARD");
		double cmcDistance = dbc.findDistance(univ1, univ2);
		assertTrue("The distance between NEWYORK IT and BARD should"
				+ " be "+calculatedDistance+".", calculatedDistance==cmcDistance );
	}

	@Test
	public void testGetEmphases() {
		assertTrue("BETHEL UNIVERSITY contains the emphasis ENGINEERING", dbc.getEmphases(u2).contains("ENGINEERING"));
		//fail("Not yet implemented");
	}

}
