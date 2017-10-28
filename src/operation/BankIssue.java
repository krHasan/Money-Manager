package operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;

public class BankIssue extends DatabaseConnection {
	
	public int bKashChargeCalculate(int amount, String nature) {
		int charge = 0;
		
		switch (nature) {
			case "Cash Out":
				charge = (amount*bKashbnkCharge("Cash Out")/100000);
				break;
				
			case "Buy Airtime":
				charge = 0;
				break;
				
			case "Send Money":
				charge = bKashbnkCharge("Send Money");
				break;
			
			case "Payment":
				charge = 0;
				break;
				
			case "ATM":
				charge = (amount*bKashbnkCharge("ATM")/100000);
				break;
				
			default:
				charge = 0;
				break;
		}
		return charge;
	}
	
	
	private static int bKashbnkCharge(String nature) {
		int charge = 0;
		String sql = "SELECT * \n"
				+ "FROM bKash_Settings \n"
				+ "WHERE ID = 1";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)){
			
			switch (nature) {
			case "Cash Out": 
				charge = result.getInt("bkCashOutAgentCharge");
				break;
				
			case "Buy Airtime":
				charge = 0;
				break;
				
			case "Send Money":
				charge = result.getInt("bkSendMoneyCharge");
				break;
			
			case "Payment":
				charge = 0;
				break;
				
			case "ATM":
				charge = result.getInt("bkATMCharge");
				break;
				
			default:
				charge = 0;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return charge;
	}
	
	
//	public int rocketChargeCalculate(int amount, String method, String nature) {
//		int charge = 0;
//		
//		if (method.equals("Cash In")) {
//			if (true) {
//				
//			} else {
//
//			}
//		} else {
//
//		}
//		switch (nature) {
//			case "Cash Out":
//				charge = (amount*bKashbnkCharge("Cash Out")/100000);
//				break;
//				
//			case "Buy Airtime":
//				charge = 0;
//				break;
//				
//			case "Send Money":
//				charge = bKashbnkCharge("Send Money");
//				break;
//			
//			case "Payment":
//				charge = 0;
//				break;
//				
//			case "ATM":
//				charge = (amount*bKashbnkCharge("ATM")/100000);
//				break;
//				
//			default:
//				charge = 0;
//				break;
//		}
//		return charge;
//	}
	
	
	private static int rocketbnkCharge(String method, String nature) {
		int charge = 0;
		boolean atmFree = true;
		
		String sqlATM = "SELECT atmFree \n"
				+ "FROM Rocket_Settings \n"
				+ "WHERE ID = 1";
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlATM)) {
			atmFree = result.getBoolean("atmFree");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sqlAll = "SELECT * \n"
				+ "FROM Rocket_Settings \n"
				+ "WHERE ID = 1";
		if (method.equals("Cash In")) {
			if (atmFree) {
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sqlAll)){

					switch (nature) {
					case "Agent": 
						charge = result.getInt("rocATMCashInAgentCharge");
						break;
						
					case "Send Money":
						charge = 0;
						break;
						
					case "Branch":
						charge = result.getInt("rocATMCashInBranchCharge");
						break;
					
					default:
						charge = 0;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sqlAll)){

					switch (nature) {
					case "Agent": 
						charge = result.getInt("rocCashCashInAgentCharge");
						break;
						
					case "Send Money":
						charge = 0;
						break;
						
					case "Branch":
						charge = result.getInt("rocCashCashInBranchCharge");
						break;
					
					default:
						charge = 0;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			if (atmFree) {
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sqlAll)){

					switch (nature) {
					case "ATM": 
						charge = result.getInt("rocATMCashOutATMCharge");
						break;
						
					case "TopUp": 
						charge = 0;
						break;
						
					case "Agent": 
						charge = result.getInt("rocATMCashOutAgentCharge");
						break;
						
					case "Send Money":
						charge = result.getInt("rocATMSendMoneyCharge");
						break;
						
					case "Branch":
						charge = result.getInt("rocATMCashOutBranchCharge");
						break;
					
					default:
						charge = 0;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sqlAll)){

					switch (nature) {
					case "ATM": 
						charge = result.getInt("rocCashCashOutATMCharge");
						break;
						
					case "TopUp": 
						charge = 0;
						break;
						
					case "Agent": 
						charge = result.getInt("rocCashCashOutAgentCharge");
						break;
						
					case "Send Money":
						charge = result.getInt("rocCashSendMoneyCharge");
						break;
						
					case "Branch":
						charge = result.getInt("rocCashCashOutBranchCharge");
						break;
					
					default:
						charge = 0;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		return charge;
	}
	
	
//	public static void main(String[] args) {
//		BankIssue access = new BankIssue();
//		System.out.println(access.bKashChargeCalculate(100000, "ATM"));
//	}
	
}









