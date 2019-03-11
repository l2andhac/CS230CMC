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
	      System.out.println("Attempted LogIn for invalid credentials\n");
	      
	      logOnInteraction = accountInteraction.logOn("jordre3@gmail.com","password2");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Attempted LogIn for deactivated Account\n");
	      
	      logOnInteraction = accountInteraction.logOn("luser","user");
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("LogIn for User\n");
	      
	      logOnInteraction = accountInteraction.logOn("jordre3@gmail.com", "password");
	      
	      
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can View Profile\n");
	      
	      uInteraction = (UserInteraction) logOnInteraction; 
	      
	      uInteraction.viewAccountInfo("luser");
	     
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can Edit Profile\n");
	      
         uInteraction = (UserInteraction) logOnInteraction; 
        
        //edit account
         uInteraction.editAccountInfo("jordre3@gmail.com","Nate","Jordrex", "password");
	      
	      uInteraction.viewAccountInfo("jordre3@gmail.com");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can search for schools by combination of state and number of students\n");
	      
	      List<String> foci = new ArrayList<String>();
	      foci.add("Computer Science");
	      Set<University> listOfMatches = uInteraction.searchSchool("", "CALIFORNIA", "", "", 60000, 5000, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1, foci);
	      if (listOfMatches != null) {
	      System.out.println("----------------------------------------------------------");
	      System.out.println("Matching Schools:");
	      for(University uni : listOfMatches) {
	      	System.out.println(uni.getSchoolName());
	      }
	      }
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can find top 5 recommended schools for a given school\n");
	      
	     
	      uInteraction = (UserInteraction) logOnInteraction; 
	      
	      uInteraction.showRecSchools("NEWYORK IT");
	      
	      
	   }

}
