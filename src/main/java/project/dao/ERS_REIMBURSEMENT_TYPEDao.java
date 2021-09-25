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
//import project.model.ERS_REIMBURSEMENT_STATUS;
//import project.model.ERS_REIMBURSEMENT_TYPE;
//import project.util.HibernateUtil;
//
//public class ERS_REIMBURSEMENT_TYPEDao {
//	public static int version = 1;
//	
//	public ERS_REIMBURSEMENT_TYPEDao() {
//	}
//
//	
//	public ERS_REIMBURSEMENT_TYPE selectById(int id) {
//		Session ses = HibernateUtil.getSession();
//		ERS_REIMBURSEMENT_TYPE user_type = ses.get(ERS_REIMBURSEMENT_TYPE.class, id);
//		return user_type;
//	}
//	
//	public ERS_REIMBURSEMENT_TYPE selectByName(String REIMB_TYPE) {
//		//Creates complex queries programatically, it does with OOP principles
//		Session ses = HibernateUtil.getSession();
//		CriteriaBuilder builder = ses.getCriteriaBuilder();
//		CriteriaQuery<ERS_REIMBURSEMENT_TYPE> q = builder.createQuery(ERS_REIMBURSEMENT_TYPE.class);
//		Root<ERS_REIMBURSEMENT_TYPE> root = q.from(ERS_REIMBURSEMENT_TYPE.class);
//		ParameterExpression<String> p = builder.parameter(String.class);
//		q.select(root).where(builder.equal(root.get("REIMB_TYPE"), p));
//		TypedQuery<ERS_REIMBURSEMENT_TYPE> query = ses.createQuery(q);
//		query.setParameter(p, REIMB_TYPE);
//		List<ERS_REIMBURSEMENT_TYPE> returnList = query.getResultList();
//		return returnList.get(0);
//	}
//	
//	public List<ERS_REIMBURSEMENT_TYPE> selectAll(){
//		Session ses = HibernateUtil.getSession();
//		List<ERS_REIMBURSEMENT_TYPE> cList = ses.createQuery("from ERS_REIMBURSEMENT_TYPE", ERS_REIMBURSEMENT_TYPE.class).list();
//		return cList;
//	}
//	
//	public void insert(ERS_REIMBURSEMENT_TYPE user_type) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		ses.save(user_type);
//		try {
//			tx.commit();
//			version++;
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
//	
//	public void update(ERS_REIMBURSEMENT_TYPE user_type) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		ses.update(user_type);
//		try {
//			tx.commit();
//			version++;
//		}
//		catch (Exception e) {
//			e.getStackTrace();
//		}
//	}
//}
