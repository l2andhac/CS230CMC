package cmc.controller;
import cmc.entity.*;
/**
 * 
 * A Class that controls all of the functionalities of searching
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */

public class SearchController{
  
private Search searchCriteria;
  
  /**
   * Constructor for SearchController
   * 
   * @param so - Search object
   */
  public SearchController(Search so) {
	  this.searchCriteria = so;
  }
  
  
  /**
   * Searches for a University
   * 
   * @param u - University to be searched for
   */
  public boolean testForMatch(University u){
  	if(!u.getState().contains(searchCriteria.getState())) {
  		return false;
  	}
  	if(u.getNumStudents() > searchCriteria.getEnrollmentUp() && u.getNumStudents() < searchCriteria.getEnrollmentLo()) {
  		return false;
  	}
  	else {
  		return true;
  	}
  }

}
