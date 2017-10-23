package gui;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class DashboardController {
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
	private ComboBox cmboGetMoneyMonthList;
	@FXML
	private ComboBox cmboExpenseMonthList;
	@FXML
	private ComboBox cmboSourceList;
	@FXML
	private ComboBox cmboSectorList;
	
	@FXML
	private BarChart chartGetMoney;
	@FXML
	private BarChart chartExpense;
		
}
