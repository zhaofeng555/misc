package hjg.mianshi;

import java.util.StringTokenizer;

/*
java编写encode方法和decode方法，机试题

请你用java语言实现两个函数encode（）和decode（），分别实现对字符串的变换和复原。
变换函数encode（）顺序考察以知字符串的字符，按以下规则逐组生成新字符串：
（1）若已知字符串的当前字符不是大于0的数字字符，则复制该字符与新字符串中；
(2)若以已知字符串的当前字符是一个数字字符，且他之后没有后继字符，则简单地将它复制到新字符串中；
(3)若以已知字符串的当前字符是一个大于0的数字字符，并且还有后继字符,设该数字字符的面值为n,
则将它的后继字符(包括后继字符是一个数字字符) 重复复制n+1 次到新字符串中;
(4)以上述一次变换为一组,在不同组之间另插入一个下划线'_'用于分隔;
(5)若以知字符串中包含有下划线'_'，则变换为用"/UL".

例如:encode()函数对字符串24ab_2t2的变换结果为 444_aaaaa_a_b_/UL_ttt_t_2
*/
public class EnctrStr {
	public static void main(String[] args) {
		System.out.println(encode("24ab_2t2"));
		System.out.println(decode("444_aaaaa_a_b_\\UL_ttt_t_2"));
	}

	static String encode(String src) {
		if (src == null || src.length() == 0)
			return src;
		
		StringBuilder sb = new StringBuilder();
		// 提前处理下划线，直接替换
		src = src.replaceAll("_", "\\\\UL");
		for (int i = 0; i < src.length(); i++) {
			char c = src.charAt(i);
			if (c == '0') { // 如果是0，直接写入
				sb.append(c);
			} else if (c > 48 && c < 58) {// 如果是1-9，且无后续字符
				if (i == src.length() - 1) {
					sb.append(c);
					break;
				} else {
					int num = c - 48;
					while (num-- >= 0) {
						sb.append(src.charAt(i + 1));
					}
					sb.append("_");
				}
			} else {
				sb.append(c);
				sb.append("_");
			}
		}
		// 最后需要将下划线替换符号中间的下划线移除
		return sb.toString().replaceAll("\\\\_U_L", "\\\\UL");
	}

	static String decode(String src) {
		if (src == null || src.length() == 0)
			return src;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(src, "_");
		while (st.hasMoreElements()) {
			String s1 = st.nextToken();

			if (s1.length() > 1) {
				if (s1.equals("\\UL"))
					sb.append("_");
				else
					sb.append(s1.length() - 1);
			} else {
				sb.append(s1);
			}
		}
		return sb.toString();
	}

}
