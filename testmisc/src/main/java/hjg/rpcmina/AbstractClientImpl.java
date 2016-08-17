package hjg.rpcmina;
import org.apache.mina.common.IoSession;
public abstract class AbstractClientImpl {
    
    IoSession session = null;
    ClientIoHandler handler = null;
    public IoSession getSession() {
        return session;
    }
    public void setSession(IoSession session) {
        this.session = session;
    }
    public ClientIoHandler getHandler() {
        return handler;
    }
    public void setHandler(ClientIoHandler handler) {
        this.handler = handler;
    }
}