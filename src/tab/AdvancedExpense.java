package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;

import system.DateAndClock;

public class AdvancedExpense extends DateAndClock {

	public void addSectorToList(String sectorName) {
		String sqltoactive = "UPDATE Sector_List SET sectorActive = ?, sectorArchived = ?, ASL_Queue = ?, ASL_Active = ? WHERE sectorList = ?";

		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(sqltoactive)) {
			pstmt.setString(1, "active");
			pstmt.setString(2, "");
			pstmt.setString(3, "");
			pstmt.setString(4, "aslActive");
			pstmt.setString(5, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeSectorFromList(String sectorName) {
		String sqltoqueue = "UPDATE Sector_List SET sectorActive = ?, sectorArchived = ?, ASL_Queue = ?, ASL_Active = ? WHERE sectorList = ?";

		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(sqltoqueue)) {
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
}
