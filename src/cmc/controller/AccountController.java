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
   * @throws IllegalArgumentException
   */
  public Account logOn(String username, String password)
  {
	  Account account = controller.findAccount(username);
	    if (account != null)
	    {
	      String password2 = account.getPassword();
	      if (password.equals(password2) && account.getStatus() != 'N' && account.getStatus() != 'P')
	      {
	        account.logOn();
	        //System.out.println("You have successfully logged on to CMC");
	        return account;
	      }
	      else if (!password.equals(password2) )    {
	        //System.out.println("Incorrect password was given");
	    	  throw new IllegalArgumentException("Incorrect password was given");
	        
	      }
	      else if(account.getStatus() == 'N')
	      {
	    	  throw new IllegalArgumentException("Account status is not valid");
	      }
	      else if(account.getStatus() != 'P')
	      {
	    	  throw new IllegalArgumentException("You cannot log in your account is pending");  
	      }
	    }
	    else
	    {
	    	throw new IllegalArgumentException("Incorrect information was given");
	    }
	    return null;

  }  
}
