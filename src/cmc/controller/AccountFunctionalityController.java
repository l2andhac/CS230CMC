package cmc.controller;

// currently unnecessary
import cmc.interaction.*;
import cmc.entity.*;

/**
 * AccountFinctionalityController.Java This class is the Controller for all
 * Accounts and their functionalities
 * 
 * @author L2 and the Hackstreet Boyz
 * @version 3/6/19
 */
public class AccountFunctionalityController {
	// Attributes
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

	// Methods
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
	 * Allows the Account to recover their password if the username is an email
	 * address
	 * 
	 * @param u - String that is the username of the Account to recover the password for
	 */
	public void forgotPassword(String u) {
		String np = fpc.generateRandomPassword();
		Boolean email = fpc.checkIfEmail(u);
		Account a = dbc.findAccount(u);
		if (a != null) {
			if (email) {
				a.setPassword(np);
				dbc.changeAccount(a);
			} else {
				System.out.println("Your username is not a valid email address");
			}
		} else {
			System.out.println("Account not found");
		}
	}

	/**
	 * Allows the Account to view a different Account's information
	 * 
	 * @param a - Account that is the account to be viewed
	 */
	public void viewAccountInfo(Account a) {
		System.out.println(a.toString()); 
	}


	/**
	 * Allows an Account to view the details of a school
	 * 
	 * @param schoolName - String that is the name of the school to view the details of
	 */
	public University viewSchoolDetails(String schoolName) {
		University univ = dbc.getSchool(schoolName);
		return univ;
	}


}
