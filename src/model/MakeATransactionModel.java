package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.BankIssue;
import operation.ComboboxList;
import operation.GlobalId;
import system.DateAndClock;
import system.UnitConverter;

public class MakeATransactionModel extends DateAndClock {
	
	private final static int maxTextSize = 100;

	public int letterCount(String text) {
		return maxTextSize - text.length();
	}
	
	
	public boolean amountIsZero(String amount) {
		try {
			if (UnitConverter.stringToDouble(amount)<=0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return true;
		}

	}

	
	public boolean validAmount(String amount) {
		if (amount.matches("[0-9]{1,7}(\\.[0-9]{1,2}){0,7}")) {
			return true;
		} else if (amount.matches("[0-9]{1,7}\\.")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public String getWalletBalance() {
		return UnitConverter.longToString(currentWalletBalance());
	}
	
	
	public String updatedbKashBalance(String amount, String nature) {
		long amountlong = UnitConverter.stringToLong(amount);
		long charge = new BankIssue().bKashChargeCalculate(amountlong, nature);
		long dbBkashBalance = currentbKashBalance();
		String newBalance = UnitConverter.longToString((amountlong-charge)+dbBkashBalance);
		return newBalance;
	}
	
	
	public String updatedRocketBalance(String amount, String method, String nature) {
		long amountlong = UnitConverter.stringToLong(amount);
		long charge = new BankIssue().rocketChargeCalculate(amountlong, method, nature);
		long dbRocketBalance = currentRocketBalance();
		String newBalance = UnitConverter.longToString((amountlong-charge)+dbRocketBalance);
		return newBalance;
	}
	
	
	public String bkashBnkCharge(String amount, String nature) {
		long amountlong = UnitConverter.stringToLong(amount);
		long charge = (new BankIssue()).bKashChargeCalculate(amountlong, nature);
		return UnitConverter.longToString(charge);
	}
	
	
	public String rocketBnkCharge(String amount, String method, String nature) {
		long amountlong = UnitConverter.stringToLong(amount);
		long charge = (new BankIssue()).rocketChargeCalculate(amountlong, method, nature);
		return UnitConverter.longToString(charge);
	}
	
	
	public ObservableList<String> getMethod() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getMethodList());
		return list;
	}
	
	
	public int globalIdToSave() {
		return GlobalId.getGlobalid();
	}
	
	
	public String timeToSave() {
		return timeNow();
	}
	
	
	public String monthToSave() {
		return getMonth();
	}
	
	
		
//////////////////////////////////////////// Get Money Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	
	public ObservableList<String> gmGetSource() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSourceList());
		return list;
	}
	
	
	public String gmWalletBalanceAfter(String amount) {
		long dbBalance = currentWalletBalance();
		long typedBalance = UnitConverter.stringToLong(amount);
		String updateBalance = UnitConverter.longToString(dbBalance + typedBalance);
		return updateBalance;
	}
	
	
////////////////////////////////////////////   Expense Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	
	public ObservableList<String> exGetSector() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSectorList());
		return list;
	}
	
	
	public String exWalletBalanceAfter(String amount) {
		long dbBalance = currentWalletBalance();
		long typedBalance = UnitConverter.stringToLong(amount);
		String updateBalance = UnitConverter.longToString(dbBalance - typedBalance);
		return updateBalance;
	}
	
	
////////////////////////////////////////////      Lend Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	
	public ObservableList<String> boGetBorrowType() {
		ObservableList<String> list = FXCollections.observableArrayList("Money Take","Return Borrowed Money");
		return list;
	}
	
	
	public ObservableList<String> boGetRepayPersonName() {
		ObservableList<String> list = FXCollections.observableArrayList(new ComboboxList().getBoRepayPersonNameList());
		return list;
	}
	
	
	public String getTotalBorrowTk() {
		return UnitConverter.longToString(totalBorrowTk());
	}
	
	
	public String boBkBalanceAfter(String amountWithCharge, String bnkCharge) {
		long amountWithChargeL = UnitConverter.stringToLong(amountWithCharge);
		long bnkChargeL = UnitConverter.stringToLong(bnkCharge);
		long amountWithoutCharge = (amountWithChargeL - bnkChargeL);
		long dbBkBalance = currentbKashBalance();
		return UnitConverter.longToString(dbBkBalance + amountWithoutCharge);
	}
	
	
	public String boRocBalanceAfter(String amountWithCharge, String bnkCharge) {
		long amountWithChargeL = UnitConverter.stringToLong(amountWithCharge);
		long bnkChargeL = UnitConverter.stringToLong(bnkCharge);
		long amountWithoutCharge = (amountWithChargeL - bnkChargeL);
		long dbRocBalance = currentRocketBalance();
		return UnitConverter.longToString(dbRocBalance + amountWithoutCharge);
	}
	
	
	public String updatedTotalBorrowTk(String amountToAdd) {
		long dbBalance = UnitConverter.stringToLong(getTotalBorrowTk());
		long amountL = UnitConverter.stringToLong(amountToAdd);
		return UnitConverter.longToString(dbBalance + amountL);
	}
	
//////////////////////////// lend //////////////////////////////
	
	public ObservableList<String> leGetLendType() {
		ObservableList<String> list = FXCollections.observableArrayList("Give Money","Take Back Lended Money");
		return list;
	}
	
	
	public ObservableList<String> leGetRepayPersonName() {
		ObservableList<String> list = FXCollections.observableArrayList(new ComboboxList().getLeRepayPersonNameList());
		return list;
	}
	
	
	public String getTotalLendTk() {
		return UnitConverter.longToString(totalLendTk());
	}
	
////////////////////////////////////////////      Bank Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//

	
//	public static void main(String[] args) {
//		MakeATransactionModel access = new MakeATransactionModel();
//		System.out.println(access.updatedbKashBalance("5000", "Cash In"));
//	}
	
}





