package apiExploration;

public class Incident {

	private String short_description;
	private String caller_id;
	
	//constructor
	public Incident(String short_description, String caller_id) {
		
		this.short_description=short_description;
		this.caller_id=caller_id;
	}
	
	//Getter and setter
	public String getShort_description() {
		return short_description;
	}
	
	public void setShort_description(String short_description) {
		this.short_description=short_description;
	}
	
	
	public String getCaller_id() {
		return caller_id;
	}
	
	public void setCaller_id(String caller_id) {
		this.caller_id=caller_id;
	}
}
