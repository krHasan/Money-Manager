package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import model.SettingsModel;
import operation.BankIssue;
import operation.ComboboxList;
import operation.GoToOperation;
import system.DateFormatManager;
import tab.AdvancedExpense;
import tab.Sector;
import tab.SettingBank;
import tab.Source;
import tab.TabAccess;

public class SettingsController extends SettingsModel {
///////////////////////////////////////// Settings //////////////////////////////
	@FXML
	private TabPane tabPane;
	
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
	private MenuItem mnuAdvancedSettings;
	@FXML
	private MenuItem mnuHowTo;
	@FXML
	private MenuItem mnuAbout;
	
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
	@FXML
	private Label bnkInvalidChargeMsg;
	
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
	private Button sourcebtnDelete;
	
	@FXML
	private TextField sourcetxtSourceName;
	
	@FXML
	private ComboBox<String> sourcecmboArchive;
	@FXML
	private ComboBox<String> sourcecmboUnArchive;
	@FXML
	private ComboBox<String> sourcecmboDelete;
	
	@FXML
	private Label sourcelblWarningMsg;
	
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
	private Button sectorbtnDelete;
	
	@FXML
	private TextField sectortxtSourceName;
	
	@FXML
	private ComboBox<String> sectorcmboArchive;
	@FXML
	private ComboBox<String> sectorcmboUnArchive;
	@FXML
	private ComboBox<String> sectorcmboDelete;
	
	@FXML
	private Label sectorlblWarningMsg;
	
//////////////////// System ////////////////////////	
	@FXML
	private Tab tabSystem;
	
	@FXML
	private Button systembtnChangeName;
	@FXML
	private Button systembtnChangePassword;
	@FXML
	private Button systembtnSave;
	
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
	@FXML
	private Label systemlblWarningMsg;
	
	@FXML
	private CheckBox checkBoxWeekNum;
	
	@FXML
	private RadioButton TIME_h;
	@FXML
	private RadioButton TIME_hh;
	@FXML
	private RadioButton TIME_H;
	@FXML
	private RadioButton TIME_HH;
	@FXML
	private RadioButton DATEddMMMM;
	@FXML
	private RadioButton DATEddMMM;
	@FXML
	private RadioButton DATEddMM;
	@FXML
	private RadioButton DATEEEddMMM;
	@FXML
	private RadioButton DATEMMM;
	
////////////////////System ////////////////////////
	@FXML
	private Tab tabAdvanced;
	
	@FXML
	private Button advancedBtnAdd;
	@FXML
	private Button advancedBtnRemove;
	
	@FXML
	private ComboBox<String> advancedCmboAdd;
	@FXML
	private ComboBox<String> advancedCmboRemove;
	
	@FXML
	private Label advancedlblSectorName;
	@FXML
	private Label advancedlblSectorName1;
	@FXML
	private Label advancedlblSectorName2;
	@FXML
	private Label advancedlblSectorName3;
	@FXML
	private Label advancedlblSectorName4;
	@FXML
	private Label advancedlblSectorName5;
	@FXML
	private Label advancedlblSectorName6;
	@FXML
	private Label advancedlblSectorName7;
	
////////////////////// General Function /////////////////////////
	@FXML
	public void initialize() {
		showTab();
		lblUserFullName.setText(getUserFullName()+" ");
		
		btnSignOut.setTooltip(new Tooltip("Sign Out from application"));
		Tooltip.install(lblUserFullName, new Tooltip("User's Full Name"));
		btnDashboard.setTooltip(new Tooltip("Take you to Dashboard"));
		btnMakeATransaction.setTooltip(new Tooltip("Take you to Transaction window"));
		btnTransactionHistory.setTooltip(new Tooltip("Take you to History window"));
		
		bnkbtnSave.setTooltip(new Tooltip("Save your changes"));
		Tooltip.install(bnkrbtnbkYes, new Tooltip("Choose if you have a bKash account"));
		Tooltip.install(bnkrbtnbkNo, new Tooltip("Choose if you don't have a bKash account"));
		Tooltip.install(bnktxtbkCashinAgent, new Tooltip("Charge for per 1000 tk Cash in from agent"));
		Tooltip.install(bnktxtbkCashOutAgent, new Tooltip("Charge for per 1000 tk Cash out from agent"));
		Tooltip.install(bnktxtbkSendMoney, new Tooltip("Charge for send money"));
		Tooltip.install(bnktxtbkCashOutATM, new Tooltip("Charge for per 1000 tk Cash out from ATM"));
		Tooltip.install(bnkrbtnrocYes, new Tooltip("Choose if you have a Rocket account"));
		Tooltip.install(bnkrbtnrocNo, new Tooltip("Choose if you don't have a Rocket account"));
		Tooltip.install(bnkrbtnrocATMFree, new Tooltip("Choose if your Rocket account is ATM free"));
		Tooltip.install(bnkrbtnrocCashinFree, new Tooltip("Choose if your Rocket account is Cash In free"));
		Tooltip.install(bnktxtrocCashinAgent, new Tooltip("Charge for per 1000 tk Cash in from Agent"));
		Tooltip.install(bnktxtrocCashinBranch, new Tooltip("Charge for per 1000 tk Cash in from DBBL Bank Branch"));
		Tooltip.install(bnktxtrocCashOutATM, new Tooltip("Charge for per 1000 tk Cash out from ATM"));
		Tooltip.install(bnktxtrocSendMoney, new Tooltip("Charge for send money"));
		Tooltip.install(bnktxtrocCashOutAgent, new Tooltip("Charge for per 1000 tk Cash out from Agent"));
		Tooltip.install(bnktxtrocCashOutBranch, new Tooltip("Charge for Cash out tk from DBBL Bank Branch"));
		
		sourcebtnCreate.setTooltip(new Tooltip("Typed name will be one of your Money Income Source"));
		sourcebtnArchive.setTooltip(new Tooltip("Selected source will be remove from \n"
				+ "your active source list and this will\n"
				+ "be no longer available in transaction"));
		sourcebtnUnarchive.setTooltip(new Tooltip("Selected source will be add to your active\n"
				+ "source list and will be available in transaction"));
		Tooltip.install(sourcetxtSourceName, new Tooltip("Type a source name from where you get Tk."));
		Tooltip.install(sourcecmboArchive, new Tooltip("List of your active sources"));
		Tooltip.install(sourcecmboUnArchive, new Tooltip("List of your archived sources"));
		
		sectorbtnCreate.setTooltip(new Tooltip("Typed name will be one of your money expense sector"));
		sectorbtnArchive.setTooltip(new Tooltip("Selected sector will be remove from \n"
				+ "your active sector list and this will\n"
				+ "be no longer available in transaction"));
		sectorbtnUnarchive.setTooltip(new Tooltip("Selected sector will be add to your active\n"
				+ "sector list and will be available in transaction"));
		Tooltip.install(sectortxtSourceName, new Tooltip("Type a sector name from where you expense Tk."));
		Tooltip.install(sectorcmboArchive, new Tooltip("List of your active sectors"));
		Tooltip.install(sectorcmboUnArchive, new Tooltip("List of your archived sectors"));
		
		systembtnChangeName.setTooltip(new Tooltip("Change your name"));
		systembtnChangePassword.setTooltip(new Tooltip("Change your password"));
		systembtnSave.setTooltip(new Tooltip("Save changes of your date and time format"));
		Tooltip.install(systemtxtUsername, new Tooltip("Your Username"));
		Tooltip.install(systemtxtName, new Tooltip("Your full name"));
		Tooltip.install(systemtxtPassword, new Tooltip("Give a password, this should not contain space"));
		Tooltip.install(systemtxtRePassword, new Tooltip("Retype the password"));
		Tooltip.install(checkBoxWeekNum, new Tooltip("Show week number in calender"));
		
		advancedBtnAdd.setTooltip(new Tooltip("Add selected sector to advanced expense sector list"));
		advancedBtnRemove.setTooltip(new Tooltip("Remove selected sector from advanced expense sector list"));
		Tooltip.install(advancedCmboAdd, new Tooltip("Select sector to add to list"));
		Tooltip.install(advancedCmboRemove, new Tooltip("Select sector to remove from list"));
		Tooltip.install(advancedlblSectorName, new Tooltip("Advanced expense sector list"));
	}

	
	public void showTab() {
		String tabName = (new TabAccess()).getTabName();
		if (tabName.equals("tabSource")) {
			tabPane.getSelectionModel().select(tabSource);
		} else if (tabName.equals("tabSector")){
			tabPane.getSelectionModel().select(tabSector);
		} else if (tabName.equals("tabSystem")) {
			tabPane.getSelectionModel().select(tabSystem);
		} else if (tabName.equals("tabAdvanced")) {
			tabPane.getSelectionModel().select(tabAdvanced);
		} else {
			tabPane.getSelectionModel().select(tabBank);			
		}
	}
	
	
/////////////////// Menu Function ///////////////////////////
	
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToDashboard(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		SettingsStage.close();
	}
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}

	@FXML
	private void mnuUndo(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Action Failed");
		alert.setHeaderText("Undo Function Works Only From \"Make A Transaction\" and \"History\" Window");
		alert.setContentText("Press \"OK\" to go to \"Make A Transaction\" window");
		alert.setX(SettingsStage.getX() + 60);
		alert.setY(SettingsStage.getY() + 170);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			(new TabAccess()).setTabName("tabGetMoney"); //name of which Tab should open
			(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
			SettingsStage.close();
		}
	}
	
	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuAdvancedSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabAdvanced");
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuHowTo(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToHelp(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void mnuAbout(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToAbout(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	
///////////////////// Button Function ///////////////////////////
	@FXML
	private void btnDashboard(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void btnMakeATransaction(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void btnTransactionHistory(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage SettingsStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(SettingsStage.getX(), SettingsStage.getY());
		SettingsStage.close();
	}
	
	
//////////////////////////////////////////// Bank Function  ////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------//
	final ToggleGroup bkrbtnGroup = new ToggleGroup();
	final ToggleGroup rocrbtnGroup = new ToggleGroup();
	final ToggleGroup rocrbtnATMGroup = new ToggleGroup();
	final String InvalidInput = "Invalid Input. Type within 0.00 to 999.99";
	
	@FXML
	private void tabBnkInitialize() {
		bkRbtn();
		rocRbtn();
	}
	
	@FXML
	private void bnktxtbkCashinAgent() {
		if (!validCharge(bnktxtbkCashinAgent.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtbkCashinAgent.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}
	
	@FXML
	private void bnktxtbkCashOutAgent() {
		if (!validCharge(bnktxtbkCashOutAgent.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtbkCashOutAgent.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}
	
	@FXML
	private void bnktxtbkSendMoney() {
		if (!validCharge(bnktxtbkSendMoney.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtbkSendMoney.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtbkCashOutATM() {
		if (!validCharge(bnktxtbkCashOutATM.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtbkCashOutATM.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtrocCashinAgent() {
		if (!validCharge(bnktxtrocCashinAgent.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtrocCashinAgent.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtrocCashinBranch() {
		if (!validCharge(bnktxtrocCashinBranch.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtrocCashinBranch.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtrocCashOutATM() {
		if (!validCharge(bnktxtrocCashOutATM.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtrocCashOutATM.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtrocSendMoney() {
		if (!validCharge(bnktxtrocSendMoney.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtrocSendMoney.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtrocCashOutAgent() {
		if (!validCharge(bnktxtrocCashOutAgent.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtrocCashOutAgent.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}

	@FXML
	private void bnktxtrocCashOutBranch() {
		if (!validCharge(bnktxtrocCashOutBranch.getText())) {
			bnkInvalidChargeMsg.setText(InvalidInput);
			bnktxtrocCashOutBranch.clear();
		} else {
			bnkInvalidChargeMsg.setText(" ");
		}
	}
	


//////////// bKash ///////////////
	@FXML
	private void bnkrbtnbkYes(ActionEvent event) {
		bkisActive();
	}
	
	@FXML
	private void bnkrbtnbkNo(ActionEvent event) {
		bkisInactive();
	}
	
	private void bkRbtn() {
		if (BankIssue.isbKashActivated()) {
			bkisActive();
			bnkrbtnbkYes.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkYes.setSelected(true);
			bnkrbtnbkYes.setUserData("bkYes");

			bnkrbtnbkNo.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkNo.setUserData("bkNo");
		} else {
			bkisInactive();
			bnkrbtnbkYes.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkYes.setUserData("bkYes");

			bnkrbtnbkNo.setToggleGroup(bkrbtnGroup);
			bnkrbtnbkNo.setSelected(true);
			bnkrbtnbkNo.setUserData("bkNo");
		}
		
	}
	
	private void bkisActive() {
		Map<String, String> bkData = bkashChargeData();
		
		bnktxtbkCashinAgent.setDisable(false);
		bnktxtbkCashinAgent.setText(bkData.get("bkCashInCharge"));
		
		bnktxtbkCashOutAgent.setDisable(false);
		bnktxtbkCashOutAgent.setText(bkData.get("bkCashOutAgentCharge"));
		
		bnktxtbkSendMoney.setDisable(false);
		bnktxtbkSendMoney.setText(bkData.get("bkSendMoneyCharge"));
		
		bnktxtbkCashOutATM.setDisable(false);
		bnktxtbkCashOutATM.setText(bkData.get("bkATMCharge"));
		
	}
	
	private void bkisInactive() {
		bnktxtbkCashinAgent.setDisable(true);
		bnktxtbkCashinAgent.setText("0");
		
		bnktxtbkCashOutAgent.setDisable(true);
		bnktxtbkCashOutAgent.setText("0");
		
		bnktxtbkSendMoney.setDisable(true);
		bnktxtbkSendMoney.setText("0");
		
		bnktxtbkCashOutATM.setDisable(true);
		bnktxtbkCashOutATM.setText("0");
		
	}
	
//////////// Rocket ///////////////
	@FXML
	private void bnkrbtnrocYes(ActionEvent event) {
		bnkrbtnrocATMFree.setDisable(false);
		bnkrbtnrocCashinFree.setDisable(false);
		if (BankIssue.isATMFree()) {
			rocATMisActive();
		} else {
			rocCashInisActive();
		}
	}
	
	@FXML
	private void bnkrbtnrocNo(ActionEvent event) {
		rocisInactive();
	}
	
	@FXML
	private void bnkrbtnrocATMFree(ActionEvent event) {
		rocATMisActive();
	}
	
	@FXML
	private void bnkrbtnrocCashinFree(ActionEvent event) {
		rocCashInisActive();
	}
	
	private void rocRbtn() {
		if (BankIssue.isRocketActivated()) {
			bnkrbtnrocYes.setToggleGroup(rocrbtnGroup);
			bnkrbtnrocYes.setSelected(true);
			bnkrbtnrocYes.setUserData("rocYes");

			bnkrbtnrocNo.setToggleGroup(rocrbtnGroup);
			bnkrbtnrocNo.setUserData("rocNo");
			
			if (BankIssue.isATMFree()) {			
				rocATMisActive();
			} else {
				rocCashInisActive();
			}
			
		} else {
			bnkrbtnrocYes.setToggleGroup(rocrbtnGroup);
			bnkrbtnrocYes.setUserData("rocYes");

			bnkrbtnrocNo.setToggleGroup(rocrbtnGroup);
			bnkrbtnrocNo.setSelected(true);
			bnkrbtnrocNo.setUserData("rocNo");
			
			rocisInactive();
		}
		
	}
	
	private void rocATMisActive() {
		Map<String, String> rockData = rocketChargeData();
		
		bnkrbtnrocATMFree.setToggleGroup(rocrbtnATMGroup);
		bnkrbtnrocATMFree.setSelected(true);
		bnkrbtnrocATMFree.setUserData("rocATMYes");

		bnkrbtnrocCashinFree.setToggleGroup(rocrbtnATMGroup);
		bnkrbtnrocCashinFree.setUserData("rocATMNo");
		
		bnktxtrocCashinAgent.setDisable(false);
		bnktxtrocCashinAgent.setText(rockData.get("rocATMCashInAgentCharge"));
		
		bnktxtrocCashinBranch.setDisable(false);
		bnktxtrocCashinBranch.setText(rockData.get("rocATMCashInBranchCharge"));
		
		bnktxtrocCashOutATM.setDisable(false);
		bnktxtrocCashOutATM.setText(rockData.get("rocATMCashOutATMCharge"));
		
		bnktxtrocSendMoney.setDisable(false);
		bnktxtrocSendMoney.setText(rockData.get("rocATMSendMoneyCharge"));
		
		bnktxtrocCashOutAgent.setDisable(false);
		bnktxtrocCashOutAgent.setText(rockData.get("rocATMCashOutAgentCharge"));
		
		bnktxtrocCashOutBranch.setDisable(false);
		bnktxtrocCashOutBranch.setText(rockData.get("rocATMCashOutBranchCharge"));
		
		bnklblrocCashOutatBranch.setText("  Tk.");
		
	}
	
	private void rocCashInisActive() {
		Map<String, String> rockData = rocketChargeData();
		
		bnkrbtnrocATMFree.setToggleGroup(rocrbtnATMGroup);
		bnkrbtnrocATMFree.setUserData("rocATMYes");

		bnkrbtnrocCashinFree.setToggleGroup(rocrbtnATMGroup);
		bnkrbtnrocCashinFree.setSelected(true);
		bnkrbtnrocCashinFree.setUserData("rocATMNo");
		
		bnktxtrocCashinAgent.setDisable(false);
		bnktxtrocCashinAgent.setText(rockData.get("rocCashCashInAgentCharge"));
		
		bnktxtrocCashinBranch.setDisable(false);
		bnktxtrocCashinBranch.setText(rockData.get("rocCashCashInBranchCharge"));
		
		bnktxtrocCashOutATM.setDisable(false);
		bnktxtrocCashOutATM.setText(rockData.get("rocCashCashOutATMCharge"));
		
		bnktxtrocSendMoney.setDisable(false);
		bnktxtrocSendMoney.setText(rockData.get("rocCashSendMoneyCharge"));
		
		bnktxtrocCashOutAgent.setDisable(false);
		bnktxtrocCashOutAgent.setText(rockData.get("rocCashCashOutAgentCharge"));
		
		bnktxtrocCashOutBranch.setDisable(false);
		bnktxtrocCashOutBranch.setText(rockData.get("rocCashCashOutBranchCharge"));
		
		bnklblrocCashOutatBranch.setText("  per 1,000 Tk.");
		
	}
		
	private void rocisInactive() {
		bnktxtrocCashinAgent.setDisable(true);
		bnktxtrocCashinAgent.setText("0.00");
		
		bnktxtrocCashinBranch.setDisable(true);
		bnktxtrocCashinBranch.setText("0.00");
		
		bnktxtrocCashOutATM.setDisable(true);
		bnktxtrocCashOutATM.setText("0.00");
		
		bnktxtrocSendMoney.setDisable(true);
		bnktxtrocSendMoney.setText("0.00");
		
		bnktxtrocCashOutAgent.setDisable(true);
		bnktxtrocCashOutAgent.setText("0.00");
		
		bnktxtrocCashOutBranch.setDisable(true);
		bnktxtrocCashOutBranch.setText("0.00");
		
		bnkrbtnrocATMFree.setDisable(true);
		bnkrbtnrocCashinFree.setDisable(true);
		
		bnklblrocCashOutatBranch.setText("  Tk.");
		
	}
	
	@FXML
	private void bnkbtnSave() {
		Map<String, String> bnkSettingData = new HashMap<>();
		
		String bkStatus = (String) bkrbtnGroup.getSelectedToggle().getUserData();
		String rocStatus = (String) rocrbtnGroup.getSelectedToggle().getUserData();
		String rocATMStatus;
		try {
			rocATMStatus = (String) rocrbtnATMGroup.getSelectedToggle().getUserData();
		} catch (Exception e1) {
			rocATMStatus = "None";
		}

		try {
			if (bkStatus.equals("bkYes")) {
				TextField zero[] = {bnktxtbkCashinAgent, bnktxtbkCashOutAgent, bnktxtbkSendMoney, bnktxtbkCashOutATM};
				for (TextField textField : zero) {
					if (textField.getText().isEmpty()) {
						textField.setText("0");
					}
				}
				bnkSettingData.put("bkCashInCharge", bnktxtbkCashinAgent.getText());
				bnkSettingData.put("bkCashOutAgentCharge", bnktxtbkCashOutAgent.getText());
				bnkSettingData.put("bkSendMoneyCharge", bnktxtbkSendMoney.getText());
				bnkSettingData.put("bkATMCharge", bnktxtbkCashOutATM.getText());
				new SettingBank().savebkYes(bnkSettingData);
			} else {
				new SettingBank().savebkNo();
			}
			
		
			if (rocStatus.equals("rocYes")) {
				TextField zero[] = {bnktxtrocCashinAgent, bnktxtrocCashinBranch, bnktxtrocCashOutATM, bnktxtrocSendMoney, bnktxtrocCashOutAgent, bnktxtrocCashOutBranch};
				for (TextField textField : zero) {
					if (textField.getText().isEmpty()) {
						textField.setText("0");
					}
				}
				if (rocATMStatus.equals("rocATMYes")) {
					bnkSettingData.put("rocATMCashInAgentCharge", bnktxtrocCashinAgent.getText());
					bnkSettingData.put("rocATMCashInBranchCharge", bnktxtrocCashinBranch.getText());
					bnkSettingData.put("rocATMCashOutATMCharge", bnktxtrocCashOutATM.getText());
					bnkSettingData.put("rocATMSendMoneyCharge", bnktxtrocSendMoney.getText());
					bnkSettingData.put("rocATMCashOutAgentCharge", bnktxtrocCashOutAgent.getText());
					bnkSettingData.put("rocATMCashOutBranchCharge", bnktxtrocCashOutBranch.getText());
					new SettingBank().saverocATMYes(bnkSettingData);
				} else if (!rocStatus.equals("None")){
					bnkSettingData.put("rocCashCashInAgentCharge", bnktxtrocCashinAgent.getText());
					bnkSettingData.put("rocCashCashInBranchCharge", bnktxtrocCashinBranch.getText());
					bnkSettingData.put("rocCashCashOutATMCharge", bnktxtrocCashOutATM.getText());
					bnkSettingData.put("rocCashSendMoneyCharge", bnktxtrocSendMoney.getText());
					bnkSettingData.put("rocCashCashOutAgentCharge", bnktxtrocCashOutAgent.getText());
					bnkSettingData.put("rocCashCashOutBranchCharge", bnktxtrocCashOutBranch.getText());
					new SettingBank().saverocCashInYes(bnkSettingData);
				}
				
			} else {
				new SettingBank().saverocNo();
			}
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Information updated successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
//////////////////////////////////////////// Source Function  ////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------////
	Source source = new Source();
	
	@FXML
	private void tabSourceInitialize() {
		sourcetxtSourceName.clear();
		sourcelblWarningMsg.setText("");
		loadActiveSource();
		loadArchievedSource();
	}
	
	
	@FXML
	private void createSource(ActionEvent event) {
		if ((sourcetxtSourceName.getText()).length() == 0 || countWords(sourcetxtSourceName.getText()) == 0) {
			sourcelblWarningMsg.setText("Write a Source Name Please");
		} else {
			sourcelblWarningMsg.setText("");
			source.createSource(sourcetxtSourceName.getText());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Source "+sourcetxtSourceName.getText()+ " created successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSourceInitialize();
		}
	}
	
	
	@FXML
	private void sourceNameValidation() {
		sourcelblWarningMsg.setText("");
	}
	
	
	@FXML
	private void sourcebtnDelete(ActionEvent event) {
		try {
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Source");
			alert.setHeaderText("Are you sure?");
			alert.setContentText("You are going to delete Source \""+ sourcecmboDelete.getValue() + "\" ");
			alert.setX(SettingsStage.getX() + 210);
			alert.setY(SettingsStage.getY() + 170);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				
				source.deleteSource(sourcecmboDelete.getValue());
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText(sourcecmboDelete.getValue()+ " Deleted Successfully");
				confirmationMsg.setX(SettingsStage.getX() + 190);
				confirmationMsg.setY(SettingsStage.getY() + 190);
				confirmationMsg.showAndWait();
			}
			
			tabSourceInitialize();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void archiveSource(ActionEvent event) {
		try {
			source.archiveSource(sourcecmboArchive.getValue());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText(sourcecmboArchive.getValue()+ " is Archived Successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSourceInitialize();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void unarchiveSource(ActionEvent event) {
		try {
			source.unarchiveSource(sourcecmboUnArchive.getValue());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText(sourcecmboUnArchive.getValue()+ " is Unarchived Successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSourceInitialize();
		} catch (Exception e) {}
	}
	
	
	private void loadActiveSource() {
		try {
			if (new ComboboxList().getSourceArraySize() == 0) {
				sourcecmboArchive.setDisable(true);
				sourcebtnArchive.setDisable(true);
				sourcecmboDelete.setDisable(true);
				sourcebtnDelete.setDisable(true);
			} else {
				sourcecmboArchive.setDisable(false);
				sourcebtnArchive.setDisable(false);
				sourcecmboDelete.setDisable(false);
				sourcebtnDelete.setDisable(false);
				sourcecmboArchive.setItems(getActiveSourceList());
				sourcecmboArchive.getSelectionModel().selectFirst();
				sourcecmboDelete.setItems(getActiveSourceList());
				sourcecmboDelete.getSelectionModel().selectFirst();
			}
		} catch (Exception e) {}
	}
	
	
	private void loadArchievedSource() {
		try {
			if (new ComboboxList().getArchivedSourceArraySize() == 0) {
				sourcecmboUnArchive.setDisable(true);
				sourcebtnUnarchive.setDisable(true);
			} else {
				sourcecmboUnArchive.setDisable(false);
				sourcebtnUnarchive.setDisable(false);
				sourcecmboUnArchive.setItems(getArchivedSourceList());
				sourcecmboUnArchive.getSelectionModel().selectFirst();
			}
		} catch (Exception e) {}
	}
	
//////////////////////////////////////////// Sector Function  ////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------////

//	create object for the classes
	Sector sector = new Sector();
	AdvancedExpense advancedSector = new AdvancedExpense();
	
	@FXML
	private void tabSectorInitialize() {
		sectortxtSourceName.clear();
		sectorlblWarningMsg.setText("");
		loadActiveSector();
		loadArchievedSector();
	}

	
	private void loadActiveSector() {
		try {
			if (new ComboboxList().getSectorArraySize() == 0) {
				sectorcmboArchive.setDisable(true);
				sectorbtnArchive.setDisable(true);
				sectorcmboDelete.setDisable(true);
				sectorbtnDelete.setDisable(true);
			} else {
				sectorcmboArchive.setDisable(false);
				sectorbtnArchive.setDisable(false);
				sectorcmboDelete.setDisable(false);
				sectorbtnDelete.setDisable(false);
				sectorcmboArchive.setItems(getActiveSectorList());
				sectorcmboArchive.getSelectionModel().selectFirst();
				sectorcmboDelete.setItems(getActiveSectorList());
				sectorcmboDelete.getSelectionModel().selectFirst();
			}
		} catch (Exception e) {}
	}
	
	
	private void loadArchievedSector() {
		try {
			if (new ComboboxList().getArchivedSectorArraySize() == 0) {
				sectorcmboUnArchive.setDisable(true);
				sectorbtnUnarchive.setDisable(true);
			} else {
				sectorcmboUnArchive.setDisable(false);
				sectorbtnUnarchive.setDisable(false);
				sectorcmboUnArchive.setItems(getArchivedSectorList());
				sectorcmboUnArchive.getSelectionModel().selectFirst();
			}
		} catch (Exception e) {}
	}
	

	@FXML
	private void createSector(ActionEvent event) {
		if ((sectortxtSourceName.getText()).length() == 0 || countWords(sectortxtSourceName.getText()) == 0) {
			sectorlblWarningMsg.setText("Write a Sector Name Please");
			
		} else if(sector.createSector(sectortxtSourceName.getText())) {
			
			Alert confirmationMsg = new Alert(AlertType.ERROR);
			confirmationMsg.setTitle("Operation Failed");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Sector Name Already Exist. Please Try Another.");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSectorInitialize();
			
		} else {
			sectorlblWarningMsg.setText("");
			sector.createSector(sectortxtSourceName.getText());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Sector "+sectortxtSourceName.getText()+ " created successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSectorInitialize();
		}
	}
	
	
	@FXML
	private void sectorNameValidation() {
		sectorlblWarningMsg.setText("");
	}
	
	
	@FXML
	private void sectorbtnDelete(ActionEvent event) {
		try {
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Sector");
			alert.setHeaderText("Are you sure?");
			alert.setContentText("You are going to delete Sector \""+ sectorcmboDelete.getValue() + "\" ");
			alert.setX(SettingsStage.getX() + 210);
			alert.setY(SettingsStage.getY() + 170);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				
				sector.deleteSector(sectorcmboDelete.getValue());
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText(sectorcmboDelete.getValue()+ " Deleted Successfully");
				confirmationMsg.setX(SettingsStage.getX() + 190);
				confirmationMsg.setY(SettingsStage.getY() + 190);
				confirmationMsg.showAndWait();
			}
			
			tabSectorInitialize();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void archiveSector(ActionEvent event) {
		try {
			sector.archiveSector(sectorcmboArchive.getValue());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText(sectorcmboArchive.getValue()+ " is Archived Successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSectorInitialize();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void unarchiveSector(ActionEvent event) {
		try {
			sector.unarchiveSector(sectorcmboUnArchive.getValue());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText(sectorcmboUnArchive.getValue()+ " is Unarchived Successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSectorInitialize();
		} catch (Exception e) {}
	}
	
	

//////////////////////////////////////////// System Function  ////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------////
	final ToggleGroup timerbtnGroup = new ToggleGroup();
	final ToggleGroup daterbtnGroup = new ToggleGroup();
	Calendar now = Calendar.getInstance();
	boolean nameChangeClicked = false;
	boolean passwordChangeClicked = false;
	
	@FXML
	private void tabSystemInitialize() {
		timeRbtn();
		dateRbtn();
		showWeekNum();
		loadUsername();
		loadUserFullName();
		loadPassword();
		systemlblRePassword.setVisible(false);
		systemtxtRePassword.setVisible(false);
		systemlblWarningMsg.setText("");
	}
	
	
	@FXML
	private void systembtnWalletBalance(ActionEvent event) {
		Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
		Alert confirmationMsg = new Alert(AlertType.INFORMATION);
		confirmationMsg.setTitle("Starting Wallet Balance");
		confirmationMsg.setHeaderText(null);
		confirmationMsg.setContentText("Press \"Adjust Balance\" Button");
		confirmationMsg.setX(SettingsStage.getX() + 200);
		confirmationMsg.setY(SettingsStage.getY() + 170);
		
		(new TabAccess()).setTabName("tabExpense");
		(new GoToOperation()).goToMakeATransaction(SettingsStage.getX(), SettingsStage.getY());
		confirmationMsg.showAndWait();
		SettingsStage.close();
	}
	
	
	private void timeRbtn() {
		DateFormat formateTIME_h = new SimpleDateFormat("h:mm:ss a");
		TIME_h.setText(formateTIME_h.format(now.getTime()));
		TIME_h.setToggleGroup(timerbtnGroup);
		TIME_h.setUserData("h:mm:ss a");
		
		DateFormat formateTIME_hh = new SimpleDateFormat("hh:mm:ss a");
		TIME_hh.setText(formateTIME_hh.format(now.getTime()));
		TIME_hh.setToggleGroup(timerbtnGroup);
		TIME_hh.setUserData("hh:mm:ss a");
		
		DateFormat formateTIME_H = new SimpleDateFormat("H:mm:ss");
		TIME_H.setText(formateTIME_H.format(now.getTime()));
		TIME_H.setToggleGroup(timerbtnGroup);
		TIME_H.setUserData("H:mm:ss");
		
		DateFormat formateTIME_HH = new SimpleDateFormat("HH:mm:ss");
		TIME_HH.setText(formateTIME_HH.format(now.getTime()));
		TIME_HH.setToggleGroup(timerbtnGroup);
		TIME_HH.setUserData("HH:mm:ss");
		
		switch (new DateFormatManager().getTimeFormate()) {
			case "h:mm:ss a": TIME_h.setSelected(true);
				break;
			case "hh:mm:ss a": TIME_hh.setSelected(true);
				break;
			case "H:mm:ss": TIME_H.setSelected(true);
				break;
			default: TIME_HH.setSelected(true);
				break;
		}
	}
	
	
	private void dateRbtn() {
		DateFormat formateDATEddMMMM = new SimpleDateFormat("dd MMMM, yyyy");
		DATEddMMMM.setText(formateDATEddMMMM.format(now.getTime()));
		DATEddMMMM.setToggleGroup(daterbtnGroup);
		DATEddMMMM.setUserData("dd MMMM, yyyy");
		
		DateFormat formateDATEddMMM = new SimpleDateFormat("dd MMM, yyyy");
		DATEddMMM.setText(formateDATEddMMM.format(now.getTime()));
		DATEddMMM.setToggleGroup(daterbtnGroup);
		DATEddMMM.setUserData("dd MMM, yyyy");
		
		DateFormat formateDATEddMM = new SimpleDateFormat("dd-MM-yyyy");
		DATEddMM.setText(formateDATEddMM.format(now.getTime()));
		DATEddMM.setToggleGroup(daterbtnGroup);
		DATEddMM.setUserData("dd-MM-yyyy");
		
		DateFormat formateDATEEEddMMM = new SimpleDateFormat("EE dd MMMM, yyyy");
		DATEEEddMMM.setText(formateDATEEEddMMM.format(now.getTime()));
		DATEEEddMMM.setToggleGroup(daterbtnGroup);
		DATEEEddMMM.setUserData("EE dd MMMM, yyyy");
		
		DateFormat formateDATEMMM = new SimpleDateFormat("MMMM dd, yyyy");
		DATEMMM.setText(formateDATEMMM.format(now.getTime()));
		DATEMMM.setToggleGroup(daterbtnGroup);
		DATEMMM.setUserData("MMMM dd, yyyy");

		switch (new DateFormatManager().getDateFormat()) {
		case "dd MMMM, yyyy": DATEddMMMM.setSelected(true);
			break;
		case "dd MMM, yyyy": DATEddMMM.setSelected(true);
			break;
		case "dd-MM-yyyy": DATEddMM.setSelected(true);
			break;
		case "EE dd MMMM, yyyy": DATEEEddMMM.setSelected(true);
			break;
		default: DATEMMM.setSelected(true);
			break;
		}
	}
	
	
	private void showWeekNum() {
		if (getWeekStatus()) {
			checkBoxWeekNum.setSelected(true);
		} else {
			checkBoxWeekNum.setSelected(false);
		}
	}
	
	
	@FXML
	private void systembtnSave(ActionEvent event) {
		DateFormatManager format = new DateFormatManager();

		try {
			String timeFormat = (String) timerbtnGroup.getSelectedToggle().getUserData();
			String dateFormat = (String) daterbtnGroup.getSelectedToggle().getUserData();

			format.setTimeFormate(timeFormat);
			format.setDateFormate(dateFormat);
			updateLastAccessDate();
			
			if (checkBoxWeekNum.isSelected()) {
				setWeekStatus(true);
			} else {
				setWeekStatus(false);
			}
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Information updated successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			confirmationMsg.showAndWait();
			
			tabSystemInitialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void loadUsername() {
		systemtxtUsername.setText(getUsername());
		systemtxtUsername.setDisable(true);
	}
	
	private void loadUserFullName() {
		systemtxtName.setText(getUserFullName());
		systemtxtName.setDisable(true);
		systembtnChangeName.setText("Change Name");
	}
	
	private void loadPassword() {
		systemtxtPassword.setText(getPassword());
		systemtxtPassword.setDisable(true);
		systembtnChangePassword.setText("Change Password");
	}
	
	
	@FXML
	private void changeName(ActionEvent event) {
		try {
			if (!nameChangeClicked) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Name Change");
				dialog.setHeaderText("Enter password for authentication");
				dialog.setContentText("Your Password :");
				Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
				dialog.setX(SettingsStage.getX() + 200);
				dialog.setY(SettingsStage.getY() + 170);
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					if (getPassword().equals(result.get())) {
						systemtxtName.setDisable(false);
						systembtnChangeName.setText("Save Name");
						nameChangeClicked = true;
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Message");
						alert.setHeaderText(null);
						alert.setContentText("Wrong Password");
						alert.setX(SettingsStage.getX() + 200);
						alert.setY(SettingsStage.getY() + 170);
						alert.showAndWait();
					}
				} 
				
			} else {
				setUserFullName(systemtxtName.getText());
				nameChangeClicked = false;
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Information updated successfully");
				Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
				confirmationMsg.setX(SettingsStage.getX() + 200);
				confirmationMsg.setY(SettingsStage.getY() + 170);
				confirmationMsg.showAndWait();
				
				lblUserFullName.setText(getUserFullName());
				tabSystemInitialize();
			}
		} catch (Exception e) {}

	}
	
	
	@FXML
	private void changePassword(ActionEvent event) {
		try {
			if (!passwordChangeClicked) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Password Change");
				dialog.setHeaderText("Enter password for authentication");
				dialog.setContentText("Your Password :");
				Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
				dialog.setX(SettingsStage.getX() + 200);
				dialog.setY(SettingsStage.getY() + 170);
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()) {
					if (getPassword().equals(result.get())) {
						systemtxtPassword.setDisable(false);
						systemtxtPassword.clear();
						systemlblRePassword.setVisible(true);
						systemtxtRePassword.setVisible(true);
						systembtnChangePassword.setText("Save Password");
						passwordChangeClicked = true;
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Message");
						alert.setHeaderText(null);
						alert.setContentText("Wrong Password");
						alert.setX(SettingsStage.getX() + 200);
						alert.setY(SettingsStage.getY() + 170);
						alert.showAndWait();
					}
				} 
				
			} else {
				if (!systemtxtPassword.getText().equals(systemtxtRePassword.getText())) {
					systemlblWarningMsg.setText("Password didn't match");
				} else {
					setPassword(systemtxtPassword.getText());
					passwordChangeClicked = false;
					
					Alert confirmationMsg = new Alert(AlertType.INFORMATION);
					confirmationMsg.setTitle("Message");
					confirmationMsg.setHeaderText(null);
					confirmationMsg.setContentText("Information updated successfully");
					Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
					confirmationMsg.setX(SettingsStage.getX() + 200);
					confirmationMsg.setY(SettingsStage.getY() + 170);
					confirmationMsg.showAndWait();
					
					tabSystemInitialize();
				}
			}
		} catch (Exception e) {}
	}
	
	@FXML
	private void emptyPassField() {
		if (containswhitespace(systemtxtPassword.getText())) {
			systemlblWarningMsg.setText("Space isn't allowed for password");
			systemtxtPassword.clear();
		} else {
			systemlblWarningMsg.setText("");
		}
	}
	
	
	@FXML
	private void systemtxtRePassword() {
		if (systemtxtPassword.getText().length() <= systemtxtRePassword.getText().length()) {
			if (!systemtxtRePassword.getText().equals(systemtxtPassword.getText())) {
				systemlblWarningMsg.setText("Password didn't match");
			}
		} else {
			systemlblWarningMsg.setText("");
		}
	}
	
	
////////////////////////////////////////////Advanced Expense Function  ///////////////////////////////////
//----------------------------------------------------------------------------------------------------////
	@FXML
	private void tabAdvancedInitialize() {
		loadQueuedSector();
		loadActiveAdvancedSector();
		loadSectorInList();
	}
	
	
	private void loadQueuedSector() {
		if (new ComboboxList().getAdvancedSectorInactiveArraySize() == 0) {
			advancedCmboAdd.setDisable(true);
			advancedBtnAdd.setDisable(true);
		} else {
			advancedCmboAdd.setDisable(false);
			advancedBtnAdd.setDisable(false);
			advancedCmboAdd.setItems(getAdvancedSectorListInactive());
			advancedCmboAdd.getSelectionModel().selectFirst();
		}
	}
	
	
	private void loadActiveAdvancedSector() {
		if (new ComboboxList().getAdvancedSectorActiveArraySize() == 0) {
			advancedCmboRemove.setDisable(true);
			advancedBtnRemove.setDisable(true);
		} else {
			advancedCmboRemove.setDisable(false);
			advancedBtnRemove.setDisable(false);
			advancedCmboRemove.setItems(getAdvancedSectorListActive());
			advancedCmboRemove.getSelectionModel().selectFirst();
		}
	}
	
	
	@FXML
	private void advancedBtnAdd(ActionEvent event) {
		try {
			if (new ComboboxList().getAdvancedSectorActiveArraySize() == 7) {
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("You can add maximum 7 sector to this list");
				Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
				confirmationMsg.setX(SettingsStage.getX() + 200);
				confirmationMsg.setY(SettingsStage.getY() + 170);
				tabAdvancedInitialize();
				confirmationMsg.showAndWait();
				
			} else {
				advancedSector.addSectorToList(advancedCmboAdd.getValue());
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText(advancedCmboAdd.getValue()+ " is addedd to list successfully");
				Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
				confirmationMsg.setX(SettingsStage.getX() + 200);
				confirmationMsg.setY(SettingsStage.getY() + 170);
				tabAdvancedInitialize();
				confirmationMsg.showAndWait();
			}
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void advancedBtnRemove(ActionEvent event) {
		try {
			advancedSector.removeSectorFromList(advancedCmboRemove.getValue());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Message");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText(advancedCmboRemove.getValue()+ " is removed from list successfully");
			Stage SettingsStage = (Stage) btnDashboard.getScene().getWindow();
			confirmationMsg.setX(SettingsStage.getX() + 200);
			confirmationMsg.setY(SettingsStage.getY() + 170);
			tabAdvancedInitialize();
			confirmationMsg.showAndWait();
			
		} catch (Exception e) {}
	}
	
	
	private void loadSectorInList() {
		Label lbl[] = {advancedlblSectorName1, advancedlblSectorName2, advancedlblSectorName3, advancedlblSectorName4,
				advancedlblSectorName5, advancedlblSectorName6, advancedlblSectorName7};
		
		String sectorNameInList[] = new ComboboxList().getAdvancedSectorListActive();
		int indexSize = new ComboboxList().getAdvancedSectorActiveArraySize();
		int index = 0;
		
		for (Label label : lbl) {
			label.setText("");
		}
		
		for (Label label : lbl) {
			if((indexSize > 0) && (index < indexSize)) {
				label.setText(sectorNameInList[index]);
				++index;
			}
		}
	}
	
	
}



	






















