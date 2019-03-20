package cmc.driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cmc.entity.University;
import cmc.interaction.*;

import cmc.interaction.AccountInteraction;
import cmc.interaction.AdminInteraction;
import cmc.interaction.UserInteraction;

/**
 * 
 * Driver for Admin Functionalities
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class CMCDriverAdmin {

	//instance variables for AdminInteraction, and AccountInteraction
	  private static AdminInteraction aInteraction;
	  private static AccountInteraction accountInteraction;
	  private static AccountInteraction logOnInteraction;
	  

	    public static void main(String[] args)
	  {
	     
	      accountInteraction = new AccountInteraction();
	      
	      
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("Attempted LogIn for invalid credentials");
	      
	      logOnInteraction = accountInteraction.logOn("nateTheAdmin","password2");
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Attempted LogIn for deactivated Account");
	      
	      logOnInteraction = accountInteraction.logOn("nadmin","admin");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("LogIn for Admin\n");
	      
	      logOnInteraction = accountInteraction.logOn("nateTheAdmin","password");
	      
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can View Profile\n");
	      
	      aInteraction = (AdminInteraction) logOnInteraction; 
	      
	      aInteraction.viewAccountInfo();
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can Edit Profile\n");
	      
        aInteraction = (AdminInteraction) logOnInteraction; 
        
        //edit account
        aInteraction.editAccountInfo("nateTheAdmin", "Nathan", "Jordre", "password", 'a', 'Y');
	      
	      aInteraction.viewAccountInfo();
	     
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can Edit User Profile\n");
	      
        aInteraction = (AdminInteraction) logOnInteraction; 
        
        aInteraction.viewAccountInfo("juser");
                //edit account
        aInteraction.editAccountInfo("juser", "John", "Miller", "user", 'u', 'D');
	      aInteraction.viewAccountInfo("juser");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can view a list of universities\n");
	      
	      aInteraction = (AdminInteraction) logOnInteraction; 
	      Set<University> uList = aInteraction.viewAllSchools();
	      for(University s : uList)
	      {
	        System.out.println(s.getSchoolName());
	      }
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can view a list of users\n");
	           
	      aInteraction = (AdminInteraction) logOnInteraction;    
	      Set<String> allAccounts = aInteraction.viewAllAccounts();
	      for(String a : allAccounts)
	      {
	        System.out.println(a);
	      }
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can view school details");
	      aInteraction.viewSchoolDetails("UNIVERSITY OF MINNESOTA");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin tries to view the details of a school not in the database");
	      aInteraction.viewSchoolDetails("COLLEGE OF NEWROCHELLEs");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin tries to edit a school");
	      aInteraction.editSchool("UNIVERSITY OF MINNESOTA", "MINNESOTA", "URBAN", "STATE", 
	    		  40500, 45, 490, 557, 13772, 50, 8500, 80, 60, 4, 3, 4);
	      aInteraction.viewSchoolDetails("UNIVERSITY OF MINNESOTA");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can add a new admin account");
	      aInteraction.addAccount("Andy", "Rothstein", "AndytheAdmin", "password",'a', 'y');
	      aInteraction.viewAccountInfo("AndytheAdmin");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can add a new user account");
	      aInteraction.addAccount("Andy", "Rothstein", "AndytheUser", "password",'u', 'y');
	      aInteraction.viewAccountInfo("AndytheUser");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can add a new school");
	      
	      List<String> foci = new ArrayList<String>();
	      foci.add("Business Administration");
	      
	      //aInteraction.addSchool("UNIVERSITY OF ST THOMAS", "MINNESOTA", "URBAN", "PRIVATE", 10000, 46.0, 450, 400, 50000, 15.2, 11001, 89.9, 50.0, 2, 1, 1, foci);
	      
	      
	      List<String> foci2 = new ArrayList<String>();
	      aInteraction.addSchool("GUSTAVUS", "MINNESOTA", "URBAN", "SMALL-CITY", 6000, 46.0, 450, 400, 50000, 15.2, 11001, 89.9, 50.0, 2, 1, 1, foci2);
	 
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin tries to add a school already in the database");
	      
	      aInteraction.addSchool("UNIVERSITY OF ST THOMAS", "MINNESOTA", "URBAN", "PRIVATE", 10000, 46.0, 450, 400, 50000, 15.2, 11001, 89.9, 50.0, 2, 1, 1, foci);
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can remove a school");
	      
	      aInteraction.removeSchool("GUSTAVUS");
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin tries to remove a school that cannot be removed");
	      
	      aInteraction.removeSchool("AUGSBURG");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Adminwith a username that is an email forgets password and is sent a new one");

	      
	      aInteraction.forgotPassword("lindsay12798@gmail.com");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin with a username that is not an email forgets password, but cannot be emailed a new one");
	      
	      aInteraction.forgotPassword("AndytheAdmin");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can log off");
	      aInteraction.logOff();
	   }

}
