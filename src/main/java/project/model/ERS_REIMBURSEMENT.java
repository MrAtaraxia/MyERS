package project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.*;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="ERS_REIMBURSEMENT")
@NamedQueries(  
	    {  
	        @NamedQuery(
	        name = "viewAllReimbursments", 
	        query = "FROM ERS_REIMBURSEMENT s"),
	        @NamedQuery(
	        name = "findReimbursmentByID",
	        query = "FROM ERS_REIMBURSEMENT s WHERE s.id = :id"),
	        @NamedQuery(
	        name = "findReimbursmentsByStatusIDAuthorID", 
	        query = "FROM ERS_REIMBURSEMENT s WHERE s.REIMB_STATUS = :REIMB_STATUS and s.REIMB_AUTHOR_ID = :REIMB_AUTHOR"),
	        @NamedQuery(
	        name = "findReimbursmentsByAuthorID", 
	        query = "FROM ERS_REIMBURSEMENT s WHERE s.REIMB_AUTHOR_ID = :REIMB_AUTHOR"),
	        @NamedQuery(
	        name = "findReimbursmentsByStatusID", 
	        query = "FROM ERS_REIMBURSEMENT s WHERE s.REIMB_STATUS = :REIMB_STATUS"),
	        @NamedQuery(
	        name = "findReimbursmentsByTypeID", 
	        query = "FROM ERS_REIMBURSEMENT s WHERE s.REIMB_TYPE = :REIMB_TYPE"),
	    }
	)
public class ERS_REIMBURSEMENT implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REIMB_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int REIMB_ID;
	
	@Column(name="REIMB_AMOUNT", unique = false, nullable = false)
	private Double REIMB_AMOUNT;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REIMB_SUBMITTED", nullable = false)
	private Date REIMB_SUBMITTED;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REIMB_RESOLVED", nullable = true)
	private Date REIMB_RESOLVED;
	
	@Column(name="REIMB_DESCRIPTION", unique = false, nullable = false, length = 250)
	private String REIMB_DESCRIPTION;
	
	@Column(name="REIMB_RECEIPT")
	private String REIMB_RECEIPT;
	
	@JoinColumn(name = "REIMB_AUTHOR_ID")
	@ManyToOne(targetEntity = ERS_USERS.class, fetch = FetchType.EAGER)
	private ERS_USERS REIMB_AUTHOR;

	@Column(name = "REIMB_AUTHOR_ID", insertable = false, updatable = false)
	private int REIMB_AUTHOR_ID;
	
	@JoinColumn(name="REIMB_RESLOVER_ID", unique = false, nullable = true)
	@ManyToOne(targetEntity = ERS_USERS.class, fetch = FetchType.EAGER)
	private ERS_USERS REIMB_RESLOVER;

	@Column(name = "REIMB_RESLOVER_ID", insertable = false, updatable = false)
	private Integer REIMB_RESLOVER_ID;

	@Enumerated(value = EnumType.STRING)
	@Column(name="REIMB_STATUS", unique = false, nullable = false, columnDefinition = "varchar(25) default 'OTHER'")
	private REIMBURSEMENT_STATUS REIMB_STATUS;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name="REIMB_TYPE", unique = false, nullable = false, columnDefinition = "varchar(25) default 'OTHER'")
	private REIMBURSEMENT_TYPE REIMB_TYPE;
	
	public ERS_REIMBURSEMENT() {
		
	}

	
	public ERS_REIMBURSEMENT(int REIMB_ID, Double REIMB_AMOUNT, String REIMB_RECEIPT) {
		this.REIMB_ID = REIMB_ID;
		this.REIMB_AMOUNT = REIMB_AMOUNT;
		this.REIMB_RECEIPT = REIMB_RECEIPT;
	}


	public ERS_REIMBURSEMENT(int REIMB_ID, Double REIMB_AMOUNT, Date REIMB_SUBMITTED, Date REIMB_RESOLVED, String REIMB_DESCRIPTION, String REIMB_RECEIPT, ERS_USERS REIMB_AUTHOR, ERS_USERS REIMB_RESLOVER, REIMBURSEMENT_STATUS REIMB_STATUS, REIMBURSEMENT_TYPE REIMB_TYPE) {
		super();
		this.REIMB_ID = REIMB_ID;
		this.REIMB_AMOUNT = REIMB_AMOUNT;
		this.REIMB_SUBMITTED = REIMB_SUBMITTED;
		this.REIMB_RESOLVED = REIMB_RESOLVED;
		this.REIMB_DESCRIPTION = REIMB_DESCRIPTION;
		this.REIMB_RECEIPT = REIMB_RECEIPT;
		this.REIMB_AUTHOR = REIMB_AUTHOR;
		this.REIMB_RESLOVER = REIMB_RESLOVER;
		this.REIMB_STATUS = REIMB_STATUS;
		this.REIMB_TYPE = REIMB_TYPE;
		
	}

	public int getREIMB_ID() {
		return REIMB_ID;
	}

	public void setREIMB_ID(int REIMB_ID) {
		this.REIMB_ID = REIMB_ID;
	}

	public Double getREIMB_AMOUNT() {
		return REIMB_AMOUNT;
	}

	public void setREIMB_AMOUNT(Double REIMB_AMOUNT) {
		this.REIMB_AMOUNT = REIMB_AMOUNT;
	}

	public Date getREIMB_SUBMITTED() {
		return REIMB_SUBMITTED;
	}

	public void setREIMB_SUBMITTED(Date REIMB_SUBMITTED) {
		this.REIMB_SUBMITTED = REIMB_SUBMITTED;
	}
	
	public Date getREIMB_RESOLVED() {
		return REIMB_RESOLVED;
	}

	public void setREIMB_RESOLVED(Date REIMB_RESOLVED) {
		this.REIMB_RESOLVED = REIMB_RESOLVED;
	}
	
	public String getREIMB_DESCRIPTION() {
		return REIMB_DESCRIPTION;
	}

	public void setREIMB_DESCRIPTION(String REIMB_DESCRIPTION) {
		this.REIMB_DESCRIPTION = REIMB_DESCRIPTION;
	}

	public String getREIMB_RECEIPT() {
		return REIMB_RECEIPT;
	}

	public void setREIMB_RECEIPT(String REIMB_RECEIPT) {
		this.REIMB_RECEIPT = REIMB_RECEIPT;
	}
	
	public ERS_USERS getREIMB_AUTHOR() {
		return REIMB_AUTHOR;
	}

	public void setREIMB_AUTHOR(ERS_USERS REIMB_AUTHOR) {
		this.REIMB_AUTHOR = REIMB_AUTHOR;
	}
	
	public ERS_USERS getREIMB_RESLOVER() {
		return REIMB_RESLOVER;
	}

	public void setREIMB_RESLOVER(ERS_USERS REIMB_RESLOVER) {
		this.REIMB_RESLOVER = REIMB_RESLOVER;
	}

	public REIMBURSEMENT_STATUS getREIMB_STATUS() {
		return REIMB_STATUS;
	}

	public void setREIMB_STATUS(REIMBURSEMENT_STATUS REIMB_STATUS) {
		this.REIMB_STATUS = REIMB_STATUS;
	}

	public REIMBURSEMENT_TYPE getREIMB_TYPE() {
		return REIMB_TYPE;
	}

	public void setREIMB_TYPE(REIMBURSEMENT_TYPE REIMB_TYPE) {
		this.REIMB_TYPE = REIMB_TYPE;
	}

}
