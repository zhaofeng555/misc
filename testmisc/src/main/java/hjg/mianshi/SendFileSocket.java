package hjg.mianshi;

import java.net.*;
import java.io.*;

//一个简单的多线程服务器程序,用于传输文件
public class SendFileSocket extends Thread {
	public static void main(String[] args) {
		server();
		// 启动服务器程序
	}

	private static final int PORT = 6000;
	private Socket s;
	private static final String name = "zieckey";
	private static final String password = "123456";

	public SendFileSocket(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			os.write("Hello,welcome you!".getBytes());
			byte[] buf = new byte[100];
			while (true) {
				int len = is.read(buf);
				String revStr = new String(buf, 0, len);
				System.out.println("This client wants to " + revStr);
				String fileName;
				if (revStr.startsWith("get "))
				// 表明客户端请求传输一个文件
				{
					os.write("Please input your name and password! Using the format:name@password"
							.getBytes());
					fileName = getFileName(revStr);
					len = is.read(buf);
					revStr = new String(buf, 0, len);
					System.out.println("The received user name and password:"
							+ revStr);
					if (revStr.startsWith("zieckey@123456")) {
						FileInputStream fins = new FileInputStream(fileName);
//						 byte[] fielBuf = new byte[100];
						int data;
						while (-1 != (data = fins.read()))// 从文件中读取数据，每次读取1字节
						{
							os.write(data);
							// 将读取到的数据写到网络数据流中发送给客户段
						}
						break;
					}
				} else {
					os.write("geting file's usage is:get filename".getBytes());
				}
			}
			os.close();
			is.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 作用：从客户端发来了文件请求命令中提取出所请求的文件名 
	 * 参数：客户端发来了文件请求命令字符串，应该以“get ”开头 
	 * 返回值：提取出所请求的文件名
	 */
	private String getFileName(String revStr) {
		String fileName;
		fileName = revStr.substring(3);
		while (fileName.startsWith(" ")) {
			fileName = fileName.substring(1);
		}
		return fileName;
	}

	public static void server() {
		System.out.println("This is server");
		try {
			ServerSocket ss = new ServerSocket(PORT);
			int count = 0;
			while (true) {
				// 创建一个Socket等待客户端连接
				Socket s = ss.accept();
				count++;
				System.out.println("This is the " + count
						+ "'st client connetion!");
				new SendFileSocket(s).start();
				// 启动一个线程为这个客户端服务
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
