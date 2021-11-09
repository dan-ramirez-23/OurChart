package termproj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	protected String userType;
	protected String firstName, lastName, dateofbirth, username, password;
	protected List<PatientMessage> inbox = new ArrayList<PatientMessage>();

	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}
//	public void setUsername(String un) {
//		un = firstName.charAt(0) + lastName + dateofbirth.substring(6, 8);
//		username = un;
//	}
//	public void setPassword(String pw) {
//		pw = lastName + firstName + dateofbirth.substring(6, 8);
//		password = pw;
//	}
//	
	public void addMessage(PatientMessage msg) {
		inbox.add(msg);
	}
	public User(String fName, String lName, String uType) {
		firstName = fName;
		lastName = lName;
		userType = uType;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
}
