package system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;

public class FormatManager extends DatabaseConnection {
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
	public final String getDateFormat() {
		String sql = "SELECT dateFormat \n"
				+ "FROM System_Settings \n"
				+ "WHERE ID=1";
		String format = null;
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql) ) {
			format = result.getString("dateFormat");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return format;
	}
	
//	public static void main(String[] args) {
//		FormatManager access = new FormatManager();
//		System.out.println(access.getDateFormat());
//	}

}