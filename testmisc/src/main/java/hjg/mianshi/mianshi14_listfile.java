package hjg.mianshi;


import java.io.File;

public class mianshi14_listfile {
	public static void main(String[] args) {
		File f = new File("C:/");
		File[] f1 = f.listFiles();
		for (int i = 0; i < f1.length; i++) {
			if(f1[i].isDirectory()){
				System.out.println("文件夹："+f1[i].getName());
			}else{
				System.out.println("文件："+f1[i].getName());
			}
		}
	}
}

