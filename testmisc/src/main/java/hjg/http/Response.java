package hjg.http;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

public class Response {
	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void sendStaticResource()// 发送请求资源
			throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			if (file.exists()) {
				System.out.println("开始发送用户请求资源...");
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while (ch != -1)

				{
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
				System.out.println("发送完毕！");
			} else {
				System.out.println("用户请求的资源不存在");
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
						+ "Content-Type:text/html\r\n" + "\r\n"
						+ "<hl>File Not Found</hl>";
				output.write(errorMessage.getBytes());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("获取请求资源错误，请检查本地资源设置！");
			System.exit(1);
		}
		if (fis != null) {
			fis.close();
		}
	}
}