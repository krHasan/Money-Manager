package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DatabaseConnection;

public class GetMoney extends DatabaseConnection {
	
	public void saveGetMoneyData(int intData[], String stringData[]) {
		String sql = "INSERT INTO Get_Money(gobalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1,7);
			pstmt.setString(2, "21:09:34");
			pstmt.setString(3, "04 November, 2017");
			pstmt.setString(4, "Nov'17");
			pstmt.setInt(5, 4500);
			pstmt.setString(6, "Father");
			pstmt.setInt(7, 1850);
			pstmt.setString(8, "No Description");
			pstmt.setString(9, "Rocket");
			pstmt.setString(10, "Cash in from Agent");
			pstmt.setInt(11, 6700);
			pstmt.setInt(12, 12300);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		GetMoney access = new GetMoney();
////		access.saveGetMoneyData();
//	}
	
}
