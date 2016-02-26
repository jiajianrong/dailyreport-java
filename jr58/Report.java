package jr58;

import java.io.Serializable;


public class Report implements Serializable {

	private String id;
	private String name;
	private String date;
	private String content;
	
	
	public Report(String id, String name, String date, String content) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.content = content;
	}
	
	public String toString() {
		//return this.id + " " + this.name + " " + this.date + " " + this.content;
		
		return "{\"id\":\"" + this.id + "\", \"name\":\"" + this.name 
				+ "\", \"date\":\"" + this.date + "\", \"content\":\"" + this.content + "\"}";
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
