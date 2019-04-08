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
		foci.add("ENGINEERING");
		searchCriteria = new Search("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8001, 7999, 31, 29, 700, 600, 700, 600, 5001, 4999, 11, 9, 11000, 10000, 96, 94, 71, 69, 3, 1, 5, 1, 5, 1,foci);
		u = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, 650, 650, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
	    dbcontroller.addSchool(u);
	}

	@After
	public void tearDown() throws Exception {
		foci = new ArrayList<String>();
		u = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, 650, 650, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, foci);
		dbcontroller.editSchool(u);
		dbcontroller.removeSchool(u);
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
	public void testTestForMatchEmptyLocationIsMatch() {
		searchCriteria.setLocation("");
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchControlIsNotAMatch() {
		searchCriteria.setControl("NONE");
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchEmptyControlIsNotAMatch() {
		searchCriteria.setControl("");
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchEnrollmentUpIsNotAMatch() {
		searchCriteria.setEnrollmentUp(1);
		searchCriteria.setEnrollmentLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchEnrollmentLoIsNotAMatch() {
		searchCriteria.setEnrollmentUp(10000000);
		searchCriteria.setEnrollmentLo(9999999);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchEnrollmentNegOneIsMatch() {
		searchCriteria.setEnrollmentUp(-1);
		searchCriteria.setEnrollmentLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}

	
	@Test
	public void testTestForMatchPercentFemaleUpIsNotAMatch() {
		searchCriteria.setPercentFemaleUp(1);
		searchCriteria.setPercentFemaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFemaleLoIsNotAMatch() {
		searchCriteria.setPercentFemaleUp(110);
		searchCriteria.setPercentFemaleLo(109);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFemaleNegOneIsMatch() {
		searchCriteria.setPercentFemaleUp(-1);
		searchCriteria.setPercentFemaleLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATVerbaUplIsNotAMatch() {
		searchCriteria.setSatVerbUp(1);
		searchCriteria.setSatVerbLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATVerbaLolIsNotAMatch() {
		searchCriteria.setSatVerbUp(850);
		searchCriteria.setSatVerbLo(849);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATVerbalNegOneIsMatch() {
		searchCriteria.setSatVerbUp(-1);
		searchCriteria.setSatVerbLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATMathUpIsNotAMatch() {
		searchCriteria.setSatMathUp(1);
		searchCriteria.setSatMathLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATMathLoIsNotAMatch() {
		searchCriteria.setSatMathUp(850);
		searchCriteria.setSatMathLo(849);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSATMathNegOneIsMatch() {
		searchCriteria.setSatMathUp(-1);
		searchCriteria.setSatMathLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchExpensesUpIsNotAMatch() {
		searchCriteria.setExpensesUp(1);
		searchCriteria.setExpensesLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchExpensesLoIsNotAMatch() {
		searchCriteria.setExpensesUp(100000);
		searchCriteria.setExpensesLo(99999);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchExpensesNegOneIsMatch() {
		searchCriteria.setExpensesUp(-1);
		searchCriteria.setExpensesLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFinancialAidUpIsNotAMatch() {
		searchCriteria.setPercentFinancialAidUp(1);
		searchCriteria.setPercentFinancialAidLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFinancialAidLoIsNotAMatch() {
		searchCriteria.setPercentFinancialAidUp(125);
		searchCriteria.setPercentFinancialAidLo(124);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentFinancialAidNegOneIsMatch() {
		searchCriteria.setPercentFinancialAidUp(-1);
		searchCriteria.setPercentFinancialAidLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchNumberOfApplicantsUpIsNotAMatch() {
		searchCriteria.setApplicantsUp(1);
		searchCriteria.setApplicantsLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchNumberOfApplicantsLoIsNotAMatch() {
		searchCriteria.setApplicantsUp(1000000);
		searchCriteria.setApplicantsLo(999999);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchNumberOfApplicantsNegOneIsMatch() {
		searchCriteria.setApplicantsUp(-1);
		searchCriteria.setApplicantsLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentAdmittedUpIsNotAMatch() {
		searchCriteria.setPercentAdmittedUp(1);
		searchCriteria.setPercentAdmittedLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentAdmittedLoIsNotAMatch() {
		searchCriteria.setPercentAdmittedUp(110);
		searchCriteria.setPercentAdmittedLo(109);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentAdmittedNegOneIsMatch() {
		searchCriteria.setPercentAdmittedUp(-1);
		searchCriteria.setPercentAdmittedLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentEnrolledUpIsNotAMatch() {
		searchCriteria.setPercentEnrollUp(1);
		searchCriteria.setPercentEnrollLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentEnrolledLoIsNotAMatch() {
		searchCriteria.setPercentEnrollUp(110);
		searchCriteria.setPercentEnrollLo(109);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchPercentEnrolledNegOneIsMatch() {
		searchCriteria.setPercentEnrollUp(-1);
		searchCriteria.setPercentEnrollLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchAcademicScaleUpIsNotAMatch() {
		searchCriteria.setAcademicScaleUp(0);
		searchCriteria.setAcademicScaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchAcademicScaleLoIsNotAMatch() {
		searchCriteria.setAcademicScaleUp(10);
		searchCriteria.setAcademicScaleLo(9);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchAcademicScaleNegOneIsMatch() {
		searchCriteria.setAcademicScaleUp(-1);
		searchCriteria.setAcademicScaleLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSocialScaleUpIsNotAMatch() {
		searchCriteria.setSocialScaleUp(0);
		searchCriteria.setSocialScaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSocialScaleLoIsNotAMatch() {
		searchCriteria.setSocialScaleUp(10);
		searchCriteria.setSocialScaleLo(9);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchSocialScaleNegOneIsMatch() {
		searchCriteria.setSocialScaleUp(-1);
		searchCriteria.setSocialScaleLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchQualityOfLifeScaleUpIsNotAMatch() {
		searchCriteria.setQualOfLifeScaleUp(0);
		searchCriteria.setQualOfLifeScaleLo(0);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchQualityOfLifeScaleLoIsNotAMatch() {
		searchCriteria.setQualOfLifeScaleUp(10);
		searchCriteria.setQualOfLifeScaleLo(9);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchQualityOfLifeScaleNegOneIsMatch() {
		searchCriteria.setQualOfLifeScaleUp(-1);
		searchCriteria.setQualOfLifeScaleLo(-1);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchWrongEmphasis() {
		List<String>foci2 = new ArrayList<String>();
		foci2.add("CHEMISTRY");
		searchCriteria.setEmphasis(foci2);
		searchController = new SearchController(searchCriteria);
		assertFalse("School should not match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchNoEmphasis() {
		List<String>fociEmpty = new ArrayList<String>();
		searchCriteria.setEmphasis(fociEmpty);
		searchController = new SearchController(searchCriteria);
		assertTrue("School should match search criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testTestForMatchIsMatch() {
		searchController = new SearchController(searchCriteria);
		assertTrue("School matches criteria", searchController.testForMatch(u));
	}
	
	@Test
	public void testForMatchSchoolOnlyHasName() throws Exception {
		foci = new ArrayList<String>();
		University testSchool = new University("NOTHING SCHOOL", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, foci);
		searchCriteria.setName("NOTHING SCHOOL");
		searchCriteria.setEmphasis(foci);
		searchController = new SearchController(searchCriteria);
		assertTrue("School matches criteria", searchController.testForMatch(testSchool));
	}

}
