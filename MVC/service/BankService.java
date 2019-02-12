package com.tcs.abc.service;

import java.util.ArrayList;
import java.util.List;

import com.tcs.abc.bean.Account;
import com.tcs.abc.bean.Customer;
import com.tcs.abc.bean.User;
import com.tcs.abc.dao.CustomerDao;

public class BankService {

	public int insertUser(int ssn, int id, String name, int age,
			String address1, String address2, String city, String state) {
		CustomerDao dao112 = new CustomerDao();

		return dao112.insertUser(ssn, id, name, age, address1, address2, city,
				state);

	}

	public int insertAccount(int ssn, String accType, double depositAmount) {
		CustomerDao dao112 = new CustomerDao();

		return dao112.insertAccount(ssn, accType, depositAmount);

	}

	public int deleteUserSSN(int SSN) {
		CustomerDao dao11 = new CustomerDao();

		return dao11.deleteUserSSN(SSN);

	}

	public int deleteUserID(int ID) {
		CustomerDao dao11 = new CustomerDao();

		return dao11.deleteUserID(ID);

	}

	public int deleteAccID(int ID) {
		CustomerDao dao11 = new CustomerDao();

		return dao11.deleteAccID(ID);

	}

	public Customer findCustomerBySSN(int updateSelection) {

		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		customer = dao.findCustomerBySSN(updateSelection);

		return customer;
	}

	public Customer findCustomerByID(int updateSelection) {

		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		customer = dao.findCustomerByID(updateSelection);

		return customer;
	}

	public int updateCustSSN(int value, String name, int age, String address1,
			String address2, String city, String state) {
		CustomerDao dao11 = new CustomerDao();
		return dao11.updateCustSSN(value, name, age, address1, address2, city,
				state);
	}

	public ArrayList<Account> getAllCustomer(int SSN) {
		CustomerDao dao = new CustomerDao();
		return dao.getAllCustomer(SSN);
	}

	public ArrayList<Account> getAllAccounts() {
		CustomerDao dao = new CustomerDao();
		return dao.getAllAccounts();
	}

	public ArrayList<Customer> getAllCustomers() {
		CustomerDao dao = new CustomerDao();
		return dao.getAllCustomers();
	}

	public int updateCustID(int value, String name, int age, String address1,
			String address2, String city, String state) {
		CustomerDao dao11 = new CustomerDao();
		return dao11.updateCustID(value, name, age, address1, address2, city,
				state);
	}

	public Customer findCustomer(int ssnid) {
		CustomerDao dao = new CustomerDao();
		return dao.findCustomer(ssnid);

	}

	public Customer findCustomerbyId(int custid) {
		CustomerDao dao = new CustomerDao();
		return dao.findCustomerbyId(custid);
	}

	public User validateLogin(String username, String password) {
		CustomerDao dao11 = new CustomerDao();
		return dao11.validateLogin(username, password);
	}

	public Account findAccByAcctId(int acctid) {
		CustomerDao dao = new CustomerDao();
		return dao.findAccByAcctId(acctid);
	}

	public Account findAccountbyCustId(int custid) {
		CustomerDao dao = new CustomerDao();
		return dao.findAccountbyCustId(custid);
	}

	public List<Account> getAccdetails(int custid) {
		CustomerDao dao = new CustomerDao();
		return dao.getAccdetails(custid);
	}

}
