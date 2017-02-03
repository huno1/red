package bean;

public class User{
	private String id;
	private String name;
	private String pass;
	private String fdate;
	private String ldate;
	
	public User(String id, String name, String pass, String fdate, String ldate){
		this.id=id;
		this.name=name;
		this.pass=pass;
		this.fdate=fdate;
		this.ldate=ldate;
	}
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getPass(){
		return pass;
	}
	public String getFdate(){
		return fdate;
	}
	public String getLdate(){
		return ldate;
	}
}