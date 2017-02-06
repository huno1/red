package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class writeTopic extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		String title = req.getParameter("title");
		String username = (String)session.getAttribute("s_id");
		if(username == null){
			username = req.getRemoteAddr();
		}
		
		String sql = "INSERT INTO thread VALUES(thread_seq.nextval,'"+title+"', default, default, '"+username+"')";
		
		stmt.executeUpdate(sql);
	
	}
}