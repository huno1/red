package bbs;

class deleteContent extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		String conid = req.getConid();
		String thid = req.getThid();
		
		String sql = "UPDATE content SET con_state=0 WHERE con_th_id="+thid+" AND con_id="+conid;
		
		dba.executeUpdate(sql);
	
		dba.commit();
	}
}