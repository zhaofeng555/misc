package hjg.js;

import java.io.File;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author hjg 
 * @version   创建时间：2010-3-28上午12:07:16
 * 类说明
 *
 **/
public class Java2Js {

	public static void main(String[] args) throws Exception {
		ScriptEngineManager mgr = new ScriptEngineManager(); 
		//Java调用js时， 需要ScriptEngine。jdk下 获得ScriptEngine三种方式
		ScriptEngine engine = mgr.getEngineByExtension("js");
		
//		ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
//		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
//		testUsingJDKClasses(engine);
//		testScriptInterface(engine);
//		testInvokeScriptMethod(engine);
		testScriptVariables(engine);
	}
	
	/**   
	 * 演示脚本语言如何使用JDK平台下的类,调用一个JDK平台的Swing窗口   
	 *   
	 * @param engine ScriptEngine实例   
	 * @return void   
	 * */       
	private static void testUsingJDKClasses(ScriptEngine engine)    throws Exception {    
	    // Packages是脚本语言里的一个全局变量,专用于访问JDK的package    
	    String js = "function doSwing(t){var f=new Packages.javax.swing.JFrame(t);f.setSize(400,300);f.setVisible(true);}";    
	    engine.eval(js);    
	    // Invocable 接口: 允许java平台调用脚本程序中的函数或方法    
	    Invocable inv = (Invocable) engine;    
	    // invokeFunction()中的第一个参数就是被调用的脚本程序中的函数，第二个参数是传递给被调用函数的参数；    
	    inv.invokeFunction("doSwing", "Scripting Swing");    
	}   
	
	/**   
	 * 演示脚本语言如何实现Java的接口,启动线程来运行script提供的方法   
	 *   
	 * @param engine ScriptEngine实例   
	 * @return void   
	 * */       
	private static void testScriptInterface(ScriptEngine engine)    throws ScriptException {    
	    String script = "var obj = new Object(); obj.run = function() { println('run method called'); }";    
	    engine.eval(script);    
	    Object obj = engine.get("obj");    
	    Invocable inv = (Invocable) engine;    
	        
	    Runnable r = inv.getInterface(obj, Runnable.class);    
	    Thread th = new Thread(r);    
	    th.start();    
	} 

	/**  
	 * 演示如何在Java中调用脚本语言的方法，通过JDK平台给script的方法中的形参赋值  
	 *  
	 * @param engine ScriptEngine实例  
	 * @return void  
	 * */          
	private static void testInvokeScriptMethod(ScriptEngine engine) throws Exception {   
	    String script = "function helloFunction(name) { return 'Hello everybody,' + name;}";   
	    engine.eval(script);   
	    Invocable inv = (Invocable) engine;   
	    String res = (String) inv.invokeFunction("helloFunction", "Scripting");   
	    System.out.println("res:" + res);   
	}
	
	/**   
	 * 演示如何暴露Java对象为脚本语言的全局变量,同时演示将File实例赋给脚本语言，并通过脚本语言取得它的各种属性值   
	 *   
	 * @param engine ScriptEngine实例   
	 * @return void   
	 * */           
	private static void testScriptVariables(ScriptEngine engine)    throws ScriptException {    
	    File file = new File("resource/test.txt");    
	    engine.put("f", file);    
	    engine.eval("println('Total Space:'+f.getTotalSpace())");    
	    engine.eval("println('Path:'+f.getPath())");    
	}   
}
