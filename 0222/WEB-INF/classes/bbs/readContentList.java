package bbs;

import java.util.List;

import bean.*;

class readContentList extends Executer {
	
	public List<Bean> query(ServletRequest req) throws Exception{
		
		String thid = req.getThid();
		
		//ƒŒƒX‚ÌŽûŽæ
		String sql = "SELECT con_th_id, con_id, con_user_name, con_content, con_date, con_parent_id, con_deleted, con_file FROM content WHERE con_th_id = '"+thid+"' AND con_state=1 ORDER BY con_date DESC";
		
		List<Bean> clist =  dba.getContentList(sql);
		
		return clist;
	}
}