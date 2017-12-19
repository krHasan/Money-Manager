package controller;

import java.net.URL;
import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.TransactionHistoryModel;
import netscape.javascript.JSObject;
import operation.GoToOperation;
import system.DateFormatManager;
import system.Undo;
import tab.TabAccess;
import web.HistorySearch;
import web.HistorySearchByDate;

public class TransactionHistoryController extends TransactionHistoryModel {
	
	@FXML
	private MenuItem mnuDashboard;
	@FXML
	private MenuItem mnuGetMoney;
	@FXML
	private MenuItem mnuExpense;
	@FXML
	private MenuItem mnuLend;
	@FXML
	private MenuItem mnuBank;
	@FXML
	private MenuItem mnuSettings;
	@FXML
	private MenuItem mnuTransactionHistory;
	@FXML
	private MenuItem mnuCashCalculate;
	@FXML
	private MenuItem mnuExit;
	@FXML
	private MenuItem mnuCreateSource;
	@FXML
	private MenuItem mnuCreateSector;
	@FXML
	private MenuItem mnuUndo;
	@FXML
	private MenuItem mnuBankSettings;
	@FXML
	private MenuItem mnuSourceSettings;
	@FXML
	private MenuItem mnuSectorSettings;
	@FXML
	private MenuItem mnuSystemSettings;
	@FXML
	private MenuItem mnuHowTo;
	@FXML
	private MenuItem mnuAbout;
	
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
	@FXML
	private WebEngine webEngine;
	
	
////////////////////// General Function /////////////////////////
	DateFormatManager formatManager = new DateFormatManager();
	
	String dateString = formatManager.toString(LocalDate.now());
	LocalDate date = formatManager.fromString(dateString);
	
	HistorySearch debug;
	HistorySearchByDate historyByDate;
	
	@FXML
	public void initialize() {
		lblUserFullName.setText(userFullName()+" ");
		showAllMonths();
		showAllFilter();
		datePicker.setConverter(formatManager);
		datePicker.setValue(date);
		webEngine = webview.getEngine();
		showHisoty();
		
		btnSignOut.setTooltip(new Tooltip("Sign Out from application"));
		btnGo.setTooltip(new Tooltip("Seach history by the selected date"));
		Tooltip.install(lblUserFullName, new Tooltip("User's Full Name"));
		Tooltip.install(cmboHistoryMonth, new Tooltip("Your all transactional month name"));
		Tooltip.install(cmboFilterList, new Tooltip("Select a filter to get specilazid search"));
		Tooltip.install(datePicker, new Tooltip("Select a date to get history on that day"));
		Tooltip.install(webview, new Tooltip("Your History"));
	}


/////////////////// Menu Function ///////////////////////////
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToDashboard(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuUndo(ActionEvent event) {
		String feedback = new Undo().actionUndo();
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Action Successful");
		alert.setHeaderText(null);
		alert.setContentText(feedback);
		alert.setX(TransactionHistoryStage.getX() + 190);
		alert.setY(TransactionHistoryStage.getY() + 190);
		initialize();
		alert.showAndWait();
	}
	
	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuHowTo(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToHelp(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
		TransactionHistoryStage.close();
	}
	
	@FXML
	private void mnuAbout(ActionEvent event) {
		Stage TransactionHistoryStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToAbout(TransactionHistoryStage.getX(), TransactionHistoryStage.getY());
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
//		initializeHisoty();
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
        URL url = getClass().getResource("/html/index.html");
        webEngine.load(url.toString());
	}
	
	
	@FXML
	private void btnGo(ActionEvent event) {
		historyByDate = new HistorySearchByDate(datePicker.getValue());
		
		webEngine.getLoadWorker().stateProperty().addListener(
        	    new ChangeListener<Worker.State>() {
        	        @Override
        	        public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        	            if (newValue == Worker.State.SUCCEEDED) {
        	                JSObject windowObject = (JSObject) webEngine.executeScript("window");
        	                windowObject.setMember("HistorySearchByDate", historyByDate); // insert object
        	                windowObject.call("searchHistoryByDate"); // execute callback
        	            }
        	        }
        	    }
        	);
		URL url = getClass().getResource("/html/index.html");
        webEngine.load(url.toString());
		
//        String url = getClass().getResource("../html/index.html").toExternalForm();
//        webEngine.load(url);
	}

	
}

















