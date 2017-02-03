package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class Executer {
	
	Statement stmt = null;
	
	public Executer(){
		try{
			DBAccessor dba = new DBAccessor();
			stmt = dba.getStmt();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void execute(HttpServletRequest req) throws Exception{}
	
}
