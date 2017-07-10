
package com.anthonyang.abc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public Connection createConnection() throws SQLException, ClassNotFoundException {
		Connection cn=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");	//HostName or TCP/IP address
		cn=DriverManager.getConnection("jdbc:oracle:thin:@host:port:databaseName", "username", "password");
		return cn;
	}
	
	public void closeAll(Connection cn, Statement pst, ResultSet rs)  throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(pst!=null) {
			pst.close();
		}
		if(cn!=null) {
			cn.close();
		}
	}
}

