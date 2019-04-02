package cmc.entity;

import static org.junit.Assert.*;

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
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumApplicants() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentAdmitted() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercentEnrolled() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAcademicScale() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSocialScale() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQualityOfLifeScale() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmphases() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
