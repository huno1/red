package bean;

public class Topic extends Bean{
	private String id;
	private String title;
	private String fdate;
	private String ldate;
	private String count;
	private String maker;
	
	public Topic(String id, String title, String fdate, String ldate, String count, String maker){
		this.id=id;
		this.title=title;
		this.fdate=fdate;
		this.ldate=ldate;
		this.count=count;
		this.maker=maker;
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
		if(count==null){
			count="0";
		}
		return count;
	}
	public String getMaker(){
		return maker;
	}
}