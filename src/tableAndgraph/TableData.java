package tableAndgraph;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TableData extends DatabaseConnection {
	
	public ObservableList<Object> borrowTableData() {
		final ObservableList<Object> boData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM Borrow_Summary";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
				while (result.next()) {
					boData.add(new BorrowTableDataModel(result.getString("boDate"), result.getString("boWhom"), result.getString("boExactTk")));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boData;
	}
	
	
	public ObservableList<Object> lendTableData() {
		final ObservableList<Object> leData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM Lend_Summary";
		
		try (Connection conn = connector();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql)) {
			
				while (result.next()) {
					leData.add(new LendTableDataModel(result.getString("leDate"), result.getString("leWhom"), result.getString("leExactTk")));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leData;
	}

}









