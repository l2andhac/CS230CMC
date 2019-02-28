package cmc.driver;
import java.util.*;
import cmc.entity.*;
import cmc.controller.*;


public class DBControllerTestDriver{
  private static DBController t;
  
  public static void main(String[] args)
  {
    t = new DBController();
    Set<String> usernames = t.viewAllAccounts();
    for(String u : usernames)
    {
      System.out.println(u);
    }
    
    Account a = t.findAccount("juser");
    System.out.println(a.getFirstName());
    System.out.println(a.getLastName());
    System.out.println(a.getUserType());
    
    System.out.println("-------------------------------------------------------");
    Set<University> uList = t.getAllSchools();
    for(University s : uList)
    {
      System.out.println(s.getSchoolName());
    }
    System.out.println("-------------------------------------------------------");
    University s = t.getSchool("BUCKNELL");
    University school = t.getSchool("UNIVERSITY OF MINNESOTA");
    System.out.println(school.getState());
    SavedSchool saved = new SavedSchool(school, "time");
    t.addSavedSchool((User) a, saved);
    
    System.out.println("----------------------------------------------------------");
    
    List<SavedSchool> savedList = t.getSavedSchools((User) a);
    for(SavedSchool ss : savedList)
    {
      System.out.println(ss.getSchoolName());
    }
    
    System.out.println("----------------------------------------------------------");
    
    if(t.isSchoolSaved(school))
    {
      System.out.println("isSchoolSaved works when true");
    }
    if(t.isSchoolSaved(s) == false)
    {
      System.out.println("isSchoolSaved works when false");
    }
    
    User nateTheUser = new User("Nate", "Jordre", "jordre3@gmail.com", "password", 'u'); /////Should be a status?
    
    t.addAccount(nateTheUser);
    
  }
}