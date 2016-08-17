package hjg.rpcmina;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.handler.StreamIoHandler;
public class ServerHandler extends StreamIoHandler {
    Hashtable sessionMgr = new Hashtable();
    List serverList = new ArrayList();
    ServerHandler() {
        serverList.add(new RpcServerImpl());
    }
    public void messageReceived(IoSession session, Object buf) {
        SocketAddress adr = session.getRemoteAddress();
        System.out.println("remote address is =" + adr.toString());
        System.out.println("buf=" + buf.toString());
        if (buf instanceof ByteBuffer) {
            ByteBuffer bb = (ByteBuffer) buf;
            System.out.println("bbb===" + bb);
            try {
                Properties prop = (Properties) bb.getObject();
                System.out.println("prop==" + prop);
                String interfaceName = (String) prop.get("interface");
                Iterator it = serverList.iterator();
                while (it.hasNext()) {// 查找实例
                    Object serobj = it.next();
                    Class[] clazz = serobj.getClass().getInterfaces();
                    if (isContains(clazz, interfaceName)) {// 找到相应实例
                        System.out.println("find.." + interfaceName);
                        int argc = Integer.parseInt(String.valueOf(prop
                                .get("argc")));
                        Class[] types = null;// 参数类型数组
                        Object[] args = null;// 参数对象数组
//                       不为最大值时表示有正常参数，否则为无参数。
                        if (argc != Integer.MAX_VALUE) {
                            // 重组参数列表
                            types = new Class[argc];
                            args = new Object[argc];
                            List typeList = (List) prop.get("types");
                            List argList = (List) prop.get("args");
                            for (int i = 0; i < argc; i++) {
                                args[i] = argList.get(i);
                                types[i] = (Class) typeList.get(i);
                                System.out.println("arg###=" + args[i]
                                        + "   type@@@=" + types[i]);
                            }
                        }
                        String methodName = prop.getProperty("method");
                        Method method = serobj.getClass().getMethod(methodName,
                                types);
                        //调用
                        Object resultObject = method.invoke(serobj, args);
                        //回复
                        replyCall(session.getRemoteAddress().toString(),resultObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //广播操作，广播消息或事件.标记为"BROADCAST" 
    public void brocastMessage(Object obj){
        Enumeration enu = sessionMgr.keys();
        while (enu.hasMoreElements()) {
            String addr = (String) enu.nextElement();
            sendMessage("BROADCAST",addr,obj);
        }
    }
    
    //通知操作，通知消息或事件。标记为"NOTIFY"
    public void notify(String addr,Object obj){
        sendMessage("NOTIFY",addr,obj);
    }
    
    //响应RPC调用。
    public void replyCall(String addr,Object obj){
        sendMessage("REPLYCALL",addr,obj);
    }
    
    private void sendMessage(String mark,String addr,Object obj){
        Object sessionObj = sessionMgr.get(addr);
        if(sessionObj!=null){
            IoSession session = (IoSession)sessionObj;
            if(!session.isConnected()){
                return;
            }
            Properties resultProp = new Properties();
            resultProp.setProperty("mark",mark);
            if(obj!=null) //对于无返回的情况。
                resultProp.put("Object",obj);
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.setAutoExpand(true);
            bb.putObject(resultProp);
            bb.flip();
            session.write(bb);
        }else{
            System.out.println("session null.addr="+addr);
        }
    }
    
    protected void processStreamIo(IoSession session, InputStream ins,
            OutputStream ous) {
        System.out.println("processStreamIo is called.");
    }
    private boolean isContains(Class[] clazz, String ifName) {
        for (int i = 0; i < clazz.length; i++) {
            if (clazz[i].getName().equals(ifName))
                return true;
        }
        return false;
    }
    public void sessionOpened(IoSession ssn) {
        System.out.println("session open for " + ssn.getRemoteAddress());
        sessionMgr.put(ssn.getRemoteAddress().toString(),ssn);
    }
    public void exceptionCaught(IoSession ssn, Throwable cause) {
        cause.printStackTrace();
        sessionMgr.remove(ssn.getRemoteAddress().toString());
        ssn.close();
    }
    public void sessionClosed(IoSession ssn) throws Exception {
        System.out.println("session closed from " + ssn.getRemoteAddress());
        sessionMgr.remove(ssn.getRemoteAddress().toString());
    }
}