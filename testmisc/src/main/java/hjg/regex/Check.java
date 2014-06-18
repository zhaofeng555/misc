package hjg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证类
 * @author hjg
 *
 */
public class Check {
	
	/**
	 * 检验输入的字符串是否为数字
	 * @param value	要检查的字符串
	 * @return	true 是 / false 不是
	 */
	public static boolean isNumber(String value){
		boolean b = false;
		if(null != value){
			String regex = "\\d*";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			b= m.matches();
		}
		return b;
	}
	
	/**
	 * 检验输入的是否为非空字符串
	 * @param value	要检验的字符串
	 * @return	true 是 / false 不是
	 */
	public static  boolean noNull(String value){
		boolean b = false;
		if((null != value) && (value.trim().length() > 0)){
			b = true;
		}
		return b;
	}
	
	/**
	 * 检验输入的是否为 中文 字符串
	 * @param value 要检验的字符串
	 * @return true 是 / false 不是
	 */
	public static  boolean isChinese(String value){
		boolean b = false;
		if(null != value){
			String regex = "[\u4e00-\u9fa5]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			b= m.matches();			
		}
		return b;
	}
	
	/**
	 * 检验输入的字符串是否为 合法的Email
	 * @param value 要检验的字符串 Email
	 * @return true 是 / false 否
	 */
	public static boolean isEmail(String value){
		boolean b = false;
		if(null != value){
			String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			b = m.matches();
		}
		return b;
	}
	
	/**
	 * 检验输入的字符串是否为 合法的电话号码
	 * @param value
	 * @return
	 */
	public static boolean isTelNum(String value){
		boolean b = false;
		if(null != value){
			String regex = "^\\d{7,8}|(\\d{4}|\\d{3})-(\\d{7,8})";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			b = m.matches();
		}
		return b;
	}
	
	/**
	 * 检验输入的字符串是否为 合法的手机号码
	 * @param value 要检查的手机号码
	 * @return true 是 / false 否
	 */
	public static boolean isMobileNum(String value){
		boolean b = false;
		if(null != value){
			String regex = "/^13\\d{9}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			b = m.matches();
		}
		return b;
	}
	
	/**
	 * 检验输入的字符串是否为 身份证号
	 * @param value 要检验的字符串
	 * @return
	 */
	public static boolean isIDCard(String value){
		boolean b = false;
		if(null != value){
			String regex = "\\d{18}|\\d{15}";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(value);
			b = m.matches();
		}
		return b;
	}
}
