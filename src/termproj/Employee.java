package termproj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee extends User {
	
	private int empID;
	private ArrayList<Patient> patients;
	
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
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	
	public int getEmpID() {
		return empID;
	}

	public void addPatient(Patient p) {
		patients.add(p);
	}
	public void removePatient(Patient p) {
		for(int i = 0; i < patients.size(); i++) {
			if(p.equals(patients.get(i))) {
				patients.remove(i);
				break;
			}
		}
	}
	
}
