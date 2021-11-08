package termproj;

import java.io.Serializable;

public class Employee extends User {
	
	private int empID;
	private int[] patients;
	
	public Employee() {
		
	}
	
	

	
	public Employee(String fName, String lName, String un, String pass, int empID, int[] patients) {
		firstName = fName;
		lastName = lName;
		username = un;
		password = pass;
		this.empID = empID;
		this.patients = patients;
	}
	
	
	

	
}
