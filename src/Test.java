import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args)
	{
		DisplayMenu dm = new DisplayMenu();
		dm.DisplayMenu();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter desired start date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String start = sc.nextLine();
		System.out.println("Please enter desired end date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String end = sc.nextLine();
		
		TimeWindow tw = new TimeWindow(start, end);
		
		ArrayList<LocalDate> timeList = tw.getListOfDates();
		LinkedList<EmployeeWkHr> workHrList = new LinkedList<EmployeeWkHr>();
		
		for (LocalDate ld : timeList)
		{
			System.out.println("Enter work hour for " + ld.toString());
			double input = sc.nextDouble();
			
			
			//EmployeeWkHr workHrObj = new EmployeeWkHr("Jae", ld, input);
			//workHrList.add(workHrObj);
		}
		
		Serializer sz = new Serializer();
		sz.serializeWorkHourData(workHrList);
		
		for (EmployeeWkHr wd : workHrList)
		{
			System.out.println(wd);
		}
		
		
		System.out.println("deserilizing...");
		
		Deserializer ds = new Deserializer();
		LinkedList<EmployeeWkHr> workHrFromData = ds.deserialize();
		
		for (EmployeeWkHr wd : workHrFromData)
		{
			System.out.println(wd);
		}
		
	}
}
