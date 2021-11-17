package termproj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PatientPage extends Pages {
	// private ArrayList<User> userList;

	Patient currentUser = new Patient("", "", -1, "", "", "", "", "");
	ArrayList<PatientMessage> summaryList = new ArrayList();
	private List<PatientMessage> inboxList = new ArrayList<>();

	public PatientPage(String un, ArrayList<User> uL, UserManager um) {
		super(un, uL, um);
		
		currentUser = (Patient) umgr.readUserFromList(un);
		inboxList = currentUser.getInbox(true);
		


		String typeString = "Patient";// know we are looking to only display
										// type patient
		for (int i = 0; i < userList.size(); i++) {
			if (typeString.equals(userList.get(i).getUserType())
					&& (userList.get(i).getUsername().equals(username))) {
				currentUser = (Patient) userList.get(i);
			}
		}

		ArrayList<PatientMessage> tempList = (ArrayList) currentUser.getInbox();

		for (int i = 0; i < tempList.size(); i++) {
			if (tempList.get(i).getSummary()) {
				summaryList.add(tempList.get(i));
			}
		}

		//System.out.println(currentUser.getInbox().get(0).getSummary());

	}

	
	@FXML
	private TabPane scenePane;
	@FXML
	private Label welcomeLabel;
	@FXML
	private Button enterButton;
	@FXML
	private TextArea messageBodyTA;
	@FXML
	private TextArea outgoingMessageTA;
	@FXML
	private TextField subjectTF;
	@FXML
	private Label composeMsgLabel;
	@FXML
	private Button sendMsgButton;
	@FXML
	private ObservableList<PatientMessage> inbox = FXCollections.observableArrayList(inboxList);
	@FXML
	private TableView<PatientMessage> inboxTblView = new TableView<PatientMessage>(inbox);
	


	@FXML
	private TextField PhoneNumView;
	@FXML
	private TextField PharmView;
	@FXML
	private TextField InsurView;
	@FXML
	private TextField dobView;
	@FXML
	private TextField FirstNameView;
	@FXML
	private TextField EmailView;
	@FXML
	private TextField LastNameView;

	@FXML
	private TextArea healthHistory;
	@FXML
	private TextArea ImmuniView;
	@FXML
	private TextArea MedView;
	@FXML
	private Button pInfoEnterButton;
	@FXML
	private TextArea summaryArea;
	@FXML
	private ObservableList<PatientMessage> OBS = FXCollections
			.observableArrayList(summaryList);
	@FXML
	private ListView<PatientMessage> dateView = new ListView<PatientMessage>(
			OBS);

	@FXML
	public void initialize() {

		welcomeLabel.setText("Welcome " + currentUser.getFirstName());
		inboxTblView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		messageBodyTA.setEditable(false);
		messageBodyTA.setWrapText(true);
		outgoingMessageTA.setWrapText(true);
		healthHistory.setWrapText(true);
		ImmuniView.setWrapText(true);
		MedView.setWrapText(true);
		summaryArea.setWrapText(true);
		
		
		inboxTblView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				messageSelected(event);
			}
		});
		setInboxView();
		
		
		PhoneNumView.setText(currentUser.getPhoneNum());
		PharmView.setText(currentUser.getPharmacy());
		InsurView.setText(currentUser.getInsurer());
		dobView.setText(currentUser.getDOB());
		FirstNameView.setText(currentUser.getFirstName());
		EmailView.setText(currentUser.getEmail());
		LastNameView.setText(currentUser.getLastName());

		String temp = "";

		for (int i = 0; i < currentUser.getHealthConcerns().size(); i++) {
			temp += "" + currentUser.getHealthConcerns().get(i) + "\n";
		}

		healthHistory.setText(temp);

		temp = "";
		for (int i = 0; i < currentUser.getImmunizations().size(); i++) {
			temp += "" + currentUser.getImmunizations().get(i) + "\n";
		}

		ImmuniView.setText(temp);

		temp = "";
		for (int i = 0; i < currentUser.getMedications().size(); i++) {
			temp += "" + currentUser.getMedications().get(i) + "\n";
		}

		MedView.setText(temp);

		FirstNameView.setEditable(false);
		FirstNameView.setStyle("-fx-background-color: Gainsboro;");
		dobView.setEditable(false);
		dobView.setStyle("-fx-background-color: Gainsboro;");
		LastNameView.setEditable(false);
		LastNameView.setStyle("-fx-background-color: Gainsboro;");
		healthHistory.setEditable(false);
		healthHistory.setStyle("-fx-control-inner-background: Gainsboro;");
		ImmuniView.setEditable(false);
		ImmuniView.setStyle("-fx-control-inner-background: Gainsboro;");
		MedView.setEditable(false);
		MedView.setStyle("-fx-control-inner-background: Gainsboro;");

		showSummaries();
		if (summaryList.size() > 0) {
			dateView.getSelectionModel().select(0);
		}
		summarySelected(null);
		setListView();

	}
	
	@FXML
	public void logOut(ActionEvent e) throws IOException {
		umgr.writeAllUsers();
		Parent root = FXMLLoader.load(getClass().getResource("LoginPane.fxml"));
		Stage stage = (Stage) scenePane.getScene().getWindow();
		stage.setScene(new Scene(root, 550, 400));
		umgr.readAllUsers();
	}

	private void setListView() {
		OBS.setAll(summaryList);
		dateView.setItems(OBS);
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
	
	
	private void showSummaries() {
		dateView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				summarySelected(event);
			}
		});
		setListView();
	}

	@FXML
	public void summarySelected(MouseEvent arg0) {
		PatientMessage selectedMessage = dateView.getSelectionModel()
				.getSelectedItem();
		if(selectedMessage != null) {
			summaryArea.setText(selectedMessage.getMessage());
		}
	}

	@FXML
	public void messageSelected(MouseEvent arg0) {
		PatientMessage selectedMsg = inboxTblView.getSelectionModel().getSelectedItem();
		
		if(selectedMsg != null) {
			messageBodyTA.setText(selectedMsg.getMessage());
		}
		
	}
	
	public void sendMessage(ActionEvent event) throws IOException {
		int docID = currentUser.getDoctor();
		User myDoc = umgr.getEmployee(docID);
		String subj = subjectTF.getText();
		String body = outgoingMessageTA.getText();
		String senderUN = username;
		String recipient = myDoc.getUsername();
		
		MessageHandler msg = new MessageHandler(subj, body, senderUN, recipient);
		msg.sendMessage(true);
		//msg.copyNurses();
		umgr.readAllUsers();

		
	}
	
	
	

	

	public void enterInfo(ActionEvent event) {
		currentUser.setPhoneNum(PhoneNumView.getText());
		currentUser.setEmail(EmailView.getText());
		currentUser.setPharm(PharmView.getText());
		currentUser.setInsurer(InsurView.getText());
		umgr.writeAllUsers();// write after changing anything
	}
}
