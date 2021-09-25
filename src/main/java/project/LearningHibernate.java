package project;
import java.util.List;
import project.dao.*;
import project.model.ERS_REIMBURSEMENT;
import project.model.ERS_USERS;
import project.model.REIMBURSEMENT_STATUS;
import project.model.REIMBURSEMENT_TYPE;
import project.model.USER_ROLES;
public class LearningHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ERS_USERS eUse = new ERS_USERS();
		
		//ERS_REIMBURSEMENT eRei = new ERS_REIMBURSEMENT();
		ERS_REIMBURSEMENTDao eDao = new ERS_REIMBURSEMENTDao();
		ERS_USERSDao uDao = new ERS_USERSDao();
		List<ERS_USERS> a = uDao.selectAll();
		for(ERS_USERS per:a) {
			System.out.println(per);
		}
		eUse.setERS_PASSWORD("123456");
		eUse.setERS_USERNAME("123456");
		eUse.setUSER_EMAIL("123@456");
		eUse.setUSER_FIRST_NAME("123");
		eUse.setUSER_LAST_NAME("456");
		eUse.setUSER_ROLE(USER_ROLES.EMPLOYEE);
		uDao.insert(eUse);

		eUse = new ERS_USERS();
		eUse.setERS_PASSWORD("man");
		eUse.setERS_USERNAME("man");
		eUse.setUSER_EMAIL("man@man");
		eUse.setUSER_FIRST_NAME("man");
		eUse.setUSER_LAST_NAME("man");
		eUse.setUSER_ROLE(USER_ROLES.MANAGER);
		uDao.insert(eUse);
		
		ERS_REIMBURSEMENT eRei = new ERS_REIMBURSEMENT();
		eRei.setREIMB_AMOUNT(10.0);
		eRei.setREIMB_AUTHOR(uDao.selectERS_USERS(1));
		eRei.setREIMB_DESCRIPTION("description");
		eRei.setREIMB_RECEIPT("C:\\uploads\\file.jpg");
		eRei.setREIMB_STATUS(REIMBURSEMENT_STATUS.PENDING);
		eRei.setREIMB_TYPE(REIMBURSEMENT_TYPE.LODGING);
		eDao.insert(eRei);
		
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
