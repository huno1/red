package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class writeTopic extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		String title = req.getParameter("title");
		String sql = "INSERT INTO thread VALUES(thread_seq.nextval,'"+title+"', default, default)";
		
		stmt.executeUpdate(sql);
	
	}
}