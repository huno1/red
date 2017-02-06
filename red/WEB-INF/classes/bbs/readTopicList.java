package bbs;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.Topic;

class readTopicList extends Executer {
	
	public void execute(HttpServletRequest req) throws Exception{
		
		String thid = req.getParameter("topic");
		
		List<Topic> tlist = new ArrayList<Topic>();
		String sql = "SELECT th_id, th_title, th_fdate, th_ldate, count, th_maker FROM thread LEFT JOIN (select con_th_id, count(*) count from content group by con_th_id) ON (th_id=con_th_id) ORDER BY th_ldate DESC";
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Topic t = new Topic(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			tlist.add(t);
		}
		rs.close();
		
		req.setAttribute("threadlist",tlist);
		
	}
}