package hjg.file;

import java.io.File;

public class ListJar {

	public static void main(String[] args) {
		File f = new File("F:/study/基于Lucene4.6+Solr4.6+Heritrix1.14+S2SH/run heritrix/heritrix/lib");

		File[] fs = f.listFiles();
		for (File jar : fs) {
			String name = jar.getName();
			System.out.print("./heritrix/"+name+";");
		}
		
	}

}
