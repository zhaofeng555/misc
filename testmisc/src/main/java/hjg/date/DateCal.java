package hjg.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hjg
 * @version 创建时间：2010-9-14下午01:39:14
 * 
 **/
public class DateCal {

	public static void main(String[] args) {
		try {
			String strDateStart = "2009-10-1";
			String strDateEnd = "2009-10-14";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date_start = sdf.parse(strDateStart);
			Date date_end = sdf.parse(strDateEnd);
			DateCal app = new DateCal();
			Calendar cal_start = Calendar.getInstance();
			Calendar cal_end = Calendar.getInstance();
			cal_start.setTime(date_start);
			cal_end.setTime(date_end);
			System.out.println("星期-->"+app.getChieseWeek(cal_start)+" , 日期-->"+cal_start.get(Calendar.YEAR));
			System.out.println("星期-->"+app.getChieseWeek(cal_end)+" , 日期-->"+cal_end.get(Calendar.YEAR)+"-"
					+(cal_end.get(Calendar.MONTH)+1)+"-"+cal_end.get(Calendar.DAY_OF_MONTH));
			System.out.println("工作日-->"+app.getWorkingDay(cal_start, cal_end));
			System.out.println("休息日-->"+app.getHolidays(cal_start, cal_end));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) {
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	// 计算2个日期之间的相隔天数
	public int getWorkingDay(Calendar d1, Calendar d2) {
		int result = -1;
		if (d1.after(d2)) {
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}

		int betweendays = getDaysBetween(d1, d2);

		int charge_date = 0;
		int charge_start_date = 0;
		int charge_end_date = 0;

		int stmp;
		int etmp;
		stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
		etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);
		if (stmp != 0 && stmp != 6) {// 开始日期为星期六和星期日时偏移量为0
			charge_start_date = stmp - 1;
		}
		if (etmp != 0 && etmp != 6) {// 结束日期为星期六和星期日时偏移量为0
			charge_end_date = etmp - 1;
		}
		result = (getDaysBetween(this.getNextMonday(d1), this.getNextMonday(d2)) / 7) * 5 + charge_start_date - charge_end_date;
		System.out.println("charge_start_date>" + charge_start_date);
		System.out.println("charge_end_date>" + charge_end_date);
		System.out.println("between day is-->" + betweendays);
		return result;
	}

	public String getChieseWeek(Calendar date) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", };
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		return dayNames[dayOfWeek - 1];
	}

	/**
	 * 获得日期的下一个星期一的日期
	 * 
	 * @param date
	 * @return
	 */
	public Calendar getNextMonday(Calendar date) {
		Calendar result = null;
		result = date;
		do {
			result = (Calendar) result.clone();
			result.add(Calendar.DATE, 1);
		} while (result.get(Calendar.DAY_OF_WEEK) != 2);
		return result;
	}

	public int getHolidays(Calendar d1, Calendar d2) {
		return this.getDaysBetween(d1, d2) - this.getWorkingDay(d1, d2);
	}

}
