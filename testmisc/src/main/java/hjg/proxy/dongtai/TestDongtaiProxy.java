package hjg.proxy.dongtai;

public class TestDongtaiProxy {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
		bookFacade.addBook();
	}
}
