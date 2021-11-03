package termproj;

import java.io.Serializable;

public class User implements Serializable {
	protected String firstName, lastName, dateofbirth, username, password;
	protected PatientMessage[] inbox;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String un) {
		un = firstName.charAt(0) + lastName + dateofbirth.substring(6, 8);
		username = un;
	}
	public void setPassword(String pw) {
		pw = lastName + firstName + dateofbirth.substring(6, 8);
		password = pw;
	}
	
	public void addMessage(PatientMessage msg) {
		
	}
	public User() {
		
	}
	public User(String fName, String lName, PatientMessage[] ib) {
		firstName = fName;
		lastName = lName;
		inbox = ib;
	}
}
