package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import bean.*;

class DBAccessor{
	private Connection con;
	private Statement stmt = null;
	
	public DBAccessor() throws Exception {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
			con.setAutoCommit(false);
			stmt = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DBAccessor Exception");
		}
	}
	/*
	public ArrayList<Topic> getTopicList(String sql){
		List<Topic> tlist = new ArrayList<Topic>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Topic t = new Topic(rs.getString(1), rs.getString(2), rs.getString(3).substring(0,rs.getString(3).length()-2), rs.getString(4).substring(0,rs.getString(4).length()-2), rs.getString(5), rs.getString(6));
			tlist.add(t);
		}
		return tlist;
	}
	
	public int executeUpdate(String sql){
		int result = stmt.executeQuery(sql);
		return result;
	}
	*/
	public Connection getConnection(){
		return con;
	}
	
}
