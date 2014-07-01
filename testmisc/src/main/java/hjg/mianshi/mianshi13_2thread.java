package hjg.mianshi;


public class mianshi13_2thread {
	public static void main(String[] args) {
		TestThread thread = new TestThread();
		for(int i=0; i<2; i++){
			Thread inc = new Thread(new Inc(thread));
			Thread dec = new Thread(new Dec(thread));
			
			inc.start();
			dec.start();			
		}
	}
}

class TestThread {
	private int j;

	public synchronized void inc() {
		j++;
		System.out.println(Thread.currentThread().getName() + "-inc:" + j);
	}

	public synchronized void dec() {
		j--;
		System.out.println(Thread.currentThread().getName() + "-dec:" + j);
	}
}

class Inc implements Runnable {
	private TestThread thread;

	public Inc(TestThread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		thread.inc();
	}
}

class Dec implements Runnable {
	private TestThread thread;

	public Dec(TestThread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		this.thread.dec();
	}
}
