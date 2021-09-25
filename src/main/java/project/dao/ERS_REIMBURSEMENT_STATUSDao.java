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
//import project.util.HibernateUtil;
//
//public class ERS_REIMBURSEMENT_STATUSDao {
//	public static int version = 1;
//	
//	public ERS_REIMBURSEMENT_STATUSDao() {
//	}
//
//	public ERS_REIMBURSEMENT_STATUS selectById(int id) {
//		Session ses = HibernateUtil.getSession();
//		ERS_REIMBURSEMENT_STATUS user_type = ses.get(ERS_REIMBURSEMENT_STATUS.class, id);
//		return user_type;
//	}
//	
//	public ERS_REIMBURSEMENT_STATUS selectByName(String REIMB_STATUS) {
//		//Creates complex queries programatically, it does with OOP principles
//		Session ses = HibernateUtil.getSession();
//		CriteriaBuilder builder = ses.getCriteriaBuilder();
//		CriteriaQuery<ERS_REIMBURSEMENT_STATUS> q = builder.createQuery(ERS_REIMBURSEMENT_STATUS.class);
//		Root<ERS_REIMBURSEMENT_STATUS> root = q.from(ERS_REIMBURSEMENT_STATUS.class);
//		ParameterExpression<String> p = builder.parameter(String.class);
//		q.select(root).where(builder.equal(root.get("REIMB_STATUS"), p));
//		TypedQuery<ERS_REIMBURSEMENT_STATUS> query = ses.createQuery(q);
//		query.setParameter(p, REIMB_STATUS);
//		List<ERS_REIMBURSEMENT_STATUS> usersList = query.getResultList();
//		return usersList.get(0);
//	}
//	
//	public List<ERS_REIMBURSEMENT_STATUS> selectAll(){
//		Session ses = HibernateUtil.getSession();
//		List<ERS_REIMBURSEMENT_STATUS> cList = ses.createQuery("from ERS_REIMBURSEMENT_STATUS", ERS_REIMBURSEMENT_STATUS.class).list();
//		return cList;
//	}
//	
//	public void insert(ERS_REIMBURSEMENT_STATUS user_type) {
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
//	public void update(ERS_REIMBURSEMENT_STATUS user_type) {
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
