package hjg.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMReadXml {
	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();
		try {
			File f = new File("resource/xmldto.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			
			NodeList nl = doc.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.println("姓名："+ doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
				System.out.println("年龄："+ doc.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("系统运行："+(System.currentTimeMillis()-lasting));//266
	}
}
