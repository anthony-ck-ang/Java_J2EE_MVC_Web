package com.anthonyang.abc.bean;

import java.sql.Date;

public class Account {

	int ws_cust_id;
	int ws_acct_id;
	String ws_acct_type;
	double ws_acct_balance;
	Date ws_acct_crdate;
	Date ws_acct_lasttrdate;
	int ws_acct_duration;
	Date ws_last_date;

	public Account(int ws_cust_id, int ws_acct_id, String ws_acct_type, double ws_acct_balance, Date ws_acct_crdate,
			Date ws_acct_lasttrdate, int ws_acct_duration, Date ws_last_date) {
		super();
		this.ws_cust_id = ws_cust_id;
		this.ws_acct_id = ws_acct_id;
		this.ws_acct_type = ws_acct_type;
		this.ws_acct_balance = ws_acct_balance;
		this.ws_acct_crdate = ws_acct_crdate;
		this.ws_acct_lasttrdate = ws_acct_lasttrdate;
		this.ws_acct_duration = ws_acct_duration;
		this.ws_last_date = ws_last_date;
	}

	public Account() {
		super();
	}

	public int getWs_cust_id() {
		return ws_cust_id;
	}

	public void setWs_cust_id(int ws_cust_id) {
		this.ws_cust_id = ws_cust_id;
	}

	public int getWs_acct_id() {
		return ws_acct_id;
	}

	public void setWs_acct_id(int ws_acct_id) {
		this.ws_acct_id = ws_acct_id;
	}

	public String getWs_acct_type() {
		return ws_acct_type;
	}

	public void setWs_acct_type(String ws_acct_type) {
		this.ws_acct_type = ws_acct_type;
	}

	public double getWs_acct_balance() {
		return ws_acct_balance;
	}

	public void setWs_acct_balance(double ws_acct_balance) {
		this.ws_acct_balance = ws_acct_balance;
	}

	public Date getWs_acct_crdate() {
		return ws_acct_crdate;
	}

	public void setWs_acct_crdate(Date ws_acct_crdate) {
		this.ws_acct_crdate = ws_acct_crdate;
	}

	public Date getWs_acct_lasttrdate() {
		return ws_acct_lasttrdate;
	}

	public void setWs_acct_lasttrdate(Date ws_acct_lasttrdate) {
		this.ws_acct_lasttrdate = ws_acct_lasttrdate;
	}

	public int getWs_acct_duration() {
		return ws_acct_duration;
	}

	public void setWs_acct_duration(int ws_acct_duration) {
		this.ws_acct_duration = ws_acct_duration;
	}

	public Date getWs_last_date() {
		return ws_last_date;
	}

	public void setWs_last_date(Date ws_last_date) {
		this.ws_last_date = ws_last_date;
	}

	@Override
	public String toString() {
		return "Account [ws_cust_id=" + ws_cust_id + ", ws_acct_id=" + ws_acct_id + ", ws_acct_type=" + ws_acct_type
				+ ", ws_acct_balance=" + ws_acct_balance + ", ws_acct_crdate=" + ws_acct_crdate
				+ ", ws_acct_lasttrdate=" + ws_acct_lasttrdate + ", ws_acct_duration=" + ws_acct_duration
				+ ", ws_last_date=" + ws_last_date + "]";
	}

}
