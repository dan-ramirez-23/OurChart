package termproj;

import java.util.ArrayList;

public class Pages {
	protected ArrayList<User> userList;
	protected ArrayList<User> patientList;
	protected ArrayList<User> docList;
	protected String username;
	
	public Pages() {
		username = "";
		userList = new ArrayList<>();
	}
	
	public Pages(String un, ArrayList<User> ul) {
		username = un;
		userList = ul;
	}
}
