package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.Statement;

class newAccount extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		HttpSession session = req.getSession();
		
		String userid = req.getParameter("newID");
		String userpw = req.getParameter("newPW");
		String sql = "select user_id from rv_user where user_name='"+userid+"'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			session.setAttribute("message",userid+" ÇÕä˘Ç…ë∂ç›Ç∑ÇÈÇhÇcÇ≈Ç∑");
		}else{
			sql = "insert into rv_user values(rv_user_seq.nextval, '"+userid+"', '"+userpw+"', default, default)";
			stmt.executeUpdate(sql);
			session.setAttribute("s_id",userid);
		}
	}
}