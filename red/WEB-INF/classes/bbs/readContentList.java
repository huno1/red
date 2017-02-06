package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.Topic;
import bean.Content;

class readContentList extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		String thid = req.getParameter("topic");
		
		List<Content> clist = new ArrayList<Content>();
		String sql = "SELECT con_th_id, con_id, con_user_name, con_content, con_date, con_parent_id FROM content WHERE con_th_id = '"+thid+"' ORDER BY con_date DESC";
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Content c = new Content(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			clist.add(c);
		}
		req.setAttribute("contentlist",clist);
		
		sql = "SELECT th_id, th_title, th_fdate, th_ldate, count, th_maker FROM thread LEFT JOIN (select con_th_id, count(*) count from content group by con_th_id) ON (th_id=con_th_id) WHERE th_id = '"+thid+"'";
		
		rs = stmt.executeQuery(sql);
		rs.next();
		Topic topic = new Topic(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		
		req.setAttribute("topic", topic);
		
		rs.close();
	}
}