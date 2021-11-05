package termproj;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;


public class LoginPage {
	public LoginPage() {
	}
	
	
	@FXML
	private Button button;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ComboBox<String> userType;
	@FXML
	private Label wrongLogIn;
	
	
	@FXML
	public void initialize() {
		userType.getItems().addAll("Doctor","Nurse","Patient");
		userType.getSelectionModel().select("Patient");
		button.defaultButtonProperty().bind(button.focusedProperty());
	}
	
	
	public void logIn(ActionEvent event) throws IOException {
		auth();
	}
	
	
	//test comment
	private void auth() throws IOException {
		TermProj window = new TermProj();
		String userInput = username.getText();
		String passInput = password.getText();
		String uTypeInput = userType.getValue().toString();
		
		try {
			String authFile = "src//termproj//" + uTypeInput + "Logins.txt";
			File authorFile = new File(authFile);
			boolean loginFound = false;
			FileReader fr = new FileReader(authorFile);
			BufferedReader br = new BufferedReader(fr);
			String line, user, pass, uType;
			String[] lineArray;
			
			while((line = br.readLine()) != null) {
				lineArray = line.split(",");
				user = lineArray[0];
				pass = lineArray[1];
				uType = lineArray[2];
				
				if(userInput.equals(user) && passInput.equals(pass) && uTypeInput.equals(uType)) {
					String fxml = uType + "Pane.fxml";
					window.changeScene(fxml, user);					
				}
				
				else if(username.getText().isEmpty() && password.getText().isEmpty()) {
					wrongLogIn.setText("Please enter your username or password.");
				}
				
				else {
					
					wrongLogIn.setText("Wrong username or password");
				}
			}
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
}
