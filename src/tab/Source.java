package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
}



