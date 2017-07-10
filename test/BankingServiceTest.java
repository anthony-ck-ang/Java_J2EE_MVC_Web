package com.anthonyang.abc.test;

import com.anthonyang.abc.service.BankService;

import junit.framework.TestCase;

public class BankingServiceTest extends TestCase {

	BankService service = BankService.getInstance();;

	public void testInsertUser() {

		int ssn = 300000005;
		int id = 200000005;
		String name = "testName1";
		int age = 30;
		String address1 = "testAddress1";
		String address2 = "testAddress2";
		String city = "testCity";
		String state = "testState";

		assertEquals(service.insertUser(ssn, id, name, age, address1, address2, city, state), 1);
	}

	public void testInsertAccount() {

		int ssn = 300000006;
		String accType = "accType1";
		double depositAmount = 1000;

		int result = service.insertAccount(ssn, accType, depositAmount);

		assertEquals(result, 1);
	}

	public void testDeleteAcctByAcctID() {
		assertEquals(service.deleteAcctByAcctId(100000006), 1);
	}

	public void testDeleteUserBySSN() {
		assertEquals(service.deleteUserBySSN(123456789), 1);
	}

	public void testDeleteUserByCustId() {
		assertEquals(service.deleteUserByCustId(222222222), 1);
	}

	public void testFindCustomerBySSN() {
		assertNotNull(service.findCustomerBySSN(100000001));
	}

	public void testFindCustomerByCustId() {
		assertNotNull(service.findCustomerByCustId(100000001));
	}

	public void testUpdateCustBySSN() {
		int ssn = 100000002;
		String name = "testName3";
		int age = 30;
		String address1 = "testAddress2";
		String address2 = "testAddress3";
		String city = "testCity1";
		String state = "testState1";

		assertEquals(service.updateCustBySSN(ssn, name, age, address1, address2, city, state), 1);
	}

	public void testGetAllAcctsOfCustByID() {
		assertNotNull(service.getAllAcctsOfCustById(100000001));
	}

	public void testGetAllAccounts() {
		assertNotNull(service.getAllAccounts());
	}

	public void testGetAllCustomers() {
		assertNotNull(service.getAllCustomers());
	}

	public void testUpdateCustByID() {

		int id = 100000001;
		String name = "testName2";
		int age = 31;
		String address1 = "testAddress5";
		String address2 = "testAddress6";
		String city = "testCity1";
		String state = "testState1";

		assertEquals(service.updateCustByCustId(id, name, age, address1, address2, city, state), 1);
	}

	public void testFindCustomerbyCustId() {
		assertNotNull(service.findCustomerbyCustId(100000001));
	}

	public void testValidateLogin() {
		assertNotNull(service.validateLogin("qwertyui", "asdfghjklz"));
	}

	public void testFindAcctById() {
		assertNotNull(service.findAcctByAcctId(100000001));
	}

	public void testFindAccountByCustId() {
		assertNotNull(service.findAcctbyCustId(888888888));
	}

	public void testGetAcctDetailsByCustId() {
		assertNotNull(service.getAcctDetailsByCustId(100000001));
	}

}
