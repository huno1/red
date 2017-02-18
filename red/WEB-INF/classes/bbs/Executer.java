package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;
import java.sql.Connection;

import java.util.List;
import bean.*;

class Executer {
	
	Connection con;
	Statement stmt;
	
	public Executer(){
		try{
			DBAccessor dba = new DBAccessor();
			con = dba.getConnection();
			stmt = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//オーバーライド専用
	public void execute(ServletRequest req) throws Exception{}
	public List query(ServletRequest req) throws Exception{return null;}
	
}
