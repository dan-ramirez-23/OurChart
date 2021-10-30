package termproj;

import java.io.Serializable;

public class User implements Serializable {
	protected String firstName, lastName, username;
	protected PatientMessage[] inbox;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String un) {
		username = un;
	}
	
	public void addMessage(PatientMessage msg) {
		
	}
}
