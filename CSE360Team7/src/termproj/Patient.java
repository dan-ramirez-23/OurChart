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

	// setters

	public void setDoctor(int Doc) {
		Doctor = Doc;
	}

	public void setPhoneNum(int phoneNum) {
		phoneNumber = phoneNum;
	}

	public void setEmail(String Email) {
		email = Email;
	}

	public void setPharm(String Pharm) {
		pharmacy = Pharm;
	}

	public void setInsurer(String Insurer) {
		insurer = Insurer;
	}

	public void setImmunizations(String[] immun) {
		immunizations = immun;
	}

	public void setPrescriptions(String[] P) {
		prescriptions = P;
	}

	public void setMedications(String[] Meds) {
		medications = Meds;
	}

	public void setHealthIssues(String[] hi) {
		healthIssues = hi;
	}

	public void setExamFindings(String[] ef) {
		examFindings = ef;
	}

	public void setRecommendations(String rec) {
		recommendations = rec;
	}

	public void setWeight(double w) {
		weight = w;
	}

	public void setHeight(double h) {
		height = h;
	}

	public void setBodyTemp(double bt) {
		bodyTemp = bt;
	}

	public void setBloodPress(double bp) {
		bloodPressure = bp;
	}

	public void setAllergies(String[] aller) {
		allergies = aller;
	}

	public void setHealthConcerns(String[] hc) {
		healthConcerns = hc;
	}

	// getters

	public int getPatientID() {
		return patientID;
	}

	public int getDoctor() {
		return Doctor;
	}

	public String getDOB() {
		return dob;
	}

	public int getPhoneNum() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public String getInsurer() {
		return insurer;
	}

	public String[] getImmunizations() {
		return immunizations;
	}

	public String[] getPrescriptions() {
		return prescriptions;
	}

	public String[] getMedications() {
		return medications;
	}

	public String[] getHealthIssues() {
		return healthIssues;
	}

	public String[] getExamFindings() {
		return examFindings;
	}

	public String getRecs() {
		return recommendations;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	public double getBodyTemp() {
		return bodyTemp;
	}

	public double getBloodPress() {
		return bloodPressure;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public String[] getHealthConcerns() {
		return healthConcerns;
	}
}
