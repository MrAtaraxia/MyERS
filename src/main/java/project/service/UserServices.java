package project.service;

import project.model.ERS_USERS;
import project.dao.ERS_USERSDao;
import java.util.*;

public class UserServices {
	private ERS_USERSDao userDao;
	
	public Boolean verifyLoginCredentials(String uname, String pass) {
		return null;
	}
	
	public ERS_USERS retrieveUser(Integer userID){
		return null;
	}
	
	public List<ERS_USERS> retrieveAllUsers(){
		return null;
	}
	
	public Boolean registerUser(ERS_USERS user) {
		return null;
	}
	
	public Boolean deleteUser(Integer userID) {
		return null;
	}

	public ERS_USERSDao getUserDao() {
		return userDao;
	}

	public void setUserDao(ERS_USERSDao userDao) {
		this.userDao = userDao;
	}
}
