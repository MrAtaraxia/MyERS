package project.service;

import project.dao.ERS_USERSDao;
import project.model.ERS_USERS;
 
public class LoginService {
	public static ERS_USERS currentUser = null;
    public static boolean authenticateUser(String userName, String password) {
    	ERS_USERSDao uDao = new ERS_USERSDao();
    	//ERS_USERS user = uDao.selectERS_USERS(userId);
    	ERS_USERS user = uDao.selectByUnamePass(userName, password);
        if(user!=null && user.getERS_USERNAME().equals(userName) && user.getERS_PASSWORD().equals(password)){
            currentUser = user;
        	return true;
        }else{
            return false;
        }
    }
}