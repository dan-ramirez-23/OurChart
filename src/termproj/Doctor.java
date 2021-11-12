package termproj;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Doctor extends Employee {
	
	private int[] nurses;//not used currently, if needed add to both constructors
	
	public Doctor() {
		super("", "", "", "", -1, new ArrayList<>(), "Doctor");
	}

	public Doctor(String fName, String lName, String un, String pass, int empID) {
		super(fName, lName, un, pass, empID, "Doctor");
		
	}
	public Doctor(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients) {
		super(fName, lName, un, pass, empID, patients, "Doctor");
		
	}
}