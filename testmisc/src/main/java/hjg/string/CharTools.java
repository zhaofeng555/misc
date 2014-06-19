package hjg.string;

import java.io.UnsupportedEncodingException;

public class CharTools {
	
	/** 枚举的方式将老字符进行转码
	 * @param oldStr
	 * cxy 2014-06-18
	 */
	public static void codeTest(String oldStr)
	{
		String[] oldCode={"GBK","UTF-8","GB2312","ISO-8859-1","BIG5"};
		String[] newCode={"GBK","UTF-8","GB2312","ISO-8859-1","BIG5"};
		System.out.println("=====================");
		System.out.println("原字符："+oldStr);
		
		try {
			for(String one : oldCode)
			{
				for(String one1 : newCode)
				{
					System.out.println(one+" to "+one1+"------"+new String(oldStr.getBytes(one),one1));
				}
				//下面是针对前台encodeURIComponent的数据
				System.out.println("URLDecoder("+one+")"+ java.net.URLDecoder.decode(oldStr, one));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
	}
	
	public static void main(String[] args) {
		CharTools.codeTest("中文");
	}

}