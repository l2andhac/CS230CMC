package cmc.controller;
import java.lang.Math;
/**
 * @author Lindsay Will
 * @version February 21, 2019
 * 
 * A Class that controls all of the functionaliteis of an Account forgetting a password
 */

public class ForgotPasswordController{
  

  private AccountFunctionalityController afController; 
  
  /**
   * Generates a random password to be the new password
   * 
   * @returns newPassword which is a String of the new password for the Account
   */
  public String generateRandomPassword(){
    
     String CHAR_LIST = 
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      
    StringBuffer password = new StringBuffer();
    for(int i=0; i<6; i++){
            double num = Math.random() * 62;
            int number = (int) Math.round(num);
            char ch = CHAR_LIST.charAt(number);
            password.append(ch);
        }
        return password.toString();
  }
  
  /**
   * Returns whether or not username is an email
   * 
   * @param username is a String for the username of the Account
   * @returns a boolean for whether or not the username is a email
   */
  public boolean checkIfEmail(String username){
    if (username.contains("@")){
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Emails the Account a new password
   * 
   * @param account is the Account to email the new password too
   */
  public void emailNewPassword(Account account){
    //NOT SURE HOW EMAIL THING WORKS :/ 
  }
}
