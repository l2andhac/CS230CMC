package cmc.controller;

import cmc.entity.*;

/**
 * AccountFinctionalityController.Java This class is the Controller for all
 * Accounts and their functionalities
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class AccountFunctionalityController {
	
	// instance variable for the AccountController
	private AccountController ac;
	// instance variable for the ForgotPasswordController
	private ForgotPasswordController fpc;
	// instance variable for the DBController
	private DBController dbc;

	/**
	 * constructor that creates an AccountFunctionalityController object by 
	 * instantiating an AccountController, ForgotPasswordController, and a DBController
	 */
	public AccountFunctionalityController() {
		this.ac = new AccountController();
		this.fpc = new ForgotPasswordController();
		this.dbc = new DBController();
	}

	/**
	 * Allows an Account to Log onto the CMC
	 * 
	 * @param u - String that is a username
	 * @param p - String that is a password
	 * @return Account - the Account that has attempted to log on
	 */
	public Account logOn(String u, String p) {
		return ac.logOn(u, p);
		
	}

	 /**
	   * User can request a new Account of type User
	   * 
	   * @param newUser - User to request a new account
	   * @throws IllegalArgumentException
	   */
	  public boolean requestNewAccount(User newUser) {
	    String username = newUser.getUsername();
	    boolean duplicate = dbc.findUsername(username);
	    if(duplicate == false) {
	      dbc.addAccount(newUser);
	      newUser.setStatus('P');
	      dbc.changeAccount(newUser);
	      return true;
	    }
	    
	    else {
	    	throw new IllegalArgumentException("Username is already taken by another account");
	    }
	    
	  }

	/**
	 * Allows the Account to recover their password if the username is an email
	 * address
	 * 
	 * @param u - String that is the username of the Account to recover the password for
	 * @throws IllegalArgumentException
	 */
	public boolean forgotPassword(String u) {
		String np = fpc.generateRandomPassword();
		Boolean email = fpc.checkIfEmail(u);
		Account a = dbc.findAccount(u);
		if (a != null) {
			if (email) {
				a.setPassword(np);
				dbc.changeAccount(a);
				fpc.emailNewPassword(u, a);
				return true;
			} else {
				throw new IllegalArgumentException("Username is not a valid email address");
			}
		} else {
			throw new IllegalArgumentException("Account not found");
		}
	}

	/**
	 * Allows the Account to view the details of an account
	 * 
	 * @param a - Account that is the account to be viewed
	 */
	public String viewAccountInfo(Account a) {
		return a.toString(); 
	}
	
	  
	  /**
	   * Allows an account to view the details of an account
	   * 
	   * @param u - String of the username to view the information for
	   */
	  public String viewAccountInfo(String u){
	    Account a = dbc.findAccount(u); 
	    return this.viewAccountInfo(a);
	  }


	/**
	 * Allows an Account to view the details of a school
	 * 
	 * @param schoolName - String that is the name of the school to view the details of
	 * @return University - University to view the details of
	 */
	public University viewSchoolDetails(String schoolName) {
		University univ = dbc.getSchool(schoolName);
		return univ;
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
	   * @throws IllegalArgumentException
	   */
	  public void editAccountInfo(String un, String fn, String ln, String p, char t, char s){
		  if(!(t == 'u' || t == 'a'))
			  throw new IllegalArgumentException("The type entered is invalid");
		  else if(!(s == 'D' || s == 'P' || s == 'Y' || s == 'N'))
			  throw new IllegalArgumentException("The status entered is invalid");
		  Account account = dbc.findAccount(un);
		  if(account == null) {
			  throw new IllegalArgumentException("The username entered was not found");
		  }
		  account.setFirstName(fn);
		    account.setLastName(ln);
		    account.setPassword(p);
		    account.setUserType(t);
		    account.setStatus(s);
		    dbc.changeAccount(account);
	  }

}
