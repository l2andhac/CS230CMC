package cmc.controller;
import cmc.entity.*;
/**
 * This is a controller class for account controller.
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */

public class AccountController{
  
  //instance variable for database controller
  private DBController controller;

  /**
   *Constructor for AccountController 
   * 
   * Instantiates the instance variables for DBController and sets the account instance variable to null
   */
  public AccountController()
  {
    this.controller = new DBController();
    
  }
  
  /**
   * LogOn method for accounts
   * 
   * @param username - String that is the username
   * @param password - String that is the password
   * @return Account - Account to be logged on
   * @throws NullPointerException
   */
  public Account logOn(String username, String password) throws NullPointerException
  {
	  Account account = controller.findAccount(username);
	    if (account != null)
	    {
	      String password2 = account.getPassword();
	      if (password.equals(password2) && account.getStatus() != 'N')
	      {
	        account.logOn();
	        System.out.println("You have successfully logged on to CMC");
	        return account;
	      }
	      else if (!password.equals(password2) )    {
	        System.out.println("Incorrect password was given");
	        
	      }
	      else if(account.getStatus() == 'N')
	      {
	        System.out.println("You cannot log in your account is deactivated");
	      }
	    }
	    else
	    {
	      System.out.println("Incorrect information was given");
	    }
	    return null;

  }  
}
