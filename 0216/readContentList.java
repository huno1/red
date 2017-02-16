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
		
		//レスの収取
		List<Content> clist = new ArrayList<Content>();
		String sql = "SELECT con_th_id, con_id, con_user_name, con_content, con_date, con_parent_id, con_deleted, con_file FROM content WHERE con_th_id = '"+thid+"' AND con_state=1 ORDER BY con_date DESC";
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Content c = new Content(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5).substring(0,rs.getString(5).length()-2), rs.getString(6), rs.getString(7), rs.getString(8));
			clist.add(c);
		}
		req.setAttribute("contentlist",clist);
		
		//スレの見出し用
		sql = "SELECT th_id, th_title, th_fdate, th_ldate, count, th_maker FROM thread LEFT JOIN (select con_th_id, count(*) count from content where con_state=1 group by con_th_id) ON (th_id=con_th_id) WHERE th_id = '"+thid+"'";
		
		rs = stmt.executeQuery(sql);
		rs.next();
		Topic topic = new Topic(rs.getString(1), rs.getString(2), rs.getString(3).substring(0,rs.getString(3).length()-2), rs.getString(4).substring(0,rs.getString(4).length()-2), rs.getString(5), rs.getString(6));
		
		req.setAttribute("topic", topic);
		
		rs.close();
	}
}