package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.Statement;


class writeContent extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		String thid = req.getParameter("thid");
		String username = (String)session.getAttribute("s_id");
		
		String sql = "SELECT COUNT(*) FROM content GROUP BY con_th_id WHERE con_th_id = " + thid;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String conid = rs.getString(1) + 1;
		
		if(username == null){
			username = req.getRemoteAddr();
		}
		//â¸çsèàóù
		String content = req.getParameter("content").replaceAll("\n","<br>");
<<<<<<< HEAD
		sql = "INSERT INTO content VALUES('"+thid+"', '" + conid + "', '" + username+"', '"+content+"', default,'', default)";
		
		stmt.executeUpdate(sql);
=======
		
		String sql = "INSERT INTO content VALUES('"+thid+"', content_seq"+thid+".nextval,'"+username+"', '"+content+"', default, '', '', '')";
		
		int rs = stmt.executeUpdate(sql);
		if(rs>0){
			sql = "update thread set th_ldate=sysdate where th_id="+thid;
			stmt.executeUpdate(sql);
		}
		con.commit();
>>>>>>> 5a2823ae77b5a20553e6132e2551015a5a4fccf6
	}
}