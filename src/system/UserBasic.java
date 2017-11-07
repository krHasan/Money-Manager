package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import operation.BalanceStatus;

public class UserBasic extends BalanceStatus {
	
	public static String userFullName() {
		String ownerNameSQL = "SELECT ownerName \n"
				+ "FROM Credentials \n"
				+ "WHERE ID=1";
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
	
	public void setUserFullName(String name) {
		String setName = "INSERT INTO Credentials (ownerName) VALUES(?)";
		String updatename = "UPDATE Credentials SET ownerName = ? WHERE ID = 1";
		
		if (checkUserPresence()) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(updatename)) {
				pstmt.setString(1, name);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(setName)) {
				pstmt.setString(1, name);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public String getUsername() {
		String username = null;
		String ownerNameSQL = "SELECT username \n"
				+ "FROM Credentials \n"
				+ "WHERE ID=1";
//		create connection and get owner name
		try (Connection conn = connector();
				Statement stmt  = conn.createStatement();
	            ResultSet result    = stmt.executeQuery(ownerNameSQL)) {
			if (checkUserPresence()) {
				username = result.getString("username");	
			}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return username;
	}
	
	
	public void setUsername(String username) {
		String setUsername = "INSERT INTO Credentials (username) VALUES(?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(setUsername)) {
			pstmt.setString(1, username);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getPassword() {
		String password = null;
		String SQL = "SELECT password \n"
				+ "FROM Credentials \n"
				+ "WHERE ID=1";
//		create connection and get owner name
		try (Connection conn = connector();
				Statement stmt  = conn.createStatement();
	            ResultSet result    = stmt.executeQuery(SQL)) {
			if (checkUserPresence()) {
				password = result.getString("password");	
			}			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return password;
	}
	
	
	public void setPassword(String password) {
		String setPassword = "INSERT INTO Credentials (password) VALUES(?)";
		String updatePassword = "UPDATE Credentials SET password = ? WHERE ID = 1";
		
		if (checkUserPresence()) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(updatePassword)) {
				pstmt.setString(1, password);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(setPassword)) {
				pstmt.setString(1, password);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static boolean checkUserPresence() {
		String ownerNameSQL = "SELECT username \n"
				+ "FROM Credentials \n"
				+ "WHERE ID=1";
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
				return false;
			}
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(checkUserPresence());
//		System.out.println(userFullName());
//	}
}
