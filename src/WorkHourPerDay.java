import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * This object contains work hours and overtime hours on a corresponding date
 * (Ex: 12-28-2015 WorkHour: 10Hr OverTimeHour: 2Hr)
 * @author cycas
 *
 */

public class WorkHourPerDay {

	final private double regularDailyWorkHour = (long) 8;
	
	private int year;
	private int month;
	private int date;
	private double workHour;
	private double overTimeHour;
	
	public WorkHourPerDay(LocalDate date, double workHour) 
	{
		// input date must be in format of MM-dd-yyyy
		//LocalDate workDate = LocalDate.parse(date);
		
		this.year = date.getYear();
		this.month = date.getMonthValue();
		this.date = date.getDayOfMonth();
		
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
	
	
	public WorkHourPerDay(String date, double workHour) 
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
	
	public static void main(String[] args)
	{
		WorkHourPerDay wh = new WorkHourPerDay("2015-11-28", 9.25);
		System.out.println("Year: "+ wh.year + " Month: " + wh.month +" Date: " + wh.date);
		System.out.println("WorkHR " + wh.workHour + " OT HR: "+ wh.overTimeHour);
	}
}
