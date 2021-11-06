package termproj;

import termproj.User;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class Nurse extends Employee {
	
	public Nurse () {
		
	}

	public Nurse(String fName, String lName, String un, String pass, int empID, int[] patients) {
		super(fName, lName, un, pass, empID, patients);
	}
}
