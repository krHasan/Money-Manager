package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import database.DatabaseConnection;
import operation.GlobalId;
import system.UnitConverter;

public class Personal extends DatabaseConnection {
	
	public void saveBnkPersonalData(Map<String, String> bnkData) {
		String sql = "INSERT INTO Personal (globalID, perTime, perDate, perMonth, perNature, perAmount, perBalanceBefore, perBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, bnkData.get("perTime"));
			pstmt.setString(3, bnkData.get("perDate"));
			pstmt.setString(4, bnkData.get("perMonth"));
			pstmt.setString(5, bnkData.get("perNature"));
			pstmt.setString(6, UnitConverter.addThousandSeparator(bnkData.get("perAmount")));
			pstmt.setString(7, UnitConverter.addThousandSeparator(bnkData.get("perBalanceBefore")));
			pstmt.setString(8, UnitConverter.addThousandSeparator(bnkData.get("perBalanceAfter")));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
