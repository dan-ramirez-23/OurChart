package termproj;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NursePage extends Pages{
	private Scene scene;
	private Patient pat;
	private int cnt = 0;
	private String username;
	private ArrayList<User> userList;
	
	
	public NursePage(String un, ArrayList<User> uL) {
		super(un, uL);
	}
	@FXML
	private TextField weightTF;
	@FXML
	private TextField heightTF;
	@FXML
	private TextField bTempTF;
	@FXML
	private TextField bPressTF;
	@FXML
	private TextArea knownAllergyTA;
	@FXML
	private TextArea hcTA;
	//@FXML
	//private Button allergyButton;
	@FXML
	private Button enterButton;
	
	@FXML
	private Button createPatientButton;
	@FXML
	private TextField fNameTF;
	@FXML 
	private TextField lNameTF;
	@FXML
	private TextField dobTF;
	@FXML
	private TextField emailTF;
	@FXML
	private TextField phoneNumTF;
	@FXML
	private TextField pharmacyTF;
	@FXML
	private TextField insurCompanyTF;
	@FXML 
	private TextField immunizationTF;
	@FXML
	private TextField medicationTF;
	
	@FXML
	public void initialize() {

	}
	
	
	@FXML
	public void enterButtonClicked(Event e) {
		
	}
	
//	public void create(ActionEvent event) throws IOException {
//		createPatient();
//	}
//	
	/*public void createPatient() {
		
	}*/

	
	public void createPatient(ActionEvent event) throws IOException 
	{
		String fName = fNameTF.getText();
		String lName = lNameTF.getText();
		String dob = dobTF.getText();
		String email = emailTF.getText();
		int phoneNum = Integer.parseInt(phoneNumTF.getText());
		String pharmacy = pharmacyTF.getText();
		String insurCompany = insurCompanyTF.getText();
		cnt++;
		pat = new Patient(fName, lName, cnt, dob, email, phoneNum, pharmacy, insurCompany);
		newiD(pat);
		setLoginInfo(pat);
		assignPatient(pat);
	}
	
	public void newiD(Patient pat) {
		cnt++;
		pat.setiD(cnt);
	}
	public void setLoginInfo(Patient pat) {
		String un = "" + pat.getfName() + pat.getPatientID();
		String pw = "" + pat.getlName() + pat.getPatientID();
		
		pat.setUserName(un);
		pat.setPassword(pw);
		
		
	}
	
	public void assignPatient(Patient pat) {
		System.out.println("Mr. " + pat.lastName + " is in the system. His iD is: " + pat.getPatientID());
	}
	/*@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}*/
	
	/*public void setScene() throws IOException{
		scene = FXMLLoader.load(getClass().getResource("NursePane.fxml"));
	}*/
}
