package hjg.mianshi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {

	public static void byteCopy(){
		File source = new File("d:/hello.txt");
		File dir = new File("d:/bak");
		if(!dir.exists()){
			dir.mkdirs();
		}
		File des = new File(dir, "bak.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream(source);
			fos=new FileOutputStream(des);
			byte[] byteTemp = new byte[1024];
			int len=0;
			while((len=fis.read(byteTemp))!=-1){
				fos.write(byteTemp, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{if(fis!=null)fis.close();}catch(Exception e){e.printStackTrace();}
			try{if(fos!=null)fos.close();}catch(Exception e){e.printStackTrace();}
		}
	}
	public static void charCopy(){
		File source = new File("d:/hello.txt");
		File dir = new File("d:/bak");
		if(!dir.exists()){
			dir.mkdirs();
		}
		File des = new File(dir, "bak.txt");
		
		FileReader fr = null;
		FileWriter fw = null;
		try{
			fr = new FileReader(source);
			fw=new FileWriter(des);
			char[] charTemp = new char[1024];
			int len=0;
			while((len=fr.read(charTemp))!=-1){
				fw.write(charTemp, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{if(fr!=null)fr.close();}catch(Exception e){e.printStackTrace();}
			try{if(fw!=null)fw.close();}catch(Exception e){e.printStackTrace();}
		}
	}
	
	public static void intCopy(){
		File source = new File("d:/hello.txt");
		File dir = new File("d:/bak");
		if(!dir.exists()){
			dir.mkdirs();
		}
		File des = new File(dir, "bak.txt");
		
		FileReader fr = null;
		FileWriter fw = null;
		try{
			fr = new FileReader(source);
			fw=new FileWriter(des);
			int rs=-1;
			while((rs=fr.read())!=-1){
				fw.write(rs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{if(fr!=null)fr.close();}catch(Exception e){e.printStackTrace();}
			try{if(fw!=null)fw.close();}catch(Exception e){e.printStackTrace();}
		}
	}
	
}
