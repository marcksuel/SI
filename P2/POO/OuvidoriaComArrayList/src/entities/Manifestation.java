package entities;

public class Manifestation {

	protected String description;
	protected String name;
	protected int code;
	
	
	
	public Manifestation(String description, String name, int code) {
		this.description = description;
		this.name= name;
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return 	"\nCode:  " + code 
				 +"\nName:  " + name 
				+ "\nDescription:  " + description 
				+ "\n";
	}
	
	
	
	
}
