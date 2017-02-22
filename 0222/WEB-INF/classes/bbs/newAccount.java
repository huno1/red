package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;

class newAccount extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		HttpSession session = req.getRequest().getSession();
		
		String userid = req.getUsername();
		String userpw = req.getUserpass();
		String sql = "select user_name from rv_user where user_name='"+userid+"'";
		String _id = dba.getString(sql);
		if (userid.equals(_id)) {
			session.setAttribute("message",userid+" ÇÕä˘Ç…ë∂ç›Ç∑ÇÈÇhÇcÇ≈Ç∑");
		}else{
			sql = "insert into rv_user values(rv_user_seq.nextval, '"+userid+"', '"+userpw+"', default, default)";
			dba.executeUpdate(sql);
			session.setAttribute("s_id",userid);
		}
		dba.commit();
	}
}