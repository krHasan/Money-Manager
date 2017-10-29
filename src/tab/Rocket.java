package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import operation.BalanceStatus;
import operation.GlobalId;
import system.UnitConverter;

public class Rocket  extends BalanceStatus {
	
	@SuppressWarnings("static-access")
	public void saveGmRocketData(Map<String, String> gmData) {
		
		UnitConverter convert = new UnitConverter();
		String sql = "INSERT INTO Rocket (globalID, rocTime, rocDate, rocMonth, rocType, rocNature, rocAmount, \n"
				+ "rocBnkCharge, rocBalanceBefore, rocBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = (new GlobalId()).getGlobalid();
		String rocBalanceBefore = convert.longToString(currentRocketBalance());
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, gmData.get("gmTime"));
			pstmt.setString(3, gmData.get("gmDate"));
			pstmt.setString(4, gmData.get("gmMonth"));
			pstmt.setString(5, "From Get Money");
			pstmt.setString(6, gmData.get("gmAmountNature"));
			pstmt.setString(7, gmData.get("gmAmount"));
			pstmt.setString(8, gmData.get("gmBankCharge"));
			pstmt.setString(9, rocBalanceBefore);
			pstmt.setString(10, gmData.get("rocBalanceAfter"));
			
			pstmt.executeUpdate();
		
			setCurrentRocketBalance(gmData.get("rocBalanceAfter"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
