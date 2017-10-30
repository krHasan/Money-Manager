package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import operation.BalanceStatus;
import operation.GlobalId;
import system.UnitConverter;

public class Bkash extends BalanceStatus {
	
	public void saveGmBkashData(Map<String, String> gmData) {
		String sql = "INSERT INTO bKash (globalID, bkTime, bkDate, bkMonth, bkType, bkNature, bkAmount, \n"
				+ "bkBnkCharge, bkBalanceBefore, bkBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		String bkBalanceBefore = UnitConverter.longToString(currentbKashBalance());
		
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
			pstmt.setString(9, bkBalanceBefore);
			pstmt.setString(10, gmData.get("bkBalanceAfter"));
			
			pstmt.executeUpdate();
			
			setCurrentbKashBalance(gmData.get("bkBalanceAfter"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
