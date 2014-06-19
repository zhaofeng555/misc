package hjg.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class DirectoryList {

	public static void main(String[] args) {

		File dir = new File("src/main/java");
		String[] children = dir.list();
		if (children == null) {
			System.out.println("not a directory");
		} else {
			for (int i = 0; i < children.length; i++) {
				System.out.println("fileName    :   " + children[i]);
			}
		}
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !name.startsWith(".");
			}
		};
		children = dir.list(filter);

		File[] files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		files = dir.listFiles(fileFilter);
		for (int i = 0; i < files.length; i++) {
			System.out.println("dir : " + files[i].getName());
		}
	}
}
