package hjg.annotation;


public class Tarena {

	@Order(1)
	public void studyUnix() {
		System.out.println("Unix");
	}

	@Order(8)
	public void studyEJB() {
		System.out.println("EJB");
	}

	@Order(2)
	public void studyCoreCpp() {
		System.out.println("C++");
	}

	@Order(6)
	public void studyHibernate() {
		System.out.println("Hibernate");
	}

	@Order(3)
	public void studyJDBC() {
		System.out.println("JDBC");
	}

	@Order(7)
	public void studyWeb() {
		System.out.println("Web");
	}

	@Order(4)
	public void studyCoreJava() {
		System.out.println("CoreJava");
	}
}

