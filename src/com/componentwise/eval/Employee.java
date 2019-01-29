package com.componentwise.eval;

import java.util.Date;

/**
 * 
 * @author Jorvon Carter
 *
 * Just a field and getter method were added as per the requirements of question 3.
 */
public class Employee {
	private boolean managerFlag;
	private String name;
	private Date dateHired;
	private int id;
	private boolean tempFlag;
	
	public String getName() {
		return this.name;
	}
	
	public String getID() {
		return this.id + "";
	}
	
	public Date getDateHired() {
		return this.dateHired;
	}
	
	public boolean isManager() {
		return this.managerFlag;
	}
	
	public boolean isTempEmployee() {
		return this.tempFlag;
	}
}
