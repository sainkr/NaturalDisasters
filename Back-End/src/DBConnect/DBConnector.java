package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static DBConnector instance = new DBConnector();
	public static DBConnector getInstance() {
		return instance;
	}
	
	//  DB 접속 변수
	private String dbURL = "jdbc:mysql://localhost:3307/PPND?serverTimezone=UTC";
	private String dbID = "PPND";
	private String dbPassword = "Security915!";
	
	public DBConnector() {
		
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (ClassNotFoundException e) {
			System.err.println("DBConnector getConnection ClassNotFoundException error");
		} catch (SQLException e) {
			System.err.println("DBConnector getConnection SQLException error");
		}
		return null;
	}
}
