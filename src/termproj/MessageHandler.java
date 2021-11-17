package termproj;

public class MessageHandler {
	
	private PatientMessage msg;
	
	public MessageHandler(String subj, String body, String senderUN, String recipientUN) {
		msg = new PatientMessage(subj, body, senderUN, recipientUN);
	}
	
	
	public void sendMessage() {

		UserManager umgr = new UserManager();
		umgr.readAllUsers();
		

		String recipientUN = msg.getRecipient();
		int recipientIndex = umgr.readUserIndex(recipientUN);
		umgr.getUserList().get(recipientIndex).addMessage(msg);
		umgr.writeAllUsers();
	}
	
	
	
	public void sendMessage(boolean copyNurses) {

		UserManager umgr = new UserManager();
		umgr.readAllUsers();
		

		String recipientUN = msg.getRecipient();
		int recipientIndex = umgr.readUserIndex(recipientUN);
		umgr.getUserList().get(recipientIndex).addMessage(msg);
		
		
		for(User usr : umgr.getUserList()) {
			if(usr.getUserType().equals("Nurse")) {
				usr.addMessage(msg);
			}
		}
		
		
		umgr.writeAllUsers();

	}
	
	
	
	public void copyNurses() {
		UserManager umgr = new UserManager();
		umgr.readAllUsers();
		
		for(User usr : umgr.getUserList()) {
			if(usr.getUserType().equals("Nurse")) {
				System.out.println("copying message to " + usr.getUsername());
				usr.addMessage(msg);
			}
		}
		

		String recipientUN = msg.getRecipient();
		int recipientIndex = umgr.readUserIndex(recipientUN);
		umgr.getUserList().get(recipientIndex).addMessage(msg);
		umgr.writeAllUsers();
	}
 	
	
	public PatientMessage[] loadMessages(String userType, int userID) {
		return null;
	}
}
