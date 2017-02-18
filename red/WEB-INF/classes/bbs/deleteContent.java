package bbs;

import java.sql.Statement;

class deleteContent extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		String conid = req.getConid();
		String thid = req.getThid();
		
		String sql = "UPDATE content SET con_state=0 WHERE con_th_id="+thid+" AND con_id="+conid;
		
		stmt.executeUpdate(sql);
		
		/*req.setAttribute("message",conid+" çÌèúÇ≥ÇÍÇ‹ÇµÇΩÅB"); */
	
		con.commit();
	}
}