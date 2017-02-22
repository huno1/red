package bbs;

import javax.servlet.http.HttpSession;

import java.sql.Statement;

class logout extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		HttpSession session = req.getRequest().getSession();
		
		session.removeAttribute("s_id"); 
	}
}