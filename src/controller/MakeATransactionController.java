package controller;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.MakeATransactionModel;
import operation.GoToOperation;
import system.DateFormatManager;
import tab.TabAccess;

public class MakeATransactionController extends MakeATransactionModel {
	
	@FXML
	private TabPane tabPane;
	
	///////////////////////////////////  Get Money  ////////////////////////////////
	@FXML
	private Tab tabGetMoney;
	
	@FXML
	private Button gmbtnCreateSource;
	@FXML
	private Button gmbtnSettings;
	@FXML
	private Button gmbtnCancel;
	@FXML
	private Button gmbtnSave;
	@FXML
	private Button gmbtnGoToDashboard;

	@FXML
	private RadioButton gmrbtnAgent;
	@FXML
	private RadioButton gmrbtnSendMoney;
	@FXML
	private RadioButton gmrbtnBranch;
	
	@FXML
	private TextField gmtxtAmount;
	@FXML
	private TextArea gmtxtDescription;
	
	@FXML
	private ComboBox<String> gmcmboSource;
	@FXML
	private ComboBox<String> gmcmboMethod;
	
	@FXML
	private DatePicker gmdateDate;
	
	@FXML
	private Label gmlblWalletBalance;
	@FXML
	private Label gmlblLetterRemainmsg;
	@FXML
	private Label gmlblWarningMsg;
	@FXML
	private Label gmlblBalanceUpdateMsg;
	@FXML
	private Label gmlblAmountNature;
	
	///////////////////////////////////  Expense  ////////////////////////////////
	@FXML
	private Tab tabExpense;
	
	@FXML
	private Button exbtnCreateSector;
	@FXML
	private Button exbtnAdjustBalance;
	@FXML
	private Button exbtnCancel;
	@FXML
	private Button exbtnSave;
	@FXML
	private Button exbtnGoToDashboard;
	
	@FXML
	private TextField extxtAmount;
	@FXML
	private TextArea extxtDescription;
	
	@FXML
	private ComboBox<String> excmboSector;
	
	@FXML
	private DatePicker exdateDate;
	
	@FXML
	private Label exlblWalletBalance;
	@FXML
	private Label exlblWarningMsg;
	
	///////////////////////////////////  Lend  ////////////////////////////////
	@FXML
	private Tab tabLend;
	
	@FXML
	private Button lendbtnCancel;
	@FXML
	private Button lendbtnSave;
	@FXML
	private Button lendbtnGoToDashboard;
	
	@FXML
	private Label lendlblTableHeading;
	
	@FXML
	private DatePicker lenddateDate;
	
	@FXML
	private TabPane lendTabPane;
	
	@FXML
	private TableView lendTableView;
	
	/////////////// Borrow //////////////////
	@FXML
	private Tab tabBorrow;
	
	@FXML
	private ComboBox<String> bocmboType;
	@FXML
	private ComboBox<String> bocmboMethod;
	@FXML
	private ComboBox<String> bocmboRepaidPerson;
	
	@FXML
	private TextField botxtFromWhom;
	@FXML
	private TextField botxtAmountWithCharge;
	@FXML
	private TextField botxtExactAmount;
	
	@FXML
	private RadioButton borbtnSendMoney;
	@FXML
	private RadioButton borbtnCashOut;
	@FXML
	private RadioButton borbtnBuyAirtime;
	@FXML
	private RadioButton borbtnATM;
	
	@FXML
	private Label bolblPersonName;
	@FXML
	private Label bolblAmountWithCharge;
	@FXML
	private Label bolblAmountNature;
	@FXML
	private Label bolblBankChargeName;
	@FXML
	private Label bolblBankCharge;
	@FXML
	private Label bolblExactAmount;
	@FXML
	private Label bolblWarningMsg;
	
	/////////////// Lend //////////////////
	@FXML
	private Tab tabLe;
	
	@FXML
	private ComboBox<String> lecmboType;
	@FXML
	private ComboBox<String> lecmboMethod;
	@FXML
	private ComboBox<String> lecmboRepaidPerson;
	
	@FXML
	private TextField letxtFromWhom;
	@FXML
	private TextField letxtAmountWithCharge;
	@FXML
	private TextField letxtExactAmount;
	
	@FXML
	private RadioButton lerbtnSendMoney;
	@FXML
	private RadioButton lerbtnCashOut;
	@FXML
	private RadioButton lerbtnBuyAirtime;
	@FXML
	private RadioButton lerbtnATM;
	
	@FXML
	private Label lelblPersonName;
	@FXML
	private Label lelblAmountWithCharge;
	@FXML
	private Label lelblAmountNature;
	@FXML
	private Label lelblBankChargeName;
	@FXML
	private Label lelblBankCharge;
	@FXML
	private Label lelblExactAmount;
	@FXML
	private Label lelblWarningMsg;
	
	///////////////////////////////////  Bank  ////////////////////////////////
	@FXML
	private Tab tabBank;
	
	@FXML
	private Button bnkbtnCancel;
	@FXML
	private Button bnkbtnSave;
	@FXML
	private Button bnkbtnGoToDashboard;
	
	@FXML
	private DatePicker bnkdateDate;
	
	@FXML
	private TabPane bnkTabPane;
	
	/////////////// bKash //////////////////
	@FXML
	private Tab tabbKash;
	
	@FXML
	private ComboBox<String> bkcmboTransactionType;
	@FXML
	private ComboBox<String> bkcmboAmountNature;
	
	@FXML
	private Button bkbtnSettings;
	@FXML
	private Button bkbtnAdjustBalance;
	
	@FXML
	private TextField bktxtAmount;
	
	@FXML
	private Label bklblBankChargeName;
	@FXML
	private Label bklblBankCharge;
	@FXML
	private Label bklblAccountBalance;
	@FXML
	private Label bklblAmountNature;
	@FXML
	private Label bklblUpdateBalance;
	
	@FXML
	private RadioButton bkrbtnSendMoney;
	@FXML
	private RadioButton bkrbtnCashOut;
	@FXML
	private RadioButton bkrbtnBuyAirtime;
	@FXML
	private RadioButton bkrbtnATM;
	@FXML
	private RadioButton bkrbtnPayment;
	
	/////////////// Rocket //////////////////
	@FXML
	private Tab tabRocket;
	
	@FXML
	private ComboBox<String> roccmboTransactionType;
	@FXML
	private ComboBox<String> roccmboAmountNature;
	
	@FXML
	private Button rocbtnSettings;
	@FXML
	private Button rocbtnAdjustBalance;
	
	@FXML
	private TextField roctxtAmount;
	
	@FXML
	private Label roclblBankChargeName;
	@FXML
	private Label roclblBankCharge;
	@FXML
	private Label roclblAccountBalance;
	@FXML
	private Label roclblAmountNature;
	@FXML
	private Label roclblUpdateBalance;
	
	@FXML
	private RadioButton rocrbtnSendMoney;
	@FXML
	private RadioButton rocrbtnAgent;
	@FXML
	private RadioButton rocrbtnTopUp;
	@FXML
	private RadioButton rocrbtnATM;
	@FXML
	private RadioButton rocrbtnBranch;
	
	/////////////// Personal //////////////////
	@FXML
	private Tab tabPersonal;
	
	@FXML
	private ComboBox<String> percmboAmountNature;
	
	@FXML
	private TextField pertxtAmount;
	
	@FXML
	private Label perlblAccountBalance;
	
	
	DateFormatManager formatManager = new DateFormatManager();
	String dateString = formatManager.toString(LocalDate.now());
	LocalDate date = formatManager.fromString(dateString);
	
	
	@FXML
	public void initialize() {
		
	}

	
////////////////////////////////////////////  Get Money Function ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	private boolean cancelbtnPressed = false;
	
	@FXML
	private void tabGetMoney() {
		gmdateDate.setConverter(formatManager);
		gmdateDate.setValue(date);
		loadSource();
		loadMethod();
		showWalletBalance();
		gmlblLetterRemainmsg.setText("");
				
		gmlblBalanceUpdateMsg.setText(" ");
		gmlblAmountNature.setText(" ");
		gmrbtnAgent.setVisible(false);
		gmrbtnSendMoney.setVisible(false);
		gmrbtnBranch.setVisible(false);
	}
	
	
	@FXML
	private void returnToDashboard(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnGoToDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		MakeATransactionStage.hide();
	}

	
	@FXML
	private void showWalletBalance() {
		gmlblWalletBalance.setText(getWalletBalance());
	}
	
	
	@FXML
	public void settingBtn(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnSettings.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		(new TabAccess()).setTabName("tabBank");
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void createSourceBtn(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnCreateSource.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		(new TabAccess()).setTabName("tabSource");
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void cancelBtn(ActionEvent event) {
		gmdateDate.setConverter(formatManager);
		gmdateDate.setValue(date);
		gmtxtAmount.clear();
		gmlblWarningMsg.setText("");
		gmtxtDescription.clear();
		gmtxtDescription.setEditable(true);
		gmlblLetterRemainmsg.setText("");
		cancelbtnPressed = true;
		loadSource();
		loadMethod();
		
		gmlblBalanceUpdateMsg.setText(" ");
		gmlblAmountNature.setText(" ");
		gmrbtnAgent.setVisible(false);
		gmrbtnSendMoney.setVisible(false);
		gmrbtnBranch.setVisible(false);
	}
	
	
	@FXML
	private void loadSource() {
		gmcmboSource.setItems(getSource());
		gmcmboSource.getSelectionModel().selectFirst();
	}
	
	
	@FXML
	private void loadMethod() {
		gmcmboMethod.setItems(getMethod());
		gmcmboMethod.getSelectionModel().selectFirst();
	}
	
	
	@FXML
	public void methodAction(ActionEvent event) {
		if (!cancelbtnPressed) {
			
			if ((gmcmboMethod.getValue()).equals("bKash")) {
				
				if (amountIsZero(gmtxtAmount.getText())) {
					gmlblBalanceUpdateMsg.setText(" ");
				} else {
					gmlblBalanceUpdateMsg.setText("Your update bKash Balance will be : " + updatedbKashBalance(gmtxtAmount.getText()));
				}
				gmlblAmountNature.setText(" ");
				gmrbtnAgent.setVisible(false);
				gmrbtnSendMoney.setVisible(false);
				gmrbtnBranch.setVisible(false);
				
			} else if ((gmcmboMethod.getValue()).equals("Rocket")) {
				final ToggleGroup rbtnGroup = new ToggleGroup();
				
				if (amountIsZero(gmtxtAmount.getText())) {
					gmlblBalanceUpdateMsg.setText(" ");
				} else {
					gmlblBalanceUpdateMsg.setText("Your update Rocket Balance will be : " + updatedRocketBalance(gmtxtAmount.getText()));
				}

				gmlblAmountNature.setText("Amount Nature");
				gmrbtnAgent.setVisible(true);
				gmrbtnSendMoney.setVisible(true);
				gmrbtnBranch.setVisible(true);
				
				gmrbtnAgent.setToggleGroup(rbtnGroup);
				gmrbtnAgent.setSelected(true);
				gmrbtnSendMoney.setToggleGroup(rbtnGroup);
				gmrbtnBranch.setToggleGroup(rbtnGroup);
				
			} else {
				gmlblBalanceUpdateMsg.setText(" ");
				gmlblAmountNature.setText(" ");
				gmrbtnAgent.setVisible(false);
				gmrbtnSendMoney.setVisible(false);
				gmrbtnBranch.setVisible(false);
			}
		}
		
	}
	
	
	@FXML
	private void savebtn(ActionEvent event) {
		
	}
	
	
	@FXML
	private void gmAmountValidation() {
		if (!validAmount(gmtxtAmount.getText())) {
			gmlblWarningMsg.setText("Invalid Input. Type within 0.00 to 9999999.99");
			gmtxtAmount.clear();
		} else {
			gmlblWarningMsg.setText(" ");
			
			try {
				if ((gmcmboMethod.getValue()).equals("bKash")) {
					gmlblBalanceUpdateMsg.setText("Your update bKash Balance will be : " + updatedbKashBalance(gmtxtAmount.getText()));
						
				} else if ((gmcmboMethod.getValue()).equals("Rocket")) {
					gmlblBalanceUpdateMsg.setText("Your update Rocket Balance will be : " + updatedRocketBalance(gmtxtAmount.getText()));
								
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	@FXML
	private void gmDescriptionValidation() {
		int wordRemain = letterCount(gmtxtDescription.getText());
		
		if (wordRemain<0) {
			gmtxtDescription.setEditable(false);
			gmlblLetterRemainmsg.setText("You cross the limit");
		} else {
			gmlblLetterRemainmsg.setText("Word remain: "+wordRemain+" out of 100");
		}
	}
	
	
	
////////////////////////////////////////////  Expense Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	@FXML
	private void tabExpense() {
		exdateDate.setConverter(formatManager);
		exdateDate.setValue(date);
	}
	
	
////////////////////////////////////////////     Lend Function    ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	@FXML
	private void tabLend() {
		lenddateDate.setConverter(formatManager);
		lenddateDate.setValue(date);
	}
	
	
////////////////////////////////////////////     Bank Function    ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	@FXML
	private void tabBank() {
		bnkdateDate.setConverter(formatManager);
		bnkdateDate.setValue(date);
	}
	
}























