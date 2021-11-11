package termproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PatientPage extends Pages {
	// private ArrayList<User> userList;

	public PatientPage(String un, ArrayList<User> uL) {
		super(un, uL);
		System.out.println("On patient page creation, un = " + un);
	}

	private String username;

	@FXML
	private Button sendMsgButton;
	@FXML
	private TextField messageBody;
	@FXML
	private TextField subject;

	@FXML
	public void initialize() { // start here

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

}
