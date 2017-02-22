package bbs;

class deleteTopic extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		String thid = req.getThid();
		
		String sql = "DELETE FROM thread WHERE th_id="+thid;
		
		dba.executeUpdate(sql);
		
		sql = "DELETE FROM content WHERE con_th_id="+thid;
		
		dba.executeUpdate(sql);
		
		dba.commit();
	}
}