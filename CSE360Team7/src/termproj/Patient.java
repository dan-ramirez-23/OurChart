package termproj;

public class Patient extends User {
	// private String firstName; contained in User class
	// private String lastName;
	private int patientID;
	private int Doctor;
	private String dob;
	private int phoneNumber;
	private String email;
	private String pharmacy;
	private String insurer;
	private String[] healthIssues;
	private String[] examFindings;
	private String recommendations;
	private double weight;
	private double height;
	private double bodyTemp;
	private double bloodPressure;
	private String[] allergies;
	private String[] healthConcerns;
	private String[] immunizations;
	private String[] prescriptions;
	private String[] medications;
	// private PatientMessage[] inbox;

	public Patient() {

	}

	public Patient(String fName, String lName, int id, int doc, String date,
			int pNum, String em, String pharm, String ins, String[] imm,
			String[] pres, String[] meds, PatientMessage[] ib, String[] hi,
			String[] ef, String rec, double w, double h, double bt, double bp,
			String[] aller, String[] hc) {

		super(fName, lName, ib);
		patientID = id;
		Doctor = doc;
		dob = date;
		phoneNumber = pNum;
		email = em;
		pharmacy = pharm;
		insurer = ins;
		immunizations = imm;
		prescriptions = pres;
		medications = meds;
		healthIssues = hi;
		examFindings = ef;
		recommendations = rec;
		weight = w;
		height = h;
		bodyTemp = bt;
		bloodPressure = bp;
		allergies = aller;
		healthConcerns = hc;

	}
}
