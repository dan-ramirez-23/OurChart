package termproj;

import java.io.Serializable;

public class PatientMessage implements Serializable {
	
	private String subject;
	private String messageBody;
	private String senderID;
	
	public PatientMessage(String subj, String body, String sender) {
		subject = subj;
		messageBody = body;
		senderID = sender;
	}
	
	
	public void setSenderUN(String id) {
		senderID = id;
	}
	public String getSenderUN() {
		return senderID;
	}

	
	/*
	public void setSubject(String subj) {
		subject = subj;
	}
	public String getSubject() {
		return subject;
	}
*/	
}
