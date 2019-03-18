package cmc.interaction;
import cmc.entity.*;
import cmc.controller.*;
/**
 * AccountInteraction.class
 * This is the class for the account interaction
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class AccountInteraction{
	  //An accountFunctionalityController to call methods on
      private AccountFunctionalityController accountFunctCont;
      //an adminInteraction to pass after logging in, if account is an admin
      private AdminInteraction adminInteraction;
      //a userInteraction to pass after logging in, if account is a user
      private UserInteraction userInteraction;
      
	  /**
	 * Constructor for an AccountInteraction that creates an AccountFunctionalityController object
	 * 
	 */
	public AccountInteraction() {
	
		this.accountFunctCont = new AccountFunctionalityController();
	}

	/**
	   * Allows the user to log on
	   * 
	   * @param u - String that is the username of the account attempting to login
	   * @param p - String that is the password of the account attempting to login
	   * @return AccountInteraction - to be used to react with a logged on user
	   */
	  public AccountInteraction logOn(String u, String p){
	    Account a = accountFunctCont.logOn(u,p);
	    if(a != null) {
	    if(a.getUserType() == 'u') {
	    	userInteraction = new UserInteraction((User) a);
	    	return userInteraction;
	    }
	    else if(a.getUserType() == 'a') {
	    	adminInteraction = new AdminInteraction((Admin) a);
	    	return adminInteraction;
	    }
	    }
	    return null;
	    
	  }
	  
	
	  /**
	   * User can request to make a new account
	   * 
	   * @param fn - String that is the first name of the account
	   * @param ln - String that is the last name of the account
	   * @param u - String that is the username of the account
	   * @param p - String that is the password for the account
	   */
	  public void requestNewAccount(String fn, String ln, String u, String p){
	    User user = new User(fn, ln, u, p, 'p');
	    AccountFunctionalityController afc = new AccountFunctionalityController();
	    afc.requestNewAccount(user);
	  }
	  
	  /**
	   * Allows the user to request to get password back if forgotten
	   * 
	   * @param u - String with the username
	   */
	  public void forgotPassword(String u){
	    accountFunctCont.forgotPassword(u);
	  }
	
}
