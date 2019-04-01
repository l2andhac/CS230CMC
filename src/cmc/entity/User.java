package cmc.entity;

import java.util.*;
/**
 * User.java
 * 
 * Class that represents an user account
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class User extends Account{
	private List<SavedSchool> savedSchools;
	/**
	 * User constructor creates a User object.
	 * @param firstName - String representing the first name of the user
	 * @param lastName - String representing the last name of the user
	 * @param username - String representing the username of the user
	 * @param password - String representing the password of the user
	 * @param status - character representing whether the account is active or not
	 */
	public  User(String firstName, String lastName, String username, String password, char status){
		super(firstName, lastName, username, password, 'u', status);
    }
	
	/**
	 * An accesor method that returns a list of saved schools.
	 * 
	 * @return - List<SavedSchools> that has all of the user's saved schools
	 */
	public List<SavedSchool> getSavedSchools(){
		return this.savedSchools;
    }
	
	/**
	 * A mutator method that sets a list of saved schools.
	 * 
	 * @param list - the list of saved schools
	 */
	public void setSavedSchools(List<SavedSchool> list){
		this.savedSchools = list;
    }
}
