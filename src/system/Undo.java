package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import operation.GlobalId;

public class Undo extends DateAndClock {
	
	public String actionUndo() {
		String feedback = null;
		int globalID = 0;
		String getGID = "SELECT globalId FROM System_Settings";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(getGID)) {
			globalID = result.getInt("globalId")-1;
			System.out.println(globalID);
		} catch (Exception e) {e.printStackTrace();}
		
		if (undoGetMoney(globalID)) {
			feedback = "Last \"Get Money\" transaction has been rollbacked";
		} else if(undoExpense(globalID)) {
			feedback = "Last \"Expense\" transaction has been rollbacked";
		} else if(undoBorrow(globalID)) {
			feedback = "Last \"Borrow\" transaction has been rollbacked";
		} else {
			feedback = "Last \"Lend\" transaction has been rollbacked";
		}
		
		return feedback;
	}
		
///////////////////////// Get Money Undo Action /////////////////////////////////
//----------------------------------------------------------------------------//
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
	
	
	private boolean undoBorrow(int globalID) {
		boolean feedback = false;
		
		String undoBo = "SELECT * FROM Borrow WHERE globalID = ?";
		String deleteBo = "DELETE FROM Borrow WHERE globalID = ?";
		String boBalanceBefore = null;
		String boType = "None";
		String boMethod = "None";
		String boWhom = null;
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(undoBo)) {
			pstmt.setInt(1, --globalID);
			ResultSet boResult = pstmt.executeQuery();
			if (boResult.next()) {
				boBalanceBefore = boResult.getString("boBalanceBefore");
				boType = boResult.getString("boType");
				boMethod = boResult.getString("boMethod");
				boWhom = boResult.getString("boWhom");
				feedback = true;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		if (boType.equals("Money Take")) {
			if (boMethod.equals("bKash")) {
				
				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteBo)){
					pstmtgm.setInt(1, globalID);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String undoBk = "SELECT * FROM bKash WHERE globalID = ?";
				String deleteBk = "DELETE FROM bKash WHERE globalID = ?";
				String bkBalanceBefore = null;
				try (Connection conn = connector();
						PreparedStatement pstmt = conn.prepareStatement(undoBk)) {
					pstmt.setInt(1, ++globalID);
					ResultSet bkResult = pstmt.executeQuery();
					bkBalanceBefore = bkResult.getString("bkBalanceBefore");
				} catch (Exception e) {e.printStackTrace();}
				
				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteBk)){
					pstmtgm.setInt(1, globalID);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				String deleteBoSummary = "DELETE FROM Borrow_Summary WHERE boWhom = ?";
				try (Connection conngm = connector();
						PreparedStatement pstmtgm = conngm.prepareStatement(deleteBoSummary)){
					pstmtgm.setString(1, boWhom);
					pstmtgm.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
				
				setCurrentbKashBalance(removeThousandSeparator(bkBalanceBefore));
				setTotalBorrowTk(removeThousandSeparator(boBalanceBefore));
				GlobalId.setGlobalId(--globalID);
				
			} else if(boMethod.equals("Rocket")) {

			} else if(boMethod.equals("Hand to Hand")) {
				
			}
		} else if(boType.equals("Return Borrowed Money")) {
			if (boMethod.equals("bKash")) {
				
			} else if(boMethod.equals("Rocket")) {

			} else if(boMethod.equals("Hand to Hand")) {
				
			}
		}
		
		return feedback;
	}
	
	
	public static void main(String[] args) {
		Undo access = new Undo();
		System.out.println(access.actionUndo());
//		GlobalId.setGlobalId(11);
		
	}
	
}
