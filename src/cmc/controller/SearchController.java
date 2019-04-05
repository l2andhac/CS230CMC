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
  	if(u.getNumStudents() > searchCriteria.getEnrollmentUp() && !(searchCriteria.getEnrollmentUp() == -1) || u.getNumStudents() < searchCriteria.getEnrollmentLo() && !(searchCriteria.getEnrollmentLo() == -1)) {
  		return false;
  	}
  	if(u.getPercentFemales() > searchCriteria.getPercentFemaleUp() && !(searchCriteria.getPercentFemaleUp() == -1) || u.getNumStudents() < searchCriteria.getPercentFemaleLo() && !(searchCriteria.getPercentFemaleLo() == -1)) {
  		return false;
  	}
  	if(u.getSATVerbal() > searchCriteria.getSatVerbUp() && !(searchCriteria.getSatVerbUp() == -1) || u.getSATVerbal() < searchCriteria.getSatVerbLo() && !(searchCriteria.getSatVerbLo() == -1)) {
  		return false;
  	}
  	if(u.getSATMath() > searchCriteria.getSatMathUp() && !(searchCriteria.getSatMathUp() == -1) || u.getSATMath() < searchCriteria.getSatMathLo() && !(searchCriteria.getSatMathLo() == -1)) {
  		return false;
  	}
  	if(u.getExpenses() > searchCriteria.getExpensesUp() && !(searchCriteria.getExpensesUp() == -1) || u.getExpenses() < searchCriteria.getExpensesLo() && !(searchCriteria.getExpensesLo() == -1)) {
  		return false;
  	}
  	if(u.getPercentFinancialAid() > searchCriteria.getPercentFinancialAidUp() && !(searchCriteria.getPercentFinancialAidUp() == -1) || u.getPercentFinancialAid() < searchCriteria.getPercentFinancialAidLo() && !(searchCriteria.getPercentFinancialAidLo() == -1)) {
  		return false;
  	}
  	if(u.getNumApplicants() > searchCriteria.getApplicantsUp() && !(searchCriteria.getApplicantsUp() == -1) || u.getNumApplicants() < searchCriteria.getApplicantsLo() && !(searchCriteria.getApplicantsLo() == -1)) {
  		return false;
  	}
  	if(u.getPercentAdmitted() > searchCriteria.getPercentAdmittedUp() && !(searchCriteria.getPercentAdmittedUp() == -1) || u.getPercentAdmitted() < searchCriteria.getPercentAdmittedLo() && !(searchCriteria.getPercentAdmittedLo() == -1)) {
  		return false;
  	}
  	if(u.getPercentEnrolled() > searchCriteria.getPercentEnrollUp() && !(searchCriteria.getPercentEnrollUp() == -1) || u.getPercentEnrolled() < searchCriteria.getPercentEnrollLo() && !(searchCriteria.getPercentEnrollLo() == -1)) {
  		return false;
  	}
  	if(u.getAcademicScale() > searchCriteria.getAcademicScaleUp() && !(searchCriteria.getAcademicScaleUp() == -1) || u.getAcademicScale() < searchCriteria.getAcademicScaleLo() && !(searchCriteria.getAcademicScaleLo() == -1)) {
  		return false;
  	}
  	if(u.getSocialScale() > searchCriteria.getSocialScaleUp() && !(searchCriteria.getSocialScaleUp() == -1) || u.getSocialScale() < searchCriteria.getSocialScaleLo() && !(searchCriteria.getSocialScaleLo() == -1)) {
  		return false;
  	}
  	if(u.getQualityOfLifeScale() > searchCriteria.getQualOfLifeScaleUp() && !(searchCriteria.getSocialScaleUp() == -1) || u.getQualityOfLifeScale() < searchCriteria.getQualOfLifeScaleLo() && !(searchCriteria.getSocialScaleLo() == -1)) {
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
