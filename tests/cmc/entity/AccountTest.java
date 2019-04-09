package cmc.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	Account a;
	
	@Before
	public void setUp() throws Exception {
		a = new Account("Dummy", "Jordre", "DummyUser", "Password", 'u', 'Y');
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testSetFirstName() {
		assertTrue("Name should be unchanged", a.getFirstName().equals("Dummy"));
		a.setFirstName("Nate");
		assertTrue("Name should be changed", a.getFirstName().equals("Nate"));
	}


	@Test
	public void testSetLastName() {
		assertTrue("Name should be unchanged", a.getLastName().equals("Jordre"));
		a.setLastName("Dummy");
		assertTrue("Name should be changed", a.getLastName().equals("Dummy"));
	}

	@Test
	public void testSetPassword() {
		assertTrue("Password should be unchanged", a.getPassword().equals("Password"));
		a.setPassword("Pass");
		assertTrue("Password should be changed", a.getPassword().equals("Pass"));
	}

	@Test
	public void testSetUserType() {
		assertTrue("Type should be unchanged", a.getUserType() == 'u');
		a.setUserType('a');
		assertTrue("Type should be changed", a.getUserType() == 'a');
	}

	@Test
	public void testSetStatus() {
		assertTrue("Status should be unchanged", a.getStatus() == 'Y');
		a.setStatus('N');
		assertTrue("Status should be changed", a.getStatus() == 'N');
	}

	@Test
	public void testSetUsername() {
		assertTrue("Username should be unchanged", a.getUsername().equals("DummyUser"));
		a.setUsername("NateTheDummy");
		assertTrue("Username should be changed", a.getUsername().equals("NateTheDummy"));
	}

	@Test
	public void testLogOnAndLogOffAndIsLoggedOff() {
		assertFalse("Account should be logged off", a.isLoggedOn());
		a.logOn();
		assertTrue("Account should be logged off", a.isLoggedOn());
		a.logOff();
		assertFalse("Account should be logged off", a.isLoggedOn());
	}

	@Test
	public void testToString() {
		String expected = "firstName= Dummy\nlastName= Jordre\nusername= DummyUser\npassword= "
				+ "Password\nuserType= u\nstatus= Y\nisLoggedOn= false";
		assertTrue("ToString should be " + expected, a.toString().equals(expected));
	}
	
	@Test
	public void testEquals() {
		Account a2 = new Account(a.getFirstName(), a.getLastName(), a.getUsername(), a.getPassword(), a.getUserType(), a.getStatus());
		assertTrue("accounts should be equal", a2.equals(a));
		a2.setFirstName("laskjdf");
		assertFalse("accounts should be different", a2.equals(a));
		a2.setFirstName(a.getFirstName());
		a2.setLastName("lskdfj");
		assertFalse("accounts should be different", a2.equals(a));
		a2.setLastName(a.getLastName());
		a2.setUsername("slkfjs");
		assertFalse("accounts should be different", a2.equals(a));
		a2.setUsername(a.getUsername());
		a2.setPassword("laskjf");
		assertFalse("accounts should be different", a2.equals(a));
		a2.setPassword(a.getUsername());
		a2.setUserType('x');
		assertFalse("accounts should be different", a2.equals(a));
		a2.setUserType(a.getUserType());
		a2.setStatus('x');
		assertFalse("accounts should be different", a2.equals(a));
	}

}
