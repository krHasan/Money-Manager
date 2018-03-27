package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.sqlite.util.StringUtils;

import model.DashboardModel;

public class Sector extends DashboardModel {

	public boolean createSector(String sectorName) {
		
		boolean exists = false;
		
		String sqlexists = "SELECT sectorList FROM Sector_List WHERE sectorList = ? ";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sqlexists)) {
			pstmt.setString(1, sectorName);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				exists = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!exists) {
			
			String sql = "INSERT INTO Sector_List (sectorList) VALUES(?)";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, sectorName);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String sqlupdate = "UPDATE Sector_List SET sectorActive = ?, ASL_Queue = ? WHERE sectorList = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sqlupdate)) {
				pstmt.setString(1, "active");
				pstmt.setString(2, "aslQueue");
				pstmt.setString(3, sectorName);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return exists;
	}

	
	public void deleteSector(String sectorName) {
		String delete = "DELETE FROM Sector_List WHERE sectorList = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(delete)){
			pstmt.setString(1, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void archiveSector(String sectorName) {
		String sqlarchived = "UPDATE Sector_List SET sectorActive = ?, sectorArchived = ?, ASL_Queue = ?, ASL_Active = ? WHERE sectorList = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sqlarchived)){
			pstmt.setString(1, "");
			pstmt.setString(2, "archived");
			pstmt.setString(3, "");
			pstmt.setString(4, "");
			pstmt.setString(5, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void unarchiveSector(String sectorName) {
		String sqlunarchived = "UPDATE Sector_List SET sectorActive = ?, sectorArchived = ?, ASL_Queue = ?, ASL_Active = ? WHERE sectorList = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sqlunarchived)){
			pstmt.setString(1, "active");
			pstmt.setString(2, "");
			pstmt.setString(3, "aslQueue");
			pstmt.setString(4, "");
			pstmt.setString(5, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public long getAmountBySectorFromExpense(String monthName, String sectorName) {
		String sql = "SELECT exAmount FROM Expense WHERE exMonth = ? AND exSector = ? ";
		long amount = 0;
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, monthName);
			pstmt.setString(2, sectorName);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				if (sectorName.equals("Adjusted Balance")) {
					if (!result.getString("exAmount").matches(".*\\badded\\b.*")) {
						amount += stringToLong(removeThousandSeparator(result.getString("exAmount")));
					}
				} else {
					amount += stringToLong(removeThousandSeparator(result.getString("exAmount")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	
	public long addedAdjustBalance(String monthName) {
		long amount = 0;
		
		String sql = "SELECT exAmount FROM Expense WHERE exMonth = ? AND exSector = ? ";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, monthName);
			pstmt.setString(2, "Adjusted Balance");
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				if (result.getString("exAmount").matches(".*\\badded\\b.*")) {
					amount += stringToLong(removeThousandSeparator(result.getString("exAmount").replaceAll("[^0-9.*]", "")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return amount;
	}

//	public static void main(String[] args) {
//		String text = "I will come and meet you at the woods 123woods and all the woods";
//
//		List<String> tokens = new ArrayList<String>();
//		tokens.add("123woods");
//		tokens.add("woods");
//
//		String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
//		Pattern pattern = Pattern.compile(patternString);
//		Matcher matcher = pattern.matcher(text);
//
//		while (matcher.find()) {
//		    System.out.println(matcher.group(1));
//		}
		
		
//		System.out.println("I will come and meet you at the 123woods".matches(".*\\badded\\b.*"));
//		System.out.println(new Sector().addedAdjustBalance("Dec-17"));
//	}
	
}








