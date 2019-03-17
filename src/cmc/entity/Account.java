 package cmc.entity;
/**
 * Account.java
 * 
 * Class that holds the information held by an account holder
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class Account {
 // no attributes

 //first name of the account holder
 private String firstName;
 // last name of the account holder
 private String lastName;
 // username for the account
 private String username;
 // password for the account
 private String password;
 // character that is 'a' if the account is held by an admin and 'u' if held by a user
 private char userType;
 // character that is 'Y' if the account is active and 'N" if the account is notactive
 private char status;
 // boolean that is true if the account is logged on
 private boolean loggedOn;

 /**
  * Account constructor that creates a new Account object
  */
 public Account(String firstName, String lastName, String username, String password, char type, char status) {
   this.firstName = firstName;
   this.lastName = lastName;
   this.username = username;
   this.password = password;
   this.userType = type;
   this.status = status;

 }
    /**
     *  accesor method that returns the first name of the account holder
     * @return - String that is the first name of the account holder
     */
 public String getFirstName() {
    return this.firstName;
 }
    
 /**
  * mutator method that sets the first name of the account holder to the parameter given
  * @param - fn the first name of the account holder
  */
 public void setFirstName(String fn) {
    this.firstName = fn;
 }

 /**
  *  accesor method that returns the last name of the account holder
  * @return - String that is the last name of the account holder
  */
 public String getLastName() {
    return this.lastName;
 }
    
 /** mutator method that sets the last name of the account holder to the parameter given
  * 
  * @param - ln the last name of the account holder
  */
 public void setLastName(String ln) {
    this.lastName = ln;
 }
    
 /** accesor method that returns the password of the account
  * 
  * @return - String that is the password of the account
  */
 public String getPassword() {
    return this.password;
 }
    
 /** mutator method that sets the password to the given parameter
  * 
  * @param - p the password of the account holder
  */
 public void setPassword(String p) {
    this.password = p;
 }
    
 /** accesor method that returns the userType
  * 
  * @return - char that represents whether the account is an admin or a user
  */
 public char getUserType() {
    return this.userType;
 }

 /** mutator method that sets the userType to the given parameter
  * 
  * @param - t the userType of the account
  */
 public void setUserType(char t) {
    this.userType = t;
 }

 /** accesor method that returns the status of the account
  * 
  * @return - char that represents the status of the account
  */
 public char getStatus() {
    return this.status;
 }

 /** 
  * mutator method that sets the status of the account to the given parameter
  * 
  * @param - c the status of the account
  */
 public void setStatus(char c) {
    this.status = c;
 }

 /** 
  * accesor that returns the username of the account
  * 
  * @return - String that is the username of the account
  */
 public String getUsername() {
    return this.username;
 }

 /** 
  * mutator that sets the username to the given parameter
  * 
  * @param - u the username of the account
  */
 public void setUsername(String u) {
    this.username = u;
 }

 /**
  * method that sets the loggedOn boolean to true
  */
 public void logOn() {
    this.loggedOn = true;
 }

 /**
  * method that sets the loggedOn boolean to false
  */
 public void logOff() {
    this.loggedOn = false;
 }
    
 /**
  *  method that returns true if the account is logged on and false if it is not
  * @return - boolean that tells whether or not the account is logged on
  */
 public boolean isLoggedOn() {
    return this.loggedOn;
 }

 
/**
 * toString method for account
 * @return - String with the information for the account
 */
@Override
public String toString() {
	return "firstName= " + firstName + "\nlastName= " + lastName + "\nusername= " + username + "\npassword= "
			+ password + "\nuserType= " + userType + "\nstatus= " + status  + "\nisLoggedOn= " + loggedOn;
}

}