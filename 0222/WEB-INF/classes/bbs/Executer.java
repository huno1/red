package bbs;

import java.util.List;

import bean.*;

class Executer {
	
	DBAccessor dba = null;
	
	public Executer(){
		try{
			dba = new DBAccessor();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//オーバーライド専用
	public int total(String row, String keyword) throws Exception{return 0;}
	public void execute(ServletRequest req) throws Exception{}
	public List<Bean> query(ServletRequest req) throws Exception{return null;}
	
}
