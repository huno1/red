package bbs;

class getTotal extends Executer {
	
	public int total(String row, String keyword) throws Exception{
		
		String sql = "SELECT count("+row+") FROM thread "+keyword ;
		
		int total = Integer.parseInt(dba.getString(sql));
		
		return total;
		
	}
}