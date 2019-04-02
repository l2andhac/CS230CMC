package cmc.entity;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniversityTest {

	University u;
	
	@Before
	public void setUp() throws Exception {
		u = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, null);
	}

	@After
	public void tearDown() throws Exception {
		u = null;
	}


	@Test
	public void testSetSchoolName() {
		assertTrue("Correctly sets school name", "BETHEL UNIVERSITY".equals(u.getSchoolName()));
	}

	@Test
	public void testSetState() {
		assertTrue("Correctly sets state", "MINNESOTA".equals(u.getState()));
	}

	@Test
	public void testSetLocation() {
		assertTrue("Correctly sets location", "SUBURBAN".equals(u.getLocation()));
	}

	@Test
	public void testSetControl() {
		assertTrue("Correctly sets control", "PRIVATE".equals(u.getControl()));
	}

	@Test
	public void testSetNumStudents() {
		assertTrue("Correctly sets number of students", 8000==(u.getNumStudents()));
	}

	@Test
	public void testSetPercentFemales() {
		assertTrue("Correctly sets percent female", 30.0==(u.getPercentFemales()));
	}

	@Test
	public void testSetSATVerbal() {
		assertTrue("Correctly sets SATVerbal", -1==(u.getSATVerbal()));
	}

	@Test
	public void testSetSATMath() {
		assertTrue("Correctly sets SATMath", -1==(u.getSATMath()));
	}

	@Test
	public void testSetExpenses() {
		assertTrue("Correctly sets expenses", 5000==(u.getExpenses()));
	}

	@Test
	public void testSetPercentFinancialAid() {
		u.setPercentFinancialAid(20.0);
		assertTrue("Correctly sets percent financial aid", 20.0==(u.getPercentFinancialAid()));
	}

	@Test
	public void testSetNumberOfApplicants() {
		u.setNumberOfApplicants(23000);
		assertTrue("Correctly sets number of applicants", 23000==(u.getNumApplicants()));
	}

	@Test
	public void testSetPercentAdmitted() {
		u.setPercentAdmitted(30.0);
		assertTrue("Correctly sets percent admitted", 30.0==(u.getPercentAdmitted()));
	}

	@Test
	public void testSetPercentEnrolled() {
		u.setPercentEnrolled(30.0);
		assertTrue("Correctly sets percent enrolled", 30.0==(u.getPercentEnrolled()));
	}

	@Test
	public void testSetAcademicScale() {
		u.setAcademicsScale(4);
		assertTrue("Correctly sets academic scale", 4==(u.getAcademicScale()));
	}

	@Test
	public void testSetSocialScale() {
		u.setSocialScale(4);
		assertTrue("Correctly sets social scale", 4==(u.getSocialScale()));
	}

	@Test
	public void testSetQualityOfLifeScale() {
		u.setSocialScale(4);
		assertTrue("Correctly sets quality of life scale", 4==(u.getSocialScale()));
	}

	@Test
	public void testSetEmphases() {
		List<String> foci = new ArrayList<String>();
		foci.add("ENGINEERING");
		u.setEmphases(foci);
		assertTrue("Correctly sets emphases", u.getEmphases().contains("ENGINEERING"));
		u.setEmphases(null);
	}

	@Test
	public void testToString() {
		assertTrue("Correctly converts University object to a String", u.toString().equals("University [schoolName=" + u.getSchoolName() + ", state=" + u.getState() + ", location=" + u.getLocation() + ", control="
				+ u.getControl() + ", numberOfStudents=" + u.getNumStudents() + ", percentFemale=" + u.getPercentFemales()
				+ ", satVerbal=" + u.getSATVerbal() + ", satMath=" + u.getSATMath() + ", expenses=" + u.getExpenses()
				+ ", percentFinancialAid=" + u.getPercentFinancialAid() + ", numberOfApplicants=" + u.getNumApplicants()
				+ ", percentAdmitted=" + u.getPercentAdmitted() + ", percentEnrolled=" + u.getPercentEnrolled() + ", academicsScale="
				+ u.getAcademicScale() + ", socialScale=" + u.getSocialScale()+ ", qualityScale=" + u.getQualityOfLifeScale() + ", emphases="
				+ u.getEmphases() + "]"));
	}

}
