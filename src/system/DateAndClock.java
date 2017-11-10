package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndClock extends UserBasic {
	
/*	check whether today's date is before or after the last opening date
	return true if today's date is before or equal from last opening date
	and return false if it's not  */
	public static boolean dateChecker() {
		String DbDateString = null;
		String todayDateString = null;
		Date DbDate = null;
    	Date todayDate = null;
		
//    	get today's date as string
		DateFormat dateFormat = new SimpleDateFormat((new DateFormatManager()).getDateFormat());
		todayDateString = dateFormat.format(Calendar.getInstance().getTime());
		
//		get last opening date from database as string
		String sql = "SELECT lastAccessDate \n"
					+ "FROM  Current_Status \n"
					+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)){
			
			DbDateString = result.getString("lastAccessDate");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
//		convert both sting date to Date format
		try {
			DbDate = new SimpleDateFormat((new DateFormatManager()).getDateFormat()).parse(DbDateString);
			todayDate = new SimpleDateFormat((new DateFormatManager()).getDateFormat()).parse(todayDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
//		check date is before or after or equal
    	try {
			if (DbDate.compareTo(todayDate) > 0) {
			    return false;
			} else if (DbDate.compareTo(todayDate) < 0) {
				return true;
			} else if (DbDate.compareTo(todayDate) == 0) {
				return true;
			}
		} catch (Exception e) {}
    	
    	return true;
	}
	
	
	public static String timeNow() {
		DateFormat timeFormat = new SimpleDateFormat(new DateFormatManager().getTimeFormate());
		Calendar now = Calendar.getInstance();
    	String timeNow = timeFormat.format(now.getTime());
		return timeNow;
	}
	
	
	public static String getMonth() {
		DateFormat monthFormat = new SimpleDateFormat("MMM-yy");
		Calendar today = Calendar.getInstance();
    	String thisMonth = monthFormat.format(today.getTime());
		return thisMonth;
	}
	
	
	public static String getYear() {
		DateFormat yearFormat = new SimpleDateFormat("yyyy");
		Calendar today = Calendar.getInstance();
    	String thisYear = yearFormat.format(today.getTime());
		return thisYear;
	}
	
	
	public void updateLastAccessDate() {
		String sql = "UPDATE Current_Status SET lastAccessDate = ? ";
		
//    	get today's date as string
		DateFormat dateFormat = new SimpleDateFormat((new DateFormatManager()).getDateFormat());
		String todayDate = dateFormat.format(Calendar.getInstance().getTime());
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, todayDate);
			
			pstmt.executeUpdate();
		} catch (Exception e) {}
	}
	
	
	public static boolean getWeekStatus() {
		String sql = "SELECT weekNumber FROM System_Settings WHERE ID = 1";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			if (result.getString("weekNumber").equals("true")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void setWeekStatus(boolean weekNumber) {
		String sql = "UPDATE System_Settings SET weekNumber = ? ";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			if (weekNumber) {
				pstmt.setString(1, "true");
			} else {
				pstmt.setString(1, "false");
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addMonth() {
		String dbLastMonth = "No Month";
		
		String getLastMonth = "SELECT * FROM All_Months ORDER BY ID DESC LIMIT 1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(getLastMonth)) {
			if (result.next()) {
				dbLastMonth = result.getString("allTransactionMonth");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!dbLastMonth.equals(getMonth())) {
			dbLastMonth = getMonth();
			String addMonthYear = "INSERT INTO All_Months(allYear, allTransactionMonth) VALUES(?,?)";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(addMonthYear)) {
				pstmt.setString(1, getYear());
				pstmt.setString(2, dbLastMonth);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	
//	public static void main(String[] args) {
//		DateAndClock access = new DateAndClock();
//		access.addMonth();
//	}
}






