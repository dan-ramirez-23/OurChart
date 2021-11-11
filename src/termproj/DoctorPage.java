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
	private Label welcomeLabel;
	@FXML
	private Button sendMsgButton;
	@FXML
	private TextField messageBody;
	@FXML
	private TextField subject;
	
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
		for(int i = 0; i < userList.size(); i++) {
			if(ut.equals(userList.get(i).getUserType()) && (userList.get(i).getUsername().equals(username))) {
				System.out.println(userList.get(i));
				user = (Doctor) userList.get(i);
			}
		}
		patientList = user.getPatients();
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
