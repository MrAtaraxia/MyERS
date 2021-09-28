package project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import project.model.ERS_USERS;
import project.util.HibernateUtil;

public class ERS_USERSDao {
	
	public static int version = 0;
	
	public ERS_USERSDao() {
	}
	
	/*
	 * SELECT User by ID
	 */
	public ERS_USERS selectERS_USERS(int id) {
		Session ses = HibernateUtil.getSession();
		//If you are using ses.get(), you must use the id
		ERS_USERS ersUser = ses.get(ERS_USERS.class, id);
		//ses.close();
		return ersUser;
	}
	
	/*
	 * SELECT ALL Users
	 */
	public List<ERS_USERS> selectAll(){
		Session ses = HibernateUtil.getSession();
		//This is how we select all entries in a table with HQL
		//HQL is based off of our Java objects, not the table in the db, 
		//Hibernate translates this HQL into native SQL
		List<ERS_USERS> usersList = ses.createQuery("from ERS_USERS", ERS_USERS.class).list();
		return usersList;
	}
	
	public ERS_USERS selectByUserRoleNative(int USER_ROLES_ID) {
		
		//We can use native SQL queries
		//You can create more complex queries with plain old SQL query
		//It targets the database table rather than the object
		//It is not recommended because it tightly couples your application to your database
		Session ses = HibernateUtil.getSession();
		List<ERS_USERS> usersList = ses.createNativeQuery("select * from ERS_USERS where USER_ROLES_ID= '" + USER_ROLES_ID + "'", ERS_USERS.class).list();
		return usersList.get(0);
	}
	
	public List<ERS_USERS> selectByUserRoleHQL(int USER_ROLES_ID) {
		//HQL Hibernate Query Language creates complex queries using a combo of OOP and SQL
		Session ses = HibernateUtil.getSession();
		List<ERS_USERS> usersList = ses.createQuery("from ERS_USERS where USER_ROLES_ID='" + USER_ROLES_ID + "'", ERS_USERS.class).list();
		if(usersList.size() == 0) {
			return null;
		}
		return usersList;
	}
	
	public List<ERS_USERS> selectByUserRoleID(int USER_ROLES_ID) {
		//Creates complex queries programatically, it does with OOP principles
		Session ses = HibernateUtil.getSession();
		CriteriaBuilder builder = ses.getCriteriaBuilder();
		CriteriaQuery<ERS_USERS> q = builder.createQuery(ERS_USERS.class);
		Root<ERS_USERS> root = q.from(ERS_USERS.class);
		ParameterExpression<Integer> p = builder.parameter(Integer.class);
		q.select(root).where(builder.equal(root.get("USER_ROLES_ID"), p));
		TypedQuery<ERS_USERS> query = ses.createQuery(q);
		query.setParameter(p, USER_ROLES_ID);
		List<ERS_USERS> usersList = query.getResultList();
		System.out.println("SELECT USERS BY USER ROLE ID:" + usersList);
		return usersList;
	}
	
	public ERS_USERS selectByUnamePass(String Uname, String Pass) {
		//Creates complex queries programatically, it does with OOP principles
		Session ses = HibernateUtil.getSession();
		CriteriaBuilder qb = ses.getCriteriaBuilder();
		CriteriaQuery<ERS_USERS> q = qb.createQuery(ERS_USERS.class);
		Root<ERS_USERS> root = q.from(ERS_USERS.class);
		
		//Constructing list of parameters
	    List<Predicate> predicates = new ArrayList<Predicate>();

	    //Adding predicates in case of parameter not being null
	    predicates.add(qb.equal(root.get("ERS_USERNAME"), Uname));
	    predicates.add(qb.equal(root.get("ERS_PASSWORD"), Pass));
	    //query itself
	    q.select(root).where(predicates.toArray(new Predicate[]{}));
	    //execute query and do something with result
	    
		List<ERS_USERS> usersList = ses.createQuery(q).getResultList();
		System.out.println("SELECT USER BY USERNAME AND PASSWORD:" +usersList);
		return usersList.get(0);
	}
	
	/*
	 * INSERT
	 */
	public Boolean insert(ERS_USERS euser) {
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
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		//Close the session once you are done
		//ses.close();
	}
	
	/*
	 * UPDATE
	 */
	public Boolean update(ERS_USERS euser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(euser);
		try {
			tx.commit();
			version++;
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
	/*
	 * DELETE
	 */
	public Boolean delete(ERS_USERS euser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(euser);
		try {
			tx.commit();
			version++;
			return true;
		}
		catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
	
}
