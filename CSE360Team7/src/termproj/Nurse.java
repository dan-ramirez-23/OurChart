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

public class Nurse extends User {
	
	public Nurse () {
		
	}
	
	@FXML
	private Button createPatientButton;
	@FXML
	private TextField fName;
	@FXML 
	private TextField lName;
	@FXML
	private TextField dob;
	@FXML
	private TextField email;
	@FXML
	private TextField phoneNum;
	@FXML
	private TextField pharmacy;
	@FXML
	private TextField insurCompany;
	@FXML 
	private TextField immunization;
	@FXML
	private TextField medication;

	@FXML
	public void initialize() {

	}
	
	public void create(ActionEvent event) throws IOException {
		createPatient();
	}
	
	public void createPatient() {
		String fName = fName.getText();
		String lName = lName.getText();
		String dob = dob.getText();
		String email = email.getText();
		String phoneNum = phoneNum.getText();
		String pharmacy = pharmacy.getText();
		String insurCompany = insurCompany.getText();
		String immunization = immunization.getText();
		String medication = medication.getText();
	}
}
