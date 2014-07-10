package hjg.qunaer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeContent {

	public String readContextTxt() {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String returnValue = null;
		try {
			fr = new FileReader("resource/context.txt");
			br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line);
				
			}
			returnValue = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(returnValue);
		return returnValue;
	}

	public Map<String, String> readWordConf() {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		Map map = new HashMap();
		try {
			fr = new FileReader("resource/word.conf");
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
				String[] str = line.split("\\=");

				map.put(str[0], str[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, String[]> getWordConf(Map<String, String> map) {
		Map<String, String[]> returnValue = new HashMap<String, String[]>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("value:" + value);
			String[] str = value.split("\\:");
			System.out.println("length:" + str.length);
			returnValue.put(key, str);
		}

		System.out.println(returnValue);
		return returnValue;
	}

	public String replaceValue(Map<String, String[]> map) {
		String txt = this.readContextTxt();

		while (txt.indexOf("$(") != -1) {
			int start = txt.indexOf("$(");
			int end = txt.indexOf(")");

			String sub = txt.substring(start + 2, end);
			String[] arr = sub.split("\\.");

			System.out.println("sub:" + sub + arr[0]);
			String replace = null;
			for (Map.Entry<String, String[]> entry : map.entrySet()) {
				String key = entry.getKey();
				String[] value = entry.getValue();
				System.out.println("key:" + key + "  value.length:" + value.length);
				if (key.equals(arr[0])) {
					if (arr.length > 1) {// 表示含有小数点
						replace = value[Integer.parseInt(arr[1]) - 1];
					} else {
						replace = value[0];
					}

					System.out.println("sub:" + sub + "  replace:" + replace);
					txt = txt.replaceAll(sub, replace);
					txt = txt.replaceFirst("\\$\\(", "");
					txt = txt.replaceFirst("\\)", "");

					break;
				}
			}
		}

		System.out.println(txt);
		return txt;
	}

	public static void main(String[] args) {
		MergeContent t2 = new MergeContent();

		Map map = t2.readWordConf();
		System.out.println(map);
		Map<String, String[]> arrMap = t2.getWordConf(map);
		String val = t2.replaceValue(arrMap);
		
//		String txt="并不是每个人都需要自己的粮食，$(flight.1)每个";
//		if (txt.indexOf("$(") != -1) {
//			int start = txt.indexOf("$(");
//			int end = txt.indexOf(")");
//			System.out.println("start = "+start+" , end = "+end);
//			String sub = txt.substring(start + 2, end);
//			System.out.println(sub);
//			int slen = sub.length();
//			System.out.println("sublen = "+slen);
//			if(sub.contains(".")){
//				int index = sub.indexOf(".");
//				System.out.println("contain .   ,  index = "+index);
//			}
//		}
		
	}
}
