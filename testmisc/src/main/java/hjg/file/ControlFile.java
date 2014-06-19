package hjg.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ControlFile {

	public static void fileCopy(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size) {
				position += inChannel
						.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}

	public static void main(String[] args) {
		File f1 = new File("resource/test.xls");
		File f2 = new File("resource/testbak.xls");
		try {
			fileCopy(f1, f2);
			System.out.println("copy complete ............");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
