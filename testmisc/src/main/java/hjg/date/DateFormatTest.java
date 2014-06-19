package hjg.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatTest {
	public static void main(String[] args) {
		DateFormatTest df = new DateFormatTest();
		df.formate();
	}
	
	public Date formate(){
		String date = "2009-9-3";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = format.parse(date);
			System.out.println(d.toString());
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
