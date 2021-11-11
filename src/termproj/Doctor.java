package termproj;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Doctor extends Employee {
	
	private int[] nurses;
	
	public Doctor() {
		
	}

	public Doctor(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients, String uType) {
		super(fName, lName, un, pass, empID, patients, "Doctor");
	}
	
	public void addPatientsToDoctor(Patient pat) {
	   patients.add(pat);
	}
	
	public void removePatient(Patient pat) {
		patients.remove(pat);
	}
	
	public ArrayList<Patient> getDoctorPatientList() {   
	    return patients;
	}
	
}
