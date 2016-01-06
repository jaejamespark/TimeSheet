import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Serializer {
	
	public void serializeEmployeeData(Employee employee, String employeeName)
	{
			
		try {
			
			FileOutputStream fout = new FileOutputStream("data/Data.ser");
			//FileOutputStream fout = new FileOutputStream("data/" + employeeName + "_Data.ser");
			
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(employee);
			oos.close();
			System.out.println("Done");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
