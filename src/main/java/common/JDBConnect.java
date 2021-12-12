package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			//JDBC 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//DB에 연결
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공(인자생성자 1)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public JDBConnect(ServletContext application) {
		
		String driver = application.getInitParameter("OracleDriver");
		String url = application.getInitParameter("OracleURL");
		String id = application.getInitParameter("OracleId");
		String pwd = application.getInitParameter("OraclePwd");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공(인자생성자 2)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
			
			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
