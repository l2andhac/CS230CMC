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
      private AccountFunctionalityController accountFunctCont;
      private AdminInteraction adminInteraction;
      private UserInteraction userInteraction;
      
	  /**
	 * 
	 */
	public AccountInteraction() {
	
		this.accountFunctCont = new AccountFunctionalityController();
	}

	/**
	   * Allows the user to log on
	   * 
	   * @param Strings username and password
	   * @return none
	   * @throws ....
	   */
	  public AccountInteraction logOn(String u, String p){
	    accountFunctCont.logOn(u,p);
	    if(userInteraction != null) {
	    	return userInteraction;
	    }
	    else if(adminInteraction != null) {
	    	return adminInteraction;
	    }
	    return null;
	  }
	  
	  /**
	   * Allows the user to log off
	   * 
	   * @param none
	   * @return none
	   * @throws ...
	   */
	  public void logOff(){
	    accountFunctCont.logOff();
	  }
	  
	  
	  /**
	   * Allows the user to request to get password back if forgotten
	   * 
	   * @param String with the username
	   * @return none
	   * @throws ...
	   */
	  public void forgotPassword(String u){
	    accountFunctCont.forgotPassword(u);
	  }
	
	
  public void setAccount(Account a){
	  if(a.getUserType() == 'a') {
		 this.adminInteraction = new AdminInteraction((Admin)a);
		 
	  }
	  else if(a.getUserType() == 'u') {
		this.userInteraction = new UserInteraction((User)a);
		  
	  }
  }
}
