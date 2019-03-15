package cmc.entity;
/**
 * Admin.java
 * 
 * @author: L^2 and the Hackstreet Boyz
 * @version: February 23, 2019
 * 
 * Class that represents an admin account
 */

public class Admin extends Account{
 /**
  * Admin constructor that creates an admin object
  */
 public Admin(String firstName, String lastName, String username, String password, char status){
     super(firstName, lastName, username, password, 'a', status);
 }
}