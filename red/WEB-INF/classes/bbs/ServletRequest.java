package bbs;

import javax.servlet.http.HttpServletRequest;

class ServletRequest{
	private HttpServletRequest req;
	private String thid;
	private String conid;
	private String title;
	private String username;
	private String userpass;
	
	public ServletRequest(){
		
	}
	//HttpServletRequest型で受け取れるが、なくても問題ない！
	//その時は直接セッターを通して設定。
	//例外処理を入れている理由は一つでもnullの場合、そこで止まる可能性があって。
	public ServletRequest(HttpServletRequest req){
		this.req = req;
		try{
			this.thid = req.getParameter("thid");
		}catch(Exception e){
		}
		try{
			this.conid = req.getParameter("conid");
		}catch(Exception e){
		}
		try{
			this.title = req.getParameter("title");
		}catch(Exception e){
		}
		try{
			this.username = req.getParameter("username");
		}catch(Exception e){
		}
		try{
			this.userpass = req.getParameter("userpass");
		}catch(Exception e){
		}
	}
	
	public void setRequest(HttpServletRequest req){
		this.req = req;
	}
	public void setThid(String thid){
		this.thid = thid;
	}
	public void setConid(String conid){
		this.conid = conid;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setuserpass(String userpass){
		this.userpass = userpass;
	}
	
	public HttpServletRequest getRequest(){
		return req;
	}
	public String getThid(){
		return thid;
	}
	public String getConid(){
		return conid;
	}
	public String getTitle(){
		return title;
	}
	public String getUsername(){
		return username;
	}
	public String getUserpass(){
		return userpass;
	}
}