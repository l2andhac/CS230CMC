package cmc.entity;

import java.util.*;

/*
 * This class is a search object
 * @author l^2AndTheHackstreetBoys
 * @version Feb 21, 2019
 */
public class Search {
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

	/*
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
			int percentFinancialAidUp, int percentFinancialAidLo, int applicantsUp, int applicantsLo,
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * @param control
	 *            the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * @return the enrollmentUp
	 */
	public int getEnrollmentUp() {
		return enrollmentUp;
	}

	/**
	 * @param enrollmentUp
	 *            the enrollmentUp to set
	 */
	public void setEnrollmentUp(int enrollmentUp) {
		this.enrollmentUp = enrollmentUp;
	}

	/**
	 * @return the enrollmentLo
	 */
	public int getEnrollmentLo() {
		return enrollmentLo;
	}

	/**
	 * @param enrollmentLo
	 *            the enrollmentLo to set
	 */
	public void setEnrollmentLo(int enrollmentLo) {
		this.enrollmentLo = enrollmentLo;
	}

	/**
	 * @return the percentFemaleUp
	 */
	public int getPercentFemaleUp() {
		return percentFemaleUp;
	}

	/**
	 * @param percentFemaleUp
	 *            the percentFemaleUp to set
	 */
	public void setPercentFemaleUp(int percentFemaleUp) {
		this.percentFemaleUp = percentFemaleUp;
	}

	/**
	 * @return the percentFemaleLo
	 */
	public int getPercentFemaleLo() {
		return percentFemaleLo;
	}

	/**
	 * @param percentFemaleLo
	 *            the percentFemaleLo to set
	 */
	public void setPercentFemaleLo(int percentFemaleLo) {
		this.percentFemaleLo = percentFemaleLo;
	}

	/**
	 * @return the satVerbUp
	 */
	public int getSatVerbUp() {
		return satVerbUp;
	}

	/**
	 * @param satVerbUp
	 *            the satVerbUp to set
	 */
	public void setSatVerbUp(int satVerbUp) {
		this.satVerbUp = satVerbUp;
	}

	/**
	 * @return the satVerbLo
	 */
	public int getSatVerbLo() {
		return satVerbLo;
	}

	/**
	 * @param satVerbLo
	 *            the satVerbLo to set
	 */
	public void setSatVerbLo(int satVerbLo) {
		this.satVerbLo = satVerbLo;
	}

	/**
	 * @return the satMathUp
	 */
	public int getSatMathUp() {
		return satMathUp;
	}

	/**
	 * @param satMathUp
	 *            the satMathUp to set
	 */
	public void setSatMathUp(int satMathUp) {
		this.satMathUp = satMathUp;
	}

	/**
	 * @return the satMathLo
	 */
	public int getSatMathLo() {
		return satMathLo;
	}

	/**
	 * @param satMathLo
	 *            the satMathLo to set
	 */
	public void setSatMathLo(int satMathLo) {
		this.satMathLo = satMathLo;
	}

	/**
	 * @return the percentFinancialAidUp
	 */
	public int getPercentFinancialAidUp() {
		return percentFinancialAidUp;
	}

	/**
	 * @param percentFinancialAidUp
	 *            the percentFinancialAidUp to set
	 */
	public void setPercentFinancialAidUp(int percentFinancialAidUp) {
		this.percentFinancialAidUp = percentFinancialAidUp;
	}

	/**
	 * @return the percentFinancialAidLo
	 */
	public int getPercentFinancialAidLo() {
		return percentFinancialAidLo;
	}

	/**
	 * @param percentFinancialAidLo
	 *            the percentFinancialAidLo to set
	 */
	public void setPercentFinancialAidLo(int percentFinancialAidLo) {
		this.percentFinancialAidLo = percentFinancialAidLo;
	}

	/**
	 * @return the applicantsUp
	 */
	public int getApplicantsUp() {
		return applicantsUp;
	}

	/**
	 * @param applicantsUp
	 *            the applicantsUp to set
	 */
	public void setApplicantsUp(int applicantsUp) {
		this.applicantsUp = applicantsUp;
	}

	/**
	 * @return the applicantsLo
	 */
	public int getApplicantsLo() {
		return applicantsLo;
	}

	/**
	 * @param applicantsLo
	 *            the applicantsLo to set
	 */
	public void setApplicantsLo(int applicantsLo) {
		this.applicantsLo = applicantsLo;
	}

	/**
	 * @return the percentAdmittedUp
	 */
	public int getPercentAdmittedUp() {
		return percentAdmittedUp;
	}

	/**
	 * @param percentAdmittedUp
	 *            the percentAdmittedUp to set
	 */
	public void setPercentAdmittedUp(int percentAdmittedUp) {
		this.percentAdmittedUp = percentAdmittedUp;
	}

	/**
	 * @return the percentAdmittedLo
	 */
	public int getPercentAdmittedLo() {
		return percentAdmittedLo;
	}

	/**
	 * @param percentAdmittedLo
	 *            the percentAdmittedLo to set
	 */
	public void setPercentAdmittedLo(int percentAdmittedLo) {
		this.percentAdmittedLo = percentAdmittedLo;
	}

	/**
	 * @return the percentEnrollUp
	 */
	public int getPercentEnrollUp() {
		return percentEnrollUp;
	}

	/**
	 * @param percentEnrollUp
	 *            the percentEnrollUp to set
	 */
	public void setPercentEnrollUp(int percentEnrollUp) {
		this.percentEnrollUp = percentEnrollUp;
	}

	/**
	 * @return the percentEnrollLo
	 */
	public int getPercentEnrollLo() {
		return percentEnrollLo;
	}

	/**
	 * @param percentEnrollLo
	 *            the percentEnrollLo to set
	 */
	public void setPercentEnrollLo(int percentEnrollLo) {
		this.percentEnrollLo = percentEnrollLo;
	}

	/**
	 * @return the academicScaleUp
	 */
	public int getAcademicScaleUp() {
		return academicScaleUp;
	}

	/**
	 * @param academicScaleUp
	 *            the academicScaleUp to set
	 */
	public void setAcademicScaleUp(int academicScaleUp) {
		this.academicScaleUp = academicScaleUp;
	}

	/**
	 * @return the academicScaleLo
	 */
	public int getAcademicScaleLo() {
		return academicScaleLo;
	}

	/**
	 * @param academicScaleLo
	 *            the academicScaleLo to set
	 */
	public void setAcademicScaleLo(int academicScaleLo) {
		this.academicScaleLo = academicScaleLo;
	}

	/**
	 * @return the socialScaleUp
	 */
	public int getSocialScaleUp() {
		return socialScaleUp;
	}

	/**
	 * @param socialScaleUp
	 *            the socialScaleUp to set
	 */
	public void setSocialScaleUp(int socialScaleUp) {
		this.socialScaleUp = socialScaleUp;
	}

	/**
	 * @return the socialScaleLo
	 */
	public int getSocialScaleLo() {
		return socialScaleLo;
	}

	/**
	 * @param socialScaleLo
	 *            the socialScaleLo to set
	 */
	public void setSocialScaleLo(int socialScaleLo) {
		this.socialScaleLo = socialScaleLo;
	}

	/**
	 * @return the qualOfLifeScaleUp
	 */
	public int getQualOfLifeScaleUp() {
		return qualOfLifeScaleUp;
	}

	/**
	 * @param qualOfLifeScaleUp
	 *            the qualOfLifeScaleUp to set
	 */
	public void setQualOfLifeScaleUp(int qualOfLifeScaleUp) {
		this.qualOfLifeScaleUp = qualOfLifeScaleUp;
	}

	/**
	 * @return the qualOfLifeScaleLo
	 */
	public int getQualOfLifeScaleLo() {
		return qualOfLifeScaleLo;
	}

	/**
	 * @param qualOfLifeScaleLo
	 *            the qualOfLifeScaleLo to set
	 */
	public void setQualOfLifeScaleLo(int qualOfLifeScaleLo) {
		this.qualOfLifeScaleLo = qualOfLifeScaleLo;
	}

	/**
	 * @return the emphasis
	 */
	public List<String> getEmphasis() {
		return emphasis;
	}

	/**
	 * @param emphasis
	 *            the emphasis to set
	 */
	public void setEmphasis(List<String> emphasis) {
		this.emphasis = emphasis;
	}
}
