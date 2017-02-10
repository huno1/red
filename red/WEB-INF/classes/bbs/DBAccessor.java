package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBAccessor{
	private Connection con;
	
	public DBAccessor() throws Exception {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
			con.setAutoCommit(false);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DBAccessor Exception");
		}
	}
	
	//Executer‚ªƒQƒbƒg‚µ‚ÄŽg‚¦‚é‚æ‚¤‚É‚·‚é
	public Connection getConnection(){
		return con;
	}
	
}
