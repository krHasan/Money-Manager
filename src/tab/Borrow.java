package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import database.DatabaseConnection;
import operation.GlobalId;
import system.UnitConverter;

public class Borrow extends DatabaseConnection {
	
	public String boRepayPersonBorrowedAmount(String name) {
		String borrowedAmount = "0";
		String sql = "SELECT boExactTk FROM Borrow_Summary WHERE boWhom = ? ";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet result = pstmt.executeQuery();
			
			if (result.next()) {
				borrowedAmount = result.getString("boExactTk");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return borrowedAmount;
	}

	
	public void saveBorrowData(Map<String, String> borrowData) {
		String sql = "INSERT INTO Borrow(globalID, boTime, boDate, boMonth, boType, boMethod, boWhom, boTk, \n"
				+ "boNature, boBnkCharge, boBalanceBefore,boBalanceAfter, boExactTk) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, borrowData.get("boTime"));
			pstmt.setString(3, borrowData.get("boDate"));
			pstmt.setString(4, borrowData.get("boMonth"));
			pstmt.setString(5, borrowData.get("boType"));
			pstmt.setString(6, borrowData.get("boMethod"));
			pstmt.setString(7, borrowData.get("boWhom"));
			pstmt.setString(8, UnitConverter.addThousandSeparator(borrowData.get("boTk")));
			pstmt.setString(9, borrowData.get("boNature"));
			pstmt.setString(10, borrowData.get("boBnkCharge"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(borrowData.get("boBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(borrowData.get("boBalanceAfter")));
			pstmt.setString(13, UnitConverter.addThousandSeparator(borrowData.get("boExactTk")));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addBorrowSummaryData(Map<String, String> borrowData) {
		String sql = "INSERT INTO Borrow_Summary(boDate, boWhom, boExactTk) \n"
				+ "VALUES(?,?,?)";

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, borrowData.get("boDate"));
			pstmt.setString(2, borrowData.get("boWhom"));
			pstmt.setString(3, borrowData.get("boExactTk"));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateBorrowSummaryData(Map<String, String> borrowData) {
		long dbAmount = UnitConverter.stringToLong(boRepayPersonBorrowedAmount(borrowData.get("boWhom")));
		long exactTk = UnitConverter.stringToLong(borrowData.get("boExactTk"));
		String updatedAmount = UnitConverter.longToString(dbAmount - exactTk);
		
		String sql = "UPDATE Borrow_Summary SET boExactTk = ?\n"
				+ "WHERE boWhom = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, updatedAmount);
			pstmt.setString(2, borrowData.get("boWhom"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteBorrowSummaryData(Map<String, String> borrowData) {
			
		String sql = "DELETE FROM Borrow_Summary \n"
				+ "WHERE boWhom = ?";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, borrowData.get("boWhom"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

























