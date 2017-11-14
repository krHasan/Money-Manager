package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				amount += stringToLong(removeThousandSeparator(result.getString("exAmount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
}








