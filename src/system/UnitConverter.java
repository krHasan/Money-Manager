package system;

public class UnitConverter {
	
	public double intToDouble(int balance) {
		return balance/100.00;
	}
	
	
	public int doubleToInt(double balance) {
		return (int) (balance*100);
	}
	
	
	public String doubleToString(double balance) {
		return Double.toString(balance);
	}
	
	
	public String intToString(int balance) {
		return Integer.toString(balance);
	}
	
//	public static void main(String[] args) {
//		UnitConverter access = new UnitConverter();
//		System.out.println(access.intToDouble(1909));
//		System.out.println(access.doubleToInt(12.89));
//	}
	
}
