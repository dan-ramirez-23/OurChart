package termproj;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Doctor extends Employee {
	
	private int[] nurses;
	
	public Doctor() {
		
	}

	public Doctor(String fName, String lName, String un, String pass, int empID, int[] patients) {
		super(fName, lName, un, pass, empID, patients);
		
	}
}
