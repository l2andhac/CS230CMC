package cmc.controller;
import java.lang.Math;
import cmc.entity.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
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
   * @param username is an email to send the password to, account is the Account which the username belongs
   * @param account - Account that is requesting a new password
   */
	public void emailNewPassword(String username, Account account) {
		String to = username;
		String from = "l2hackstreet@gmail.com";
		String host = "LocalHost";
		Properties systemProperties = System.getProperties();
		systemProperties.setProperty("mail.smtp.host", host);

		try {
			MimeMessage message = new MimeMessage(Session.getDefaultInstance(systemProperties));
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Your new password");
			message.setText("Your password is " + account.getPassword());
			Transport.send(message);
			System.out.println("Message sent");
		}

		catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
