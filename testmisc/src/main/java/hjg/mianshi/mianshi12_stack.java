package hjg.mianshi;

/**
 * @author hjg
 * @version 创建时间：2011-1-22上午10:31:59
 **/
public class mianshi12_stack {
	public static void main(String[] args) throws Exception {
		Stack st = new Stack(10);
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		while (st.top != -1) {
			System.out.println(st.pop());
		}
	}

}

class Stack {
	int[] data;
	int maxSize;
	int top;

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		data = new int[maxSize];
		top = -1;
	}

	public boolean push(int num) {
		if (top + 1 == maxSize) {
			System.out.println("栈已经满了");
			return false;
		}
		data[++top] = num;
		return true;
	}

	public int pop() throws Exception {
		if (top == -1) {
			throw new Exception("栈已经空了");
		}

		return data[top--];
	}

}
