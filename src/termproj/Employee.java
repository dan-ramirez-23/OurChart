package termproj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
	
	private int empID;
	protected ArrayList<Patient> patients;
	
	public Employee() {
		
	}
	
	public Employee(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients, String uType) {
		super(fName, lName, uType);
		username = un;
		password = pass;
		this.empID = empID;
		this.patients = patients;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public void addPatient(Patient p) {
		patients.add(p);
	}
	
}
