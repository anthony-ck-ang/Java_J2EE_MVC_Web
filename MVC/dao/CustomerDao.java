package com.tcs.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tcs.abc.bean.Account;
import com.tcs.abc.bean.Customer;
import com.tcs.abc.bean.User;
import com.tcs.abc.util.DBUtil;

public class CustomerDao {

	public int deleteUserSSN(int SSN) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("DELETE FROM Customer_Team_A WHERE WS_SSN = ? ");
			pst.setInt(1, SSN);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;
	}

	public int deleteUserID(int ID) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("DELETE FROM Customer_Team_A WHERE WS_CUST_ID = ? ");
			pst.setInt(1, ID);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;
	}

	public int deleteAccID(int ID) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("DELETE FROM Account_Team_A WHERE WS_ACCT_ID = ? ");
			pst.setInt(1, ID);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;
	}

	public Customer findCustomerBySSN(int updateSelection) {
		Customer temp = null;
		DBUtil util = new DBUtil();

		try {

			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Customer_Team_A where WS_SSN = ?");
			pst.setInt(1, updateSelection);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				temp = new Customer();
				temp.setWs_ssn(rs.getInt(1));
				temp.setWs_cust_id(rs.getInt(2));
				temp.setWs_name(rs.getString(3));
				temp.setWs_adrs(rs.getString(4));
				temp.setWs_age(rs.getInt(5));

			}

			util.closeAll(cn, pst, rs);
		}

		catch (SQLException e)

		{
			System.out.println(e);
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		catch (NullPointerException e) {
			System.out.println(e);
		}
		return temp;

	}

	public ArrayList<Account> getAllCustomer(int SSN) {
		ArrayList<Account> accList = new ArrayList<Account>();

		DBUtil util = new DBUtil();
		try {

			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Account_Team_A where WS_cust_ID = ?");
			pst.setInt(1, SSN);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Account a = new Account();
				a.setWs_cust_id(rs.getInt(1));
				a.setWs_acct_id(rs.getInt(2));
				a.setWs_acct_type(rs.getString(3));
				a.setWs_acct_balance(rs.getDouble(4));
				a.setWs_acct_crdate(rs.getDate(5));
				a.setWs_acct_lasttrdate(rs.getDate(6));
				a.setWs_acct_duration(rs.getInt(7));

				accList.add(a);
				System.out.println(a);

			}

			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return accList;
	}

	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> accList = new ArrayList<Account>();

		DBUtil util = new DBUtil();
		try {

			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Account_Team_A");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Account a = new Account();
				a.setWs_cust_id(rs.getInt(1));
				a.setWs_acct_id(rs.getInt(2));
				a.setWs_acct_type(rs.getString(3));
				a.setWs_acct_balance(rs.getDouble(4));
				a.setWs_acct_crdate(rs.getDate(5));
				a.setWs_acct_lasttrdate(rs.getDate(6));
				a.setWs_acct_duration(rs.getInt(7));
				a.setWs_last_date(rs.getDate(8));

				accList.add(a);

				System.out.println(a);

			}

			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return accList;
	}

	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> custList = new ArrayList<Customer>();

		DBUtil util = new DBUtil();
		try {

			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Customer_Team_A");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Customer c = new Customer();
				c.setWs_ssn(rs.getInt(1));
				c.setWs_cust_id(rs.getInt(2));
				c.setWs_name(rs.getString(3));
				c.setWs_adrs(rs.getString(4));
				c.setWs_age(rs.getInt(5));
				c.setWs_last_date(rs.getDate(7));
				custList.add(c);

				System.out.println(c);

			}

			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return custList;
	}

	public Customer findCustomerByID(int updateSelection) {
		Customer temp = null;
		DBUtil util = new DBUtil();

		try {

			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Customer_Team_A where WS_cust_id = ?");
			pst.setInt(1, updateSelection);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				temp = new Customer();
				temp.setWs_ssn(rs.getInt(1));
				temp.setWs_cust_id(rs.getInt(2));
				temp.setWs_name(rs.getString(3));
				temp.setWs_adrs(rs.getString(4));
				temp.setWs_age(rs.getInt(5));

			}

			util.closeAll(cn, pst, rs);
		}

		catch (SQLException e)

		{
			System.out.println(e);
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		catch (NullPointerException e) {
			System.out.println(e);
		}
		return temp;

	}

	public int updateUserSSN(int SSN) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("UPDATE FROM Customer_Team_A WHERE WS_SSN = ? ");
			pst.setInt(1, SSN);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;
	}

	public int insertUser(int ssn, int id, String name, int age,
			String address1, String address2, String city, String state) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			String address = address1 + ", " + address2 + "," + city + ","
					+ state;

			PreparedStatement pst = cn
					.prepareStatement("insert into Customer_Team_A values(?,?,?,?,?,?,?)");
			pst.setInt(1, ssn);
			pst.setInt(2, id);
			pst.setString(3, name);
			pst.setString(4, address);
			pst.setInt(5, age);
			pst.setString(6, "Customer");
			pst.setDate(7, new java.sql.Date(System.currentTimeMillis()));

			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}

			util.closeAll(cn, pst, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;

	}

	public int insertAccount(int ssn, String accType, double depositAmount) {
		int done = 0;

		int amount = 0;
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();

			PreparedStatement pst1 = cn
					.prepareStatement("select MAX (WS_ACCT_ID) FROM Account_Team_A");
			ResultSet rs1 = pst1.executeQuery();
			while (rs1.next()) {

				amount = rs1.getInt(1);

			}
			amount = amount + 1;
			PreparedStatement pst = cn
					.prepareStatement("insert into Account_Team_A values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, ssn);
			pst.setInt(2, amount);
			pst.setString(3, accType);
			pst.setDouble(4, depositAmount);
			Date todaysDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String testDateString = sdf.format(todaysDate);
			pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			pst.setDate(6, new java.sql.Date(System.currentTimeMillis()));
			// pst.setString(5, "TO_DATE('"+testDateString+"', 'YYYY/MM/DD')");
			// pst.setString(6, "TO_DATE('"+testDateString+"', 'YYYY/MM/DD')");
			pst.setInt(7, 0);
			pst.setDate(8, new java.sql.Date(System.currentTimeMillis()));

			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}

			util.closeAll(cn, pst, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;

	}

	public int updateCustSSN(int value, String name, int age, String address1,
			String address2, String city, String state) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();

			String address = address1 + ", " + address2 + "," + city + ","
					+ state;
			PreparedStatement pst = cn
					.prepareStatement("update Customer_Team_A set ws_name=?, ws_adrs=?, ws_age=?, lastupdated = ? where ws_ssn=?");
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setInt(3, age);
			pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pst.setInt(5, value);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}

			util.closeAll(cn, pst, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;

	}

	public int updateCustID(int value, String name, int age, String address1,
			String address2, String city, String state) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();

			PreparedStatement pst1 = cn
					.prepareStatement("insert into Last_Updated_Team_A values(?,?,?)");
			pst1.setInt(1, value);
			pst1.setInt(2, 0);
			pst1.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			pst1.executeUpdate();

			String address = address1 + ", " + address2 + "," + city + ","
					+ state;
			PreparedStatement pst = cn
					.prepareStatement("update Customer_Team_A set ws_name=?, ws_adrs=?, ws_age=?, lastupdated = ? where ws_cust_id=?");
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setInt(3, age);
			pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pst.setInt(5, value);

			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}

			util.closeAll(cn, pst, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;

	}

	public Customer findCustomer(int ssnid) {
		Customer temp = null;

		try {
			DBUtil db = new DBUtil();
			Connection cn = db.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Customer_Team_A WHERE ws_ssn=?");
			pst.setInt(1, ssnid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				temp = new Customer();
				temp.setWs_ssn(rs.getInt(1));
				temp.setWs_cust_id(rs.getInt(2));
				temp.setWs_name(rs.getString(3));
				temp.setWs_adrs(rs.getString(4));
				temp.setWs_age(rs.getInt(5));

				System.out.println("Customer found!");
				System.out.println(temp);
			}
			db.closeAll(cn, pst, rs);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return temp;
	}

	public Customer findCustomerbyId(int custid) {
		Customer temp = null;

		try {
			DBUtil db1 = new DBUtil();
			Connection cn = db1.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Customer_Team_A WHERE ws_cust_id=?");
			pst.setInt(1, custid);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				temp = new Customer();
				temp.setWs_ssn(rs.getInt(1));
				temp.setWs_cust_id(rs.getInt(2));
				temp.setWs_name(rs.getString(3));
				temp.setWs_adrs(rs.getString(4));
				temp.setWs_age(rs.getInt(5));
				System.out.println("Customer found!");
				System.out.println(temp);
			}

			db1.closeAll(cn, pst, rs);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return temp;
	}

	public User validateLogin(String username, String password) {
		User temp = null;
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();

			PreparedStatement pst2 = cn
					.prepareStatement("UPDATE USERSTORE_TEAM_A SET ETIMESTAMP = ? Where EUSERNAME = ?");
			pst2.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			pst2.setString(2, username);
			pst2.executeUpdate();

			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Userstore_Team_A WHERE eUsername=? AND ePassword=?");
			pst.setString(1, username);
			pst.setString(2, password);

			// PreparedStatement pst2 = cn
			// .prepareStatement("UPDATE USERSTORE_TEAM_A SET ETIMESTAMP = ? Where EUSERNAME = ?");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				temp = new User();
				temp.setUsername(rs.getString("eUsername"));
				temp.setPassword(rs.getString("ePassword"));
				temp.setDesignation(rs.getString("eDesignation"));
				temp.setDate(rs.getDate("eTimestamp"));

			}

			System.out.println(temp);

			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}

	public Account findAccByAcctId(int acctid) {
		Account temp = null;

		try {

			DBUtil db = new DBUtil();
			Connection cn = db.createConnection();

			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Account_Team_A WHERE ws_acct_id=?");

			pst.setInt(1, acctid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				temp = new Account();
				temp.setWs_cust_id(rs.getInt(1));
				temp.setWs_acct_id(rs.getInt(2));
				temp.setWs_acct_type(rs.getString(3));
				temp.setWs_acct_balance(rs.getDouble(4));
				temp.setWs_acct_crdate(rs.getDate(5));
				temp.setWs_acct_lasttrdate(rs.getDate(6));
				temp.setWs_acct_duration(rs.getInt(7));
				System.out.println("Account found!");
				System.out.println(temp);
			}

			db.closeAll(cn, pst, rs);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return temp;
	}

	public Account findAccountbyCustId(int custid) {
		Account temp = null;

		try {
			DBUtil util = new DBUtil();
			Connection cn = util.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Account_Team_A WHERE ws_cust_id=?");
			pst.setInt(1, custid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				temp = new Account();
				temp.setWs_cust_id(rs.getInt(1));
				temp.setWs_acct_id(rs.getInt(2));
				temp.setWs_acct_type(rs.getString(3));
				temp.setWs_acct_balance(rs.getDouble(4));
				temp.setWs_acct_crdate(rs.getDate(5));
				temp.setWs_acct_lasttrdate(rs.getDate(6));
				temp.setWs_acct_duration(rs.getInt(7));
				System.out.println("Account found!");
				System.out.println(temp);
			}

			util.closeAll(cn, pst, rs);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return temp;
	}

	public List<Account> getAccdetails(int custid) {

		ArrayList<Account> aList = new ArrayList<Account>();
		DBUtil db = new DBUtil();
		try {
			Connection cn = db.createConnection();
			PreparedStatement pst = cn
					.prepareStatement("SELECT * FROM Account_Team_A where ws_cust_id=?");
			pst.setInt(1, custid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Account temp = new Account();
				temp.setWs_cust_id(rs.getInt(1));
				temp.setWs_acct_id(rs.getInt(2));
				temp.setWs_acct_type(rs.getString(3));
				temp.setWs_acct_balance(rs.getDouble(4));
				if (aList == null) {
					aList = new ArrayList<Account>();
				}
				aList.add(temp);
				System.out.println(temp);
			}
			db.closeAll(cn, pst, rs);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
		return aList;

	}

}