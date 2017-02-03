package bean;

public class Topic{
	private String id;
	private String title;
	private String fdate;
	private String ldate;
	private String count;
	
	public Topic(String id, String title, String fdate, String ldate, String count){
		this.id=id;
		this.title=title;
		this.fdate=fdate;
		this.ldate=ldate;
		this.count=count;
	}
	
	public String getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getFdate(){
		return fdate;
	}
	public String getLdate(){
		return ldate;
	}
	public String getCount(){
		return count;
	}
}