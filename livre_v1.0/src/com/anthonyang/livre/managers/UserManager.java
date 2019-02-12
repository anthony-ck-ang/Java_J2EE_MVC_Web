package com.anthonyang.livre.managers;

import com.anthonyang.livre.dao.UserDao;
import com.anthonyang.livre.entities.User;

public class UserManager {
	
	//MVC - Controller will invoke Manager which will invoke the Dao
	//Business logic exists in Manager classes 
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao(); 

	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public User[] getUser() {
		return dao.getUser();
	}
}
