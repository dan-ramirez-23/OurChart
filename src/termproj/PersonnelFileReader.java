package termproj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;

public class PersonnelFileReader {
	
	private String fName;
	
	//private ArrayList<User> userList= new ArrayList<>();//stores a list of users, needed to only store one file
	private String un;
	
	public PersonnelFileReader() {
		
	}
	public PersonnelFileReader(String username) {
		fName = "userdata//" + username + ".txt";
		un = username;
	}
	/*public PersonnelFileReader(ArrayList<User> uL) {//not needed
		userList = uL;
	}*/
	public void setFName(String username) {
		fName = "userdata//" + username + ".txt";
		un = username;
	}
	/*public void setUserList(ArrayList<User> uL) {//not needed
		userList = uL;
	}*/
	
	public User readUser() {

		try {
			File userFile = new File(fName);
			FileInputStream fi = new FileInputStream(userFile);
			ObjectInputStream oi = new ObjectInputStream(fi);

			User usr = (User) oi.readObject();

			System.out.println(usr.toString());
			
			oi.close();
			fi.close();
			
			return usr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	//searches for 1 file with all users puts that into an array list of users,
	//then searches for the user with the given username within the list of all users.
	//after that returns the user, if the user is not in the list returns null(for now)
	public User readUserFromList() {

		try {
			File userFile = new File("userdata//users.txt");
			FileInputStream fi = new FileInputStream(userFile);
			ObjectInputStream oi = new ObjectInputStream(fi);

			ArrayList<User> usrList = (ArrayList<User>) oi.readObject();

			for(int i = 0; i < usrList.size(); i++) {
				if(un.equals(usrList.get(i).username)) {
					oi.close();
					fi.close();
					User usr = usrList.get(i);
					System.out.println(usr.toString());
					return usr;
				}
			}
			
			
			oi.close();
			fi.close();
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
