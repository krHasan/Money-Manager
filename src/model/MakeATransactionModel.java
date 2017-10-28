package model;

import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		if ((new UnitConverter()).stringToDouble(amount)<=0) {
			return true;
		} else {
			return false;
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
		UnitConverter convert = new UnitConverter();
		return convert.doubleToString(convert.intToDouble(currentWalletBalance()));		
	}
	
	
	public double updatedbKashBalance(String oldBalance) {
		double newBalance = 0;
		
		UnitConverter convert = new UnitConverter();
		int updateBalance = currentbKashBalance() + convert.doubleToInt(convert.stringToDouble(oldBalance));
		
		return newBalance = convert.intToDouble(updateBalance);
	}
	
	
	public double updatedRocketBalance(String oldBalance) {
		double newBalance = 0;
		
		UnitConverter convert = new UnitConverter();
		int updateBalance = currentRocketBalance() + convert.doubleToInt(convert.stringToDouble(oldBalance));

		return newBalance = convert.intToDouble(updateBalance);
	}
	
	
	public ObservableList<String> getMethod() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getMethodList());
		return list;
	}
	
	
	@SuppressWarnings("static-access")
	public int globalIdToSave() {
		return (new GlobalId()).getGlobalid();
	}
	
	
	public String timeToSave() {
		return timeNow();
	}
	
	
	public String monthToSave() {
		return getMonth();
	}
	
	
	public double bkashBnkCharge(String amount) {
		UnitConverter convert = new UnitConverter();
		return convert.doubleToInt(convert.stringToDouble(amount));
	}
	
//////////////////////////////////////////// Get Money Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	
	public ObservableList<String> getSource() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getSourceList());
		return list;
	}

	
	public int gmAmountToSave(String amount) {
		UnitConverter convert = new UnitConverter();
		return convert.doubleToInt(convert.stringToDouble(amount));
	}
	
	
	
	
////////////////////////////////////////////   Expense Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
////////////////////////////////////////////      Lend Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
////////////////////////////////////////////      Bank Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//

	
//	public static void main(String[] args) {
//		MakeATransactionModel access = new MakeATransactionModel();
//		while(false) {
//			Scanner scan = new Scanner(System.in);
//			System.out.print("Amount: ");
//			String amount = scan.nextLine();
//			System.out.println(access.validAmount(amount));
//		}
//		System.out.println(access.amountIsZero("0000000.01"));
//		System.out.println(access.updatedRocketBalance("30.89"));
//	}
	
}
