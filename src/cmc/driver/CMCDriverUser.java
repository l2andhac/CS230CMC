package cmc.driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cmc.entity.Search;
import cmc.entity.University;
import cmc.interaction.*;

import cmc.interaction.AccountInteraction;
import cmc.interaction.AdminInteraction;
import cmc.interaction.UserInteraction;

/**
 * 
 * Driver for User Functionalities
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class CMCDriverUser {

	//instance variables for UserInteraction, and AccountInteraction
	  private static UserInteraction uInteraction;
	  private static AccountInteraction accountInteraction;
	  private static AccountInteraction logOnInteraction;
	  
	    public static void main(String[] args)
	  {
	      
	      //uInteraction = new UserInteraction();
	      accountInteraction = new AccountInteraction();
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("Non user requests a new account\n");
	      accountInteraction.requestNewAccount("Collin", "Jordre", "cjordre", "password");
	      
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("Attempted LogIn for invalid password credentials\n");
	      
	      logOnInteraction = accountInteraction.logOn("jordre3@gmail.com","password2");
	      
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("Attempted LogIn for invalid username credentials\n");
	      
	      logOnInteraction = accountInteraction.logOn("jordre@gmail.com","password");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Attempted LogIn for deactivated Account\n");
	      
	      logOnInteraction = accountInteraction.logOn("luser","user");
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("LogIn for User\n");
	      
	      logOnInteraction = accountInteraction.logOn("jordre3@gmail.com", "password");
	      
	      
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can View Profile\n");
	      
	      uInteraction = (UserInteraction) logOnInteraction; 
	      
	      uInteraction.viewAccountInfo();
	     
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can Edit Profile\n");
	      
         uInteraction = (UserInteraction) logOnInteraction; 
        
        //edit account
         uInteraction.editAccountInfo("jordre3@gmail.com","Nate","Jordre", "password");
	      
	      uInteraction.viewAccountInfo();
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can search for schools by combination of state and number of students\n");
	      
	      University univ1 = null;
	      List<String> foci = new ArrayList<String>();
	      foci.add("ENGINEERING");
	      foci.add("LIBERAL-ARTS");
	      Set<University> listOfMatches = uInteraction.searchSchool("", "CALI", "URBAN", "STATE", 60000, 5000, 25, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	      if (listOfMatches != null) {
	      System.out.println("----------------------------------------------------------");
	      System.out.println("Matching Schools:");
	      for(University uni : listOfMatches) {
	      	System.out.println(uni.getSchoolName());
	      	univ1 = uni;
	      }
	      }
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can find top 5 recommended schools for a given school\n");
	      
	     
	      uInteraction = (UserInteraction) logOnInteraction; 
	      
	      uInteraction.showRecSchools("NEWYORK IT");
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("The user can view school details");
	      uInteraction.viewSchoolDetails("AUGSBURG");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User tries to view the details of a school not in the database");
	      uInteraction.viewSchoolDetails("AUGSBURGs");
	      
	      //System.out.println("\n-------------------------------------------------------");
	      //System.out.println("User tries to save a school");
	      //uInteraction.saveSchool(univ1);
	      
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User views their list of saved schools");
	      uInteraction.viewSavedSchools();
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can remove a saved school");
	      uInteraction.removeSavedSchool("UNIVERSITY OF CALIFORNIA SANTA CRUZ");
	      uInteraction.viewSavedSchools();
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User searches for friends");
	      uInteraction.searchForFriends("juser");
	      	
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User requests for deactivation");
	      uInteraction.requestDeactivation();
	      uInteraction.viewAccountInfo();
	      

	  System.out.println("\n-------------------------------------------------------");
      System.out.println("User can compare 2 Saved Schools which are Stanford and Auburn.");
      uInteraction.compareSavedSchools("STANFORD");

      
      System.out.println("\n-------------------------------------------------------");
      System.out.println("User can sort list by expenses - from less expensive to more expensive");
      
      uInteraction.sortResults(listOfMatches, 'e');
      
      System.out.println("\n-------------------------------------------------------");
      System.out.println("User can sort list by admission - from lowest percentage of admission to highest");
      
      uInteraction.sortResults(listOfMatches, 'a');
      
      System.out.println("\n-------------------------------------------------------");
      System.out.println("User can sort list by number of students - from lowest number of students to highest");
      
      uInteraction.sortResults(listOfMatches, 'n');

      System.out.println("\n-------------------------------------------------------");
      System.out.println("User with a username that is an email forgets password and is sent a new one");

      uInteraction = (UserInteraction) logOnInteraction; 
      
      uInteraction.forgotPassword("lwill001@csbsju.edu");
      
      System.out.println("\n-------------------------------------------------------");
      System.out.println("User with a username that is not an email forgets password, but cannot be emailed a new one");

      uInteraction = (UserInteraction) logOnInteraction; 
      
      uInteraction.forgotPassword("juser");  
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User logs off");
	      uInteraction.logOff();
	   }

}
