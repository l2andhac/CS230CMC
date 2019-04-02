package cmc.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	Search s;

	@Before
	public void setUp() throws Exception {
		List<String> foci = new ArrayList<String>();
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
		s = new Search("Un", "CALI", "URBAN", "STATE", 60000, 5000, 25, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetControl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEnrollmentUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEnrollmentLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentFemaleUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentFemaleLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSatVerbUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSatVerbLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSatMathUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSatMathLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpensesUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetExpensesLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentFinancialAidUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentFinancialAidLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetApplicantsUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetApplicantsLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentAdmittedUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentAdmittedLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentEnrollUp() {
		s.setPercentEnrollUp(80);
		assertTrue("Percent Enroll Up is now 80", s.getPercentEnrollUp() == 80);
	}

	@Test
	public void testSetPercentEnrollLo() {
		s.setPercentEnrollLo(70);
		assertTrue("Percent Enroll Low is now 70", s.getPercentEnrollLo() == 70);
	}

	@Test
	public void testSetAcademicScaleUp() {
		s.setAcademicScaleUp(4);
		assertTrue("PAcademic Scale is now 4", s.getAcademicScaleUp() == 4);
	}

	@Test
	public void testSetAcademicScaleLo() {
		s.setAcademicScaleLo(4);
		assertTrue("Academic Scale is now 4", s.getAcademicScaleLo() == 4);
	}

	@Test
	public void testSetSocialScaleUp() {
		s.setSocialScaleUp(4);
		assertTrue("Social Scale is now 4", s.getSocialScaleLo() == 4);
	}

	@Test
	public void testSetSocialScaleLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQualOfLifeScaleUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQualOfLifeScaleLo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmphasis() {
		fail("Not yet implemented");
	}

}
