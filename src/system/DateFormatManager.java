package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import database.DatabaseConnection;
import javafx.util.StringConverter;

public class DateFormatManager extends StringConverter<LocalDate> {
	
	
//	return the user define date format from database
	public final String getDateFormat() {
		String sql = "SELECT dateFormat \n"
				+ "FROM System_Settings";
		String format = null;
		try (Connection conn = DatabaseConnection.connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql) ) {
			format = result.getString("dateFormat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return format;
	}
	
	
	public void setDateFormate(String format) {
		String sql = "UPDATE System_Settings SET dateFormat = ? ";
		
		try (Connection conn = DatabaseConnection.connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
			pstmt.setString(1, format);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public final String getTimeFormate() {
		String sql = "SELECT timeFormat \n"
				+ "FROM System_Settings";
		String format = null;
		try (Connection conn = DatabaseConnection.connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql) ) {
			format = result.getString("timeFormat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return format;

	}
	
	
	public void setTimeFormate(String format) {
		String sql = "UPDATE System_Settings SET timeFormat = ? ";
		
		try (Connection conn = DatabaseConnection.connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
			pstmt.setString(1, format);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public String toString(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(getDateFormat());
		String text = null;
		if (date != null) {
			text = dtFormatter.format(date);
		}
		return text;
	}


	@Override
	public LocalDate fromString(String stringDate) {
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(getDateFormat());
		LocalDate date = null;
		if (stringDate != null && !stringDate.trim().isEmpty()) {
			date = LocalDate.parse(stringDate, dtFormatter);
		}
		return date;
	}
	
	
//	public static void main(String[] args) {
//		FormatManager access = new FormatManager();
//		System.out.println(access.getDateFormat());
//	}

}