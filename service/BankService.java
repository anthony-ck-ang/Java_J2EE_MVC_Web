package com.anthonyang.abc.service;

import java.util.ArrayList;
import java.util.List;

import com.anthonyang.abc.bean.Account;
import com.anthonyang.abc.bean.Customer;
import com.anthonyang.abc.bean.User;
import com.anthonyang.abc.dao.CustomerDao;

public class BankService {
	static BankService instance = new BankService();

	private BankService() {
	}

	public static BankService getInstance() {
		return instance;
	}

	CustomerDao dao = new CustomerDao();

	public int insertCustomer(int ssn, int id, String name, int age, String address1, String address2, String city,
			String state) {
		return dao.insertCustomer(ssn, id, name, age, address1, address2, city, state);
	}

	// new implementation
	public int insertCustomerObj(int ssn, int id, String name, int age, String address1, String address2, String city,
			String state) {
		int returnCode = 0;

		Customer customer = new Customer();
		customer.setWs_ssn(ssn);
		customer.setWs_cust_id(id);
		customer.setWs_name(name);
		customer.setWs_age(age);
		customer.setWs_adrs(address1 + address2 + city + state);

		return dao.insertCustomerObj(customer);
	}


	public int insertAccount(int ssn, String accType, double depositAmount) {
		return dao.insertAccount(ssn, accType, depositAmount);
	}

	public int deleteUserBySSN(int SSN) {
		return dao.deleteUserBySSN(SSN);
	}

	public int deleteUserByCustId(int custid) {
		return dao.deleteUserByCustId(custid);
	}

	public int deleteAcctByAcctId(int acctId) {
		return dao.deleteAcctByAcctID(acctId);
	}

	public Customer findCustomerBySSN(int ssn) {
		Customer customer = new Customer();
		customer = dao.findCustomerBySSN(ssn);
		return customer;
	}

	public Customer findCustomerByCustId(int custid) {
		Customer customer = new Customer();
		customer = dao.findCustomerByCustId(custid);
		return customer;
	}

	public int updateCustBySSN(int ssn, String name, int age, String address1, String address2, String city,
			String state) {
		return dao.updateCustBySSN(ssn, name, age, address1, address2, city, state);
	}

	public ArrayList<Account> getAllAcctsOfCustById(int custid) {
		return dao.getAllAcctsByCustID(custid);
	}

	public ArrayList<Account> getAllAccounts() {
		return dao.getAllAccounts();
	}

	public ArrayList<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	public int updateCustByCustId(int custid, String name, int age, String address1, String address2, String city,
			String state) {
		return dao.updateCustByCustId(custid, name, age, address1, address2, city, state);
	}

	public Customer findCustomerbyCustId(int custid) {
		return dao.findCustomerbyCustId(custid);
	}

	public User validateLogin(String username, String password) {
		return dao.validateLogin(username, password);
	}

	public Account findAcctByAcctId(int acctid) {
		return dao.findAcctByAcctId(acctid);
	}

	public Account findAcctbyCustId(int custid) {
		return dao.findAccountbyCustId(custid);
	}

	public List<Account> getAcctDetailsByCustId(int custid) {
		return dao.getAcctDetailsByCustId(custid);
	}

}
