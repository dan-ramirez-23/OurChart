package termproj;

import java.util.ArrayList;

public class Patient extends User {
	// private String firstName; contained in User class
	// private String lastName;
	private int patientID;
	private int doctor;
	private String dob;
	private String phoneNumber;
	private String email;
	private String pharmacy;
	private String insurer;
	private ArrayList<String> healthIssues;
	private ArrayList<String> examFindings;
	private String recommendations;
	private double weight;
	private double height;
	private double bodyTemp;
	private double bloodPressure;
	private ArrayList<String> allergies;
	private ArrayList<String> healthConcerns;
	private ArrayList<String> immunizations;
	private ArrayList<String> prescriptions;
	private ArrayList<String> medications;
	// private PatientMessage[] inbox;

	
	public Patient(String fName, String lName, int id, String date, String em, String pNum, String pharm, String ins) 
	{
		/*super(fName, lName, "Patient");
		patientID = id;
		dob = date;
		email = em;
		phoneNumber = pNum;
		pharmacy = pharm;
		insurer = ins;*/
		super(fName, lName, "Patient", "", "", -1);
		patientID = id;
		doctor = -1;
		dob = date;
		phoneNumber = pNum;
		email = em;
		pharmacy = pharm;
		insurer = ins;
		immunizations = new ArrayList<>();
		immunizations.set(0, "");
		prescriptions = new ArrayList<>();
		immunizations.set(0, "");
		medications = new ArrayList<>();
		medications.set(0, "");
		healthIssues = new ArrayList<>();
		healthIssues.set(0, "");
		examFindings = new ArrayList<>();
		examFindings.set(0, "");
		recommendations = "";
		weight = -1;
		height = -1;
		bodyTemp = -1;
		bloodPressure = -1;
		allergies = new ArrayList<>();
		allergies.set(0, "");
		healthConcerns = new ArrayList<>();
		healthConcerns.set(0, "");
	
	}

	public Patient(String fName, String lName, int id, int doc, String date,
			String pNum, String em, String pharm, String un, String pass, String ins, String[] imm, String[] pres, 
			String[] meds, String[] hi, String[] ef, String rec, double w, double h, 
			double bt, double bp, String[] aller, String[] hc) {

		super(fName, lName, "Patient", un, pass, id);
		patientID = id;
		doctor = doc;
		dob = date;
		phoneNumber = pNum;
		email = em;
		pharmacy = pharm;
		insurer = ins;
		immunizations = new ArrayList<>();
		for(int i = 0; i < imm.length; i++) {
			immunizations.add(imm[i]);
		}
		prescriptions = new ArrayList<>();
		for(int i = 0; i < pres.length; i++) {
			prescriptions.add(pres[i]);
		}
		medications = new ArrayList<>();
		for(int i = 0; i < meds.length; i++) {
			medications.add(meds[i]);
		}
		healthIssues = new ArrayList<>();
		for(int i = 0; i < hi.length; i++) {
			healthIssues.add(hi[i]);
		}
		examFindings = new ArrayList<>();
		for(int i = 0; i < ef.length; i++) {
			examFindings.add(ef[i]);
		}
		recommendations = rec;
		weight = w;
		height = h;
		bodyTemp = bt;
		bloodPressure = bp;
		allergies = new ArrayList<>();
		for(int i = 0; i < aller.length; i++) {
			allergies.add(aller[i]);
		}
		healthConcerns = new ArrayList<>();
		for(int i = 0; i < hc.length; i++) {
			healthConcerns.add(hc[i]);
		}

	}

	// setters

	public void setPatientID(int ID) {
		super.id = ID;
		patientID = ID;
	}
	public void setDoctor(int Doc) {
		doctor = Doc;
	}

	public void setPhoneNum(String phoneNum) {
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

	public void setImmunizations(ArrayList<String> immun) {
		immunizations = immun;
	}

	public void setPrescriptions(ArrayList<String> P) {
		prescriptions = P;
	}

	public void setMedications(ArrayList<String> Meds) {
		medications = Meds;
	}

	public void setHealthIssues(ArrayList<String> hi) {
		healthIssues = hi;
	}

	public void setExamFindings(ArrayList<String> ef) {
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

	public void setAllergies(ArrayList<String> aller) {
		allergies = aller;
	}

	public void setHealthConcerns(ArrayList<String> hc) {
		healthConcerns = hc;
	}

	public void setUserName(String un) {
		super.username=un;
	}
	
	public void setPassword(String pw) {
		super.password=pw;
	}
	// getters
	
	/*public String getfName() {//use User versions
		return super.firstName;
	}
	
	public String getlName() {
		return super.lastName;
	}*/

	public int getPatientID() {
		return patientID;
	}

	public int getDoctor() {
		return doctor;
	}

	public String getDOB() {
		return dob;
	}

	public String getPhoneNum() {
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

	public ArrayList<String> getImmunizations() {
		return immunizations;
	}

	public ArrayList<String> getPrescriptions() {
		return prescriptions;
	}

	public ArrayList<String> getMedications() {
		return medications;
	}

	public ArrayList<String> getHealthIssues() {
		return healthIssues;
	}

	public ArrayList<String> getExamFindings() {
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

	public ArrayList<String> getAllergies() {
		return allergies;
	}

	public ArrayList<String> getHealthConcerns() {
		return healthConcerns;
	}

}
