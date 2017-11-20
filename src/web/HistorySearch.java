package web;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

import org.json.simple.JSONObject;

import database.DatabaseConnection;
import operation.ComboboxList;

public class HistorySearch extends DatabaseConnection {

	String monthName;
	String typedFilterName;
	public boolean initialize = false;
	
	public HistorySearch(String monthName, String typedFilterName) {
		this.monthName = monthName;
		this.typedFilterName = typedFilterName;
	}
	
	
	@SuppressWarnings("unchecked")
	public Collection<JSONObject> getAllHistory() {
		int minIDnumber = new MaxMinGlobalID().getMinIDNumber(monthName);
		int maxIDnumber = new MaxMinGlobalID().getMaxIDNumber(monthName);
		
		Collection<JSONObject> allData = new LinkedList<JSONObject>();
		
		try {
			JSONObject searchedFilter = new JSONObject();
			 if (new ComboboxList().isFilterInSource(typedFilterName)) {
				 searchedFilter.put("typedFilterName", "Source");
			 } else if (new ComboboxList().isFilterInSector(typedFilterName)) {
				 searchedFilter.put("typedFilterName", "Sector");
			 } else {
				 searchedFilter.put("typedFilterName", typedFilterName); 
			 }
			allData.add(searchedFilter);
		} catch (Exception e1) {e1.printStackTrace();}
		
		
		if (typedFilterName.equals("All")) {
			
			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				
				String gmresult = "SELECT * FROM Get_Money WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(gmresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject gmData = new JSONObject();
						gmData.put("globalID", result.getInt("globalID"));
						gmData.put("gmTime", result.getString("gmTime"));
						gmData.put("gmDate", result.getString("gmDate"));
						gmData.put("gmMonth", result.getString("gmMonth"));
						gmData.put("gmAmount", result.getString("gmAmount"));
						gmData.put("gmSource", result.getString("gmSource"));
						gmData.put("gmBankCharge", result.getString("gmBankCharge"));
						gmData.put("gmDescription", result.getString("gmDescription"));
						gmData.put("gmMethod", result.getString("gmMethod"));
						gmData.put("gmAmountNature", result.getString("gmAmountNature"));
						gmData.put("gmWalletBalanceBefore", result.getString("gmWalletBalanceBefore"));
						gmData.put("gmWalletBalanceAfter", result.getString("gmWalletBalanceAfter"));
						gmData.put("filter", "Get Money");
						allData.add(gmData);
					}
				} catch (Exception e) {e.printStackTrace();}
				
				String exresult = "SELECT * FROM Expense WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(exresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject exData = new JSONObject();
						exData.put("globalID", result.getInt("globalID"));
						exData.put("exTime", result.getString("exTime"));
						exData.put("exDate", result.getString("exDate"));
						exData.put("exMonth", result.getString("exMonth"));
						exData.put("exAmount", result.getString("exAmount"));
						exData.put("exDescription", result.getString("exDescription"));
						exData.put("exSector", result.getString("exSector"));
						exData.put("exWalletBalanceBefore", result.getString("exWalletBalanceBefore"));
						exData.put("exWalletBalanceAfter", result.getString("exWalletBalanceAfter"));
						exData.put("filter", "Expense");
						allData.add(exData);
					}
				} catch (Exception e) {e.printStackTrace();}
			
				String boresult = "SELECT * FROM Borrow WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(boresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject boData = new JSONObject();
						boData.put("globalID", result.getInt("globalID"));
						boData.put("boTime", result.getString("boTime"));
						boData.put("boDate", result.getString("boDate"));
						boData.put("boMonth", result.getString("boMonth"));
						boData.put("boType", result.getString("boType"));
						boData.put("boMethod", result.getString("boMethod"));
						boData.put("boWhom", result.getString("boWhom"));
						boData.put("boTk", result.getString("boTk"));
						boData.put("boNature", result.getString("boNature"));
						boData.put("boBnkCharge", result.getString("boBnkCharge"));
						boData.put("boBalanceBefore", result.getString("boBalanceBefore"));
						boData.put("boBalanceAfter", result.getString("boBalanceAfter"));
						boData.put("boExactTk", result.getString("boExactTk"));
						boData.put("filter", "Borrow");
						allData.add(boData);
					}
				} catch (Exception e) {e.printStackTrace();}
				
				String leresult = "SELECT * FROM Lend WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(leresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject leData = new JSONObject();
						leData.put("globalID", result.getInt("globalID"));
						leData.put("leTime", result.getString("leTime"));
						leData.put("leDate", result.getString("leDate"));
						leData.put("leMonth", result.getString("leMonth"));
						leData.put("leType", result.getString("leType"));
						leData.put("leMethod", result.getString("leMethod"));
						leData.put("leWhom", result.getString("leWhom"));
						leData.put("leTk", result.getString("leTk"));
						leData.put("leNature", result.getString("leNature"));
						leData.put("leBnkCharge", result.getString("leBnkCharge"));
						leData.put("leBalanceBefore", result.getString("leBalanceBefore"));
						leData.put("leBalanceAfter", result.getString("leBalanceAfter"));
						leData.put("leExactTk", result.getString("leExactTk"));
						leData.put("filter", "Lend");
						allData.add(leData);
					}
				} catch (Exception e) {e.printStackTrace();}
				
				String bkresult = "SELECT * FROM bKash WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(bkresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject bkData = new JSONObject();
						bkData.put("globalID", result.getInt("globalID"));
						bkData.put("bkTime", result.getString("bkTime"));
						bkData.put("bkDate", result.getString("bkDate"));
						bkData.put("bkMonth", result.getString("bkMonth"));
						bkData.put("bkType", result.getString("bkType"));
						bkData.put("bkNature", result.getString("bkNature"));
						bkData.put("bkAmount", result.getString("bkAmount"));
						bkData.put("bkBnkCharge", result.getString("bkBnkCharge"));
						bkData.put("bkBalanceBefore", result.getString("bkBalanceBefore"));
						bkData.put("bkBalanceAfter", result.getString("bkBalanceAfter"));
						bkData.put("filter", "bKash");
						allData.add(bkData);
					}
				} catch (Exception e) {e.printStackTrace();}
				
				String rocresult = "SELECT * FROM Rocket WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(rocresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject rocData = new JSONObject();
						rocData.put("globalID", result.getInt("globalID"));
						rocData.put("rocTime", result.getString("rocTime"));
						rocData.put("rocDate", result.getString("rocDate"));
						rocData.put("rocMonth", result.getString("rocMonth"));
						rocData.put("rocType", result.getString("rocType"));
						rocData.put("rocNature", result.getString("rocNature"));
						rocData.put("rocAmount", result.getString("rocAmount"));
						rocData.put("rocBnkCharge", result.getString("rocBnkCharge"));
						rocData.put("rocBalanceBefore", result.getString("rocBalanceBefore"));
						rocData.put("rocBalanceAfter", result.getString("rocBalanceAfter"));
						rocData.put("filter", "Rocket");
						allData.add(rocData);
					}
				} catch (Exception e) {e.printStackTrace();}
				
				String perresult = "SELECT * FROM Personal WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(perresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject perData = new JSONObject();
						perData.put("globalID", result.getInt("globalID"));
						perData.put("perTime", result.getString("perTime"));
						perData.put("perDate", result.getString("perDate"));
						perData.put("perMonth", result.getString("perMonth"));
						perData.put("perNature", result.getString("perNature"));
						perData.put("perAmount", result.getString("perAmount"));
						perData.put("perBalanceBefore", result.getString("perBalanceBefore"));
						perData.put("perBalanceAfter", result.getString("perBalanceAfter"));
						perData.put("filter", "Personal");
						allData.add(perData);
					}
				} catch (Exception e) {e.printStackTrace();}
				
			}
			
		} else if(typedFilterName.equals("Get Money")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String gmresult = "SELECT * FROM Get_Money WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(gmresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject gmData = new JSONObject();
						gmData.put("globalID", result.getInt("globalID"));
						gmData.put("gmTime", result.getString("gmTime"));
						gmData.put("gmDate", result.getString("gmDate"));
						gmData.put("gmMonth", result.getString("gmMonth"));
						gmData.put("gmAmount", result.getString("gmAmount"));
						gmData.put("gmSource", result.getString("gmSource"));
						gmData.put("gmBankCharge", result.getString("gmBankCharge"));
						gmData.put("gmDescription", result.getString("gmDescription"));
						gmData.put("gmMethod", result.getString("gmMethod"));
						gmData.put("gmAmountNature", result.getString("gmAmountNature"));
						gmData.put("gmWalletBalanceBefore", result.getString("gmWalletBalanceBefore"));
						gmData.put("gmWalletBalanceAfter", result.getString("gmWalletBalanceAfter"));
						gmData.put("filter", "Get Money");
						allData.add(gmData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if(typedFilterName.equals("Expense")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String exresult = "SELECT * FROM Expense WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(exresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject exData = new JSONObject();
						exData.put("globalID", result.getInt("globalID"));
						exData.put("exTime", result.getString("exTime"));
						exData.put("exDate", result.getString("exDate"));
						exData.put("exMonth", result.getString("exMonth"));
						exData.put("exAmount", result.getString("exAmount"));
						exData.put("exDescription", result.getString("exDescription"));
						exData.put("exSector", result.getString("exSector"));
						exData.put("exWalletBalanceBefore", result.getString("exWalletBalanceBefore"));
						exData.put("exWalletBalanceAfter", result.getString("exWalletBalanceAfter"));
						exData.put("filter", "Expense");
						allData.add(exData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if(typedFilterName.equals("Borrow")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String boresult = "SELECT * FROM Borrow WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(boresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject boData = new JSONObject();
						boData.put("globalID", result.getInt("globalID"));
						boData.put("boTime", result.getString("boTime"));
						boData.put("boDate", result.getString("boDate"));
						boData.put("boMonth", result.getString("boMonth"));
						boData.put("boType", result.getString("boType"));
						boData.put("boMethod", result.getString("boMethod"));
						boData.put("boWhom", result.getString("boWhom"));
						boData.put("boTk", result.getString("boTk"));
						boData.put("boNature", result.getString("boNature"));
						boData.put("boBnkCharge", result.getString("boBnkCharge"));
						boData.put("boBalanceBefore", result.getString("boBalanceBefore"));
						boData.put("boBalanceAfter", result.getString("boBalanceAfter"));
						boData.put("boExactTk", result.getString("boExactTk"));
						boData.put("filter", "Borrow");
						allData.add(boData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if(typedFilterName.equals("Lend")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String leresult = "SELECT * FROM Lend WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(leresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject leData = new JSONObject();
						leData.put("globalID", result.getInt("globalID"));
						leData.put("leTime", result.getString("leTime"));
						leData.put("leDate", result.getString("leDate"));
						leData.put("leMonth", result.getString("leMonth"));
						leData.put("leType", result.getString("leType"));
						leData.put("leMethod", result.getString("leMethod"));
						leData.put("leWhom", result.getString("leWhom"));
						leData.put("leTk", result.getString("leTk"));
						leData.put("leNature", result.getString("leNature"));
						leData.put("leBnkCharge", result.getString("leBnkCharge"));
						leData.put("leBalanceBefore", result.getString("leBalanceBefore"));
						leData.put("leBalanceAfter", result.getString("leBalanceAfter"));
						leData.put("leExactTk", result.getString("leExactTk"));
						leData.put("filter", "Lend");
						allData.add(leData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if(typedFilterName.equals("bKash")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String bkresult = "SELECT * FROM bKash WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(bkresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject bkData = new JSONObject();
						bkData.put("globalID", result.getInt("globalID"));
						bkData.put("bkTime", result.getString("bkTime"));
						bkData.put("bkDate", result.getString("bkDate"));
						bkData.put("bkMonth", result.getString("bkMonth"));
						bkData.put("bkType", result.getString("bkType"));
						bkData.put("bkNature", result.getString("bkNature"));
						bkData.put("bkAmount", result.getString("bkAmount"));
						bkData.put("bkBnkCharge", result.getString("bkBnkCharge"));
						bkData.put("bkBalanceBefore", result.getString("bkBalanceBefore"));
						bkData.put("bkBalanceAfter", result.getString("bkBalanceAfter"));
						bkData.put("filter", "bKash");
						allData.add(bkData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if(typedFilterName.equals("Rocket")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String rocresult = "SELECT * FROM Rocket WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(rocresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject rocData = new JSONObject();
						rocData.put("globalID", result.getInt("globalID"));
						rocData.put("rocTime", result.getString("rocTime"));
						rocData.put("rocDate", result.getString("rocDate"));
						rocData.put("rocMonth", result.getString("rocMonth"));
						rocData.put("rocType", result.getString("rocType"));
						rocData.put("rocNature", result.getString("rocNature"));
						rocData.put("rocAmount", result.getString("rocAmount"));
						rocData.put("rocBnkCharge", result.getString("rocBnkCharge"));
						rocData.put("rocBalanceBefore", result.getString("rocBalanceBefore"));
						rocData.put("rocBalanceAfter", result.getString("rocBalanceAfter"));
						rocData.put("filter", "Rocket");
						allData.add(rocData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if(typedFilterName.equals("Personal")) {

			for (int max = maxIDnumber; max >= minIDnumber; max--) {
				String perresult = "SELECT * FROM Personal WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(perresult)) {
					pstmt.setInt(1, max);
					ResultSet result = pstmt.executeQuery();
					if (result.next()) {
						JSONObject perData = new JSONObject();
						perData.put("globalID", result.getInt("globalID"));
						perData.put("perTime", result.getString("perTime"));
						perData.put("perDate", result.getString("perDate"));
						perData.put("perMonth", result.getString("perMonth"));
						perData.put("perNature", result.getString("perNature"));
						perData.put("perAmount", result.getString("perAmount"));
						perData.put("perBalanceBefore", result.getString("perBalanceBefore"));
						perData.put("perBalanceAfter", result.getString("perBalanceAfter"));
						perData.put("filter", "Personal");
						allData.add(perData);
					}
				} catch (Exception e) {e.printStackTrace();}
			}
			
		} else if (new ComboboxList().isFilterInSource(typedFilterName)) {
	
			String sourceFilterSQL = "SELECT * FROM Get_Money WHERE gmSource = ? ORDER BY globalID DESC";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sourceFilterSQL)) {
				pstmt.setString(1, typedFilterName);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					JSONObject sourceData = new JSONObject();
					sourceData.put("globalID", result.getInt("globalID"));
					sourceData.put("gmTime", result.getString("gmTime"));
					sourceData.put("gmDate", result.getString("gmDate"));
					sourceData.put("gmMonth", result.getString("gmMonth"));
					sourceData.put("gmAmount", result.getString("gmAmount"));
					sourceData.put("gmSource", result.getString("gmSource"));
					sourceData.put("gmBankCharge", result.getString("gmBankCharge"));
					sourceData.put("gmDescription", result.getString("gmDescription"));
					sourceData.put("gmMethod", result.getString("gmMethod"));
					sourceData.put("gmAmountNature", result.getString("gmAmountNature"));
					sourceData.put("gmWalletBalanceBefore", result.getString("gmWalletBalanceBefore"));
					sourceData.put("gmWalletBalanceAfter", result.getString("gmWalletBalanceAfter"));
					sourceData.put("filter", "Source");
					allData.add(sourceData);
				}
			} catch (Exception e) {e.printStackTrace();}
	
		} else if (new ComboboxList().isFilterInSector(typedFilterName)) {
		
			String sectorresult = "SELECT * FROM Expense WHERE exSector = ? ORDER BY globalID DESC";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(sectorresult)) {
				pstmt.setString(1, typedFilterName);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					JSONObject sectorData = new JSONObject();
					sectorData.put("globalID", result.getInt("globalID"));
					sectorData.put("exTime", result.getString("exTime"));
					sectorData.put("exDate", result.getString("exDate"));
					sectorData.put("exMonth", result.getString("exMonth"));
					sectorData.put("exAmount", result.getString("exAmount"));
					sectorData.put("exDescription", result.getString("exDescription"));
					sectorData.put("exSector", result.getString("exSector"));
					sectorData.put("exWalletBalanceBefore", result.getString("exWalletBalanceBefore"));
					sectorData.put("exWalletBalanceAfter", result.getString("exWalletBalanceAfter"));
					sectorData.put("filter", "Sector");
					allData.add(sectorData);
				}
			} catch (Exception e) {e.printStackTrace();}
	
		}
		
//		try (FileWriter file = new FileWriter("allDataJson.json")) {
//			file.write(allData.toString());
//			file.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		
		return allData;
	}
	
	
//	public static void main(String[] args) {
//		HistorySearch access = new HistorySearch("Nov-17", "All");
//		access.getAllHistory();
//	}

}




































