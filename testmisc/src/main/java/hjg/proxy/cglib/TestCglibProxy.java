package hjg.proxy.cglib;

public class TestCglibProxy {
	public static void main(String[] args) {
		BookFacadeCglib cglib=new BookFacadeCglib();
		BookFacadeImpl2 bookCglib = (BookFacadeImpl2)cglib.getInstance(new BookFacadeImpl2());
		bookCglib.addBook();
	}
}
