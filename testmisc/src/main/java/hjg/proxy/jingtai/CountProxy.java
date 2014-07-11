package hjg.proxy.jingtai;

public class CountProxy implements Count {

	private Count count;

	public CountProxy(CountImpl count) {
		this.count = count;
	}

	@Override
	public void queryCount() {
		System.out.println("事件调度前");
		count.queryCount();
		System.out.println("事件调度后");
	}

}
