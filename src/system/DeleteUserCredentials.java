package system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DatabaseConnection;

public class DeleteUserCredentials extends DatabaseConnection {
	
	String deleteCredentials = "DELETE FROM Credentials";
	String deleteSource_List = "DELETE FROM Source_List";
	String deleteSector_List = "DELETE FROM Sector_List";
	String deleteArchived_Source_List = "DELETE FROM Archived_Source_List";
	String deleteArchived_Sector_List = "DELETE FROM Archived_Sector_List";
	String deleteAll_Months = "DELETE FROM All_Months";
	String deleteGet_Money = "DELETE FROM Get_Money";
	String deleteExpense = "DELETE FROM Expense";
	String deleteBorrow = "DELETE FROM Borrow";
	String deleteLend = "DELETE FROM Lend";
	String deletebKash = "DELETE FROM bKash";
	String deleteRocket = "DELETE FROM Rocket";
	String deletePersonal = "DELETE FROM Personal";
	String deleteBorrow_Summary = "DELETE FROM Borrow_Summary";
	String deleteLend_Summary = "DELETE FROM Lend_Summary";
	String deleteMethods_List = "DELETE FROM Methods_List";
	
	String initializeCurrent_Status = "UPDATE Current_Status \n" + 
			"SET bkashBalance = ?, rocketBalance = ?, personalBalance = ?, walletBalance = ?, \n" +
			"totalBorrowTk = ?, totalLendTk = ?, lastAccessDate = ? \n" +
			"WHERE ID = 1";
	String initializebKash_Settings = "UPDATE bKash_Settings \n" +
			"SET bkCashInCharge = ?, bkCashOutAgentCharge = ?, bkSendMoneyCharge = ?, bkATMCharge = ? \n" +
			"WHERE ID = 1";
	String initializeRocket_Settings = "UPDATE Rocket_Settings \n" +
			"SET atmFree = ?, cashInFree = ?, rocATMCashInAgentCharge = ?, rocATMCashInBranchCharge = ?, \n" +
			"rocATMCashOutATMCharge = ?, rocATMSendMoneyCharge = ?, rocATMCashOutAgentCharge = ?, rocATMCashOutBranchCharge = ?, \n" +
			"rocCashCashInAgentCharge = ?, rocCashCashInBranchCharge = ?, rocCashCashOutATMCharge = ?, rocCashSendMoneyCharge = ?, \n" +
			"rocCashCashOutAgentCharge = ?, rocCashCashOutBranchCharge = ? \n" +
			"WHERE ID = 1";
	String initializeSystem_Settings = "UPDATE System_Settings \n" +
			"SET timeFormat = ?, dateFormat = ?, weekNumber = ?, globalId = ?, undoId = ? \n" +
			"WHERE ID = 1";
	String initializeCurrent_Access = "UPDATE Current_Access \n" +
			"SET tabName = ?, reRegistrationLodingStatus = ? \n" +
			"WHERE ID = 1";
	
	String initializeMethods_List = "INSERT INTO Methods_List (activeMethods) \n" + 
									"VALUES(?)";
	
	String initializeSource_List1 = "INSERT INTO Source_List (sourceList) \n" + 
									"VALUES(?)";
	String initializeSource_List2 = "INSERT INTO Source_List (sourceList) \n" + 
									"VALUES(?)";
	
	String initializeSector_List1 = "INSERT INTO Sector_List (sectorList) \n" + 
								 	"VALUES(?)";
	String initializeSector_List2 = "INSERT INTO Sector_List (sectorList) \n" + 
		 							"VALUES(?)";
	String initializeSector_List3 = "INSERT INTO Sector_List (sectorList) \n" + 
									"VALUES(?)";
	String initializeSector_List4 = "INSERT INTO Sector_List (sectorList) \n" + 
									"VALUES(?)";
	
	
	public void initializeApplication() {
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteAll_Months);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteSource_List);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteSector_List);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteArchived_Source_List);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteArchived_Sector_List);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteCredentials);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteGet_Money);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteExpense);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteBorrow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteLend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deletebKash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteRocket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deletePersonal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteBorrow_Summary);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteLend_Summary);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(deleteMethods_List);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeCurrent_Status)) {	
			pstmt.setLong(1, 0);
			pstmt.setLong(2, 0);
			pstmt.setLong(3, 0);
			pstmt.setLong(4, 0);
			pstmt.setLong(5, 0);
			pstmt.setLong(6, 0);
			pstmt.setString(7, "09 August, 2017");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializebKash_Settings)) {		
			pstmt.setLong(1, 0);
			pstmt.setLong(2, 1850);
			pstmt.setLong(3, 500);
			pstmt.setLong(4, 2000);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeRocket_Settings)) {		
			pstmt.setString(1, "true");
			pstmt.setString(2, "false");
			pstmt.setLong(3, 900);
			pstmt.setLong(4, 1000);
			pstmt.setLong(5, 0);
			pstmt.setLong(6, 500);
			pstmt.setLong(7, 900);
			pstmt.setLong(8, 1000);
			pstmt.setLong(9, 0);
			pstmt.setLong(10, 0);
			pstmt.setLong(11, 900);
			pstmt.setLong(12, 500);
			pstmt.setLong(13, 1800);
			pstmt.setLong(14, 900);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSystem_Settings)) {		
			pstmt.setString(1, "HH:mm:ss");
			pstmt.setString(2, "dd MMMM, yyyy");
			pstmt.setString(3, "false");
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeCurrent_Access)) {		
			pstmt.setString(1, "tabBank");
			pstmt.setString(2, "forgotPassword");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeMethods_List)) {		
			pstmt.setString(1, "Hand to Hand");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSource_List1)) {		
			pstmt.setString(1, "Salary");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSource_List2)) {		
			pstmt.setString(1, "Business");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSector_List1)) {		
			pstmt.setString(1, "Transport");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSector_List2)) {		
			pstmt.setString(1, "Snacks");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSector_List3)) {		
			pstmt.setString(1, "Mobile Load");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(initializeSector_List4)) {		
			pstmt.setString(1, "Accessories");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args) {
//		DeleteUserCredentials access = new DeleteUserCredentials();
//		access.initializeApplication();
//	}
	
}



