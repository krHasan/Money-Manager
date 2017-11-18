package model;

import system.DateAndClock;
import system.UnitConverter;

public class CashCalculateModel extends DateAndClock {
	
	public String getWalletBalance() {
		return UnitConverter.longToString(currentWalletBalance());
	}
	
	
	public boolean validAmount(String amount) {
		if (amount.matches("[0-9]{1,4}")) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
