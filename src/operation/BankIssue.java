package operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;

public class BankIssue extends DatabaseConnection {
	
	public long bKashChargeCalculate(long amount, String nature) {
		long charge = 0;
		
		switch (nature) {
			case "Cash Out":
				charge = (amount*bKashbnkCharge(nature)/100000);
				break;
				
			case "Buy Airtime":
				charge = bKashbnkCharge(nature);
				break;
				
			case "Send Money":
				charge = bKashbnkCharge(nature);
				break;
			
			case "Payment":
				charge = bKashbnkCharge(nature);
				break;
				
			case "ATM":
				charge = (amount*bKashbnkCharge(nature)/100000);
				break;
				
			default:
				charge = 0;
				break;
		}
		return charge;
	}
	
	
	private static long bKashbnkCharge(String nature) {
		long charge = 0;
		String sql = "SELECT * \n"
				+ "FROM bKash_Settings";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)){
			
			switch (nature) {
			case "Cash Out": 
				charge = result.getLong("bkCashOutAgentCharge");
				break;
				
			case "Buy Airtime":
				charge = 0;
				break;
				
			case "Send Money":
				charge = result.getLong("bkSendMoneyCharge");
				break;
			
			case "Payment":
				charge = 0;
				break;
				
			case "ATM":
				charge = result.getLong("bkATMCharge");
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
	
	
	public long rocketChargeCalculate(long amount, String method, String nature) {
		long charge = 0;
		
		if (method.equals("Cash In")) {
			switch (nature) {
			case "Agent":
				charge = (amount*rocketbnkCharge(method, nature)/100000);
				break;
				
			case "Send Money":
				charge = rocketbnkCharge(method, nature);
				break;
				
			case "Branch":
				charge = rocketbnkCharge(method, nature);
				break;
						
			default:
				charge = 0;
				break;
			}
		} else {
			switch (nature) {
			case "ATM":
				charge = (amount*rocketbnkCharge(method, nature)/100000);
				break;
				
			case "TopUp":
				charge = rocketbnkCharge(method, nature);
				break;
				
			case "Agent":
				charge = (amount*rocketbnkCharge(method, nature)/100000);
				break;
			
			case "Send Money":
				charge = rocketbnkCharge(method, nature);
				break;
				
			case "Branch":
				if (isATMFree()) {
					charge = rocketbnkCharge(method, nature);
				} else {
					charge = (amount*rocketbnkCharge(method, nature)/100000);
				}
				break;
				
			default:
				charge = 0;
				break;
			}
		}
		
		return charge;
	}
	
	
	private static long rocketbnkCharge(String method, String nature) {
		long charge = 0;
		
		String sqlAll = "SELECT * \n"
				+ "FROM Rocket_Settings";
		
		if (method.equals("Cash In")) {
			if (isATMFree()) {
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sqlAll)){

					switch (nature) {
					case "Agent": 
						charge = result.getLong("rocATMCashInAgentCharge");
						break;
						
					case "Send Money":
						charge = 0;
						break;
						
					case "Branch":
						charge = result.getLong("rocATMCashInBranchCharge");
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
						charge = result.getLong("rocCashCashInAgentCharge");
						break;
						
					case "Send Money":
						charge = 0;
						break;
						
					case "Branch":
						charge = result.getLong("rocCashCashInBranchCharge");
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
			if (isATMFree()) {
				try (Connection conn = connector();
						Statement stmt = conn.createStatement();
						ResultSet result = stmt.executeQuery(sqlAll)){

					switch (nature) {
					case "ATM": 
						charge = result.getLong("rocATMCashOutATMCharge");
						break;
						
					case "TopUp": 
						charge = 0;
						break;
						
					case "Agent": 
						charge = result.getLong("rocATMCashOutAgentCharge");
						break;
						
					case "Send Money":
						charge = result.getLong("rocATMSendMoneyCharge");
						break;
						
					case "Branch":
						charge = result.getLong("rocATMCashOutBranchCharge");
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
						charge = result.getLong("rocCashCashOutATMCharge");
						break;
						
					case "TopUp": 
						charge = 0;
						break;
						
					case "Agent": 
						charge = result.getLong("rocCashCashOutAgentCharge");
						break;
						
					case "Send Money":
						charge = result.getLong("rocCashSendMoneyCharge");
						break;
						
					case "Branch":
						charge = result.getLong("rocCashCashOutBranchCharge");
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
	
	
	public static boolean isbKashActivated() {
		String sql = "SELECT activeMethods \n"
				+ "FROM Methods_List \n"
				+ "WHERE activeMethods = \"bKash\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean isRocketActivated() {
		String sql = "SELECT activeMethods \n"
				+ "FROM Methods_List \n"
				+ "WHERE activeMethods = \"Rocket\"";

		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
			if (result.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean isATMFree() {
		String atmFree = null;
		boolean atmFreeb = false;
		
		String sqlATM = "SELECT atmFree \n"
				+ "FROM Rocket_Settings";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sqlATM)) {
			
			atmFree = result.getString("atmFree");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (atmFree.equals("true")) {
			atmFreeb = true;
		}
		return atmFreeb;
	}
	
	
	
//	public static void main(String[] args) {
//		BankIssue access = new BankIssue();
//		System.out.println(access.bKashChargeCalculate(100000, "ATM"));
//		System.out.println(access.rocketChargeCalculate(1500000, "Cash Out", "Agent"));
//		System.out.println(access.isATMFree());
//	}
	
}









