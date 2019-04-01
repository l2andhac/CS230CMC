package cmc.entity;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User("Dummy", "Jordre", "DummyUser", "Password", 'Y');
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetSavedSchools() {
		University u, u2;
		SavedSchool s, s2;
		u = new University("BETHEL UNIVERSITY", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, null);
		s = new SavedSchool(u, "time");
		u2 = new University("Carleton College", "MINNESOTA", "SUBURBAN", "PRIVATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, null);
		s2 = new SavedSchool(u2, "time");
		List<SavedSchool> l = new ArrayList<SavedSchool>();
		l.add(s);
		l.add(s2);
		user.setSavedSchools(l);
		assertTrue("Lists should be equal", l.equals(user.getSavedSchools()));
	}

}
