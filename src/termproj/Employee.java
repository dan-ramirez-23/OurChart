package termproj;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User {
	
	private int empID;
	private ArrayList<Patient> patients;
	
	public Employee() {
		
	}
	
	public Employee(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients, String uType) {
		super(fName, lName, uType, un, pass);
		//username = un;
		//password = pass;
		this.empID = empID;
		this.patients = patients;
	}
	
	public int getID() {
		return empID;
	}
	public ArrayList<Patient> getPatients(){
		return patients;
	}

	
}
