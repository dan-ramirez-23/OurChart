package termproj;

public class MessageHandler {
	
	private PatientMessage msg;
	
	public MessageHandler(String subj, String body, String senderUN, String[] recipients) {
		msg = new PatientMessage(subj, body, senderUN, recipients);
	}
	
	
	public void sendMessage() {

		// for each recipient:
		for(String recipient : msg.getRecipients()) {
			// read file
			
			
			// add message to recipient inbox
			
			// write file
		}
			
		
	}
	
	
	public PatientMessage[] loadMessages(String userType, int userID) {
		return null;
	}
}
