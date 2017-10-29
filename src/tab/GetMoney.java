package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import database.DatabaseConnection;

public class GetMoney extends DatabaseConnection {
	
	public void saveGetMoneyData(int globalId, Map<String, String> stringData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, stringData.get("gmTime"));
			pstmt.setString(3, stringData.get("gmDate"));
			pstmt.setString(4, stringData.get("gmMonth"));
			pstmt.setString(5, stringData.get("gmAmount"));
			pstmt.setString(6, stringData.get("gmSource"));
			pstmt.setString(7, stringData.get("gmBankCharge"));
			pstmt.setString(8, stringData.get("gmDescription"));
			pstmt.setString(9, stringData.get("gmMethod"));
			pstmt.setString(10, stringData.get("gmAmountNature"));
			pstmt.setString(11, stringData.get("gmWalletBalanceBefore"));
			pstmt.setString(12, stringData.get("gmWalletBalanceAfter"));
			
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
