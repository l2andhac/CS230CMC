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
	// instance variable for the Account
	private Account a;
	// instance variable for the DBController
	private DBController dbc;
	// instance variable for AccountInteraction ???? I added this, but she discuss
	// if it is necesary
	//private AccountInteraction ai;

	/**
	 * constructor that creates an AccountFunctionalityController object
	 */
	public AccountFunctionalityController() {
		this.ac = new AccountController();
		this.fpc = new ForgotPasswordController();
		this.a = null;
		this.dbc = new DBController();
		//this.ai = new AccountInteraction();
	}

	// Methods
	/**
	 * Allows an Account to Log onto the CMC
	 * 
	 * @param String
	 *            u as a username and String p as a password
	 * @return Account the Account that has attempted to log on
	 * @throws ....
	 */
	public Account logOn(String u, String p) {
		return ac.logOn(u, p);
		
	}

	/**
	 * Allows an Account to Log Off
	 * 
	 * @param none
	 * @return void
	 * @throws ...
	 */
	public void logOff() {
		ac.logOff();
	}

	/**
	 * Allows the Account to recover their password if the username is an email
	 * address
	 * 
	 * @param String
	 *            that is the username of the Account to recover the password for
	 * @return void
	 * @throw ...
	 */
	public void forgotPassword(String u) {
		String np = fpc.generateRandomPassword();
		Boolean email = fpc.checkIfEmail(u);
		this.a = dbc.findAccount(u);
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
	 * Allows the Account to view an Account's information
	 * 
	 * @param String
	 *            that is the username of the Account that the account wishes to view
	 * @return void
	 * @throws ....
	 */
	public void viewAccountInfo(String u) {
		this.a = dbc.findAccount(u);
		System.out.println(a.toString()); 
	}


	/**
	 * Allows an Account to view the details of a school
	 * 
	 * @param String
	 *            that is the name of the school to view the details of
	 * @return void
	 * @throw ...
	 */
	public void viewSchoolDetails(String schoolName) {
		dbc.getSchool(schoolName);
	}


}
