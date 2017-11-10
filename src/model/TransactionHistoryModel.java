package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.ComboboxList;
import system.DateAndClock;

public class TransactionHistoryModel extends DateAndClock {
	
	public ObservableList<String> loadAllMonths() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getAllMonth());
		return list;
	}
	
	
	public ObservableList<String> loadAllFilter() {
		ObservableList<String> list = FXCollections.observableArrayList((new ComboboxList()).getFilterList());
		return list;
	}
	
	
}
