package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class deleteTopic extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		String thid = req.getThid();
		
		String sql = "DELETE FROM thread WHERE th_id="+thid;
		
		stmt.executeUpdate(sql);
		
		sql = "DELETE FROM content WHERE con_th_id="+thid;
		
		stmt.executeUpdate(sql);
		
		/*req.setAttribute("message",thid+" çÌèúÇ≥ÇÍÇ‹ÇµÇΩÅB"); */
		
		con.commit();
	}
}