package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;

import database.DatabaseConnection;

public class HistorySearchByDate extends DatabaseConnection {

	DateFormat formateDATEddMMMM = new SimpleDateFormat("dd MMMM, yyyy");
	DateFormat formateDATEddMMM = new SimpleDateFormat("dd MMM, yyyy");
	DateFormat formateDATEddMM = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat formateDATEEEddMMM = new SimpleDateFormat("EE dd MMMM, yyyy");
	DateFormat formateDATEMMM = new SimpleDateFormat("MMMM dd, yyyy");
	
	String DATEddMMMM;
	String DATEddMMM;
	String DATEddMM;
	String DATEEEddMMM;
	String DATEMMM;
	
	public HistorySearchByDate(LocalDate localDate) {
		java.util.Date date = java.sql.Date.valueOf(localDate);
		this.DATEddMMMM = formateDATEddMMMM.format(date);
		this.DATEddMMM = formateDATEddMMM.format(date);
		this.DATEddMM = formateDATEddMM.format(date);
		this.DATEEEddMMM = formateDATEEEddMMM.format(date);
		this.DATEMMM = formateDATEMMM.format(date);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Collection<JSONObject> getHistoryByDate() {
		
		Collection<JSONObject> allData = new LinkedList<JSONObject>();
		String dateFormatString[] = {DATEddMMMM, DATEddMMM, DATEddMM, DATEEEddMMM, DATEMMM};
		
		try {
			for (int globalid : getGlobalIdByAsc(dateFormatString)) {

				String gmresult = "SELECT * FROM Get_Money WHERE globalID = ?";
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(gmresult)) {
					pstmt.setInt(1, globalid);
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
					pstmt.setInt(1, globalid);
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
					pstmt.setInt(1, globalid);
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
					pstmt.setInt(1, globalid);
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
					pstmt.setInt(1, globalid);
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
					pstmt.setInt(1, globalid);
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
					pstmt.setInt(1, globalid);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allData;
	}
	
	
	private int[] getGlobalIdByAsc(String dateFormatString[]) {
		int[] globalIDarr = new int[getGlobalIdByAscSize(dateFormatString)];
		int arrIndex = 0;
		
		for (String dateString : dateFormatString) {
			String gmresult = "SELECT * FROM Get_Money WHERE gmDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(gmresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String exresult = "SELECT * FROM Expense WHERE exDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(exresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
		
			String boresult = "SELECT * FROM Borrow WHERE boDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(boresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String leresult = "SELECT * FROM Lend WHERE leDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(leresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String bkresult = "SELECT * FROM bKash WHERE bkDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(bkresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String rocresult = "SELECT * FROM Rocket WHERE rocDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(rocresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String perresult = "SELECT * FROM Personal WHERE perDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(perresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					globalIDarr[arrIndex] = result.getInt("globalID");
					++arrIndex;
				}
			} catch (Exception e) {e.printStackTrace();}
		}

		for (int i = 0; i < globalIDarr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < globalIDarr.length; j++) {
                if (globalIDarr[j] > globalIDarr[index]) { 
                    index = j;
                }
            }
            int smallerNumber = globalIDarr[index];  
            globalIDarr[index] = globalIDarr[i];
            globalIDarr[i] = smallerNumber;
        }
		
		return globalIDarr;
	}
	
	
	private int getGlobalIdByAscSize(String dateFormatString[]) {
		int arrSize = 0;
		
		for (String dateString : dateFormatString) {
			
			String gmresult = "SELECT * FROM Get_Money WHERE gmDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(gmresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String exresult = "SELECT * FROM Expense WHERE exDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(exresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
		
			String boresult = "SELECT * FROM Borrow WHERE boDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(boresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String leresult = "SELECT * FROM Lend WHERE leDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(leresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String bkresult = "SELECT * FROM bKash WHERE bkDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(bkresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
			
			String rocresult = "SELECT * FROM Rocket WHERE rocDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(rocresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
			 
			String perresult = "SELECT * FROM Personal WHERE perDate = ?";
			try (Connection conn = connector();
					PreparedStatement pstmt = conn.prepareStatement(perresult)) {
				pstmt.setString(1, dateString);
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					arrSize++;
				}
			} catch (Exception e) {e.printStackTrace();}
		}
		
		return arrSize;
	}

}










