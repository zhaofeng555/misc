package hjg.xml.saxp;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXReadXml extends DefaultHandler {

	public static void main(String args[]) {
		long lasting = System.currentTimeMillis();
		
			try {
				String fpath = "resource/xmldto.xml";
				SAXParserFactory sf = SAXParserFactory.newInstance();
				SAXParser sp = sf.newSAXParser();
				SAXReadXml reader = new SAXReadXml();
				sp.parse(new InputSource(fpath), reader);
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		
			System.out.println("系统运行："+(System.currentTimeMillis()-lasting));//281
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {
  		System.out.println("ch = "+new String(ch, start, length));
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		System.out.println("uri = "+uri);
		System.out.println("localname = "+localName);
		System.out.println("qname="+qName);
		
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
	
	
}

