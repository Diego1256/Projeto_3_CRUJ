package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static final String url = "jdbc:postgresql://localhost:5432/bd_aula03";
	public static final String user = "postgre";
	public static final String password = "coti";
	public static final String driver = "org.postgresql.Driver";

	public static Connection createConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
}
