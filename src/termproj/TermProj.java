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
	   private ArrayList<User> userList = new ArrayList<User>();
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
		   ArrayList <Patient> allPats = new ArrayList <Patient>();
		   ArrayList <Patient> docPats = new ArrayList <Patient>();
		   Doctor doc1 = new Doctor("Hannah", "Kaufman", "hjkaufma", "password", 102, docPats);
		   Doctor doc2 = new Doctor("Audrey", "Wong", "awong24", "password", 293, docPats);
		   Nurse nur1 = new Nurse("Jackson", "Carrion", "jtcarrio", "password", 900, allPats);
		   Nurse nur2 = new Nurse("Dan", "Ramirez", "darami14", "password", 032, allPats);
		   String[] im={"Chicken Pox", "COVID-19"};
		   String[] per={"Marijuana"};
		   String[] med={"N/A"};
		   String[] hi={"Just a boss ass bitch"};
		   String[] ef={"N/A"};
		   String[] alrg={"Cats", "Broke Bitches", "Anything that isnt money"};
		   String[] hc = {"He is to real"};
		   
		   Patient pat2 = new Patient("Sebastian", "Aguilar", 001, 1, "031621", "6023915618", 
				   "ass@gmail.com" , "CVS", "sdiazagu",im, per, med,
				   hi, ef, "Stay up cuzzo", 289.2, 6.7, 98.2, 170.3, alrg, hc );
		  
		   userList.add(doc1);
		   userList.add(nur1);
		   userList.add(doc2);
		   userList.add(nur2);
		   userList.add(pat2);
	   }

}
