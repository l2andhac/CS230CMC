package cmc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Search;
import cmc.entity.University;

public class SearchControllerTest {

	private Search searchCriteria;
	private static DBController dbcontroller;
	private SearchController searchController;
	private List<String> foci;
	private University u;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		dbcontroller = new DBController();
		
	}
	
	@Before
	public void setUp() throws Exception {
		foci = new ArrayList<String>();
		foci.add("BUSINESS");
		searchCriteria = new Search("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 7999, 8001, 29, 31, -1, -1, -1, -1, 4999, 5001, 9, 11, 10000, 10600, 94, 96, 69, 71, 1,3, -1, -1, -1, -1,foci);
		u = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
	    dbcontroller.addSchool(u);
	}

	@After
	public void tearDown() throws Exception {
		foci = new ArrayList<String>();
		foci.add("BUSINESS");;
		dbcontroller.removeSchool(u);
	}

	@Test
	public void testSearchController() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestForMatchSchoolNameIsNotAMatch() {
		searchCriteria.setName("SOMEWHERE UNIVERSITY");
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchStateNameIsNotAMatch() {
		searchCriteria.setState("Nowhere");
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchLocationIsNotAMatch() {
		searchCriteria.setLocation("EVERYWHERE");
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchControlIsNotAMatch() {
		searchCriteria.setControl("NONE");
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchEnrollmentIsNotAMatch() {
		searchCriteria.setEnrollmentUp(1);
		searchCriteria.setEnrollmentLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFemaleIsNotAMatch() {
		searchCriteria.setPercentFemaleUp(1);
		searchCriteria.setPercentFemaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATVerbalIsNotAMatch() {
		searchCriteria.setSatVerbUp(1);
		searchCriteria.setSatVerbLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATMathIsNotAMatch() {
		searchCriteria.setSatMathUp(1);
		searchCriteria.setSatMathLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchExpensesIsNotAMatch() {
		searchCriteria.setExpensesUp(1);
		searchCriteria.setExpensesLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFinancialAidIsNotAMatch() {
		searchCriteria.setPercentFinancialAidUp(1);
		searchCriteria.setPercentFinancialAidLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchNumberOfApplicantsIsNotAMatch() {
		searchCriteria.setApplicantsUp(1);
		searchCriteria.setApplicantsLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentAdmittedIsNotAMatch() {
		searchCriteria.setPercentAdmittedUp(1);
		searchCriteria.setPercentAdmittedLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentEnrolledIsNotAMatch() {
		searchCriteria.setPercentEnrollUp(1);
		searchCriteria.setPercentEnrollLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchAcademicScaleIsNotAMatch() {
		searchCriteria.setAcademicScaleUp(1);
		searchCriteria.setAcademicScaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSocialScaleIsNotAMatch() {
		searchCriteria.setSocialScaleUp(1);
		searchCriteria.setSocialScaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchQualityOfLifeScaleIsNotAMatch() {
		searchCriteria.setQualOfLifeScaleUp(1);
		searchCriteria.setQualOfLifeScaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchWrongEmphasis() {
		foci.add("CHEMISTRY");
		searchCriteria.setEmphasis(foci);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
		searchCriteria.setEmphasis(foci);
	}
	
	@Test
	public void testTestForMatchIsMatch() {
		searchController = new SearchController(searchCriteria);
		assertTrue("School matches criteria", searchController.testForMatch(u));
	}

}
