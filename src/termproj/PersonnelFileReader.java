package termproj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.net.URL;

public class PersonnelFileReader {
	
	private String fName;
	

	public PersonnelFileReader(String username) {
		fName = "userdata//" + username + ".txt";
	}
	
	
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
}
