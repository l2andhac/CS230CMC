package cmc.entity;
import java.io.*;
import java.util.*;
/**
 * User.java
 * 
 * @author: L^2 and the Hackstreet Boyz
 * @version: February 21, 2019
 * 
 * Class that represents an user account
*/
public class User extends Account{
  
  private List<SavedSchool> savedSchools;
 /**
  * User constructor creates an user object
  */
 public  User(String firstName, String lastName, String username, String password, char status){
   super(firstName, lastName, username, password, 'u', status);
 }
 
 /**
  * An accesor method that returns a list of saved schools
  * @return - List<SavedSchools> that has all of the user's saved schools
  */
 public List<SavedSchool> getSavedSchools(){
   return this.savedSchools;
 }
 
 /**
  * method that adds a saved school to a user
  * @param s - the saved school that will be added to a user
  */
 public void addSavedSchool(SavedSchool s) {
  
 }
 
 /**
  * method that removes a saved school from a user account
  * @param s - the saved school which is wished to be removed
  */
 public void removeSavedSchool(SavedSchool s) {
  
 }

}