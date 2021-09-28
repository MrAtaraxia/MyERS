package project.service;

import java.util.List;

import project.model.ERS_USERS;

public interface UserService {
	/*
	 * Verifies the login credentials for the user.
	 */
	public Boolean verifyLoginCredentials(String uname, String pass);
	/*
	 * Retrieve a user by userID.
	 */
	public ERS_USERS retrieveUser(Integer userID);
	/*
	 * Retrieve All Users.
	 */
	public List<ERS_USERS> retrieveAllUsers();
	/*
	 * Register a new User.
	 */
	public Boolean registerUser(ERS_USERS user);
	/*
	 * Update a User.
	 */
	public Boolean updateUser(ERS_USERS user);
	/*
	 * Delete a User.
	 */
	public Boolean deleteUser(Integer userID);
}
