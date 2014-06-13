package hjg.http2java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
    	Scanner reader = new Scanner(System.in);
		
        while (true) {
        	// 创建客户端socket
        	Socket client = new Socket("localhost", 9999);
        	System.out.println("---------------------------");
        	
        	// 获取客户端的输入流（获取服务器端的输出流）
        	BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); 
        	// 
            PrintWriter out = new PrintWriter(client.getOutputStream()); 
            
            System.out.println("Input Something ");
        	String msg = reader.nextLine(); 
        	System.out.println("Client sended " +  msg);
            out.println(msg);  
            out.flush();  
            if (msg.equals("bye")) {  
            	System.out.println("Client stop!");
                break;  
            }  
            System.out.println("Client received " + in.readLine());
            client.close();
        }
	}

}
