package hjg.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2Date {

	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "07/06/2013";

		try {

			Date date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Letter Description Examples
	// y Year 2013
	// M Month in year July, 07, 7
	// d Day in month 1-31
	// E Day name in week Friday, Sunday
	// a Am/pm marker AM, PM
	// H Hour in day 0-23
	// h Hour in am/pm 1-12
	// m Minute in hour 0-60
	// s Second in minute 0-60
}
