package termproj;

import java.util.ArrayList;

public class Pages {
	protected ArrayList<User> userList;
	protected String username;
	protected UserManager umgr;
	
	public Pages() {
		username = "";
		userList = new ArrayList<>();
		umgr = new UserManager();
	}
	public Pages(String un, ArrayList<User> ul, UserManager umgr) {
		username = un;
		userList = ul;
		this.umgr = umgr;
	}
}
