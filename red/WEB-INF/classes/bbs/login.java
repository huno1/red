package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;
import java.sql.Statement;

class login extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		HttpSession session = req.getRequest().getSession();
		
		String userid = req.getUsername();
		String userpw = req.getUserpass();
		String sql = "select user_id from rv_user where user_name='"+userid+"' and user_pass='"+userpw+"'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			session.setAttribute("s_id",userid);
		}else{
			session.setAttribute("message","存在しないＩＤか、パスワードが違います");
		}
		
	}
}