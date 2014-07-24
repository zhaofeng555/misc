package hjg.mianshi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 创建一个PriorityQueue队列来保存Queue实例化的对象
 */
public class priorityQueue {

	public static void main(String[] args) {
		// 创建队列,并创建容器的容量和排序规则
		PriorityQueue<MyQueue2> list = new PriorityQueue<MyQueue2>(11, new Comparator<MyQueue2>() {
			// 创建匿名类来重写排序方法
			@Override
			public int compare(MyQueue2 o1, MyQueue2 o2) {
				// 返回排序规则
				return o1.obj - o2.obj;
			}

		});

		// 如果不重写上述方法,会出现下面的错误
		// 根据数组创建对象
		MyQueue2 queue1 = new MyQueue2(122);
		MyQueue2 queue2 = new MyQueue2(21);
		MyQueue2 queue3 = new MyQueue2(33);
		// 添加到队列中
		list.add(queue1);
		list.add(queue2);
		list.add(queue3);
		// 打印队列中的元素
		while (!list.isEmpty()) {
			System.out.println(list.poll());
		}
	}

	// 创建Queue类
	static class MyQueue2 {

		int obj;

		public MyQueue2(int obj) {
			this.obj = obj;
		}

		// 重写String的方法
		@Override
		public String toString() {
			return String.valueOf(obj);

		}

	}
}