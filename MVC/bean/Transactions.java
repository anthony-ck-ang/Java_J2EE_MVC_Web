package com.tcs.abc.bean;

import java.sql.Date;

public class Transactions {

	int ws_cust_id;
	String ws_acct_type;
	double ws_amt;
	Date ws_trxn_date;
	String ws_src_typ;
	public Transactions(int ws_cust_id, String ws_acct_type, double ws_amt,
			Date ws_trxn_date, String ws_src_typ) {
		super();
		this.ws_cust_id = ws_cust_id;
		this.ws_acct_type = ws_acct_type;
		this.ws_amt = ws_amt;
		this.ws_trxn_date = ws_trxn_date;
		this.ws_src_typ = ws_src_typ;
	}
	public int getWs_cust_id() {
		return ws_cust_id;
	}
	public void setWs_cust_id(int ws_cust_id) {
		this.ws_cust_id = ws_cust_id;
	}
	public String getWs_acct_type() {
		return ws_acct_type;
	}
	public void setWs_acct_type(String ws_acct_type) {
		this.ws_acct_type = ws_acct_type;
	}
	public double getWs_amt() {
		return ws_amt;
	}
	public void setWs_amt(double ws_amt) {
		this.ws_amt = ws_amt;
	}
	public Date getWs_trxn_date() {
		return ws_trxn_date;
	}
	public void setWs_trxn_date(Date ws_trxn_date) {
		this.ws_trxn_date = ws_trxn_date;
	}
	public String getWs_src_typ() {
		return ws_src_typ;
	}
	public void setWs_src_typ(String ws_src_typ) {
		this.ws_src_typ = ws_src_typ;
	}
	public Transactions() {
		super();
	}
	@Override
	public String toString() {
		return "Transactions [ws_cust_id=" + ws_cust_id + ", ws_acct_type="
				+ ws_acct_type + ", ws_amt=" + ws_amt + ", ws_trxn_date="
				+ ws_trxn_date + ", ws_src_typ=" + ws_src_typ + "]";
	}
	
	

	
	
}
