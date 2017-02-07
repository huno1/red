package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBAccessor{
	private Statement stmt;
	
	public DBAccessor() throws Exception {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
			stmt = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DBAccessor Exception");
		}
	}
	
	//Executer���Q�b�g���Ďg����悤�ɂ���
	public Statement getStmt(){
		return stmt;
	}
	
}
