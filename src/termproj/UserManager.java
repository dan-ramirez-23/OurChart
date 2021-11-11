package termproj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserManager {
	
	private ArrayList<User> userList = new ArrayList<>();
	
	public UserManager( ) {
		
	}
	public UserManager(ArrayList<User> uL) {
		userList = uL;
	}
	
	
	// get list of all Users from file
	public void readAllUsers() {//modified from PersonalFileReader
		File directory = new File("userData");//experimental
		if (!directory.exists()) {//checks to see if the directory exists
			directory.mkdir();//if not make the folder
		}
		try {
			File userFile = new File("userdata//users.txt");
			FileInputStream fi = new FileInputStream(userFile);
			ObjectInputStream oi = new ObjectInputStream(fi);

			userList = (ArrayList<User>) oi.readObject();

			oi.close();
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// get User by username (additional methods by user type?)
	public User readUserFromList(User u) {//modified from PersonalFileReader
		for(int i = 0; i < userList.size(); i++) {
			if(u.equals(userList.get(i).username)) {
				User usr = userList.get(i);
				System.out.println(usr.toString());
				return usr;
			}
		}
		return null;

	}
	
	// add new User to global list
	public void addUserToList(User u) {
		userList.add(u);
	}
	
	// return userList
	public ArrayList<User> getUserList() {
		return userList;
	}
	
	// write global list to file 
	public void writeUserToSingleFile(User usr, ArrayList<User> ul) {//same function from PersonalFileWriter
		try {
			// fName = "userdata//" + usr.getUsername() + ".txt";
			// System.out.print(fName);
			// URL url = getClass().getResource(fName);
			// System.out.print(url);
			File directory = new File("userData");
			if (!directory.exists()) {
				directory.mkdir();
			}
			File empFile = new File("userdata//users.txt");
			FileOutputStream f = new FileOutputStream(empFile);
			ObjectOutputStream o = new ObjectOutputStream(f);

			ul.add(usr);
			o.writeObject(ul);

			o.close();
			f.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}