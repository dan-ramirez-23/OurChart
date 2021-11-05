package termproj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

public class PersonnelFileWriter {
	
	private String fName;
	private ArrayList<User> userList= new ArrayList<>();
	
	public PersonnelFileWriter() {
		
	}
	public PersonnelFileWriter(ArrayList<User> uL) {
		userList = uL;
	}
	
	
	
	public void writePatient() {
		
	}
	
	
	public void writeUser(User usr) {
		try {
			fName = "userdata//" + usr.getUsername() + ".txt";
			System.out.print(fName);
			//URL url = getClass().getResource(fName);
			//System.out.print(url);
			File empFile = new File(fName);
			FileOutputStream f = new FileOutputStream(empFile);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(usr);

			o.close();
			f.close();
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
