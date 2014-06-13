package hjg.xml.xstream;

import hjg.xml.XmlDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XstreamUtils {

	private static String filePath="resource/xmldto.xml";
	
	public static void main(String[] args) {
		writeDTO2xml();
		readXxml2DTO();
	}

	private static void readXxml2DTO(){
		XStream xs = new XStream(new DomDriver());

		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
//			xs.alias("config", XmlDTO.class);
			// 映射将对象属性datasourcename映射到xml别名datasource-name中
//		xs.aliasField("datasource-name", ConfigReader.class, "datasourcename");
			// 这是可选的一步。没有这步XStream也可以很好的起作用，但是XML元素的名字就会包含每个类的全称(包括包名)，这将会使生成XML稍大。
//		ConfigReader r = (ConfigReader) xs.fromXML(fis);
			
			XmlDTO dto = (XmlDTO)xs.fromXML(fis);
			
			System.out.println(dto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeDTO2xml() {
		XmlDTO e = new XmlDTO();
		e.setName("Jack");
		e.setAge("21");

		// Serialize the object
		// 实例化XStream
		// 使用XStream，简单实例化XStream类：

		XStream xs = new XStream();
//		 xs.omitField(XmlDTO .class, "name"); //定义某一个属性的值不进行xml序列化。
//		 xs.useAttributeFor(String.class); // 对所有String类型的字段定义为属性tag显示
//		 xs.useAttributeFor("name",String.class);// 对所有String类型的字段名成为name
		// 定义为属性tag显示,读取的时候获取不了该值

		try {
			FileOutputStream fs = new FileOutputStream(filePath);
			xs.toXML(e, fs);
			fs.flush();
			fs.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
