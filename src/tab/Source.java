package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.DashboardModel;

public class Source extends DashboardModel {
	
	public void createSource(String sourceName) {
		String sql = "INSERT INTO Source_List (sourceList) VALUES(?)";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, sourceName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void archiveSource(String sourceName) {
		String delete = "DELETE FROM Source_List WHERE sourceList = ?";
		String insert = "INSERT INTO Archived_Source_List (sourceArchiveList) VALUES(?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(delete)){
			pstmt.setString(1, sourceName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(insert)){
			pstmt.setString(1, sourceName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void unarchiveSource(String sourceName) {
		String delete = "DELETE FROM Archived_Source_List WHERE sourceArchiveList = ?";
		String insert = "INSERT INTO Source_List (sourceList) VALUES(?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(delete)){
			pstmt.setString(1, sourceName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(insert)){
			pstmt.setString(1, sourceName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public long getAmountBySourceFromGM(String monthName, String sourceName) {
		String sql = "SELECT gmAmount FROM Get_Money WHERE gmMonth = ? AND gmSource = ? ";
		long amount = 0;
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, monthName);
			pstmt.setString(2, sourceName);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				amount += stringToLong(removeThousandSeparator(result.getString("gmAmount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	
}




















