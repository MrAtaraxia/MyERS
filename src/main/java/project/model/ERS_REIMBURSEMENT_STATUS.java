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
//
//import org.hibernate.annotations.*;
//
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY )
//@Entity
//@Table(name="ERS_REIMBURSEMENT_STATUS")
//@NamedQueries(  
//	    {
//	        @NamedQuery(
//	        name = "viewAllStatus", 
//	        query = "FROM ERS_REIMBURSEMENT_STATUS s"),
//	        @NamedQuery(
//	        name = "findStatusByID",
//	        query = "FROM ERS_REIMBURSEMENT_STATUS s WHERE s.id = :id"),
//	        @NamedQuery(
//	        name = "findStatusBySTATUS", 
//	        query = "FROM ERS_REIMBURSEMENT_STATUS s WHERE s.REIMB_STATUS = :REIMB_STATUS"),
//	    }
//	)
//public class ERS_REIMBURSEMENT_STATUS implements Serializable{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="REIMB_STATUS_ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int REIMB_STATUS_ID;
//	
//	@Column(name="REIMB_STATUS", nullable=false, unique=true)
//	private String REIMB_STATUS;
//	
//	
//	public ERS_REIMBURSEMENT_STATUS() {
//	}
//	
//	public ERS_REIMBURSEMENT_STATUS(String REIMB_STATUS) {
//		this.REIMB_STATUS = REIMB_STATUS;
//	}
//
//	public ERS_REIMBURSEMENT_STATUS(int REIMB_STATUS_ID, String REIMB_STATUS) {
//		this.REIMB_STATUS_ID = REIMB_STATUS_ID;
//		this.REIMB_STATUS = REIMB_STATUS;
//	}
//
//	public int getREIMB_STATUS_ID() {
//		return REIMB_STATUS_ID;
//	}
//
//	public void setREIMB_STATUS_ID(int REIMB_STATUS_ID) {
//		this.REIMB_STATUS_ID = REIMB_STATUS_ID;
//	}
//
//	public String getREIMB_STATUS() {
//		return REIMB_STATUS;
//	}
//
//	public void setREIMB_STATUS(String REIMB_STATUS) {
//		this.REIMB_STATUS = REIMB_STATUS;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Status [id=" + REIMB_STATUS_ID + ", status=" + REIMB_STATUS + "]";
//	}
//	
//}
