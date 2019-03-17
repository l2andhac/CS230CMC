package cmc.interaction;
import java.util.*;
import java.io.*;
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
 * @param User
 */
  public UserInteraction(User user) {
	super();
	this.user = user;
	this.userFunctCont = new UserFunctionalityController();
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
    
    List<SavedSchool> savedSchools = userFunctCont.searchForFriends(u);
    if(savedSchools != null) {
    	for(SavedSchool school : savedSchools) {
    		System.out.println(""+school);
    	}
    }else {
    	System.out.println("No saved schools to display");
    }
  }
  
  /*
   * Allows the user to request that their account be deactivated
   * 
   * @param none
   * @return none
   * @throws none
   */
  public void requestDeactivation(){
    userFunctCont.requestDeactivation(this.user);
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
    * Allows the user to sort a list of Universities by a certain trait
    * 
    * @param a list of University to be sorted and a character denoting what to sort by
    * @return the sorted list
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
   * @param A University to add to the saved school list
   * @return none
   * @throws none
   */
  public void saveSchool(University univ){
    userFunctCont.saveSchool(univ, this.user);
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
  public void removeSavedSchool(String univ){
    userFunctCont.removeSavedSchool(univ, this.user);
  }
  
  
  /**
   * Allows a user to view their list of saved schools
   * 
   * @param none
   * @return none
   * @throws none
   */
  public void viewSavedSchools(){
    List<SavedSchool> savedSchools = userFunctCont.viewSavedSchools(this.user);
    if(savedSchools != null) {
    	for(SavedSchool school : savedSchools) {
    		System.out.println(""+school);
    	}
    }else {
    	System.out.println("No saved schools to display");
    }
  }
  
  
  /**
   * Allows the user to compare two saved schools
   * 
   * @param the SavedSchool that the user wishes to compare to
   * @return none
   * @throws none
   */
  public void compareSavedSchools(String s1){
    userFunctCont.compareSavedSchools(s1);
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
  public void viewAccountInfo(){
    userFunctCont.viewAccountInfo(this.user);
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
  
  /**
   * Allows the user to log off
   * 
   * @param none
   * @return none
   * @throws none
   */
  public void logOff(){
    this.user.logOff();
    System.out.println(this.user.toString());
  }
  
  
}
