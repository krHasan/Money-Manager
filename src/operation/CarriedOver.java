package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnection;
import system.UnitConverter;

public class CarriedOver extends DatabaseConnection {
	
	public void addCarriedOver(String monthName) {
		String sql = "SELECT monthName FROM Carried_Over WHERE monthName = ?";
		String insertCO = "INSERT INTO Carried_Over(monthName, amount) VALUES(?,?)";

		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (!result.next()) {
				try (Connection conn2 = connector(); PreparedStatement pstmt2 = conn2.prepareStatement(insertCO)) {
					pstmt2.setString(1, monthName);
					new UnitConverter();
					new BalanceStatus();
					pstmt2.setString(2, UnitConverter.longToString(BalanceStatus.currentWalletBalance()));
					pstmt2.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public long getCOAmount(String monthName) {
		long coAmount = 0;
		String sql = "SELECT amount FROM Carried_Over WHERE monthName = ?";
		
		try (Connection conn = connector(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, monthName);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				coAmount = UnitConverter.stringToLong(result.getString("amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return coAmount;
	}
	
	// public static void main(String[] args) {
	// CarriedOver access = new CarriedOver();
	// access.addCarriedOver("Mar-18");
	// }

}
