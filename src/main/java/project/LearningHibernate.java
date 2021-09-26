package project;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import project.dao.*;
import project.model.ERS_REIMBURSEMENT;
import project.model.ERS_USERS;
import project.model.REIMBURSEMENT_STATUS;
import project.model.REIMBURSEMENT_TYPE;
import project.model.USER_ROLES;
import project.util.HibernateUtil;
public class LearningHibernate {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ERS_USERS eUse = new ERS_USERS();
		
		Session ses = HibernateUtil.getSession();
		Query<ERS_REIMBURSEMENT> query = ses.getNamedQuery("findReimbursmentsByStatusID").setParameter("REIMB_STATUS", REIMBURSEMENT_STATUS.PENDING);
		List<ERS_REIMBURSEMENT> aList = query.list();
		for(ERS_REIMBURSEMENT use:aList) {
			System.out.println(use.getREIMB_ID());
		}
//		//ERS_REIMBURSEMENT eRei = new ERS_REIMBURSEMENT();
		ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();

//		List<ERS_USERS> a = uDao.selectAll();
//		for(ERS_USERS per:a) {
//			System.out.println(per);
//		}
		
		ERS_USERSDao uDao = new ERS_USERSDao();
//		eUse.setERS_PASSWORD("123456");
//		eUse.setERS_USERNAME("123456");
//		eUse.setUSER_EMAIL("123@456");
//		eUse.setUSER_FIRST_NAME("123");
//		eUse.setUSER_LAST_NAME("456");
//		eUse.setUSER_ROLE(USER_ROLES.EMPLOYEE);
//		uDao.insert(eUse);
//
//		eUse = new ERS_USERS();
//		eUse.setERS_PASSWORD("man");
//		eUse.setERS_USERNAME("man");
//		eUse.setUSER_EMAIL("man@man");
//		eUse.setUSER_FIRST_NAME("man");
//		eUse.setUSER_LAST_NAME("man");
//		eUse.setUSER_ROLE(USER_ROLES.MANAGER);
//		uDao.insert(eUse);
		
		ERS_REIMBURSEMENT eRei = new ERS_REIMBURSEMENT();
//		eRei.setREIMB_AMOUNT(10.0);
//		eRei.setREIMB_AUTHOR(uDao.selectERS_USERS(1));
//		eRei.setREIMB_DESCRIPTION("description");
//		eRei.setREIMB_RECEIPT("C:\\uploads\\file.jpg");
//		eRei.setREIMB_STATUS(REIMBURSEMENT_STATUS.PENDING);
//		eRei.setREIMB_TYPE(REIMBURSEMENT_TYPE.LODGING);
//		eDao.insert(eRei);
		ERS_USERS use = uDao.selectAll().get(0);
		//ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
		ERS_REIMBURSEMENT myRei = eDao.selectERS_REIMBURSEMENT(1);
		myRei.setREIMB_RESLOVER(use);
		myRei.setREIMB_STATUS(REIMBURSEMENT_STATUS.APPROVED);
		eDao.update(myRei);
		
		myRei = eDao.selectAll().get(0);
		System.out.println(myRei.getREIMB_RESLOVER());
		
		
		
		
//		ERS_REIMBURSEMENT_STATUSDao statDao = new ERS_REIMBURSEMENT_STATUSDao();
//		
//		ERS_REIMBURSEMENT_TYPEDao typeDao = new ERS_REIMBURSEMENT_TYPEDao();
//		
//		ERS_USER_ROLESDao roleDao = new ERS_USER_ROLESDao();
//		

		//eRoles = new ERS_USER_ROLES("EMPLOYEE");
		//roleDao.insert(eRoles);
		//eRoles = new ERS_USER_ROLES("MANAGER");
		//roleDao.insert(eRoles);
		//eRoles = new ERS_USER_ROLES("NONE");
		//roleDao.insert(eRoles);
		
//		reStatus = new ERS_REIMBURSEMENT_STATUS("PENDING");
//		statDao.insert(reStatus);
//		reStatus = new ERS_REIMBURSEMENT_STATUS("APPROVED");
//		statDao.insert(reStatus);
//		reStatus = new ERS_REIMBURSEMENT_STATUS("DENIED");
//		statDao.insert(reStatus);
		
//		reType = new ERS_REIMBURSEMENT_TYPE("LODGING");
//		typeDao.insert(reType);
//		reType = new ERS_REIMBURSEMENT_TYPE("FOOD");
//		typeDao.insert(reType);
//		reType = new ERS_REIMBURSEMENT_TYPE("TRAVEL");
//		typeDao.insert(reType);
//		reType = new ERS_REIMBURSEMENT_TYPE("OTHER");
//		typeDao.insert(reType);
		
		System.out.println("Hi");
	}
}
