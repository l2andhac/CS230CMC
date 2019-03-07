package cmc.controller;
import cmc.entity.*;
/**
 * @author Lindsay Will
 * @version February 21, 2019
 * 
 * A Class that controls all of the functionalities of searching
 */

public class SearchController{
  
	//instance variable for a DBController
  private DBController controller; 
  
  /**
   * Constructor for SearchController
   * 
   * creates a new DBController
   */
  public SearchController() {
  	this.controller = new DBController();
  }
  
  
  /**
   * Searches for a University
   * 
   * @param so is the Search object
   */
  public void searchSchool(Search so){
    controller.findSearchedSchool(so);
  }

}
