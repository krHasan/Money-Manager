package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.ComboboxList;
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
		boolean feedback = false;
		String sql = "SELECT ownerName \n"
				+ "FROM Credentials \n"
				+ "WHERE username = ? AND password = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				feedback =  true;
			} else {
				feedback =  false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedback;
	}
	
	
	public ObservableList<String> getSecurityQuestion() {
		ObservableList<String> list = FXCollections.observableArrayList(new ComboboxList().getSecurityQuestionList());
		return list;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(authentication("rakib", "1123"));
//		System.out.println((new SignInModel()).securityQuestionAnswerIsOk("01199518105"));
//	}
}
