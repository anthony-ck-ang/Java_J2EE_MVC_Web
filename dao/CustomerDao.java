package com.anthonyang.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anthonyang.abc.bean.Account;
import com.anthonyang.abc.bean.Customer;
import com.anthonyang.abc.bean.User;
import com.anthonyang.abc.util.DBUtil;

public class CustomerDao {
	
	// new implementation
	public int insertCustomerObj(Customer customer){
		int done = 0;

		Connection cn = null;
		PreparedStatement pst = null;

		/*
		 * finally block can be replaced with try with resources implementation
		 * -> ensures that each resource is closed at the end of the statement
		 */
		
		try {
			cn = DBUtil.createConnection();

			pst = cn.prepareStatement("insert into Customer_Team_A values(?,?,?,?,?,?,?)");
			pst.setInt(1, customer.getWs_ssn());
			pst.setInt(2, customer.getWs_cust_id());
			pst.setString(3, customer.getWs_name());
			pst.setString(4, customer.getWs_adrs());
			pst.setInt(5, customer.getWs_age());
			pst.setString(6, "Customer");
			pst.setDate(7, new java.sql.Date(System.currentTimeMillis()));

			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}

		} catch (SQLException e) {
			// will implement logger eg: log4j
			// logger.error(“SQLException while interacting with DB”);
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// logger.error(“ClassNotFoundException while interacting with DB”);
			throw new RuntimeException(e);
		} finally {
			try {
				DBUtil.closeAll(cn, pst, null);
			} catch (SQLException e) {
				// will implement logger
				// logger.error(“SQLException while interacting with DB”);
				throw new RuntimeException(e);
			}
		}
		return done;
	}

	public int deleteUserBySSN(int SSN) {
		int returnCode = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("DELETE FROM Customer_Team_A WHERE WS_SSN = ? ");
			pst.setInt(1, SSN);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				returnCode = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return returnCode;
	}

	public int deleteUserByCustId(int custid) {
		int returnCode = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("DELETE FROM Customer_Team_A WHERE WS_CUST_ID = ? ");
			pst.setInt(1, custid);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				returnCode = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return returnCode;
	}

	public int deleteAcctByAcctID(int acctid) {
		int returnCode = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("DELETE FROM Account_Team_A WHERE WS_ACCT_ID = ? ");
			pst.setInt(1, acctid);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				returnCode = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return returnCode;
	}

	public Customer findCustomerBySSN(int ssn) {
		Customer cust = new Customer();
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Customer_Team_A where WS_SSN = ?");
			pst.setInt(1, ssn);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cust.setWs_ssn(rs.getInt(1));
				cust.setWs_cust_id(rs.getInt(2));
				cust.setWs_name(rs.getString(3));
				cust.setWs_adrs(rs.getString(4));
				cust.setWs_age(rs.getInt(5));
			}

			util.closeAll(cn, pst, rs);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		return cust;

	}

	public ArrayList<Account> getAllAcctsByCustID(int custid) {
		ArrayList<Account> acctList = new ArrayList<Account>();

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Account_Team_A where WS_cust_ID = ?");
			pst.setInt(1, custid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Account acct = new Account();
				acct.setWs_cust_id(rs.getInt(1));
				acct.setWs_acct_id(rs.getInt(2));
				acct.setWs_acct_type(rs.getString(3));
				acct.setWs_acct_balance(rs.getDouble(4));
				acct.setWs_acct_crdate(rs.getDate(5));
				acct.setWs_acct_lasttrdate(rs.getDate(6));
				acct.setWs_acct_duration(rs.getInt(7));

				acctList.add(acct);
			}

			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return acctList;
	}

	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> acctList = new ArrayList<Account>();
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Account_Team_A");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Account acct = new Account();
				acct.setWs_cust_id(rs.getInt(1));
				acct.setWs_acct_id(rs.getInt(2));
				acct.setWs_acct_type(rs.getString(3));
				acct.setWs_acct_balance(rs.getDouble(4));
				acct.setWs_acct_crdate(rs.getDate(5));
				acct.setWs_acct_lasttrdate(rs.getDate(6));
				acct.setWs_acct_duration(rs.getInt(7));
				acct.setWs_last_date(rs.getDate(8));

				acctList.add(acct);

			}
			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return acctList;
	}

	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Customer_Team_A");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Customer cust = new Customer();
				cust.setWs_ssn(rs.getInt(1));
				cust.setWs_cust_id(rs.getInt(2));
				cust.setWs_name(rs.getString(3));
				cust.setWs_adrs(rs.getString(4));
				cust.setWs_age(rs.getInt(5));
				cust.setWs_last_date(rs.getDate(7));

				custList.add(cust);
			}
			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return custList;
	}

	public Customer findCustomerByCustId(int custid) {
		Customer cust = new Customer();
		DBUtil util = new DBUtil();

		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Customer_Team_A where WS_cust_id = ?");
			pst.setInt(1, custid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cust.setWs_ssn(rs.getInt(1));
				cust.setWs_cust_id(rs.getInt(2));
				cust.setWs_name(rs.getString(3));
				cust.setWs_adrs(rs.getString(4));
				cust.setWs_age(rs.getInt(5));
			}
			util.closeAll(cn, pst, rs);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		return cust;
	}

	public int updateUserSSN(int SSN) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("UPDATE FROM Customer_Team_A WHERE WS_SSN = ? ");
			pst.setInt(1, SSN);
			int rs = pst.executeUpdate();

			if (rs > 0) {
				done = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;
	}

	public int insertUser(int ssn, int id, String name, int age, String address1, String address2, String city,
			String state) {
		int done = 0;

		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			String address = address1 + ", " + address2 + "," + city + "," + state;

			PreparedStatement pst = cn.prepareStatement("insert into Customer_Team_A values(?,?,?,?,?,?,?)");
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
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;

	}

	public int insertAccount(int ssn, String accType, double depositAmount) {
		int done = 0;
		int acctID = 0;
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			// get the last/largest acct id
			PreparedStatement pst1 = cn.prepareStatement("select MAX (WS_ACCT_ID) FROM Account_Team_A");
			ResultSet rs1 = pst1.executeQuery();
			while (rs1.next()) {
				acctID = rs1.getInt(1);
			}
			acctID = acctID++;
			PreparedStatement pst = cn.prepareStatement("insert into Account_Team_A values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, ssn);
			pst.setInt(2, acctID);
			pst.setString(3, accType);
			pst.setDouble(4, depositAmount);
			// Date todaysDate = new Date();
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// String testDateString = sdf.format(todaysDate);
			pst.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			pst.setDate(6, new java.sql.Date(System.currentTimeMillis()));
			// pst.setString(5, "TO_DATE('"+testDateString+"', 'YYYY/MM/DD')");
			// pst.setString(6, "TO_DATE('"+testDateString+"', 'YYYY/MM/DD')");
			pst.setInt(7, 0);
			// pst.setDate(8, new java.sql.Date(System.currentTimeMillis()));

			int rs = pst.executeUpdate();
			if (rs > 0) {
				done = 1;
			}
			util.closeAll(cn, pst, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return done;

	}

	public int updateCustBySSN(int ssn, String name, int age, String address1, String address2, String city,
			String state) {
		int returnCode = 0;
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();
			String address = address1 + ", " + address2 + "," + city + "," + state;

			PreparedStatement pst = cn.prepareStatement(
					"update Customer_Team_A set ws_name=?, ws_adrs=?, ws_age=?, lastupdated = ? where ws_ssn=?");

			pst.setString(1, name);
			pst.setString(2, address);
			pst.setInt(3, age);
			pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pst.setInt(5, ssn);

			int rs = pst.executeUpdate();

			if (rs > 0) {
				returnCode = 1;
			}
			util.closeAll(cn, pst, null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return returnCode;
	}

	public int updateCustByCustId(int custid, String name, int age, String address1, String address2, String city,
			String state) {
		int returnCode = 0;
		DBUtil util = new DBUtil();
		try {
			Connection cn = util.createConnection();

			String address = address1 + ", " + address2 + "," + city + "," + state;
			PreparedStatement pst = cn.prepareStatement(
					"update Customer_Team_A set ws_name=?, ws_adrs=?, ws_age=?, lastupdated = ? where ws_cust_id=?");
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setInt(3, age);
			pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pst.setInt(5, custid);

			int rs = pst.executeUpdate();
			
//			PreparedStatement pst1 = cn.prepareStatement("insert into Last_Updated_Team_A values(?,?,?)");
//			pst1.setInt(1, custid);
//			pst1.setInt(2, 0);
//			pst1.setDate(3, new java.sql.Date(System.currentTimeMillis()));
//			pst1.executeUpdate();
			
			if (rs > 0) {
				returnCode = 1;
			}

			util.closeAll(cn, pst, null);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return returnCode;
	}

	public Customer findCustomerbyCustId(int custid) {
		Customer cust = new Customer();

		try {
			DBUtil util = new DBUtil();
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Customer_Team_A WHERE ws_cust_id=?");
			pst.setInt(1, custid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cust.setWs_ssn(rs.getInt(1));
				cust.setWs_cust_id(rs.getInt(2));
				cust.setWs_name(rs.getString(3));
				cust.setWs_adrs(rs.getString(4));
				cust.setWs_age(rs.getInt(5));

				System.out.println("Customer found!");
				System.out.println(cust);
			}
			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return cust;
	}

	public User validateLogin(String username, String password) {
		User user = new User();
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

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user.setUsername(rs.getString("eUsername"));
				user.setPassword(rs.getString("ePassword"));
				user.setDesignation(rs.getString("eDesignation"));
				user.setDate(rs.getDate("eTimestamp"));
			}
			System.out.println(user);

			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public Account findAcctByAcctId(int acctid) {
		Account acct = new Account();
		try {

			DBUtil db = new DBUtil();
			Connection cn = db.createConnection();

			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Account_Team_A WHERE ws_acct_id=?");
			pst.setInt(1, acctid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				acct.setWs_cust_id(rs.getInt(1));
				acct.setWs_acct_id(rs.getInt(2));
				acct.setWs_acct_type(rs.getString(3));
				acct.setWs_acct_balance(rs.getDouble(4));
				acct.setWs_acct_crdate(rs.getDate(5));
				acct.setWs_acct_lasttrdate(rs.getDate(6));
				acct.setWs_acct_duration(rs.getInt(7));
				System.out.println("Account found!");
				System.out.println(acct);
			}
			db.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return acct;
	}

	public Account findAccountbyCustId(int custid) {
		Account acct = new Account();

		try {
			DBUtil util = new DBUtil();
			Connection cn = util.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Account_Team_A WHERE ws_cust_id=?");
			pst.setInt(1, custid);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				acct.setWs_cust_id(rs.getInt(1));
				acct.setWs_acct_id(rs.getInt(2));
				acct.setWs_acct_type(rs.getString(3));
				acct.setWs_acct_balance(rs.getDouble(4));
				acct.setWs_acct_crdate(rs.getDate(5));
				acct.setWs_acct_lasttrdate(rs.getDate(6));
				acct.setWs_acct_duration(rs.getInt(7));
				System.out.println("Account found!");
				System.out.println(acct);
			}
			util.closeAll(cn, pst, rs);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return acct;
	}

	public List<Account> getAcctDetailsByCustId(int custid) {
		ArrayList<Account> list = new ArrayList<Account>();
		DBUtil db = new DBUtil();
		try {
			Connection cn = db.createConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM Account_Team_A where ws_cust_id=?");
			pst.setInt(1, custid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Account acct = new Account();
				acct.setWs_cust_id(rs.getInt(1));
				acct.setWs_acct_id(rs.getInt(2));
				acct.setWs_acct_type(rs.getString(3));
				acct.setWs_acct_balance(rs.getDouble(4));
//				if (list == null) {
//					list = new ArrayList<Account>();
//				}
				list.add(acct);
				System.out.println(acct);
			}
			db.closeAll(cn, pst, rs);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
