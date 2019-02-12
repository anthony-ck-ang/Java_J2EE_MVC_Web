package com.tcs.abc.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.tcs.abc.bean.Account;
import com.tcs.abc.bean.Customer;
import com.tcs.abc.bean.User;
import com.tcs.abc.service.BankService;

public class BankingServiceTest extends TestCase {

	BankService service = new BankService();

	public void testInsertUser() {

		int ssn = 300000005;
		int id = 200000005;
		String name = "testName1";
		int age = 30;
		String address1 = "testAddress1";
		String address2 = "testAddress2";
		String city = "testCity";
		String state = "testState";

		int result = service.insertUser(ssn, id, name, age, address1, address2,
				city, state);

		assertEquals(result, 1);
	}

	public void testInsertAccount() {

		int ssn = 300000006;
		String accType = "accType1";
		double depositAmount = 1000;

		int result = service.insertAccount(ssn, accType, depositAmount);

		assertEquals(result, 1);
	}

	public void testDeleteAccID() {

		int id = 100000006;
		int result = service.deleteAccID(id);

		assertEquals(result, 1);
	}

	public void testDeleteUserSSN() {

		int ssn = 123456789;
		int result = service.deleteUserSSN(ssn);

		assertEquals(result, 1);
	}

	public void testDeleteUserSSN2() {

		int ssn = 123456789;
		int result = service.deleteUserSSN(ssn);

		assertEquals(result, 1);
	}

	public void testDeleteUserID() {

		int id = 222222222;
		int result = service.deleteUserID(id);

		assertEquals(result, 1);
	}

	public void testFindCustomerBySSN() {

		int ssn = 100000001;
		Customer customer = service.findCustomerBySSN(ssn);
		assertNotNull(customer);
	}

	public void testFindCustomerByID() {

		int id = 100000001;
		Customer customer = service.findCustomerByID(id);
		assertNotNull(customer);
	}

	public void testUpdateCustSSN() {

		int value = 100000002; // ssn
		String name = "testName3";
		int age = 30;
		String address1 = "testAddress2";
		String address2 = "testAddress3";
		String city = "testCity1";
		String state = "testState1";

		int result = service.updateCustSSN(value, name, age, address1,
				address2, city, state);

		assertEquals(result, 1);
	}

	public void testGetAllCustomer() {

		int ssn = 100000001;
		ArrayList<Account> accounts = service.getAllCustomer(ssn);
		assertNotNull(accounts);
	}

	public void testGetAllAccounts() {
		ArrayList<Account> account = service.getAllAccounts();
		assertNotNull(account);
	}

	public void testGetAllCustomers() {
		ArrayList<Customer> customers = service.getAllCustomers();
		assertNotNull(customers);
	}

	public void testUpdateCustID() {

		int value = 100000001; // ssn
		String name = "testName2";
		int age = 31;
		String address1 = "testAddress5";
		String address2 = "testAddress6";
		String city = "testCity1";
		String state = "testState1";

		int result = service.updateCustID(value, name, age, address1, address2,
				city, state);

		assertEquals(result, 1);
	}

	public void testFindCustomer() {

		int ssnid = 999999999;
		Customer customers = service.findCustomer(ssnid);
		assertNotNull(customers);
	}

	public void testFindCustomerbyId() {

		int custid = 100000001;
		Customer customers = service.findCustomerbyId(custid);
		assertNotNull(customers);
	}

	public void testValidateLogin() {
		String username = "qwertyui";
		String password = "asdfghjklz";
		User accountExec = service.validateLogin(username, password);
		assertNotNull(accountExec);
	}

	public void testFindAccByAcctId() {
		int acctid = 100000001;
		Account account = service.findAccByAcctId(acctid);
		assertNotNull(account);
	}

	public void testFindAccountByCustId() {
		int custid = 888888888;
		Account account = service.findAccountbyCustId(custid);
		assertNotNull(account);
	}

	public void testGetAccDetails() {
		int custid = 100000001;
		List<Account> accountList = service.getAccdetails(custid);
		assertNotNull(accountList);
	}

}
