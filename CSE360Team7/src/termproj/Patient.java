package termproj;

public class Patient extends User {
	//private String firstName; contained in User class
	//private String lastName;
	private int patientID;
	private int Doctor;
	private String dob;
	private int phoneNumber;
	private String email;
	private String pharmacy;
	private String insurer;
	private String[] immunizations;
	private String[] prescriptions;
	//private PatientMessage[] inbox;
	
	public Patient() {
		
	}
	public Patient(String fName, String lName, int id, int doc, String date, int pNum, String em, String pharm, String ins, String[] imm, String[] pres, PatientMessage[] ib) {
		super(fName, lName, ib);
		patientID= id;
		Doctor = doc;
		dob = date;
		phoneNumber = pNum;
		email = em;
		pharmacy = pharm;
		insurer= ins;
		immunizations = imm;
		prescriptions = pres;
	}
}
