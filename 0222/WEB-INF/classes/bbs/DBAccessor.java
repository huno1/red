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
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DBAccessor Exception");
		}
	}
	
	public List<Bean> getTopicList(String sql) throws Exception{
		stmt = con.createStatement();
		List<Bean> tlist = new ArrayList<Bean>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Topic t = new Topic(rs.getString(1), rs.getString(2), rs.getString(3).substring(0,rs.getString(3).length()-2), rs.getString(4).substring(0,rs.getString(4).length()-2), rs.getString(5), rs.getString(6));
			tlist.add(t);
		}
		return tlist;
	}
	
	public List<Bean> getContentList(String sql) throws Exception{
		stmt = con.createStatement();
		List<Bean> clist = new ArrayList<Bean>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Content c = new Content(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5).substring(0,rs.getString(5).length()-2), rs.getString(6), rs.getString(7), rs.getString(8));
			clist.add(c);
		}
		
		return clist;
	}
	
	
	public String getString(String sql) throws Exception{
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			return rs.getString(1);
		}else{
			return "";
		}
	}
	
	public int executeUpdate(String sql) throws Exception{
		stmt = con.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	public void commit() throws Exception{
		con.commit();
	}
}
