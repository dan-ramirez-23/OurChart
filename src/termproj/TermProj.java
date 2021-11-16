package termproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TermProj extends Application {

	private static final int WIDTH = 550;
	private static final int HEIGHT = 400;
	private static Stage stage;
	private ArrayList<User> userList = new ArrayList<>();// created to make sure
															// there are no null
															// pointer
															// exceptions
	private ArrayList<Doctor> doctorList = new ArrayList<>();
	private UserManager um = new UserManager(userList);

	public void start(Stage primaryStage) throws Exception {
		//hardcode();
		stage = primaryStage;
		/*
		 * FXMLLoader loader = new FXMLLoader();
		 * loader.setLocation(getClass().getResource("LoginPane.fxml"));
		 * LoginPage startPage = new LoginPage();
		 * loader.setController(startPage); Parent root = loader.load();
		 */
		Parent root = FXMLLoader.load(getClass().getResource("LoginPane.fxml"));
		primaryStage.setTitle("Pediatric Office System");
		primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
		primaryStage.show(); // Display the stage
	}
	

	public void changeScene(String fxml, String username) throws IOException {
		//hardcode();
		um.readAllUsers();// idk why we need to read them twice, but we do
		FXMLLoader loader = new FXMLLoader();
		Pages pageController = null;
		if (fxml.equals("NursePane.fxml")) {
			pageController = new NursePage(username, um.getUserList(), um);
		} else if (fxml.equals("DoctorPane.fxml")) {
			pageController = new DoctorPage(username, um.getUserList(), um);
		} else if (fxml.equals("PatientPane.fxml")) {
			pageController = new PatientPage(username, um.getUserList(), um);
		}

		loader.setLocation(getClass().getResource(fxml));
		loader.setController(pageController);
		Parent pane = loader.load();

		// Parent pane = loader.load(getClass().getResource(fxml));
		stage.setScene(new Scene(pane, WIDTH + 300, HEIGHT + 150));
		// stage.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void hardcode() {

		ArrayList<Patient> allPats = new ArrayList<Patient>();
		ArrayList<Patient> docPats = new ArrayList<Patient>();

		String[] im1 = { "Chicken Pox", "COVID-19", "HPV", "Rotavirus", "Polio" };
		String[] im2 = { "Chicken Pox", "HPV", "Rotavirus", "Polio" };
		String[] per1 = { "Atorvastatin", "Metformin" };
		String[] per2 = { "Insulin" };
		String[] per = { "N/A" };
		String[] med1 = { "Atorvastatin", "Metformin", "Niacin" };
		String[] med2 = { "Insulin" };
		String[] med = { "N/A" };
		String[] hi1 = { "High cholesterol", "High blood pressure" };
		String[] hi2 = { "Type 2 Diabetes" };
		String[] hi = { "N/A" };
		String[] ef1 = { "LDL: 193", "HDL: 45", "Triglycerides: 435" };
		String[] ef1_5 = { "LDL: 133", "HDL: 95", "Triglycerides: 82" };
		String[] ef2 = { "A1C Level: 7.1%" };
		String[] ef3 = { "LDL: 198", "HDL: 37", "Triglycerides: 482", "A1C: 5.3%" };
		String[] alrg = { "N/A" };
		String[] alrg1 = { "Latex", "Tree Nuts" };
		String[] hc2 = { "N/A" };
		String[] hc1 = { "Weight", "High blood-pressure", "High cholestorol", "Diet", "Use of Alcohol" };
		int numOfDoctors = doctorList.size();

		Patient pat1 = new Patient("Anthony", "Freaks", 002, 293, "06/21/99",
				"(972)658-4598", "HxH@gmail.com", "Walgreens", "afreaks",
				"password", "United Health", im1, per2, med2, hi2, ef2, "Stay aware of your sugar levels", 150.33, 6.2,
				98.9, "120/80", alrg, hc2);
		
		Patient pat3 = new Patient("Bob", "Ross", 003, 102, "03/01/99",
				"(602)652-2598", "ASU@gmail.com", "Walgreens", "bross","password", "United Health",
				im1, per, med, hi, ef1_5, "Overall Very healthy!", 173.53, 6.4,
				97.9, "123/79", alrg, hc2);

		Patient pat2 = new Patient("Troy", "Diaz", 001, 102, "03/16/00",
				"(602)391-5618", "Tray.Diaz@gmail.com", "CVS", "tdiaz", "password",
				"Blue Cross Blue Shield", im2, per1, med1, hi1, ef3, "Continue to get physical activity & eat healthy",
				230.2, 5.9, 98.2, "148/93", alrg1, hc1);
		
		Patient pat4 = new Patient("Sidney", "Wall", 004, 293, "12/31/01",
				"(602)481-2186", "Sideney.Wall@gmail.com", "CVS", "swall", "password",
				"Blue Cross Blue Shield", im1, per1, med1, hi1, ef1, "Continue to get physical activity & eat healthy",
				109.12, 5.3, 98.4, "148/93", alrg1, hc1);

		um.addUserToList(pat2);
		um.addUserToList(pat1);
		um.addUserToList(pat3);
		um.addUserToList(pat4);
		Doctor doc1 = new Doctor("Hannah", "Kaufman", "hjkaufma", "password",102);
		Doctor doc2 = new Doctor("Audrey", "Wong", "awong24", "password", 293);
		Nurse nur1 = new Nurse("Jackson", "Carrion", "jtcarrio", "password",900);
		Nurse nur2 = new Nurse("Dan", "Ramirez", "darami14", "password", 032);
		Nurse nur3 = new Nurse("Sebastian", "Diaz", "sdiazgu", "password", 669);

		doc1.addPatient(pat2);
		doc2.addPatient(pat1);
		doc1.addPatient(pat3);
		doc2.addPatient(pat4);

		for (int i = 0; i < um.getUserList().size(); i++) {// add all patients
															// to all nurses
			if (um.getUserList().get(i).getUserType().equals("Patient")) {
				nur1.addPatient((Patient) um.getUserList().get(i));
				nur2.addPatient((Patient) um.getUserList().get(i));
			}
		}

		um.addUserToList(doc1);
		um.addUserToList(nur1);
		um.addUserToList(doc2);
		um.addUserToList(nur2);
		um.addUserToList(nur3);

		PatientMessage msg1 = new PatientMessage("test message subject",
				"test message body", "jtcarrio","darami14");
		PatientMessage msg2 = new PatientMessage("test message 2 subject",
				"test message 2 body", "hjkaufma","darami14");
		PatientMessage msg3 = new PatientMessage("test message 3 subject",
				"test message 3 body", "awong24","darami14");
		nur2.addMessage(msg1);
		nur2.addMessage(msg2);
		nur2.addMessage(msg3);

		um.writeAllUsers();// testing with writing to file
	}

}
