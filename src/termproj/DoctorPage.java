package termproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DoctorPage extends Pages{
	//private String username;
	private String patientSelected;
	//private ArrayList<User> userList;
	
	@FXML
	private Button sendMsgButton;
	@FXML
	private TextField messageBody;
	@FXML
	private TextField subject;
	
	
	
	
	public DoctorPage(String un, ArrayList<User> uL) {
		super(un, uL);
	}
	

	
	@FXML
	public void initialize() {
		

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
