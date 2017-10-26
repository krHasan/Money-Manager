package system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import database.DatabaseConnection;
import javafx.util.StringConverter;

public class DateFormatManager extends StringConverter<LocalDate> {
	public static final String TIME_h = "h:mm:ss a";
	public static final String TIME_hh = "hh:mm:ss a";
	public static final String TIME_H = "H:mm:ss";
	public static final String TIME_HH = "HH:mm:ss";
	
	public static final String DATEddMMMM = "dd MMMM yyyy";
	public static final String DATEddMMM = "dd MMM, yyyy";
	public static final String DATEddMM = "dd-MM-yyyy";
	public static final String DATEEEddMMM = "EE dd MMMM, yyyy";
	public static final String DATEMMM = "MMMM dd, yyyy";
	
	
//	return the user define date format from database
	@SuppressWarnings("static-access")
	public final String getDateFormat() {
		String sql = "SELECT dateFormat \n"
				+ "FROM System_Settings \n"
				+ "WHERE ID=1";
		String format = null;
		try (Connection conn = new DatabaseConnection().connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql) ) {
			format = result.getString("dateFormat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return format;
	}

	
	@SuppressWarnings("static-access")
	public final String getTimeFormate() {
		String sql = "SELECT timeFormat \n"
				+ "FROM System_Settings \n"
				+ "WHERE ID=1";
		String format = null;
		try (Connection conn = new DatabaseConnection().connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql) ) {
			format = result.getString("timeFormat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return format;

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