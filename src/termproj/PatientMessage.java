package termproj;

import java.io.Serializable;

public class PatientMessage implements Serializable {

	private String subject;
	private String messageBody;
	private boolean summary;
	private String senderID;

	public PatientMessage(String subj, String body, String sender) {
		subject = subj;
		messageBody = body;
		senderID = sender;
		summary = false;
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

	public PatientMessage(String subj, String body, String sender, boolean s) {
		subject = subj;
		messageBody = body;
		senderID = sender;
		summary = s;
	}

	/*
	 * public void setSubject(String subj) { subject = subj; } public String
	 * getSubject() { return subject; }
	 */
}
