package hjg.jdbc;

import java.sql.*;

/**
 * @author hjg
 **/
public class ConnectionDemo {
	private static Connection conn;
	private static Statement ps;
	private static ResultSet rs;
	// private static final String DRIVER ="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	// private static final String URL ="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=Northwind";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://211.68.72.121:3306/massi?rewriteBatchedStatements=true&autoReconnect=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=utf8";
	private static final String USER = "masadmin";
	private static final String PASS = "5t6y7u8i";

	public ConnectionDemo() {
		ConnectionDemo.getConnection();
	}

	public static Connection getConnection() {
		System.out.println("连接中...");
		try {
			Object o = Class.forName(ConnectionDemo.DRIVER).newInstance();
			System.out.println(" o = " + o.toString());
			conn = DriverManager.getConnection(ConnectionDemo.URL, ConnectionDemo.USER, ConnectionDemo.PASS);
			System.out.println("成功连接");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Statement getStatement(String sql) {
		System.out.println("执行SQL语句中...");
		try {
			ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			if (sql.substring(0, 6).equals("select")) {
				rs = ps.executeQuery(sql);
				System.out.println("执行完查询操作,结果已返回ResultSet集合");
			} else if (sql.substring(0, 6).equals("delete")) {
				ps.executeUpdate(sql);
				System.out.println("已执行完毕删除操作");
			} else if (sql.substring(0, 6).equals("insert")) {
				ps.executeUpdate(sql);
				System.out.println("已执行完毕增加操作");
			} else {
				ps.executeUpdate(sql);
				System.out.println("已执行完毕更新操作");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public static ResultSet getResultSet() {
		System.out.println("查询结果为:");
		return rs;
	}

	public static void closeConnection() {
		System.out.println("关闭连接中...");
		try {
			if (rs != null) {
				rs.close();
				System.out.println("已关闭ResultSet");
			}
			if (ps != null) {
				ps.close();
				System.out.println("已关闭Statement");
			}
			if (conn != null) {
				conn.close();
				System.out.println("已关闭Connection");
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		ConnectionDemo.getConnection();
		// String sql = "delete from type where id = 1";
		// ConnectionDemo.getStatement(sql);
		// String sql2 = "insert into type values(1,'教学设备')";
		// ConnectionDemo.getStatement(sql2);
		String sql1 = "select 1 from dual";
		ConnectionDemo.getStatement(sql1);
		ResultSet rs = ConnectionDemo.getResultSet();
		// System.out.println("编号 "+"类    型");
		try {
			while (rs.next()) {
				System.out.print(" " + rs.getInt(1) + "  ");
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionDemo.closeConnection();
	}
}
