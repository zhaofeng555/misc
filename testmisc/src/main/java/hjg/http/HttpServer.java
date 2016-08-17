package hjg.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.IOException;
import java.util.Enumeration;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class HttpServer {
	private int iPort = 8989; // default port
	public static String Basic_Root = System.getProperty("user.dir");
	public static String WEB_ROOT = System.getProperty("user.dir")
			+ File.separator + "webroot";
	public static int count = 0;

	public HttpServer() {
		System.out.println("欢迎使用Erik‘s 快速Web服务器，本服务器只支持静态网页。");
		System.out.println("检查配置文件及网页文件夹...");
		getConfig();
		start();
	}

	public static void main(String[] args) {
		HttpServer httpserver = new HttpServer();
	}

	private void getConfig() {
		File fileCon = new File(Basic_Root, "config.ini");

		File fileDir = new File(WEB_ROOT);
		File fileWeb = new File(WEB_ROOT, "index.htm");
		if (!fileCon.exists()) {
			System.out.println("配置文件Config.ini损坏，重建中...");
			reBuildConfig(fileCon);
		}
		if (!fileDir.exists()) {
			System.out.println("网页存放文件夹不存在，重建中...");
			fileDir.mkdir();
			System.out.print("完成！请在");
			System.out.println(WEB_ROOT + "中放置网页文件...");
			System.out.println("Web服务器将重新初始化...");
			getConfig();
		}
		if (!fileWeb.exists()) {
			reBuildWeb(fileWeb);
		}
		Properties pps = new Properties();
		try {
			pps.load(new FileInputStream("config.ini"));
			Enumeration enumer = pps.propertyNames();
			String strKey = (String) enumer.nextElement();
			String strValue = pps.getProperty(strKey);
			if (strValue.equals("") != true) {
				WEB_ROOT = strValue;
			}
			System.out.println("网页文件的存放路径为： " + WEB_ROOT);
			strKey = (String) enumer.nextElement();
			strValue = pps.getProperty(strKey);
			if (strValue.equals("") != true) {
				iPort = Integer.parseInt(strValue);
			}
			System.out.println("Web服务器访问端口为：" + iPort);
			System.out.println("您可以修改Config.ini文件重新设定以上配置");
			System.out.println("启动检查完成，服务器初始化中...");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void start() {
		System.out.println("Web 服务器启动中...");
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(iPort);
			System.out.println("Web 启动完成！");
			System.out.println("您现在可以在浏览器中访问http://localhost:8989/，以测试服务器是否运行");
			while (true) {
				Socket socket = null;
				InputStream input = null;
				OutputStream output = null;
				System.out.println("等待连接...");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress().toString() + "请求连接");
				input = socket.getInputStream();
				output = socket.getOutputStream();
				System.out.println("服务器开始处理第" + (++count) + "次连接"); // 开始处理并分析请求信息
				Request request = new Request(input);
				request.parse(); // 开始发送请求资源
				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource(); // 关系连接
				socket.close();
				System.out.println("连接已关闭！");
			}
		} catch (Exception ex) {

			ex.printStackTrace();
			System.out.println("3"); // continue;
		}
	}

	private void reBuildConfig(File file) {
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream sp = new PrintStream(fos);
			sp.println("WEB_ROOT=");
			sp.println("PORT=");
			sp.close();
			System.out
					.println("配置文件Config.ini创建成功，您可以修改WEB_ROOT的值改变网页文件的存放路径，修改PORT的值改变访问端口！");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("重建配置文件Config.ini失败");
			System.out.println("服务器将使用默认配置...");
		}
	}

	private void reBuildWeb(File file) {
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream sp = new PrintStream(fos);
			sp.println("<html>");
			sp.println("<head>");
			sp.println("<title>Erik'简单Web服务器</title>");
			sp.println("</head>");
			sp.println("<body>");
			sp.println("<div align=" + "center" + ">服务器已经成功运行 </div>");
			sp.println("</body>");
			sp.println("</html>");
			sp.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}