package hjg.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author hjg 
 * @version   创建时间：2010-4-29下午08:02:50
 * 类说明
 *
 **/
public class Pinyin4jTest {

	public static void main(String argsp[]) {
        try {
            String output = Pinyin4jTest.CNToPinyin("你和你好", null);
            System.out.println(output);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * @parm inputCN 输入的中文字符串
     * @parm seg 输出汉语拼音时的分隔符
     * 
     * HanyuPinyinOutputFormat提供了几种输出模式
     * HanyuPinyinCaseType:设定输入的结果是大写英文还是小写英文 LOWERCASE :小写 UPPERCASE :大写
     * HanyuPinyinToneType:输出是否表明音调和重音 WITH_TONE_NUMBER:标明音调 如YE1 1-4表示 1-4声
     * WITHOUT_TONE:不显示音调符 HanyuPinyinVCharType :输出要用何种的拼音编码
     */
    public static String CNToPinyin(String inputCN, String seg)
            throws BadHanyuPinyinOutputFormatCombination {
    	System.out.println(inputCN);
        char[] inputArray = inputCN.toCharArray();
        if (seg == null)
            seg = " ";
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output = "";
        String[] temp = new String[10];
        for (int i = 0; i < inputArray.length; i++) {
            temp = PinyinHelper.toHanyuPinyinStringArray(inputArray[i], format);
            //若输入的汉字为多音字则会将不同的读音依次放入temp[]中，若不是多音字则只有temp[0]中有值
            System.out.println("temp.length = "+temp.length +"第一个字母   "+temp[0]);
            for (int j = 0; j < temp.length; j++) {
                output += temp[j] + seg;
                
                System.out.println("temp[ "+ j +" ]"+temp[j]);
            }
        }
        return output;
    }


}
