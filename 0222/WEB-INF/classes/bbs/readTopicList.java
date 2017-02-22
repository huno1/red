package bbs;

import java.util.List;

import bean.*;

class readTopicList extends Executer {
	
	public List<Bean> query(ServletRequest req) throws Exception{
		
		//topic=form‚©‚çŽæ‚Á‚½ƒXƒŒID
		String thid = req.getThid();
		String keyword = "";
		if(req.getKeyword()!=null){
			keyword = req.getKeyword();
		}
		int page = Integer.parseInt(req.getPage());
		int first = (page-1)*10+1;
		int last = (page)*10;
		
		String sql = "SELECT * FROM (SELECT th_id,th_title,th_fdate,th_ldate,count,th_maker,r1,rownum r2 FROM (SELECT th_id,th_title,th_fdate,th_ldate,count,th_maker,rownum r1 FROM thread LEFT JOIN (select con_th_id,count(*) count from content where con_state=1 group by con_th_id) ON (th_id=con_th_id) "+keyword+" ORDER BY th_ldate DESC)) WHERE r2 BETWEEN "+first+" AND "+last;
		System.out.println(sql);
		
		List<Bean> tlist = dba.getTopicList(sql);
		
		return tlist;
		
	}
}