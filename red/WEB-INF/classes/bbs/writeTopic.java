package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.Statement;

class writeTopic extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		String title = req.getParameter("title");
		String username = (String)session.getAttribute("s_id");
		if(username == null){
			username = req.getRemoteAddr();
		}
		
		String sql = "SELECT thread_seq.nextval FROM dual";
		
		ResultSet rs=stmt.executeQuery(sql);
		rs.next();
		String thid = rs.getString(1);
		
		sql = "INSERT INTO thread VALUES("+thid+",'"+title+"', default, default, '"+username+"')";
		
		stmt.executeUpdate(sql);
		
		sql = "CREATE SEQUENCE content_seq"+thid;
		
		stmt.executeUpdate(sql);
	
		con.commit();
	}
}