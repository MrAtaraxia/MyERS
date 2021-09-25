//package project.dao;
//
//import java.util.List;
//
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.ParameterExpression;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import project.model.ERS_USERS;
//import project.model.ERS_USER_ROLES;
//import project.util.HibernateUtil;
//
//public class ERS_USER_ROLESDao {
//	
//	public static int version = 0;
//	
//	public ERS_USER_ROLESDao() {
//	}
//
//	/*
//	 * SELECT BY ID
//	 */
//	public ERS_USER_ROLES selectById(int id) {
//		Session ses = HibernateUtil.getSession();
//		ERS_USER_ROLES user_roles = ses.get(ERS_USER_ROLES.class, id);
//		return user_roles;
//	}
//
//	/*
//	 * SELECT BY NAME
//	 */
//	public ERS_USER_ROLES selectByName(String USER_ROLES) {
//		//Creates complex queries programatically, it does with OOP principles
//		Session ses = HibernateUtil.getSession();
//		CriteriaBuilder builder = ses.getCriteriaBuilder();
//		CriteriaQuery<ERS_USER_ROLES> q = builder.createQuery(ERS_USER_ROLES.class);
//		Root<ERS_USER_ROLES> root = q.from(ERS_USER_ROLES.class);
//		ParameterExpression<String> p = builder.parameter(String.class);
//		q.select(root).where(builder.equal(root.get("USER_ROLES"), p));
//		TypedQuery<ERS_USER_ROLES> query = ses.createQuery(q);
//		query.setParameter(p, USER_ROLES);
//		List<ERS_USER_ROLES> returnList = query.getResultList();
//		return returnList.get(0);
//	}
//
//	/*
//	 * SELECT ALL
//	 */
//	public List<ERS_USER_ROLES> selectAll(){
//		Session ses = HibernateUtil.getSession();
//		List<ERS_USER_ROLES> cList = ses.createQuery("from ERS_USER_ROLES", ERS_USER_ROLES.class).list();
//		return cList;
//	}
//	
//	/*
//	 * INSERT
//	 */
//	public void insert(ERS_USER_ROLES user_roles) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		ses.save(user_roles);
//		try {
//			tx.commit();
//			version++;
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
//
//	/*
//	 * UPDATE
//	 */
//	public void update(ERS_USER_ROLES user_roles) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		ses.update(user_roles);
//		try {
//			tx.commit();
//			version++;
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//		}
//	}	
//	
//	/*
//	 * DELETE
//	 */
//	public void delete(ERS_USER_ROLES user_roles) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		ses.delete(user_roles);
//		try {
//			tx.commit();
//			version++;
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
//}
