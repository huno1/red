package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.Statement;

class writeContent extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		String thid = req.getParameter("thid");
		String username = (String)session.getAttribute("s_id");
		if(username == null){
			username = req.getRemoteAddr();
		}
		String content = req.getParameter("content").replaceAll("\n","<br>");
		String sql = "INSERT INTO content VALUES('"+thid+"', content_seq.nextval,'"+username+"', '"+content+"', default,'')";
		
		stmt.executeUpdate(sql);
	
	}
}