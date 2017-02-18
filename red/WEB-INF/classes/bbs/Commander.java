package bbs;

import javax.servlet.http.HttpServletRequest;

class Commander{
	
	public Executer getCommand(String action) throws Exception{
		
		if(action.equals("writeContent")){
			return new writeContent();
			
		}else if(action.equals("writeTopic")){
			return new writeTopic();
			
		}else if(action.equals("deleteContent")){
			return new deleteContent();
			
		}else if(action.equals("deleteTopic")){
			return new deleteTopic();
			
		}else if(action.equals("login")){
			return new login();
			
		}else if(action.equals("logout")){
			return new logout();
			
		}else if(action.equals("newAccount")){
			return new newAccount();
			
		}else{
			return null;
		}
		
	}
}