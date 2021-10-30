package termproj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.net.URL;

public class PersonnelFileReader {
	
	private String fName;
	

	public PersonnelFileReader(String username) {
		fName = username + ".txt";
	}
	
	
	public Employee readEmployee() {

		try {
			URL url = getClass().getResource(fName);
			File empFile = new File(url.getPath());
			FileInputStream fi = new FileInputStream(empFile);
			ObjectInputStream oi = new ObjectInputStream(fi);

			Employee emp = (Employee) oi.readObject();

			System.out.println(emp.toString());
			
			oi.close();
			fi.close();
			
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
