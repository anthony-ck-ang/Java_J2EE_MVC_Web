package com.tcs.abc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.abc.bean.Account;
import com.tcs.abc.bean.Customer;
import com.tcs.abc.bean.User;
import com.tcs.abc.service.BankService;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BankService service = new BankService();
		String delete = request.getParameter("Delete");
		if (delete != null) {
			String accId1 = request.getParameter("accId");
			int accId = Integer.parseInt(accId1);
			int done = service.deleteAccID(accId);
			if (done == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/DeleteAccountDone.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/CreateCustomerError.jsp");
				rd.forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BankService service = new BankService();
		HttpSession session = request.getSession();

		Account a = null;
		Customer c = null;

		String insert = request.getParameter("Create");
		String deleteCustomer = request.getParameter("DeleteCustomer");
		String createAccount = request.getParameter("CreateAccount");
		String update1 = request.getParameter("Update1");
		String update2 = request.getParameter("Update2");
		String deleteAccount2 = request.getParameter("DeleteAccount2");
		String deleteAccount1 = request.getParameter("DeleteAccount1");
		String login = request.getParameter("Login");

		String listDeleteAccount1 = request.getParameter("ListDeleteAccount");
		String DeleteCustomerLatest = request
				.getParameter("DeleteCustomerLatest");
		String ListAccounts = request.getParameter("ListAccounts");
		String ListCustomers = request.getParameter("ListCustomers");
		if (ListCustomers != null) {
			ArrayList<Customer> custList = service.getAllCustomers();
			request.setAttribute("custList", custList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/CustomerStatus2.jsp");
			rd.forward(request, response);
		}

		else if (ListAccounts != null) {

			ArrayList<Account> accList = service.getAllAccounts();
			request.setAttribute("accList", accList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/AccountStatus2.jsp");
			rd.forward(request, response);

		}

		else if (deleteCustomer != null) {

			String selection2 = request.getParameter("selection2");
			// String age1 = request.getParameter("age");
			// int age = Integer.parseInt(age1);
			// String address1 = request.getParameter("address1");
			// String address2 = request.getParameter("address2");
			// String city = request.getParameter("city");
			// String state = request.getParameter("state");
			String deleteSelection1 = request.getParameter("DeleteSelection");
			int deleteSelection = Integer.parseInt(deleteSelection1);

			if (selection2.equals("SSN")) {
				System.out.println("testSSN" + deleteSelection);

				try {
					Customer customer = service
							.findCustomerBySSN(deleteSelection);
					System.out.println(customer.toString());
					session = request.getSession();
					session.setAttribute("customer", customer);
					System.out.println(customer.toString());

					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/DeleteCustomer2.jsp");
					rd.forward(request, response);

				}

				catch (NullPointerException e) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/UpdateCustomerError.jsp");
					rd.forward(request, response);
				}
			}

			else if (selection2.equals("ID")) {
				try {
					Customer customer = service
							.findCustomerByID(deleteSelection);
					System.out.println(customer.toString());
					session = request.getSession();
					session.setAttribute("customer", customer);
					System.out.println(customer.toString());

					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/DeleteCustomer2.jsp");
					rd.forward(request, response);
				} catch (NullPointerException e) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/UpdateCustomerError.jsp");
					rd.forward(request, response);
				}

			}

		}

		else if (insert != null) {

			String ssn1 = request.getParameter("ssn");
			int ssn = Integer.parseInt(ssn1);
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			String name = request.getParameter("name");
			String age1 = request.getParameter("age");
			int age = Integer.parseInt(age1);
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");

			int done2 = service.insertUser(ssn, id, name, age, address1,
					address2, city, state);

			if (done2 == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/CreateCustomerDone.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/CreateCustomerError.jsp");
				rd.forward(request, response);
			}
		}

		else if (listDeleteAccount1 != null) {
			String id1 = request.getParameter("custid");
			int id = Integer.parseInt(id1);
			ArrayList<Account> custList = service.getAllCustomer(id);
			request.setAttribute("CustList", custList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/JSP/DeleteAccount3.jsp");
			rd.forward(request, response);

		}

		else if (DeleteCustomerLatest != null) {

			String deleteSelection1 = request.getParameter("custid");
			int deleteSelection = Integer.parseInt(deleteSelection1);

			int done = service.deleteUserID(deleteSelection);
			if (done == 1) {
				System.out.println("TEST1");
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/DeleteCustomerDone.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/DeleteCustomerError.jsp");
				rd.forward(request, response);
			}

		}

		else if (deleteAccount2 != null) {

			String deleteSelection1 = request.getParameter("DeleteSelection1");
			int deleteSelection = Integer.parseInt(deleteSelection1);
			String selection4 = request.getParameter("selection4");

			System.out.println("TEST");
			if (selection4.equals("SSN")) {
				int done = service.deleteUserSSN(deleteSelection);
				if (done == 1) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/DeleteCustomerDone.jsp");
					rd.forward(request, response);
				}

				else {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/CreateCustomerError.jsp");
					rd.forward(request, response);
				}
			}

			else if (selection4.equals("ID")) {

				int done = service.deleteUserID(deleteSelection);
				if (done == 1) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/DeleteCustomerDone.jsp");
					rd.forward(request, response);
				}

				else {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/CreateCustomerError.jsp");
					rd.forward(request, response);
				}

			}

		}

		if (createAccount != null) {

			String ssn1 = request.getParameter("ssn");
			int ssn = Integer.parseInt(ssn1);
			String accType = request.getParameter("accType");

			String depositAmount1 = request.getParameter("depositAmount");
			double depositAmount = Double.parseDouble(depositAmount1);

			int done2 = service.insertAccount(ssn, accType, depositAmount);

			if (done2 == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/CreateAccountDone.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/CreateAccountError.jsp");
				rd.forward(request, response);
			}
		}

		else if (update1 != null) {
			String selection3 = request.getParameter("selection3");
			// String age1 = request.getParameter("age");
			// int age = Integer.parseInt(age1);
			// String address1 = request.getParameter("address1");
			// String address2 = request.getParameter("address2");
			// String city = request.getParameter("city");
			// String state = request.getParameter("state");
			String updateSelection1 = request.getParameter("UpdateSelection");
			int updateSelection = Integer.parseInt(updateSelection1);

			if (selection3.equals("SSN")) {
				try {
					Customer customer = service
							.findCustomerBySSN(updateSelection);
					System.out.println(customer.toString());
					session = request.getSession();
					session.setAttribute("customer", customer);
					String str = customer.getWs_adrs();
					String[] addressArray = str.split(",");
					String address1 = addressArray[0];
					String address2 = addressArray[1];
					String city = addressArray[2];
					String state = addressArray[3];
					session.setAttribute("address1", address1);
					session.setAttribute("address2", address2);
					session.setAttribute("city", city);
					session.setAttribute("state", state);
					System.out.println(address1);
					System.out.println(address2);

					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/UpdateCustomer2.jsp");
					rd.forward(request, response);
				}

				catch (NullPointerException e) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/UpdateCustomerError.jsp");
					rd.forward(request, response);
				}

			}

			else if (selection3.equals("ID")) {
				try {
					Customer customer = service
							.findCustomerByID(updateSelection);
					System.out.println(customer.toString());
					session = request.getSession();
					session.setAttribute("customer", customer);
					String str = customer.getWs_adrs();
					String[] addressArray = str.split(",");
					String address1 = addressArray[0];
					String address2 = addressArray[1];
					String city = addressArray[2];
					String state = addressArray[3];
					session.setAttribute("address1", address1);
					session.setAttribute("address2", address2);
					session.setAttribute("city", city);
					session.setAttribute("state", state);
					System.out.println(address1);
					System.out.println(address2);

					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/UpdateCustomer2.jsp");
					rd.forward(request, response);

				} catch (NullPointerException e) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/UpdateCustomerError.jsp");
					rd.forward(request, response);
				}

			}

		}

		else if (deleteAccount1 != null) {
			String selection4 = request.getParameter("selection4");
			// String age1 = request.getParameter("age");
			// int age = Integer.parseInt(age1);
			// String address1 = request.getParameter("address1");
			// String address2 = request.getParameter("address2");
			// String city = request.getParameter("city");
			// String state = request.getParameter("state");
			String deleteSelection1 = request.getParameter("DeleteSelection1");
			int deleteSelection = Integer.parseInt(deleteSelection1);

			if (selection4.equals("SSN"))

			{
				try {

					System.out.println("testSSN" + deleteSelection);
					Customer customer = service
							.findCustomerBySSN(deleteSelection);
					System.out.println(customer.toString());
					session = request.getSession();
					session.setAttribute("customer", customer);
					System.out.println(customer.toString());

					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/DeleteAccount2.jsp");
					rd.forward(request, response);
				}

				catch (NullPointerException e) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/UpdateCustomerError.jsp");
					rd.forward(request, response);
				}
			}

			else if (selection4.equals("ID")) {

				try {
					Customer customer = service
							.findCustomerByID(deleteSelection);
					System.out.println(customer.toString());
					session = request.getSession();
					session.setAttribute("customer", customer);
					System.out.println(customer.toString());

					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/DeleteAccount2.jsp");
					rd.forward(request, response);

				} catch (NullPointerException e) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(
									"/JSP/UpdateCustomerError.jsp");
					rd.forward(request, response);
				}

			}

		}

		else if (update2 != null) {
			System.out.println("TESTAG");
			String name = request.getParameter("name");
			String age1 = request.getParameter("age");
			int age = Integer.parseInt(age1);
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String type = request.getParameter("type");
			String value1 = request.getParameter("ssncust");

			int value = Integer.parseInt(value1);

			System.out.println("SSN" + value);
			int done = service.updateCustSSN(value, name, age, address1,
					address2, city, state);
			System.out.println("ssn");
			if (done == 1) {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/UpdateCustomerDone.jsp");
				rd.forward(request, response);
			}

			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/CreateCustomerError.jsp");
				rd.forward(request, response);
			}

		} else if (login != null) {
			// session.invalidate();
			String username = request.getParameter("uName");
			String password = request.getParameter("uPass");
			User user = service.validateLogin(username, password);
			if (user != null) {

				System.out.println("TEST1");
				if (user.getDesignation().equals("AccExecutive")) {
					session = request.getSession();
					session.setAttribute("LoginAccExec", user);
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/CustomerExec.jsp");
					rd.forward(request, response);

				} else if (user.getDesignation().equals("Cashier")) {
					session = request.getSession();
					session.setAttribute("LoginCashier", user);
					String url = "/JSP/CashierTelMain.jsp";
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher(url);
					rd.forward(request, response);
				}
			} else {
				System.out.println("TEST2");
				String url = "/JSP/LoginFailure.jsp";
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
			}

		}

		else if (request.getParameter("submitChoice2") != null) {

			// int t = Integer.parseInt(request.getParameter("input2"));
			// c = service.findCustomer(ssnid);

			String t21 = request.getParameter("t2");

			if (t21.equals("Customer Id")) {
				session.setAttribute("choicemade1", t21);

				int t = Integer.parseInt(request.getParameter("input2"));
				c = service.findCustomerbyId(t);

				if (c != null) {
					session.setAttribute("name", c.getWs_name());
					session.setAttribute("address", c.getWs_adrs());
					session.setAttribute("age", c.getWs_age());
					session.setAttribute("custid", c.getWs_cust_id());
					session.setAttribute("ssn", c.getWs_ssn());

				}
				if (c != null) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/CustomerDetails.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
					rd.forward(request, response);
				}
			}

			else if (t21.equals("SSNID")) {

				session.setAttribute("choicemade1", t21);

				int ssnid = Integer.parseInt(request.getParameter("input2"));
				c = service.findCustomer(ssnid);

				if (c != null) {
					session.setAttribute("name", c.getWs_name());
					session.setAttribute("address", c.getWs_adrs());
					session.setAttribute("age", c.getWs_age());
					session.setAttribute("custid", c.getWs_cust_id());
					session.setAttribute("ssn", c.getWs_ssn());
				}

				if (c != null) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/CustomerDetails.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
					rd.forward(request, response);
				}

			}

			else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
				rd.forward(request, response);
			}

		}

		else if (request.getParameter("submitChoice") != null) {

			int t = Integer.parseInt(request.getParameter("input"));
			String t1 = request.getParameter("t1");

			if (t1.equals("Account Id")) {

				session.setAttribute("choicemade1", t1);

				a = service.findAccByAcctId(t);

				if (a != null) {

					if (a.getWs_acct_type().equalsIgnoreCase("s")) {
						a.setWs_acct_type("Savings");
					} else {
						a.setWs_acct_type("Current");
					}

					session.setAttribute("custid", a.getWs_cust_id());
					session.setAttribute("acctid", a.getWs_acct_id());
					session.setAttribute("acctType", a.getWs_acct_type());
					session.setAttribute("acctBal", a.getWs_acct_balance());

				}
				if (a != null) {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/ViewAcctDetails.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
					rd.forward(request, response);
				}

			} else if (t1.equals("Customer Id")) {
				session.setAttribute("choicemade1", t1);

				c = service.findCustomerbyId(t);

				if (c != null) {
					int cTempCustId = c.getWs_cust_id();
					a = service.findAccountbyCustId(cTempCustId);

					if (a != null) {

						if (a.getWs_acct_type().equalsIgnoreCase("s")) {
							a.setWs_acct_type("Savings");
						} else {
							a.setWs_acct_type("Current");
						}

						session.setAttribute("custid", a.getWs_cust_id());
						session.setAttribute("acctid", a.getWs_acct_id());
						session.setAttribute("acctType", a.getWs_acct_type());
						session.setAttribute("acctBal", a.getWs_acct_balance());

						List<Account> acclisttemp = service.getAccdetails(t);
						request.setAttribute("acclist", acclisttemp);
						RequestDispatcher rd = getServletContext()
								.getRequestDispatcher("/JSP/DropDown.jsp");
						rd.forward(request, response);

					} else {
						// if a == null, execute bottom

						RequestDispatcher rd = getServletContext()
								.getRequestDispatcher("/JSP/SSNIdNotFound3.jsp");
						rd.forward(request, response);
					}
				} else {
					// if c == null, execute bottom
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
					rd.forward(request, response);
				}

			}

			else if (t1.equals("SSN ID")) {

				session.setAttribute("choicemade1", t1);

				int ssnid = Integer.parseInt(request.getParameter("input"));
				c = service.findCustomer(ssnid);

				if (c != null) {
					int cTempCustId = c.getWs_cust_id();
					a = service.findAccountbyCustId(cTempCustId);

					if (a != null) {

						if (a.getWs_acct_type().equalsIgnoreCase("s")) {
							a.setWs_acct_type("Savings");
						} else {
							a.setWs_acct_type("Current");
						}

						session.setAttribute("custid", a.getWs_cust_id());
						session.setAttribute("acctid", a.getWs_acct_id());
						session.setAttribute("acctType", a.getWs_acct_type());
						session.setAttribute("acctBal", a.getWs_acct_balance());
						List<Account> acclisttemp = service
								.getAccdetails(cTempCustId);
						request.setAttribute("acclist", acclisttemp);
						RequestDispatcher rd = getServletContext()
								.getRequestDispatcher("/JSP/DropDown.jsp");
						rd.forward(request, response);
					}

					else {
						// if a == null, execute bottom

						RequestDispatcher rd = getServletContext()
								.getRequestDispatcher("/JSP/SSNIdNotFound3.jsp");
						rd.forward(request, response);
					}
				} else {
					// if c == null, execute bottom
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
					rd.forward(request, response);
				}

			}

		}// END OF SUBMIT CHOICE
		else if (request.getParameter("submitAccountId") != null) {
			int acc = Integer.parseInt(request.getParameter("Accounts"));

			Account b = new Account();

			b = service.findAccByAcctId(acc);

			if (b != null) {
				String bType = b.getWs_acct_type();

				if (bType.equalsIgnoreCase("s")) {
					b.setWs_acct_type("Savings");
				} else {
					b.setWs_acct_type("Current");
				}

				session.setAttribute("custid", b.getWs_cust_id());
				session.setAttribute("acctid", b.getWs_acct_id());
				session.setAttribute("acctType", b.getWs_acct_type());
				session.setAttribute("acctBal", b.getWs_acct_balance());
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/ViewAcctDetails.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/JSP/SSNIdNotFound2.jsp");
				rd.forward(request, response);
			}

		}

	}

}
