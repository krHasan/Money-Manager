package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import operation.GlobalId;
import tab.Borrow;
import tab.Lend;

public class Undo extends DateAndClock {
	
	public String actionUndo() {
		String feedback = null;
		boolean limit = false;
		int globalID = 0;
		String getGID = "SELECT globalId FROM System_Settings";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(getGID)) {
			globalID = result.getInt("globalId")-1;
		} catch (Exception e) {e.printStackTrace();}
		
		int undoId = 0;
		String getUID = "SELECT undoId FROM System_Settings";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(getUID)) {
			undoId = result.getInt("undoId");
		} catch (Exception e) {e.printStackTrace();}
		 
		if (globalID <= undoId) {
			limit = false;
		} else if((globalID-undoId)>=1 && (globalID-undoId)<=5) {
			limit = true;
		} else if((globalID-undoId)>5) {
			limit = true;
			GlobalId.setUndoId((globalID-5));
		}
		
		if (limit) {
			if (undoGetMoney(globalID)) {
				feedback = "Last \"Get Money\" transaction has been rollbacked";
			} else if(undoExpense(globalID)) {
				feedback = "Last \"Expense\" transaction has been rollbacked";
			} else if(undoBorrow(globalID)) {
				feedback = "Last \"Borrow\" transaction has been rollbacked";
			} else if(undoLend(globalID)) {
				feedback = "Last \"Lend\" transaction has been rollbacked";
			} else if(undobKash(globalID)) {
				feedback = "Last \"bKash\" transaction has been rollbacked";
			} else if(undoRocket(globalID)) {
				feedback = "Last \"Rocket\" transaction has been rollbacked";
			} else if(undoPersonal(globalID)) {
				feedback = "Last \"Personal\" transaction has been rollbacked";
			} else {
				feedback = "Something Problem";
			}
		} else {
			feedback = "Sorry! Undo Limit is Over";
		}
		
		return feedback;
	}
	
		
///////////////////////// Get Money Undo Action /////////////////////////////////
//-----------------------------------------------------------------------------//
	private boolean undoGetMoney(int globalID) {
		boolean feedback = false;
		
		String undoGM = "SELECT * FROM Get_Money WHERE globalID = ?";
		String deleteGM = "DELETE FROM Get_Money WHERE globalID = ?";
		String gmMethod = "None";
		String gmWalletBalanceBefore = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoGM)) {
			pstmt.setInt(1, globalID);
			ResultSet gmResult = pstmt.executeQuery();
			if (gmResult.next()) {
				gmMethod = gmResult.getString("gmMethod");
				gmWalletBalanceBefore = gmResult.getString("gmWalletBalanceBefore");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (gmMethod.equals("bKash")) {
			String undoGMbk = "SELECT * FROM bKash WHERE globalID = ?";
			String deleteGMbk = "DELETE FROM bKash WHERE globalID = ?";
			String bkBalanceBefore = null;
			try (Connection connbk = connector();
					PreparedStatement pstmtbk = connbk.prepareStatement(undoGMbk)){
				pstmtbk.setInt(1, --globalID);
				ResultSet resultbk = pstmtbk.executeQuery();
				bkBalanceBefore = resultbk.getString("bkBalanceBefore");
			} catch (Exception e) {e.printStackTrace();}
			setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
			
			try (Connection connbk = connector();
					PreparedStatement pstmtbk = connbk.prepareStatement(deleteGMbk)){
				pstmtbk.setInt(1, globalID);
				pstmtbk.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			try (Connection conngm = connector();
					PreparedStatement pstmtgm = conngm.prepareStatement(deleteGM)){
				pstmtgm.setInt(1, ++globalID);
				pstmtgm.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			GlobalId.setGlobalId(--globalID);
		
		} else if(gmMethod.equals("Rocket")){
			String undoGMroc = "SELECT * FROM Rocket WHERE globalID = ?";
			String deleteGMroc = "DELETE FROM Rocket WHERE globalID = ?";
			String rocBalanceBefore = null;
			try (Connection connroc = connector();
					PreparedStatement pstmtroc = connroc.prepareStatement(undoGMroc)){
				pstmtroc.setInt(1, --globalID);
				ResultSet resultroc = pstmtroc.executeQuery();
				rocBalanceBefore = resultroc.getString("rocBalanceBefore");
			} catch (Exception e) {e.printStackTrace();}
			setCurrentRocketBalance(removeThousandSeparator(rocBalanceBefore));
			
			try (Connection connroc = connector();
					PreparedStatement pstmtroc = connroc.prepareStatement(deleteGMroc)){
				pstmtroc.setInt(1, globalID);
				pstmtroc.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			try (Connection conngm = connector();
					PreparedStatement pstmtgm = conngm.prepareStatement(deleteGM)){
				pstmtgm.setInt(1, ++globalID);
				pstmtgm.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			GlobalId.setGlobalId(--globalID);
			
		} else if(gmMethod.equals("Hand to Hand")){
			setCurrentWalletBalance(removeThousandSeparator(gmWalletBalanceBefore));
			
			try (Connection conngm = connector();
					PreparedStatement pstmtgm = conngm.prepareStatement(deleteGM)){
				pstmtgm.setInt(1, globalID);
				pstmtgm.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			GlobalId.setGlobalId(globalID);
		}
		
		return feedback;
	}
	

///////////////////////// Expense Undo Action /////////////////////////////////
//---------------------------------------------------------------------------//
	private boolean undoExpense(int globalID) {
		boolean feedback = false;
		
		String undoEx = "SELECT * FROM Expense WHERE globalID = ?";
		String deleteEx = "DELETE FROM Expense WHERE globalID = ?";
		String exWalletBalanceBefore = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoEx)) {
			pstmt.setInt(1, globalID);
			ResultSet exResult = pstmt.executeQuery();
			if (exResult.next()) {
				exWalletBalanceBefore = exResult.getString("exWalletBalanceBefore");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (feedback) {
			setCurrentWalletBalance(removeThousandSeparator(exWalletBalanceBefore));
			
			try (Connection conngm = connector();
					PreparedStatement pstmtgm = conngm.prepareStatement(deleteEx)){
				pstmtgm.setInt(1, globalID);
				pstmtgm.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			GlobalId.setGlobalId(globalID);
		}
		
		return feedback;
	}
	
	
///////////////////////// Borrow Undo Action /////////////////////////////////
//--------------------------------------------------------------------------//
	private boolean undoBorrow(int globalID) {
		boolean feedback = false;
		
		String undoBo = "SELECT * FROM Borrow WHERE globalID = ?";
		String deleteBo = "DELETE FROM Borrow WHERE globalID = ?";
		String boBalanceBefore = null;
		String boType = "None";
		String boMethod = "None";
		String boWhom = null;
		String boExactTk = null;
		String boDate = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoBo)) {
			pstmt.setInt(1, globalID);
			ResultSet boResult = pstmt.executeQuery();
			if (boResult.next()) {
				boBalanceBefore = boResult.getString("boBalanceBefore");
				boType = boResult.getString("boType");
				boMethod = boResult.getString("boMethod");
				boWhom = boResult.getString("boWhom");
				boExactTk = boResult.getString("boExactTk");
				boDate = boResult.getString("boDate");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (boType.equals("Money Take")) {
			if (boMethod.equals("bKash")) {
				
				try (Connection connbo = connector();
						PreparedStatement pstmtbo = connbo.prepareStatement(deleteBo)){
					pstmtbo.setInt(1, globalID);
					pstmtbo.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoBk = "SELECT * FROM bKash WHERE globalID = ?";
				String deleteBk = "DELETE FROM bKash WHERE globalID = ?";
				String bkBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoBk)) {
					pstmt.setInt(1, --globalID);
					ResultSet bkResult = pstmt.executeQuery();
					bkBalanceBefore = bkResult.getString("bkBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connbk = connector();
						PreparedStatement pstmtbk = connbk.prepareStatement(deleteBk)){
					pstmtbk.setInt(1, globalID);
					pstmtbk.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteBoSummary = "DELETE FROM Borrow_Summary WHERE boWhom = ?";
				try (Connection connbk = connector();
						PreparedStatement pstmtbk = connbk.prepareStatement(deleteBoSummary)){
					pstmtbk.setString(1, boWhom);
					pstmtbk.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			} else if(boMethod.equals("Rocket")) {
				
				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteBo)){
					pstmtgm.setInt(1, globalID);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoRoc = "SELECT * FROM Rocket WHERE globalID = ?";
				String deleteRoc = "DELETE FROM Rocket WHERE globalID = ?";
				String rocBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoRoc)) {
					pstmt.setInt(1, --globalID);
					ResultSet rocResult = pstmt.executeQuery();
					rocBalanceBefore = rocResult.getString("rocBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connroc = connector();
						PreparedStatement pstmtroc = connroc.prepareStatement(deleteRoc)){
					pstmtroc.setInt(1, globalID);
					pstmtroc.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteBoSummary = "DELETE FROM Borrow_Summary WHERE boWhom = ?";
				try (Connection connroc = connector();
						PreparedStatement pstmtroc = connroc.prepareStatement(deleteBoSummary)){
					pstmtroc.setString(1, boWhom);
					pstmtroc.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentRocketBalance(removeThousandSeparator(rocBalanceBefore));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(globalID);

			} else if(boMethod.equals("Hand to Hand")) {
				
				try (Connection connHH = connector();
						PreparedStatement pstmtHH = connHH.prepareStatement(deleteBo)){
					pstmtHH.setInt(1, globalID);
					pstmtHH.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteBoSummary = "DELETE FROM Borrow_Summary WHERE boWhom = ?";
				try (Connection connHH = connector();
						PreparedStatement pstmtHH = connHH.prepareStatement(deleteBoSummary)){
					pstmtHH.setString(1, boWhom);
					pstmtHH.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentWalletBalance(longToString(currentWalletBalance()-stringToLong(removeThousandSeparator(boExactTk))));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(globalID);

			}
		} else if(boType.equals("Return Borrowed Money")) {
			if (boMethod.equals("bKash")) {
				
				try (Connection connbo = connector();
						PreparedStatement pstmtbo = connbo.prepareStatement(deleteBo)){
					pstmtbo.setInt(1, globalID);
					pstmtbo.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoBk = "SELECT * FROM bKash WHERE globalID = ?";
				String deleteBk = "DELETE FROM bKash WHERE globalID = ?";
				String bkBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoBk)) {
					pstmt.setInt(1, --globalID);
					ResultSet bkResult = pstmt.executeQuery();
					bkBalanceBefore = bkResult.getString("bkBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connbk = connector();
						PreparedStatement pstmtbk = connbk.prepareStatement(deleteBk)){
					pstmtbk.setInt(1, globalID);
					pstmtbk.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				Map<String, String> boleData = new HashMap<>();
				boleData.put("boDate", boDate);
				boleData.put("boWhom", boWhom);
				boleData.put("boExactTk", removeThousandSeparator(boExactTk));
				
				if (!new Borrow().boRepayPersonBorrowedAmount(boWhom).isEmpty()) {
					(new Borrow()).updateBorrowSummaryDataForUndo(boleData);
				} else {
					(new Borrow()).addBorrowSummaryData(boleData);
				}
				
				setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			} else if(boMethod.equals("Rocket")) {

				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteBo)){
					pstmtgm.setInt(1, globalID);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoRoc = "SELECT * FROM Rocket WHERE globalID = ?";
				String deleteRoc = "DELETE FROM Rocket WHERE globalID = ?";
				String rocBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoRoc)) {
					pstmt.setInt(1, --globalID);
					ResultSet rocResult = pstmt.executeQuery();
					rocBalanceBefore = rocResult.getString("rocBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connroc = connector();
						PreparedStatement pstmtroc = connroc.prepareStatement(deleteRoc)){
					pstmtroc.setInt(1, globalID);
					pstmtroc.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				Map<String, String> boleData = new HashMap<>();
				boleData.put("boDate", boDate);
				boleData.put("boWhom", boWhom);
				boleData.put("boExactTk", removeThousandSeparator(boExactTk));
				
				if (!new Borrow().boRepayPersonBorrowedAmount(boWhom).isEmpty()) {
					(new Borrow()).updateBorrowSummaryDataForUndo(boleData);
				} else {
					(new Borrow()).addBorrowSummaryData(boleData);
				}
				
				setCurrentRocketBalance(removeThousandSeparator(rocBalanceBefore));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			} else if(boMethod.equals("Hand to Hand")) {
				
				try (Connection connHH = connector();
						PreparedStatement pstmtHH = connHH.prepareStatement(deleteBo)){
					pstmtHH.setInt(1, globalID);
					pstmtHH.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				Map<String, String> boleData = new HashMap<>();
				boleData.put("boDate", boDate);
				boleData.put("boWhom", boWhom);
				boleData.put("boExactTk", removeThousandSeparator(boExactTk));

				if (!new Borrow().boRepayPersonBorrowedAmount(boWhom).isEmpty()) {
					(new Borrow()).updateBorrowSummaryDataForUndo(boleData);
				} else {
					(new Borrow()).addBorrowSummaryData(boleData);
				}
				
				setCurrentWalletBalance(longToString(currentWalletBalance()+stringToLong(removeThousandSeparator(boExactTk))));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			}
		}
		
		return feedback;
	}
	
	
///////////////////////// Lend Undo Action /////////////////////////////////
//------------------------------------------------------------------------//
	private boolean undoLend(int globalID) {
		boolean feedback = false;
		
		String undoLe = "SELECT * FROM Lend WHERE globalID = ?";
		String deleteLe = "DELETE FROM Lend WHERE globalID = ?";
		String leBalanceBefore = null;
		String leType = "None";
		String leMethod = "None";
		String leWhom = null;
		String leExactTk = null;
		String leDate = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoLe)) {
			pstmt.setInt(1, globalID);
			ResultSet leResult = pstmt.executeQuery();
			if (leResult.next()) {
				leBalanceBefore = leResult.getString("leBalanceBefore");
				leType = leResult.getString("leType");
				leMethod = leResult.getString("leMethod");
				leWhom = leResult.getString("leWhom");
				leExactTk = leResult.getString("leExactTk");
				leDate = leResult.getString("leDate");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (leType.equals("Give Money")) {
			if (leMethod.equals("bKash")) {
				
				try (Connection connle = connector();
						PreparedStatement pstmtle = connle.prepareStatement(deleteLe)){
					pstmtle.setInt(1, globalID);
					pstmtle.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoBk = "SELECT * FROM bKash WHERE globalID = ?";
				String deleteBk = "DELETE FROM bKash WHERE globalID = ?";
				String bkBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoBk)) {
					pstmt.setInt(1, --globalID);
					ResultSet bkResult = pstmt.executeQuery();
					bkBalanceBefore = bkResult.getString("bkBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connbk = connector();
						PreparedStatement pstmtbk = connbk.prepareStatement(deleteBk)){
					pstmtbk.setInt(1, globalID);
					pstmtbk.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteLeSummary = "DELETE FROM Lend_Summary WHERE leWhom = ?";
				try (Connection connbk = connector();
						PreparedStatement pstmtbk = connbk.prepareStatement(deleteLeSummary)){
					pstmtbk.setString(1, leWhom);
					pstmtbk.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
				setTotalLendTk(removeThousandSeparator(leBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			} else if(leMethod.equals("Rocket")) {
				
				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteLe)){
					pstmtgm.setInt(1, globalID);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoRoc = "SELECT * FROM Rocket WHERE globalID = ?";
				String deleteRoc = "DELETE FROM Rocket WHERE globalID = ?";
				String rocBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoRoc)) {
					pstmt.setInt(1, --globalID);
					ResultSet rocResult = pstmt.executeQuery();
					rocBalanceBefore = rocResult.getString("rocBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connroc = connector();
						PreparedStatement pstmtroc = connroc.prepareStatement(deleteRoc)){
					pstmtroc.setInt(1, globalID);
					pstmtroc.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteLeSummary = "DELETE FROM Lend_Summary WHERE leWhom = ?";
				try (Connection connroc = connector();
						PreparedStatement pstmtroc = connroc.prepareStatement(deleteLeSummary)){
					pstmtroc.setString(1, leWhom);
					pstmtroc.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentRocketBalance(removeThousandSeparator(rocBalanceBefore));
				setTotalLendTk(removeThousandSeparator(leBalanceBefore));
				GlobalId.setGlobalId(globalID);

			} else if(leMethod.equals("Hand to Hand")) {
				
				try (Connection connHH = connector();
						PreparedStatement pstmtHH = connHH.prepareStatement(deleteLe)){
					pstmtHH.setInt(1, globalID);
					pstmtHH.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteLeSummary = "DELETE FROM Lend_Summary WHERE leWhom = ?";
				try (Connection connHH = connector();
						PreparedStatement pstmtHH = connHH.prepareStatement(deleteLeSummary)){
					pstmtHH.setString(1, leWhom);
					pstmtHH.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentWalletBalance(longToString(currentWalletBalance()+stringToLong(removeThousandSeparator(leExactTk))));
				setTotalLendTk(removeThousandSeparator(leBalanceBefore));
				GlobalId.setGlobalId(globalID);

			}
		} else if(leType.equals("Take Back Lended Money")) {
			if (leMethod.equals("bKash")) {
				
				try (Connection connle = connector();
						PreparedStatement pstmtle = connle.prepareStatement(deleteLe)){
					pstmtle.setInt(1, globalID);
					pstmtle.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoBk = "SELECT * FROM bKash WHERE globalID = ?";
				String deleteBk = "DELETE FROM bKash WHERE globalID = ?";
				String bkBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoBk)) {
					pstmt.setInt(1, --globalID);
					ResultSet bkResult = pstmt.executeQuery();
					bkBalanceBefore = bkResult.getString("bkBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connbk = connector();
						PreparedStatement pstmtbk = connbk.prepareStatement(deleteBk)){
					pstmtbk.setInt(1, globalID);
					pstmtbk.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				Map<String, String> boleData = new HashMap<>();
				boleData.put("leDate", leDate);
				boleData.put("leWhom", leWhom);
				boleData.put("leExactTk", removeThousandSeparator(leExactTk));

				if (!new Lend().leRepayPersonLendedAmount(leWhom).isEmpty()) {
					(new Lend()).updateLendSummaryDataForUndo(boleData);
				} else {
					(new Lend()).addLendSummaryData(boleData);
				}
				
				setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
				setTotalLendTk(removeThousandSeparator(leBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			} else if(leMethod.equals("Rocket")) {

				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteLe)){
					pstmtgm.setInt(1, globalID);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoRoc = "SELECT * FROM Rocket WHERE globalID = ?";
				String deleteRoc = "DELETE FROM Rocket WHERE globalID = ?";
				String rocBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoRoc)) {
					pstmt.setInt(1, --globalID);
					ResultSet rocResult = pstmt.executeQuery();
					rocBalanceBefore = rocResult.getString("rocBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection connroc = connector();
						PreparedStatement pstmtroc = connroc.prepareStatement(deleteRoc)){
					pstmtroc.setInt(1, globalID);
					pstmtroc.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				Map<String, String> boleData = new HashMap<>();
				boleData.put("leDate", leDate);
				boleData.put("leWhom", leWhom);
				boleData.put("leExactTk", removeThousandSeparator(leExactTk));

				if (!new Lend().leRepayPersonLendedAmount(leWhom).isEmpty()) {
					(new Lend()).updateLendSummaryDataForUndo(boleData);
				} else {
					(new Lend()).addLendSummaryData(boleData);
				}
				
				setCurrentRocketBalance(removeThousandSeparator(rocBalanceBefore));
				setTotalLendTk(removeThousandSeparator(leBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			} else if(leMethod.equals("Hand to Hand")) {
				
				try (Connection connHH = connector();
						PreparedStatement pstmtHH = connHH.prepareStatement(deleteLe)){
					pstmtHH.setInt(1, globalID);
					pstmtHH.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				Map<String, String> boleData = new HashMap<>();
				boleData.put("leDate", leDate);
				boleData.put("leWhom", leWhom);
				boleData.put("leExactTk", removeThousandSeparator(leExactTk));
				
				if (!new Lend().leRepayPersonLendedAmount(leWhom).isEmpty()) {
					(new Lend()).updateLendSummaryDataForUndo(boleData);
				} else {
					(new Lend()).addLendSummaryData(boleData);
				}
				
				setCurrentWalletBalance(longToString(currentWalletBalance()-stringToLong(removeThousandSeparator(leExactTk))));
				setTotalLendTk(removeThousandSeparator(leBalanceBefore));
				GlobalId.setGlobalId(globalID);
				
			}
		}
		
		return feedback;
	}
	
	
///////////////////////// bKash Undo Action ////////////////////////////////
//------------------------------------------------------------------------//
	private boolean undobKash(int globalID) {
		boolean feedback = false;
		
		String undobKash = "SELECT * FROM bKash WHERE globalID = ?";
		String deletebKash = "DELETE FROM bKash WHERE globalID = ?";
		String bkBalanceBefore = null;
		String bkType = "None";
		String bkNature = "None";
		String bkAmount = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undobKash)) {
			pstmt.setInt(1, globalID);
			ResultSet bkResult = pstmt.executeQuery();
			if (bkResult.next()) {
				bkBalanceBefore = bkResult.getString("bkBalanceBefore");
				bkType = bkResult.getString("bkType");
				bkNature = bkResult.getString("bkNature");
				bkAmount = bkResult.getString("bkAmount");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (feedback) {
			try (Connection connbk = connector();
					PreparedStatement pstmtbk = connbk.prepareStatement(deletebKash)){
				pstmtbk.setInt(1, globalID);
				pstmtbk.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			if (bkType.equals("Get Money") && !bkNature.equals("Credited by Cash In")) {
				String undogm = "SELECT * FROM Get_Money WHERE globalID = ?";
				String deletegm = "DELETE FROM Get_Money WHERE globalID = ?";
				String gmWalletBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undogm)) {
					pstmt.setInt(1, --globalID);
					ResultSet gmResult = pstmt.executeQuery();
					gmWalletBalanceBefore = gmResult.getString("gmWalletBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection conngm = connector();
						PreparedStatement pstmt = conngm.prepareStatement(deletegm)){
					pstmt.setInt(1, globalID);
					pstmt.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentWalletBalance(removeThousandSeparator(gmWalletBalanceBefore));
			}
			
			if (bkType.equals("Personal") && !bkNature.equals("Credited by Cash In")) {
				setCurrentWalletBalance(longToString(currentWalletBalance()-stringToLong(removeThousandSeparator(bkAmount))));
			}
			
			setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
			GlobalId.setGlobalId(globalID);
		}
		
		return feedback;
	}
///////////////////////// Rocket Undo Action ///////////////////////////////
//------------------------------------------------------------------------//
	private boolean undoRocket(int globalID) {
		boolean feedback = false;

		String undoRocket = "SELECT * FROM Rocket WHERE globalID = ?";
		String deleteRocket = "DELETE FROM Rocket WHERE globalID = ?";
		String rocBalanceBefore = null;
		String rocType = "None";
		String rocNature = "None";
		String rocAmount = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoRocket)) {
			pstmt.setInt(1, globalID);
			ResultSet rocResult = pstmt.executeQuery();
			if (rocResult.next()) {
				rocBalanceBefore = rocResult.getString("rocBalanceBefore");
				rocType = rocResult.getString("rocType");
				rocNature = rocResult.getString("rocNature");
				rocAmount = rocResult.getString("rocAmount");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (feedback) {
			try (Connection connroc = connector();
					PreparedStatement pstmtroc = connroc.prepareStatement(deleteRocket)){
				pstmtroc.setInt(1, globalID);
				pstmtroc.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			if (rocType.equals("Get Money")) {
				if (rocNature.equals("ATM") || rocNature.equals("TopUp") || rocNature.equals("Agent") || rocNature.equals("Branch") || rocNature.equals("Send Money")) {
					String undogm = "SELECT * FROM Get_Money WHERE globalID = ?";
					String deletegm = "DELETE FROM Get_Money WHERE globalID = ?";
					String gmWalletBalanceBefore = null;
					try (Connection conn = connector();
							PreparedStatement pstmt = conn.prepareStatement(undogm)) {
						pstmt.setInt(1, --globalID);
						ResultSet gmResult = pstmt.executeQuery();
						gmWalletBalanceBefore = gmResult.getString("gmWalletBalanceBefore");
					} catch (Exception e) {e.printStackTrace();}
					
					try (Connection conngm = connector();
							PreparedStatement pstmt = conngm.prepareStatement(deletegm)){
						pstmt.setInt(1, globalID);
						pstmt.executeUpdate();
					} catch (Exception e) {e.printStackTrace();}
					
					setCurrentWalletBalance(removeThousandSeparator(gmWalletBalanceBefore));
				}
			}
			
			if (rocType.equals("Personal")) {
				if (rocNature.equals("Debited by ATM") || rocNature.equals("Debited by TopUp") || rocNature.equals("Debited by Agent") || rocNature.equals("Debited by Branch") || rocNature.equals("Debited by Send Money")) {
					setCurrentWalletBalance(longToString(
							currentWalletBalance() - stringToLong(removeThousandSeparator(rocAmount))));
				}
			}
			
			setCurrentRocketBalance(removeThousandSeparator(rocBalanceBefore));
			GlobalId.setGlobalId(globalID);
		}
		
		return feedback;
	}
///////////////////////// Personal Undo Action /////////////////////////////
//------------------------------------------------------------------------//
	private boolean undoPersonal(int globalID) {
		boolean feedback = false;

		String undoPersonal = "SELECT * FROM Personal WHERE globalID = ?";
		String deletePersonal = "DELETE FROM Personal WHERE globalID = ?";
		String perBalanceBefore = null;
		String perNature = "None";
		String perAmount = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoPersonal)) {
			pstmt.setInt(1, globalID);
			ResultSet perResult = pstmt.executeQuery();
			if (perResult.next()) {
				perBalanceBefore = perResult.getString("perBalanceBefore");
				perNature = perResult.getString("perNature");
				perAmount = perResult.getString("perAmount");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (feedback) {
			try (Connection connper = connector();
					PreparedStatement pstmtper = connper.prepareStatement(deletePersonal)){
				pstmtper.setInt(1, globalID);
				pstmtper.executeUpdate();
			} catch (Exception e) {e.printStackTrace();}
			
			if (perNature.equals("Credit")) {
				setCurrentWalletBalance(longToString(currentWalletBalance() + stringToLong(removeThousandSeparator(perAmount))));
			} else if(perNature.equals("Debit")) {
				setCurrentWalletBalance(longToString(currentWalletBalance() - stringToLong(removeThousandSeparator(perAmount))));
			}
			
			setCurrentPersonalBalance(removeThousandSeparator(perBalanceBefore));
			GlobalId.setGlobalId(globalID);
		}
		
		return feedback;
	}
	
	
//	public static void main(String[] args) {
//		Undo access = new Undo();
//		System.out.println(access.actionUndo());
//		GlobalId.setGlobalId(14);
//	}
	
}
