package cmc.controller;

import java.util.*;
import cmc.entity.*;

/**
 * AdminFunctionalityController.class
 * This class is the Controller for Admins and their functionalities
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class AdminFunctionalityController extends AccountFunctionalityController{
  //Attributes
	//instance variable for DBController
  private DBController dbController;



  /**
   * Constructor for AdminFunctionalityController that creates an AdminFunctionalityController
   * and instantiates a DBController in the class
   * 
   * @param a - Admin that is the current admin
   */
  public AdminFunctionalityController(Admin a){
    super();
    dbController = new DBController();
   
  }
  
  
  /**
   * Allows an admin to remove a school from the Database
   * 
   * @param schoolName - String of university to be removed from Database
   * 
   * @throws IllegalArgumentException
   */
  public void removeSchool(String schoolName){
	University univ = dbController.getSchool(schoolName);
    boolean saved = dbController.isSchoolSaved(univ);
    boolean hasEmphasis = dbController.hasEmphasis(univ);
      if(saved == false && hasEmphasis == false){     
      dbController.removeSchool(univ);
      //System.out.println("\nThe school was removed.");
      }
      else if(saved == true) {
    	  throw new IllegalArgumentException("This school is saved by at least one user, so it cannot be removed from the database");
      }
      else if(hasEmphasis == true) {
    	  throw new IllegalArgumentException("This school has at least one emphasis, so it cannot be removed");
      }
    }
  
  
  
  /**
   * Allows an Admin to add a school to the Database
   * 
   * @param univ - University to be added to Database
   */
  public void addSchool(University univ){
    boolean found = dbController.findSchoolName(univ.getSchoolName());
    if (!found){
      dbController.addSchool(univ);
      //System.out.println("\nThe school was added to the database");
    }
    else {
    	throw new IllegalArgumentException("The school cannot be added because it is already in the database");
    }
  }
  
  
  /**
   * Allows an Admin to edit the school information
   * 
   * @param univ University object with the updated information
   */
  public void editSchoolInfo(University univ){
    dbController.editSchool(univ);
  }
  
  
  /**
   * Allows the Admin to view all of the Universities in the Database
   * 
   * @return Set<University> - A set of all the Schools in the database
   */
  public Set<University> viewAllSchools(){
    return dbController.getAllSchools();
  }
  
  
  /**
   * Allows the Admin to view all of the Accounts in the Database
   * 
   * @return Set<String> - a set of all of the Accounts in the database
   */
  public Set<String> viewAllAccounts(){
    return dbController.viewAllAccounts();
  }
  
  
  /**
   * Allows the Admin to add a new Account into the Database
   * 
   * @param newAccount - Account to be added into the Database
   */
  public void addAccount(Account newAccount){
    boolean duplicate = dbController.findUsername(newAccount.getUsername());
    if(duplicate == false){
      dbController.addAccount(newAccount);
    }
    
    
  }

  
}
