package termproj;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User {
	
	private int empID;
	private ArrayList<Patient> patients;//I don't think nurses need this, but it's here just in case
	
	public Employee() {
		
	}
	
	public Employee(String fName, String lName, String un, String pass, int empID, String uType) {//does not need a patient list
		super(fName, lName, uType, un, pass, empID);
		//username = un;
		//password = pass;
		this.empID = empID;
		patients = new ArrayList<>();
	}
	
	public Employee(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients, String uType) {
		super(fName, lName, uType, un, pass, empID);
		//username = un;
		//password = pass;
		this.empID = empID;
		this.patients = patients;
	}
	
	public int getEmpID() {
		return empID;
	}
	public ArrayList<Patient> getPatients(){
		return patients;
	}
	public void addPatient(Patient p) {
		patients.add(p);
	}
	
}
