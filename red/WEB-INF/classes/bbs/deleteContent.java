package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class deleteContent extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		String cid = req.getParameter("cid");
		String thid = req.getParameter("thid");
		
		String sql = "DELETE FROM content WHERE con_th_id="+thid+" and con_id="+cid;
		
		stmt.executeUpdate(sql);
		
		req.setAttribute("message",cid+" çÌèúÇ≥ÇÍÇ‹ÇµÇΩÅB");
	
		con.commit();
	}
}