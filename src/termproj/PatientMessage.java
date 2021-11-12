package termproj;

import java.io.Serializable;

public class PatientMessage implements Serializable {

	private String subject;
	private String messageBody;
	private boolean summary;
	private String senderUN;
	private String recipient;

	public PatientMessage(String subj, String body, String sender, String recipient) {
		subject = subj;
		messageBody = body;
		senderUN = sender;
		this.recipient = recipient;
		summary = false;
	}

	public void setSenderUN(String id) {
		senderUN = id;
	}

	public String getSenderUN() {
		return senderUN;
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

	public String getRecipient() {
		return recipient;
	}
	
	public PatientMessage(String subj, String body, String sender, boolean s) {
		subject = subj;
		messageBody = body;
		senderUN = sender;
		summary = s;
	}

	/*
	 * public void setSubject(String subj) { subject = subj; } public String
	 * getSubject() { return subject; }
	 */
}
