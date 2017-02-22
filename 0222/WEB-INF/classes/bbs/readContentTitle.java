package bbs;

import java.util.List;

import bean.*;

class readContentTitle extends Executer {
	
	public List<Bean> query(ServletRequest req) throws Exception{
		
		String thid = req.getThid();
		
		//ÉXÉåÇÃå©èoÇµóp
		String sql = "SELECT th_id, th_title, th_fdate, th_ldate, count, th_maker FROM thread LEFT JOIN (select con_th_id, count(*) count from content where con_state=1 group by con_th_id) ON (th_id=con_th_id) WHERE th_id = '"+thid+"'";
		
		List<Bean> tlist = dba.getTopicList(sql);
		
		return tlist;
	}
}