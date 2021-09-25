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
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY )
//@Entity
//@Table(name="ERS_REIMBURSEMENT_TYPE")
//public class ERS_REIMBURSEMENT_TYPE implements Serializable{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 8757493238917101376L;
//
//	@Id
//	@Column(name="REIMB_TYPE_ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int REIMB_TYPE_ID;
//	
//	@Column(name="REIMB_TYPE", nullable=false, unique=true)
//	private String REIMB_TYPE;
//	
//	
//	public ERS_REIMBURSEMENT_TYPE() {
//		
//	}
//	
//	public ERS_REIMBURSEMENT_TYPE(String REIMB_TYPE) {
//		this.REIMB_TYPE = REIMB_TYPE;
//	}
//
//	public ERS_REIMBURSEMENT_TYPE(int REIMB_TYPE_ID, String REIMB_TYPE) {
//		super();
//		this.REIMB_TYPE_ID = REIMB_TYPE_ID;
//		this.REIMB_TYPE = REIMB_TYPE;
//	}
//
//	public int getREIMB_TYPE_ID() {
//		return REIMB_TYPE_ID;
//	}
//
//	public void setREIMB_TYPE_ID(int REIMB_TYPE_ID) {
//		this.REIMB_TYPE_ID = REIMB_TYPE_ID;
//	}
//
//	public String getREIMB_TYPE() {
//		return REIMB_TYPE;
//	}
//
//	public void setREIMB_TYPE(String REIMB_TYPE) {
//		this.REIMB_TYPE = REIMB_TYPE;
//	}
//
//
//	@Override
//	public String toString() {
//		return "TYPE [id=" + REIMB_TYPE_ID + ", TYPE=" + REIMB_TYPE + "]";
//	}
//	
//}
