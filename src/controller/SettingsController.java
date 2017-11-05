package controller;

import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.SettingsModel;
import operation.GoToOperation;
import tab.TabAccess;

public class SettingsController extends SettingsModel {
///////////////////////////////////////// Settings //////////////////////////////
	@FXML
	private TabPane tabPane;
	
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
	private Tab tabBank;
	
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
	private Tab tabSource;
	
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
	private Tab tabSector;
	
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
	private Tab tabSystem;
	
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
	
////////////////////// General Function /////////////////////////
	@FXML
	public void initialize() {
		tabTimer();
		lblUserFullName.setText(getUserFullName());
	}
	
	
	public void tabTimer() {
		new Timer().schedule(
			new TimerTask() {
				@Override
				public void run() {
					showTab();
				}
			}, 100);
	}
	
	public void showTab() {
		String tabName = (new TabAccess()).getTabName();
		if (tabName.equals("tabSource")) {
			tabPane.getSelectionModel().select(tabSource);
		} else if (tabName.equals("tabSector")){
			tabPane.getSelectionModel().select(tabSector);
		} else if (tabName.equals("tabSystem")) {
			tabPane.getSelectionModel().select(tabSystem);
		} else {
			tabPane.getSelectionModel().select(tabBank);			
		}
	}
	
	
/////////////////// Menu Function ///////////////////////////
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		SettingsStage.close();
	}
	
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	
///////////////////// Button Function ///////////////////////////
	@FXML
	private void btnDashboard(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void btnMakeATransaction(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void btnTransactionHistory(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.hide();
	}
	
	
//////////////////////////////////////////// Bank Function  ////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------//
	final ToggleGroup bkrbtnGroup = new ToggleGroup();
	final ToggleGroup rocrbtnGroup = new ToggleGroup();
	
	@FXML
	private void tabBnkInitialize() {
		bkRbtn();
	}
	
	private void bkRbtn() {
		if (isbKashActive()) {
			bnkrbtnbkYes.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkYes.setSelected(true);
			bnkrbtnbkYes.setUserData("bkYes");

			bnkrbtnbkNo.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkNo.setUserData("bkNo");
		} else {
			bnkrbtnbkYes.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkYes.setUserData("bkYes");

			bnkrbtnbkNo.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkNo.setSelected(true);
			bnkrbtnbkNo.setUserData("bkNo");
		}
		
	}
	
	private void bkisActive() {
		
	}
	
	
	
	
}
























