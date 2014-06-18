package hjg.enums;
/**
 * @author hjg 
 * @version   创建时间：2010-11-6下午01:36:50
 *
 **/
public class GenderTest {
	public static void main(String[] args) {
		String title = Gender.BOTH.getTitle();
		System.out.println(title);
		
		String value = Gender.BOTH.getValue();
		System.out.println(value);
	}
}
