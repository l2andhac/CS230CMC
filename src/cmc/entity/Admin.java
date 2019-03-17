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
  * @param - firstName the new admin's first name
  * @param - lastName the new admin's last name
  * @param - username the new admin's username
  * @param - password the new admin's password
  * @param - status the new admin's status, either 'Y' for active, 'N' for deactivated

  */
 public Admin(String firstName, String lastName, String username, String password, char status){
     super(firstName, lastName, username, password, 'a', status);
 }
}