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

class readContentTitle extends Executer {
	
	public Topic query(ServletRequest req) throws Exception{
		
		String thid = req.getThid();
		
		//ÉXÉåÇÃå©èoÇµóp
		String sql = "SELECT th_id, th_title, th_fdate, th_ldate, count, th_maker FROM thread LEFT JOIN (select con_th_id, count(*) count from content where con_state=1 group by con_th_id) ON (th_id=con_th_id) WHERE th_id = '"+thid+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		Topic topic = new Topic(rs.getString(1), rs.getString(2), rs.getString(3).substring(0,rs.getString(3).length()-2), rs.getString(4).substring(0,rs.getString(4).length()-2), rs.getString(5), rs.getString(6));
		
		rs.close();
		
		return topic;
	}
}