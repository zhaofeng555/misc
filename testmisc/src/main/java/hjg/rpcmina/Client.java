package hjg.rpcmina;
import java.net.InetSocketAddress;

import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoConnectorConfig;
import org.apache.mina.transport.socket.nio.SocketConnector;
public class Client {
    public static void main(String[] args) throws Exception {
        // Create TCP/IP connector.
        SocketConnector connector = new SocketConnector();
        // Set connect timeout.
        ((IoConnectorConfig) connector.getDefaultConfig())
                .setConnectTimeout(15);
        ClientIoHandler handler = new ClientIoHandler();
        // Start communication.
        ConnectFuture cf = connector.connect(new InetSocketAddress("localhost",
                8080), handler);
        // Wait for the connection attempt to be finished.
        System.out.println("start to join");
        cf.join();
        cf.getSession();
        System.out.println("test get value="
                + RpcClientImpl.getInstance().getStringValue("adsf", 222,
                        new Apple()));
        System.out.println("test get int value="
                + RpcClientImpl.getInstance().getIntValue());
        System.out.println("test call process start.");
        RpcClientImpl.getInstance().printPrice();
        System.out.println("test call process end.");
    }
}