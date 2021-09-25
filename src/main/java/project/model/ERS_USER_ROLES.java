//package project.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Cacheable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import org.hibernate.annotations.*;
//
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Entity
//@Table(name="ERS_USER_ROLES")
//@NamedQueries(  
//	    {
//	        @NamedQuery(
//	        name = "viewAllRoles", 
//	        query = "FROM ERS_USER_ROLES s"),
//	        @NamedQuery(
//	        name = "findRoleByID",
//	        query = "FROM ERS_USER_ROLES s WHERE s.id = :id"),
//	        @NamedQuery(
//	        name = "findRoleByName", 
//	        query = "FROM ERS_USER_ROLES s WHERE s.USER_ROLES = :USER_ROLES"),
//	    }
//	) 
//public class ERS_USER_ROLES implements Serializable{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="USER_ROLES_ID", nullable=false, unique=true)
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer USER_ROLES_ID;
//	
//	@Column(name="USER_ROLES", nullable=false, unique=true)
//	private String USER_ROLES;
//	
//	public ERS_USER_ROLES() {
//	}
//	
//	public ERS_USER_ROLES(String USER_ROLES) {
//		this.USER_ROLES = USER_ROLES;
//	}
//
//	public ERS_USER_ROLES(Integer USER_ROLES_ID, String USER_ROLES) {
//		super();
//		this.USER_ROLES_ID = USER_ROLES_ID;
//		this.USER_ROLES = USER_ROLES;
//	}
//
//	public Integer getUSER_ROLES_ID() {
//		return USER_ROLES_ID;
//	}
//
//	public void setUSER_ROLES_ID(Integer USER_ROLES_ID) {
//		this.USER_ROLES_ID = USER_ROLES_ID;
//	}
//
//	public String getUSER_ROLES() {
//		return USER_ROLES;
//	}
//
//	public void setUSER_ROLES(String USER_ROLES) {
//		this.USER_ROLES = USER_ROLES;
//	}
//
//	@Override
//	public String toString() {
//		return "TYPE [id=" + USER_ROLES_ID + ", TYPE=" + USER_ROLES + "]";
//	}
//	
//}
