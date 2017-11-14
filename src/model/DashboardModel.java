package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.ComboboxList;
import system.DateAndClock;
import system.UnitConverter;
import tab.Sector;
import tab.Source;

public class DashboardModel extends DateAndClock {
	
	public String getWalletBalance() {
		return UnitConverter.longToString(currentWalletBalance());
	}
	
	
	public String getTotalBorrowTk() {
		return UnitConverter.longToString(totalBorrowTk());
	}
	
	
	public String getTotalLendTk() {
		return UnitConverter.longToString(totalLendTk());
	}
	
	
	public String getbkAccountBalance() {
		return UnitConverter.longToString(currentbKashBalance());
	}
	
	
	public String getRocAccountBalance() {
		return UnitConverter.longToString(currentRocketBalance());
	}
	
	
	public String getPerAccountBalance() {
		return UnitConverter.longToString(currentPersonalBalance());
	}
	
	
	public ObservableList<String> loadAllGetMoneyMonths() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAllGetMoneyMonth());
		return list;
	}
	
	
	public ObservableList<String> loadAllExpenseMonths() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAllExpenseMonth());
		return list;
	}
	
	
	public ObservableList<String> loadSector() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSectorListForDashboard());
		return list;
	}
	
	
	public ObservableList<String> loadSource() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSourceListForDashboard());
		return list;
	}
	
	
	public String getAmountBySource(String monthName, String sourceName) {
		long totalAmountinLong = 0;
		if (sourceName.equals("All")) {
			String sourceList[] = new ComboboxList().getSourceList();
			for (String string : sourceList) {
				totalAmountinLong += new Source().getAmountBySourceFromGM(monthName, string);
			}
		} else {
			totalAmountinLong = new Source().getAmountBySourceFromGM(monthName, sourceName);
		}
		return longToString(totalAmountinLong);
	}
	
	
	public String getAmountBySector(String monthName, String sectorName) {
		long totalAmountinLong = 0;
		if (sectorName.equals("All")) {
			String sectorList[] = new ComboboxList().getSectorList();
			for (String string : sectorList) {
				totalAmountinLong += new Sector().getAmountBySectorFromExpense(monthName, string);
			}
		} else {
			totalAmountinLong = new Sector().getAmountBySectorFromExpense(monthName, sectorName);
		}
		return longToString(totalAmountinLong);
	}
	
	
}














































