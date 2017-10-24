package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import system.DateAndClock;

public class SignInModel extends DateAndClock{
	
	public static String getOwnerName() {
		if (checkUserPresence()) {
			return userFullName() + "'s";
		} else {
			return "Your";
		}
	}
	
	
	public static boolean openingDateUpdate() {
			return dateChecker();
	}
	
	
	public static boolean authentication(String username, String password) {
		String sql = "SELECT ownerName \n"
				+ "FROM Credentials \n"
				+ "WHERE username = ? AND password = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public String showSecurityQuestion() {
		String question = null;
		String sql = "SELECT securityQuestion \n"
				+ "FROM Credentials \n"
				+ "WHERE ID = 1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			question = result.getString("securityQuestion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return question;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(authentication("rakib", "1123"));
//	}
}
