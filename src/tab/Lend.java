package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import database.DatabaseConnection;
import operation.GlobalId;
import system.UnitConverter;

public class Lend extends DatabaseConnection {
	
	public String leRepayPersonLendedAmount(String name) {
		String lendedAmount = "0";
		String sql = "SELECT leExactTk FROM Lend_Summary WHERE leWhom = ? ";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet result = pstmt.executeQuery();
			
			if (result.next()) {
				lendedAmount = result.getString("leExactTk");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lendedAmount;
	}

	
	public void saveLendData(Map<String, String> LendData) {
		String sql = "INSERT INTO Lend(globalID, leTime, leDate, leMonth, leType, leMethod, leWhom, leTk, \n"
				+ "leNature, leBnkCharge, leBalanceBefore,leBalanceAfter, leExactTk) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, LendData.get("leTime"));
			pstmt.setString(3, LendData.get("leDate"));
			pstmt.setString(4, LendData.get("leMonth"));
			pstmt.setString(5, LendData.get("leType"));
			pstmt.setString(6, LendData.get("leMethod"));
			pstmt.setString(7, LendData.get("leWhom"));
			pstmt.setString(8, UnitConverter.addThousandSeparator(LendData.get("leTk")));
			pstmt.setString(9, LendData.get("leNature"));
			pstmt.setString(10, LendData.get("leBnkCharge"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(LendData.get("leBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(LendData.get("leBalanceAfter")));
			pstmt.setString(13, UnitConverter.addThousandSeparator(LendData.get("leExactTk")));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addLendSummaryData(Map<String, String> LendData) {
		String sql = "INSERT INTO Lend_Summary(leDate, leWhom, leExactTk) \n"
				+ "VALUES(?,?,?)";

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, LendData.get("leDate"));
			pstmt.setString(2, LendData.get("leWhom"));
			pstmt.setString(3, LendData.get("leExactTk"));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateLendSummaryData(Map<String, String> LendData) {
		long dbAmount = UnitConverter.stringToLong(leRepayPersonLendedAmount(LendData.get("leWhom")));
		long exactTk = UnitConverter.stringToLong(LendData.get("leExactTk"));
		String updatedAmount = UnitConverter.longToString(dbAmount - exactTk);
		
		String sql = "UPDATE Lend_Summary SET leExactTk = ?\n"
				+ "WHERE leWhom = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, updatedAmount);
			pstmt.setString(2, LendData.get("leWhom"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void updateLendSummaryDataForUndo(Map<String, String> LendData) {
		long dbAmount = UnitConverter.stringToLong(leRepayPersonLendedAmount(LendData.get("leWhom")));
		long exactTk = UnitConverter.stringToLong(LendData.get("leExactTk"));
		String updatedAmount = UnitConverter.longToString(dbAmount + exactTk);
		
		String sql = "UPDATE Lend_Summary SET leExactTk = ?\n"
				+ "WHERE leWhom = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, updatedAmount);
			pstmt.setString(2, LendData.get("leWhom"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteLendSummaryData(Map<String, String> LendData) {
			
		String sql = "DELETE FROM Lend_Summary \n"
				+ "WHERE leWhom = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, LendData.get("leWhom"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
