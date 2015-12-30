import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * This object contains employee name, work hours, and overtime hours on a corresponding date
 * (Ex: Jae 12-28-2015 WorkHour: 10Hr OverTimeHour: 2Hr)
 * @author cycas
 *
 */

public class EmployeeWkHr implements Serializable{

	final private double regularDailyWorkHour = (long) 8;
	
	private String employeeName;
	private int year;
	private int month;
	private int date;
	private DayOfWeek dayOfWeek;
	private double workHour;
	private double overTimeHour;
	
	public EmployeeWkHr(String employeeName, LocalDate date, double workHour) 
	{
		// input date must be in format of MM-dd-yyyy
		//LocalDate workDate = LocalDate.parse(date);
		this.employeeName = employeeName;
		this.year = date.getYear();
		this.month = date.getMonthValue();
		this.date = date.getDayOfMonth();
		this.dayOfWeek = date.getDayOfWeek();
		
		
		// set work hour
		this.workHour = workHour;
		
		// calculate overtime if worked more than or equal to 8 hours
		if(workHour >= regularDailyWorkHour) 
		{
			this.overTimeHour = workHour - regularDailyWorkHour;
			
		} else 
		{
			this.overTimeHour = 0;
		}
	}
	
	public EmployeeWkHr(String employeeName) 
	{
		this.employeeName = employeeName;
	}
	
	public EmployeeWkHr(String date, double workHour) 
	{
		// input date must be in format of MM-dd-yyyy
		LocalDate workDate = LocalDate.parse(date);
		
		this.year = workDate.getYear();
		this.month = workDate.getMonthValue();
		this.date = workDate.getDayOfMonth();
		
		// set work hour
		this.workHour = workHour;
		
		// calculate overtime if worked more than or equal to 8 hours
		if(workHour >= regularDailyWorkHour) 
		{
			this.overTimeHour = workHour - regularDailyWorkHour;
			
		} else 
		{
			this.overTimeHour = 0;
		}
	}
	
	public String toString()
	{
		String a = "Employee Name: " + employeeName;
		String b = " Year: "+ this.year + " Month: " + this.month +" Date: " + this.date + " " + this.dayOfWeek;
		String c = " || Work HR " + this.workHour + " OT HR: "+ this.overTimeHour;
		
		return a + b + c;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public double getWorkHour() {
		return workHour;
	}

	public void setWorkHour(double workHour) {
		this.workHour = workHour;
	}

	public double getOverTimeHour() {
		return overTimeHour;
	}

	public void setOverTimeHour(double overTimeHour) {
		this.overTimeHour = overTimeHour;
	}
	
	
	
//	public static void main(String[] args)
//	{
//		WorkHourPerDay wh = new WorkHourPerDay("2015-11-28", 9.25);
//		System.out.println("Year: "+ wh.year + " Month: " + wh.month +" Date: " + wh.date);
//		System.out.println(" WorkHR " + wh.workHour + " OT HR: "+ wh.overTimeHour);
//	}
}
