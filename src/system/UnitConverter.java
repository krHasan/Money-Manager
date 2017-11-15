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
	
	
	public static String getAbbreviateName(String name) {
		String abbreviateName = null;
		
		if (countWords(name) == 1) {
			abbreviateName = name.substring(0, Math.min(name.length(), 3));
		} else {
			if (getUppercaseLetters(name).equals("none")) {
				abbreviateName = name.substring(0, Math.min(name.length(), 3));
			} else {
				abbreviateName = getUppercaseLetters(name);
			} 
		}
		return abbreviateName;
	}
	
	private static String getUppercaseLetters(String name) {
		char uppercaseLetters[] = new char[3];
		int index = 0;
		for (int ch = 0; ch < name.length() && index <= 2; ch++) {
		    // Check for uppercase letters.
		    if (Character.isUpperCase(name.charAt(ch))) {
		    	uppercaseLetters[index] = name.charAt(ch);
		    	index++;
		    }
		}
		if (index == 0) {
			return "none";
		} else {
			return String.valueOf(uppercaseLetters);
		}
	}
		
	public static int countWords(String s){
	    int wordCount = 0;

	    boolean word = false;
	    int endOfLine = s.length() - 1;

	    for (int i = 0; i < s.length(); i++) {
	        // if the char is a letter, word = true.
	        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
	            word = true;
	            // if char isn't a letter and there have been letters before,
	            // counter goes up.
	        } else if (!Character.isLetter(s.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	            // last word of String; if it doesn't end with a non letter, it
	            // wouldn't count without this.
	        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
	    return wordCount;
	}
	
	
//	public static void main(String[] args) {
//		UnitConverter access = new UnitConverter();
//		System.out.println(longToDouble(1909));
//		System.out.println(doubleTolong(12.89));
//		System.out.println(addThousandSeparator("9999999"));
//		System.out.println(removeThousandSeparator(addThousandSeparator("9999999")));
//		System.out.println(addTSwithTKSign("9999999.99"));
//		System.out.println(addTSwithTKSign(addThousandSeparator("9999999")));
//		System.out.println(addTSwithDollerSign("9999999.99"));
//		System.out.println(addTSwithDollerSign(addThousandSeparator("9999999")));
//		System.out.println(countWords("something"));
//		System.out.println(access.getUppercaseLetters("khandoker rakib hasan bappi"));
//	}
	
}
