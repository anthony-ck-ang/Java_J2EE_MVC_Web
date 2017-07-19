
package com.anthonyang.abc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		Connection cn=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@10.103.13.85:1521:XE", "ilp_sgp", "Tata!123");
		return cn;
	}
	
	public static void closeAll(Connection cn, Statement pst, ResultSet rs)  throws SQLException {
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
