package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.Statement;

class writeTopic extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		HttpServletRequest servletReq = req.getRequest();
		HttpSession session = servletReq.getSession();
		
		String title = req.getTitle();
		String username = (String)session.getAttribute("s_id");
		if(username == null){
			username = servletReq.getRemoteAddr();
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