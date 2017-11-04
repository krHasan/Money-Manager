package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import database.DatabaseConnection;
import operation.GlobalId;
import system.UnitConverter;

public class GetMoney extends DatabaseConnection {
	
	public void saveGetMoneyData(Map<String, String> getMoneyData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, getMoneyData.get("gmTime"));
			pstmt.setString(3, getMoneyData.get("gmDate"));
			pstmt.setString(4, getMoneyData.get("gmMonth"));
			pstmt.setString(5, UnitConverter.addThousandSeparator(getMoneyData.get("gmAmount")));
			pstmt.setString(6, getMoneyData.get("gmSource"));
			pstmt.setString(7, getMoneyData.get("gmBankCharge"));
			pstmt.setString(8, getMoneyData.get("gmDescription"));
			pstmt.setString(9, getMoneyData.get("gmMethod"));
			pstmt.setString(10, getMoneyData.get("gmAmountNature"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(getMoneyData.get("gmWalletBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(getMoneyData.get("gmWalletBalanceAfter")));
			
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
