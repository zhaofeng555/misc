package hjg.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddCon2File {

	public static void main(String[] args) {

	}
	
	public void writeCon2File(String con){
		BufferedWriter out = null;
		try {
			out=new BufferedWriter(new FileWriter("resource/test.txt", true));
			out.write("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null)
				try{out.close();}catch(Exception e){}
		}
	}

}
