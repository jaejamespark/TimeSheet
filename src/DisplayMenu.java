import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
	
	static int userInput = 0;
	static Scanner sc = new Scanner(System.in);
	
	static List<Employee> empList = new ArrayList<Employee>();
	static EmployeeWkHr empWkHr;
	static Employee employee;
	
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
					System.out.println("Provide name of employee that you want to add/edit work hour");
					AddWorkHour(FindEmployeeByName());
					ShowEmployeeList();
					break;
				case 4:
					System.out.println("Provide name of employee that you want to save");
					int emp = FindEmployeeByName();
					Serializer serial = new Serializer();
					serial.serializeEmployeeData(empList.get(emp), empList.get(FindEmployeeByName()).getEmployeeName());
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
		System.out.println("Provide the year");
		String year = sc.next();
		
		employee = new Employee(name, year);
		empList.add(employee);
	}
	
	public static void ShowEmployeeList()
	{
		System.out.println("[Employee List]");
		for(Employee employee : empList)
		{
			System.out.println(employee);
		}
		System.out.print("\n");
	}
	
	public static int FindEmployeeByName()
	{
		String name = sc.next();
		int index = 0;
		int IndexOfTheEmp = 0;
		
		for(Employee employee : empList)
		{
			String employeeName = employee.getEmployeeName();
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
		
		Employee employee = empList.get(IndexOfTheEmp);
	
		
		System.out.println("Please enter desired date in format of YYYY-MM-DD (Ex: 2015-11-28)");
		String date = sc.next();
		
		System.out.println("Please enter work hour");
		String workHour = sc.next();
		
		LocalDate editDate = LocalDate.parse(date);
		
		ArrayList<EmployeeWkHr> empWkHrList = employee.getListOfEmpWkHr();
		
		for (EmployeeWkHr empWkHr : empWkHrList)
		{

			if(empWkHr.getLocalDate().getDayOfYear() == (editDate.getDayOfYear()))
			{
				empWkHr.setWorkHour(Double.parseDouble(workHour));
			}
		}
	}
}
