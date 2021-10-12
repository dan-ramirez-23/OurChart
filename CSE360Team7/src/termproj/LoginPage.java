package termproj;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
	

public class LoginPage {
	public LoginPage() {
		
	}
	
	
	
	@FXML
	private Button button;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	
	public void logIn(ActionEvent event) throws IOException {
		auth();
	}
	
	
	private void auth() throws IOException {
		TermProj window = new TermProj();
		String userInput = username.getText();
		String passInput = password.getText();
		
		try {
			String authFile = "C:\\Users\\danra\\git\\CSE360Team7\\CSE360Team7\\src\\termproj\\userLogins.txt";
			boolean loginFound = false;
			BufferedReader br = new BufferedReader(new FileReader(authFile));
			String line, user, pass, userType, personnelFile;
			String[] lineArray;
			
			while((line = br.readLine()) != null) {
				lineArray = line.split(",");
				user = lineArray[0];
				pass = lineArray[1];
				userType = lineArray[2];
				personnelFile = lineArray[3];
				
				if(userInput.equals(user) && passInput.equals(pass)) {
					String fxml = userType + "Pane.fxml";
					window.changeScene(fxml);					
				}
				else {
					// add a prompt for incorrect login input?
				}
			}
			br.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
