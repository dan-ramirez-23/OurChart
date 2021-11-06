package termproj;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
	
public class TermProj extends Application {

	   private final int WIDTH = 550;
	   private final int HEIGHT = 400;
	   private static Stage stage;

	   public void start(Stage primaryStage) throws Exception
	   {
	      stage = primaryStage;
		  Parent root = FXMLLoader.load(getClass().getResource("LoginPane.fxml"));
		  primaryStage.setTitle("Pediatric Office System");
		  primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
	      primaryStage.show(); // Display the stage
	   }

	   
	   public void changeScene(String fxml, String username) throws IOException {
		   FXMLLoader loader = new FXMLLoader();
		   Pages pageController = null;
		   if(fxml.equals("NursePane.fxml")) {
			   pageController = new NursePage(username);//needs to change depending on the page required
		   }
		   else if (fxml.equals("DoctorPane.fxml")) {
			   pageController = new DoctorPage(username);
		   }
		   else if (fxml.equals("PatientPane.fxml")) { 
			   pageController = new PatientPage(username);
		   }
		   
		   
		   loader.setLocation(getClass().getResource(fxml));
		   loader.setController(pageController);
		   Parent pane = loader.load();
		   
		   //Parent pane = loader.load(getClass().getResource(fxml));
		   stage.getScene().setRoot(pane);
	   }
	   
	   public static void main(String[] args)
	   {
	      Application.launch(args);
	   }
	   
	   public void hardcode() {
		   ArrayList <User> doctorList, userList;
		   doctorList = new ArrayList <User> ();
		   userList = new ArrayList <User> ();
		   Doctor doc = new Doctor("Hannah", "Kaufman", "hjkaufma", "password", 102, int[] patients);
		   Doctor doc = new Doctor("Jackson", "Carrion", "jtcarrio", "password", 900, int[] patients);
		   Doctor doc = new Doctor("Dan", "Ramirez", "darami14", "password", 032, int[] patients);
		   Nurse nur = new Nurse("Audrey", "Wong", "awong24", "password", 293, int[] patients);
		   Nurse nur = new Nurse("Sebastian", "Aguilar", "sdiazagu", "password", 289, int[] patients);
		  
	   }

}
