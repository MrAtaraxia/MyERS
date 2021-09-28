package project.service;

import project.model.ERS_USERS;
import project.dao.ERS_USERSDao;
import java.util.*;

public class UserServices implements UserService {
	private ERS_USERSDao userDao;
	
	public UserServices(){
		this.userDao = new ERS_USERSDao();
	}
	
	public UserServices(ERS_USERSDao userDao) {
		this.userDao = userDao;
	}
	/*
	 * Verifies the login credentials exist.
	 * Returns true/false based on if exists.
	 */
	public Boolean verifyLoginCredentials(String uname, String pass) {
		ERS_USERS user = userDao.selectByUnamePass(uname, pass);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public ERS_USERS retrieveUser(Integer userID){
		return userDao.selectERS_USERS(userID);
	}
	
	public List<ERS_USERS> retrieveAllUsers(){
		return userDao.selectAll();
	}
	
	public Boolean registerUser(ERS_USERS user) {
		return userDao.insert(user);
	}

	public Boolean updateUser(ERS_USERS user) {
		return userDao.update(user);
	}
	
	public Boolean deleteUser(Integer userID) {
		
		ERS_USERS userToDelete = userDao.selectERS_USERS(userID);
		if(userToDelete==null) {
			return false;
		} else {
			return userDao.delete(userToDelete);
		}
	}

	public ERS_USERSDao getUserDao() {
		return userDao;
	}

	public void setUserDao(ERS_USERSDao userDao) {
		this.userDao = userDao;
	}
}
