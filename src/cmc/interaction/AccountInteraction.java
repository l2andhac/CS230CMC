package cmc.interaction;
import cmc.entity.*;
import cmc.controller.*;
/**
 * AccountInteraction.class
 * This class is the abstract class for the account interaction
 * 
 * @author L2 and the Hackstreet Boyz
 * @version 2/23/19
 */
public class AccountInteraction{
	  //An accountFunctionalityController to call methods on
      private AccountFunctionalityController accountFunctCont;
      //an adminInteraction to pass after logging in, if account is an admin
      private AdminInteraction adminInteraction;
      //a userInteraction to pass after logging in, if account is a user
      private UserInteraction userInteraction;
      
	  /**
	 * Constructor for an AccountInteraction
	 * 
	 * @param none
	 * 
	 */
	public AccountInteraction() {
	
		this.accountFunctCont = new AccountFunctionalityController();
	}

	/**
	   * Allows the user to log on
	   * 
	   * @param Strings username and password
	   * @return AccountInteraction
	   * @throws none
	   */
	  public AccountInteraction logOn(String u, String p){
	    Account a = accountFunctCont.logOn(u,p);
	    if(a != null) {
	    if(a.getUserType() == 'u') {
	    	return new UserInteraction((User) a);
	    }
	    else if(a.getUserType() == 'a') {
	    	return new AdminInteraction((Admin) a);
	    }
	    }
	    return null;
	    
	  }
	  
	  /**
	   * Allows the user to log off
	   * 
	   * @param none
	   * @return none
	   * @throws none
	   */
	  public void logOff(){
	    accountFunctCont.logOff();
	  }
	  
	  
	  /**
	   * Allows the user to request to get password back if forgotten
	   * 
	   * @param String with the username
	   * @return none
	   * @throws none
	   */
	  public void forgotPassword(String u){
	    accountFunctCont.forgotPassword(u);
	  }
	
	
 /* public void setAccount(Account a){
	  accountFunctCont(a);
  }*/
}
