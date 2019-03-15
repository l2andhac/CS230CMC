package cmc.controller;
import cmc.entity.*;
import cmc.interaction.AdminInteraction;

/**
 * @author Lindsay Will, Steffi Tapsoba
 * @version February 21, 2019
 * 
 * A Class that controls all of the functionalities of a User
 */
import java.util.*;

public class UserFunctionalityController extends AccountFunctionalityController{
  //User
  private SearchController searchController;
  private SavedSchool savedSchool;
  private DBController dbController;
  
  /**
   * Constructor for AdminFunctionalityController
   * 
   * @param User user
   */
  public UserFunctionalityController(){
    super();  
    this.dbController = new DBController();
  }
  
  
  
  /**
   * User can view their own account info
   * 
   * @param u - the User to be view information for
   */
  public void viewUserInfo(User u){
    super.viewAccountInfo(u);
  }
  
  /**
   * User can edit their account
   * 
   * @param un - String that is the username of the User
   * @param fn - String that is the first name of the User
   * @param ln - String that is the last name of the User
   * @param p - String that is the password of the User
   * @param t - Character that is the type of the User
   * @param s - Character that is the status of the User
   */
  public void editUserInfo(String un, String fn, String ln, String p, char t, char s){ 
	  Account user = dbController.findAccount(un);
      user.setFirstName(fn);
      user.setLastName(ln);
      user.setPassword(p);
      user.setUserType(t);
      user.setStatus(s);
    dbController.changeAccount(user);
  }
  
  /**
   * View details of a school
   * 
   * @param schoolName - String that is the name of the school
   */
  public University viewSchoolDetails(String schoolName){
    boolean found = dbController.findSchoolName(schoolName);
    if(found == true) {
      University univ = dbController.getSchool(schoolName);
      return univ;
    }
    return null;
  }
  
  
  /**
   * Allows the User to search a "friend" (another User) for their list of SavedSchools
   * 
   * @param username - String representing the username of the "friend" that the current User is trying to search for
   * @return boolean - representing if the "friend" has any SavedSchools
   */
  public List<SavedSchool> searchForFriends(String username){
    User friend = (User) dbController.findAccount(username);
    return viewSavedSchools(friend);
//    if(friend.getUserType() == 'a') {
//      System.out.println("The username entered is incorrect");
//    }
//    
//    else if(friend != null && friend.getUserType() == 'u') {
//      List<SavedSchool> list = friend.getSavedSchools(); 
//      return list;                                      
//    }
//    return null;
  }
  
  /**
   * User can request for their status to be set to 'd' for deactivated
   * 
   * @param user - User requesting deactivation
   */
  public void requestDeactivation(User user){
    user.setStatus('d');
    dbController.changeStatus(user, 'd');
  }
  
  /**
   * User can search for schools that match the parameter criteria
   * 
   * @param searchObject - Search Object with all the parameters for a University
   */
  public Set<University> searchSchool(Search searchObject){ ///////////COME BACK TO ADD PARAMS
    if(searchObject != null) {
      return this.dbController.findSearchedSchool(searchObject);
    }
    
    else {
      System.out.println("All the fields are empty");
      return null;
    }
    
  }
  
  /**
   * View results of searched schools
   * @param univs - List<University> Universities to be sorted
   * @param howToSort - char 
   * @return List<University> - The sorted list of the Universities
   */
  public List<University> sortResults(List<University> univs, char howToSort){
    //I'm probably thinking to much but I found that
    //https://www.javadevjournal.com/java/java-sorting-example-comparable-comparator/
    //https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
    //To sort a list according to a specified comparator -> we will have to implement that in the University class
    
    List<University> newList = new ArrayList<University>();
    if(howToSort =='e') { //expenses
      Collections.sort(univs, University.compareByExpenses);
    }
    
    else if(howToSort == 'a') { //percent admitted
      Collections.sort(univs, University.compareByAdmission);
    }
    
    else if(howToSort == 'n') { //number of students
      Collections.sort(univs, University.compareByNumberStudents);
    }
    return univs; 
  }
  
  /**
   * Save school to make a University a SavedSchool
   * 
   * @param univ - the University to save
   * @param user - the User to save the school to
   */
  public void saveSchool(University univ, User user){
    List<SavedSchool> list = user.getSavedSchools();
    
    SavedSchool schoolToSave = new SavedSchool(univ, "time");
    if(list == null || !list.contains(schoolToSave)) {
      
      dbController.addSavedSchool(user, schoolToSave);
      user.addSavedSchool(schoolToSave);
    }
    
    else {
      System.out.println("This school has already been saved");
    }
  }
  
  /**
   * View a particular University from results
   * 
   * @param univ - University to view
   */
  public void viewSearchedSchool(University univ){
    //Should we do a System.out.println to display all the school info (name, state, location, SAt,...) ?
    //System.out.println(""+univ.getName()+", "+univ.getState()+", "+...);
  }
  
  
  /**
   * Remove a SavedSchool from User's list of SavedSchools
   * 
   * @param schoolToRemove - String that schoolName of the SavedSchool to remove
   * @param user - User to remove the SavedSchool from
   */
  public void removeSavedSchool(String schoolToRemove, User user){
    dbController.removeSavedSchool(user, schoolToRemove);
    //user.removeSavedSchool(schoolToRemove);
  }
  
  /**
   * View list of SavedSchools
   * 
   * @param user - User that will have SavedSchools viewed
   * @return List<SavedSchool> - SavedSchools of the User
   */
  public List<SavedSchool> viewSavedSchools(User user){
    List<SavedSchool> savedSchools = dbController.getSavedSchools(user);
    return savedSchools;
  }
  
  /**
   * Compare two SavedSchools in the User's list of SavedSchools
   * 
   * @param s1 - SavedSchool to compare
   * @param s2 - SavedSchool to compare
   */
  public void compareSavedSchools(SavedSchool s1, SavedSchool s2){
    System.out.println("University 1: "+s1);
    System.out.println("University 2: "+s2);
  }
  
  /**
   * User can request a new Account of type User
   * 
   * @param newUser - User to request a new account
   */
  public void requestNewAccount(User newUser) {
    String username = newUser.getUsername();
    boolean duplicate = dbController.findUsername(username);
    if(duplicate == false) {
      dbController.requestNewAccount(newUser);
    }
    
    else {
      System.out.println("This username is already taken");
    }
  }
  
  /**
   *???
   */
  public void viewResults() {
    //view results of what? this method seems to only be in the UserInteraction class according to 
    //the communication diagram
  }


/**
 * calls the method of DBCOntroller to find 5 most related schools 
 * 
 * @param school - String that is the schoolName of the University to find related schools
 */
public void showRecSchools(String school) {
	dbController.findRecSchools(school);
}
  
  
}








