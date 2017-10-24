package system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import operation.GoToOperation;

public class UserBasic extends GoToOperation {
//	query to get owner name form database
	static String ownerNameSQL = "SELECT ownerName \n"
								+ "FROM Credentials \n"
								+ "WHERE ID=1";
	
	public static String userFullName() {
//		create connection and get owner name		
		try (Connection conn = connector();
				Statement stmt  = conn.createStatement();
	            ResultSet result    = stmt.executeQuery(ownerNameSQL)) {
				
				if(result.next()) {
					return result.getString("ownerName");
				} else {
					return "Your";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return " ";
	}
	
	
	public static boolean checkUserPresence() {
//		create connection and get owner name
		try (Connection conn = connector();
				Statement stmt  = conn.createStatement();
	            ResultSet result    = stmt.executeQuery(ownerNameSQL)) {
				
				if(result.next()) {
					return true;
				} else {
					return false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
//	public static void main(String[] args) {
//		System.out.println(checkUserPresence());
//		System.out.println(userFullName());
//	}
}
