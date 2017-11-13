package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.DashboardModel;
import operation.GoToOperation;
import tab.TabAccess;

public class DashboardController extends DashboardModel {
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
	private MenuItem mnuTransactionHistory;
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
	private Button btnMakeATransaction;
	@FXML
	private Button btnCashCalculate;
	@FXML
	private Button btnAdjustBalance;
	@FXML
	private Button btnTransactionHistory;
	@FXML
	private Button btnSettings;
	
	@FXML
	private Label lblLongClock;
	@FXML
	private Label lblWalletBalance;
	@FXML
	private Label lblUserFullName;
	@FXML
	private Label lblTotalGetMoney;
	@FXML
	private Label lblTotalExpense;
	@FXML
	private Label lblbKashBalance;
	@FXML
	private Label lblRocketBalance;
	@FXML
	private Label lblPersonalBalance;
	@FXML
	private Label lblTotalBorrow;
	@FXML
	private Label lblTotalLend;
	@FXML
	private Label lblbKashName;
	@FXML
	private Label lblRocketName;
	
	@FXML
	private ComboBox<String> cmboGetMoneyMonthList;
	@FXML
	private ComboBox<String> cmboExpenseMonthList;
	@FXML
	private ComboBox<String> cmboSourceList;
	@FXML
	private ComboBox<String> cmboSectorList;
	
	@FXML
	private BarChart<?, ?> chartGetMoney;
	@FXML
	private BarChart<?, ?> chartExpense;
		
////////////////////////////////// General Function //////////////////////////////
	@FXML
	public void initialize() {
		lblUserFullName.setText(userFullName());
	}
	
	
/////////////////// Menu Function ///////////////////////////
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuExit(ActionEvent event) {
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		DashboardStage.close();
	}

	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}

	
///////////////////// Button Function ///////////////////////////
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage DashboardStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	@FXML
	private void goToMakeAtransaction(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage DashboardStage = (Stage) btnMakeATransaction.getScene().getWindow();
		goToMakeATransaction(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.hide();
	}
	
	@FXML
	private void btnCashCalculate(ActionEvent event) {
		Stage DashboardStage = (Stage) btnCashCalculate.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	@FXML
	private void btnTransactionHistory(ActionEvent event) {
		Stage DashboardStage = (Stage) btnTransactionHistory.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	@FXML
	private void btnSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage DashboardStage = (Stage) btnSettings.getScene().getWindow();
		(new GoToOperation()).goToSettings(DashboardStage.getX(), DashboardStage.getY());
		DashboardStage.close();
	}
	
	
}







