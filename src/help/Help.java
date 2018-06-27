package help;

import java.io.InputStream;

public class Help {
	
	public String loadHelpInfo() {
		try {
			InputStream reader1 = Help.class.getResourceAsStream("HowToUse.txt");
			InputStream reader2 = Help.class.getResourceAsStream("HowToUse.txt");
			@SuppressWarnings("unused")
			int charactar,length,a=0,arrayLength=0;
			while((length = reader1.read()) != -1) {
				arrayLength++;
			}
			char ch[] = new char[arrayLength];
			while((charactar = reader2.read()) != -1) {
				ch[a] = (char) charactar;
				a++;
			}
			String stringValueOfCharArray = String.valueOf(ch);
			return stringValueOfCharArray;
		} catch (Exception e1) {
			e1.printStackTrace();
			return "No Helping Informaion Found.";
		}
	}
}
