package project.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.*;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="ERS_USERS")
@NamedQueries(  
	    {  
	        @NamedQuery(
	        name = "viewAllUsers", 
	        query = "FROM ERS_USERS s"),
	        @NamedQuery(
	        name = "findUserByID",
	        query = "FROM ERS_USERS s WHERE s.id = :id"),
	        @NamedQuery(
	        name = "findUsersByRole", 
	        query = "FROM ERS_USERS s WHERE s.USER_ROLE = :USER_ROLE"),
	        @NamedQuery(
	        name = "findUserByUsername", 
	        query = "FROM ERS_USERS s WHERE s.ERS_USERNAME = :ERS_USERNAME"),
	    }
	)
public class ERS_USERS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ERS_USERS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ERS_USERS_ID;
	
	@Column(name="ERS_USERNAME", unique=true, nullable=false, length = 50)
	private String ERS_USERNAME;
	
	@Column(name="ERS_PASSWORD", unique = false, nullable = false, length = 50)
	private String ERS_PASSWORD;
	
	@Column(name="USER_FIRST_NAME", unique = false, nullable = false, length = 100)
	private String USER_FIRST_NAME;
	
	@Column(name="USER_LAST_NAME", unique = false, nullable = false, length = 100)
	private String USER_LAST_NAME;
	
	@Column(name="USER_EMAIL", unique = true, nullable = false, length = 150)
	private String USER_EMAIL;

	//@Enumerated(EnumType.STRING)
	@Enumerated(value = EnumType.STRING)
	@Column(name="USER_ROLE", unique = false, nullable = false, columnDefinition = "varchar(25) default 'OTHER'")
	private USER_ROLES USER_ROLE;
	
	
	public ERS_USERS() {
	}
	
	public ERS_USERS(Integer ERS_USERS_ID, String ERS_USERNAME, String ERS_PASSWORD) {
		this.ERS_USERS_ID = ERS_USERS_ID;
		this.ERS_USERNAME = ERS_USERNAME;
		this.ERS_PASSWORD = ERS_PASSWORD;
	}


	public ERS_USERS(Integer ERS_USERS_ID, String ERS_USERNAME, String ERS_PASSWORD, String USER_FIRST_NAME, String USER_LAST_NAME, String USER_EMAIL, USER_ROLES USER_ROLE) {
		super();
		this.ERS_USERS_ID = ERS_USERS_ID;
		this.ERS_USERNAME = ERS_USERNAME;
		this.ERS_PASSWORD = ERS_PASSWORD;
		this.USER_FIRST_NAME = USER_FIRST_NAME;
		this.USER_LAST_NAME = USER_LAST_NAME;
		this.USER_EMAIL = USER_EMAIL;
		this.USER_ROLE = USER_ROLE;
	}

	public Integer getERS_USERS_ID() {
		return ERS_USERS_ID;
	}

	public void setERS_USERS_ID(Integer ERS_USERS_ID) {
		this.ERS_USERS_ID = ERS_USERS_ID;
	}

	public String getERS_USERNAME() {
		return ERS_USERNAME;
	}

	public void setERS_USERNAME(String ERS_USERNAME) {
		this.ERS_USERNAME = ERS_USERNAME;
	}

	public String getERS_PASSWORD() {
		return ERS_PASSWORD;
	}

	public void setERS_PASSWORD(String ERS_PASSWORD) {
		this.ERS_PASSWORD = ERS_PASSWORD;
	}
	public String getUSER_FIRST_NAME() {
		return USER_FIRST_NAME;
	}

	public void setUSER_FIRST_NAME(String USER_FIRST_NAME) {
		this.USER_FIRST_NAME = USER_FIRST_NAME;
	}

	public String getUSER_LAST_NAME() {
		return USER_LAST_NAME;
	}

	public void setUSER_LAST_NAME(String USER_LAST_NAME) {
		this.USER_LAST_NAME = USER_LAST_NAME;
	}
	
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String USER_EMAIL) {
		this.USER_EMAIL = USER_EMAIL;
	}

	public USER_ROLES getUSER_ROLE() {
		return USER_ROLE;
	}

	public void setUSER_ROLE(USER_ROLES USER_ROLE) {
		this.USER_ROLE = USER_ROLE;
	}

	@Override
	public String toString() {
		return "User [id=" + ERS_USERS_ID + ", uname=" + ERS_USERNAME + ", pass=" + ERS_PASSWORD + ", fname="
				+ USER_FIRST_NAME + ", lname=" + USER_LAST_NAME + ", email=" + USER_EMAIL + ", role=" + USER_ROLE +"]";
	}
	
}