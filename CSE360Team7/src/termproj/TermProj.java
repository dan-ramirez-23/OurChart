package termproj;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
	
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

	   
	   public void changeScene(String fxml) throws IOException {
		   Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		   stage.getScene().setRoot(pane);
	   }
	   
	   public static void main(String[] args)
	   {
	      Application.launch(args);
	   }
	

}
