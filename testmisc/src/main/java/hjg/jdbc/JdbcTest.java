package hjg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcTest {

	public void connOracle() throws Exception {
		// 1、Oracle8/8i/9i数据库（thin模式）
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // orcl为数据库的SID
		String user = "test";
		String password = "test";
		Connection conn = DriverManager.getConnection(url, user, password);
	}

	public void connDB2() throws Exception {
		// 2、DB2数据库
		// Class.forName("com.ibm.db2.jdbc.app.DB2Driver ").newInstance();
		String url = "jdbc:db2://localhost:5000/sample"; // sample为你的数据库名
		String user = "admin";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
	}

	public void connSqlServer() throws Exception {
		// 3、Sql Server7.0/2000数据库
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
		String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=mydb";
		// mydb为数据库
		String user = "sa";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
	}

	public void connSybase() throws Exception {
		// 4、Sybase数据库
		Class.forName("com.sybase.jdbc.SybDriver").newInstance();
		String url = " jdbc:sybase:Tds:localhost:5007/myDB"; // myDB为你的数据库名
		Properties sysProps = System.getProperties();
		sysProps.put("user", "userid");
		sysProps.put("password", "user_password");
		Connection conn = DriverManager.getConnection(url, sysProps);
	}

	public void connInformix() throws Exception {
		// 5、Informix数据库
		Class.forName("com.informix.jdbc.IfxDriver").newInstance();
		String url = "jdbc:informix-sqli://123.45.67.89:1533/myDB:INFORMIXSERVER=myserver;	user=testuser;password=testpassword"; // myDB为数据库名
		Connection conn = DriverManager.getConnection(url);
	}

	public void connMySQL() throws Exception {
		// 6、MySQL数据库
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		String url = "jdbc:mysql://localhost/myDB?user=soft&password=soft1234&useUnicode=true&characterEncoding=8859_1";
		// myDB为数据库名
		Connection conn = DriverManager.getConnection(url);
	}

	public void connPostgreSQL() throws Exception {
		// 7、PostgreSQL数据库
		Class.forName("org.postgresql.Driver").newInstance();
		String url = "jdbc:postgresql://localhost/myDB"; // myDB为数据库名
		String user = "myuser";
		String password = "mypassword";
		Connection conn = DriverManager.getConnection(url, user, password);

	}

	public void connAccess() throws Exception {
		// 8、access数据库
		Connection conn = DriverManager.getConnection(
				"jdbc:odbc:Driver={MicroSoft Access Driver(*.mdb)};DBQ=C:/data/Access/test1.mdb", "dba", "sql");

	}

	public void test() {

	}
}
