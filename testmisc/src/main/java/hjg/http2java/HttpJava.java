package hjg.http2java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author hjg 
 * @version   创建时间：2010-11-14下午09:19:05
 *
 **/
public class HttpJava {

	private static Request  request = null;
	public static void main(String[] args) {
		request = new Request();

	}

	/**  
	 * 传入一个Socket对象，解析出通过该对象传入这个链接中的所有HTTP请求信息  
	 *   
	 * @param client  
	 */  
	private void getRequset(Socket client) {   
	    try {   
	        InputStream in = client.getInputStream();   
	        InputStreamReader reader = new InputStreamReader(in);   
	        BufferedReader bd = new BufferedReader(reader);//三重封装   
	        String t = null;   
	  
	        while ((t = bd.readLine()) != null) {   
	            System.out.println(t);   
	             parser(t);//解析每一句的方法   
	        }   
	    } catch (Exception ef) {   
	        ef.printStackTrace();   
	        System.out.println("getRequset error--->");   
	    }   
	}  

	private void parser(String s) {   
	    if (s.startsWith("GET")) {   
	        String method = "Get";   
	        request.setMethod(method);   
	  
	        int index = s.indexOf("HTTP");   
	        System.out.println("index--->" + index);   
	        String uri = s.substring(3 + 1, index - 1);// 用index-1可以去掉连接中的空格   
	        System.out.println("uri--->" + uri);   
	        request.setRequestURI(uri);   
	  
	        String protocol = s.substring(index);   
	        System.out.println("protocol---->" + protocol);   
	        request.setProtocol(protocol);   
	    } else if (s.startsWith("POST")) {   
	        String method = "POST";   
	        request.setMethod(method);   
	  
	        int index = s.indexOf("HTTP");   
	        System.out.println("index--->" + index);   
	        String uri = s.substring(3 + 1, index - 1);// 用index-1可以去掉连接中的空格   
	        System.out.println("uri--->" + uri);   
	        request.setRequestURI(uri);   
	  
	        String protocol = s.substring(index);   
	        System.out.println("protocol---->" + protocol);   
	        request.setProtocol(protocol);   
	  
	    } else if (s.startsWith("Accept:")) {   
	            String accept = s.substring("Accept:".length() + 1);   
	        System.out.println("accept--->" + accept);   
	        request.setAccept(accept);   
	  
	    } else if (s.startsWith("User-Agent:")) {   
	        String agent = s.substring("User-Agent:".length() + 1);   
	        System.out.println("agent--->" + agent);   
	        request.setAgent(agent);   
	  
	    } else if (s.startsWith("Host:")) {   
	        String host = s.substring("Host:".length() + 1);   
	        System.out.println("host--->" + host);   
	        request.setHost(host);   
	  
	    } else if (s.startsWith("Accept-Language:")) {   
	        String language = s.substring("Accept-Language:".length() + 1);   
	        System.out.println("language--->" + language);   
	        request.setLanguage(language);   
	  
	    } else if (s.startsWith("Accept-Charset:")) {   
	        String charset = s.substring("Accept-Charset:".length() + 1);   
	        System.out.println("charset--->" + charset);   
	        request.setCharset(charset);   
	    } else if (s.startsWith("Accept-Encoding:")) {   
	        String encoding = s.substring("Accept-Encoding:".length() + 1);   
	        System.out.println("encoding--->" + encoding);   
	        request.setEncoding(encoding);   
	  
	    } else if (s.startsWith("Connection:")) {   
	        String connection = s.substring("Connection:".length() + 1);   
	        System.out.println("connection--->" + connection);   
	        request.setConnection(connection);   
	    }   
	  
	}  

	
}
