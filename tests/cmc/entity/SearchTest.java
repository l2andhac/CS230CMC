package cmc.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	Search s;
	List<String> foci = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
	    foci.add("ENGINEERING");
	    foci.add("ENGLISH");
		s = new Search("Un", "CALI", "URBAN", "STATE", 60000, 5000, 25, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
		foci.add("MATHEMATICS");
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	//@Test
	//public void testSearch() {
	//	fail("Not yet implemented");
	//}

	@Test
	public void testSetName() {
		s.setName("College");
		assertTrue("The school name has been set to College", s.getName().equals("College"));
	}

	@Test
	public void testSetState() {
		s.setState("Minn");
		assertTrue("The state has been set to Minn", s.getState().equals("Minn"));
	}

	@Test
	public void testSetLocation() {
		s.setLocation("Rural");
		assertTrue("The location has been set to Rural", s.getLocation().equals("Rural"));
	}

	@Test
	public void testSetControl() {
		s.setControl("Private");
		assertTrue("The control type has been set to Private", s.getControl().equals("Private"));
	}

	@Test
	public void testSetEnrollmentUp() {
		s.setEnrollmentUp(8000);
		assertTrue("Enrollment Up is now 8000", s.getEnrollmentUp() == 8000);
	}

	@Test
	public void testSetEnrollmentLo() {
		s.setEnrollmentLo(3000);
		assertTrue("Enrollment Low is now 3000", s.getEnrollmentLo() == 3000);
	}

	@Test
	public void testSetPercentFemaleUp() {
		s.setPercentFemaleUp(63);
		assertTrue("Percent Female Up is now 63", s.getPercentFemaleUp() == 63);
	}

	@Test
	public void testSetPercentFemaleLo() {
		s.setPercentFemaleLo(43);
		assertTrue("Percent Female Low is now 43", s.getPercentFemaleLo() == 43);
	}

	@Test
	public void testSetSatVerbUp() {
		s.setSatVerbUp(630);
		assertTrue("SAT Verbal Up is now 630", s.getSatVerbUp() == 630);
	}

	@Test
	public void testSetSatVerbLo() {
		s.setSatVerbLo(430);
		assertTrue("SAT Verbal Low is now 430", s.getSatVerbLo() == 430);
	}

	@Test
	public void testSetSatMathUp() {
		s.setSatMathUp(630);
		assertTrue("SAT Math Up is now 630", s.getSatMathUp() == 630);
	}

	@Test
	public void testSetSatMathLo() {
		s.setSatMathLo(430);
		assertTrue("SAT Math Low is now 430", s.getSatMathLo() == 430);
	}

	@Test
	public void testSetExpensesUp() {
		s.setExpensesUp(63000);
		assertTrue("Expenses Up is now 63000", s.getExpensesUp() == 63000);
	}

	@Test
	public void testSetExpensesLo() {
		s.setExpensesLo(13000);
		assertTrue("Expenses Low is now 13000", s.getExpensesLo() == 13000);
	}

	@Test
	public void testSetPercentFinancialAidUp() {
		s.setPercentFinancialAidUp(82);
		assertTrue("Percent Financial Aid Up is now 82", s.getPercentFinancialAidUp() == 82);
	}

	@Test
	public void testSetPercentFinancialAidLo() {
		s.setPercentFinancialAidLo(22);
		assertTrue("Percent Financial Aid Low is now 22", s.getPercentFinancialAidLo() == 22);
	}

	@Test
	public void testSetApplicantsUp() {
		s.setApplicantsUp(100000);
		assertTrue("Applicants Up is now 100000", s.getApplicantsUp() == 100000);
	}

	@Test
	public void testSetApplicantsLo() {
		s.setApplicantsLo(1000);
		assertTrue("Applicants Low is now 1000", s.getApplicantsLo() == 1000);
	}

	@Test
	public void testSetPercentAdmittedUp() {
		s.setPercentAdmittedUp(99);
		assertTrue("Percent Admitted Up is now 99", s.getPercentAdmittedUp() == 99);
	}

	@Test
	public void testSetPercentAdmittedLo() {
		s.setPercentAdmittedLo(19);
		assertTrue("Percent Admitted Low is now 19", s.getPercentAdmittedLo() == 19);
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
		s.setAcademicScaleUp(3);
		assertTrue("PAcademic Scale is now 4", s.getAcademicScaleUp() == 3);
	}

	@Test
	public void testSetAcademicScaleLo() {
		s.setAcademicScaleLo(4);
		assertTrue("Academic Scale is now 4", s.getAcademicScaleLo() == 4);
	}

	@Test
	public void testSetSocialScaleUp() {
		s.setSocialScaleUp(1);
		assertTrue("Social Scale Up is now 4", s.getSocialScaleUp() == 1);
	}

	@Test
	public void testSetSocialScaleLo() {
		s.setSocialScaleLo(5);
		assertTrue("Social Scale Low is now 5", s.getSocialScaleLo() == 5);
	}

	@Test
	public void testSetQualOfLifeScaleUp() {
		s.setQualOfLifeScaleUp(2);
		assertTrue("Quality of Life Scale Up is now 2", s.getQualOfLifeScaleUp() == 2);
	}

	@Test
	public void testSetQualOfLifeScaleLo() {
		s.setQualOfLifeScaleLo(3);
		assertTrue("Quality of Life Scale Low is now 2", s.getQualOfLifeScaleLo() == 3);
	}

	@Test
	public void testSetEmphasis() {
		s.setEmphasis(foci);
		assertTrue("Focus now has MATHEMATICS added", s.getEmphasis().equals(foci));
		
	}

}
