package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	Connection dbConnection;
	
	public DatabaseConnection() {
		dbConnection = DatabaseConnection.connector();
	}
	
	public static Connection connector() {
		// SQLite connection string
        Connection conn = null;
        try {
        	Class.forName("org.sqlite.JDBC");
//            String url = "jdbc:sqlite::resource:database/Money_Manager.db";
            String url = "jdbc:sqlite:/home/"+System.getProperty("user.name")+"/Money_Manager.db";
//            System.out.println(System.getProperty("java.io.tmpdir"));
//        	String url = "jdbc:sqlite:Money_Manager.db";
            conn = DriverManager.getConnection(url);
//            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}
	
	
	public boolean isDBConnected() {
		try {
			return !dbConnection.isClosed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		DatabaseConnection access = new DatabaseConnection();
//		System.out.println(access.isDBConnected());
//	}
}
