package cmc.driver;
import java.util.Set;

import cmc.entity.University;
import cmc.interaction.*;

import cmc.interaction.AccountInteraction;
import cmc.interaction.AdminInteraction;
import cmc.interaction.UserInteraction;

public class CMCDriverAdmin {

	//instance variables for AdminInteraction, and AccountInteraction
	  private static AdminInteraction aInteraction;
	  private static AccountInteraction accountInteraction;
	  private static AccountInteraction logOnInteraction;
	  
	    public static void main(String[] args)
	  {
	      //aInteraction = new AdminInteraction();
	     
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
        aInteraction.editAccountInfo("nateTheAdmin", "Nathaniel", "Jordre", "password", 'a', 'Y');
	      
	      aInteraction.viewAccountInfo();
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can Edit User Profile\n");
	      
        aInteraction = (AdminInteraction) logOnInteraction; 
        
        //edit account
        aInteraction.editAccountInfo("juser", "John", "Cena", "user", 'u', 'Y');
	      
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
	      aInteraction.viewSchoolDetails("COLLEGE OF NEWROCHELLE");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin tries to view the details of a school not in the database");
	      aInteraction.viewSchoolDetails("COLLEGE OF NEWROCHELLEs");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can add a new admin account");
	      aInteraction.addAccount("Andy", "Rothstein", "AndytheAdmin", "password",'a', 'y');
	      aInteraction.viewAccountInfo("AndytheAdmin");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can add a new user account");
	      aInteraction.addAccount("Andy", "Rothstein", "AndytheUser", "password",'u', 'y');
	      aInteraction.viewAccountInfo("AndytheUser");
	      
	      System.out.println("\n-------------------------------------------------------");
	      System.out.println("Admin can log off");
	      aInteraction.logOff();
	   }

}
