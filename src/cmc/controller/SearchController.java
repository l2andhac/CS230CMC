package cmc.controller;
import java.util.List;

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
 //instance variable for Search Object 
private Search searchCriteria;
private DBController dbcontroller;
  
  /**
   * Constructor for SearchController
   * 
   * @param so - Search object
   */
  public SearchController(Search so) {
	  this.searchCriteria = so;
	  this.dbcontroller = new DBController();
  }
  
  
  /**
   * Searches for a University
   * 
   * @param u - University to be searched for
   * @return - boolean returns true if the school matches the search criteria
   */
  public boolean testForMatch(University u){
  	if(!u.getSchoolName().contains(searchCriteria.getName())) {
  		return false;
  	}
  	if(!u.getState().contains(searchCriteria.getState())) {
  		return false;
  	}
  	if(!u.getLocation().equals(searchCriteria.getLocation()) && !searchCriteria.getLocation().equals("")) {
  		return false;
  	}
  	if(!u.getControl().equals(searchCriteria.getControl()) && !searchCriteria.getControl().equals("")) {
  		return false;
  	}
  	//ACCOUNT FOR -1
  	if(u.getNumStudents() > searchCriteria.getEnrollmentUp() && u.getNumStudents() < searchCriteria.getEnrollmentLo() && !(searchCriteria.getEnrollmentUp() == -1)) {
  		return false;
  	}
  	if(u.getPercentFemales() > searchCriteria.getPercentFemaleUp() && u.getNumStudents() < searchCriteria.getPercentFemaleLo() && !(searchCriteria.getPercentFemaleUp() == -1)) {
  		return false;
  	}
  	if(u.getSATVerbal() > searchCriteria.getSatVerbUp() && u.getSATVerbal() < searchCriteria.getSatVerbLo() && !(searchCriteria.getSatVerbUp() == -1)) {
  		return false;
  	}
  	if(u.getSATMath() > searchCriteria.getSatMathUp() && u.getSATMath() < searchCriteria.getSatMathLo() && !(searchCriteria.getSatMathUp() == -1)) {
  		return false;
  	}
  	if(u.getExpenses() > searchCriteria.getExpensesUp() && u.getExpenses() < searchCriteria.getExpensesLo() && !(searchCriteria.getExpensesUp() == -1)) {
  		return false;
  	}
  	if(u.getPercentFinancialAid() > searchCriteria.getPercentFinancialAidUp() && u.getPercentFinancialAid() < searchCriteria.getPercentFinancialAidLo() && !(searchCriteria.getPercentFinancialAidUp() == -1)) {
  		return false;
  	}
  	if(u.getNumApplicants() > searchCriteria.getApplicantsUp() && u.getNumApplicants() < searchCriteria.getApplicantsLo() && !(searchCriteria.getApplicantsUp() == -1)) {
  		return false;
  	}
  	if(u.getPercentAdmitted() > searchCriteria.getPercentAdmittedUp() && u.getPercentAdmitted() < searchCriteria.getPercentAdmittedLo() && !(searchCriteria.getPercentAdmittedUp() == -1)) {
  		return false;
  	}
  	if(u.getPercentEnrolled() > searchCriteria.getPercentEnrollUp() && u.getPercentEnrolled() < searchCriteria.getPercentEnrollLo() && !(searchCriteria.getPercentEnrollUp() == -1)) {
  		return false;
  	}
  	if(u.getAcademicScale() > searchCriteria.getAcademicScaleUp() && u.getAcademicScale() < searchCriteria.getAcademicScaleLo() && !(searchCriteria.getAcademicScaleUp() == -1)) {
  		return false;
  	}
  	if(u.getSocialScale() > searchCriteria.getSocialScaleUp() && u.getSocialScale() < searchCriteria.getSocialScaleLo() && !(searchCriteria.getSocialScaleUp() == -1)) {
  		return false;
  	}
  	if(u.getQualityOfLifeScale() > searchCriteria.getQualOfLifeScaleUp() && u.getQualityOfLifeScale() < searchCriteria.getQualOfLifeScaleLo() && !(searchCriteria.getSocialScaleUp() == -1)) {
  		return false;
  	}  

  	int matches = 0;
  	List<String> emphases = dbcontroller.getEmphases(u);
  	if(searchCriteria.getEmphasis() != null) {
  	for(String em : emphases) {
  		if(searchCriteria.getEmphasis().contains(em)) {
  			matches += 1;
  		}
  	}
  	}
  	else {
  		return true;
  	}
  	if(matches >= 1 || dbcontroller.getEmphases(u).size() == 0) {
  		return true;
  	}
  	else {
  		return false;
  	}
  }

}
