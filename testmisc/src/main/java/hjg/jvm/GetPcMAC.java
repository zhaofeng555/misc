package hjg.jvm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * JDK6新特性,JAVA获得机器MAC地址的方法
 */
public class GetPcMAC {
	// 返回一个字节的十六进制字符串
	static String hexByte(byte b) {
		String s = "000000" + Integer.toHexString(b);
		return s.substring(s.length() - 2);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("本机器的所有的网卡MAC发下:");
		getMacOnWindow();
		// getMac();
	}

	/**
	 * JDK1.6新特性获取网卡MAC地址
	 */
	public static void getMac() {
		try {
			Enumeration<NetworkInterface> el = NetworkInterface.getNetworkInterfaces();
			while (el.hasMoreElements()) {
				byte[] mac = el.nextElement().getHardwareAddress();
				if (mac == null)
					continue;

				StringBuilder builder = new StringBuilder();
				for (byte b : mac) {
					builder.append(hexByte(b));
					builder.append("-");
				}
				builder.deleteCharAt(builder.length() - 1);
				System.out.println(builder);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 原始的获取网卡MAC地址
	 */
	public static void getMacOnWindow() {
		try {
			String mac = null;
			Process process = Runtime.getRuntime().exec("ipconfig /all");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
				System.out.println(line);
				// System.out.println(new String(line.getBytes("ISO-8859-1"),"utf-8"));
				// System.out.println(new String(line.getBytes("utf-8"),"gbk"));
				// System.out.println(new String(line.getBytes("gbk"),"utf-8"));
				int index = line.indexOf("Physical Address");
				if (index <= 0) {
					continue;
				}
				mac = line.substring(index + 36);
				break;
			}
			buffer.close();
			process.waitFor();
			System.out.println(mac);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
