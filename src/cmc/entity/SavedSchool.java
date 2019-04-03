package cmc.entity;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * SavedSchool.java
 * 
 * This class is an entity class for saved schools.
 * 
 * 
 * @author L^2 and the Hackstreetboyz
 * @version 3/17/2019
 */
public class SavedSchool extends University {
  //timeStamp that keeps track of when a SavedSchool is added
  private SimpleDateFormat timeStamp;
  
  /**
   * Constructor that creates a Saved School 
   * @param u - University that the SavedSchool object represents
   * @param timeStamp - keeps track of when a SavedSchool is added
   */
  public SavedSchool(University u, String ts) {
    super(u.getSchoolName(), u.getState(), u.getLocation(), u.getControl(),
                                        u.getNumStudents(), u.getPercentFemales(), u.getSATVerbal(), u.getSATMath(),
                                        u.getExpenses(), u.getPercentFinancialAid(), u.getNumApplicants(),
                                        u.getPercentAdmitted(), u.getPercentEnrolled(), u.getAcademicScale(),
                                        u.getSocialScale(), u.getQualityOfLifeScale(), u.getEmphases());
    this.timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }
  
  /**
   * Gets the time stamp of a saved university.
   * 
   * @return the time stamp of the university
   */
  public SimpleDateFormat getTimeStamp() {
    return this.timeStamp;
  }
  
  /**
   * Sets the time stamp of a saved university to time.
   * 
   * @param time the time the university was saved at
   */
  public void setTimeStamp(SimpleDateFormat time) {
    this.timeStamp = time;
  }
  
  public boolean equals(University u) {
	  if(!this.schoolName.equals(u.getSchoolName())) 
			  return false;
	  else if(!(this.state.equals(u.getState()))) 
		  return false;
	  else if(!(this.location.equals(u.getLocation())))
		  return false;
	  else if(!(this.control.equals(u.getControl())))
		  return false;
	  else if(!(this.numberOfStudents == u.getNumStudents()))
		  return false;
	  else if(!(this.percentFemale == u.getPercentFemales()))
		  return false;
	  else if(!(this.satVerbal == u.getSATVerbal()))
		  return false;
	  else if(!(this.satMath == u.getSATMath()))
		  return false;
	  else if(!(this.expenses == u.getExpenses()))
		  return false;
	  else if(!(this.percentFinancialAid == u.getPercentFinancialAid()))
		  return false;
	  else if(!(this.numberOfApplicants == u.getNumApplicants()))
		  return false;
	  else if(!(this.percentEnrolled == u.getPercentEnrolled()))
		  return false;
	  else if(!(this.percentAdmitted == u.getPercentAdmitted()))
		  return   false;
	  else if(!(this.academicsScale == u.getAcademicScale()))
		  return false;
	  else if (!(this.socialScale == u.getSocialScale()))
		  return false;
	  else if(!(this.qualityScale == u.getQualityOfLifeScale()))
		  return false;
	  if (this.emphases.size() == 0 && u.getEmphases().size() == 0)
		  return true;
	  else if(!(this.emphases.equals(u.getEmphases())))
		  return false;
	 
	  return true;  
	  
  }
}