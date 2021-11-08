package termproj;

public class MessageHandler {
	
	private PatientMessage msg;
	
	public MessageHandler(String subj, String body, String senderUN) {
		msg = new PatientMessage(subj, body, senderUN);
	}
	
	
	public void sendMessage() {

		// for each recipient:
		//for() {
			// read file
			//System.out.println("in MessageHandler's sendMessage() - read file of " + recipient);
			PersonnelFileReader pfr = new PersonnelFileReader("bhicks");
			User recipient = pfr.readUser();
			
			
			System.out.println("adding message from user " + msg.getSenderUN() + 
					"\n to user bhicks (recipient hardcoded)");
			System.out.println("Recipient inbox before:" + recipient.inbox);
			
			// add message to recipient inbox
			recipient.addMessage(msg);
			System.out.println("Recipient inbox after:" + recipient.inbox);
			
			// write file
			PersonnelFileWriter pfw = new PersonnelFileWriter();
			pfw.writeUser(recipient);
		//}
			
		
	}
	
	
	public PatientMessage[] loadMessages(String userType, int userID) {
		return null;
	}
}
