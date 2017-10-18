package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignInSQL extends DatabaseConnection {
	
	public static String ownerNameSQL() {
//		query to get owner name form database
		String sql = "SELECT ownerName \n"
				+ "FROM Credentials \n"
				+ "WHERE ID=1";
//		create connection and get owner name
		try (Connection conn = connector();
			 Statement stmt  = conn.createStatement();
             ResultSet result    = stmt.executeQuery(sql)) {
			
			if(result.next()) {
				return result.getString("ownerName") + "'s";
			} else {
				return "Your";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "null";
	}
	
	public static boolean outDateMsg() {
		
		return false;
	}
}
