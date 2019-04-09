package cmc.entity;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SavedSchoolTest {

	@Test
	public void testSetTimeStamp() {
		University dummyU = new University("BETHEL UNIVERSITY", "WISCONSIN", "URBAN", "STATE", 8000, 30.0, -1, -1, 5000, 10.5, 10500, 95.0, 70.0, 2, 1, 1, null);
		SavedSchool dummyS = new SavedSchool(dummyU, "time");
		SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dummyS.setTimeStamp(timeStamp);
		assertTrue("Time Stamp should be set", dummyS.getTimeStamp().equals(timeStamp));
	}

}
