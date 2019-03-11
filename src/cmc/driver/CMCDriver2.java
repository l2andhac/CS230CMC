//package cmc.driver;
//import java.util.Scanner;
//import java.util.Set;
//
//import cmc.entity.Account;
//import cmc.entity.Admin;
//import cmc.entity.University;
//import cmc.entity.User;
//import cmc.interaction.*;
///**
// * CMCDriver1.java
// * 
// * @author: L^2 and the Hackstreet Boyz
// * @version: February 25th
// * 
// * Driver for the CMC project
// */
//
//public class CMCDriver2{
//      //instance variables for AdminInteraction, UserInteraction, and AccountInteraction
//	  private static AdminInteraction aInteraction;
//	  private static UserInteraction uInteraction;
//	  private static AccountInteraction accountInteraction;
//	  private static AccountInteraction logOnInteraction;
//	  
//	  static Scanner sc = new Scanner(System.in);
//	  
////	  public void runCMCDriver2() {
////    	  char cmd;
////    	  do {
////    		  menu();
////    		  cmd = acceptCommand();
////    		  doCommand(cmd);
////    	  } while ((cmd != 'q') && (cmd != 'Q'));
////      }
////	  
//	  
//	  
//	  // Everything related to the User
//	  public static void userMenu() {
//		  System.out.println();
//		  System.out.print("***** User Menu *****");
//		  System.out.print("\n\tv-View profile");
//		  System.out.print("\n\te-Edit profile");
//		  System.out.print("\n\ts-Search for schools");
//		  System.out.print("\n\tt-Top 5 for a given school");
//		  System.out.print("\n\tq-Quit\n");
//	  }
//	  
//	 
//	  
//	  public static Account editUser(String username) {
//		  System.out.println("First Name");
//    	  String fn = sc.next();
//    	  System.out.println("Last Name");
//    	  String ln = sc.next();
//
//    	  System.out.println("Password");
//    	  String pwrd = sc.next();    	  
//    	  Account account = new Account(fn, ln, username, pwrd, 'u', 'Y');
//    	  return account;
//	  }
//	  
//	  public static void forUser(UserInteraction uInteraction) {
//		  String cmd = "0";
//		  while(!cmd.equals("q") && !cmd.equals("Q")) {
//			  userMenu();
//			  System.out.println("Enter command");
//			  cmd = sc.next();
//			  if(cmd.equals("v") ||cmd.equals("V")) {
//				  uInteraction.viewAccountInfo(uInteraction.getUsername());
//			  }
//			  
//			  else if(cmd.equals("e") || cmd.equals("E")) {
//				  //System.out.println("Enter new First Name");
//				  User newUser = (User) editUser(uInteraction.getUsername());
//				  uInteraction.editAccountInfo(newUser.getUsername(), newUser.getFirstName(), newUser.getLastName(), newUser.getPassword());
//			  }
//			  
//			  else if(cmd.equals("s") || cmd.equals("S")) {
//				  //
//			  }
//			  
//			  else if(cmd.equals("t") || cmd.equals("T")) {
//				  //
//			  }
//			  else {
//				  System.out.println("Invalid command");
//			  }
//		  }
//	  }
//	  
//	  
//	  //Everything related to the Admin
//	  public static void adminMenu() {
//		  System.out.println();
//		  System.out.print("***** Admin Menu *****");
//		  System.out.print("\n\tv-View profile");
//		  System.out.print("\n\te-Edit profile");
//		  System.out.print("\n\ta-View list of Users");
//		  System.out.print("\n\tu-View lsit of Universities");
//		  System.out.print("\n\tq-Quit\n");
//	  }
//	  
//	  public static void forAdmin(AdminInteraction aInteraction) {
//		  String cmd = "v";
//		  
//		  while(!cmd.equals("q") && !cmd.equals("Q")) {
//			  adminMenu();
//			  System.out.println("Enter command");
//			  cmd = sc.next();
//			  if(cmd.equals("v") || cmd.equals("V")) {
//				  aInteraction.viewAccountInfo(aInteraction.getUsername());
//			  }
//			  
//			  else if(cmd.equals("e") || cmd.equals("E")) {
//				  System.out.println("Enter username");
//				  String username = sc.next();
//				  Admin newAdmin = (Admin) editAccount(username);
//				  aInteraction.editAccountInfo(newAdmin);
//			  }
//			  
//			  else if(cmd.equals("a") || cmd.equals("A")) {
//				  Set<String> allAccounts = aInteraction.viewAllAccounts();
//			      for(String a : allAccounts)
//			      {
//			        System.out.println(a);
//			      }
//			  }
//			  
//			  else if(cmd.equals("u") || cmd.equals("U")) {
//			      //aInteraction = (AdminInteraction) logOnInteraction; 
//			      Set<University> uList = aInteraction.viewAllSchools();
//			      for(University s : uList)
//			      {
//			        System.out.println(s.getSchoolName());
//			      }
//			      
//			  }
//			  else {
//				  System.out.println("Invalid command");
//			  }
//		  } 
//	  }
//	  
//	  
//	  public static Account editAccount(String username) {
//		  System.out.println("First Name");
//    	  String fn = sc.next();
//    	  System.out.println("Last Name");
//    	  String ln = sc.next();
//    	  System.out.println("Password");
//    	  String pwrd = sc.next();
//    	  System.out.println("User Type");
//    	  String t = sc.next();
//    	  System.out.println("Status");
//    	  String s = sc.next();
//    	  
//    	  Account account = new Account(fn, ln, username, pwrd, t.charAt(0), s.charAt(0));
//    	  return account;
//	  }
//	  
//	  
//	  public static void main(String[] args)
//	  {
//	      accountInteraction = new AccountInteraction();
//	      
//	      
//	      System.out.println("-------------------------------------------------------");
//	      System.out.println("LogIn page");
//	      System.out.println("Enter your username");
//	      
//	      String usrnm = sc.next();
//	      
//	      	      
//	      System.out.println("Enter your password");
//	      //Scanner pssw = new Scanner(System.in);
//	      String psswrd = sc.next();
//	      
//	      try {
//	      logOnInteraction = accountInteraction.logOn(usrnm, psswrd);
//	      if(logOnInteraction.getTypeOfInteraction(usrnm, psswrd)=='a') {
//			  
//		      aInteraction = (AdminInteraction) logOnInteraction; 
//		      
//		      forAdmin(aInteraction);
//	      }
//	      
//	      else if(logOnInteraction.getTypeOfInteraction(usrnm, psswrd)=='u') {
//		      
//		      uInteraction = (UserInteraction) logOnInteraction; 
//		      
//		      forUser(uInteraction);
//	      }
//	      
//	      } catch (NullPointerException npe) {
//	    	  System.err.println("Incorrect information was given");
//	      }
//	      
//	      
//	      
//	     
////	      System.out.println("\n-------------------------------------------------------");
////	      System.out.println("Admin can view a list of users\n");
////	           
////	      aInteraction = (AdminInteraction) logOnInteraction;    
////	      Set<String> allAccounts = aInteraction.viewAllAccounts();
////	      for(String a : allAccounts)
////	      {
////	        System.out.println(a);
////	      }
////	      
////	      
////	      //System.out.println("\n-------------------------------------------------------");
////	      //System.out.println("Attempted LogIn for deactivated Account\n");
////	      
////	      // we need a deactivated user first to test this one
////	      //logOnInteraction = accountInteraction.logOn( , );
////	      
////	      
////	      //System.out.println("\n-------------------------------------------------------");
////	      //System.out.println("User can View and Edit Profile\n");
////	      
////	      //logOnInteraction was created for an admin so we are unable to cast it to a user Interaction
////	      
////	      //uInteraction = (UserInteraction) logOnInteraction; 
////	      
////	      //uInteraction.viewAccountInfo("jordre3@gmail.com");
////	      
////	      
////	      System.out.println("\n-------------------------------------------------------");
////	      System.out.println("Admin can View Profile\n");
////	      
////	      aInteraction = (AdminInteraction) logOnInteraction; 
////	      
////	      aInteraction.viewAccountInfo("nateTheAdmin");
////	      
////	      System.out.println("\n-------------------------------------------------------");
////	      System.out.println("Admin can Edit Profile\n");
////	      
////          aInteraction = (AdminInteraction) logOnInteraction; 
////          
////          //edit account
////          //adminInteraction needs to take all the parameters not an Account in the AdminInteraction class....
////	      
////	      aInteraction.viewAccountInfo("nateTheAdmin");
////	      
//////	      System.out.println("\n-------------------------------------------------------");
//////	      System.out.println("User can search for schools by combination of state and number of students\n");
//////	      
//////	      uInteraction.searchSchool("", String state, String location, String control, int enrollmentUp, 
//////	                int enrollmentLo, int percentFemaleUp, int percentFemaleLo, int satVerbUp, 
//////	                int satVerbLo, int satMathUp, int satMathLo, int percentFinancialAidUp, 
//////	                int percentFinancialAidLo,  int applicantsUp, int applicantsLo, int percentAdmittedUp,
//////	                int percentAdmittedLo, int percentEnrollUp, int percentEnrollLo, int academicScaleUp, 
//////	                int academicScaleLo, int socialScaleUp, int socialScaleLo, int qualOfLifeScaleUp,
//////	                int qualOfLifeScaleLo, List<String> emphasis);
////	      
////	      System.out.println("\n-------------------------------------------------------");
////	      System.out.println("User can find top 5 recommended schools for a given school\n");
////	      
////	      System.out.println("XXXXXXXXX");
////	      //uInteraction = (UserInteraction) logOnInteraction; 
////	      //logOnInteraction was created for an admin so we are unable to cast it to a user Interaction
////	      
////	      //uInteraction.showRecSchools("AUGSBURG");
////	      
////	      System.out.println("\n-------------------------------------------------------");
////	      System.out.println("Admin can view a list of universities\n");
////	      
////	      aInteraction = (AdminInteraction) logOnInteraction; 
////	      Set<University> uList = aInteraction.viewAllSchools();
////	      for(University s : uList)
////	      {
////	        System.out.println(s.getSchoolName());
////	      }
//	      sc.close();
//	   }
//	  
//	}
