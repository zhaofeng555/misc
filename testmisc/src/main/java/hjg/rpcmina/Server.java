package hjg.rpcmina;
import java.net.InetSocketAddress;

import org.apache.mina.common.DefaultIoFilterChainBuilder;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.common.IoAcceptorConfig;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;
import org.apache.mina.transport.socket.nio.SocketSessionConfig;
public class Server {
    /** Choose your favorite port number. */
    private static final int PORT = 8080;
    private static final boolean USE_SSL = false;
    public static void main(String[] args) throws Exception {
        IoAcceptor acceptor = new SocketAcceptor();
        IoAcceptorConfig config = new SocketAcceptorConfig();
        DefaultIoFilterChainBuilder chain = config.getFilterChain();
        ((SocketSessionConfig) config.getSessionConfig()).setReuseAddress(true);
        // Add SSL filter if SSL is enabled.
        if (USE_SSL) {
            // addSSLSupport(chain);
        }
        // Bind
        acceptor.bind(new InetSocketAddress(PORT), new ServerHandler(), config);
        System.out.println("Listening on port " + PORT);
    }
}