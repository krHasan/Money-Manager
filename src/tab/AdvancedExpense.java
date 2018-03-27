package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;

import operation.ComboboxList;
import system.DateAndClock;

public class AdvancedExpense extends DateAndClock{
	
//	public void createSectorToAddList(String sectorName) {
//		String sql = "INSERT INTO Advanced_Sector_List_Add (sectorNameOutOfList) VALUES(?)";
//		try (Connection conn = connector();
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, sectorName);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	
//	public void deleteSectorFromAdvancedList(String sectorName) {
//		String deleteFromAdd = "DELETE FROM Advanced_Sector_List_Add WHERE sectorNameOutOfList = ?";
//		String deleteFromRemove = "DELETE FROM Advanced_Sector_List_Remove WHERE sectorNameInTheList = ?";
//		
//		boolean sectorInAddList = false;
//		
//		String sectorListAdd[] = new ComboboxList().getAdvancedSectorListInactive();
//		for (String string : sectorListAdd) {
//			if (string.equals(sectorName)) {
//				sectorInAddList = true;
//			}
//		}
//		
//		if (sectorInAddList) {
//			try (Connection conn = connector();
//					PreparedStatement pstmt = conn.prepareStatement(deleteFromAdd)){
//				pstmt.setString(1, sectorName);
//				pstmt.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}			
//		} else {
//			try (Connection conn = connector();
//					PreparedStatement pstmt = conn.prepareStatement(deleteFromRemove)){
//				pstmt.setString(1, sectorName);
//				pstmt.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}	
//		}
//
//	}
	
	
	public void addSectorToList(String sectorName) {
		String sqltoactive = "UPDATE Sector_List SET sectorActive = ?, sectorArchived = ?, ASL_Queue = ?, ASL_Active = ? WHERE sectorList = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sqltoactive)){
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
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sqltoqueue)){
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
