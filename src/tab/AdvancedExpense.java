package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;

import operation.ComboboxList;
import system.DateAndClock;

public class AdvancedExpense extends DateAndClock{
	
	public void createSectorToAddList(String sectorName) {
		String sql = "INSERT INTO Advanced_Sector_List_Add (sectorNameOutOfList) VALUES(?)";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, sectorName);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void deleteSectorFromAdvancedList(String sectorName) {
		String deleteFromAdd = "DELETE FROM Advanced_Sector_List_Add WHERE sectorNameOutOfList = ?";
		String deleteFromRemove = "DELETE FROM Advanced_Sector_List_Remove WHERE sectorNameInTheList = ?";
		
		boolean sectorInAddList = false;
		
		String sectorListAdd[] = new ComboboxList().getAdvancedSectorListInactive();
		for (String string : sectorListAdd) {
			if (string.equals(sectorName)) {
				sectorInAddList = true;
			}
		}
		
		if (sectorInAddList) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(deleteFromAdd)){
				pstmt.setString(1, sectorName);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		} else {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(deleteFromRemove)){
				pstmt.setString(1, sectorName);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}

	}
	
	
	public void addSectorToList(String sectorName) {
		String delete = "DELETE FROM Advanced_Sector_List_Add WHERE sectorNameOutOfList = ?";
		String insert = "INSERT INTO Advanced_Sector_List_Remove (sectorNameInTheList) VALUES(?)";
		
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
	
	
	public void removeSectorFromList(String sectorName) {
		String delete = "DELETE FROM Advanced_Sector_List_Remove WHERE sectorNameInTheList = ?";
		String insert = "INSERT INTO Advanced_Sector_List_Add (sectorNameOutOfList) VALUES(?)";
		
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
}
