package cmc.entity;
import java.io.*;
import java.util.*;
/*
 * This is a base class for university.
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 2/21/2019
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
  
  /* Consturctor for a University object
   *
   * @param schoolName, name of school
   * @param state, state of school
   * @param location, location of school: suburban, urban, small-city, or -1 if unknown
   * @param control, control of the school: private, state, city, or -1 if unknown 
   * @param numberOfStudents, number of students of a school
   * @param percentFemale, percentage of students that are female
   * @param percentMale, percentage of students that are male
   * @param satVerbal, average SAT verbal score for enrolled students (between 0 and 800)
   * @param satMath, average SAT math score for enrolled students (between 0 and 800)
   * @param expenses, annual expenses
   * @param percentFinancialAid, percent of enrolled students recieving financial aid
   * @param numberOfApplicants, number of applicants for school
   * @param percentAdmitted, percent of applicants that get admitted
   * @param percentEnrolled, percent of applicants that decide to enroll
   * @param academicScale, academic scale of school (1-5)
   * @param socialScale, social scale of school (1-5)
   * @param qualityScale, quality scale of school (1-5)
   * @param emphases, list of up to 5 areas of study in which the school excels
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
  
  /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public String getSchoolName()
  {
    return this.schoolName;
  }
  
    /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public String getState()
  {
    return this.state;
  }
  
    /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public String getLocation()
  {
    return this.location;
  }
  
    /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public String getControl()
  {
    return this.control;
  }
  
    /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public int getNumStudents()
  {
    return this.numberOfStudents;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getPercentFemales()
  {
    return this.percentFemale;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getSATVerbal()
  {
    return this.satVerbal;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getSATMath()
  {
    return this.satMath;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getExpenses()
  {
    return this.expenses;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getPercentFinancialAid()
  {
    return this.percentFinancialAid; 
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public int getNumApplicants()
  {
    return this.numberOfApplicants;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getPercentAdmitted()
  {
    return this.percentAdmitted;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public double getPercentEnrolled()
  {
    return this.percentEnrolled;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public int getAcademicScale()
  {
    return this.academicsScale;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public int getSocialScale()
  {
    return this.socialScale;
  }
  
      /*
   * accessor method for school name
   * 
   * @returns school name, a String
   */
  public int getQualityOfLifeScale()
  {
    return this.qualityScale;
  }
  
  public List<String> getEmphases()
  {
    return this.emphases;
  }
  
  /////   COMPARATORS   /////////////
  /*Comparator for sorting the list by expenses*/
  public static Comparator<University> compareByExpenses = new Comparator<University>() {
    public int compare(University u1, University u2) {
      double univ1Expenses = u1.getExpenses();
      double univ2Expenses = u2.getExpenses();
      
      //from smallest to largest
      return Double.compare(univ1Expenses, univ2Expenses);
    }
  };
  
  /*Comparator for sorting the list by percent admitted*/
  public static Comparator<University> compareByAdmission = new Comparator<University>() {
    public int compare(University u1, University u2) {
      double univ1Admission = u1.getPercentAdmitted();
      double univ2Admission = u2.getPercentAdmitted();
      
      //from smallest to largest
      return Double.compare(univ1Admission, univ2Admission);
    }
  };
  
  /*Comparator for sorting the list by percent admitted*/
  public static Comparator<University> compareByNumberStudents = new Comparator<University>() {
    public int compare(University u1, University u2) {
      int univ1NumStudents = u1.getNumStudents();
      int univ2NumStudents = u2.getNumStudents();
      
      //from smallest to largest
      return univ1NumStudents-univ2NumStudents;
    }
  };
}