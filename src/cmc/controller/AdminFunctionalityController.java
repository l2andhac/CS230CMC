package cmc.controller;
import java.util.Set;

import cmc.entity.*;
import cmc.interaction.*;
/**
 * AdminFunctionalityController.class
 * This class is the Controller for Admins and their functionalities
 * 
 * @author L2 and the Hackstreet Boyz
 * @version 2/24/19
 */
public class AdminFunctionalityController extends AccountFunctionalityController{
  //Attributes
  private DBController dbController;
  private ForgotPasswordController forgotPasswordController;
  private AccountController accountController;

 
  //Methods
  /**
   * Constructor for AdminFunctionalityController that creates an AdminFunctionalityController
   * and instantiates a DBController in the class
   * 
   * @param admin - Admin that is the current admin
   */
  public AdminFunctionalityController(Admin a){
    super();
    dbController = new DBController();
   
  }
  
  
  /**
   * Allows an admin to remove a school from the Database
   * 
   * @param univ - University to be removed from Database
   */
  public void removeSchool(University univ){
    boolean saved = dbController.isSchoolSaved(univ);
    boolean hasEmphasis = dbController.hasEmphasis(univ);
      if(saved == false && hasEmphasis == false){     
      dbController.removeSchool(univ);
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
    }
  }
  
  
  /**
   * Allows an Admin to view a School
   * 
   * @param univ - University that the Admin wishes to view
   */
  public void adminViewSchool(University univ){
    //is this the same as viewing a school's details? Is an admin not being able to save it a GUI thin?
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
   * Allows an Admin to edit an Account's information
   * 
   * @param un - String that is the username of the Account to edit
   * @param fn - String that is the first name of the Account
   * @param ln - String that is the last name of the Account
   * @param p - String that is the password of the Account
   * @param t - Character that represents the type of the Account
   * @param s - Character that represents the status of the Account
   */
  public void editAccountInfo(String un, String fn, String ln, String p, char t, char s){
	  Account account = dbController.findAccount(un);
	  account.setFirstName(fn);
	    account.setLastName(ln);
	    account.setPassword(p);
	    account.setUserType(t);
	    account.setStatus(s);
	    dbController.changeAccount(account);
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
  
  /**
   * Allows the admin to see their own information
   * 
   * @param u - String of the username to view the information for
   */
  public void viewAccountInfo(String u){
    Account a = dbController.findAccount(u); 
    super.viewAccountInfo(a);
  }
  
}