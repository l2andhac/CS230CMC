package cmc.driver;
import java.util.Set;

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
	      
	      uInteraction.viewAccountInfo("jordre3@gmail.com");
	     
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can Edit Profile\n");
	      
         uInteraction = (UserInteraction) logOnInteraction; 
        
        //edit account
        //adminInteraction needs to take all the parameters not an Account in the AdminInteraction class....
	      
	      uInteraction.viewAccountInfo("jordre3@gmail.com");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("User can search for schools by combination of state and number of students\n");
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
	      
	     
	      uInteraction = (UserInteraction) logOnInteraction; 
	      
	      uInteraction.showRecSchools("NEWYORK IT");
	      
	      
	   }

}
