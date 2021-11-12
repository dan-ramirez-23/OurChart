package termproj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientMessage implements Serializable {

	private String subject;
	private String messageBody;
	private boolean summary;
	private String senderID;
	private String dateSent;

	public PatientMessage(String subj, String body, String sender) {
		subject = subj;
		messageBody = body;
		senderID = sender;
		summary = false;
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy 'at' hh:mm:ss aa z");
		Date date = new Date(System.currentTimeMillis());
		dateSent = formatter.format(date);
	}

	public PatientMessage(String subj, String body, String sender, boolean s) {
		subject = subj;
		messageBody = body;
		senderID = sender;
		summary = s;
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy 'at' hh:mm:ss aa z");
		Date date = new Date(System.currentTimeMillis());
		dateSent = formatter.format(date);
	}
	public void setSenderUN(String id) {
		senderID = id;
	}

	public String getSenderUN() {
		return senderID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSummary(boolean s) {
		summary = s;
	}

	public boolean getSummary() {
		return summary;
	}

	public String getMessage() {
		return messageBody;
	}
	public String toString() {
		return dateSent;
	}
	

	/*
	 * public void setSubject(String subj) { subject = subj; } public String
	 * getSubject() { return subject; }
	 */
}
