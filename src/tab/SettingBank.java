package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import database.DatabaseConnection;
import operation.BankIssue;
import system.UnitConverter;

public class SettingBank extends DatabaseConnection {
	
	public Map<String, String> getBkashChargeData() {
		Map<String, String> bkData = new HashMap<>();
		
		String sql = "SELECT * FROM bKash_Settings WHERE ID = 1 ";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
			bkData.put("bkCashInCharge", UnitConverter.longToString(result.getLong("bkCashInCharge")));
			bkData.put("bkCashOutAgentCharge", UnitConverter.longToString(result.getLong("bkCashOutAgentCharge")));
			bkData.put("bkSendMoneyCharge", UnitConverter.longToString(result.getLong("bkSendMoneyCharge")));
			bkData.put("bkATMCharge", UnitConverter.longToString(result.getLong("bkATMCharge")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bkData;
	}
	
	
	public Map<String, String> getRocketChargeData() {
		Map<String, String> rocData = new HashMap<>();
		
		String sql = "SELECT * FROM Rocket_Settings WHERE ID = 1 ";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
			rocData.put("rocATMCashInAgentCharge", UnitConverter.longToString(result.getLong("rocATMCashInAgentCharge")));
			rocData.put("rocATMCashInBranchCharge", UnitConverter.longToString(result.getLong("rocATMCashInBranchCharge")));
			rocData.put("rocATMCashOutATMCharge", UnitConverter.longToString(result.getLong("rocATMCashOutATMCharge")));
			rocData.put("rocATMSendMoneyCharge", UnitConverter.longToString(result.getLong("rocATMSendMoneyCharge")));
			rocData.put("rocATMCashOutAgentCharge", UnitConverter.longToString(result.getLong("rocATMCashOutAgentCharge")));
			rocData.put("rocATMCashOutBranchCharge", UnitConverter.longToString(result.getLong("rocATMCashOutBranchCharge")));
			rocData.put("rocCashCashInAgentCharge", UnitConverter.longToString(result.getLong("rocCashCashInAgentCharge")));
			rocData.put("rocCashCashInBranchCharge", UnitConverter.longToString(result.getLong("rocCashCashInBranchCharge")));
			rocData.put("rocCashCashOutATMCharge", UnitConverter.longToString(result.getLong("rocCashCashOutATMCharge")));
			rocData.put("rocCashSendMoneyCharge", UnitConverter.longToString(result.getLong("rocCashSendMoneyCharge")));
			rocData.put("rocCashCashOutAgentCharge", UnitConverter.longToString(result.getLong("rocCashCashOutAgentCharge")));
			rocData.put("rocCashCashOutBranchCharge", UnitConverter.longToString(result.getLong("rocCashCashOutBranchCharge")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rocData;
	}
	
	
	public void savebkYes(Map<String, String> bnkSettingData) {
		String sql = "UPDATE bKash_Settings \n"
				+ "SET bkCashInCharge = ?, bkCashOutAgentCharge = ?, bkSendMoneyCharge = ?, bkATMCharge = ? \n"
				+ "WHERE ID = 1";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {		
			
			pstmt.setLong(1, UnitConverter.stringToLong(bnkSettingData.get("bkCashInCharge")));
			pstmt.setLong(2, UnitConverter.stringToLong(bnkSettingData.get("bkCashOutAgentCharge")));
			pstmt.setLong(3, UnitConverter.stringToLong(bnkSettingData.get("bkSendMoneyCharge")));
			pstmt.setLong(4, UnitConverter.stringToLong(bnkSettingData.get("bkATMCharge")));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql1 = "INSERT INTO Methods_List (activeMethods) \n"
				+ "VALUES(?)";
		
		if (!BankIssue.isbKashActivated()) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sql1)) {
					pstmt.setString(1, "bKash");
					pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void savebkNo() {
		String sql = "DELETE FROM Methods_List WHERE activeMethods = ?";
		
		if (BankIssue.isbKashActivated()) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, "bKash");
					pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void saverocYes() {
		String sql = "INSERT INTO Methods_List (activeMethods) \n"
				+ "VALUES(?)";
		if (!BankIssue.isRocketActivated()) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, "Rocket");
					pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void saverocATMYes(Map<String, String> bnkSettingData) {
		saverocYes();
		
		String sql = "UPDATE Rocket_Settings \n"
				+ "SET atmFree = ?, cashInFree = ?, rocATMCashInAgentCharge = ?, rocATMCashInBranchCharge = ? ,\n"
				+ "rocATMCashOutATMCharge = ?, rocATMSendMoneyCharge = ?, rocATMCashOutAgentCharge = ?, rocATMCashOutBranchCharge = ? \n"
				+ "WHERE ID = 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {	
			pstmt.setString(1, "true");
			pstmt.setString(2, "false");
			pstmt.setLong(3, UnitConverter.stringToLong(bnkSettingData.get("rocATMCashInAgentCharge")));
			pstmt.setLong(4, UnitConverter.stringToLong(bnkSettingData.get("rocATMCashInBranchCharge")));
			pstmt.setLong(5, UnitConverter.stringToLong(bnkSettingData.get("rocATMCashOutATMCharge")));
			pstmt.setLong(6, UnitConverter.stringToLong(bnkSettingData.get("rocATMSendMoneyCharge")));
			pstmt.setLong(7, UnitConverter.stringToLong(bnkSettingData.get("rocATMCashOutAgentCharge")));
			pstmt.setLong(8, UnitConverter.stringToLong(bnkSettingData.get("rocATMCashOutBranchCharge")));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void saverocCashInYes(Map<String, String> bnkSettingData) {
		saverocYes();
		
		String sql = "UPDATE Rocket_Settings \n"
				+ "SET atmFree = ?, cashInFree = ?, rocCashCashInAgentCharge = ?, rocCashCashInBranchCharge = ? ,\n"
				+ "rocCashCashOutATMCharge = ?, rocCashSendMoneyCharge = ?, rocCashCashOutAgentCharge = ?, rocCashCashOutBranchCharge = ? \n"
				+ "WHERE ID = 1";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {	
			pstmt.setString(1, "false");
			pstmt.setString(2, "true");
			pstmt.setLong(3, UnitConverter.stringToLong(bnkSettingData.get("rocCashCashInAgentCharge")));
			pstmt.setLong(4, UnitConverter.stringToLong(bnkSettingData.get("rocCashCashInBranchCharge")));
			pstmt.setLong(5, UnitConverter.stringToLong(bnkSettingData.get("rocCashCashOutATMCharge")));
			pstmt.setLong(6, UnitConverter.stringToLong(bnkSettingData.get("rocCashSendMoneyCharge")));
			pstmt.setLong(7, UnitConverter.stringToLong(bnkSettingData.get("rocCashCashOutAgentCharge")));
			pstmt.setLong(8, UnitConverter.stringToLong(bnkSettingData.get("rocCashCashOutBranchCharge")));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public void saverocNo() {
		String sql = "DELETE FROM Methods_List WHERE activeMethods = ?";
		
		if (BankIssue.isRocketActivated()) {
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, "Rocket");
					pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public static void main(String[] args) {
//		SettingBank access = new SettingBank();
//		Map<String, String> bnkSettingData = new HashMap<>();
//		
//		bnkSettingData.put("bkCashInCharge", "");
//		bnkSettingData.put("bkCashOutAgentCharge", "18.5");
//		bnkSettingData.put("bkSendMoneyCharge", "5");
//		bnkSettingData.put("bkATMCharge", "20");
//		
//		access.savebkYes(bnkSettingData);
//	}
}









