package hjg.xml.saxp;

/**
 * @author hjg 
 * @version   创建时间：2012-1-15下午11:36:35
 *
 **/
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAXParser {
	/** 基于SAX方式解析XML文档 */
	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
		File f = new File("resource/xmldto.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance(); // 创建SAX解析器工厂
		factory.setValidating(true); // 让error方法生效
		SAXParser parser = factory.newSAXParser(); // 生成一个具体的SAX解析器
		parser.parse(f, new XMLreader()); // 开始解析
	}
}

class XMLreader extends DefaultHandler {
	// 只需覆盖我们感兴趣的方法
	private int counter = 0;// 定义一个计数器，保存XML文档触发事件的次数

	@Override
	// 文档开始事件触发
	public void startDocument() throws SAXException {
		counter++;
		System.out.println(counter + ".解析XML文件开始...");
	}

	@Override
	// 文档结束事件触发
	public void endDocument() throws SAXException {
		counter++;
		System.out.println("\r\n" + counter + ".解析XML文件结束...");
	}

	@Override
	// 元素开始事件触发
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		counter++;
		System.out.print(counter + ".<" + qName);
		for (int i = 0; i < atts.getLength(); i++) { // 读取标志的所有属性
			System.out.print(" " + atts.getLocalName(i) + "=" + atts.getValue(i));
		}
		System.out.print(">");
	}

	@Override
	// 元素结束事件触发
	public void endElement(String uri, String localName, String qName) throws SAXException {
		counter++;
		System.out.print(counter + ".</" + qName + ">");
	}

	@Override
	// 文本事件触发 打印时尽量不要换行，否则很难看
	public void characters(char[] ch, int start, int length) throws SAXException {
		counter++;
		String text = new String(ch, start, length); // 当前元素的文本值
		System.out.print(counter + ".Text=" + text);
	}

	@Override
	// 这是可恢复错误。需在SAXParserFactory设置有效性错误才能生效
	public void error(SAXParseException e) throws SAXException {
		System.out.println("xml文档有效性错误：" + e);
	}

	@Override
	// 严重错误
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("xml文档严重的有效性错误：" + e);
	}
}
