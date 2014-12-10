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
		} catch (Exception e) {
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
		return returnValue;
	}

	public Map<String, String> readWordConf() {
		FileReader fr = null;
		BufferedReader br = null;
		Map<String, String> map = new HashMap();
		try {
			fr = new FileReader("resource/word.conf");
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] str = line.split("\\=");
				map.put(str[0], str[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null)br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(fr!=null)fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return map;
	}

	public Map<String, String[]> getWordConf(Map<String, String> map) {
		Map<String, String[]> val = new HashMap<String, String[]>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			String[] str = value.split("\\:");
			val.put(key, str);
		}

		return val;
	}

	public String replaceValue(Map<String, String[]> map) {
		String txt = this.readContextTxt();

		
//		while (txt.indexOf("$(") != -1) {
		while (txt.contains("$(")) {
			int start = txt.indexOf("$(");
			int end = txt.indexOf(")");

			String sub = txt.substring(start + 2, end);
			String[] arr = sub.split("\\.");

			String replace = null;
			for (Map.Entry<String, String[]> entry : map.entrySet()) {
				String key = entry.getKey();
				String[] value = entry.getValue();
				if (key.equals(arr[0])) {
					if (arr.length > 1) {// 表示含有小数点
						replace = value[Integer.parseInt(arr[1]) - 1];
					} else {
						replace = value[0];
					}

					txt = txt.replaceAll(sub, replace)
							.replaceFirst("\\$\\(", "")
							.replaceFirst("\\)", "");
					break;
				}
			}
		}

		return txt;
	}

	public static void main(String[] args) {
		MergeContent t2 = new MergeContent();
		Map map = t2.readWordConf();
		System.out.println(map);
		Map<String, String[]> arrMap = t2.getWordConf(map);
		String val = t2.replaceValue(arrMap);
		System.out.println(val);
	}
}
