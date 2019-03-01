package cmc.driver;
import java.util.Set;

import cmc.interaction.*;
/**
 * CMCDriver1.java
 * 
 * @author: L^2 and the Hackstreet Boyz
 * @version: February 25th
 * 
 * Driver for the CMC project
 */

public class CMCDriver1{

	  private static AdminInteraction aInteraction;
	  private static UserInteraction uInteraction;
	  private static AccountInteraction accountInteraction;
	  private static AccountInteraction logOnInteraction;
	  
	    public static void main(String[] args)
	  {
	      //aInteraction = new AdminInteraction();
	      //uInteraction = new UserInteraction();
	      accountInteraction = new AccountInteraction();
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("LogIn for User");
	      
	      logOnInteraction = accountInteraction.logOn("jordre3@gmail.com", "password");
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("LogIn for Admin");
	      
	      logOnInteraction = accountInteraction.logOn("nateTheAdmin","password");
	      
	      aInteraction = (AdminInteraction) logOnInteraction;
	      Set<String> allAccounts = aInteraction.viewAllAccounts();
	      for(String a : allAccounts)
	      {
	        System.out.println(a);
	      }
	      
	     /* System.out.println("-------------------------------------------------------");
	      System.out.println("User can View and Edit Profile");
	      
	      uInteraction.viewAccountInfo("jordre3@gmail.com");
	      
	      System.out.println("-------------------------------------------------------");
	      System.out.println("Admin can View and Edit Profile");
	      
	      aInteraction.viewAccountInfo("nateTheAdmin");
	      */
	      
//	      System.out.println("-------------------------------------------------------");
//	      System.out.println("User can search for schools by combination of state and number of students");
//	      
//	      uInteraction.searchSchool("", String state, String location, String control, int enrollmentUp, 
//	                int enrollmentLo, int percentFemaleUp, int percentFemaleLo, int satVerbUp, 
//	                int satVerbLo, int satMathUp, int satMathLo, int percentFinancialAidUp, 
//	                int percentFinancialAidLo,  int applicantsUp, int applicantsLo, int percentAdmittedUp,
//	                int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp, 
//	                int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp,
//	                int qualOfLifeScaleLo, List<String> emphasis);
//	      
//	      System.out.println("-------------------------------------------------------");
//	      System.out.println("User can fine top 5 reccomendnd schools for a given school");
//	      
//	      
//	      
//	      
//	      System.out.println("-------------------------------------------------------");
//	      System.out.println("Admin can view a list of universities");
//	      
//	      aInteraction.viewAllSchools();
//	      
//	      
//	      System.out.println("-------------------------------------------------------");
//	      System.out.println("Admin can view a list of users");
//	      
//	      aInteraction.viewAllAccounts();
	      
	   }
	  
	}