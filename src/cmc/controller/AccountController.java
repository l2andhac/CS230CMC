package cmc.controller;
import cmc.entity.*;
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
  
  private AccountFunctionalityController accountFunctionalityController;
  
  /*
   *Constructor for AccountController 
   * 
   * instaniates the instance variables
   */
  public AccountController()
  {
    this.controller = controller;
    this. account = account;
  }
  
  /*
   * LogOn method for accounts
   * 
   * @param username, a String that is the username
   * @param password, a String that is the password
   */
  public void logOn(String username, String password)
  {
    Account a = controller.findAccount(username);
    if (a != null)
    {
      String password2 = a.getPassword();
      if (password.equals(password2) && a.getStatus() != 'n')
      {
        this.account.logOn();
        accountFunctionalityController.setAccount(a);//another instance of afc need in this class??? also add to class diagram
      }
      else if (!password.equals(password2) )    {
        System.out.print("Incorrect password was given");
      }
      else if(a.getStatus() == 'n')
      {
        System.out.print("You cannot log in your account is deactivated");
      }
    }
    else
    {
      System.out.print("Incorrect information was given");
    }
    
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
  
  /*
   * updateAccountInfo method to update the Account information of either a user or admin
   * 
   * Users can update first name, last name, or password
   * Admins can update first name, last name, password, type, or status
   * 
   * @param a, an Account to be updated
   * @param fn, a String that is the first name
   * @param ln, a String that is the last name
   * @param p, a String that is the password
   * @param t, a String that is the type (either a or u)
   * @param s, a String that is the status (either y,n,p or d)
   * 
   */
  public void updateAccountInfo(Account a,String fn,String ln,String p,char t,char s)
  {
    a.setFirstName(fn);
    a.setLastName(ln);
    a.setPassword(p);
    a.setUserType('t');
    a.setStatus('s');
  }

  
}
