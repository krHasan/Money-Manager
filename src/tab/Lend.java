package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseConnection;

public class Lend extends DatabaseConnection {
	
	public String leRepayPersonLendedAmount(String name) {
		String lendedAmount = "0";
		String sql = "SELECT leExactTk FROM Lend_Summary WHERE leWhom = ? ";
		
		try (Connection conn = connector();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet result = pstmt.executeQuery();
			
			if (result.next()) {
				lendedAmount = result.getString("leExactTk");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lendedAmount;
	}

}
