package hjg.mianshi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 多线程下写文件
 * @author owen.huang
 *
 */

/**
 * 将要写入文件的数据存入队列中
 */
class Creater implements Runnable {
	private ConcurrentLinkedQueue<String> queue;
	private String contents;

	public Creater() {
	}

	public Creater(ConcurrentLinkedQueue<String> queue, String contents) {
		this.queue = queue;
		this.contents = contents;
	}

	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		queue.add(contents);
	}
}

/**
 * 将队列中的数据写入到文件
 */
class DealFile implements Runnable {
	private FileOutputStream out;
	private ConcurrentLinkedQueue<String> queue;

	public DealFile() {
	}

	public DealFile(FileOutputStream out, ConcurrentLinkedQueue<String> queue) {
		this.out = out;
		this.queue = queue;
	}

	public void run() {
		while (true) {// 循环监听
			if (!queue.isEmpty()) {
				try {
					out.write(queue.poll().getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println(queue);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 测试类
 */

public class TestMultipleWriteFile {
	public static void main(String[] args) throws FileNotFoundException {
//		FileOutputStream out = new FileOutputStream(new File("E:" + File.separator + "test.txt"), true);
		FileOutputStream out = new FileOutputStream(new File("resource/mutiltest.txt"), true);
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

		for (int j = 0; j < 10; j++) {
			new Thread(new Creater(queue, j + "--")).start();// 多线程往队列中写入数据
		}
		new Thread(new DealFile(out, queue)).start();// 监听线程，不断从queue中读数据写入到文件中
		
	}
}