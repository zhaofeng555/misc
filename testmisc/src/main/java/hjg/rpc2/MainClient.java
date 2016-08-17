package hjg.rpc2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MainClient {

	public static void main(String[] args) throws Exception {
		SocketChannel client = SocketChannel.open();
		client.configureBlocking(false);
		Selector selector = Selector.open();
		client.register(selector, SelectionKey.OP_CONNECT);
		client.connect(new InetSocketAddress("localhost", 19999));

		String message = "client test";
		ByteBuffer bb = ByteBuffer.allocate(message.length());
		boolean flag = true;

		while (flag) {
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();
				it.remove();
				if (key.isConnectable()) {
					System.out.println("客户端连接上");
					SocketChannel sc = (SocketChannel) key.channel();
					if (sc.isConnectionPending())
						sc.finishConnect();
					sc.register(selector, SelectionKey.OP_WRITE);
				}
				if (key.isWritable()) {
					System.out.println("客户端可以写");
					SocketChannel sc = (SocketChannel) key.channel();
					bb.clear();
					bb.put(message.getBytes());
					bb.flip();
					sc.write(bb);
					// 发完一条信息，退出发送，关闭连接。
					flag = false;
				}
			}
		}
		// 关闭连接
		client.close();
	}
}