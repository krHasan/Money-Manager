package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import system.DatabaseConnection;

public class SettingsController extends DatabaseConnection {
///////////////////////////////////////// Settings //////////////////////////////
	@FXML
	private MenuItem mnuCreateSource;
	@FXML
	private MenuItem mnuCreateSector;
	@FXML
	private MenuItem mnuExit;
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
	private Button btnDashboard;
	@FXML
	private Button btnMakeATransaction;
	@FXML
	private Button btnTransactionHistory;
	
	@FXML
	private Label lblUserFullName;
	@FXML
	private Label lblLongClock;
	
//////////////////// Bank ////////////////////////
	@FXML
	private Button bnkbtnSave;
	
	@FXML
	private TextField bnktxtbkCashinAgent;
	@FXML
	private TextField bnktxtbkCashOutAgent;
	@FXML
	private TextField bnktxtbkSendMoney;
	@FXML
	private TextField bnktxtbkCashOutATM;
	@FXML
	private TextField bnktxtrocCashinAgent;
	@FXML
	private TextField bnktxtrocCashinBranch;
	@FXML
	private TextField bnktxtrocCashOutATM;
	@FXML
	private TextField bnktxtrocSendMoney;
	@FXML
	private TextField bnktxtrocCashOutAgent;
	@FXML
	private TextField bnktxtrocCashOutBranch;
	
	@FXML
	private RadioButton bnkrbtnbkYes;
	@FXML
	private RadioButton bnkrbtnbkNo;
	@FXML
	private RadioButton bnkrbtnrocYes;
	@FXML
	private RadioButton bnkrbtnrocNo;
	@FXML
	private RadioButton bnkrbtnrocATMFree;
	@FXML
	private RadioButton bnkrbtnrocCashinFree;
	
	@FXML
	private Label bnklblrocCashOutatBranch;
	
//////////////////// Source ////////////////////////
	@FXML
	private Button sourcebtnCreate;
	@FXML
	private Button sourcebtnArchive;
	@FXML
	private Button sourcebtnUnarchive;
	
	@FXML
	private TextField sourcetxtSourceName;
	
	@FXML
	private ComboBox sourcecmboArchive;
	@FXML
	private ComboBox sourcecmboUnArchive;
	
//////////////////// Sector ////////////////////////
	@FXML
	private Button sectorbtnCreate;
	@FXML
	private Button sectorbtnArchive;
	@FXML
	private Button sectorbtnUnarchive;
	
	@FXML
	private TextField sectortxtSourceName;
	
	@FXML
	private ComboBox sectorcmboArchive;
	@FXML
	private ComboBox sectorcmboUnArchive;
	
//////////////////// System ////////////////////////	
	@FXML
	private Button systembtnChangeName;
	@FXML
	private Button systembtnChangePassword;
	
	@FXML
	private TextField systemtxtUsername;
	@FXML
	private TextField systemtxtName;
	
	@FXML
	private PasswordField systemtxtPassword;
	@FXML
	private PasswordField systemtxtRePassword;
	
	@FXML
	private Label systemlblRePassword;
}
