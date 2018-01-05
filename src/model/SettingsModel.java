package model;

import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.ComboboxList;
import system.DateAndClock;
import tab.SettingBank;

public class SettingsModel extends DateAndClock {
	
	public boolean validCharge(String charge) {
		if (charge.matches("[0-9]{1,3}(\\.[0-9]{1,2}){0,7}")) {
			return true;
		} else if (charge.matches("[0-9]{1,3}\\.")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getUserFullName() {
		if (checkUserPresence()) {
			return userFullName();
		} else {
			return "No User";
		}
	}
	
	
//	public static boolean isbKashActive() {
//		String sql = "SELECT bKashActive FROM System_Settings WHERE ID = 1";
//		try (Connection conn = connector();
//				Statement stmt = conn.createStatement();
//				ResultSet result = stmt.executeQuery(sql)) {
//			if ((result.getString("bKashActive")).equals("true")) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//	
//	
//	public static boolean isRocketActive() {
//		String sql = "SELECT RocketActive FROM System_Settings WHERE ID = 1";
//		try (Connection conn = connector();
//				Statement stmt = conn.createStatement();
//				ResultSet result = stmt.executeQuery(sql)) {
//			if ((result.getString("RocketActive")).equals("true")) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//	
//	
//	public static boolean rocIsATMFree() {
//		return BankIssue.isATMFree();
//	}
	
	
	public Map<String, String> bkashChargeData() {
		return new SettingBank().getBkashChargeData();
	}
	
	
	public Map<String, String> rocketChargeData() {
		return new SettingBank().getRocketChargeData();
	}
	
	
//////////////////////  Source  ////////////////////////
	public ObservableList<String> getActiveSourceList() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSourceList());
		return list;
	}
	
	
	public ObservableList<String> getArchivedSourceList() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getArchivedSourceList());
		return list;
	}
	
////////////////////// Sector  ////////////////////////
	public ObservableList<String> getActiveSectorList() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSectorList());
		return list;
	}


	public ObservableList<String> getArchivedSectorList() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getArchivedSectorList());
		return list;
	}
	
////////////////////// Advanced Expense  ////////////////////////
	public ObservableList<String> getAdvancedSectorListInactive() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAdvancedSectorListInactive());
		return list;
	}


	public ObservableList<String> getAdvancedSectorListActive() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAdvancedSectorListActive());
		return list;
	}
	
}













