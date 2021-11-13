package termproj;

public class MessageHandler {
	
	private PatientMessage msg;
	
	public MessageHandler(String subj, String body, String senderUN, String recipientUN) {
		msg = new PatientMessage(subj, body, senderUN, recipientUN);
	}
	
	
	public void sendMessage() {

		// for each recipient:
		UserManager umgr = new UserManager();
		umgr.readAllUsers();
		

		String recipientUN = msg.getRecipient();
		int recipientIndex = umgr.readUserIndex(recipientUN);
		umgr.getUserList().get(recipientIndex).addMessage(msg);
		umgr.writeAllUsers();
			


			
		
	}
	
	
	public PatientMessage[] loadMessages(String userType, int userID) {
		return null;
	}
}
