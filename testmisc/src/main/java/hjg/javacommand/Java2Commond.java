package hjg.javacommand;

import java.io.IOException;

/**
 * @author hjg 
 * @version   创建时间：2010-7-8下午03:38:55
 * 类说明
 *
 **/
public class Java2Commond {

	public static void main(String[] args) {
		try {
			 String command = "notepad";
			 Process child = Runtime.getRuntime().exec(command);
//			 child
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
	}
}
//Quick Batch File (De)Compiler使用非常简单：
//Quickbfc 文件名.bat 文件名.exe（将批处理命令编译为可执行文件） 
//quickbfd 文件名.exe 文件名.bat（将可执行文件反编译为批处理命令）

