package termproj;

public class PatientMessage {
	
	private String subject;
	private String messageBody;
	private String senderID;
	private String[] recipients;
	
	public PatientMessage(String subj, String body, String sender, String[] recipients) {
		subject = subj;
		messageBody = body;
		senderID = sender;
		this.recipients = recipients;
	}
	
	
	public void setSenderUN(String id) {
		senderID = id;
	}
	public String getSenderUN() {
		return senderID;
	}
	
	public String[] getRecipients() {
		return recipients;
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
