package termproj;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User {
	
	private int empID;
	private ArrayList<Patient> patients;
	
	public Employee() {
		
	}
	
	

	
	public Employee(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients) {
		firstName = fName;
		lastName = lName;
		username = un;
		password = pass;
		this.empID = empID;
		this.patients = patients;
	}
	
	
	

	
}
