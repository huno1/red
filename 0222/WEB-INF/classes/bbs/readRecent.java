package bbs;

import java.util.List;

import bean.*;

class readRecent extends Executer {
	
	public List<Bean> query(ServletRequest req) throws Exception{
		
		String sql = "SELECT * FROM (SELECT con_th_id, con_id, con_user_name, con_content, con_date, con_parent_id, con_deleted, con_file FROM content WHERE con_state=1 ORDER BY con_date DESC) WHERE rownum <= 15";
		
		List<Bean> recent =  dba.getContentList(sql);
		
		return recent;
	}
}