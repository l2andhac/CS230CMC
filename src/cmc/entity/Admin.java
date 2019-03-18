package cmc.entity;
/**
 * Admin.java
 * 
 * Class that represents an admin account
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */

public class Admin extends Account{
 /**
  * Admin constructor that creates an admin object
  * 
  * @param firstName - String that is the new admin's first name
  * @param lastName - String that is the new admin's last name
  * @param username - String that is the new admin's username
  * @param password - String that is the new admin's password
  * @param status - Character that is the new admin's status, either 'Y' for active, 'N' for deactivated

  */
 public Admin(String firstName, String lastName, String username, String password, char status){
     super(firstName, lastName, username, password, 'a', status);
 }
}