package cmc.driver;
import java.util.Set;

import cmc.entity.University;
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
      //instance variables for AdminInteraction, UserInteraction, and AccountInteraction
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
	      System.out.println("LogIn for User\n");
	      
	      logOnInteraction = accountInteraction.logOn("jordre3@gmail.com", "password");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Attempted LogIn for invalid credentials\n");
	      
	      logOnInteraction = accountInteraction.logOn("nateTheAdmin","password2");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("LogIn for Admin\n");
	      
	      logOnInteraction = accountInteraction.logOn("nateTheAdmin","password");
	      
	      //System.out.println("\n-------------------------------------------------------");
	      //System.out.println("Attempted LogIn for deactivated Account\n");
	      
	      // we need a deactivated user first to test this one
	      //logOnInteraction = accountInteraction.logOn( , );
	      
	      
	      //System.out.println("\n-------------------------------------------------------");
	      //System.out.println("User can View and Edit Profile\n");
	      
	      //logOnInteraction was created for an admin so we are unable to cast it to a user Interaction
	      
	      //uInteraction = (UserInteraction) logOnInteraction; 
	      
	      //uInteraction.viewAccountInfo("jordre3@gmail.com");
	      
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can View Profile\n");
	      
	      aInteraction = (AdminInteraction) logOnInteraction; 
	      
	      aInteraction.viewAccountInfo("nateTheAdmin");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can Edit Profile\n");
	      
          aInteraction = (AdminInteraction) logOnInteraction; 
          
          //edit account
          //adminInteraction needs to take all the parameters not an Account in the AdminInteraction class....
	      
	      aInteraction.viewAccountInfo("nateTheAdmin");
	      
//	      System.out.println("\n-------------------------------------------------------");
//	      System.out.println("User can search for schools by combination of state and number of students\n");
//	      
//	      uInteraction.searchSchool("", String state, String location, String control, int enrollmentUp, 
//	                int enrollmentLo, int percentFemaleUp, int percentFemaleLo, int satVerbUp, 
//	                int satVerbLo, int satMathUp, int satMathLo, int percentFinancialAidUp, 
//	                int percentFinancialAidLo,  int applicantsUp, int applicantsLo, int percentAdmittedUp,
//	                int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp, 
//	                int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp,
//	                int qualOfLifeScaleLo, List<String> emphasis);
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can find top 5 recommended schools for a given school\n");
	      
	      System.out.println("XXXXXXXXX");
	      
	      //uInteraction.showRecSchools("AUGSBURG");
	      
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
	      
	   }
	  
	}