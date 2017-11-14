package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import operation.BalanceStatus;
import operation.GlobalId;
import system.UnitConverter;

public class Rocket  extends BalanceStatus {
	
	public void saveGmRocketData(Map<String, String> gmData) {
		
		String sql = "INSERT INTO Rocket (globalID, rocTime, rocDate, rocMonth, rocType, rocNature, rocAmount, \n"
				+ "rocBnkCharge, rocBalanceBefore, rocBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		String rocBalanceBefore = UnitConverter.longToString(currentRocketBalance());
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, gmData.get("gmTime"));
			pstmt.setString(3, gmData.get("gmDate"));
			pstmt.setString(4, gmData.get("gmMonth"));
			pstmt.setString(5, "From Get Money");
			pstmt.setString(6, gmData.get("gmAmountNature"));
			pstmt.setString(7, UnitConverter.addThousandSeparator(gmData.get("gmAmount")));
			pstmt.setString(8, gmData.get("gmBankCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(rocBalanceBefore));
			pstmt.setString(10, UnitConverter.addThousandSeparator(gmData.get("rocBalanceAfter")));
			
			pstmt.executeUpdate();
		
			setCurrentRocketBalance(gmData.get("rocBalanceAfter"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public boolean isRocketActivated() {
//		String sql = "SELECT activeMethods \n"
//				+ "FROM Methods_List \n"
//				+ "WHERE activeMethods = \"Rocket\"";
//
//		try (Connection conn = connector();
//				Statement stmt = conn.createStatement();
//				ResultSet result = stmt.executeQuery(sql)) {
//			
//			if (result.next()) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			return false;
//		}
//	}
	
	
	public void saveBnkRocketData(Map<String, String> bnkData) {
		
		String sql = "INSERT INTO Rocket (globalID, rocTime, rocDate, rocMonth, rocType, rocNature, rocAmount, \n"
				+ "rocBnkCharge, rocBalanceBefore, rocBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		String rocAmount = null;
		try {
			rocAmount = UnitConverter.addThousandSeparator(bnkData.get("rocAmount"));
		} catch (Exception e) {
			rocAmount = bnkData.get("rocAmount");
		}
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, bnkData.get("rocTime"));
			pstmt.setString(3, bnkData.get("rocDate"));
			pstmt.setString(4, bnkData.get("rocMonth"));
			pstmt.setString(5, bnkData.get("rocType"));
			pstmt.setString(6, bnkData.get("rocNature"));
			pstmt.setString(7, rocAmount);
			pstmt.setString(8, bnkData.get("rocBnkCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(bnkData.get("rocBalanceBefore")));
			pstmt.setString(10, UnitConverter.addThousandSeparator(bnkData.get("rocBalanceAfter")));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveBorrowRocketData(Map<String, String> boleData) {
		
		String sql = "INSERT INTO Rocket (globalID, rocTime, rocDate, rocMonth, rocType, rocNature, rocAmount, \n"
				+ "rocBnkCharge, rocBalanceBefore, rocBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, boleData.get("boTime"));
			pstmt.setString(3, boleData.get("boDate"));
			pstmt.setString(4, boleData.get("boMonth"));
			pstmt.setString(5, "Data form Borrow");
			pstmt.setString(6, boleData.get("boNature"));
			pstmt.setString(7, UnitConverter.addThousandSeparator(boleData.get("boTk")));
			pstmt.setString(8, boleData.get("boBnkCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(boleData.get("rocBalanceBefore")));
			pstmt.setString(10, UnitConverter.addThousandSeparator(boleData.get("rocBalanceAfter")));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveLendRocketData(Map<String, String> boleData) {
		
		String sql = "INSERT INTO Rocket (globalID, rocTime, rocDate, rocMonth, rocType, rocNature, rocAmount, \n"
				+ "rocBnkCharge, rocBalanceBefore, rocBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, boleData.get("leTime"));
			pstmt.setString(3, boleData.get("leDate"));
			pstmt.setString(4, boleData.get("leMonth"));
			pstmt.setString(5, "Data form Lend");
			pstmt.setString(6, boleData.get("leNature"));
			pstmt.setString(7, UnitConverter.addThousandSeparator(boleData.get("leTk")));
			pstmt.setString(8, boleData.get("leBnkCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(boleData.get("rocBalanceBefore")));
			pstmt.setString(10, UnitConverter.addThousandSeparator(boleData.get("rocBalanceAfter")));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
