package project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import project.model.ERS_REIMBURSEMENT;
import project.model.REIMBURSEMENT_STATUS;
import project.model.REIMBURSEMENT_TYPE;
import project.util.HibernateUtil;

public class ERS_REIMBURSEMENTDao {
	
	public static int version = 0;
	
	public ERS_REIMBURSEMENTDao() {
	}
	
	/*
	 * SELECT REIMBURSEMENT by ID
	 */
	public ERS_REIMBURSEMENT selectERS_REIMBURSEMENT(int id) {
		Session ses = HibernateUtil.getSession();
		//If you are using ses.get(), you must use the id
		ERS_REIMBURSEMENT ersUser = ses.get(ERS_REIMBURSEMENT.class, id);
		//ses.close();
		return ersUser;
	}
	
	/*
	 * SELECT ALL REIMBURSEMENTs
	 */
	public List<ERS_REIMBURSEMENT> selectAll(){
		Session ses = HibernateUtil.getSession();
		//This is how we select all entries in a table with HQL
		//HQL is based off of our Java objects, not the table in the db, 
		//Hibernate translates this HQL into native SQL
		List<ERS_REIMBURSEMENT> usersList = ses.createQuery("from ERS_REIMBURSEMENT", ERS_REIMBURSEMENT.class).list();
		return usersList;
	}
	/*
	 * SELECT REIMBURSEMENT by Reimbursement Author ID
	 */
	public ERS_REIMBURSEMENT selectByAuthorID(int REIMB_AUTHOR_ID) {
		//Creates complex queries programatically, it does with OOP principles
		Session ses = HibernateUtil.getSession();
		CriteriaBuilder qb = ses.getCriteriaBuilder();
		CriteriaQuery<ERS_REIMBURSEMENT> q = qb.createQuery(ERS_REIMBURSEMENT.class);
		Root<ERS_REIMBURSEMENT> root = q.from(ERS_REIMBURSEMENT.class);
		//Constructing list of parameters
	    List<Predicate> predicates = new ArrayList<Predicate>();
	    //Adding predicates in case of parameter not being null
	    predicates.add(qb.equal(root.get("REIMB_AUTHOR"), REIMB_AUTHOR_ID));
	    //predicates.add(qb.equal(root.get("ERS_PASSWORD"), Pass));
	    //query itself
	    q.select(root).where(predicates.toArray(new Predicate[]{}));
	    //execute query and do something with result
		List<ERS_REIMBURSEMENT> usersList = ses.createQuery(q).getResultList();
		System.out.println(usersList);
		return usersList.get(0);
	}
	/*
	 * SELECT REIMBURSEMENT by Reimbursement Status ID
	 */
	public List<ERS_REIMBURSEMENT> selectByREIMB_STATUS(REIMBURSEMENT_STATUS REIMB_STATUS_ID) {
		//Creates complex queries programatically, it does with OOP principles
		Session ses = HibernateUtil.getSession();
		CriteriaBuilder qb = ses.getCriteriaBuilder();
		CriteriaQuery<ERS_REIMBURSEMENT> q = qb.createQuery(ERS_REIMBURSEMENT.class);
		Root<ERS_REIMBURSEMENT> root = q.from(ERS_REIMBURSEMENT.class);
		//Constructing list of parameters
	    List<Predicate> predicates = new ArrayList<Predicate>();
	    //Adding predicates in case of parameter not being null
	    predicates.add(qb.equal(root.get("REIMB_STATUS"), REIMB_STATUS_ID));
	    //predicates.add(qb.equal(root.get("ERS_PASSWORD"), Pass));
	    //query itself
	    q.select(root).where(predicates.toArray(new Predicate[]{}));
	    //execute query and do something with result
		List<ERS_REIMBURSEMENT> usersList = ses.createQuery(q).getResultList();
		System.out.println(usersList);
		return usersList;
	}
	
	/*
	 * SELECT REIMBURSEMENT by Reimbursement Type ID
	 */
	public List<ERS_REIMBURSEMENT> selectByREIMB_TYPE(REIMBURSEMENT_TYPE REIMB_TYPE_ID) {
		//Creates complex queries programatically, it does with OOP principles
		Session ses = HibernateUtil.getSession();
		CriteriaBuilder qb = ses.getCriteriaBuilder();
		CriteriaQuery<ERS_REIMBURSEMENT> q = qb.createQuery(ERS_REIMBURSEMENT.class);
		Root<ERS_REIMBURSEMENT> root = q.from(ERS_REIMBURSEMENT.class);
		//Constructing list of parameters
	    List<Predicate> predicates = new ArrayList<Predicate>();
	    //Adding predicates in case of parameter not being null
	    predicates.add(qb.equal(root.get("REIMB_TYPE"), REIMB_TYPE_ID));
	    //predicates.add(qb.equal(root.get("ERS_PASSWORD"), Pass));
	    //query itself
	    q.select(root).where(predicates.toArray(new Predicate[]{}));
	    //execute query and do something with result
		List<ERS_REIMBURSEMENT> usersList = ses.createQuery(q).getResultList();
		System.out.println(usersList);
		return usersList;
	}
	
	/*
	 * INSERT REIMBURSEMENT
	 */
	public void insert(ERS_REIMBURSEMENT euser) {
		//First we need to open up a session
		Session ses = HibernateUtil.getSession();
		//Then we must start a transaction
		Transaction tx = ses.beginTransaction();
		//Use the session method .save() to write the super villain object to our database
		ses.save(euser);
		//Commit the transaction
		try {
			tx.commit();
			version++;
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		//Close the session once you are done
		//ses.close();
	}
	
	/*
	 * UPDATE REIMBURSEMENT
	 */
	public void update(ERS_REIMBURSEMENT euser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(euser);
		try {
			tx.commit();
			version++;
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	/*
	 * DELETE REIMBURSEMENT
	 */
	public void delete(ERS_REIMBURSEMENT euser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(euser);
		try {
			tx.commit();
			version++;
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	
}
