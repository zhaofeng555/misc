package hjg.rpcmina;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.mina.common.ByteBuffer;
public class RpcClientImpl extends AbstractClientImpl implements RpcInterface {
    private static String IFNAME = RpcInterface.class.getName();
    
    private static RpcClientImpl instance = null;
    
    public static RpcClientImpl getInstance(){
        if(instance == null){
            instance = new RpcClientImpl();
        }
        return instance;
    }
    
    public String getStringValue(String arg0,int arg1,Apple arg2) {
        if(session!=null){
            Properties prop = new Properties();
            prop.setProperty("interface",IFNAME);
            prop.setProperty("method","getStringValue");
            prop.put("argc","3");//参数个数.
        
            //生成参数类型链表
            List typeList = new ArrayList();
            typeList.add(String.class);
            typeList.add(Integer.TYPE);
            typeList.add(Apple.class);
            
            //生成参数对象链表
            List argList = new ArrayList();
            argList.add(arg0);
            argList.add(arg1);
            argList.add(arg2);
            
            prop.put("types",typeList);
            prop.put("args",argList);
            
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.setAutoExpand( true );
            bb.putObject(prop);
            bb.flip();
            System.out.println("bbb==="+bb.toString());
            session.write(bb);
        }
        
        try {
            System.out.println("handler="+handler);
            System.out.println("lock="+handler.lock);
            printStamp("1");
            synchronized(handler.lock){
                printStamp("2");
                handler.lock.wait();
                printStamp("3");
                if(handler.resultObject!=null){
                    return String.valueOf(handler.resultObject);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    public int getIntValue() {
        if(session!=null){
            Properties prop = new Properties();
            prop.setProperty("interface",IFNAME);
            prop.setProperty("method","getIntValue");
            prop.put("argc",Integer.MAX_VALUE);
            //prop.put("object",new Object());
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.setAutoExpand( true );
            bb.putObject(prop);
            bb.flip();
            System.out.println("bbb==="+bb.toString());
            session.write(bb);
        }
        try {
            System.out.println("handler="+handler);
            System.out.println("lock="+handler.lock);
            printStamp("1");
            synchronized(handler.lock){
                printStamp("2");
                handler.lock.wait();
                printStamp("3");
                if(handler.resultObject!=null){
                    return Integer.parseInt(String.valueOf(handler.resultObject));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return Integer.MIN_VALUE;
    }
    
    public void printStamp(String str){
        System.out.println((new Date().toString())+" "+str);
    }
    public void printPrice() {
        if(session!=null){
            Properties prop = new Properties();
            prop.setProperty("interface",IFNAME);
            prop.setProperty("method","printPrice");
            prop.put("argc",Integer.MAX_VALUE);//参数个数
            
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.setAutoExpand( true );
            bb.putObject(prop);
            bb.flip();
            System.out.println("bbb==="+bb.toString());
            session.write(bb);
        }
        
        try {
            System.out.println("handler="+handler);
            System.out.println("lock="+handler.lock);
            printStamp("1");
            synchronized(handler.lock){
                printStamp("2");
                handler.lock.wait();
                printStamp("3");
                return;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}