import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class Deserializer {

	LinkedList<EmployeeWkHr> workHourListData;
	
	public LinkedList<EmployeeWkHr> deserialize()
	{
		
		FileInputStream fin;
		try {
			fin = new FileInputStream("data/workHourData.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			workHourListData = (LinkedList<EmployeeWkHr>) ois.readObject();
			ois.close();
			
			return workHourListData;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
