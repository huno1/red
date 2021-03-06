package bbs;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.*;

class readTopicList extends Executer {
	
	public List getTopicList(ServletRequest req) throws Exception{
		
		//topic=formから取ったスレID
		String thid = req.getThid();
		
		List<Topic> tlist = new ArrayList<Topic>();
		String sql = "SELECT th_id, th_title, th_fdate, th_ldate, count, th_maker FROM thread LEFT JOIN (select con_th_id, count(*) count from content where con_state=1 group by con_th_id) ON (th_id=con_th_id) ORDER BY th_ldate DESC";
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Topic t = new Topic(rs.getString(1), rs.getString(2), rs.getString(3).substring(0,rs.getString(3).length()-2), rs.getString(4).substring(0,rs.getString(4).length()-2), rs.getString(5), rs.getString(6));
			tlist.add(t);
		}
		rs.close();
		
		return tlist;
		
	}
}