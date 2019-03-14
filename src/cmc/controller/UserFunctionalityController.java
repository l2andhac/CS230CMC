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
   * @return void
   * @throws ....
   */
  public UserFunctionalityController(){
    super();  
    this.dbController = new DBController();
  }
  
  
  
  /**
   * User can view their own account info
   * 
   * @param username is the username of the User
   */
  public void viewUserInfo(User u){
    super.viewAccountInfo(u);
  }
  
  /**
   * User can edit their account
   * 
   * @param User is the current User???
   * @params fn, ln, p, un are String info
   * @params t, s are char info
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
   * @param schoolName is the name of the school
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
   * @param a String username of the "friend" that the current User is trying to search for
   * @returns a boolean representing if the "friend" has any SavedSchools
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
   */
  public void requestDeactivation(User user){
    user.setStatus('d');
    dbController.changeStatus(user, 'd');
  }
  
  /**
   * User can search for schools that match the parameter criteria
   * 
   * @params all parameters are the criteria
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
   * @param univ is the University to save
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
   * @param univ is the University to view
   */
  public void viewSearchedSchool(University univ){
    //Should we do a System.out.println to display all the school info (name, state, location, SAt,...) ?
    //System.out.println(""+univ.getName()+", "+univ.getState()+", "+...);
  }
  
  
  /**
   * Remove a SavedSchool from User's list of SavedSchools
   * 
   * @param schoolToRemove is the SavedSchool to remove
   */
  public void removeSavedSchool(String schoolToRemove, User user){
    dbController.removeSavedSchool(user, schoolToRemove);
    //user.removeSavedSchool(schoolToRemove);
  }
  
  /**
   * View list of SavedSchools
   */
  public List<SavedSchool> viewSavedSchools(User user){
    List<SavedSchool> savedSchools = dbController.getSavedSchools(user);
    return savedSchools;
  }
  
  /**
   * Compare two SavedSchools in the User's list of SavedSchools
   * 
   * @param s1 and s2 are the two SavedSchools to compare
   */
  public void compareSavedSchools(SavedSchool s1, SavedSchool s2){
    System.out.println("University 1: "+s1);
    System.out.println("University 2: "+s2);
  }
  
  /**
   * User can request a new Account of type User
   * 
   * @param newUser is the new User that was created from the params in the UserInteraction class
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
   *
   */
  public void viewResults() {
    //view results of what? this method seems to only be in the UserInteraction class according to 
    //the communication diagram
  }


/**
 * calls the method of DBCOntroller to find 5 most related schools 
 * 
 * @param school
 */
public void showRecSchools(String school) {
	dbController.findRecSchools(school);
}
  
  
}








