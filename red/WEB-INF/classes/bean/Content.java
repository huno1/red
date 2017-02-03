package bean;

public class Content{
	private String thid;
	private String id;
	private String username;
	private String content;
	private String date;
	private String parent;
	
	public Content(String thid, String id, String username, String content, String date, String parent){
		this.thid=thid;
		this.id=id;
		this.username=username;
		this.content=content;
		this.date=date;
		this.parent=parent;
	}
	
	public String getThid(){
		return thid;
	}
	public String getId(){
		return id;
	}
	public String getUsername(){
		return username;
	}
	public String getContent(){
		return content;
	}
	public String getDate(){
		return date;
	}
	public String getParent(){
		return parent;
	}
}