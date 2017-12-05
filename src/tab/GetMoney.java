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
	
	
	public void saveBorrowGMData(Map<String, String> boleData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, boleData.get("boTime"));
			pstmt.setString(3, boleData.get("boDate"));
			pstmt.setString(4, boleData.get("boMonth"));
			pstmt.setString(5, UnitConverter.addThousandSeparator(boleData.get("boTk")));
			pstmt.setString(6, "Data from Borrow");
			pstmt.setString(7, boleData.get("boBnkCharge"));
			pstmt.setString(8, "Borrow Transaction With "+boleData.get("boWhom"));
			pstmt.setString(9, boleData.get("boMethod"));
			pstmt.setString(10, boleData.get("boNature"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(boleData.get("gmWalletBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(boleData.get("gmWalletBalanceAfter")));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveLendGMData(Map<String, String> boleData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, boleData.get("leTime"));
			pstmt.setString(3, boleData.get("leDate"));
			pstmt.setString(4, boleData.get("leMonth"));
			pstmt.setString(5, UnitConverter.addThousandSeparator(boleData.get("leTk")));
			pstmt.setString(6, "Data from Lend");
			pstmt.setString(7, boleData.get("leBnkCharge"));
			pstmt.setString(8, "Lend Transaction With "+boleData.get("leWhom"));
			pstmt.setString(9, boleData.get("leMethod"));
			pstmt.setString(10, boleData.get("leNature"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(boleData.get("gmWalletBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(boleData.get("gmWalletBalanceAfter")));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void saveBnkBkashData(Map<String, String> bnkData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, bnkData.get("bkTime"));
			pstmt.setString(3, bnkData.get("bkDate"));
			pstmt.setString(4, bnkData.get("bkMonth"));
			pstmt.setString(5, UnitConverter.addThousandSeparator(bnkData.get("bkAmount")));
			pstmt.setString(6, "bKash");
			pstmt.setString(7, bnkData.get("bkBnkCharge"));
			pstmt.setString(8, "Data from bKash");
			pstmt.setString(9, bnkData.get("bkType"));
			pstmt.setString(10, bnkData.get("bkNature"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(bnkData.get("gmWalletBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(bnkData.get("gmWalletBalanceAfter")));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void saveBnkRocketData(Map<String, String> bnkData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, bnkData.get("rocTime"));
			pstmt.setString(3, bnkData.get("rocDate"));
			pstmt.setString(4, bnkData.get("rocMonth"));
			pstmt.setString(5, UnitConverter.addThousandSeparator(bnkData.get("rocAmount")));
			pstmt.setString(6, "Rocket");
			pstmt.setString(7, bnkData.get("rocBnkCharge"));
			pstmt.setString(8, "Data from Rocket");
			pstmt.setString(9, bnkData.get("rocType"));
			pstmt.setString(10, bnkData.get("rocNature"));
			pstmt.setString(11, UnitConverter.addThousandSeparator(bnkData.get("gmWalletBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(bnkData.get("gmWalletBalanceAfter")));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void saveBnkPersonalData(Map<String, String> bnkData) {
		String sql = "INSERT INTO Get_Money(globalID, gmTime, gmDate, gmMonth, gmAmount, gmSource, \n"
				+ "gmBankCharge,  gmDescription, gmMethod, gmAmountNature, \n"
				+ "gmWalletBalanceBefore, gmWalletBalanceAfter) \n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		int globalId = GlobalId.getGlobalid();

		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setLong(1,globalId);
			pstmt.setString(2, bnkData.get("perTime"));
			pstmt.setString(3, bnkData.get("perDate"));
			pstmt.setString(4, bnkData.get("perMonth"));
			pstmt.setString(5, UnitConverter.addThousandSeparator(bnkData.get("perAmount")));
			pstmt.setString(6, "Data from Personal Bank");
			pstmt.setString(7, "None");
			pstmt.setString(8, "Data from Personal Bank");
			pstmt.setString(9, "Personal");
			pstmt.setString(10, "Banking");
			pstmt.setString(11, UnitConverter.addThousandSeparator(bnkData.get("gmWalletBalanceBefore")));
			pstmt.setString(12, UnitConverter.addThousandSeparator(bnkData.get("gmWalletBalanceAfter")));
			
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
