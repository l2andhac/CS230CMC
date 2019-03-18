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
  	if(!u.getSchoolName().contains(searchCriteria.getName())) {
  		return false;
  	}
  	if(!u.getState().contains(searchCriteria.getState())) {
  		return false;
  	}
  	if(!u.getLocation().equals(searchCriteria.getLocation())) {
  		return false;
  	}
  	if(!u.getControl().equals(searchCriteria.getControl())) {
  		return false;
  	}
  	if(u.getNumStudents() > searchCriteria.getEnrollmentUp() && u.getNumStudents() < searchCriteria.getEnrollmentLo()) {
  		return false;
  	}
  	if(u.getPercentFemales() > searchCriteria.getPercentFemaleUp() && u.getNumStudents() < searchCriteria.getPercentFemaleLo()) {
  		return false;
  	}
  	if(u.getSATVerbal() > searchCriteria.getSatVerbUp() && u.getSATVerbal() < searchCriteria.getSatVerbLo()) {
  		return false;
  	}
  	if(u.getSATMath() > searchCriteria.getSatMathUp() && u.getSATVerbal() < searchCriteria.getSatVerbLo()) {
  		return false;
  	}
  	if(u.getExpenses() > searchCriteria.getExpensesUp() && u.getExpenses() < searchCriteria.getExpensesLo()) {
  		return false;
  	}
  	if(u.getPercentFinancialAid() > searchCriteria.getPercentFinancialAidUp() && u.getPercentFinancialAid() < searchCriteria.getPercentFinancialAidLo()) {
  		return false;
  	}
  	if(u.getNumApplicants() > searchCriteria.getApplicantsUp() && u.getNumApplicants() < searchCriteria.getApplicantsLo()) {
  		return false;
  	}
  	if(u.getPercentAdmitted() > searchCriteria.getPercentAdmittedUp() && u.getPercentAdmitted() < searchCriteria.getPercentAdmittedLo()) {
  		return false;
  	}
  	if(u.getPercentEnrolled() > searchCriteria.getPercentEnrollUp() && u.getPercentEnrolled() < searchCriteria.getPercentEnrollLo()) {
  		return false;
  	}
  	if(u.getAcademicScale() > searchCriteria.getAcademicScaleUp() && u.getAcademicScale() < searchCriteria.getAcademicScaleLo()) {
  		return false;
  	}
  	if(u.getSocialScale() > searchCriteria.getSocialScaleUp() && u.getSocialScale() < searchCriteria.getSocialScaleLo()) {
  		return false;
  	}
  	if(u.getQualityOfLifeScale() > searchCriteria.getQualOfLifeScaleUp() && u.getQualityOfLifeScale() < searchCriteria.getQualOfLifeScaleLo()) {
  		return false;
  	}  		
  	int matches = 0;
  	for(String em : u.getEmphases()) {
  		if(searchCriteria.getEmphasis().contains(em)) {
  			matches += 1;
  		}
  	}
  	if(matches >= 1) {
  		return true;
  	}
  	else {
  		return false;
  	}
  }

}
