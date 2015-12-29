import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {

	private String name;
	
	public Employee(String name) 
	{
		this.name = name;

	}
	
	public Employee(){
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	
		Employee employee = new Employee("jae");
		
		System.out.println("Please enter desired start date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String start = sc.nextLine();
		System.out.println("Please enter desired end date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String end = sc.nextLine();
		
		TimeWindow tw = new TimeWindow(start, end);
		//tw.getListOfDates();
	//	System.out.print(tw);
		
		List<LocalDate> timeList = tw.getListOfDates();
		List<WorkHourPerDay> workHrList = new ArrayList<WorkHourPerDay>();
		
		//workHrList.add(0, employee.name);
		for (LocalDate ld : timeList)
		{
			System.out.println("Enter work hour for " + ld.toString());
			double input = sc.nextDouble();
			
			
			WorkHourPerDay workHrObj = new WorkHourPerDay(ld, input);
			workHrList.add(workHrObj);
		}
		
		for (WorkHourPerDay wd : workHrList)
		{
			System.out.println(wd);
		}
		
	}
	
}
