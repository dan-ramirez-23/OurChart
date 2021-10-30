package termproj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;

public class PersonnelFileWriter {
	
	private String fName;
	
	public PersonnelFileWriter() {
		
	}
	
	
	
	public void writePatient() {
		
	}
	
	
	public void writeEmployee(Employee emp) {
		try {
			fName = emp.getUsername() + ".txt";
			URL url = getClass().getResource(fName);
			File empFile = new File(url.getPath());
			FileOutputStream f = new FileOutputStream(empFile);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(emp);

			o.close();
			f.close();
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
