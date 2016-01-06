import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String employeeName;
	ArrayList<LocalDate> listOfDays;
	ArrayList<EmployeeWkHr> listOfEmpWkHr;

	
	public Employee(String employeeName, String year)
	{
		this.employeeName = employeeName;
		
		TimeWindow timeWindow = new TimeWindow(year);
		listOfDays = timeWindow.getListOfDates();

		listOfEmpWkHr = new ArrayList<EmployeeWkHr>();
		
		for (LocalDate dates : listOfDays)
		{
			EmployeeWkHr employeeWkHr = new EmployeeWkHr();
			
			employeeWkHr.setYear(dates.getYear());
			employeeWkHr.setMonth(dates.getMonthValue());
			employeeWkHr.setDate(dates.getDayOfMonth());
			employeeWkHr.setDayOfWeek(dates.getDayOfWeek());
			
			listOfEmpWkHr.add(employeeWkHr);
		}
	}
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public ArrayList<EmployeeWkHr> getListOfEmpWkHr() {
		return listOfEmpWkHr;
	}

	public void setListOfEmpWkHr(ArrayList<EmployeeWkHr> listOfEmpWkHr) {
		this.listOfEmpWkHr = listOfEmpWkHr;
	}


	public String toString()
	{
		String a = "Employee Name: " + employeeName + "\n";
		String b = "";
		
		for (EmployeeWkHr empWkHr : listOfEmpWkHr)
		{
			b += empWkHr.toString();
		}

		return a + b;
	}
}
