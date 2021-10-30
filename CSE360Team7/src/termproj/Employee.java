package termproj;

import java.io.Serializable;

public class Employee implements Serializable {
	private String firstName, lastName, username;
	private int empID;
	private PatientMessage[] inbox;
	private int[] patients;
	
	public Employee() {
		
	}
	
	

	
	public Employee(String fName, String lName, String un, int empID, int[] patients) {
		firstName = fName;
		lastName = lName;
		username = un;
		this.empID = empID;
		this.patients = patients;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String un) {
		username = un;
	}
	
	public void addMessage(PatientMessage msg) {
		
	}
	
}
