package termproj;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NursePage extends Pages{
	private Scene scene;
	private Patient pat;
	private Nurse user;
	private int cnt = 0;
	private ArrayList<Patient> patientList = new ArrayList<>();
	private List<PatientMessage> inboxList = new ArrayList<>();
	//private ArrayList<User> userList = new ArrayList<User>();
	
	public NursePage(String un, ArrayList<User> uL) {
		super(un, uL);
		UserManager umgr = new UserManager(uL);
		user = (Nurse) umgr.readUserFromList(un);
		inboxList = user.getInbox();
		
		String typeString = "Patient";//know we are looking to only display type patient
		for(int i = 0; i < userList.size(); i++) {
			if(typeString.equals(userList.get(i).userType)) {
				patientList.add((Patient)userList.get(i));
			}
		}
	}
	
	@FXML
	private TextField weightTF;
	@FXML
	private ObservableList<Patient> obs = FXCollections.observableArrayList(patientList);
	@FXML
	private ListView<Patient> lstView = new ListView<Patient>(obs);
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
	private ObservableList<PatientMessage> inbox = FXCollections.observableArrayList(inboxList);
	@FXML
	private TableView<PatientMessage> inboxTblView = new TableView<PatientMessage>(inbox);
	
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
	private Label usernameLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label welcomeLabel;
	
	
	@FXML
	private Label dobLabel;
	@FXML
	private ListView<String> MedsView;
	@FXML
	private ListView<String> HealthView;
	@FXML
	private ListView<String> ImmunView;
	
	@FXML
	public void initialize() {
		
		welcomeLabel.setText("Welcome " + user.getFirstName());
		
		lstView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				userSelected(event);
			}
		});
		setListView();
		
		
		inboxTblView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				messageSelected(event);
			}
		});
		setInboxView();
	}
	
	
	@FXML
	public void messageSelected(MouseEvent arg0) {
		PatientMessage selectedMsg = inboxTblView.getSelectionModel().getSelectedItem();
		
	}
	
	public void setInboxView() {
		inbox.setAll(inboxList);
		inboxTblView.getItems().addAll(inbox);
		

		TableColumn<PatientMessage, String> senderCol = new TableColumn<>();
		senderCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getSenderUN()));
		
		TableColumn<PatientMessage, String> subjectCol = new TableColumn<>();
		subjectCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getSubject()));
		

		
		inboxTblView.getColumns().addAll(senderCol, subjectCol);
	}
	
	
	@FXML
	public void userSelected(MouseEvent arg0) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		dobLabel.setText(selectedPatient.getDOB());
		
		ArrayList<String> tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getMedications().length; i++) {
			tempList.add(selectedPatient.getMedications()[i]);
		}
		ObservableList<String> stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		MedsView.setItems(stringList);
		
		tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getHealthIssues().length; i++) {
			tempList.add(selectedPatient.getHealthIssues()[i]);
		}
		stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		HealthView.setItems(stringList);
		
		tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getImmunizations().length; i++) {
			tempList.add(selectedPatient.getImmunizations()[i]);
		}
		stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		ImmunView.setItems(stringList);
		
		
		weightTF.setText("" + selectedPatient.getWeight());
		heightTF.setText("" + selectedPatient.getHeight());
		bTempTF.setText("" + selectedPatient.getBodyTemp());
		bPressTF.setText("" + selectedPatient.getBloodPress());
		String tempString = "";
		for(int i = 0; i < selectedPatient.getAllergies().length; i++) {
			tempString += "" + selectedPatient.getAllergies()[i] + "\n";
		}
		knownAllergyTA.setText(tempString);
		tempString = "";
		for(int i = 0; i < selectedPatient.getHealthConcerns().length; i++) {
			tempString += "" + selectedPatient.getHealthConcerns()[i] + "\n";
		}
		hcTA.setText(tempString);
	}
	
	public void setListView() {
		obs.setAll(patientList);
		lstView.setItems(obs);
		
	}
	
	@FXML
	public void enterButtonClicked(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		selectedPatient.setWeight(Double.parseDouble(weightTF.getText()));
		selectedPatient.setHeight(Double.parseDouble(heightTF.getText()));
		selectedPatient.setBodyTemp(Double.parseDouble(bTempTF.getText()));
		selectedPatient.setBloodPress(Double.parseDouble(bPressTF.getText()));
		
		String textFromAllergies = knownAllergyTA.getText();
		String lines[] = textFromAllergies.split("\\r?\\n");
		selectedPatient.setAllergies(lines);
		
		String textFromConcerns = hcTA.getText();
		String hcLines[] = textFromConcerns.split("\\r?\\n");
		selectedPatient.setAllergies(hcLines);
		
		weightTF.setText("");
		heightTF.setText("");
		bTempTF.setText("");
		bPressTF.setText("");
		knownAllergyTA.setText("");
		hcTA.setText("");
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
		
		usernameLabel.setText(un);
		passwordLabel.setText(pw);
	}
	
	public void assignPatient(Patient pat) {
		userList.add(pat);
		patientList.add(pat);
		obs.setAll(patientList);
		lstView.setItems(obs);
	}
	/*@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}*/
	
	/*public void setScene() throws IOException{
		scene = FXMLLoader.load(getClass().getResource("NursePane.fxml"));
	}*/
}
