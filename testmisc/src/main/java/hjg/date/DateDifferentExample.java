package hjg.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
 
public class DateDifferentExample {
 
	public static void main(String[] args) {
 
		test1_Date();
		test2_Jodatime();
 
	}

	private static void test1_Date() {
		String dateStart = "01/14/2012 09:29:58";
		String dateStop = "01/15/2012 10:31:48";
 
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 
		Date d1 = null;
		Date d2 = null;
 
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.println(diffSeconds + " seconds.");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static void test2_Jodatime(){
		String dateStart = "01/14/2012 09:29:58";
		String dateStop = "01/15/2012 10:31:48";
	 
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	 
		Date d1 = null;
		Date d2 = null;
	 
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
	 
			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);
	 
			System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
			System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
			System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
			System.out.println(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");
	 
		 } catch (Exception e) {
			e.printStackTrace();
		 }
	}
	
}
