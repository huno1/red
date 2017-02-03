package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class deleteContent extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		String cid = req.getParameter("cid");
		
		String sql = "DELETE FROM content WHERE con_id="+cid;
		System.out.println(sql);
		stmt.executeUpdate(sql);
		
		req.setAttribute("message",cid+" çÌèúÇ≥ÇÍÇ‹ÇµÇΩÅB");
	
	}
}