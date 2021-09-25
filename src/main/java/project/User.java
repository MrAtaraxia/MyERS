package project;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * serial
	 */
	private static final long serialVersionUID = 2950382285175670211L;
	private String id;
	private String fname;
	private String lname;
	
	public User(String id, String fname, String lname) {
		this.id =id;
		this.fname=fname;
		this.lname=lname;
		
	}
	public User() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
