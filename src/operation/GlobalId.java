package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;

public class GlobalId extends DatabaseConnection {
		
	public static int getGlobalid() {
		int globalId = 0;
		
		String sql = "SELECT globalId \n"
				+ "FROM System_Settings \n"
				+ "WHERE ID = 1";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			if (result.next()) {
				globalId = result.getInt("globalId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		increseGlobalId(globalId);
		return globalId;
	}
	
	private static void increseGlobalId(int oldId) {
		String sql = "UPDATE System_Settings \n"
				+ "SET globalId = ? \n"
				+ "WHERE ID = 1";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1, oldId+1);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(getGlobalid());
//	}
}
