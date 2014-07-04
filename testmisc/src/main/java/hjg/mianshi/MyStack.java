package hjg.mianshi;


public class MyStack<T> {
	/**
	 * @param sArray
	 *            数组
	 * @param INCREASE_SIZE
	 *            栈每次自增大小
	 * @param maxSize
	 *            为栈的大小
	 * @param top
	 *            栈顶
	 */
	private Object[] sArray;
	private int initialSize;
	private int top;
	private final static int INCREASE_SIZE = 50;

	/**
	 * @param T
	 * @param i
	 *            栈的初始大小
	 */
	public MyStack(int initialSize)// Object[][] T)
	{
		this.initialSize = initialSize;
		sArray = new Object[initialSize];
		top = -1;
	}

	/**
	 * 从栈顶插入元素
	 * 
	 * @param node
	 *            入栈的节点
	 */
	public void push(T node) {
		if (!this.isFull()) {
			this.sArray[++top] = node;
		} else {
			this.initialSize += INCREASE_SIZE;
			this.sArray[++top] = node;
		}
	}

	/**
	 * 从栈顶取出元素
	 * 
	 * @return
	 */
	public Object pop() {
		if (!this.isEmpty()) {
			return sArray[top--];
		} else {
			return null;
		}
	}

	/**
	 * 返回栈顶的位置
	 */
	public Object peek() {
		return this.sArray[top];
	}

	/**
	 * 判断栈是否为空
	 */
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * 判断栈是否已满
	 * 
	 * @return 若栈已经装满，返回true
	 */
	public boolean isFull() {
		return (top == initialSize - 1);
	}
}


