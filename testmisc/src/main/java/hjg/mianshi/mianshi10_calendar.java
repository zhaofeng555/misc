package hjg.mianshi;


import java.util.Calendar;

/**
 * @author hjg
 * @version 创建时间：2011-1-22上午09:45:50
 * 
 **/
public class mianshi10_calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		print(cal);
		System.out.println(cal.getTime());
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());
	}
	
	public static void print(Calendar cal){
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR)+" 年");
		System.out.println((cal.get(Calendar.MONTH)+1+" 月"));
		System.out.println(cal.get(Calendar.DATE)+" 日");
		System.out.println(cal.get(Calendar.HOUR)+" 时");
		System.out.println(cal.get(Calendar.MINUTE)+" 分");
		System.out.println(cal.get(Calendar.SECOND)+" 秒");	
	}
}
