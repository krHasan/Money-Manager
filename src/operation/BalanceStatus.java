package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import system.UnitConverter;

public class BalanceStatus extends GoToOperation {
	
	public static long currentWalletBalance() {
		long balance = 0;
		String sql = "SELECT walletBalance \n"
				+ "FROM Current_Status";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getLong("walletBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public void setCurrentWalletBalance(String balance) {
		long balancelong = UnitConverter.stringToLong(balance);
		String sql = "UPDATE Current_Status \n"
				+ " SET walletBalance = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, balancelong);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static long currentbKashBalance() {
		long balance = 0;
		String sql = "SELECT bkashBalance \n"
				+ "FROM Current_Status";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getLong("bkashBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public void setCurrentbKashBalance(String balance) {
		long balancelong = UnitConverter.stringToLong(balance);
		String sql = "UPDATE Current_Status \n"
				+ " SET bkashBalance = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, balancelong);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static long currentRocketBalance() {
		long balance = 0;
		String sql = "SELECT rocketBalance \n"
				+ "FROM Current_Status";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getLong("rocketBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}

	
	public void setCurrentRocketBalance(String balance) {
		long balancelong = UnitConverter.stringToLong(balance);
		String sql = "UPDATE Current_Status \n"
				+ " SET rocketBalance = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, balancelong);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static long currentPersonalBalance() {
		long balance = 0;
		String sql = "SELECT personalBalance \n"
				+ "FROM Current_Status";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getLong("personalBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public void setCurrentPersonalBalance(String balance) {
		long balancelong = UnitConverter.stringToLong(balance);
		String sql = "UPDATE Current_Status \n"
				+ " SET personalBalance = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, balancelong);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static long totalBorrowTk() {
		long balance = 0;
		String sql = "SELECT totalBorrowTk \n"
				+ "FROM Current_Status";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getLong("totalBorrowTk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public void setTotalBorrowTk(String balance) {
		long balancelong = UnitConverter.stringToLong(balance);
		String sql = "UPDATE Current_Status \n"
				+ " SET totalBorrowTk = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, balancelong);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static long totalLendTk() {
		long balance = 0;
		String sql = "SELECT totalLendTk \n"
				+ "FROM Current_Status";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getLong("totalLendTk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	public void setTotalLendTk(String balance) {
		long balancelong = UnitConverter.stringToLong(balance);
		String sql = "UPDATE Current_Status \n"
				+ " SET totalLendTk = ?";
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, balancelong);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		BalanceStatus access = new BalanceStatus();
//		System.out.println(access.currentWalletBalance());
//		access.setCurrentWalletBalance("1000");
//	}
	
	
}
