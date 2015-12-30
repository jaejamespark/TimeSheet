import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Serializer {

	public void serializeWorkHourData(LinkedList<EmployeeWkHr> workHourListData)
	{
		try {
			FileOutputStream fout = new FileOutputStream("data/workHourData.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(workHourListData);
			oos.close();
			System.out.println("Done");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
