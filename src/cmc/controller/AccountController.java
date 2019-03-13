package cmc.controller;
import cmc.entity.*;
import cmc.interaction.AccountInteraction;
/*
 * This is a controller class for account controller.
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 2/21/2019
 */

public class AccountController{
  
  //instance variable for database controller
  private DBController controller;
  //instance variable for account
  private Account account; 
  
  
  /*
   *Constructor for AccountController 
   * 
   * Instantiates the instance variables for DBController and sets the account instance variable to null
   */
  public AccountController()
  {
    this.controller = new DBController();
    this.account = null;
  }
  
  /*
   * LogOn method for accounts
   * 
   * @param username, a String that is the username
   * @param password, a String that is the password
   * @throws NullPointerException
   */
  public Account logOn(String username, String password) throws NullPointerException
  {
	  this.account = controller.findAccount(username);
	    if (account != null)
	    {
	      String password2 = account.getPassword();
	      if (password.equals(password2) && account.getStatus() != 'N')
	      {
	        this.account.logOn();
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
//    this.account = controller.findAccount(username);
//    
//    if(account == null) {
//    	throw new NullPointerException();
//    }
//    
//  
//    else
//    {
//      String password2 = account.getPassword();
//      if (password.equals(password2) && account.getStatus() != 'N')
//      {
//        this.account.logOn();
//        System.out.println("You have successfully logged on to CMC");
//        return account;
//      }
//      else if (!password.equals(password2) )    {
//       System.out.println("Incorrect password was given");
//       
//      }
//      else if(account.getStatus() == 'N')
//      {
//        System.out.println("You cannot log in your account is deactivated");
//      }
//    }
    
//    else
//    {
//      System.out.println("Incorrect information was given");
//    }

    
  }
  
  /*
   *LogOff method for accounts
   * 
   */
  public void logOff()
  {
    this.account.logOff();
    //take user back to main page??
  }
  

  
}
