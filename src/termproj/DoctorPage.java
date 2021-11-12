package termproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DoctorPage extends Pages{
	//private String username;
	private Doctor user = new Doctor();
	private String patientSelected;
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Patient> patientList = new ArrayList<>();
	
	
	@FXML
	private ObservableList<Patient> obs = FXCollections.observableArrayList(user.getPatients());
	@FXML
	private ListView<Patient> patientView = new ListView<>(obs);
	
	@FXML 
	private Button sendScript;
	@FXML
	private Label welcomeLabel;
	@FXML
	private Button sendMsgButton;
	@FXML
	private TextField messageBody;
	@FXML
	private TextField subject;
	@FXML
	private TextArea prescript;
	@FXML
	private ListView<String> MedsView;
	@FXML
	private ListView<String> HealthView;
	@FXML
	private ListView<String> ImmunView;
	@FXML
	private Button reassignButton;
	@FXML
	private Label dobLabel;
	
	
	public DoctorPage(String un, ArrayList<User> uL, UserManager um) {
		super(un, uL, um);
		//find Doctor by username
		String ut = "Doctor";
		for(int i = 0; i < super.userList.size(); i++) {
			UserManager testUM = new UserManager(uL);
			System.out.println("Hannah user type:" + testUM.readUserFromList(super.username).getUserType());
			
			if(ut.equals(super.userList.get(i).getUserType()) && (super.userList.get(i).getUsername().equals(super.username))) {
				System.out.println(super.userList.get(i));
				user = (Doctor) super.userList.get(i);
			}
		}
		patientList = user.getPatients();
		System.out.print(patientList);
	}
	
	
	@FXML
	public void initialize() {
		welcomeLabel.setText("Welcome " +user.getFirstName());
		setListView();
		patientView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				userSelected(event);
			}
		});
		setListView();

	}
	
	public void setListView() {
		obs.setAll(patientList);
		patientView.setItems(obs);
	}
	
	public void userSelected(MouseEvent arg0) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel().getSelectedItem();
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
		
	}
	
	public void sendScript(ActionEvent event) throws IOException {
		sendPrescriptions();
		
	}
	
	public void sendPrescriptions() {
		Patient selectedPatient = (Patient) patientView.getSelectionModel().getSelectedItem();
		String newprescription = prescript.getText();
		int l = (selectedPatient.getPrescriptions().length + 1);
		String[] newPrescriptions = new String[l];
		
		for(int i = 0; i < selectedPatient.getPrescriptions().length; i++){
		   newPrescriptions[i] = selectedPatient.getPrescriptions()[i];
		}
		newPrescriptions[selectedPatient.getPrescriptions().length] = newprescription;
		selectedPatient.setPrescriptions(newPrescriptions);
		
	String subj = ("New Prescription " + newprescription);
	String body = ("Hello " + selectedPatient.getFirstName() + " your prescription " + newprescription 
			+ " has been sent to your pharmacy " + selectedPatient.getPharmacy() + " and will be ready soon");
	String[] recipient = {patientSelected};
	String senderUN = selectedPatient.getUsername();
	MessageHandler msgHandler = new MessageHandler(subj,body,senderUN);
	msgHandler.sendMessage();
		
	}
	public void send(ActionEvent event) throws IOException {
		sendMsg();
	}
	
	public void sendMsg() {
		String subj = subject.getText();
		String body = messageBody.getText();
		String senderUN = username;
		PersonnelFileReader reader = new PersonnelFileReader(username);
		Doctor sender = (Doctor)reader.readUser();//changed readEmployee to readUser
		String[] recipient = {patientSelected};
		//PatientMessage msg = new PatientMessage(subj,body,senderUN,recipient);
		MessageHandler msgHandler = new MessageHandler(subj,body,senderUN);
		msgHandler.sendMessage();
	}

}
