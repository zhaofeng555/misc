package hjg.rpc2;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MainServer {
	private static final int port = 19999;
	private static ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

	public static void main(String[] args) throws Exception {
		ServerSocketChannel server = ServerSocketChannel.open();
		Selector sel = Selector.open();
		server.socket().bind(new InetSocketAddress(port));
		// 无阻塞
		server.configureBlocking(false);
		// 绑定连接事件。
		server.register(sel, SelectionKey.OP_ACCEPT);
		System.out.println("server start");
		while (true) {
			sel.select();
			Iterator<SelectionKey> iter = sel.selectedKeys().iterator();
			while (iter.hasNext()) {
				SelectionKey key = (SelectionKey) iter.next();
				iter.remove();
				// 判断是否有新的连接到达
				if (key.isAcceptable()) {
					System.out.println("有新连接");
					SocketChannel sc = server.accept();
					sc.configureBlocking(false);
					sc.register(sel, SelectionKey.OP_READ);
				}
				// 判断是否可读取
				if (key.isReadable()) {
					SocketChannel sc = (SocketChannel) key.channel();
					sc.configureBlocking(false);
					int count = sc.read(buffer);
					if (count <= 0) {
						System.out.println("客户端已经关闭了");
						sc.close();
					} else {
						System.out.println("有数据过来了");
						buffer.flip();
						byte[] bytes = new byte[buffer.remaining()];
						buffer.get(bytes);
						String msg = new String(bytes);
						System.out.println("收到信息>>" + msg);
						buffer.clear();
					}

				}
			}
		}
	}
}