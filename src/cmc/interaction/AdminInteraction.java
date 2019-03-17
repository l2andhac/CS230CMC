package cmc.interaction;
import java.util.*;
import cmc.entity.*;
import cmc.controller.*;
/**
 * AdminInteraction.class
 * This class serves as the interaction class for the admin
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class AdminInteraction extends AccountInteraction{
  //Attributes
  //The current Admin
  private Admin admin;
  //A AdminFunctionalityController to call the proper methods in the controllers
  private AdminFunctionalityController adminFunctCont;
  
  
  /**
 * Constructor for an AdminInteraction
 * 
 * @param admin - Admin of the AdminInteraction
 */
  public AdminInteraction(Admin admin) {
	super();
	this.admin = admin;
	this.adminFunctCont = new AdminFunctionalityController(admin);
  }
  
  public String getUsername() {
	  return this.admin.getUsername();
  }


//Methods
  /**
   * Allows an admin to remove a school from the database
   * 
   * @param schoolName - String of university to be removed
   */
  public void removeSchool(String schoolName){
    adminFunctCont.removeSchool(schoolName);
  }
  
  

  /**
   * Allows the Admin to add a school to the database
   * 
   * @param schoolName - String that is the name of the school to be added
   * @param state - String that is the state of the school to be added
   * @param location - String that is the location setting of the school to be added
   * @param control - String that is the school control type of the school to be added
   * @param numberOfStudents - int that is the number of Students of the school to be added
   * @param percentFemale - double that the percent of female students at the school to be added
   * @param satVerbal - double that is the average score on the SAT verbal of the school to be added
   * @param satMath - double that is the average score on the SAT math of the school to be added
   * @param expenses - double that is the cost of the school to be added
   * @param percentFinancialAid - double that is the percentage of financial aid of the school to be added
   * @param numberOfApplicants - int that is the number of applicants to the school
   * @param percentAdmitted - double that is the percent of students who are admitted to the school
   * @param percentEnrolled - double that is the percent of students who enroll in the school
   * @param academicScale - 
   * @param socialScale -
   * @param qualityScale -
   * @param emphases - List<String> that are academic emphases of the schools
   */
  public void addSchool(String schoolName, String state, String location,
                        String control, int numberOfStudents, double percentFemale,
                         double satVerbal, double satMath,
                        double expenses, double percentFinancialAid, int numberOfApplicants,
                        double percentAdmitted, double percentEnrolled, int academicScale,
                        int socialScale, int qualityScale, List<String> emphases
  ){
    University school = new University(schoolName, state, location, control, numberOfStudents,
                                       percentFemale, satVerbal, satMath, expenses,
                                       percentFinancialAid, numberOfApplicants, percentAdmitted,
                                       percentEnrolled, academicScale, socialScale, qualityScale,
                                       emphases
                                       );
    adminFunctCont.addSchool(school);
  }
  
  
  
  /**
   * Allows the admin to edit a school
   * 
   * @param String schoolName, String state, String location,
                        String control, int numberOfStudents, double percentFemale,
                         double satVerbal, double satMath,
                        double expenses, double percentFinancialAid, int numberOfApplicants,
                        double percentAdmitted, double percentEnrolled, int academicScale,
                        int socialScale, int qualityScale, List<String> emphases

   */
  public void editSchool(String schoolName, String state, String location,
                        String control, int numberOfStudents, double percentFemale,
                         double satVerbal, double satMath,
                        double expenses, double percentFinancialAid, int numberOfApplicants,
                        double percentAdmitted, double percentEnrolled, int academicScale,
                        int socialScale, int qualityScale
  ){
    University school = new University(schoolName, state, location, control, numberOfStudents,
                                       percentFemale, satVerbal, satMath, expenses,
                                       percentFinancialAid, numberOfApplicants, percentAdmitted,
                                       percentEnrolled, academicScale, socialScale, qualityScale, null
                                       
                                       );
    adminFunctCont.editSchoolInfo(school);
  }
  
  
  /**
   * Allows the admin to view all the schools in the database
   * 
   * @retun Set<University> - Universities to be viewed
   */
  public Set<University> viewAllSchools(){  
    return adminFunctCont.viewAllSchools();
  }
  
  
  /**
   * Allows the admin to view all the accounts in the database
   * 
   * @return Set<String> - Accounts to be viewed
   */
  public Set<String> viewAllAccounts(){
    return adminFunctCont.viewAllAccounts();
  }
  
  
  
  /**
   * Allows the admin to add a new account into the database
   * 
   * @param un - String that is the username of the account to add
   * @param fn - String that is the last name of the account to add
   * @param ln - String that is the first name of the account to add
   * @param p - String that is the password of the account to add
   * @param t - Character that is the type of the Account
   * @param s - Character that is the status of the Account
   */
  public void addAccount(String fn, String ln, String u, String p, char t, char s){
    Account a;
    if(t == 'u'){
      a = new User(fn, ln, u, p, s);
    }else if(t == 'a'){
      a = new Admin(fn, ln, u, p, s);
    }
    else {
      a = null;
    }
    adminFunctCont.addAccount(a); // this method takes a Account as param
  }
  
  
  //Inherited methods
  
  /**
   * Allows the admin to see their own information
   */
  public void viewAccountInfo(){
    adminFunctCont.viewAccountInfo(this.admin); 
  }
  
  /**
   * Allows the admin to see their own information
   * 
   * @param u - String of the username to view the information for
   */
  public void viewAccountInfo(String u){
    adminFunctCont.viewAccountInfo(u); 
  }
  
  
  /**
   * Allows the admin to edit first name, last name, and password/////////////// change to edit everything
   * 
   * @param un - String that is the username of the account to edit
   * @param fn - String that is the last name of the account to edit
   * @param ln - String that is the first name of the account to edit
   * @param p - String that is the password of the account to   edit
   * @param t - Character that is the type of the Account
   * @param s - Character that is the status of the Account
   */
  public void editAccountInfo(String un, String fn, String ln, String p, char t, char s){
    adminFunctCont.editAccountInfo(un, fn, ln, p, t, s); 
    // editAccountInfo should take all the parameters not an Account in the AdminInteraction class
  }
  
  
  /**
   * Allows an admin to view the school details
   * 
   * @param schoolName - String of the University's name
   */
  public void viewSchoolDetails(String schoolName){
    University univ = adminFunctCont.viewSchoolDetails(schoolName);
    if(univ != null) {
    	System.out.println(univ.toString());
    }else {
    	System.out.println("The school was not found");
    }
  }

  /**
   * Allows the admin to log off
   * 
   */
  public void logOff(){
    this.admin.logOff();
    System.out.println(this.admin.toString());
  }
    
}
