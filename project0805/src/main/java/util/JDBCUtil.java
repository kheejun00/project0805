package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "mysql");
		} catch (SQLException|ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public static void close(PreparedStatement pstmt, Connection con) {
		try {
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
