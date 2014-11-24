package hjg.mianshi;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestCharAcount {

	public static void main(String args[]) {
		String strIn = "aaabbbbccccc";
		char[]cs = strIn.toCharArray();
		for (char c : cs) {
			System.out.println(c);
		}
		System.out.println("--------------");
		
		byte[]bs=strIn.getBytes();
		for (byte b : bs) {
			System.out.println(b);
		}
//		TestCharAcount tc = new TestCharAcount();
//		Map<Character, Integer> mTemp = tc.charAcount(strIn);
//
//		Set<Character> ks = mTemp.keySet();// 生成索引set
//		for (Iterator<Character> it = ks.iterator(); it.hasNext();) {// 遍历索引取值
//			char c = it.next();
//			System.out.println(c + " " + mTemp.get(c));
//		}

	}

	public Map<Character, Integer> charAcount(String strIn) {
		String tempStr = strIn;
//char c = strIn.charAt(0);
		
		// The map is sorted according to the natural ordering of its keys
		// treemap是以键的自然顺序来存储值的
		Map<Character, Integer> m = new TreeMap<Character, Integer>();
		char[] strC = tempStr.toCharArray();
		for (int i = 0; i < strC.length; i++) {
			Integer count = m.get(strC[i]);
			if (null == count)
				count = 0;

			count++;
			m.put(strC[i], count);
		}

		return m;
	}
}