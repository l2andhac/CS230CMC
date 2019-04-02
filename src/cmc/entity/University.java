package cmc.entity;

import java.util.*;
/**
 * This is a base class for university.
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
  
public class University{
  
  // name of school
  private String schoolName;
  //state of school
  private String state;
  //location of school: suburban, urban, small-city, or -1 if unknown
  private String location;
  //control of the school: private, state, city, or -1 if unknown 
  private String control;
  //number of students of a school
  private int numberOfStudents;
  //percentage of students that are female
  private double percentFemale;
  //average SAT verbal score for enrolled students (between 0 and 800)
  private double satVerbal;
  //average SAT math score for enrolled students (between 0 and 800)
  private double satMath;
  //annual expenses
  private double expenses;
  //percent of enrolled students recieving financial aid
  private double percentFinancialAid;
  //number of applicants for school
  private int numberOfApplicants;
  //percent of applicants that get admitted
  private double percentAdmitted;
  //percent of applicants that decide to enroll
  private double percentEnrolled;
  //academic scale of school (1-5)
  private int academicsScale;
  //social scale of school (1-5)
  private int socialScale;
  //quality scale of school (1-5)
  private int qualityScale;
  //list of up to 5 areas of study in which the school excels
  private List<String> emphases;
  
  /** Constructor for a University object
   *
   * @param schoolName - String that is the name of school
   * @param state - String that is the state of school
   * @param location - String that is the location of school: suburban, urban, small-city, or -1 if unknown
   * @param control - String that is the control of the school: private, state, city, or -1 if unknown 
   * @param numberOfStudents - int that is the number of students of a school
   * @param percentFemale - int that is the percentage of students that are female
   * @param percentMale - double that is the percentage of students that are male
   * @param satVerbal - double that is the average SAT verbal score for enrolled students (between 0 and 800)
   * @param satMath - double that is the average SAT math score for enrolled students (between 0 and 800)
   * @param expenses - double that is the annual expenses
   * @param percentFinancialAid - double that is the percent of enrolled students recieving financial aid
   * @param numberOfApplicants  - int that is the number of applicants for school
   * @param percentAdmitted - double that is the percent of applicants that get admitted
   * @param percentEnrolled - double that is the percent of applicants that decide to enroll
   * @param academicsScale - int that is the academic scale of school (1-5)
   * @param socialScale - int that is the social scale of school (1-5)
   * @param qualityScale - int that is the quality scale of school (1-5)
   * @param emphases - List<String> list of up to 5 areas of study in which the school excels
   * 
   */
  public University(String schoolName, String state, String location, String control, int numberOfStudents, double percentFemale, double satVerbal, double satMath, double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityScale, List<String> emphases)

  {
    this.schoolName = schoolName;
    this.state = state;
    this.location = location;
    this.control = control;
    this.numberOfStudents = numberOfStudents;
    this.percentFemale = percentFemale;
    this.satVerbal = satVerbal;
    this.satMath = satMath;
    this.expenses = expenses;
    this.percentFinancialAid = percentFinancialAid;
    this.numberOfApplicants = numberOfApplicants;
    this.percentAdmitted = percentAdmitted;
    this.percentEnrolled = percentEnrolled;
    this.academicsScale = academicsScale;
    this.socialScale = socialScale;
    this.qualityScale = qualityScale;
    this.emphases = emphases; 
    
  }
  
  /**
   * accessor method for school name
   * 
   * @return String - school name
   */
  public String getSchoolName()
  {
    return this.schoolName;
  }
  
    /**
   * accessor method for state
   * 
   * @return String - state
   */
  public String getState()
  {
    return this.state;
  }
  
    /**
   * accessor method for location
   * 
   * @return String - location
   */
  public String getLocation()
  {
    return this.location;
  }
  
    /**
   * accessor method for control
   * 
   * @return Sting - control
   */
  public String getControl()
  {
    return this.control;
  }
  
    /**
   * accessor method for number of students
   * 
   * @return int - numberOfStudents
   */
  public int getNumStudents()
  {
    return this.numberOfStudents;
  }
  
      /**
   * accessor method for percent female
   * 
   * @return double percentFemale
   */
  public double getPercentFemales()
  {
    return this.percentFemale;
  }
  
      /**
   * accessor method for SATVerbal
   * 
   * @return double - satVerbal
   */
  public double getSATVerbal()
  {
    return this.satVerbal;
  }
  
      /**
   * accessor method for SATMath
   * 
   * @return double - satMath
   */
  public double getSATMath()
  {
    return this.satMath;
  }
  
      /**
   * accessor method for school name
   * 
   * @return double - expenses
   */
  public double getExpenses()
  {
    return this.expenses;
  }
  
      /**
   * accessor method for percentFinancialAid
   * 
   * @return double - percentFinancialAid
   */
  public double getPercentFinancialAid()
  {
    return this.percentFinancialAid; 
  }
  
      /**
   * accessor method for number of Apllicants
   * 
   * @return int - numberOfApplicants
   */
  public int getNumApplicants()
  {
    return this.numberOfApplicants;
  }
  
      /**
   * accessor method for percentAdmitted
   * 
   * @return double - percentAdmitted
   */
  public double getPercentAdmitted()
  {
    return this.percentAdmitted;
  }
  
      /**
   * accessor method for percentEnrolled
   * 
   * @return double percentEnrolled
   */
  public double getPercentEnrolled()
  {
    return this.percentEnrolled;
  }
  
      /**
   * accessor method for academic scale
   * 
   * @return int academicScale
   */
  public int getAcademicScale()
  {
    return this.academicsScale;
  }
  
      /**
   * accessor method for social scale
   * 
   * @return int - socialScale
   */
  public int getSocialScale()
  {
    return this.socialScale;
  }
  
      /**
   * accessor method for quality of life scale
   * 
   * @return int - qualityScale
   */
  public int getQualityOfLifeScale()
  {
    return this.qualityScale;
  }
  
  /**
   * accessor method for emphases
   * 
   * @return List<String> - emphases
   */
  public List<String> getEmphases()
  {
    return this.emphases;
  }

  public boolean equals(University u) {
	  if(!this.schoolName.equals(u.getSchoolName())) 
			  return false;
	  else if(!(this.state.equals(u.getState()))) 
		  return false;
	  else if(!(this.location.equals(u.getLocation())))
		  return false;
	  else if(!(this.control.equals(u.getControl())))
		  return false;
	  else if(!(this.numberOfStudents == u.getNumStudents()))
		  return false;
	  else if(!(this.percentFemale == u.getPercentFemales()))
		  return false;
	  else if(!(this.satVerbal == u.getSATVerbal()))
		  return false;
	  else if(!(this.satMath == u.getSATMath()))
		  return false;
	  else if(!(this.expenses == u.getExpenses()))
		  return false;
	  else if(!(this.percentFinancialAid == u.getPercentFinancialAid()))
		  return false;
	  else if(!(this.numberOfApplicants == u.getNumApplicants()))
		  return false;
	  else if(!(this.percentEnrolled == u.getPercentEnrolled()))
		  return false;
	  else if(!(this.percentAdmitted == u.getPercentAdmitted()))
		  return   false;
	  else if(!(this.academicsScale == u.getAcademicScale()))
		  return false;
	  else if (!(this.socialScale == u.getSocialScale()))
		  return false;
	  else if(!(this.qualityScale == u.getQualityOfLifeScale()))
		  return false;
	  else if(!(this.emphases.equals(u.getEmphases())))
		  return false;
	 
	  return true;  
	  
  }
  
  /////   COMPARATORS   /////////////
  /*Comparator for sorting the list by expenses*/
  public static Comparator<University> compareByExpenses = new Comparator<University>() {
	  
	/**
	 * compare method for expenses
	 * 
	 *   @param u1 - University the first University to compare
	 *   @param u2 - Universtiy that is the second school to compare
	 *   @return int - if its positive u1 is greater than u2, if int is negative u1 is less than u2, if its 0 they are equal
	 */
    public int compare(University u1, University u2) {
      double univ1Expenses = u1.getExpenses();
      double univ2Expenses = u2.getExpenses();
      
      //from smallest to largest
      return Double.compare(univ1Expenses, univ2Expenses);
    }
  };
  
  /*Comparator for sorting the list by percent admitted*/
  public static Comparator<University> compareByAdmission = new Comparator<University>() {
    
	  /**
		 * compare method for percent Admitted
		 * 
		 *   @param u1 - University that is the first University to compare
		 *   @param u2 - University that is thesecond school to compare
		 *   @return int - if its positive u1 is greater than u2, if int is negative u1 is less than u2, if its 0 they are equal
		 */
	  public int compare(University u1, University u2) {
      double univ1Admission = u1.getPercentAdmitted();
      double univ2Admission = u2.getPercentAdmitted();
      
      //from smallest to largest
      return Double.compare(univ1Admission, univ2Admission);
    }
  };
  
  /*Comparator for sorting the list by number of students*/
  public static Comparator<University> compareByNumberStudents = new Comparator<University>() {
    
	  /**
		 * compare method for number of students
		 * 
		 *   @param u1 - University that is the first University to compare
		 *   @param u2 - University that is the second school to compare
		 *   @return int - if its positive u1 is greater than u2, if int is negative u1 is less than u2, if its 0 they are equal
		 */
	  public int compare(University u1, University u2) {
      int univ1NumStudents = u1.getNumStudents();
      int univ2NumStudents = u2.getNumStudents();
      
      //from smallest to largest
      return univ1NumStudents-univ2NumStudents;
    }
  };
  

  /**
   * @Override overrides the toString method
   * 
   * @returns a string
   */
	public String toString() {
		return "University [schoolName=" + schoolName + ", state=" + state + ", location=" + location + ", control="
				+ control + ", numberOfStudents=" + numberOfStudents + ", percentFemale=" + percentFemale
				+ ", satVerbal=" + satVerbal + ", satMath=" + satMath + ", expenses=" + expenses
				+ ", percentFinancialAid=" + percentFinancialAid + ", numberOfApplicants=" + numberOfApplicants
				+ ", percentAdmitted=" + percentAdmitted + ", percentEnrolled=" + percentEnrolled + ", academicsScale="
				+ academicsScale + ", socialScale=" + socialScale + ", qualityScale=" + qualityScale + ", emphases="
				+ emphases + "]";
	}
}