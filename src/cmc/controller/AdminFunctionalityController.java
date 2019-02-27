package cmc.controller;
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
  private Admin a;
  private AdminInteraction ai;
  //Methods
  /**
   * Constructor for AdminFunctionalityController
   * 
   * @param Admin admin
   * @return void
   * @throws ....
   */
  public AdminFunctionalityController(Admin a){
    super();
    this.a = a;   
    this.ai = new AdminInteraction();
  }
  
  
  /**
   * Allows an admin to remove a school from the Database
   * @param University to be removed from Database
   * @return void
   * @throws .......
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
   * @param University to be added to Database
   * @return void
   * @throw .....
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
   * @param University that the Admin wishes to view
   * @return void
   * @throws ....
   */
  public void adminViewSchool(University univ){
    //is this the same as viewing a school's details? Is an admin not being able to save it a GUI thin?
  }
  
  
  /**
   * Allows an Admin to edit the school information
   * 
   * @param University object with the updated information
   * @return void
   * @throws ....
   */
  public void editSchoolInfo(University univ){
    dbController.editSchool(univ);
  }
  
  
  /**
   * Allows an Admin to edit an Account's information
   * 
   * @param Account object with the updated information
   * @return void
   * @throws ....
   */
  public void editAccountInfo(Account a){
    accountController.updateAccountInfo(a, a.getFirstName(), a.getLastName(), a.getPassword(), a.getUserType(), a.getStatus());
  }
  
  
  /**
   * Allows the Admin to view a list of all of the Universities in the Database
   * 
   * @param none
   * @return void
   * @throws ....
   */
  public void viewAllSchools(){
    dbController.getAllSchools();
  }
  
  
  /**
   * Allows the Admin to view a list of all of the Accounts in the Database
   * 
   * @param none
   * @return void
   * @throws ...
   */
  public void viewAllAccounts(){
    dbController.viewAllAccounts();
  }
  
  
  /**
   * Allows the Admin to add a new Account into the Database
   * 
   * @param Account to be added into the Database
   * @return void
   * @throws ...
   */
  public void addAccount(Account newAccount){
    boolean duplicate = dbController.findUsername(newAccount.getUsername());
    if(duplicate == false){
      dbController.addAccount(newAccount);
    }
  }
  
}