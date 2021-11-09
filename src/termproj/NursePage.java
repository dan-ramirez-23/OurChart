package termproj;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NursePage extends Pages{
	private Scene scene;
	private Patient pat;
	private int cnt = 0;
	private String username;
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<String> userListName = new ArrayList<String>();
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private ArrayList<User> docList = new ArrayList<User>();
	
	public NursePage(String un, ArrayList<User> uL) {
		super(un, uL);
		userList=uL;
		setListView();
	}
	
	
	@FXML
	private TextField weightTF;
	@FXML
	private ObservableList<User> obs = FXCollections.observableArrayList(userList);
	@FXML
	private ListView<User> lstView = new ListView<User>(obs);
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
	private Button changeDoctor;
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
	
		lstView.getItems().addAll(userList);
		
	
	}
	
	public void setListView() {
		obs.setAll(userList);
		lstView.setItems(obs);
		
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
		String phoneNum = phoneNumTF.getText();
		//int phoneNum = Integer.parseInt(phoneNumTF.getText());
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
		userList.add(pat);
		patientList.add(pat);
		docList.add(pat);
	}
	
	public void changeDoc(ActionEvent event) throws IOException {
			if (pat.getClass() == Patient.class) {
				pat.getDoctor();
				if(userList.contains(pat)) {
					userList.remove(pat);
					docList.add(pat);
				}
			}
	}
	/*@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}*/
	
	/*public void setScene() throws IOException{
		scene = FXMLLoader.load(getClass().getResource("NursePane.fxml"));
	}*/
}
