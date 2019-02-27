package cmc.entity;
import java.util.*;
/*
 * This class is a search object
 * @author l^2AndTheHackstreetBoys
 * @version Feb 21, 2019
 */
public class Search{
  //name of the school
  private String name;
  //name of the state
  private String state;
  //whether school urban, rural, etc
  private String location;
  //whether school is public or private
  private String control;
  //the upperbound of enrollment
  private int enrollmentUp;
  //the lowerbound of enrollment
  private int enrollmentLo;
  //the upperbound of the percentage of female students
  private int percentFemaleUp;
  //the lowerbound of the percentage of female students
  private int percentFemaleLo;
  //the upperbound of sat verbal scores
  private int satVerbUp;
  //the lowerbound of sat verbal scores
  private int satVerbLo;
  //the upperbound of sat math scores
  private int satMathUp;
  //the lowerbound of sat math scores
  private int satMathLo;
  //the upperbound of the percent financial aid
  private int percentFinancialAidUp;
  //the lowerbound of the percent financial aid
  private int percentFinancialAidLo;
  //the upperbond of the number of applicants
  private int applicantsUp;
  //the lowerebound of the number of applicants
  private int applicantsLo;
  //the upperbound of the percent of applicants admitted
  private int percentAdmittedUp;
  //the lowerbound of the percent of applicants admitted
  private int percentAdmittedLo;
  //the upperbound of the percent of admitted students who enroll
  private int percentEnrollUp;
  //the lowerbound of the percent of admitted students who enroll
  private int percentEnrollLo;
  //the upperbound of the academic scale rating
  private int academicScaleUp;
  //the lowerbound of the academic scale rating
  private int academicScaleLo;
  //the upperbound of the social scale rating
  private int socialScaleUp;
  //the lowerbound of the social scale rating
  private int socialScaleLo;
  //the upperbound of the quality of life scale rating
  private int qualOfLifeScaleUp;
  //the lowerbound of the quality of life scale rating
  private int qualOfLifeScaleLo;
  //the list of emphases that a school has
  private List<String> emphasis;
  
  /*
   * Constructs a search object with the given parameters
   * @param name to search
   * @param state to search
   * @param location type to search
   * @param control type to search
   * @param enrollmentUp upperbound of enrollment
   * @param enrollmentLo lowerbound of enrollment
   * @param percentFemaleUp upperbound of the percentage of female students
   * @param percentFemaleLo lowerbound of the percentage of female students
   * @param satVerbUp upperbound of the sat verbal scores
   * @param satVerbLo lowerbound of the sat verbal scores
   * @param satMathUp upperbound of the sat math scores
   * @param satMathLo lowerbound of the sat math scores
   * @param percentFinancialAidUp upperbound of the percentage of financial aid
   * @param percentFinancialAidLo lowerbound of the percentage of financial aid
   * @param applicantsUp upperbound of the number of applicants
   * @param applicantsLo lowerbound of the number of applicants
   * @param percentAdmittedUp upperbound of the percent of applicants admitted
   * @param percentAdmittedLo lowerbound of the percent of applicants admitted
   * @param percentEnrollUp upperbound of the percent of admitted students who enroll
   * @param percentEnrollLo lowerbound of the percent of admitted students who enroll
   * @param academicScaleUp upperbound of the academic scale
   * @param academicScaleLo lowerbound of the academic scale
   * @param socialScaleUp upperbound of the social scale
   * @param socialScaleLo upperbound of the social scale
   * @param qualOfLifeScaleUp upperbound of the quality of life scale
   * @param qualOfLifeScaleLo lowerbound of the quality of life scale
   * @param emphasis the areas of focus of a school
   */
  public Search(String name, String state, String location, String control, int enrollmentUp, 
                int enrollmentLo, int percentFemaleUp, int percentFemaleLo, int satVerbUp, 
                int satVerbLo, int satMathUp, int satMathLo, int percentFinancialAidUp, 
                int percentFinancialAidLo,  int applicantsUp, int applicantsLo, int percentAdmittedUp,
                int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp, 
                int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp,
                int qualOfLifeScaleLo, List<String> emphasis){
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
  }
  