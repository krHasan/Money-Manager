package model;

import system.DateAndClock;
import system.UnitConverter;

public class MakeATransactionModel extends DateAndClock {
	
	public String getWalletBalance() {
		UnitConverter convert = new UnitConverter();
		return convert.doubleToString(convert.intToDouble(currentWalletBalance()));		
	}
	
}
