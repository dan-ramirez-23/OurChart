package termproj;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class PatientPage extends Pages{
	public PatientPage() {
		
	}
	
	
	public PatientPage(String un) {
		username = un;
	}
	
	private String username;
	
	@FXML
	private Button sendMsgButton;
	@FXML
	private TextField messageBody;
	@FXML
	private TextField subject;

	
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
		//PersonnelFileReader reader = new PersonnelFileReader(username).readPatient();
		//	PatientMessage msg = new PatientMessage("","",3,[1,2,3]);
	}

	
}
