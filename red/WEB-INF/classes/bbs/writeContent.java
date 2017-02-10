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
		//â¸çsèàóù
		String content = req.getParameter("content").replaceAll("\n","<br>");
		
		String sql = "INSERT INTO content VALUES('"+thid+"', content_seq"+thid+".nextval,'"+username+"', '"+content+"', default, '', '', '')";
		
		int rs = stmt.executeUpdate(sql);
		if(rs>0){
			sql = "update thread set th_ldate=sysdate where th_id="+thid;
			stmt.executeUpdate(sql);
		}
		con.commit();
	}
}