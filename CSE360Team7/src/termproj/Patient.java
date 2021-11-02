package termproj;

public class Patient extends User {
	private String firstName;
	private String lastName;
	private int patientID;
	private int Doctor;
	private String dob;
	private int phoneNumber;
	private String email;
	private String pharmacy;
	private String insurer;
	private String[] immunizations;
	private String[] prescriptions;
	private PatientMessage[] inbox;
	
	public Patient() {
		
	}
}
