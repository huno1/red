package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
		
		String thid = dba.getString(sql);
		
		sql = "INSERT INTO thread VALUES("+thid+",'"+title+"', default, default, '"+username+"')";
		
		dba.executeUpdate(sql);
		
		sql = "CREATE SEQUENCE content_seq"+thid;
		
		dba.executeUpdate(sql);
	
		dba.commit();
	}
}