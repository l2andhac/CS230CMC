package cmc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cmc.entity.Search;

public class SearchControllerTest {

	private Search searchCriteria;
	private DBController dbcontroller;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		dbcontroller = new DBController();
		//searchCriteria ...
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchController() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestForMatch() {
		fail("Not yet implemented");
	}

}
