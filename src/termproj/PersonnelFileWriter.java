package termproj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonnelFileWriter {

	private String fName;
	private ArrayList<User> userList = new ArrayList<>();

	public PersonnelFileWriter() {

	}

	// public PersonnelFileWriter(ArrayList<User> uL) {
	// userList = uL;
	// }

	public void writePatient() {

	}

	public void writeUser(User usr) {
		try {
			fName = "userdata//" + usr.getUsername() + ".txt";
			System.out.print(fName);
			// URL url = getClass().getResource(fName);
			// System.out.print(url);
			File empFile = new File(fName);
			FileOutputStream f = new FileOutputStream(empFile);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(usr);

			o.close();
			f.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeUserToSingleFile(User usr, ArrayList<User> ul) {
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
