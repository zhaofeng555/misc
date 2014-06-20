package hjg.ipnumber;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetClientIP {

	public static void main(String[] args) {
		//is client behind something?
		
//		   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
//		   if (ipAddress == null) {  
//			   ipAddress = request.getRemoteAddr();  
//		   }
		
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip = getClientIpAddr(request);
		System.out.println(ip);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
