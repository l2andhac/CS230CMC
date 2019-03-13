package cmc.interaction;
import java.util.*;
import java.io.*;
import cmc.controller.*;
import cmc.entity.*;
/**
 * UserInteraction.class
 * This class serves as the interaction class for the user
 * 
 * @author L2 and the Hackstreet Boyz
 * @version 2/23/19
 */
public class UserInteraction extends AccountInteraction{
  //Attributes
  //The current User
  private User user;
  //A UserFunctionalityController to call the proper methods in the controllers
  private UserFunctionalityController userFunctCont;
  
  
  //Methods
  
  /**
 * Constructor for a UserInteraction
 * 
 * @param User
 */
  public UserInteraction(User user) {
	super();
	this.user = user;
	this.userFunctCont = new UserFunctionalityController(user);
  }
  
  public String getUsername() {
	  return this.user.getUsername();
  }
  
  /**
   * Allows the user to search for a friends saved schools
   * 
   * @param a String u which is the username to search by
   * @return a boolean if the search is successful
   * @throws none
   */
  public void searchForFriends(String u){
    
    List<SavedSchool> list = userFunctCont.searchForFriends(u);
    // display list to user
  }
  
  /*
   * Allows the user to request that their account be deactivated
   * 
   * @param none
   * @return none
   * @throws none
   */
  public void requestDeactivation(){
    userFunctCont.requestDeactivation();
  }
  
  
  /**
   * Allows the user to search for a school
   * 
   * @param String name, state, location, control, int enrollmentUp, 
                enrollmentLo, percentFemaleUp, percentFemaleLo, satVerbUp, 
                satVerbLo, int satMathUp, satMathLo, percentFinancialAidUp, 
                percentFinancialAidLo,  applicantsUp,  applicantsLo, percentAdmittedUp,
                percentAdmittedLo, percentEnrollUp, percentEnrollLo,  academicScaleUp, 
                academicScaleLo, socialScaleUp, socialScaleLo, qualOfLifeScaleUp,
                qualOfLifeScaleLo, List<String> emphasis
   * @return none
   * @throws none
   */
  public Set<University> searchSchool(String name, String state, String location, String control, int enrollmentUp, 
                int enrollmentLo, int percentFemaleUp, int percentFemaleLo, int satVerbUp, 
                int satVerbLo, int satMathUp, int satMathLo, int percentFinancialAidUp, 
                int percentFinancialAidLo,  int applicantsUp, int applicantsLo, int percentAdmittedUp,
                int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp, 
                int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp,
                int qualOfLifeScaleLo, List<String> emphasis){
    Search s = new Search( name,state, location, control,enrollmentUp, enrollmentLo, percentFemaleUp, 
                          percentFemaleLo, satVerbUp, satVerbLo, satMathUp, satMathLo, percentFinancialAidUp, 
                          percentFinancialAidLo, applicantsUp, applicantsLo, percentAdmittedUp,
                          percentAdmittedLo, percentEnrollUp, percentEnrollLo, academicScaleUp, 
                          academicScaleLo, socialScaleUp, socialScaleLo, qualOfLifeScaleUp,
                          qualOfLifeScaleLo, emphasis);
    return userFunctCont.searchSchool(s);
  }
  
  
  /**
   * Allows the user to view the results of a search
   * 
   * @param a list of schools to display
   * @return none
   * @throws none
   */
  public void viewResults(List<University> list){
    //////////////////////////display results
  }
  
  
  /**
   * Allows the user to sort a list of Usiversities by a certain trait
   * 
   * @param a list of University to be sorted and a character denoting what to sort by
   * @return the sorted list
   * @throws none
   */
  public List<University> sortResults(List<University> list, char c){
    //return userFunctCont.sortResults(list, c);
    return null;
  }
  
  
  
  /**
   * Allows a user to add a University to their saved school list
   * 
   * @param A University to add to the saved school list
   * @return none
   * @throws none
   */
  public void saveSchool(University univ){
    userFunctCont.saveSchool(univ);
  }
  
  
  /**
   * Allows a user to view a searched school
   * 
   * @param University to view
   * @return none
   * @throws none
   */
  public void viewSearchedSchool(University univ){
    userFunctCont.viewSearchedSchool(univ);
  }
  
  
  /**
   * Allows a user to remove a saved school from their saved school list
   * 
   * @param University to remove from their saved school list
   * @return none
   * @throws none
   */
  public void removeSavedSchool(SavedSchool univ){
    userFunctCont.removeSavedSchool(univ);
  }
  
  
  /**
   * Allows a user to view their list of saved schools
   * 
   * @param none
   * @return none
   * @throws none
   */
  public void viewSavedSchools(){
    userFunctCont.viewSavedSchools();
  }
  
  
  /**
   * Allows the user to compare two saved schools
   * 
   * @param the SavedSchool that the user wishes to compare to
   * @return none
   * @throws none
   */
  public void compareSavedSchools(SavedSchool s1){
    SavedSchool s2 = requestForSecondSchool();
    userFunctCont.compareSavedSchools(s1, s2);
  }
  
  
  /**
   * User can request to make a new account
   * 
   * @param a String first name, last name, username, and password
   * @return none
   * @throws none
   */
  public void requestNewAccount(String fn, String ln, String u, String p){
    User user = new User(fn, ln, u, p, 'p');
    userFunctCont.requestNewAccount(user);
  }
  
  
  /**
   * Requests for the second school to compare to
   * 
   * @param none
   * @return SavedSchool to compare
   * @throws none
   */
  public SavedSchool requestForSecondSchool(){
    ///////////////////////////////////////////////////
    return null;
  }
  
  
  /**
   * Shows the recommended schools for a user, by calling the method in UserFunctionalityController
   * 
   * @param String that is a school to find the 5 closest ones to
   * @return none
   * @throws none
   */
  public void showRecSchools(String school){
    userFunctCont.showRecSchools(school);
  }
  
  

  
  

  
  
  /**
   * Allows the user to see their own information
   * 
   * @param String of the username to view the information for
   * @return none
   * @throws none
   */
  public void viewAccountInfo(String u){
    userFunctCont.viewAccountInfo(u);
  }
  
  
  /**
   * Allows the user to edit first name, last name, and password
   * 
   * @param An Account,String for first name, last name, and password
   * @return none
   * @throws none
   */
  public void editAccountInfo(String un, String fn, String ln, String p){
    userFunctCont.editUserInfo(un, fn, ln, p, 'u', this.user.getStatus()); 
  }
  
  
  /**
   * Allows the current user to be set
   * 
   * @param the current User
   * @return none
   * @throws none
   */
  public void setAccount(User a){
    user = a;
  }
  
  
  /**
   * Allows a user to view the school details
   * 
   * @param String of the University's name
   * @return none
   * @throws none
   */
  public void viewSchoolDetails(String schoolName){
    University univ = userFunctCont.viewSchoolDetails(schoolName);
    if(univ != null) {
    	System.out.println(univ.toString());
    }else {
    	System.out.println("The school was not found");
    }
  }
  
  
}
