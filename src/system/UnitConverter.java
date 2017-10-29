package system;

import database.DatabaseConnection;

public class UnitConverter extends DatabaseConnection {
	
	public static double longToDouble(long balance) {
		return balance/100.00;
	}
	
	
	public static long doubleTolong(double balance) {
		return (long) (balance*100);
	}
	
	
	public static String doubleToString(double balance) {
		return Double.toString(balance);
	}
	
	
	public static Double stringToDouble(String balance) {
		return Double.parseDouble(balance);
	}
	
	
	public static long stringToLong(String balance) {
		return (long) (Double.parseDouble(balance)*100);
	}

	
	public static String longToString(long balance) {
		return Double.toString(balance/100.00);
	}
	
	
//	public static void main(String[] args) {
//		UnitConverter access = new UnitConverter();
//		System.out.println(access.longToDouble(1909));
//		System.out.println(access.doubleTolong(12.89));
//	}
	
}
