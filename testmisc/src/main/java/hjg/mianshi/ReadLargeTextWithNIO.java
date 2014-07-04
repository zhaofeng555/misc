package hjg.mianshi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 用NIO读取大文本（1G以上）
 */
public class ReadLargeTextWithNIO {
	public static void main(String... args) throws Exception {
		readBigFile3();
	}

	public static void readBigFile3() throws Exception {
		final int BUFFER_SIZE = 1024 * 1024;// 缓冲大小为1M

		File file = new File("d:/adsys.sql");
		long fileLen = file.length();
		MapMode mode = FileChannel.MapMode.READ_ONLY;
		long rfPos = 0;
		long rfLen = fileLen * 1 / 8;
		int bufLen = 0;
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		FileChannel fc = raf.getChannel();
		MappedByteBuffer inputBuf = null;
		for (int z = 1; z < 9; z++) {
			rfPos = fileLen * (z - 1) / 8;
			inputBuf = fc.map(mode, rfPos, rfLen);
			byte[] dst = new byte[BUFFER_SIZE];

			for (int pos = 0; pos < inputBuf.capacity(); pos += BUFFER_SIZE) {
				bufLen = Math.min(inputBuf.capacity() - pos, BUFFER_SIZE);

				for (int i = 0; i < bufLen; i++) {
					dst[i] = inputBuf.get(pos + i);
				}
//				System.out.println(new String(dst, "GBK"));
				System.out.println(new String(dst, "UTF-8"));
			}
		}
		fc.close();
		raf.close();
	}

	public static void readBigFile2() throws Exception {
		// final int BUFFER_SIZE = 0x1200000;// 缓冲大小为12M
		final int BUFFER_SIZE = 1024 * 1024;// 缓冲大小为1M

		System.out.println("缓存大小：" + BUFFER_SIZE);

		File f = new File("d:/mianshi.txt");

		int len = 0;
		Long start = System.currentTimeMillis();
		for (int z = 8; z > 0; z--) {
			MappedByteBuffer inputBuffer = new RandomAccessFile(f, "r")
					.getChannel().map(FileChannel.MapMode.READ_ONLY,
							f.length() * (z - 1) / 8, f.length() * 1 / 8);
			byte[] dst = new byte[BUFFER_SIZE];// 每次读出12M的内容
			for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {
				if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {
					for (int i = 0; i < BUFFER_SIZE; i++)
						dst[i] = inputBuffer.get(offset + i);
				} else {
					for (int i = 0; i < inputBuffer.capacity() - offset; i++)
						dst[i] = inputBuffer.get(offset + i);
				}
				int length = (inputBuffer.capacity() % BUFFER_SIZE == 0) ? BUFFER_SIZE
						: inputBuffer.capacity() % BUFFER_SIZE;

				String rs = new String(dst, 0, length);
				// System.out.println(new String(dst));
				// System.out.println(new String(dst, "UTF-8"));
				// System.out.println(new String(dst, "ISO8859-1"));
				System.out.println(new String(dst, "GBK"));
				len += rs.length();
				// System.out.println(new String(dst, 0, length).length() + "-"+ (z - 1) + "-" + (8 - z + 1));
			}
		}
		System.out.println(len);
		long end = System.currentTimeMillis();
		System.out.println("读取文件文件花费：" + (end - start) + "毫秒");
	}

	private static void readBigFile1() throws FileNotFoundException,
			IOException {
		FileInputStream fin = new FileInputStream("d:\\temp\\outlineA1.log");
		FileChannel fcin = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 50);
		while (true) {
			buffer.clear();
			int flag = fcin.read(buffer);
			if (flag == -1) {
				break;
			}
			buffer.flip();
			FileOutputStream fout = new FileOutputStream("d:\\temp\\"+ Math.random() + ".log");
			FileChannel fcout = fout.getChannel();
			fcout.write(buffer);
		}
	}
}
