package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sqlite.util.StringUtils;

import model.DashboardModel;

public class Sector extends DashboardModel {

	public void createSector(String sectorName) {
		String sql = "INSERT INTO Sector_List (sectorList) VALUES(?)";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String delete = "DELETE FROM Sector_List WHERE sectorList = ?";
		String insert = "INSERT INTO Archived_Sector_List (sectorArchiveList) VALUES(?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(delete)){
			pstmt.setString(1, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(insert)){
			pstmt.setString(1, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void unarchiveSector(String sectorName) {
		String delete = "DELETE FROM Archived_Sector_List WHERE sectorArchiveList = ?";
		String insert = "INSERT INTO Sector_List (sectorList) VALUES(?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(delete)){
			pstmt.setString(1, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(insert)){
			pstmt.setString(1, sectorName);
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
//	}
	
}








