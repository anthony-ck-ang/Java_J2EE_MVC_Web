package com.anthonyang.livre.dao;

import com.anthonyang.livre.DataStore;
import com.anthonyang.livre.entities.User;

/*
 * This is for the datastore implementation.  
 * Version 2 will change with the database implementation
 */

public class UserDao {
	public User[] getUser() {
		return DataStore.getUsers();
	}
}
