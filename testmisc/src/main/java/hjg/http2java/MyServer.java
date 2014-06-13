package hjg.http2java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		int port = 9999;
		
		// 监听服务器端口
		ServerSocket server = new ServerSocket(port);
		System.out.println("listening on " + port);
		
		while (true) {
			// 接受一个客户端连接
			Socket socket = server.accept();
			System.out.println("---------------------------");
			System.out.println("the client " + socket.getInetAddress().getHostAddress() + " has connected!");
			
			// 获取客户端的输入流
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
			// 获取客户端的输出流
	        PrintWriter out = new PrintWriter(socket.getOutputStream());
	        
			String msg = in.readLine();
			System.out.println("Server received " + msg);
			
			if (msg.equals("bye")) {
				System.out.println("Server stoped!");
				break;
			} else {
				// 想客户端发送信息
				System.out.println("Server send " + msg);
				out.print("Server received " + msg);
				out.flush();
			}
			socket.close();
		}
		server.close();
	}

}
