package bean;

public class Content{
	private String thid;
	private String id;
	private String username;
	private String content;
	private String date;
	private String parent;
	private String deleted;
	private String file;
	
	public Content(String thid, String id, String username, String content, String date, String parent, String deleted, String file){
		this.thid=thid;
		this.id=id;
		this.username=username;
		this.content=content;
		this.date=date;
		this.parent=parent;
		this.deleted=deleted;
		this.file=file;
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
	public String getDeleted(){
		return deleted;
	}
	public String getFile(){
		return file;
	}
}