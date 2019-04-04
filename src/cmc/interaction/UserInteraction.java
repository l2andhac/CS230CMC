package cmc.interaction;
import java.util.*;
import cmc.controller.*;
import cmc.entity.*;
/**
 * UserInteraction.class
 * This class serves as the interaction class for the user
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class UserInteraction extends AccountInteraction{
  //Attributes
  //The current User
  private User user;
  //A UserFunctionalityController to call the proper methods in the controllers
  private UserFunctionalityController userFunctCont;
  
  /**
 * Constructor for a UserInteraction
 * 
 * @param user - User that is the current user
 */
  public UserInteraction(User user) {
	super();
	this.user = user;
	this.userFunctCont = new UserFunctionalityController();
  }
  
  /**
   * method that return the username as a String
   * @return String - username of the User
   */
  public String getUsername() {
	  return this.user.getUsername();
  }
  
  /**
   * Allows the user to search for a friends saved schools
   * 
   * @param u - String which is the username to search by
   */
  public List<SavedSchool> searchForFriends(String u){
    
    List<SavedSchool> savedSchools = userFunctCont.searchForFriends(u);
    return savedSchools;
  }
  
  /**
   * Allows the user to request that their account be deactivated
   * 
   */
  public void requestDeactivation(){
    userFunctCont.requestDeactivation(this.user);
  }
  
  
 /**
  * User searches for a school using the parameters and returns a set of Universities
  * 
  * @param name - String that is the name of the school
  * @param state - String that is the state of the school
  * @param location - String that is the location setting of the school
  * @param control - String that is the school control type of the school
  * @param enrollmentUp - int that is the highest enrollment of a potential school
  * @param enrollmentLo - int that is the lowest enrollment of a potential school
  * @param percentFemaleUp -  double that is the highest percent of female students at the school
  * @param percentFemaleLo -  double that is the lowest percent of female students at the school
  * @param satVerbUp - double that is the highest average score on the SAT verbal of the school
  * @param satVerbLo - double that is the lowest average score on the SAT verbal of the school
  * @param satMathUp - double that is the highest average score on the SAT math of the school
  * @param satMathLo - double that is the lowest average score on the SAT math of the school
  * @param expensesUp - int that is the highest expense
  * @param expensesLo - int that is the lowest expense
  * @param percentFinancialAidUp - double that is the highest percentage of financial aid of the school
  * @param percentFinancialAidLo - double that is the lowest percentage of financial aid of the school
  * @param applicantsUp - int that is the highest number of applicants to the school
  * @param applicantsLo - int that is the lowest number of applicants to the school
  * @param percentAdmittedUp - double that is the highest percent of students who are admitted to the school
  * @param percentAdmittedLo - double that is the lowest percent of students who are admitted to the school
  * @param percentEnrollUp - double that is the highest percent of students who enroll in the school
  * @param percentEnrollLo - double that is the lowest percent of students who enroll in the school
  * @param academicScaleUp - int highest rating of the academics of the school
  * @param academicScaleLo - int lowest rating of the academics of the school
  * @param socialScaleUp - int highest rating of the social scale of the school
  * @param socialScaleLo - int lowest rating of the social scale of the school
  * @param qualOfLifeScaleUp - int highest rating of the quality of the school
  * @param qualOfLifeScaleLo - int lowest rating of the quality of the school
  * @param emphasis - List<String> that are academic emphases of the school
  * 
  * @return Set<University> that hold the Universities that match the search criteria
  */
  public Set<University> searchSchool(String name, String state, String location, String control, int enrollmentUp, 
                int enrollmentLo, int percentFemaleUp, int percentFemaleLo, int satVerbUp, 
                int satVerbLo, int satMathUp, int satMathLo, int expensesUp, int expensesLo, int percentFinancialAidUp, 
                int percentFinancialAidLo,  int applicantsUp, int applicantsLo, int percentAdmittedUp,
                int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp, 
                int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp,
                int qualOfLifeScaleLo, List<String> emphasis){
    Search s = new Search( name,state, location, control,enrollmentUp, enrollmentLo, percentFemaleUp, 
                          percentFemaleLo, satVerbUp, satVerbLo, satMathUp, satMathLo, expensesUp, expensesLo, percentFinancialAidUp, 
                          percentFinancialAidLo, applicantsUp, applicantsLo, percentAdmittedUp,
                          percentAdmittedLo, percentEnrollUp, percentEnrollLo, academicScaleUp, 
                          academicScaleLo, socialScaleUp, socialScaleLo, qualOfLifeScaleUp,
                          qualOfLifeScaleLo, emphasis);
    return userFunctCont.searchSchool(s);
  }
 

  /**
    * Allows the user to sort a list of Universities by a certain trait
    * 
    * @param list - Set<University> Universities to be sorted
    * @param c -character denoting what to sort by
    */
   public void sortResults(Set<University> list, char c){
     if(list != null) {
   List<University> aList = userFunctCont.sortResults(list, c);
   for(University uni : aList) {
   System.out.println(uni.getSchoolName());
   }
     }
     else {
     System.out.println("The list to sort is empty");
     }
   }

  
  
  
  /**
   * Allows a user to add a University to their saved school list
   * 
   * @param univ - University to add to the saved school list
   */
  public void saveSchool(University univ){
    userFunctCont.saveSchool(univ, this.user);
  }
  

  
  /**
   * Allows a user to remove a saved school from their saved school list
   * 
   * @param univ - University to remove from their saved school list
   */
  public void removeSavedSchool(String univ){
    userFunctCont.removeSavedSchool(univ, this.user);
  }
  
  
  /**
   * Allows a user to view their list of saved schools
   * 
   */
  public List<SavedSchool> viewSavedSchools(){
    List<SavedSchool> savedSchools = userFunctCont.viewSavedSchools(this.user);
    return savedSchools;
  }
  
  
  /**
   * Allows the user to compare two saved schools
   * 
   * @param s1 - SavedSchool that the user wishes to compare to
   */
  public void compareSavedSchools(String s1){
    userFunctCont.compareSavedSchools(s1);
  }
  
  
 
  
  
  /**
   * Shows the recommended schools for a user, by calling the method in UserFunctionalityController
   * 
   * @param school - String that is a school to find the 5 closest ones to
   */
  public void showRecSchools(String school){
    userFunctCont.showRecSchools(school);
  }
  
  

  
  

  
  
  /**
   * Allows the user to see their own information
   * 
   */
  public String viewAccountInfo(){
    return userFunctCont.viewAccountInfo(this.user);
  }
  
  
 /**
  * Allows the user to edit first name, last name, and password
  * 
  * @param un - String that is the username of the account
  * @param fn - String that is the first name of the account
  * @param ln - String that is the last name of the account
  * @param p - String that is the password of the account
  */
  public void editAccountInfo(String fn, String ln, String p){
	this.user.setFirstName(fn);
	this.user.setLastName(ln);
	this.user.setPassword(p);
    userFunctCont.editAccountInfo(user.getUsername(), fn, ln, p, 'u', this.user.getStatus()); 
  }

  
  /**
   * Allows a user to view the school details
   * 
   * @param schoolName - String of the University's name
   */
  public University viewSchoolDetails(String schoolName){
    University univ = userFunctCont.viewSchoolDetails(schoolName);
    return univ;
  }
  
  /**
   * Allows the user to log off
   * 
   */
  public void logOff(){
    this.user.logOff();
    System.out.println(this.user.toString());
  }
  
  
}
