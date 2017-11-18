package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;

public class TabAccess extends DatabaseConnection{

	public void setTabName(String tabName) {
		String sql = "UPDATE Current_Access SET tabName = ? ";
		
		try (Connection conn = connector();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, tabName);
             pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	
	public String getTabName() {
		String tabName = null;
		String sql = "SELECT tabName \n"
				+ "FROM Current_Access \n"
				+ "WHERE ID = 1";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			if (result.next()) {
				tabName = result.getString("tabName");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tabName;
	}
	
	
	public void setreRegistrationLodingStatus(String reRegistrationLodingStatus) {
		String sql = "UPDATE Current_Access SET reRegistrationLodingStatus = ? ";
		
		try (Connection conn = connector();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, reRegistrationLodingStatus);
             pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	
	public String getreRegistrationLodingStatus() {
		String reRegistrationLodingStatus = null;
		String sql = "SELECT reRegistrationLodingStatus \n"
				+ "FROM Current_Access \n"
				+ "WHERE ID = 1";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			if (result.next()) {
				reRegistrationLodingStatus = result.getString("reRegistrationLodingStatus");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reRegistrationLodingStatus;
	}
	
	
//	public static void main(String[] args) {
//		TabAccess access = new TabAccess();
//		access.setTabName("tabSector");
//		System.out.println(access.getTabName());
//	}
}
