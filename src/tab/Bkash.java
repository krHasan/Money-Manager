package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
			pstmt.setString(7, UnitConverter.addThousandSeparator(gmData.get("gmAmount")));
			pstmt.setString(8, gmData.get("gmBankCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(bkBalanceBefore));
			pstmt.setString(10, UnitConverter.addThousandSeparator(gmData.get("bkBalanceAfter")));
			
			pstmt.executeUpdate();
			
			setCurrentbKashBalance(gmData.get("bkBalanceAfter"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isbKashActivated() {
		String sql = "SELECT activeMethods \n"
				+ "FROM Methods_List \n"
				+ "WHERE activeMethods = \"bKash\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void saveBnkBkashData(Map<String, String> bnkData) {
		String sql = "INSERT INTO bKash (globalID, bkTime, bkDate, bkMonth, bkType, bkNature, bkAmount, \n"
				+ "bkBnkCharge, bkBalanceBefore, bkBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		String bkAmount = null;
		try {
			bkAmount = UnitConverter.addThousandSeparator(bnkData.get("bkAmount"));
		} catch (Exception e) {
			bkAmount = bnkData.get("bkAmount");
		}
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, bnkData.get("bkTime"));
			pstmt.setString(3, bnkData.get("bkDate"));
			pstmt.setString(4, bnkData.get("bkMonth"));
			pstmt.setString(5, bnkData.get("bkType"));
			pstmt.setString(6, bnkData.get("bkNature"));
			pstmt.setString(7, bkAmount);
			pstmt.setString(8, bnkData.get("bkBnkCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(bnkData.get("bkBalanceBefore")));
			pstmt.setString(10, UnitConverter.addThousandSeparator(bnkData.get("bkBalanceAfter")));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveBorrowBkashData(Map<String, String> boleData) {
		String sql = "INSERT INTO bKash (globalID, bkTime, bkDate, bkMonth, bkType, bkNature, bkAmount, \n"
				+ "bkBnkCharge, bkBalanceBefore, bkBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, boleData.get("boTime"));
			pstmt.setString(3, boleData.get("boDate"));
			pstmt.setString(4, boleData.get("boMonth"));
			pstmt.setString(5, "Data From Borrow");
			pstmt.setString(6, boleData.get("boNature"));
			pstmt.setString(7, UnitConverter.addThousandSeparator(boleData.get("boTk")));
			pstmt.setString(8, boleData.get("boBnkCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(boleData.get("bkBalanceBefore")));
			pstmt.setString(10, UnitConverter.addThousandSeparator(boleData.get("bkBalanceAfter")));
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void saveLendBkashData(Map<String, String> boleData) {
		String sql = "INSERT INTO bKash (globalID, bkTime, bkDate, bkMonth, bkType, bkNature, bkAmount, \n"
				+ "bkBnkCharge, bkBalanceBefore, bkBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int globalId = GlobalId.getGlobalid();
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, boleData.get("leTime"));
			pstmt.setString(3, boleData.get("leDate"));
			pstmt.setString(4, boleData.get("leMonth"));
			pstmt.setString(5, "Data From Lend");
			pstmt.setString(6, boleData.get("leNature"));
			pstmt.setString(7, UnitConverter.addThousandSeparator(boleData.get("leTk")));
			pstmt.setString(8, boleData.get("leBnkCharge"));
			pstmt.setString(9, UnitConverter.addThousandSeparator(boleData.get("bkBalanceBefore")));
			pstmt.setString(10, UnitConverter.addThousandSeparator(boleData.get("bkBalanceAfter")));
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		Bkash access = new Bkash();
//		System.out.println(access.isbKashActivated());
//	}
	
}
