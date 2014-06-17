package hjg.xml.dom4j;

/**
 * @author hjg 
 * @version   创建时间：2012-1-16上午12:06:50
 *
 **/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXMLSql {
	private static  Map<String, String>readXML(String url) {
		SAXReader reader = new SAXReader();
		Map<String, String> map = new HashMap<String, String>();
		try {
			Document doc = reader.read(url);
			Element root = doc.getRootElement();
			List<Element> listmsg = root.elements();
			if (listmsg.size() == 0)
				return null;
			for (Element element : listmsg) {
				map.put(element.getName(), element.getText());
			}
		} catch (DocumentException e) {
			System.out.println("URL路径有误" + e.getMessage());
		}
		return map;
	}

	public static void main(String[] args) {
		String xmlPath = "resource/sqlmap.xml";
		Map<String, String> map = readXML(xmlPath);
		
		for (Map.Entry<String, String> en : map.entrySet()) {
			String key = en.getKey();
			String val = en.getValue();
			System.out.print(key+"=");
			System.out.println(doHandleSql(val));
		}

	}
	
	private static String doHandleSql(String sql){
		if(sql!=null && !sql.isEmpty()){//替换掉tab，换行
			return sql.replaceAll("\n", "").replaceAll("\t", "").trim();
		}
		return sql;
	}
}