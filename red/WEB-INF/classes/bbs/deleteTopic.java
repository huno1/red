package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class deleteTopic extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		String id = req.getParameter("id");
		
		String sql = "DELETE FROM thread WHERE th_id="+id;
		System.out.println(sql);
		stmt.executeUpdate(sql);
		
		req.setAttribute("message",id+" çÌèúÇ≥ÇÍÇ‹ÇµÇΩÅB");
	
	}
}