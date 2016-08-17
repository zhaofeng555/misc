package hjg.rpcmina;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoSession;
import org.apache.mina.handler.StreamIoHandler;
public class ClientIoHandler extends StreamIoHandler{
    IoSession session = null;
    
    List implList = new ArrayList();
    
    Object resultObject;
    Object lock = new Object();
    
    public ClientIoHandler(){
        //init impls.
        RpcClientImpl impl = RpcClientImpl.getInstance();
        implList.add(impl);
        //impl.setHandler(this);
    }
    
    private void initImpls(){
        Iterator it = implList.iterator();
        while(it.hasNext())
        {
            Object obj = it.next();
            if(obj instanceof AbstractClientImpl){
                AbstractClientImpl impl = (AbstractClientImpl)obj;
                impl.setSession(session);
                System.out.println("add this handler");
                impl.setHandler(this);
            }
        }
    }
    
    //收到服务端消息后的处理，框架内部为异步。在应用中改为同步。
    public void messageReceived(IoSession session, Object buf) {
        System.out.println("receive message.");
        
        System.out.println(buf.toString());
        try{
            if(buf instanceof ByteBuffer){
                Properties prop = (Properties)(((ByteBuffer)buf).getObject());
                System.out.println("received prop="+prop);
                String mark = prop.getProperty("mark");
                //根据mark类型，选择不同处理。
                if(mark.equals("REPLYCALL")){
                    Object obj = prop.get("Object");
                    synchronized(lock){
                        System.out.println("result="+obj);
                        resultObject = obj;
                        lock.notify();
                    }
                }else if(mark.equals("BROADCAST")){
                    Object obj = prop.get("Object");
                    System.out.println("BROADCAST obj="+obj);
                }else if(mark.equals("NOTIFY")){
                    Object obj = prop.get("Object");
                    System.out.println("NOTIFY obj="+obj);
                }else{
                    System.out.println("unknow mark.mark="+mark);
                }
            }else{
                System.out.println("class type error.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    protected void processStreamIo(IoSession session, InputStream is, OutputStream os) {
        System.out.println("process stream info,"+session.getRemoteAddress());
    }
    public void sessionOpened(IoSession session) {
        // Set reader idle time to 10 seconds.
        // sessionIdle(...) method will be invoked when no data is read
        // for 10 seconds.
       System.out.println("open session..");
        this.session = session;
       initImpls();
       session.setIdleTime(IdleStatus.READER_IDLE, 10);
    }
    public void sessionClosed(IoSession session) {
        // Print out total number of bytes read from the remote peer.
        System.err.println("Total " + session.getReadBytes() + " byte(s)");
    }
    public void sessionIdle(IoSession session, IdleStatus status) {
        // Close the connection if reader is idle.
        if (status == IdleStatus.READER_IDLE)
            session.close();
    }
}