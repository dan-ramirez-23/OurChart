package termproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientPage extends Pages {
	// private ArrayList<User> userList;

	Patient currentUser = new Patient("", "", -1, "", "", "", "", "");

	public PatientPage(String un, ArrayList<User> uL, UserManager um) {
		super(un, uL, um);
		System.out.println("On patient page creation, un = " + un);

		String typeString = "Patient";// know we are looking to only display type patient
		for (int i = 0; i < userList.size(); i++) {
			if (typeString.equals(userList.get(i).getUserType()) && (userList.get(i).getUsername().equals(username))) {
				currentUser = (Patient) userList.get(i);
			}
		}

	}

	@FXML
	private Button sendMsgButton;
	@FXML
	private TextField messageBody;
	@FXML
	private TextField subject;
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
	public void initialize() {

		PhoneNumView.setText(currentUser.getPhoneNum());
		PharmView.setText(currentUser.getPharmacy());
		InsurView.setText(currentUser.getInsurer());
		dobView.setText(currentUser.getDOB());
		FirstNameView.setText(currentUser.getFirstName());
		EmailView.setText(currentUser.getEmail());
		LastNameView.setText(currentUser.getlName());

		String temp = "";

		for (int i = 0; i < currentUser.getHealthConcerns().length; i++) {
			temp += "" + currentUser.getHealthConcerns()[i] + "\n";
		}
		
		healthHistory.setText(temp);

		temp = "";
		for (int i = 0; i < currentUser.getImmunizations().length; i++) {
			temp += "" + currentUser.getImmunizations()[i] + "\n";
		}

		ImmuniView.setText(temp);

		temp = "";
		for (int i = 0; i < currentUser.getMedications().length; i++) {
			temp += "" + currentUser.getMedications()[i] + "\n";
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
		
	}

	public void send(ActionEvent event) throws IOException {
		sendMsg();
	}

	public void sendMsg() {

		Patient pat = new Patient("bill", "hicks", 27, "August 13, 1974",
				"bhicks.xyz", "508888888", "todd", "Blue Cross");
		pat.setUserName("bhicks");
		pat.setPassword("apple");
		PersonnelFileWriter pfw = new PersonnelFileWriter();
		pfw.writeUser(pat);

		String subj = subject.getText();
		System.out.println("in the sendMsg function - subj is: " + subj);
		String body = messageBody.getText();
		String senderUN = username;

		System.out.println("In PatientPage sending message from " + senderUN);
		MessageHandler msg = new MessageHandler(subj, body, senderUN);
		msg.sendMessage();
	}
	public void enterInfo(ActionEvent event) {
		currentUser.setPhoneNum(PhoneNumView.getText());
		currentUser.setEmail(EmailView.getText());
		currentUser.setPharm(PharmView.getText());
		currentUser.setInsurer(InsurView.getText());
	}
}
