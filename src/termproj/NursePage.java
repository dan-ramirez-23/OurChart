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
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class NursePage extends Pages{
	private Scene scene;
	private Nurse user = new Nurse();//temporary nurse
	private int cnt = 0;
	ArrayList<Doctor> doctorList = new ArrayList<>();
	FileChooser fileChooser = new FileChooser();
	private ArrayList<Patient> patientList = new ArrayList<>();
	private List<PatientMessage> inboxList = new ArrayList<>();
	//private ArrayList<User> userList = new ArrayList<User>();
	
	public NursePage(String un, ArrayList<User> uL, UserManager um) {
		super(un, uL, um);
		//UserManager umgr = new UserManager(uL); umgr moved to pages class, will be created in termproj
		user = (Nurse) umgr.readUserFromList(un);
		inboxList = user.getInbox();
		
		String typeString = "Patient";//know we are looking to only display type patient
		for(int i = 0; i < userList.size(); i++) {
			if(typeString.equals(userList.get(i).getUserType())) {
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
	private TextArea messageBodyTA;
	@FXML
	private TextArea outgoingMessageTA;
	@FXML
	private TextField subjectTF;
	@FXML
	private Button sendMsgButton;
	@FXML
	private Label composeMsgLabel;
	
	
	
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
	private Button RemoveMedsButton;
	@FXML
	private Button EnterMedsButton;
	@FXML
	private Button RemoveHealthButton;
	@FXML
	private Button EnterHealthButton;
	@FXML
	private Button RemoveImmunButton;
	@FXML
	private Button EnterImmunButton;
	@FXML
	private TextField EnterMedsTF;
	@FXML
	private TextField EnterHealthTF;
	@FXML
	private TextField EnterImmunTF;
	
	@FXML
	public void initialize() {
		
		welcomeLabel.setText("Welcome " + user.getFirstName());
		messageBodyTA.setEditable(false);
		
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
		lstView.getSelectionModel().select(0);
		userSelected(null);
		setInboxView();
	}
	
	
	@FXML
	public void messageSelected(MouseEvent arg0) {
		PatientMessage selectedMsg = inboxTblView.getSelectionModel().getSelectedItem();
		messageBodyTA.setText(selectedMsg.getMessage());
		//selectedMsgSenderUN = inboxTblView.getSelectionModel().getSelectedItem().getSenderUN();
		
	}
	
	public void sendMessage(ActionEvent event) throws IOException {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		if(selectedPatient == null) {
			System.out.println("null test");
			composeMsgLabel.setText("Select a patient from left menu");
		} else {
			String subj = subjectTF.getText();
			System.out.println("in the sendMsg function - subj is: " + subj);
			String body = outgoingMessageTA.getText();
			String senderUN = username;
			String recipient = selectedPatient.getUsername();
			

			System.out.println("In PatientPage sending message from " + senderUN);
			MessageHandler msg = new MessageHandler(subj, body, senderUN, recipient);
			msg.sendMessage();
		}

		
	}


		
	
	
	@FXML
	public void changeDoc(Event e) {
		Doctor currentDoctor = new Doctor();
		Doctor newDoctor;
		ArrayList<Doctor> dList = new ArrayList<>();
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		for(int i = 0; i < umgr.getUserList().size(); i++) {
			if(umgr.getUserList().get(i).getUserType().equals("Doctor")) {
				dList.add((Doctor) umgr.getUserList().get(i));
			}
		}
		for(int i = 0; i < dList.size(); i++) {
			if(dList.get(i).getID() == selectedPatient.getDoctor()) {
				System.out.println("Doctor Found");
				currentDoctor = dList.get(i);
			}
		}
		if(dList.size() > 1) {
			Random rand = new Random();
			int randInt;
			do {
				randInt = rand.nextInt(dList.size());
				newDoctor = dList.get(randInt);
			}while(currentDoctor.equals(newDoctor));
			
			newDoctor.addPatient(selectedPatient);
			selectedPatient.setDoctor(newDoctor.getID());
			currentDoctor.removePatient(selectedPatient);
			}
		else {
			System.out.println("Only 1 doctor");
		}
		umgr.writeAllUsers();
		
	}
	
	public void setInboxView() {
		inbox.setAll(inboxList);
		inboxTblView.getItems().addAll(inbox);
		//System.out.println("inbox after adding to tblview:" + inbox.get(1).getSenderUN());

		TableColumn<PatientMessage, String> senderCol = new TableColumn<>("From:");
		senderCol.setCellValueFactory(new PropertyValueFactory<>("senderUN"));
		
		TableColumn<PatientMessage, String> subjectCol = new TableColumn<>("Subject");
		subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
		
		inboxTblView.getColumns().addAll(senderCol, subjectCol);
	}
	
	
	@FXML
	public void userSelected(MouseEvent arg0) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		composeMsgLabel.setText("Message to " + selectedPatient.getUsername());
		dobLabel.setText(selectedPatient.getDOB());
		
		
		ArrayList<String> tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getMedications().size(); i++) {
			tempList.add(selectedPatient.getMedications().get(i));
		}
		ObservableList<String> stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		MedsView.setItems(stringList);
		
		tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getHealthIssues().size(); i++) {
			tempList.add(selectedPatient.getHealthIssues().get(i));
		}
		stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		HealthView.setItems(stringList);
		
		tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getImmunizations().size(); i++) {
			tempList.add(selectedPatient.getImmunizations().get(i));
		}
		stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		ImmunView.setItems(stringList);
		
		String [] patientDOB = selectedPatient.getDOB().split("-|/");
		int patientBirthYear = Integer.parseInt(patientDOB[2]);
		double patientAge = 0;
		if(patientDOB[2].length() == 2) {
			if(patientBirthYear <= 21) {
				patientAge = 21 - patientBirthYear;
			}
			else {
				patientAge = 100 - patientBirthYear + 21;
			}
		}
		else if(patientDOB[2].length() == 4){
			patientAge = 2021 - patientBirthYear;
		}
		if(selectedPatient.getWeight() >= 0) {
			weightTF.setText("" + selectedPatient.getWeight());
		}
		else {
			weightTF.setText("");
		}
		if(selectedPatient.getHeight() >= 0) {
			heightTF.setText("" + selectedPatient.getHeight());
		}
		else {
			heightTF.setText("");
		}
		if(selectedPatient.getBodyTemp() >= 0) {
			bTempTF.setText("" + selectedPatient.getBodyTemp());
		}
		else {
			bTempTF.setText("");
		}
		if(patientAge > 12) {
			if(selectedPatient.getBloodPress() >= 0) {
				bPressTF.setText("" + selectedPatient.getBloodPress());
			}
			else {
				bPressTF.setText("");
			}
			bPressTF.setEditable(true);
			bPressTF.setStyle("-fx-control-inner-background: white;");
		}
		else {
			bPressTF.setEditable(false);
			bPressTF.setStyle("-fx-control-inner-background: Gainsboro;");
			bPressTF.setText("");
		}
		
		String tempString = "";
		for(int i = 0; i < selectedPatient.getAllergies().size(); i++) {
			tempString += "" + selectedPatient.getAllergies().get(i) + "\n";
		}
		knownAllergyTA.setText(tempString);
		tempString = "";
		for(int i = 0; i < selectedPatient.getHealthConcerns().size(); i++) {
			tempString += "" + selectedPatient.getHealthConcerns().get(i) + "\n";
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
		ArrayList<String> tempList = new ArrayList<>();
		for(int i = 0; i < lines.length; i++) {
			tempList.add(lines[i]);
		}
		selectedPatient.setAllergies(tempList);
		
		String textFromConcerns = hcTA.getText();
		String hcLines[] = textFromConcerns.split("\\r?\\n");
		ArrayList<String> tempList2 = new ArrayList<>();
		for(int i = 0; i < hcLines.length; i++) {
			tempList2.add(hcLines[i]);
		}
		selectedPatient.setHealthConcerns(tempList2);
		
		/*weightTF.setText("");
		heightTF.setText("");
		bTempTF.setText("");
		bPressTF.setText("");
		knownAllergyTA.setText("");
		hcTA.setText("");
		*/
		umgr.writeAllUsers();//write after any changes to a patient
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
		String date = dobTF.getText();
		//String dob = (date.substring(0,2) + "/" + date.substring(2,4) + "/" + date.substring(4,8));
		String email = emailTF.getText();
		String phoneNum = phoneNumTF.getText();
		//int phoneNum = Integer.parseInt(phoneNumTF.getText());
		String pharmacy = pharmacyTF.getText();
		String insurCompany = insurCompanyTF.getText();
		cnt++;
		Patient pat = new Patient(fName, lName, cnt, date, email, phoneNum, pharmacy, insurCompany);//moved from the top
		newiD(pat);
		setLoginInfo(pat);
		addDoctor(pat);
		assignPatient(pat);
		umgr.addUserToList(pat);//saves user to global arraylist
		umgr.writeAllUsers();//writes the file
		umgr.readAllUsers();//reads all users to list once done
	}
	
	public void newiD(Patient p) {
		cnt++;
		Random rand = new Random();
		int randInt = rand.nextInt(9999) + 1;//4 digit id
		for(int i = 0; i < umgr.getUserList().size(); i++) {
			if(umgr.getUserList().get(i).getID() == randInt) {
				randInt = rand.nextInt(9999) + 1;
				i = -1;//restart for loop
			}
		}
		p.setPatientID(randInt);
	}
	public void setLoginInfo(Patient p) {
		String un = "" + p.getFirstName() + p.getLastName() + p.getPatientID();
		String pw = "" + randomPassword();//change Password generation
		
		p.setUserName(un);
		p.setPassword(pw);
		
		usernameLabel.setText(un);
		passwordLabel.setText(pw);
	}
	
	public void assignPatient(Patient pat) {
		userList.add(pat);
		patientList.add(pat);
		obs.setAll(patientList);
		lstView.setItems(obs);
	}
	//	doctorList.add(pat);
	private void addDoctor(Patient p ) {
		Random rand = new Random();
		ArrayList<Doctor> dList= new ArrayList<>();
		
		for(int i = 0; i < umgr.getUserList().size(); i++) {
			if(umgr.getUserList().get(i).getUserType().equals("Doctor")) {
				dList.add((Doctor)umgr.getUserList().get(i));
			}
		}
		int randDocInt = rand.nextInt(dList.size());// random number between 0 and (amount of doctors - 1) inclusive
		
		dList.get(randDocInt).addPatient(p);
		p.setDoctor(dList.get(randDocInt).getID());
	}
	

	//	Doctor assignedDoc = doctorList.get((int) Math.random() * doctorList.size());
	//	assignedDoc.addPatientsToDoctor(pat);
	    
	    
	    
		
	
	/*public void changeDoc(ActionEvent event) throws IOException {
	       for(int i = 0;i<patientList.size();i++){
	    	   Patient currentPatient = patientList.get(i);
	    	   for(int r = 0; r<doctorList.size(); i++) {
	    		   Doctor currentDoctor = doctorList.get(r);
	    		   Doctor nextDoctor = doctorList.get((r+1) % doctorList.size());
	    		   if(currentDoctor.getPatients().contains(i)) {
	    			   currentDoctor.removePatient(currentPatient);
	    			   nextDoctor.addPatient(currentPatient);
	    			   
	    	   }
				
				//	docList.add(ArrayList<Patient> pat);
			}
	       }		
	}*/
	
	private String randomPassword() {
		String passwordString = "";
		Random rand = new Random();
		int tempInt = -1;
		for(int i = 0; i < 10; i++) {
			tempInt = rand.nextInt(123);//adds random characters to create a random password
			if(tempInt < 48) {
				i--;//if too small add another repetition in the loop
			}
			else {
				passwordString += (char) tempInt;
			}
		}
		return passwordString;
	}
	
	@FXML
	public void removeMeds(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		if(selectedPatient.getMedications().contains(MedsView.getSelectionModel().getSelectedItem())) {
			selectedPatient.getMedications().remove(MedsView.getSelectionModel().getSelectedIndex());
		}
		
		resetPatientHistoryView(selectedPatient);
	}
	@FXML
	public void addMeds(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		selectedPatient.getMedications().add(EnterMedsTF.getText());
		resetPatientHistoryView(selectedPatient);
	}
	@FXML
	public void removeHealth(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		if(selectedPatient.getHealthIssues().contains(HealthView.getSelectionModel().getSelectedItem())) {
			selectedPatient.getHealthIssues().remove(HealthView.getSelectionModel().getSelectedIndex());
		}
		
		resetPatientHistoryView(selectedPatient);
	}
	@FXML
	public void addHealth(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		selectedPatient.getHealthIssues().add(EnterHealthTF.getText());
		resetPatientHistoryView(selectedPatient);
	}
	@FXML
	public void removeImmunizations(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		if(selectedPatient.getImmunizations().contains(ImmunView.getSelectionModel().getSelectedItem())) {
			selectedPatient.getImmunizations().remove(ImmunView.getSelectionModel().getSelectedIndex());
		}
		
		resetPatientHistoryView(selectedPatient);
	}
	@FXML
	public void addImmunizations(Event e) {
		Patient selectedPatient = (Patient) lstView.getSelectionModel().getSelectedItem();
		selectedPatient.getImmunizations().add(EnterImmunTF.getText());
		resetPatientHistoryView(selectedPatient);
	}
	
	private void resetPatientHistoryView(Patient selectedPatient) {
		ArrayList<String> tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getMedications().size(); i++) {
			tempList.add(selectedPatient.getMedications().get(i));
		}
		ObservableList<String> stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		MedsView.setItems(stringList);
		
		tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getHealthIssues().size(); i++) {
			tempList.add(selectedPatient.getHealthIssues().get(i));
		}
		stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		HealthView.setItems(stringList);
		
		tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getImmunizations().size(); i++) {
			tempList.add(selectedPatient.getImmunizations().get(i));
		}
		stringList = FXCollections.observableArrayList(tempList);
		stringList.setAll(tempList);
		ImmunView.setItems(stringList);
		umgr.writeAllUsers();
	}
	
}