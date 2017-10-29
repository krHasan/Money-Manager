package controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.MakeATransactionModel;
import operation.GoToOperation;
import system.DateFormatManager;
import tab.Bkash;
import tab.GetMoney;
import tab.Rocket;
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
	
	
////////////////////////////////////////////   General Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//

	DateFormatManager formatManager = new DateFormatManager();
	String dateString = formatManager.toString(LocalDate.now());
	LocalDate date = formatManager.fromString(dateString);
	
	
	@FXML
	public void initialize() {
		
	}
	
	
	@FXML
	private void showWalletBalance() {
		gmlblWalletBalance.setText(getWalletBalance());
	}
	
	
	@FXML
	private void returnToDashboard(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnGoToDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void loadMethod() {
		gmcmboMethod.setItems(getMethod());
		gmcmboMethod.getSelectionModel().selectFirst();
	}
	
////////////////////////////////////////////  Get Money Function ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	private boolean cancelbtnPressed = false;
	final ToggleGroup gmrbtnGroup = new ToggleGroup();
	
	@FXML
	private void tabGetMoney() {
		gmInitialize();
	}
	
	
	private void gmInitialize() {
		gmdateDate.setConverter(formatManager);
		gmdateDate.setValue(date);
		gmlblLetterRemainmsg.setText("");
		gmlblBalanceUpdateMsg.setText(" ");
		gmtxtAmount.clear();
		gmlblWarningMsg.setText("");
		gmtxtDescription.clear();
		gmtxtDescription.setEditable(true);
		gmLoadSource();
		loadMethod();
		showWalletBalance();
		gmRocInRbtnHide();

	}
	
	
	private void gmRocInRbtnHide() {
		gmlblAmountNature.setText(" ");
		gmrbtnAgent.setVisible(false);
		gmrbtnSendMoney.setVisible(false);
		gmrbtnBranch.setVisible(false);
	}
	
	private void gmRocInRbtnShow() {
		gmlblAmountNature.setText("Amount Nature");
		
		gmrbtnAgent.setVisible(true);
		gmrbtnAgent.setToggleGroup(gmrbtnGroup);
		gmrbtnAgent.setSelected(true);
		gmrbtnAgent.setUserData("Agent");
		
		gmrbtnSendMoney.setVisible(true);
		gmrbtnSendMoney.setToggleGroup(gmrbtnGroup);
		gmrbtnSendMoney.setUserData("Send Money");
		
		gmrbtnBranch.setVisible(true);
		gmrbtnBranch.setToggleGroup(gmrbtnGroup);
		gmrbtnBranch.setUserData("Branch");
		
	}
	
	@FXML
	public String gmGetSelectedrbtnName() {
		return (String) gmrbtnGroup.getSelectedToggle().getUserData();
	}
	
	
	@FXML
	public void gmSettingBtn(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnSettings.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		(new TabAccess()).setTabName("tabBank");
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void gmGoToSourceBtn(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnCreateSource.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		(new TabAccess()).setTabName("tabSource");
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void gmCancelBtn(ActionEvent event) {
		gmInitialize();
		cancelbtnPressed = true;
	}
	
	
	@FXML
	private void gmLoadSource() {
		try {
			gmcmboSource.setItems(gmGetSource());
			gmcmboSource.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	@FXML
	public void gmMethodAction(ActionEvent event) {
		try {
			if (!cancelbtnPressed) {
				gmUpdateBalanceShow();
			} else {
				cancelbtnPressed = false;
			}
		} catch (Exception e) {}
		
	}
		
	
	@FXML
	private void gmUpdateBalanceShow() {
		
		try {
			if ((gmcmboMethod.getValue()).equals("bKash")) {
				
				if (letterCount(gmtxtAmount.getText())==100) {
					gmlblBalanceUpdateMsg.setText(" ");
				} else {
					gmlblBalanceUpdateMsg.setText("Your update bKash Balance will be : " + updatedbKashBalance(gmtxtAmount.getText(), "Cash In"));
				}
				gmRocInRbtnHide();
				
			} else if ((gmcmboMethod.getValue()).equals("Rocket")) {
				
				gmRocInRbtnShow();
				if (letterCount(gmtxtAmount.getText())==100) {
					gmlblBalanceUpdateMsg.setText(" ");
				} else {
					gmlblBalanceUpdateMsg.setText("Your update Rocket Balance will be : " + updatedRocketBalance(gmtxtAmount.getText(), "Cash In", gmGetSelectedrbtnName()));
				}
					
			} else {
				gmlblBalanceUpdateMsg.setText(" ");
				gmRocInRbtnHide();
			}
		} catch (Exception e) {}
	}
	
	
	private void gmRocUpdateBalanceShow() {
		if (letterCount(gmtxtAmount.getText())==100) {
			gmlblBalanceUpdateMsg.setText(" ");
		} else {
			gmlblBalanceUpdateMsg.setText("Your update Rocket Balance will be : " + updatedRocketBalance(gmtxtAmount.getText(), "Cash In", gmGetSelectedrbtnName()));
		}
	}
	
	
	@FXML
	private void gmRbtnAgentClick(MouseEvent event) {
		gmRocUpdateBalanceShow();
	}

	
	@FXML
	private void gmRbtnSendMoneyClick(MouseEvent event) {
		gmRocUpdateBalanceShow();
	}
	
	
	@FXML
	private void gmRbtnBranceClick(MouseEvent event) {
		gmRocUpdateBalanceShow();
	}
	
	
	@FXML
	private void gmSavebtn(ActionEvent event) {
		if (amountIsZero(gmtxtAmount.getText())) {
			
			gmlblWarningMsg.setText("Empty or Zero is not approved.");
		
		} else {
			try {
				Map<String, String> stringData = new HashMap<>();
				
				int globalId = globalIdToSave();
				
				stringData.put("gmTime", timeToSave());
				stringData.put("gmDate", (new DateFormatManager()).toString(gmdateDate.getValue()));
				stringData.put("gmMonth", monthToSave());
				stringData.put("gmAmount", gmtxtAmount.getText());
				
				if ((gmcmboMethod.getValue()).equals("bKash")) {
					stringData.put("gmBankCharge", bkashBnkCharge(gmtxtAmount.getText(), "Cash In"));
				} else if((gmcmboMethod.getValue()).equals("Rocket")){
					stringData.put("gmBankCharge", rocketBnkCharge(gmtxtAmount.getText(), "Cash In", gmGetSelectedrbtnName()));
				} else {
					stringData.put("gmBankCharge", "0");
				}
				
				if ((gmcmboMethod.getValue()).equals("bKash")) {
					stringData.put("gmAmountNature", "Cash In from Agent");
				} else if ((gmcmboMethod.getValue()).equals("Rocket")) {
					stringData.put("gmAmountNature", gmGetSelectedrbtnName());
				} else {
					stringData.put("gmAmountNature", "None");
				}
				
				if ((gmcmboMethod.getValue()).equals("bKash")) {
					stringData.put("bkBalanceAfter", updatedbKashBalance(gmtxtAmount.getText(), "Cash In"));
					(new Bkash()).saveGmBkashData(stringData);
				} else if ((gmcmboMethod.getValue()).equals("Rocket")) {
					stringData.put("rocBalanceAfter", updatedRocketBalance(gmtxtAmount.getText(), "Cash In", gmGetSelectedrbtnName()));
					(new Rocket()).saveGmRocketData(stringData);
				}
				
				stringData.put("gmSource", gmcmboSource.getValue());
				
				if (gmIsDescripionEmpty()) {
					stringData.put("gmDescription", "None");
				} else {
					stringData.put("gmDescription", gmtxtDescription.getText());
				}

				stringData.put("gmMethod", gmcmboMethod.getValue());
				stringData.put("gmWalletBalanceBefore", getWalletBalance());
				
				if ((gmcmboMethod.getValue()).equals("Hand to Hand")) {
					stringData.put("gmWalletBalanceAfter", getWalletBalanceAfter(gmtxtAmount.getText()));
					setCurrentWalletBalance(getWalletBalanceAfter(gmtxtAmount.getText()));
				} else {
					stringData.put("gmWalletBalanceAfter", getWalletBalance());
				}
				
				(new GetMoney()).saveGetMoneyData(globalId, stringData);
				
				gmInitialize();
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Successfull Transaction");
				alert.setHeaderText(null);
				alert.setContentText("Your transaction completed successfully.");
				alert.showAndWait();
				
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				alert.showAndWait();
			}
		}

	}
	
	
	@FXML
	private void gmAmountValidation() {
		if (!validAmount(gmtxtAmount.getText())) {
			
			gmlblWarningMsg.setText("Invalid Input. Type within 0.00 to 9999999.99");
			gmtxtAmount.clear();
		
		} else {
			
			gmlblWarningMsg.setText(" ");
			try {
				
				gmUpdateBalanceShow();
				
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
	
	
	@FXML
	private boolean gmIsDescripionEmpty() {
		if (letterCount(gmtxtDescription.getText()) == 100) {
			return true;
		} else {
			return false;
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























