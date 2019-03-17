package cmc.controller;
import java.lang.Math;
import cmc.entity.*;
/**
 * 
 * A Class that controls all of the functionaliteis of an Account forgetting a password
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */

public class ForgotPasswordController{
  
  
  /**
   * Generates a random password to be the new password
   * 
   * @return String - new password for the Account
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
   * @param username - String for the username of the Account
   * @return boolean - for whether or not the username is a email
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
   * @param account - Account to email the new password too
   */
  public void emailNewPassword(Account account){
    //NOT SURE HOW EMAIL THING WORKS :/ 
  }
}
