package web;

import controller.TransactionHistoryController;
import database.DatabaseConnection;

public class HistorySearch extends DatabaseConnection {
	TransactionHistoryController classObj = new TransactionHistoryController();
	
	public void getAllHistory() {
		String monthName = classObj.selectedMonthName();
		String filterName = classObj.selectedFilterName();
		
	}
	
}
