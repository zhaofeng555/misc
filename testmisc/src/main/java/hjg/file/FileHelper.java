package hjg.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileHelper {

	public static String getFilePathToSave() {

		Properties prop = new Properties();
		String filePath = "";
		try {
			InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties");
			// Thread.currentThread().getClass().getClassLoader().getResourceAsStream("");

			prop.load(inputStream);
			filePath = prop.getProperty("path");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	public static void main(String[] args) {
		String path = FileHelper.getFilePathToSave();
		System.out.println(path);
	}
}