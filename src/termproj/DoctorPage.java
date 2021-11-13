package termproj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DoctorPage extends Pages {
	// private String username;
	private Doctor user = new Doctor();
	private String patientSelected;
	private ArrayList<Patient> patientList = new ArrayList<>();
	private List<PatientMessage> inboxList = new ArrayList<>();

	@FXML
	private ObservableList<Patient> obs = FXCollections
			.observableArrayList(user.getPatients());
	@FXML
	private ListView<Patient> patientView = new ListView<>(obs);

	@FXML
	private Button sendScript;
	@FXML
	private Label welcomeLabel;
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
	private TextArea physExamFindings;
	@FXML
	private Button sendSummary;
	@FXML
	private TextArea Recs;
	@FXML
	private SplitPane scenePane;

	public DoctorPage(String un, ArrayList<User> uL, UserManager um) {
		super(un, uL, um);
		// find Doctor by username
		String ut = "Doctor";
		for (int i = 0; i < super.userList.size(); i++) {
			// UserManager testUM = new UserManager(uL);
			// System.out.println("Hannah user type:" +
			// testUM.readUserFromList(super.username).getUserType());

			if (ut.equals(userList.get(i).getUserType())
					&& (userList.get(i).getUsername().equals(username))) {
				System.out.println(userList.get(i));
				user = (Doctor) userList.get(i);
			}
		}
		patientList = user.getPatients();
		System.out.print(patientList);
		
		inboxList = user.getInbox(true);
	}

	@FXML
	public void initialize() {
		welcomeLabel.setText("Welcome " + user.getFirstName());
		setListView();
		patientView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				userSelected(event);
			}
		});
		patientView.getSelectionModel().select(0);
		userSelected(null);
		setListView();
		
		
		messageBodyTA.setEditable(false);
		inboxTblView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				messageSelected(event);
			}
		});
		setInboxView();

	}
	
	
	public void setInboxView() {
		inbox.setAll(inboxList);
		inboxTblView.getItems().addAll(inbox);

		TableColumn<PatientMessage, String> senderCol = new TableColumn<>("From:");
		senderCol.setCellValueFactory(new PropertyValueFactory<>("senderUN"));
		
		TableColumn<PatientMessage, String> subjectCol = new TableColumn<>("Subject");
		subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
		
		inboxTblView.getColumns().addAll(senderCol, subjectCol);
	}
	
	
	
	@FXML
	public void messageSelected(MouseEvent arg0) {
		PatientMessage selectedMsg = inboxTblView.getSelectionModel().getSelectedItem();
		messageBodyTA.setText(selectedMsg.getMessage());
		//selectedMsgSenderUN = inboxTblView.getSelectionModel().getSelectedItem().getSenderUN();
		
	}
	
	public void sendMessage(ActionEvent event) throws IOException {
		Patient selectedPatient = (Patient) patientView.getSelectionModel().getSelectedItem();
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
	public void logOut(ActionEvent e) throws IOException {
		umgr.writeAllUsers();
		Parent root = FXMLLoader.load(getClass().getResource("LoginPane.fxml"));
		Stage stage = (Stage) scenePane.getScene().getWindow();
		stage.setScene(new Scene(root, 550, 400));
	}
	

	@FXML
	public void changeDoc(Event e) {
		Doctor currentDoctor = user;
		Doctor newDoctor;
		ArrayList<Doctor> dList = new ArrayList<>();
		Patient selectedPatient = (Patient) patientView.getSelectionModel().getSelectedItem();
		for (int i = 0; i < umgr.getUserList().size(); i++) {
			if (umgr.getUserList().get(i).getUserType().equals("Doctor")) {
				dList.add((Doctor) umgr.getUserList().get(i));
			}
		}
		if (dList.size() > 1) {
			Random rand = new Random();
			int randInt;
			do {
				randInt = rand.nextInt(dList.size());
				newDoctor = dList.get(randInt);
			} while (currentDoctor.equals(newDoctor));

			newDoctor.addPatient(selectedPatient);
			selectedPatient.setDoctor(newDoctor.getID());
			currentDoctor.removePatient(selectedPatient);
		} else {
			System.out.println("Only 1 doctor");
		}
		umgr.writeAllUsers();
		setListView();
	}

	public void setListView() {
		obs.setAll(patientList);
		patientView.setItems(obs);
	}

	public void userSelected(MouseEvent arg0) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel().getSelectedItem();
		
		if(selectedPatient != null) {
			composeMsgLabel.setText("Message to " + selectedPatient.getUsername());
			dobLabel.setText(selectedPatient.getDOB());

			ArrayList<String> tempList = new ArrayList<>();
			for (int i = 0; i < selectedPatient.getMedications().size(); i++) {
				tempList.add(selectedPatient.getMedications().get(i));
			}
			ObservableList<String> stringList = FXCollections
					.observableArrayList(tempList);
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
		}

	}

	public void sendScript(ActionEvent event) throws IOException {
		sendPrescriptions();

	}

	public void sendPrescriptions() {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		String newprescription = prescript.getText();
		int l = (selectedPatient.getPrescriptions().size() + 1);
		ArrayList<String> newPrescriptions = new ArrayList<>();

		/*
		 * for(int i = 0; i < selectedPatient.getPrescriptions().size(); i++){
		 * newPrescriptions.add(selectedPatient.getPrescriptions().get(i)); }
		 */
		newPrescriptions.add(newprescription);
		selectedPatient.setPrescriptions(newPrescriptions);
		// waiting for MessageHandler to be implemented
		
		 String subj = ("New Prescription " + newprescription);
		 String body = ("Hello " + selectedPatient.getFirstName() + " your prescription " + newprescription + " has been sent to your pharmacy " + selectedPatient.getPharmacy() + " and will be ready soon");
		 String recipient = selectedPatient.getUsername();
		 String senderUN = selectedPatient.getUsername();
		 PatientMessage msgHandler = new PatientMessage(subj,body,senderUN, recipient);
		 selectedPatient.getInbox().add(msgHandler);
		 
		umgr.writeAllUsers();// needed to save all changes
	}


	@FXML
	public void removeMeds(Event e) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		if (selectedPatient.getMedications()
				.contains(MedsView.getSelectionModel().getSelectedItem())) {
			selectedPatient.getMedications()
					.remove(MedsView.getSelectionModel().getSelectedIndex());
		}

		resetPatientHistoryView(selectedPatient);
	}

	@FXML
	public void addMeds(Event e) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		selectedPatient.getMedications().add(EnterMedsTF.getText());
		resetPatientHistoryView(selectedPatient);
	}

	@FXML
	public void removeHealth(Event e) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		if (selectedPatient.getHealthIssues()
				.contains(HealthView.getSelectionModel().getSelectedItem())) {
			selectedPatient.getHealthIssues()
					.remove(HealthView.getSelectionModel().getSelectedIndex());
		}

		resetPatientHistoryView(selectedPatient);
	}

	@FXML
	public void addHealth(Event e) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		selectedPatient.getHealthIssues().add(EnterHealthTF.getText());
		resetPatientHistoryView(selectedPatient);
	}

	@FXML
	public void removeImmunizations(Event e) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		if (selectedPatient.getImmunizations()
				.contains(ImmunView.getSelectionModel().getSelectedItem())) {
			selectedPatient.getImmunizations()
					.remove(ImmunView.getSelectionModel().getSelectedIndex());
		}

		resetPatientHistoryView(selectedPatient);
	}

	@FXML
	public void addImmunizations(Event e) {
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		selectedPatient.getImmunizations().add(EnterImmunTF.getText());
		resetPatientHistoryView(selectedPatient);
	}

	private void resetPatientHistoryView(Patient selectedPatient) {
		ArrayList<String> tempList = new ArrayList<>();
		for (int i = 0; i < selectedPatient.getMedications().size(); i++) {
			tempList.add(selectedPatient.getMedications().get(i));
		}
		ObservableList<String> stringList = FXCollections
				.observableArrayList(tempList);
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

	@FXML
	public void sendSummary(Event e) {
		String temp = "";
		temp += "Physical Exam Findings:\n" + physExamFindings.getText() + "\n\nDoctor's Recommendations:\n" + Recs.getText();
		PatientMessage summary = new PatientMessage("", temp, "", true, "");
		Patient selectedPatient = (Patient) patientView.getSelectionModel()
				.getSelectedItem();
		selectedPatient.getInbox().add(summary);

		umgr.writeAllUsers();
	}
}
