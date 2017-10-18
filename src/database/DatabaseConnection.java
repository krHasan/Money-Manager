package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import system.DateAndClock;

public class DatabaseConnection extends DateAndClock {
	public static Connection connector() {
		// SQLite connection string
        Connection conn = null;
        try {
        	Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:Money_Manager.db";
            conn = DriverManager.getConnection(url);
//            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}
}
