package system;

import java.text.DecimalFormat;

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
	
	
	public static String addThousandSeparator(String amount) {
		DecimalFormat format = new DecimalFormat("###,###.##");
		try {
			return format.format(stringToDouble(amount));
		} catch (Exception e) {
			return amount;
		}
	}
	
	
	public static String removeThousandSeparator(String amount) {
		return amount.replace(",", "");
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(longToDouble(1909));
//		System.out.println(doubleTolong(12.89));
//		System.out.println(addThousandSeparator("9999999"));
//		System.out.println(removeThousandSeparator(addThousandSeparator("9999999")));
//		System.out.println(addTSwithTKSign("9999999.99"));
//		System.out.println(addTSwithTKSign(addThousandSeparator("9999999")));
//		System.out.println(addTSwithDollerSign("9999999.99"));
//		System.out.println(addTSwithDollerSign(addThousandSeparator("9999999")));
//	}
	
}
