package cmc.entity;

import java.util.*;

/**
 * This class is a search object
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class Search {
	///////////////// forgot to add expenses into the parameters
	// name of the school
	private String name;
	// name of the state
	private String state;
	// whether school urban, rural, etc
	private String location;
	// whether school is public or private
	private String control;
	// the upperbound of enrollment
	private int enrollmentUp;
	// the lowerbound of enrollment
	private int enrollmentLo;
	// the upperbound of the percentage of female students
	private int percentFemaleUp;
	// the lowerbound of the percentage of female students
	private int percentFemaleLo;
	// the upperbound of sat verbal scores
	private int satVerbUp;
	// the lowerbound of sat verbal scores
	private int satVerbLo;
	// the upperbound of sat math scores
	private int satMathUp;
	// the lowerbound of sat math scores
	private int satMathLo;
	// the upperbound of the expenses
	private int expensesUp;
	//the lowerbound of the expenses
	private int expensesLo;
	// the upperbound of the percent financial aid
	private int percentFinancialAidUp;
	// the lowerbound of the percent financial aid
	private int percentFinancialAidLo;
	// the upperbond of the number of applicants
	private int applicantsUp;
	// the lowerebound of the number of applicants
	private int applicantsLo;
	// the upperbound of the percent of applicants admitted
	private int percentAdmittedUp;
	// the lowerbound of the percent of applicants admitted
	private int percentAdmittedLo;
	// the upperbound of the percent of admitted students who enroll
	private int percentEnrollUp;
	// the lowerbound of the percent of admitted students who enroll
	private int percentEnrollLo;
	// the upperbound of the academic scale rating
	private int academicScaleUp;
	// the lowerbound of the academic scale rating
	private int academicScaleLo;
	// the upperbound of the social scale rating
	private int socialScaleUp;
	// the lowerbound of the social scale rating
	private int socialScaleLo;
	// the upperbound of the quality of life scale rating
	private int qualOfLifeScaleUp;
	// the lowerbound of the quality of life scale rating
	private int qualOfLifeScaleLo;
	// the list of emphases that a school has
	private List<String> emphasis;

	/**
	 * Constructs a search object with the given parameters
	 * 
	 * @param name to search
	 * 
	 * @param state to search
	 * 
	 * @param location type to search
	 * 
	 * @param control type to search
	 * 
	 * @param enrollmentUp upperbound of enrollment
	 * 
	 * @param enrollmentLo lowerbound of enrollment
	 * 
	 * @param percentFemaleUp upperbound of the percentage of female students
	 * 
	 * @param percentFemaleLo lowerbound of the percentage of female students
	 * 
	 * @param satVerbUp upperbound of the sat verbal scores
	 * 
	 * @param satVerbLo lowerbound of the sat verbal scores
	 * 
	 * @param satMathUp upperbound of the sat math scores
	 * 
	 * @param satMathLo lowerbound of the sat math scores
	 * 
	 * @param expensesUp upperbound of expenses
	 * 
	 * @param expensesLo lowerbound of expenses
	 * 
	 * @param percentFinancialAidUp upperbound of the percentage of financial aid
	 * 
	 * @param percentFinancialAidLo lowerbound of the percentage of financial aid
	 * 
	 * @param applicantsUp upperbound of the number of applicants
	 * 
	 * @param applicantsLo lowerbound of the number of applicants
	 * 
	 * @param percentAdmittedUp upperbound of the percent of applicants admitted
	 * 
	 * @param percentAdmittedLo lowerbound of the percent of applicants admitted
	 * 
	 * @param percentEnrollUp upperbound of the percent of admitted students who
	 * enroll
	 * 
	 * @param percentEnrollLo lowerbound of the percent of admitted students who
	 * enroll
	 * 
	 * @param academicScaleUp upperbound of the academic scale
	 * 
	 * @param academicScaleLo lowerbound of the academic scale
	 * 
	 * @param socialScaleUp upperbound of the social scale
	 * 
	 * @param socialScaleLo upperbound of the social scale
	 * 
	 * @param qualOfLifeScaleUp upperbound of the quality of life scale
	 * 
	 * @param qualOfLifeScaleLo lowerbound of the quality of life scale
	 * 
	 * @param emphasis the areas of focus of a school
	 */
	public Search(String name, String state, String location, String control, int enrollmentUp, int enrollmentLo,
			int percentFemaleUp, int percentFemaleLo, int satVerbUp, int satVerbLo, int satMathUp, int satMathLo,
			int expensesUp, int expensesLo, int percentFinancialAidUp, int percentFinancialAidLo, int applicantsUp, int applicantsLo,
			int percentAdmittedUp, int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp,
			int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp, int qualOfLifeScaleLo,
			List<String> emphasis) {
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.enrollmentUp = enrollmentUp;
		this.enrollmentLo = enrollmentLo;
		this.percentFemaleUp = percentFemaleUp;
		this.satVerbUp = satVerbUp;
		this.satVerbLo = satVerbLo;
		this.setExpensesUp(expensesUp);
		this.setExpensesLo(expensesLo);
		this.satMathUp = satMathUp;
		this.satMathLo = satMathLo;
		this.percentFinancialAidUp = percentFinancialAidUp;
		this.percentFinancialAidLo = percentFinancialAidLo;
		this.applicantsUp = applicantsUp;
		this.applicantsLo = applicantsLo;
		this.percentAdmittedUp = percentAdmittedUp;
		this.percentAdmittedLo = percentAdmittedLo;
		this.percentEnrollUp = percentEnrollUp;
		this.percentEnrollLo = percentEnrollLo;
		this.academicScaleUp = academicScaleUp;
		this.academicScaleLo = academicScaleLo;
		this.socialScaleUp = socialScaleUp;
		this.socialScaleLo = socialScaleLo;
		this.qualOfLifeScaleUp = qualOfLifeScaleUp;
		this.qualOfLifeScaleLo = qualOfLifeScaleLo;
		this.emphasis = emphasis;
	}

	/**
	 * accessor method to get the name of the search
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * mutator method to change the name of the search
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * accessor method to get the state of the search
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * mutator method to change the state of the search
	 * 
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * accessor method to get the location of the search
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * mutator method to change the location of the search
	 * 
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * accessor method to get the control of the search
	 * 
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * mutator method to change the control of the search
	 * 
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * accessor method to get the enrollment upperbound of the search
	 * 
	 * @return the enrollmentUp
	 */
	public int getEnrollmentUp() {
		return enrollmentUp;
	}

	/**
	 * mutator method to change the upperbound for enrollment of the search
	 * 
	 * @param enrollmentUp the enrollmentUp to set
	 */
	public void setEnrollmentUp(int enrollmentUp) {
		this.enrollmentUp = enrollmentUp;
	}

	/**
	 * accessor method to get the enrollment lowerbound of the search
	 * 
	 * @return the enrollmentLo
	 */
	public int getEnrollmentLo() {
		return enrollmentLo;
	}

	/**
	 * mutator method to change the lowerbound for enrollment of the search
	 * 
	 * @param enrollmentLo the enrollmentLo to set
	 */
	public void setEnrollmentLo(int enrollmentLo) {
		this.enrollmentLo = enrollmentLo;
	}

	/**
	 * accessor method to get the percentFemale lowerbound of the search
	 * 
	 * @return the percentFemaleUp
	 */
	public int getPercentFemaleUp() {
		return percentFemaleUp;
	}

	/**
	 * mutator method to change the percentFemale upperbound of the search
	 * 
	 * @param percentFemaleUp the percentFemaleUp to set
	 */
	public void setPercentFemaleUp(int percentFemaleUp) {
		this.percentFemaleUp = percentFemaleUp;
	}

	/**
	 * accessor method to get the percentFemale lowerbound of the search
	 * 
	 * @return the percentFemaleLo
	 */
	public int getPercentFemaleLo() {
		return percentFemaleLo;
	}

	/**
	 * mutator method to change the percentFemale lowerbound of the search
	 * 
	 * @param percentFemaleLo the percentFemaleLo to set
	 */
	public void setPercentFemaleLo(int percentFemaleLo) {
		this.percentFemaleLo = percentFemaleLo;
	}

	/**
	 * accessor method to get the satVerb upperbound of the search
	 * 
	 * @return the satVerbUp
	 */
	public int getSatVerbUp() {
		return satVerbUp;
	}

	/**
	 * mutator method to change the satVerb upperbound of the search
	 * 
	 * @param satVerbUp the satVerbUp to set
	 */
	public void setSatVerbUp(int satVerbUp) {
		this.satVerbUp = satVerbUp;
	}

	/**
	 * accessor method to get the satVerb lowerbound of the search
	 * 
	 * @return the satVerbLo
	 */
	public int getSatVerbLo() {
		return satVerbLo;
	}

	/**
	 * mutator method to change the satVerbLo of the search
	 * 
	 * @param satVerbLo the satVerbLo to set
	 */
	public void setSatVerbLo(int satVerbLo) {
		this.satVerbLo = satVerbLo;
	}

	/**
	 * accessor method to get the satMath upperbound of the search
	 * 
	 * @return the satMathUp
	 */
	public int getSatMathUp() {
		return satMathUp;
	}

	/**
	 * mutator method to change the satMath upperbound of the search
	 * 
	 * @param satMathUp the satMathUp to set
	 */
	public void setSatMathUp(int satMathUp) {
		this.satMathUp = satMathUp;
	}

	/**
	 * accessor method to get the satMath lowerbound of the search
	 * 
	 * @return the satMathLo
	 */
	public int getSatMathLo() {
		return satMathLo;
	}

	/**
	 * mutator method to change the satMath lowerbound of the search
	 * 
	 * @param satMathLo the satMathLo to set
	 */
	public void setSatMathLo(int satMathLo) {
		this.satMathLo = satMathLo;
	}

	/**
	 * accessor method to get the expenses upperbound of the search
	 * 
	 * @return the expensesUp
	 */
	public int getExpensesUp() {
		return expensesUp;
	}

	/**
	 * mutator method to change the expenses upperbound of the search
	 * 
	 * @param expensesUp the expensesUp to set
	 */
	public void setExpensesUp(int expensesUp) {
		this.expensesUp = expensesUp;
	}

	/**
	 * accessor method to get the expenses lowerbound of the search
	 * 
	 * @return the expensesLo
	 */
	public int getExpensesLo() {
		return expensesLo;
	}

	/**
	 * mutator method to change the expenses lowerbound of the search
	 * 
	 * @param expensesLo the expensesLo to set
	 */
	public void setExpensesLo(int expensesLo) {
		this.expensesLo = expensesLo;
	}

	/**
	 * accessor method to get the financialAid upperbound of the search
	 * 
	 * @return the percentFinancialAidUp
	 */
	public int getPercentFinancialAidUp() {
		return percentFinancialAidUp;
	}

	/**
	 * mutator method to change the percentFinancialAid upperbound of the search
	 * 
	 * @param percentFinancialAidUp the percentFinancialAidUp to set
	 */
	public void setPercentFinancialAidUp(int percentFinancialAidUp) {
		this.percentFinancialAidUp = percentFinancialAidUp;
	}

	/**
	 * accessor method to get the percentFinancialAid lowerbound of the search
	 * 
	 * @return the percentFinancialAidLo
	 */
	public int getPercentFinancialAidLo() {
		return percentFinancialAidLo;
	}

	/**
	 * mutator method to change the percentFinancialAid lowerbound of the search
	 * 
	 * @param percentFinancialAidLo the percentFinancialAidLo to set
	 */
	public void setPercentFinancialAidLo(int percentFinancialAidLo) {
		this.percentFinancialAidLo = percentFinancialAidLo;
	}

	/**
	 * accessor method to get the applicants upperbound of the search
	 * 
	 * @return the applicantsUp
	 */
	public int getApplicantsUp() {
		return applicantsUp;
	}

	/**
	 * mutator method to change the applicants upperbound of the search
	 * 
	 * @param applicantsUp the applicantsUp to set
	 */
	public void setApplicantsUp(int applicantsUp) {
		this.applicantsUp = applicantsUp;
	}

	/**
	 * accessor method to get the applicants lowerbound of the search
	 * 
	 * @return the applicantsLo
	 */
	public int getApplicantsLo() {
		return applicantsLo;
	}

	/**
	 * mutator method to change the applicants lowerbound of the search
	 * 
	 * @param applicantsLo the applicantsLo to set
	 */
	public void setApplicantsLo(int applicantsLo) {
		this.applicantsLo = applicantsLo;
	}

	/**
	 * accessor method to get the percentAdmitted upperbound of the search
	 * 
	 * @return the percentAdmittedUp
	 */
	public int getPercentAdmittedUp() {
		return percentAdmittedUp;
	}

	/**
	 * mutator method to change the percentAdmitted upperbound of the search
	 * 
	 * @param percentAdmittedUp the percentAdmittedUp to set
	 */
	public void setPercentAdmittedUp(int percentAdmittedUp) {
		this.percentAdmittedUp = percentAdmittedUp;
	}

	/**
	 * accessor method to get the percentAdmitted lowerbound of the search
	 * 
	 * @return the percentAdmittedLo
	 */
	public int getPercentAdmittedLo() {
		return percentAdmittedLo;
	}

	/**
	 * mutator method to change the percentAdmitted lowerbound of the search
	 * 
	 * @param percentAdmittedLo the percentAdmittedLo to set
	 */
	public void setPercentAdmittedLo(int percentAdmittedLo) {
		this.percentAdmittedLo = percentAdmittedLo;
	}

	/**
	 * accessor method to get the percentEnroll upperbound of the search
	 * 
	 * @return the percentEnrollUp
	 */
	public int getPercentEnrollUp() {
		return percentEnrollUp;
	}

	/**
	 * mutator method to change the percentEnroll upperbound of the search
	 * 
	 * @param percentEnrollUp the percentEnrollUp to set
	 */
	public void setPercentEnrollUp(int percentEnrollUp) {
		this.percentEnrollUp = percentEnrollUp;
	}

	/**
	 * accessor method to get the percentEnroll lowerbound of the search
	 * 
	 * @return the percentEnrollLo
	 */
	public int getPercentEnrollLo() {
		return percentEnrollLo;
	}

	/**
	 * mutator method to change the percentEnroll lowerbound of the search
	 * 
	 * @param percentEnrollLo the percentEnrollLo to set
	 */
	public void setPercentEnrollLo(int percentEnrollLo) {
		this.percentEnrollLo = percentEnrollLo;
	}

	/**
	 * accessor method to get the academicScale upperbound of the search
	 * 
	 * @return the academicScaleUp
	 */
	public int getAcademicScaleUp() {
		return academicScaleUp;
	}

	/**
	 * mutator method to change the academicScale upperbound of the search
	 * 
	 * @param academicScaleUp the academicScaleUp to set
	 */
	public void setAcademicScaleUp(int academicScaleUp) {
		this.academicScaleUp = academicScaleUp;
	}

	/**
	 * accessor method to get the academicScale lowerbound of the search
	 * 
	 * @return the academicScaleLo
	 */
	public int getAcademicScaleLo() {
		return academicScaleLo;
	}

	/**
	 * mutator method to change the academicScale lowerbound of the search
	 * 
	 * @param academicScaleLo the academicScaleLo to set
	 */
	public void setAcademicScaleLo(int academicScaleLo) {
		this.academicScaleLo = academicScaleLo;
	}

	/**
	 * accessor method to get the socialScale upperbound of the search
	 * 
	 * @return the socialScaleUp
	 */
	public int getSocialScaleUp() {
		return socialScaleUp;
	}

	/**
	 * mutator method to change the socialScale upperbound of the search
	 * 
	 * @param socialScaleUp the socialScaleUp to set
	 */
	public void setSocialScaleUp(int socialScaleUp) {
		this.socialScaleUp = socialScaleUp;
	}

	/**
	 * accessor method to get the socialScale lowerbound of the search
	 * 
	 * @return the socialScaleLo
	 */
	public int getSocialScaleLo() {
		return socialScaleLo;
	}

	/**
	 * mutator method to change the socialScale lowerbound of the search
	 * 
	 * @param socialScaleLo the socialScaleLo to set
	 */
	public void setSocialScaleLo(int socialScaleLo) {
		this.socialScaleLo = socialScaleLo;
	}

	/**
	 * accessor method to get the qualOfLifeScale upperbound of the search
	 * 
	 * @return the qualOfLifeScaleUp
	 */
	public int getQualOfLifeScaleUp() {
		return qualOfLifeScaleUp;
	}

	/**
	 * mutator method to change the qualOfLifeScale upperbound of the search
	 * 
	 * @param qualOfLifeScaleUp the qualOfLifeScaleUp to set
	 */
	public void setQualOfLifeScaleUp(int qualOfLifeScaleUp) {
		this.qualOfLifeScaleUp = qualOfLifeScaleUp;
	}

	/**
	 * accessor method to get the qualOfLifeScale lowerbound of the search
	 * 
	 * @return the qualOfLifeScaleLo
	 */
	public int getQualOfLifeScaleLo() {
		return qualOfLifeScaleLo;
	}

	/**
	 * mutator method to change the qualOfLifeScale lowerbound of the search
	 * 
	 * @param qualOfLifeScaleLo the qualOfLifeScaleLo to set
	 */
	public void setQualOfLifeScaleLo(int qualOfLifeScaleLo) {
		this.qualOfLifeScaleLo = qualOfLifeScaleLo;
	}

	/**
	 * accessor method to get the emphasis of the search
	 * 
	 * @return the emphasis
	 */
	public List<String> getEmphasis() {
		return emphasis;
	}

	/**
	 * mutator method to change the emphases of the search
	 * 
	 * @param emphasis the emphasis to set
	 */
	public void setEmphasis(List<String> emphasis) {
		this.emphasis = emphasis;
	}
}
