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
  	if(!u.getState().equals("") && !u.getState().contains(searchCriteria.getState())) {
  		return false;
  	}
  	if(!u.getLocation().equals("") && !u.getLocation().equals(searchCriteria.getLocation()) && !searchCriteria.getLocation().equals("")) {
  		return false;
  	}
  	if(!u.getControl().equals("") && !u.getControl().equals(searchCriteria.getControl()) && !searchCriteria.getControl().equals("")) {
  		return false;
  	}
  	if(u.getNumStudents() != -1 && (u.getNumStudents() > searchCriteria.getEnrollmentUp() && !(searchCriteria.getEnrollmentUp() == -1) || u.getNumStudents() < searchCriteria.getEnrollmentLo())) {
  		return false;
  	}
  	if(u.getPercentFemales() != -1 && (u.getPercentFemales() > searchCriteria.getPercentFemaleUp() && !(searchCriteria.getPercentFemaleUp() == -1) || u.getPercentFemales() < searchCriteria.getPercentFemaleLo())) {
  		return false;
  	}
  	if(u.getSATVerbal() != -1 && (u.getSATVerbal() > searchCriteria.getSatVerbUp() && !(searchCriteria.getSatVerbUp() == -1) || u.getSATVerbal() < searchCriteria.getSatVerbLo())) {
  		return false;
  	}
  	if(u.getSATMath() != -1 && (u.getSATMath() > searchCriteria.getSatMathUp() && !(searchCriteria.getSatMathUp() == -1) || u.getSATMath() < searchCriteria.getSatMathLo())) {
  		return false;
  	}
  	if(u.getExpenses() != -1 && (u.getExpenses() > searchCriteria.getExpensesUp() && !(searchCriteria.getExpensesUp() == -1) || u.getExpenses() < searchCriteria.getExpensesLo())) {
  		return false;
  	}
  	if(u.getPercentFinancialAid() != -1 && (u.getPercentFinancialAid() > searchCriteria.getPercentFinancialAidUp() && !(searchCriteria.getPercentFinancialAidUp() == -1) || u.getPercentFinancialAid() < searchCriteria.getPercentFinancialAidLo())) {
  		return false;
  	}
  	if(u.getNumApplicants() != -1 && (u.getNumApplicants() > searchCriteria.getApplicantsUp() && !(searchCriteria.getApplicantsUp() == -1) || u.getNumApplicants() < searchCriteria.getApplicantsLo())) {
  		return false;
  	}
  	if(u.getPercentAdmitted() != -1 && (u.getPercentAdmitted() > searchCriteria.getPercentAdmittedUp() && !(searchCriteria.getPercentAdmittedUp() == -1) || u.getPercentAdmitted() < searchCriteria.getPercentAdmittedLo())) {
  		return false;
  	}
  	if(u.getPercentEnrolled() != -1 && (u.getPercentEnrolled() > searchCriteria.getPercentEnrollUp() && !(searchCriteria.getPercentEnrollUp() == -1) || u.getPercentEnrolled() < searchCriteria.getPercentEnrollLo())) {
  		return false;
  	}
  	if(u.getAcademicScale() != -1 && (u.getAcademicScale() > searchCriteria.getAcademicScaleUp() && !(searchCriteria.getAcademicScaleUp() == -1) || u.getAcademicScale() < searchCriteria.getAcademicScaleLo())) {
  		return false;
  	}
  	if(u.getSocialScale() != -1 && (u.getSocialScale() > searchCriteria.getSocialScaleUp() && !(searchCriteria.getSocialScaleUp() == -1) || u.getSocialScale() < searchCriteria.getSocialScaleLo())) {
  		return false;
  	}
  	if(u.getQualityOfLifeScale() != -1 && (u.getQualityOfLifeScale() > searchCriteria.getQualOfLifeScaleUp() && !(searchCriteria.getQualOfLifeScaleUp() == -1) || u.getQualityOfLifeScale() < searchCriteria.getQualOfLifeScaleLo())) {
  		return false;
  	}  

  	int matches = 0;
  	List<String> emphases = dbcontroller.getEmphases(u);
  	if(searchCriteria.getEmphasis() != null && searchCriteria.getEmphasis().size() != 0) {
  	for(String em : emphases) {
  		if(searchCriteria.getEmphasis().contains(em)) {
  			matches += 1;
  		}
  	}
  	}
  	else {
  		return true;
  	}
  	if(matches >= 1) {
  		return true;
  	}
  	else {
  		return false;
  	}
  }

}
