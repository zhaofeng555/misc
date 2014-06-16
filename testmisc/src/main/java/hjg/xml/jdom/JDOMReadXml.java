package hjg.xml.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDOMReadXml {

	public static void main(String[] args) {
		long lasting = System.currentTimeMillis();
		try {
			File f = new File("resource/xmldto.xml");
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(f);
			Element foo = doc.getRootElement();
			@SuppressWarnings("rawtypes")
			List allChildren = foo.getChildren();
			for (int i = 0; i < allChildren.size(); i++) {
				Element e = (Element)allChildren.get(i);
				System.out.println(e.getName()+" , "+e.getText());
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("系统运行："+(System.currentTimeMillis()-lasting));//297
	}

}

