package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.BankIssue;
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
			String sourceList[] = new ComboboxList().getSourceListForDashboard();
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
			totalAmountinLong += new Sector().getAmountBySectorFromExpense(monthName, "Adjusted Balance");
			String sectorList[] = new ComboboxList().getSectorList();
			for (String string : sectorList) {
				totalAmountinLong += new Sector().getAmountBySectorFromExpense(monthName, string);
			}
			totalAmountinLong -= new Sector().addedAdjustBalance(monthName);
		} else {
			totalAmountinLong = new Sector().getAmountBySectorFromExpense(monthName, sectorName);
		}
		return longToString(totalAmountinLong);
	}
	
	
	int carrier = 1;
	public int currentBalanceStatus() {
		int status = 0;
		if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
			if(carrier == 5) {
				status = carrier;
				carrier = 1;
			} else {
				status = carrier;
				this.carrier = carrier+1;
			}			
		} else if(BankIssue.isbKashActivated()) {
			if(carrier == 4) {
				status = carrier;
				carrier = 1;
			} else {
				status = carrier;
				this.carrier = carrier+1;
			}
		} else if(BankIssue.isRocketActivated()) {
			if(carrier == 5) {
				status = carrier;
				carrier = 1;
			} else {
				if (carrier == 4) {
					status = 5;
					carrier = 5;
				} else {
					status = carrier;
					this.carrier = carrier+1;
				}
			}
		} else {
			if(carrier == 3) {
				status = carrier;
				carrier = 1;
			} else {
				status = carrier;
				this.carrier = carrier+1;
			}
		}

		return status;
	}
	
//	public static void main(String[] args) {
//		DashboardModel access = new DashboardModel();
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//		System.out.println(access.currentBalanceStatus());
//	}
}
















































