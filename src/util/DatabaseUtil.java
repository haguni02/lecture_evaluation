package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	
	private static DatabaseUtil instance;
	
	private DatabaseUtil() {}
	
	public static DatabaseUtil getInstance() {
		if (instance == null) instance = new DatabaseUtil();
		return instance;
	}

	public Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/LECTUREEVALUATION?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "gkrnsl02";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
