import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
	
	static int userInput = 0;
	static Scanner sc = new Scanner(System.in);
	
	static List<EmployeeWkHr> empList = new ArrayList<EmployeeWkHr>();
	static EmployeeWkHr empWkHr;
	
	public static void DisplayMenu()
	{
		
		do
		{
			System.out.println("***********************************");
			System.out.println("***********************************");
			System.out.println("[Please type in a digit to select]");
			System.out.println("1 - Add a new employee");
			System.out.println("2 - Remove an employee");
			System.out.println("3 - Input or edit work hour of an employee");
			System.out.println("4 - Save data");
			System.out.println("5 - Read data");
			
			userInput = sc.nextInt();
			
			switch(userInput)
			{
				case 1:
					AddEmployee();
					ShowEmployeeList();
					break;
				case 2:
					ShowEmployeeList();
					System.out.println("Provide name of employee that you want to remove");
					RemoveEmployee(FindEmployeeByName());
					ShowEmployeeList();
					break;
				case 3:
					ShowEmployeeList();
					AddWorkHour(FindEmployeeByName());
					break;
				case 4:

					break;
				case 5:

					break;
			}
		} while(userInput > 0 && userInput < 6);
	}
	
	public static void AddEmployee()
	{
		System.out.println("Provide new employee's name");
		String name = sc.next();
		empWkHr = new EmployeeWkHr(name);
		empList.add(empWkHr);
	}
	
	public static void ShowEmployeeList()
	{
		System.out.println("[Employee List]");
		for(EmployeeWkHr empWkHr : empList)
		{
			System.out.println(empWkHr.getEmployeeName());
		}
		System.out.print("\n");
	}
	
	public static int FindEmployeeByName()
	{
		String name = sc.next();
		int index = 0;
		int IndexOfTheEmp = 0;
		
		for(EmployeeWkHr empWkHr : empList)
		{
			String employeeName = empWkHr.getEmployeeName();
			if (employeeName.equals(name))
			{
				IndexOfTheEmp = index;
			}
			index++;
		}
		return IndexOfTheEmp;
	}
	
	public static void RemoveEmployee(int IndexOfTheEmp)
	{
		empList.remove(IndexOfTheEmp);
	}
	
	
	
	public static void AddWorkHour(int IndexOfTheEmp)
	{
		System.out.println("Please enter desired start date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String start = sc.nextLine();
		System.out.println("Please enter desired end date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String end = sc.nextLine();
		
		TimeWindow tw = new TimeWindow(start, end);
		
		LinkedList<LocalDate> timeList = tw.getListOfDates();
		
		// ????
		LinkedList<EmployeeWkHr> workHrList = new LinkedList<EmployeeWkHr>();
		
		EmployeeWkHr workHour = empList.get(IndexOfTheEmp);
		
		for (LocalDate ld : timeList)
		{
			System.out.println("Enter work hour for " + ld.toString());
			double input = sc.nextDouble();
			
			
			EmployeeWkHr workHrObj = new EmployeeWkHr("Jae", ld, input);
			workHrList.add(workHrObj);
		}
		
	}
}
