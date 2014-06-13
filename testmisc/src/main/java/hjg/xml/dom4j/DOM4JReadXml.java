package hjg.xml.dom4j;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JReadXml {

	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();
		try {
			File f = new File("resource/xmldto.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				foo = (Element) i.next();
				System.out.println("节点名字："+foo.getName()+" ， 节点值："+foo.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("系统运行："+(System.currentTimeMillis()-lasting));//391
	}

}
