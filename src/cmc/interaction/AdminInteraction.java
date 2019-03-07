package cmc.interaction;
import java.io.*;
import java.util.*;
import cmc.entity.*;
import cmc.controller.*;
/**
 * AdminInteraction.class
 * This class serves as the interaction class for the admin
 * 
 * @author L2 and the Hackstreet Boyz
 * @version 2/23/19
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
 * @param Admin
 */
  public AdminInteraction(Admin admin) {
	super();
	this.admin = admin;
	this.adminFunctCont = new AdminFunctionalityController(admin);
  }


//Methods
  /**
   * Allows an admin to remove a school from the database
   * 
   * @param University to be removed
   * @return none
   * @throws none
   */
  public void removeSchool(University univ){
    adminFunctCont.removeSchool(univ);
  }
  
  
  /**
   * Allows the Admin to add a school to the database
   * 
   * @param String schoolName, String state, String location,
                        String control, int numberOfStudents, double percentFemale,
                         double satVerbal, double satMath,
                        double expenses, double percentFinancialAid, int numberOfApplicants,
                        double percentAdmitted, double percentEnrolled, int academicScale,
                        int socialScale, int qualityScale, List<String> emphases
   * @return none
   * @throws none
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
   * Alllows the admin to view a school's details
   * 
   * @param A University to view
   * @return none
   * @throws none
   */
  public void adminViewSchool(University univ){
    adminFunctCont.adminViewSchool(univ);
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
   * @return none
   * @throws none
   */
  public void editSchool(String schoolName, String state, String location,
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
    adminFunctCont.editSchoolInfo(school);
  }
  
  
  /**
   * Allows the admin to view all the schools in the database
   * 
   * @param none
   * @retun Set<University>
   * @throws none
   */
  public Set<University> viewAllSchools(){  
    return adminFunctCont.viewAllSchools();
  }
  
  
  /**
   * Allows the admin to view all the accounts in the database
   * 
   * @param none
   * @return Set<String>
   * @throws none
   */
  public Set<String> viewAllAccounts(){
    return adminFunctCont.viewAllAccounts();
  }
  
  
  
  /**
   * Allows the admin to add a new account into the database
   * 
   * @param String for the first name, last name, username, password, and Char for type, and status
   * @return none
   * @throws none
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
   * 
   * @param String of the username to view the information for
   * @return none
   * @throws none
   */
  public void viewAccountInfo(String u){
    adminFunctCont.viewAccountInfo(u); 
  }
  
  
  /**
   * Allows the admin to edit first name, last name, and password/////////////// change to edit everything
   * 
   * @param An Account a
   * @return none
   * @throws none
   */
  public void editAccountInfo(Account a){
    adminFunctCont.editAccountInfo(a); 
    // editAccountInfo should take all the parameters not an Account in the AdminInteraction class
  }
  
  
  /**
   * Allows the current admin to be set
   * 
   * @param the current Account
   * @return none
   * @throws none
   */
  public void setAccount(Admin a){
    admin = a;
  }
  
  
  /**
   * Allows an admin to view the school details
   * 
   * @param String of the University's name
   * @return none
   * @throws none
   */
  public void viewSchoolDetails(String schoolName){
    adminFunctCont.viewSchoolDetails(schoolName);
  }

    
}
