package com.tcs.abc.bean;

import java.util.Date;

public class User {
String username;
String password;
String designation;
Date date;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public User(String username, String password, String designation, Date date) {
	super();
	this.username = username;
	this.password = password;
	this.designation = designation;
	this.date = date;
}
public User() {
	super();
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password
			+ ", designation=" + designation + ", date=" + date + "]";
}


}
