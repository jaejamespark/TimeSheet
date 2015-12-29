import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/***
 * Input: Desired start date and end date
 * Output: List of dates between start and end date.
 * @author cycas
 * reference: 		//http://www.mkyong.com/java/java-date-and-calendar-examples/
 */

public class TimeWindow {

	private LocalDate start;
	private LocalDate end;
	List<LocalDate> totalDates;
	
	public TimeWindow(String startDateInput, String endDateInput)
	{
		this.start = LocalDate.parse(startDateInput);
		this.end = LocalDate.parse(endDateInput);
	}
	
	public List<LocalDate> getListOfDates()
	{
		totalDates = new ArrayList<>();
		while (!start.isAfter(end))
		{
			totalDates.add(start);
			//start.getDayOfWeek();
			//System.out.println(start + " "+ start.getDayOfWeek());
			start = start.plusDays(1);
		}
		
		return totalDates;
	}
	
	public String toString()
	{
		String output = "";
		for (LocalDate ls : totalDates)
		{
			output += (ls + " "+ ls.getDayOfWeek() +"\n");
		//	System.out.println(ls + " "+ ls.getDayOfWeek());
		}
		return output;
	}
	
	
	public static void main(String arg[])
	{
		TimeWindow tw = new TimeWindow("2015-10-01", "2015-10-04");
		tw.getListOfDates();
		System.out.print(tw);
	}
}


