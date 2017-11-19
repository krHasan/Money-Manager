package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import operation.ComboboxList;
import system.DateAndClock;

public class RegistrationIssueModel extends DateAndClock {
	
	public ObservableList<String> getSecurityQuestion() {
		ObservableList<String> list = FXCollections.observableArrayList(new ComboboxList().getSecurityQuestionList());
		return list;
	}
}
