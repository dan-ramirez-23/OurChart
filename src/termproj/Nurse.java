package termproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class Nurse extends Employee {
	
	public Nurse() {
		super("", "", "", "", -1, new ArrayList<>(), "Nurse");
	}
	
	public Nurse(String fName, String lName, String un, String pass, int empID) {
		super(fName, lName, un, pass, empID, "Nurse");
	}
	public Nurse(String fName, String lName, String un, String pass, int empID, ArrayList<Patient> patients) {
		super(fName, lName, un, pass, empID, patients, "Nurse");
	}
}
