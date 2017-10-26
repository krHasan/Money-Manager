package operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BalanceStatus extends GoToOperation {
	
	
	public int currentWalletBalance() {
		int balance = 0;
		String sql = "SELECT walletBalance \n"
				+ "FROM Current_Status \n"
				+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getInt("walletBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public int currentbKashBalance() {
		int balance = 0;
		String sql = "SELECT bkashBalance \n"
				+ "FROM Current_Status \n"
				+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getInt("bkashBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public int currentRocketBalance() {
		int balance = 0;
		String sql = "SELECT rocketBalance \n"
				+ "FROM Current_Status \n"
				+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getInt("rocketBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}

	
	public int currentPersonalBalance() {
		int balance = 0;
		String sql = "SELECT personalBalance \n"
				+ "FROM Current_Status \n"
				+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getInt("personalBalance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public int totalBorrowTk() {
		int balance = 0;
		String sql = "SELECT totalBorrowTk \n"
				+ "FROM Current_Status \n"
				+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getInt("totalBorrowTk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public int totalLendTk() {
		int balance = 0;
		String sql = "SELECT totalLendTk \n"
				+ "FROM Current_Status \n"
				+ "WHERE ID=1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			balance = result.getInt("totalLendTk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}
	
//	public static void main(String[] args) {
//		BalanceStatus access = new BalanceStatus();
//		System.out.println(access.currentWalletBalance());
//	}
	
	
}
