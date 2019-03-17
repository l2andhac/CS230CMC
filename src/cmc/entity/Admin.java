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
  */
 public Admin(String firstName, String lastName, String username, String password, char status){
     super(firstName, lastName, username, password, 'a', status);
 }
}