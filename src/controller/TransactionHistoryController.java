package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.TransactionHistoryModel;
import netscape.javascript.JSObject;
import operation.GoToOperation;
import system.DateFormatManager;
import tab.TabAccess;
import web.HistorySearch;

public class TransactionHistoryController extends TransactionHistoryModel {
	@FXML
	private MenuItem mnuCreateSource;
	@FXML
	private MenuItem mnuCreateSector;
	@FXML
	private MenuItem mnuExit;
	@FXML
	private MenuItem mnuGetMoney;
	@FXML
	private MenuItem mnuExpense;
	@FXML
	private MenuItem mnuLend;
	@FXML
	private MenuItem mnuBank;
	@FXML
	private MenuItem mnuDashboard;
	@FXML
	private MenuItem mnuCashCalculate;
	@FXML
	private MenuItem mnuBankSettings;
	@FXML
	private MenuItem mnuSourceSettings;
	@FXML
	private MenuItem mnuSectorSettings;
	@FXML
	private MenuItem mnuSystemSettings;
	
	@FXML
	private Button btnSignOut;
	@FXML
	private Button btnGo;

	@FXML
	private Label lblUserFullName;
	
	@FXML
	private DatePicker datePicker;
	
	@FXML
	private ComboBox<String> cmboHistoryMonth;
	@FXML
	private ComboBox<String> cmboFilterList;
	
	@FXML
	private WebView webview;
	private WebEngine webEngine;
	
	
//////////////////////General Function /////////////////////////
	DateFormatManager formatManager = new DateFormatManager();
	
	String dateString = formatManager.toString(LocalDate.now());
	LocalDate date = formatManager.fromString(dateString);
	
	HistorySearch debug;
	
	@FXML
	public void initialize() {
		lblUserFullName.setText(userFullName());
		showAllMonths();
		showAllFilter();
		datePicker.setConverter(formatManager);
		datePicker.setValue(date);
		webEngine = webview.getEngine();
		showHisoty();
	}


/////////////////// Menu Function ///////////////////////////
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuExit(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToDashboard(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage TransactionHistoryStage = (Stage) btnGo.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	
///////////////////// Button Function ///////////////////////////

	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

////////////////////////// Function //////////////////////////////
	@FXML
	private void cmboHistoryMonth(ActionEvent event) {
		showHisoty();
	}
	
	
	@FXML
	private void cmboFilterList(ActionEvent event) {
		showHisoty();
	}
	
	
	private void showAllMonths() {
		cmboHistoryMonth.setItems(loadAllMonths());
		cmboHistoryMonth.getSelectionModel().selectFirst();
	}
	
	
	private void showAllFilter() {
		cmboFilterList.setItems(loadAllFilter());
		cmboFilterList.getSelectionModel().selectFirst();
	}
	
	
	private void showHisoty() {
		debug = new HistorySearch(cmboHistoryMonth.getValue(), cmboFilterList.getValue());
		
		webEngine.getLoadWorker().stateProperty().addListener(
        	    new ChangeListener<Worker.State>() {
        	        @Override
        	        public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        	            if (newValue == Worker.State.SUCCEEDED) {
        	                JSObject windowObject = (JSObject) webEngine.executeScript("window");
        	                windowObject.setMember("HistorySearch", debug); // insert object
        	                windowObject.call("ready"); // execute callback
        	            }
        	        }
        	    }
        	);
        String url = getClass().getResource("../html/index.html").toExternalForm();
        webEngine.load(url);
	}
}

















