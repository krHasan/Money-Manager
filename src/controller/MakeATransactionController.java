package controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.swing.LayoutFocusTraversalPolicy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MakeATransactionModel;
import operation.BankIssue;
import operation.GoToOperation;
import system.DateFormatManager;
import system.UnitConverter;
import tab.Bkash;
import tab.Borrow;
import tab.Expense;
import tab.GetMoney;
import tab.Lend;
import tab.Personal;
import tab.Rocket;
import tab.TabAccess;
import tableAndgraph.TableData;

public class MakeATransactionController extends MakeATransactionModel {
	
	@FXML
	private TabPane tabPane;
	
	///////////////////////////////////  Get Money  ////////////////////////////////
	@FXML
	private Tab tabGetMoney;
	
	@FXML
	private AnchorPane gmAnchorPane;
	
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
	private AnchorPane exAnchorPane;
	
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
	@FXML
	private Label exlblLetterRemainmsg;
	
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
	private Label lendlblWalletBalance;
	@FXML
	private Label lendlblTotalLendName;
	@FXML
	private Label lendlblTotalBorrowTk;
	@FXML
	private Label lendlblTotalLendTk;
	@FXML
	private Label lendlblBkBalance;
	@FXML
	private Label lendlblRocBalance;
	
	@FXML
	private DatePicker lenddateDate;
	
	@FXML
	private TabPane lendTabPane;
	
	@FXML
	private TableView<Object> lendTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn lendTblColumnName;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn lendTblColumnDate;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn lendTblColumnAmount;
	
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
	private RadioButton borbtn1;
	@FXML
	private RadioButton borbtn2;
	@FXML
	private RadioButton borbtn3;
	@FXML
	private RadioButton borbtn4;
	
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
	@FXML
	private Label bolblAmountValidationMsg;
	@FXML
	private Label bolblAmountValidationMsg2;
	
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
	private RadioButton lerbtn1;
	@FXML
	private RadioButton lerbtn2;
	@FXML
	private RadioButton lerbtn3;
	@FXML
	private RadioButton lerbtn4;
	
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
	@FXML
	private Label lelblAmountValidationMsg;
	@FXML
	private Label lelblAmountValidationMsg2;
	
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
	private Button bnkbtnSettings;
	
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
	private Label bkAmountValidationMsg;
	
	@FXML
	private RadioButton bkrbtn1;
	@FXML
	private RadioButton bkrbtn2;
	@FXML
	private RadioButton bkrbtn3;
	@FXML
	private RadioButton bkrbtn4;
	@FXML
	private RadioButton bkrbtn5;
	
	/////////////// Rocket //////////////////
	@FXML
	private Tab tabRocket;
	
	@FXML
	private ComboBox<String> roccmboTransactionType;
	@FXML
	private ComboBox<String> roccmboAmountNature;

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
	private Label rocAmountValidationMsg;
	
	@FXML
	private RadioButton rocrbtn1;
	@FXML
	private RadioButton rocrbtn2;
	@FXML
	private RadioButton rocrbtn3;
	@FXML
	private RadioButton rocrbtn4;
	@FXML
	private RadioButton rocrbtn5;
	
	/////////////// Personal //////////////////
	@FXML
	private Tab tabPersonal;
	
	@FXML
	private ComboBox<String> percmboAmountNature;
	
	@FXML
	private TextField pertxtAmount;
	
	@FXML
	private Label perlblAccountBalance;
	@FXML
	private Label perAmountValidationMsg;
	@FXML
	private Label bnkWalletBalance;
	
	
////////////////////////////////////////////   General Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//

	DateFormatManager formatManager = new DateFormatManager();
	
	String dateString = formatManager.toString(LocalDate.now());
	LocalDate date = formatManager.fromString(dateString);
	
	final String InvalidInput = "Invalid Input. Type within 0.00 to 9999999.99";
	
	
	@FXML
	public void initialize() {
		
	}
	
	
	private void showWalletBalance() {
		try {
			gmlblWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			exlblWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			lendlblWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			bnkWalletBalance.setText(addThousandSeparator(getWalletBalance()));
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void returnToDashboard(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) gmbtnGoToDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void loadMethod() {
		try {
			gmcmboMethod.setItems(getMethod());
			gmcmboMethod.getSelectionModel().selectFirst();
			bocmboMethod.setItems(getMethod());
			bocmboMethod.getSelectionModel().selectFirst();
			lecmboMethod.setItems(getMethod());
			lecmboMethod.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void anchorPaneAction(MouseEvent ev) {
		try {
			gmlblWarningMsg.setText("");
			exlblWarningMsg.setText("");
		} catch (Exception e) {}
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
		gmrbtnAgent.setText("Agent");
		gmrbtnAgent.setToggleGroup(gmrbtnGroup);
		gmrbtnAgent.setSelected(true);
		gmrbtnAgent.setUserData("Agent");
		
		gmrbtnSendMoney.setVisible(true);
		gmrbtnSendMoney.setText("Send Money");
		gmrbtnSendMoney.setToggleGroup(gmrbtnGroup);
		gmrbtnSendMoney.setUserData("Send Money");
		
		gmrbtnBranch.setVisible(true);
		gmrbtnBranch.setText("Branch");
		gmrbtnBranch.setToggleGroup(gmrbtnGroup);
		gmrbtnBranch.setUserData("Branch");
		
	}
	

	private String gmGetSelectedrbtnName() {
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
				
				stringData.put("gmTime", timeToSave());
				stringData.put("gmDate", (new DateFormatManager()).toString(gmdateDate.getValue()));
				stringData.put("gmMonth", monthToSave());
				stringData.put("gmAmount", gmtxtAmount.getText());
				
				if ((gmcmboMethod.getValue()).equals("bKash")) {
					stringData.put("gmBankCharge", bkashBnkCharge(gmtxtAmount.getText(), "Cash In"));
				} else if((gmcmboMethod.getValue()).equals("Rocket")){
					stringData.put("gmBankCharge", rocketBnkCharge(gmtxtAmount.getText(), "Cash In", gmGetSelectedrbtnName()));
				} else {
					stringData.put("gmBankCharge", "0.00");
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
					stringData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(gmtxtAmount.getText()));
					setCurrentWalletBalance(gmWalletBalanceAfter(gmtxtAmount.getText()));
				} else {
					stringData.put("gmWalletBalanceAfter", getWalletBalance());
				}
				
				(new GetMoney()).saveGetMoneyData(stringData);
				
				gmInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Your transaction completed successfully.");
				Stage MakeATransactionStage = (Stage) gmbtnSave.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 170);
				confirmationMsg.showAndWait();
				
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) gmbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			}
		}

	}
	
	
	@FXML
	private void gmAmountValidation() {
		if (!validAmount(gmtxtAmount.getText())) {
			
			gmlblWarningMsg.setText(InvalidInput);
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
	
	
	private boolean gmIsDescripionEmpty() {
		if (letterCount(gmtxtDescription.getText()) == 100) {
			return true;
		} else {
			return false;
		}
	}
	
	
////////////////////////////////////////////  Expense Function  ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	private boolean adjustBtnPressed = false;
	String exAdjustBalAfter = null;
	String exAdjustAmount = null;
	
	@FXML
	private void tabExpense() {
		exInitialize();
	}
	
	
	private void exInitialize() {
		exdateDate.setConverter(formatManager);
		exdateDate.setValue(date);
		extxtAmount.clear();
		extxtDescription.clear();
		exlblWarningMsg.setText("");
		exlblLetterRemainmsg.setText("");
		showWalletBalance();
		exLoadSector();
	}
	
	
	@FXML
	private void exGoToSectorBtn(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) exbtnCreateSector.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		(new TabAccess()).setTabName("tabSector");
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void exCancelBtn(ActionEvent event) {
		exInitialize();
	}
	
	
	private void exLoadSector() {
		try {
			excmboSector.setItems(exGetSector());
			excmboSector.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void exAmountValidation() {
		if (!validAmount(extxtAmount.getText())) {
			exlblWarningMsg.setText(InvalidInput);
			extxtAmount.clear();
		} else {
			exlblWarningMsg.setText(" ");
		}
	}
	
	
	@FXML
	private void exDescriptionValidation() {
		int wordRemain = letterCount(extxtDescription.getText());
		
		if (wordRemain<0) {
			extxtDescription.setEditable(false);
			exlblLetterRemainmsg.setText("You cross the limit");
		} else {
			exlblLetterRemainmsg.setText("Word remain: "+wordRemain+" out of 100");
		}
	}
	
	
	private boolean exIsDescripionEmpty() {
		if (letterCount(extxtDescription.getText()) == 100) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@FXML
	private void exAdjustBalance(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Adjust Wallet Balance");
		dialog.setHeaderText("Provide Balance Status at Your Hand Now.");
		dialog.setContentText("Please enter the amount:");
		Stage MakeATransactionStage = (Stage) exbtnAdjustBalance.getScene().getWindow();
		dialog.setX(MakeATransactionStage.getX() + 200);
		dialog.setY(MakeATransactionStage.getY() + 170);
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			String typedAmount = result.get();
			if (!validAmount(typedAmount)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText(InvalidInput);
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			} else if (amountIsZero(typedAmount)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("Zero is not approved.");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			} else {
				adjustBtnPressed = true;
				long dbWalletBalance = currentWalletBalance();
				long typedBalance = stringToLong(typedAmount);
				exAdjustBalAfter = typedAmount;
				if (dbWalletBalance<typedBalance) {
					exAdjustAmount = "added "+longToString(typedBalance - dbWalletBalance)+" to Wallet";
				} else if(dbWalletBalance>typedBalance) {
					exAdjustAmount = exWalletBalanceAfter(typedAmount);
				} else {
					exAdjustAmount = "0.0";
				}
				exSaveFunction();
			}
		}
		adjustBtnPressed = false;
	}
	
	
	@FXML
	private void exSaveBtn(ActionEvent event) {
		if (amountIsZero(extxtAmount.getText())) {
			exlblWarningMsg.setText("Empty or Zero is not approved.");
		} else {
			exSaveFunction();
		}
	}
	
	
	private void exSaveFunction() {
		try {
			Map<String, String> expenseData = new HashMap<>();
			
			expenseData.put("exTime", timeToSave());
			expenseData.put("exDate", (new DateFormatManager()).toString(exdateDate.getValue()));
			expenseData.put("exMonth", monthToSave());
			
			if (adjustBtnPressed) {
				expenseData.put("exAmount", exAdjustAmount);
			} else {
				expenseData.put("exAmount", extxtAmount.getText());
			}
							
			if (adjustBtnPressed) {
				if (exIsDescripionEmpty()) {
					expenseData.put("exDescription", "You have adjusted your Wallet Balance");
				} else {
					expenseData.put("exDescription", extxtDescription.getText());
				}
			} else {
				if (exIsDescripionEmpty()) {
					expenseData.put("exDescription", "None");
				} else {
					expenseData.put("exDescription", extxtDescription.getText());
				}
			}
			
			if (adjustBtnPressed) {
				expenseData.put("exSector", "Adjusted Balance");
			} else {
				expenseData.put("exSector", excmboSector.getValue());
			}

			expenseData.put("exWalletBalanceBefore", getWalletBalance());
			
			if (adjustBtnPressed) {
				expenseData.put("exWalletBalanceAfter", exAdjustBalAfter);
				setCurrentWalletBalance(exAdjustBalAfter);
			} else {
				expenseData.put("exWalletBalanceAfter", exWalletBalanceAfter(extxtAmount.getText()));
				setCurrentWalletBalance(exWalletBalanceAfter(extxtAmount.getText()));
			}
			
			(new Expense()).saveExpenseData(expenseData);
			
			exInitialize();
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Successfull Transaction");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Your transaction completed successfully.");
			Stage MakeATransactionStage = (Stage) exbtnSave.getScene().getWindow();
			confirmationMsg.setX(MakeATransactionStage.getX() + 200);
			confirmationMsg.setY(MakeATransactionStage.getY() + 170);
			confirmationMsg.showAndWait();
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Transaction Failed");
			alert.setHeaderText(null);
			alert.setContentText("There something is wrong.");
			Stage MakeATransactionStage = (Stage) exbtnSave.getScene().getWindow();
			alert.setX(MakeATransactionStage.getX() + 200);
			alert.setY(MakeATransactionStage.getY() + 170);
			alert.showAndWait();
		}
	}
	
		
////////////////////////////////////////////     Lend Function    ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	private String selectedTabName = "Borrow";
	
	@FXML
	private void tabLend() {
		boInitialize();
	}

	
	@FXML
	private void boInitialize() {
		selectedTabName = "Borrow";
		lenddateDate.setConverter(formatManager);
		lenddateDate.setValue(date);
		showBorroTblData();
		showWalletBalance();
		showTotalBorrowTk();
		boLoadType();
		loadMethod();
		boBankChargeShow();
		boLoadRepayPersonName();
		lendBkBalanceShow();
		lendRocBalanceShow();
		bolblPersonName.setText("From Whom :");
		bolblAmountWithCharge.setText("Borrowed Amount :");
		bolblBankChargeName.setText("");
		bolblWarningMsg.setText("");
		bolblExactAmount.setText("");
		bolblAmountNature.setText("");
		botxtFromWhom.clear();
		botxtAmountWithCharge.clear();
		botxtExactAmount.clear();
		boRbtnHide();
		bocmboRepaidPerson.setVisible(false);
		botxtExactAmount.setVisible(false);
		bolblAmountValidationMsg.setText("");
		bolblAmountValidationMsg2.setText("");
		botxtFromWhom.setVisible(true);
		
	}
	
	
	@FXML
	private void leInitialize() {
		selectedTabName = "Lend";
		lenddateDate.setConverter(formatManager);
		lenddateDate.setValue(date);
		showLendTblData();
		showWalletBalance();
		showTotalLendTk();
		leLoadType();
		loadMethod();
		leBankChargeShow();
		leLoadRepayPersonName();
		lendBkBalanceShow();
		lendRocBalanceShow();
		lelblPersonName.setText("To Whom :");
		lelblAmountWithCharge.setText("Lended Amount :");
		lelblBankChargeName.setText("");
		lelblWarningMsg.setText("");
		lelblExactAmount.setText("");
		lelblAmountNature.setText("");
		letxtFromWhom.clear();
		letxtAmountWithCharge.clear();
		letxtExactAmount.clear();
		leRbtnHide();
		lecmboRepaidPerson.setVisible(false);
		letxtExactAmount.setVisible(false);
		lelblAmountValidationMsg.setText("");
		lelblAmountValidationMsg2.setText("");
		letxtFromWhom.setVisible(true);
	}
	
	
	@FXML
	private void LendCancelBtn(ActionEvent event) {
		if (selectedTabName.equals("Borrow")) {
			boInitialize();
		} else {
			leInitialize();
		}
	}

	
	private void lendBkBalanceShow() {
		try {
			lendlblBkBalance.setText(addThousandSeparator(getbkAccountBalance()));
		} catch (Exception e) {}
	}
	
	
	private void lendRocBalanceShow() {
		try {
			lendlblRocBalance.setText(addThousandSeparator(getRocAccountBalance()));
		} catch (Exception e) {}
	}
	
///////////////////////// Borrow ////////////////////////////
	final ToggleGroup boRocInRbtnGroup = new ToggleGroup();
	final ToggleGroup boBkRbtnGroup = new ToggleGroup();
	final ToggleGroup boRocOutRbtnGroup = new ToggleGroup();
	
	@SuppressWarnings("unchecked")
	private void showBorroTblData() {
		lendlblTableHeading.setText("Money Borrow History");
		try {
			lendTblColumnName.setCellValueFactory(new PropertyValueFactory<>("boWhom"));
			lendTblColumnDate.setCellValueFactory(new PropertyValueFactory<>("boDate"));
			lendTblColumnAmount.setCellValueFactory(new PropertyValueFactory<>("boExactTk"));
			lendTable.setItems(new TableData().borrowTableData());
		} catch (Exception e) {}
	}
	
	
	private void showTotalBorrowTk() {
		try {
			lendlblTotalLendName.setText("Total Borrowed Amount :");
			lendlblTotalBorrowTk.setVisible(true);
			lendlblTotalBorrowTk.setText(addThousandSeparator(getTotalBorrowTk()));
			lendlblTotalLendTk.setVisible(false);
		} catch (Exception e) {}
	}
	
	
	private void boLoadType() {
		try {
			bocmboType.setItems(boGetBorrowType());
			bocmboType.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void boLoadRepayPersonName() {
		try {
			bocmboRepaidPerson.setItems(boGetRepayPersonName());
			bocmboRepaidPerson.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void boRepayPersonCmboFunction() {
		bolblAmountValidationMsg.setText("");
		bolblAmountValidationMsg2.setText("");
		bolblWarningMsg.setText("");
		String boRepayPersonBorrowedAmount = new Borrow().boRepayPersonBorrowedAmount(bocmboRepaidPerson.getValue());
		botxtExactAmount.setText(boRepayPersonBorrowedAmount);
		botxtAmountWithCharge.setText(boRepayPersonBorrowedAmount);
	}
	
	
	@FXML
	private void boRepayPersonCmboAction(ActionEvent event) {
		boRepayPersonCmboFunction();
	}
	
	
	@FXML
	private void boTypeAction(ActionEvent event) {
		try {
			borrowAction();
			botxtAmountWithCharge.clear();
			botxtExactAmount.clear();
			botxtFromWhom.clear();
			if (!bocmboType.getValue().equals("Money Take")) {
				boRepayPersonCmboFunction();
			}
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void boMethodAction(ActionEvent event) {
		borrowAction();
	}
	
	
	@FXML
	private void boRbtn1Action() {
		boBankChargeShow();
	}
	
	
	@FXML
	private void boRbtn2Action() {
		boBankChargeShow();
	}
	
	
	@FXML
	private void boRbtn3Action() {
		boBankChargeShow();
	}
	
	
	@FXML
	private void boRbtn4Action() {
		boBankChargeShow();
	}
	
	
	@FXML
	private void boAmountValidation() {
		if (!validAmount(botxtAmountWithCharge.getText())) {	
			bolblAmountValidationMsg.setText(InvalidInput);
			botxtAmountWithCharge.clear();
		} else {
			bolblAmountValidationMsg.setText(" ");
			bolblAmountValidationMsg2.setText(" ");
			try {
				boBankChargeShow();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@FXML
	private void boExactAmountValidation() {
		if (!validAmount(botxtExactAmount.getText())) {	
			bolblAmountValidationMsg2.setText(InvalidInput);
			bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
			botxtExactAmount.clear();
		} else {
			bolblAmountValidationMsg2.setText(" ");
			bolblAmountValidationMsg.setText(" ");
			bolblWarningMsg.setText("");
			try {
				boBankChargeShow();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private String boGetSelectedrbtnName() {
		try {
			if (bocmboType.getValue().equals("Money Take")) {
				if (bocmboMethod.getValue().equals("bKash")) {
					return "Cash In";
				} else if(bocmboMethod.getValue().equals("Rocket")) {
					return (String) boRocInRbtnGroup.getSelectedToggle().getUserData();
				} else {
					return "";
				}
			} else {
				if (bocmboMethod.getValue().equals("bKash")) {
					return (String) boBkRbtnGroup.getSelectedToggle().getUserData();
				} else if(bocmboMethod.getValue().equals("Rocket")) {
					return (String) boRocOutRbtnGroup.getSelectedToggle().getUserData();
				} else {
					return "";
				}
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	
	private String boBankChargeShow() {
		String charge = "0";
		try {
			if (bocmboType.getValue().equals("Money Take")) {
				if (amountIsZero(botxtAmountWithCharge.getText())) {
					if (bocmboMethod.getValue().equals("Hand to Hand")) {
						bolblBankCharge.setText("");
					} else {
						bolblBankCharge.setText("0.00");
					}
				} else {
					if (bocmboMethod.getValue().equals("bKash")) {
						charge = bkashBnkCharge(botxtAmountWithCharge.getText(), "Cash In");
						bolblBankCharge.setText(charge);
					} else if(bocmboMethod.getValue().equals("Rocket")) {
						if (boGetSelectedrbtnName().isEmpty()) {
							charge = rocketBnkCharge(botxtAmountWithCharge.getText(), "Cash In", "Agent");
						} else {
							charge = rocketBnkCharge(botxtAmountWithCharge.getText(), "Cash In", boGetSelectedrbtnName());
						}
						bolblBankCharge.setText(charge);
					} else {
						bolblBankCharge.setText("");
					}
				}
				
			} else {
				
				if (amountIsZero(botxtAmountWithCharge.getText())) {
					if (bocmboMethod.getValue().equals("Hand to Hand")) {
						bolblBankCharge.setText("");
					} else {
						bolblBankCharge.setText("0.00");
					}
				} else {
					if (bocmboMethod.getValue().equals("bKash")) {
						if (boGetSelectedrbtnName().isEmpty()) {
							charge = bkashBnkCharge(botxtAmountWithCharge.getText(), "Send Money");
						} else {
							charge = bkashBnkCharge(botxtAmountWithCharge.getText(), boGetSelectedrbtnName());
						}
						bolblBankCharge.setText(charge);
					} else if(bocmboMethod.getValue().equals("Rocket")) {
						if (boGetSelectedrbtnName().isEmpty()) {
							charge = rocketBnkCharge(botxtAmountWithCharge.getText(), "Cash Out", "Send Money");
						} else {
							charge = rocketBnkCharge(botxtAmountWithCharge.getText(), "Cash Out", boGetSelectedrbtnName());
						}
						bolblBankCharge.setText(charge);
					} else {
						bolblBankCharge.setText("");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return charge;
	}
	
	
	private void boRbtnHide() {
		borbtn1.setVisible(false);
		borbtn2.setVisible(false);
		borbtn3.setVisible(false);
		borbtn4.setVisible(false);
	}
	
	private void boRocInRbtnShow() {
		borbtn1.setVisible(true);
		borbtn1.setText("Agent");
		borbtn1.setToggleGroup(boRocInRbtnGroup);
		borbtn1.setSelected(true);
		borbtn1.setUserData("Agent");
		
		borbtn2.setVisible(true);
		borbtn2.setText("Send Money");
		borbtn2.setToggleGroup(boRocInRbtnGroup);
		borbtn2.setUserData("Send Money");
		
		borbtn3.setVisible(true);
		borbtn3.setText("Branch");
		borbtn3.setToggleGroup(boRocInRbtnGroup);
		borbtn3.setUserData("Branch");
		
		borbtn4.setVisible(false);
	}
	
	
	private void boBkRbtnShow() {
		borbtn1.setVisible(true);
		borbtn1.setText("Send Money");
		borbtn1.setToggleGroup(boBkRbtnGroup);
		borbtn1.setSelected(true);
		borbtn1.setUserData("Send Money");
		
		borbtn2.setVisible(true);
		borbtn2.setText("Cash Out");
		borbtn2.setToggleGroup(boBkRbtnGroup);
		borbtn2.setUserData("Cash Out");
		
		borbtn3.setVisible(true);
		borbtn3.setText("Buy Airtime");
		borbtn3.setToggleGroup(boBkRbtnGroup);
		borbtn3.setUserData("Buy Airtime");
		
		borbtn4.setVisible(true);
		borbtn4.setText("ATM");
		borbtn4.setToggleGroup(boBkRbtnGroup);
		borbtn4.setUserData("ATM");
	}
	

	private void boRocOutRbtnShow() {
		borbtn1.setVisible(true);
		borbtn1.setText("Send Money");
		borbtn1.setToggleGroup(boRocOutRbtnGroup);
		borbtn1.setSelected(true);
		borbtn1.setUserData("Send Money");
		
		borbtn2.setVisible(true);
		borbtn2.setText("TopUp");
		borbtn2.setToggleGroup(boRocOutRbtnGroup);
		borbtn2.setUserData("TopUp");
		
		borbtn3.setVisible(true);
		borbtn3.setText("ATM");
		borbtn3.setToggleGroup(boRocOutRbtnGroup);
		borbtn3.setUserData("ATM");
		
		borbtn4.setVisible(false);
	}
	
	
	private void borrowAction() {
		try {
			if (bocmboType.getValue().equals("Money Take")) {
				
				if (bocmboMethod.getValue().equals("bKash")) {
					bolblPersonName.setText("From Whom :");
					bolblAmountWithCharge.setText("Amount With Charge :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Amount Without Charge :");
					bolblAmountNature.setText("");
					boRbtnHide();
					boBankChargeShow();
					bocmboRepaidPerson.setVisible(false);
					botxtExactAmount.setVisible(true);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(true);
				} else if (bocmboMethod.getValue().equals("Rocket")) {
					bolblPersonName.setText("From Whom :");
					bolblAmountWithCharge.setText("Amount With Charge :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Amount Without Charge :");
					bolblAmountNature.setText("Cash In From");
					boBankChargeShow();
					boRocInRbtnShow();
					bocmboRepaidPerson.setVisible(false);
					botxtExactAmount.setVisible(true);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(true);
				} else {
					bolblPersonName.setText("From Whom :");
					bolblAmountWithCharge.setText("Borrowed Amount :");
					bolblBankChargeName.setText("");
					bolblWarningMsg.setText("");
					bolblExactAmount.setText("");
					bolblAmountNature.setText("");
					boBankChargeShow();
					boRbtnHide();
					bocmboRepaidPerson.setVisible(false);
					botxtExactAmount.setVisible(false);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(true);
				}
				
			} else {
				
				if (bocmboMethod.getValue().equals("bKash")) {
					bolblPersonName.setText("Return to :");
					bolblAmountWithCharge.setText("Amount With Charge :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Amount Without Charge :");
					bolblAmountNature.setText("Cash Return Using");
					boBankChargeShow();
					boBkRbtnShow();
					bocmboRepaidPerson.setVisible(true);
					boLoadRepayPersonName();
					botxtExactAmount.setVisible(true);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(false);
				} else if (bocmboMethod.getValue().equals("Rocket")) {
					bolblPersonName.setText("Return to :");
					bolblAmountWithCharge.setText("Amount With Charge :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Amount Without Charge :");
					bolblAmountNature.setText("Cash Return Using");
					boBankChargeShow();
					boRocOutRbtnShow();
					bocmboRepaidPerson.setVisible(true);
					boLoadRepayPersonName();
					botxtExactAmount.setVisible(true);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(false);
				} else {
					bolblPersonName.setText("Return to :");
					bolblAmountWithCharge.setText("Returnable Amount :");
					bolblBankChargeName.setText("");
					bolblWarningMsg.setText("");
					bolblExactAmount.setText("");
					bolblAmountNature.setText("");
					boBankChargeShow();
					boRbtnHide();
					bocmboRepaidPerson.setVisible(true);
					boLoadRepayPersonName();
					botxtExactAmount.setVisible(false);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(false);
				}
			}
		} catch (Exception e) {}
	}
	
	
///////////////////////// Lend ////////////////////////////
	final ToggleGroup leRocInRbtnGroup = new ToggleGroup();
	final ToggleGroup leBkRbtnGroup = new ToggleGroup();
	final ToggleGroup leRocOutRbtnGroup = new ToggleGroup();
	
	@SuppressWarnings("unchecked")
	private void showLendTblData() {
		lendlblTableHeading.setText("Money Lend History");
		try {
			lendTblColumnName.setCellValueFactory(new PropertyValueFactory<>("leWhom"));
			lendTblColumnDate.setCellValueFactory(new PropertyValueFactory<>("leDate"));
			lendTblColumnAmount.setCellValueFactory(new PropertyValueFactory<>("leExactTk"));
			lendTable.setItems(new TableData().lendTableData());
		} catch (Exception e) {}
	}

	
	private void showTotalLendTk() {
		try {
			lendlblTotalLendName.setText("Total Lended Amount :");
			lendlblTotalLendTk.setVisible(true);
			lendlblTotalLendTk.setText(addThousandSeparator(getTotalLendTk()));
			lendlblTotalBorrowTk.setVisible(false);
		} catch (Exception e) {}
	}

	
	private void leLoadType() {
		try {
			lecmboType.setItems(leGetLendType());
			lecmboType.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void leLoadRepayPersonName() {
		try {
			lecmboRepaidPerson.setItems(leGetRepayPersonName());
			lecmboRepaidPerson.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void leRepayPersonCmboFunction() {
		lelblAmountValidationMsg.setText("");
		lelblAmountValidationMsg2.setText("");
		lelblWarningMsg.setText("");
		String leRepayPersonLendedAmount = new Lend().leRepayPersonLendedAmount(lecmboRepaidPerson.getValue());
		letxtExactAmount.setText(leRepayPersonLendedAmount);
		letxtAmountWithCharge.setText(leRepayPersonLendedAmount);
	}
	
	@FXML
	private void leRepayPersonCmboAction(ActionEvent event) {
		leRepayPersonCmboFunction();
	}
	
	
	@FXML
	private void leTypeAction(ActionEvent event) {
		try {
			lendAction();
			letxtAmountWithCharge.clear();
			letxtExactAmount.clear();
			letxtFromWhom.clear();
			if (!lecmboType.getValue().equals("Give Money")) {
				leRepayPersonCmboFunction();
			}
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void leMethodAction(ActionEvent event) {
		lendAction();
	}
	
	
	@FXML
	private void leRbtn1Action() {
		leBankChargeShow();
	}
	
	
	@FXML
	private void leRbtn2Action() {
		leBankChargeShow();
	}
	
	
	@FXML
	private void leRbtn3Action() {
		leBankChargeShow();
	}
	
	
	@FXML
	private void leRbtn4Action() {
		leBankChargeShow();
	}
	
	
	@FXML
	private void leAmountValidation() {
		if (!validAmount(letxtAmountWithCharge.getText())) {	
			lelblAmountValidationMsg.setText(InvalidInput);
			letxtAmountWithCharge.clear();
		} else {
			lelblAmountValidationMsg.setText(" ");
			lelblAmountValidationMsg2.setText(" ");
			try {
				leBankChargeShow();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@FXML
	private void leExactAmountValidation() {
		if (!validAmount(letxtExactAmount.getText())) {	
			lelblAmountValidationMsg2.setText(InvalidInput);
			lelblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
			letxtExactAmount.clear();
		} else {
			lelblAmountValidationMsg2.setText(" ");
			lelblAmountValidationMsg.setText(" ");
			lelblWarningMsg.setText("");
			try {
				leBankChargeShow();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private String leGetSelectedrbtnName() {
		try {
			if (lecmboType.getValue().equals("Give Money")) {
				if (lecmboMethod.getValue().equals("bKash")) {
					return (String) leBkRbtnGroup.getSelectedToggle().getUserData();
				} else if(lecmboMethod.getValue().equals("Rocket")) {
					return (String) leRocOutRbtnGroup.getSelectedToggle().getUserData();
				} else {
					return "";
				}
			} else {
				if (lecmboMethod.getValue().equals("bKash")) {
					return "Cash In";
				} else if(lecmboMethod.getValue().equals("Rocket")) {
					return (String) leRocInRbtnGroup.getSelectedToggle().getUserData();
				} else {
					return "";
				}
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	
	private String leBankChargeShow() {
		String charge = "0";
		try {
			if (lecmboType.getValue().equals("Give Money")) {
				if (amountIsZero(letxtAmountWithCharge.getText())) {
					if (lecmboMethod.getValue().equals("Hand to Hand")) {
						lelblBankCharge.setText("");
					} else {
						lelblBankCharge.setText("0.00");
					}
				} else {
					if (lecmboMethod.getValue().equals("bKash")) {
						if (leGetSelectedrbtnName().isEmpty()) {
							charge = bkashBnkCharge(letxtAmountWithCharge.getText(), "Send Money");
						} else {
							charge = bkashBnkCharge(letxtAmountWithCharge.getText(), leGetSelectedrbtnName());
						}
						lelblBankCharge.setText(charge);
					} else if(lecmboMethod.getValue().equals("Rocket")) {
						if (leGetSelectedrbtnName().isEmpty()) {
							charge = rocketBnkCharge(letxtAmountWithCharge.getText(), "Cash Out", "Send Money");
						} else {
							charge = rocketBnkCharge(letxtAmountWithCharge.getText(), "Cash Out", leGetSelectedrbtnName());
						}
						lelblBankCharge.setText(charge);
					} else {
						lelblBankCharge.setText("");
					}
				}
				
			} else {
				
				if (amountIsZero(letxtAmountWithCharge.getText())) {
					if (lecmboMethod.getValue().equals("Hand to Hand")) {
						lelblBankCharge.setText("");
					} else {
						lelblBankCharge.setText("0.00");
					}
				} else {
					if (lecmboMethod.getValue().equals("bKash")) {
						charge = bkashBnkCharge(letxtAmountWithCharge.getText(), "Cash In");
						lelblBankCharge.setText(charge);
					} else if(lecmboMethod.getValue().equals("Rocket")) {
						if (leGetSelectedrbtnName().isEmpty()) {
							charge = rocketBnkCharge(letxtAmountWithCharge.getText(), "Cash In", "Agent");
						} else {
							charge = rocketBnkCharge(letxtAmountWithCharge.getText(), "Cash In", leGetSelectedrbtnName());
						}
						lelblBankCharge.setText(charge);
					} else {
						lelblBankCharge.setText("");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return charge;
	}
	
	
	private void leRbtnHide() {
		lerbtn1.setVisible(false);
		lerbtn2.setVisible(false);
		lerbtn3.setVisible(false);
		lerbtn4.setVisible(false);
	}
	
	
	private void leRocInRbtnShow() {
		lerbtn1.setVisible(true);
		lerbtn1.setText("Agent");
		lerbtn1.setToggleGroup(leRocInRbtnGroup);
		lerbtn1.setSelected(true);
		lerbtn1.setUserData("Agent");
		
		lerbtn2.setVisible(true);
		lerbtn2.setText("Send Money");
		lerbtn2.setToggleGroup(leRocInRbtnGroup);
		lerbtn2.setUserData("Send Money");
		
		lerbtn3.setVisible(true);
		lerbtn3.setText("Branch");
		lerbtn3.setToggleGroup(leRocInRbtnGroup);
		lerbtn3.setUserData("Branch");
		
		lerbtn4.setVisible(false);
	}
	
	
	private void leBkRbtnShow() {
		lerbtn1.setVisible(true);
		lerbtn1.setText("Send Money");
		lerbtn1.setToggleGroup(leBkRbtnGroup);
		lerbtn1.setSelected(true);
		lerbtn1.setUserData("Send Money");
		
		lerbtn2.setVisible(true);
		lerbtn2.setText("Cash Out");
		lerbtn2.setToggleGroup(leBkRbtnGroup);
		lerbtn2.setUserData("Cash Out");
		
		lerbtn3.setVisible(true);
		lerbtn3.setText("Buy Airtime");
		lerbtn3.setToggleGroup(leBkRbtnGroup);
		lerbtn3.setUserData("Buy Airtime");
		
		lerbtn4.setVisible(true);
		lerbtn4.setText("ATM");
		lerbtn4.setToggleGroup(leBkRbtnGroup);
		lerbtn4.setUserData("ATM");
	}
	

	private void leRocOutRbtnShow() {
		lerbtn1.setVisible(true);
		lerbtn1.setText("Send Money");
		lerbtn1.setToggleGroup(leRocOutRbtnGroup);
		lerbtn1.setSelected(true);
		lerbtn1.setUserData("Send Money");
		
		lerbtn2.setVisible(true);
		lerbtn2.setText("TopUp");
		lerbtn2.setToggleGroup(leRocOutRbtnGroup);
		lerbtn2.setUserData("TopUp");
		
		lerbtn3.setVisible(true);
		lerbtn3.setText("ATM");
		lerbtn3.setToggleGroup(leRocOutRbtnGroup);
		lerbtn3.setUserData("ATM");
		
		lerbtn4.setVisible(false);
	}
	
	
	private void lendAction() {
		try {
			if (lecmboType.getValue().equals("Give Money")) {
				
				if (lecmboMethod.getValue().equals("bKash")) {
					lelblPersonName.setText("To Whom :");
					lelblAmountWithCharge.setText("Amount With Charge :");
					lelblBankChargeName.setText("Bank Charge");
					lelblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					lelblExactAmount.setText("Amount Without Charge :");
					lelblAmountNature.setText("Cash Given Using");
					leBkRbtnShow();
					leBankChargeShow();
					lecmboRepaidPerson.setVisible(false);
					letxtExactAmount.setVisible(true);
					lelblAmountValidationMsg.setText("");
					lelblAmountValidationMsg2.setText("");
					letxtFromWhom.setVisible(true);
				} else if (lecmboMethod.getValue().equals("Rocket")) {
					lelblPersonName.setText("To Whom :");
					lelblAmountWithCharge.setText("Amount With Charge :");
					lelblBankChargeName.setText("Bank Charge");
					lelblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					lelblExactAmount.setText("Amount Without Charge :");
					lelblAmountNature.setText("Cash Given Using");
					leBankChargeShow();
					leRocOutRbtnShow();
					lecmboRepaidPerson.setVisible(false);
					letxtExactAmount.setVisible(true);
					lelblAmountValidationMsg.setText("");
					lelblAmountValidationMsg2.setText("");
					letxtFromWhom.setVisible(true);
				} else {
					lelblPersonName.setText("To Whom :");
					lelblAmountWithCharge.setText("Lended Amount :");
					lelblBankChargeName.setText("");
					lelblWarningMsg.setText("");
					lelblExactAmount.setText("");
					lelblAmountNature.setText("");
					leBankChargeShow();
					leRbtnHide();
					lecmboRepaidPerson.setVisible(false);
					letxtExactAmount.setVisible(false);
					lelblAmountValidationMsg.setText("");
					lelblAmountValidationMsg2.setText("");
					letxtFromWhom.setVisible(true);
				}
				
			} else {
				
				if (lecmboMethod.getValue().equals("bKash")) {
					lelblPersonName.setText("Take Back From :");
					lelblAmountWithCharge.setText("Amount With Charge :");
					lelblBankChargeName.setText("Bank Charge");
					lelblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					lelblExactAmount.setText("Amount Without Charge :");
					lelblAmountNature.setText("");
					leBankChargeShow();
					leRbtnHide();
					lecmboRepaidPerson.setVisible(true);
					leLoadRepayPersonName();
					letxtExactAmount.setVisible(true);
					lelblAmountValidationMsg.setText("");
					lelblAmountValidationMsg2.setText("");
					letxtFromWhom.setVisible(false);
				} else if (lecmboMethod.getValue().equals("Rocket")) {
					lelblPersonName.setText("Take Back From :");
					lelblAmountWithCharge.setText("Amount With Charge :");
					lelblBankChargeName.setText("Bank Charge");
					lelblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					lelblExactAmount.setText("Amount Without Charge :");
					lelblAmountNature.setText("Cash Take Back Using");
					leBankChargeShow();
					leRocInRbtnShow();
					lecmboRepaidPerson.setVisible(true);
					leLoadRepayPersonName();
					letxtExactAmount.setVisible(true);
					lelblAmountValidationMsg.setText("");
					lelblAmountValidationMsg2.setText("");
					letxtFromWhom.setVisible(false);
				} else {
					lelblPersonName.setText("Take Back From :");
					lelblAmountWithCharge.setText("Take Back Amount :");
					lelblBankChargeName.setText("");
					lelblWarningMsg.setText("");
					lelblExactAmount.setText("");
					lelblAmountNature.setText("");
					leBankChargeShow();
					leRbtnHide();
					lecmboRepaidPerson.setVisible(true);
					leLoadRepayPersonName();
					letxtExactAmount.setVisible(false);
					lelblAmountValidationMsg.setText("");
					lelblAmountValidationMsg2.setText("");
					letxtFromWhom.setVisible(false);
				}
			}
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void lendSaveBtn(ActionEvent event) {
		Map<String, String> boleData = new HashMap<>();
		
		try {
			
			if (selectedTabName.equals("Borrow")) {
				
				if (bocmboType.getValue().equals("Money Take")) {
							// Borrow, Money Take, bKash
					if (bocmboMethod.getValue().equals("bKash")) {
						if (amountIsZero(botxtAmountWithCharge.getText()) || letterCount(botxtFromWhom.getText())==100 || amountIsZero(botxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							boleData.put("boTime", timeToSave());
							boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("boMonth", monthToSave());
							boleData.put("boType", bocmboType.getValue());
							boleData.put("boMethod", bocmboMethod.getValue());
							boleData.put("boWhom", botxtFromWhom.getText());
							boleData.put("boTk", botxtAmountWithCharge.getText());
							boleData.put("boNature", "None");
							boleData.put("boBnkCharge", boBankChargeShow());
							boleData.put("boBalanceBefore", longToString(currentbKashBalance()));
							boleData.put("boBalanceAfter", updatedbKashBalance(botxtAmountWithCharge.getText(), "Cash In"));
							boleData.put("boExactTk", botxtExactAmount.getText());
							
							(new Borrow()).saveBorrowData(boleData);
							(new Borrow()).addBorrowSummaryData(boleData);
							setCurrentbKashBalance(updatedbKashBalance(botxtAmountWithCharge.getText(), "Cash In"));
//							setCurrentbKashBalance(boBkBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Money Take"));
							setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(), "Money Take"));
							boInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Your transaction completed successfully.");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 170);
							confirmationMsg.showAndWait();
							
						}	// Borrow, Money Take, Rocket
					} else if(bocmboMethod.getValue().equals("Rocket")) {
						if (amountIsZero(botxtAmountWithCharge.getText()) || letterCount(botxtFromWhom.getText())==100 || amountIsZero(botxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							boleData.put("boTime", timeToSave());
							boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("boMonth", monthToSave());
							boleData.put("boType", bocmboType.getValue());
							boleData.put("boMethod", bocmboMethod.getValue());
							boleData.put("boWhom", botxtFromWhom.getText());
							boleData.put("boTk", botxtAmountWithCharge.getText());
							boleData.put("boNature", boGetSelectedrbtnName());
							boleData.put("boBnkCharge", boBankChargeShow());
							boleData.put("boBalanceBefore", longToString(currentRocketBalance()));
							boleData.put("boBalanceAfter", updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash In", boGetSelectedrbtnName()));
							boleData.put("boExactTk", botxtExactAmount.getText());
							
							(new Borrow()).saveBorrowData(boleData);
							(new Borrow()).addBorrowSummaryData(boleData);
							setCurrentRocketBalance(updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash In", boGetSelectedrbtnName()));
//							setCurrentRocketBalance(boRocBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Money Take"));
							setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(), "Money Take"));
							boInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Your transaction completed successfully.");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 170);
							confirmationMsg.showAndWait();
						}
					} else { // Borrow, Money Take, Hand to Hand
						if (amountIsZero(botxtAmountWithCharge.getText()) || letterCount(botxtFromWhom.getText())==100) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							boleData.put("boTime", timeToSave());
							boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("boMonth", monthToSave());
							boleData.put("boType", bocmboType.getValue());
							boleData.put("boMethod", bocmboMethod.getValue());
							boleData.put("boWhom", botxtFromWhom.getText());
							boleData.put("boTk", botxtAmountWithCharge.getText());
							boleData.put("boNature", "None");
							boleData.put("boBnkCharge", "None");
							boleData.put("boBalanceBefore", longToString(currentWalletBalance()));
							boleData.put("boBalanceAfter", gmWalletBalanceAfter(botxtAmountWithCharge.getText()));
							boleData.put("boExactTk", botxtAmountWithCharge.getText());
							
							(new Borrow()).saveBorrowData(boleData);
							(new Borrow()).addBorrowSummaryData(boleData);
							setCurrentWalletBalance(gmWalletBalanceAfter(botxtAmountWithCharge.getText()));
							setTotalBorrowTk(updatedTotalBorrowTk(botxtAmountWithCharge.getText(), "Money Take"));
							boInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Your transaction completed successfully.");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 170);
							confirmationMsg.showAndWait();
						}
					}
					
				} else {
							// Borrow, Return Borrowed Money, bKash
					if (bocmboMethod.getValue().equals("bKash")) {
						if (amountIsZero(botxtAmountWithCharge.getText()) || amountIsZero(botxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							if (boRepayValidation(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
								boleData.put("boTime", timeToSave());
								boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("boMonth", monthToSave());
								boleData.put("boType", bocmboType.getValue());
								boleData.put("boMethod", bocmboMethod.getValue());
								boleData.put("boWhom", bocmboRepaidPerson.getValue());
								boleData.put("boTk", botxtAmountWithCharge.getText());
								boleData.put("boNature", boGetSelectedrbtnName());
								boleData.put("boBnkCharge", boBankChargeShow());
								boleData.put("boBalanceBefore", longToString(currentbKashBalance()));
								boleData.put("boBalanceAfter", updatedbKashBalance(botxtAmountWithCharge.getText(), boGetSelectedrbtnName()));
								boleData.put("boExactTk", botxtExactAmount.getText());
								
								(new Borrow()).saveBorrowData(boleData);
								if (boisTypedAmountLessThanBorrowed(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
									(new Borrow()).updateBorrowSummaryData(boleData);
								} else {
									(new Borrow()).deleteBorrowSummaryData(boleData);
								}
								setCurrentbKashBalance(updatedbKashBalance(botxtAmountWithCharge.getText(), boGetSelectedrbtnName()));
//								setCurrentbKashBalance(boBkBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Return Borrowed Money"));
								setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(),"Return Borrowed Money"));
								boInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Your transaction completed successfully.");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 170);
								confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
								alert.showAndWait();
							}
						}  // Borrow, Return Borrowed Money, Rocket
					} else if(bocmboMethod.getValue().equals("Rocket")) {
						if (amountIsZero(botxtAmountWithCharge.getText()) || amountIsZero(botxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							if (boRepayValidation(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
								boleData.put("boTime", timeToSave());
								boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("boMonth", monthToSave());
								boleData.put("boType", bocmboType.getValue());
								boleData.put("boMethod", bocmboMethod.getValue());
								boleData.put("boWhom", bocmboRepaidPerson.getValue());
								boleData.put("boTk", botxtAmountWithCharge.getText());
								boleData.put("boNature", boGetSelectedrbtnName());
								boleData.put("boBnkCharge", boBankChargeShow());
								boleData.put("boBalanceBefore", longToString(currentRocketBalance()));
								boleData.put("boBalanceAfter", updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash Out", boGetSelectedrbtnName()));
								boleData.put("boExactTk", botxtExactAmount.getText());
								
								(new Borrow()).saveBorrowData(boleData);
								if (boisTypedAmountLessThanBorrowed(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
									(new Borrow()).updateBorrowSummaryData(boleData);
								} else {
									(new Borrow()).deleteBorrowSummaryData(boleData);
								}
								setCurrentRocketBalance(updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash Out", boGetSelectedrbtnName()));
//								setCurrentRocketBalance(boRocBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Return Borrowed Money"));
								setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(),"Return Borrowed Money"));
								boInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Your transaction completed successfully.");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 170);
								confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
								alert.showAndWait();
							}
						}
					} else { // Borrow, Return Borrowed Money, Hand to Hand
						if (amountIsZero(botxtAmountWithCharge.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							if (boRepayValidation(botxtAmountWithCharge.getText(), bocmboRepaidPerson.getValue())) {
								boleData.put("boTime", timeToSave());
								boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("boMonth", monthToSave());
								boleData.put("boType", bocmboType.getValue());
								boleData.put("boMethod", bocmboMethod.getValue());
								boleData.put("boWhom", bocmboRepaidPerson.getValue());
								boleData.put("boTk", botxtAmountWithCharge.getText());
								boleData.put("boNature", "None");
								boleData.put("boBnkCharge", "None");
								boleData.put("boBalanceBefore", longToString(currentWalletBalance()));
								boleData.put("boBalanceAfter", exWalletBalanceAfter(botxtAmountWithCharge.getText()));
								boleData.put("boExactTk", botxtAmountWithCharge.getText());
								
								(new Borrow()).saveBorrowData(boleData);
								if (boisTypedAmountLessThanBorrowed(botxtAmountWithCharge.getText(), bocmboRepaidPerson.getValue())) {
									(new Borrow()).updateBorrowSummaryData(boleData);
								} else {
									(new Borrow()).deleteBorrowSummaryData(boleData);
								}
								setCurrentWalletBalance(exWalletBalanceAfter(botxtAmountWithCharge.getText()));
								setTotalBorrowTk(updatedTotalBorrowTk(botxtAmountWithCharge.getText(),"Return Borrowed Money"));
								boInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Your transaction completed successfully.");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 170);
								confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
								alert.showAndWait();
							}
						}
					}
				}
				
			} else {

				if (lecmboType.getValue().equals("Give Money")) {
							// Lend, Give Money, bKash
					if (lecmboMethod.getValue().equals("bKash")) {
						if (amountIsZero(letxtAmountWithCharge.getText()) || letterCount(letxtFromWhom.getText())==100 || amountIsZero(letxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							boleData.put("leTime", timeToSave());
							boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("leMonth", monthToSave());
							boleData.put("leType", lecmboType.getValue());
							boleData.put("leMethod", lecmboMethod.getValue());
							boleData.put("leWhom", letxtFromWhom.getText());
							boleData.put("leTk", letxtAmountWithCharge.getText());
							boleData.put("leNature", leGetSelectedrbtnName());
							boleData.put("leBnkCharge", leBankChargeShow());
							boleData.put("leBalanceBefore", longToString(currentbKashBalance()));
							boleData.put("leBalanceAfter", updatedbKashBalance(letxtAmountWithCharge.getText(), leGetSelectedrbtnName()));
							boleData.put("leExactTk", letxtExactAmount.getText());
							
							(new Lend()).saveLendData(boleData);
							(new Lend()).addLendSummaryData(boleData);
							setCurrentbKashBalance(updatedbKashBalance(letxtAmountWithCharge.getText(), leGetSelectedrbtnName()));
//							setCurrentbKashBalance(leBkBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Give Money"));
							setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(), "Give Money"));
							leInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Your transaction completed successfully.");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 170);
							confirmationMsg.showAndWait();
						}	// Lend, Give Money, Rocket
					} else if(lecmboMethod.getValue().equals("Rocket")) {
						if (amountIsZero(letxtAmountWithCharge.getText()) || letterCount(letxtFromWhom.getText())==100 || amountIsZero(letxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							boleData.put("leTime", timeToSave());
							boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("leMonth", monthToSave());
							boleData.put("leType", lecmboType.getValue());
							boleData.put("leMethod", lecmboMethod.getValue());
							boleData.put("leWhom", letxtFromWhom.getText());
							boleData.put("leTk", letxtAmountWithCharge.getText());
							boleData.put("leNature", leGetSelectedrbtnName());
							boleData.put("leBnkCharge", leBankChargeShow());
							boleData.put("leBalanceBefore", longToString(currentRocketBalance()));
							boleData.put("leBalanceAfter", updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash Out", leGetSelectedrbtnName()));
							boleData.put("leExactTk", letxtExactAmount.getText());
							
							(new Lend()).saveLendData(boleData);
							(new Lend()).addLendSummaryData(boleData);
							setCurrentRocketBalance(updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash Out", leGetSelectedrbtnName()));
//							setCurrentRocketBalance(leRocBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Give Money"));
							setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(), "Give Money"));
							leInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Your transaction completed successfully.");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 170);
							confirmationMsg.showAndWait();
						}	
					} else {  // Lend, Give Money, Hand to Hand
						if (amountIsZero(letxtAmountWithCharge.getText()) || letterCount(letxtFromWhom.getText())==100) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							boleData.put("leTime", timeToSave());
							boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("leMonth", monthToSave());
							boleData.put("leType", lecmboType.getValue());
							boleData.put("leMethod", lecmboMethod.getValue());
							boleData.put("leWhom", letxtFromWhom.getText());
							boleData.put("leTk", letxtAmountWithCharge.getText());
							boleData.put("leNature", "None");
							boleData.put("leBnkCharge", "None");
							boleData.put("leBalanceBefore", longToString(currentWalletBalance()));
							boleData.put("leBalanceAfter", exWalletBalanceAfter(letxtAmountWithCharge.getText()));
							boleData.put("leExactTk", letxtAmountWithCharge.getText());
							
							(new Lend()).saveLendData(boleData);
							(new Lend()).addLendSummaryData(boleData);
							setCurrentWalletBalance(exWalletBalanceAfter(letxtAmountWithCharge.getText()));
							setTotalLendTk(updatedTotalLendTk(letxtAmountWithCharge.getText(), "Give Money"));
							leInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Your transaction completed successfully.");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 170);
							confirmationMsg.showAndWait();
						}	
					}
					
				} else {
							 // Lend, Take Back Lended Money, bKash
					if (lecmboMethod.getValue().equals("bKash")) {
						if (amountIsZero(letxtAmountWithCharge.getText()) || amountIsZero(letxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							if (leRepayValidation(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
								boleData.put("leTime", timeToSave());
								boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("leMonth", monthToSave());
								boleData.put("leType", lecmboType.getValue());
								boleData.put("leMethod", lecmboMethod.getValue());
								boleData.put("leWhom", lecmboRepaidPerson.getValue());
								boleData.put("leTk", letxtAmountWithCharge.getText());
								boleData.put("leNature", leGetSelectedrbtnName());
								boleData.put("leBnkCharge", leBankChargeShow());
								boleData.put("leBalanceBefore", longToString(currentbKashBalance()));
								boleData.put("leBalanceAfter", updatedbKashBalance(letxtAmountWithCharge.getText(), "Cash In"));
								boleData.put("leExactTk", letxtExactAmount.getText());
								
								(new Lend()).saveLendData(boleData);
								if (leisTypedAmountLessThanLended(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
									(new Lend()).updateLendSummaryData(boleData);
								} else {
									(new Lend()).deleteLendSummaryData(boleData);
								}
								setCurrentbKashBalance(updatedbKashBalance(letxtAmountWithCharge.getText(), "Cash In"));
//								setCurrentbKashBalance(leBkBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Take Back Lended Money"));
								setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(),"Take Back Lended Money"));
								leInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Your transaction completed successfully.");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 170);
								confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
								alert.showAndWait();
							}
						} 	 // Lend, Take Back Lended Money, Rocket
					} else if(lecmboMethod.getValue().equals("Rocket")) {
						if (amountIsZero(letxtAmountWithCharge.getText()) || amountIsZero(letxtExactAmount.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							if (leRepayValidation(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
								boleData.put("leTime", timeToSave());
								boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("leMonth", monthToSave());
								boleData.put("leType", lecmboType.getValue());
								boleData.put("leMethod", lecmboMethod.getValue());
								boleData.put("leWhom", lecmboRepaidPerson.getValue());
								boleData.put("leTk", letxtAmountWithCharge.getText());
								boleData.put("leNature", leGetSelectedrbtnName());
								boleData.put("leBnkCharge", leBankChargeShow());
								boleData.put("leBalanceBefore", longToString(currentRocketBalance()));
								boleData.put("leBalanceAfter", updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash In", leGetSelectedrbtnName()));
								boleData.put("leExactTk", letxtExactAmount.getText());
								
								(new Lend()).saveLendData(boleData);
								if (leisTypedAmountLessThanLended(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
									(new Lend()).updateLendSummaryData(boleData);
								} else {
									(new Lend()).deleteLendSummaryData(boleData);
								}
								setCurrentRocketBalance(updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash In", leGetSelectedrbtnName()));
//								setCurrentRocketBalance(leRocBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Take Back Lended Money"));
								setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(),"Take Back Lended Money"));
								leInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Your transaction completed successfully.");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 170);
								confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
								alert.showAndWait();
							}
						}
					} else { // Lend, Take Back Lended Money, Hand to Hand
						if (amountIsZero(letxtAmountWithCharge.getText())) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Transaction Failed");
							alert.setHeaderText(null);
							alert.setContentText("Zero or Empty is not allowed");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							alert.setX(MakeATransactionStage.getX() + 200);
							alert.setY(MakeATransactionStage.getY() + 170);
							alert.showAndWait();
						} else {
							if (leRepayValidation(letxtAmountWithCharge.getText(), lecmboRepaidPerson.getValue())) {
								boleData.put("leTime", timeToSave());
								boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("leMonth", monthToSave());
								boleData.put("leType", lecmboType.getValue());
								boleData.put("leMethod", lecmboMethod.getValue());
								boleData.put("leWhom", lecmboRepaidPerson.getValue());
								boleData.put("leTk", letxtAmountWithCharge.getText());
								boleData.put("leNature", "None");
								boleData.put("leBnkCharge", "None");
								boleData.put("leBalanceBefore", longToString(currentWalletBalance()));
								boleData.put("leBalanceAfter", gmWalletBalanceAfter(letxtAmountWithCharge.getText()));
								boleData.put("leExactTk", letxtAmountWithCharge.getText());
								
								(new Lend()).saveLendData(boleData);
								if (leisTypedAmountLessThanLended(letxtAmountWithCharge.getText(), lecmboRepaidPerson.getValue())) {
									(new Lend()).updateLendSummaryData(boleData);
								} else {
									(new Lend()).deleteLendSummaryData(boleData);
								}
								setCurrentWalletBalance(gmWalletBalanceAfter(letxtAmountWithCharge.getText()));
								setTotalLendTk(updatedTotalLendTk(letxtAmountWithCharge.getText(),"Take Back Lended Money"));
								leInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Your transaction completed successfully.");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 170);
								confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than lended amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
								alert.showAndWait();
							}
						}
					}
					
				}
				
			}
			
		} catch (Exception e) {}
	}
	
	
////////////////////////////////////////////     Bank Function    ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	String bnkSelectedTabName = "bKash";
	
	@FXML
	private void tabBank() {
		if (!new Bkash().isbKashActivated()) {
			tabbKash.setDisable(true);
		}
		if (!new Rocket().isRocketActivated()) {
			tabRocket.setDisable(true);
		}
		if (new Bkash().isbKashActivated()) {
			bkInitialize();
		} else if (new Rocket().isRocketActivated()) {
			rocInitialize();
		} else {
			perInitialize();
		}
	}
	
	
	@FXML
	private void bkInitialize() {
		bnkSelectedTabName = "bKash";
		bnkdateDate.setConverter(formatManager);
		bnkdateDate.setValue(date);
		bkLoadType();
		bkLoadNature();
		bkAccountBalanceShow();
		showWalletBalance();
		bklblBankChargeName.setText("");
		bklblBankCharge.setText("");
		bklblAmountNature.setText("");
		bklblUpdateBalance.setText("");
		bkAmountValidationMsg.setText("");
		bkRbtnHide();
		bktxtAmount.clear();
	}
	
	
	@FXML
	private void rocInitialize() {
		bnkSelectedTabName = "Rocket";
		bnkdateDate.setConverter(formatManager);
		bnkdateDate.setValue(date);
		rocLoadType();
		rocLoadNature();
		rocAccountBalanceShow();
		showWalletBalance();
		roclblBankChargeName.setText("Bank Charge");
		roclblBankCharge.setText("0.00");
		roclblAmountNature.setText("Cash Credited By");
		roclblUpdateBalance.setText("");
		rocAmountValidationMsg.setText("");
		rocInRbtnShow();
		roctxtAmount.clear();
	}
	
	
	@FXML
	private void perInitialize() {
		bnkSelectedTabName = "Personal";
		bnkdateDate.setConverter(formatManager);
		bnkdateDate.setValue(date);
		perLoadNature();
		perAccountBalanceShow();
		showWalletBalance();
	}
	
	
	@FXML
	private void bnkSettingBtn(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) bnkbtnSettings.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage.getX(), MakeATransactionStage.getY());
		(new TabAccess()).setTabName("tabBank");
		MakeATransactionStage.hide();
	}
	
	
	@FXML
	private void bnkCancelBtn(ActionEvent event) {
		if (bnkSelectedTabName.equals("bKash")) {
			bkInitialize();
		} else if(bnkSelectedTabName.equals("Rocket")) {
			rocInitialize();
		} else {
			perInitialize();
		}
	}
	
//////////////////////// bKash ///////////////////////////
	final ToggleGroup bkRbtnGroup = new ToggleGroup();
	
	@FXML
	private void bkTypeAction(ActionEvent event) {
		try {
			bkAction();
			bkBankChargeShow();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void bkNatureAction(ActionEvent event) {
		try {
			bkAction();
			bkBankChargeShow();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void bkAmountValidation() {
		if (!validAmount(bktxtAmount.getText())) {
			bkAmountValidationMsg.setText(InvalidInput);
			bktxtAmount.clear();
			bklblBankChargeName.setText("");
			bklblBankCharge.setText("");
		} else {
			bkAmountValidationMsg.setText(" ");
			bklblBankChargeName.setText("Bank Charge");
			try {
				bkUpdatedBkBalanceShow();
				bkBankChargeShow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@FXML
	private void bkCmboAction1(ActionEvent event) {
		bkUpdatedBkBalanceShow();
		bkBankChargeShow();
	}
	
	
	@FXML
	private void bkCmboAction2(ActionEvent event) {
		bkUpdatedBkBalanceShow();
		bkBankChargeShow();
	}
	
	
	@FXML
	private void bkCmboAction3(ActionEvent event) {
		bkUpdatedBkBalanceShow();
		bkBankChargeShow();
	}
	
	
	@FXML
	private void bkCmboAction4(ActionEvent event) {
		bkUpdatedBkBalanceShow();
		bkBankChargeShow();
	}
	
	
	@FXML
	private void bkCmboAction5(ActionEvent event) {
		bkUpdatedBkBalanceShow();
		bkBankChargeShow();
	}
	
	
	private void bkLoadType() {
		try {
			bkcmboTransactionType.setItems(bnkTransactionType());
			bkcmboTransactionType.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void bkLoadNature() {
		try {
			bkcmboAmountNature.setItems(bnkAmountNature());
			bkcmboAmountNature.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void bkAccountBalanceShow() {
		bklblAccountBalance.setText(addThousandSeparator(getbkAccountBalance()));
	}
	
	
	private void bkUpdatedBkBalanceShow() {
		if (letterCount(bktxtAmount.getText())==100) {
			bklblUpdateBalance.setText("");
		} else {
			try {
				if (bkcmboTransactionType.getValue().equals("Personal")) {
					if (bkcmboAmountNature.getValue().equals("Credit")) {
						bklblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedbKashBalance(bktxtAmount.getText(), "Cash In")));
					} else {
						bklblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedbKashBalance(bktxtAmount.getText(), bkGetSelectedRbtn())));
					}
				} else {
					if (bkcmboAmountNature.getValue().equals("Credit")) {
						bklblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedbKashBalance(bktxtAmount.getText(), "Cash In")));
					} else {
						bklblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedbKashBalance(bktxtAmount.getText(), bkGetSelectedRbtn())));
					}
				}
			} catch (Exception e) {
				bklblUpdateBalance.setText("");
			}
		}
	}
	
	
	private String bkBankChargeShow() {
		String charge = "0.00";
		try {
			if (bkcmboTransactionType.getValue().equals("Personal")) {
				if (bkcmboAmountNature.getValue().equals("Credit")) {
					if (letterCount(bktxtAmount.getText()) == 100) {
						charge = " ";
						bklblBankCharge.setText(charge);
					} else {
						charge = "0.00";
						bklblBankCharge.setText(charge);
					}
				} else {
					if (bkGetSelectedRbtn().isEmpty()) {
						charge = bkashBnkCharge(bktxtAmount.getText(), "Cash Out");
					} else {
						charge = bkashBnkCharge(bktxtAmount.getText(), bkGetSelectedRbtn());
					}
					bklblBankCharge.setText(charge);
				}
			} else {
				if (bkcmboAmountNature.getValue().equals("Credit")) {
					if (letterCount(bktxtAmount.getText()) == 100) {
						charge = " ";
						bklblBankCharge.setText(charge);
					} else {
						charge = "0.00";
						bklblBankCharge.setText(charge);
					}
				} else {
					if (bkGetSelectedRbtn().isEmpty()) {
						charge = bkashBnkCharge(bktxtAmount.getText(), "Cash Out");
					} else {
						charge = bkashBnkCharge(bktxtAmount.getText(), bkGetSelectedRbtn());
					}
					bklblBankCharge.setText(charge);
				}
			}
		} catch (Exception e) {
			charge = "0.00";
		}
		
		return charge;
	}
	
	
	private void bkRbtnHide() {
		bkrbtn1.setVisible(false);
		bkrbtn2.setVisible(false);
		bkrbtn3.setVisible(false);
		bkrbtn4.setVisible(false);
		bkrbtn5.setVisible(false);
	}
	
	
	private void bkRbtnShow() {
		bkrbtn1.setVisible(true);
		bkrbtn1.setText("Cash Out");
		bkrbtn1.setToggleGroup(bkRbtnGroup);
		bkrbtn1.setSelected(true);
		bkrbtn1.setUserData("Cash Out");
		
		bkrbtn2.setVisible(true);
		bkrbtn2.setText("Buy Airtime");
		bkrbtn2.setToggleGroup(bkRbtnGroup);
		bkrbtn2.setUserData("Buy Airtime");
		
		bkrbtn3.setVisible(true);
		bkrbtn3.setText("Send Money");
		bkrbtn3.setToggleGroup(bkRbtnGroup);
		bkrbtn3.setUserData("Send Money");
		
		bkrbtn4.setVisible(true);
		bkrbtn4.setText("Payment");
		bkrbtn4.setToggleGroup(bkRbtnGroup);
		bkrbtn4.setUserData("Payment");
		
		bkrbtn5.setVisible(true);
		bkrbtn5.setText("ATM");
		bkrbtn5.setToggleGroup(bkRbtnGroup);
		bkrbtn5.setUserData("ATM");
	}
	
	
	private String bkGetSelectedRbtn() {
		try {
			if (bkcmboTransactionType.getValue().equals("Personal")) {
				if (bkcmboAmountNature.getValue().equals("Credit")) {
					return "Cash In";
				} else {
					return (String) bkRbtnGroup.getSelectedToggle().getUserData();
				}
			} else {
				if (bkcmboAmountNature.getValue().equals("Credit")) {
					return "Cash In";
				} else {
					return (String) bkRbtnGroup.getSelectedToggle().getUserData();
				}
			}
		} catch (Exception e) {
			return "None";
		}
	}
	
	
	private void bkAction() {
		if (bkcmboTransactionType.getValue().equals("Personal")) {
			if (bkcmboAmountNature.getValue().equals("Credit")) {
				bklblBankChargeName.setText("");
				bklblBankCharge.setText("");
				bklblAmountNature.setText("");
				bklblUpdateBalance.setText("");
				bkAmountValidationMsg.setText("");
				bkRbtnHide();
				bkUpdatedBkBalanceShow();
			} else {
				bklblBankChargeName.setText("Bank Charge");
				bklblAmountNature.setText("Cash Debited By");
				bkAmountValidationMsg.setText("");
				bkRbtnShow();
				bkUpdatedBkBalanceShow();
				bkBankChargeShow();
			}
		} else {
			if (bkcmboAmountNature.getValue().equals("Credit")) {
				bklblBankChargeName.setText("");
				bklblBankCharge.setText("");
				bklblAmountNature.setText("");
				bklblUpdateBalance.setText("");
				bkAmountValidationMsg.setText("");
				bkRbtnHide();
				bkUpdatedBkBalanceShow();
			} else {
				bklblBankChargeName.setText("Bank Charge");
				bklblAmountNature.setText("Cash Debited By");
				bkAmountValidationMsg.setText("");
				bkRbtnShow();
				bkUpdatedBkBalanceShow();
				bkBankChargeShow();
			}
		}
	}
	
//////////////////////// Rocket //////////////////////////
	final ToggleGroup rocInRbtnGroup = new ToggleGroup();
	final ToggleGroup rocOutRbtnGroup = new ToggleGroup();
	
	@FXML
	private void rocTypeAction(ActionEvent event) {
		try {
			rocAction();
			rocBankChargeShow();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void rocNatureAction(ActionEvent event) {
		try {
			rocAction();
			rocBankChargeShow();
		} catch (Exception e) {}
	}
	
	
	@FXML
	private void rocAmountValidation() {
		if (!validAmount(roctxtAmount.getText())) {
			rocAmountValidationMsg.setText(InvalidInput);
			roctxtAmount.clear();
			roclblBankChargeName.setText("");
			roclblBankCharge.setText("");
		} else {
			rocAmountValidationMsg.setText(" ");
			roclblBankChargeName.setText("Bank Charge");
			try {
				rocUpdatedRocBalanceShow();
				rocBankChargeShow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@FXML
	private void rocCmboAction1(ActionEvent event) {
		rocUpdatedRocBalanceShow();
		rocBankChargeShow();
	}
	
	
	@FXML
	private void rocCmboAction2(ActionEvent event) {
		rocUpdatedRocBalanceShow();
		rocBankChargeShow();
	}
	
	
	@FXML
	private void rocCmboAction3(ActionEvent event) {
		rocUpdatedRocBalanceShow();
		rocBankChargeShow();
	}
	
	
	@FXML
	private void rocCmboAction4(ActionEvent event) {
		rocUpdatedRocBalanceShow();
		rocBankChargeShow();
	}
	
	
	@FXML
	private void rocCmboAction5(ActionEvent event) {
		rocUpdatedRocBalanceShow();
		rocBankChargeShow();
	}

	
	private void rocLoadType() {
		try {
			roccmboTransactionType.setItems(bnkTransactionType());
			roccmboTransactionType.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void rocLoadNature() {
		try {
			roccmboAmountNature.setItems(bnkAmountNature());
			roccmboAmountNature.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void rocAccountBalanceShow() {
		roclblAccountBalance.setText(addThousandSeparator(getRocAccountBalance()));
	}
	
	
	private void rocUpdatedRocBalanceShow() {
		if (letterCount(roctxtAmount.getText())==100) {
			roclblUpdateBalance.setText("");
		} else {
			try {
				if (roccmboTransactionType.getValue().equals("Personal")) {
					if (roccmboAmountNature.getValue().equals("Credit")) {
						roclblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn())));
					} else {
						roclblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn())));
					}
				} else {
					if (roccmboAmountNature.getValue().equals("Credit")) {
						roclblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn())));
					} else {
						roclblUpdateBalance.setText("Update Balance will be : "+addThousandSeparator(updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn())));
					}
				}
			} catch (Exception e) {
				roclblUpdateBalance.setText("");
			}
		}
	}
	
	
	private String rocBankChargeShow() {
		String charge = "0.00";
		try {
			if (!amountIsZero(roctxtAmount.getText())) {
				if (roccmboTransactionType.getValue().equals("Personal")) {
					if (roccmboAmountNature.getValue().equals("Credit")) {
						if (rocGetSelectedRbtn().isEmpty()) {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash In", "Agent");
						} else {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn());
						}
						roclblBankCharge.setText(charge);
					} else {
						if (rocGetSelectedRbtn().isEmpty()) {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash Out", "ATM");
						} else {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn());
						}
						roclblBankCharge.setText(charge);
					}
				} else {
					if (roccmboAmountNature.getValue().equals("Credit")) {
						if (rocGetSelectedRbtn().isEmpty()) {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash In", "Agent");
						} else {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn());
						}
						roclblBankCharge.setText(charge);
					} else {
						if (rocGetSelectedRbtn().isEmpty()) {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash Out", "ATM");
						} else {
							charge = rocketBnkCharge(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn());
						}
						roclblBankCharge.setText(charge);
					}
				}
			} else {
				charge = "0.00";
				roclblBankCharge.setText(charge);
			}
		} catch (Exception e) {
			charge = "0.00";
			roclblBankCharge.setText(charge);
		}
		
		return charge;
	}
	

	private void rocInRbtnShow() {
		rocrbtn1.setVisible(true);
		rocrbtn1.setText("Agent");
		rocrbtn1.setToggleGroup(rocInRbtnGroup);
		rocrbtn1.setSelected(true);
		rocrbtn1.setUserData("Agent");
		
		rocrbtn2.setVisible(true);
		rocrbtn2.setText("Send Money");
		rocrbtn2.setToggleGroup(rocInRbtnGroup);
		rocrbtn2.setUserData("Send Money");
		
		rocrbtn3.setVisible(true);
		rocrbtn3.setText("Branch");
		rocrbtn3.setToggleGroup(rocInRbtnGroup);
		rocrbtn3.setUserData("Branch");
		
		rocrbtn4.setVisible(false);
		
		rocrbtn5.setVisible(false);
	
	}
	

	private void rocOutRbtnShow() {
		rocrbtn1.setVisible(true);
		rocrbtn1.setText("ATM");
		rocrbtn1.setToggleGroup(rocOutRbtnGroup);
		rocrbtn1.setSelected(true);
		rocrbtn1.setUserData("ATM");
		
		rocrbtn2.setVisible(true);
		rocrbtn2.setText("TopUp");
		rocrbtn2.setToggleGroup(rocOutRbtnGroup);
		rocrbtn2.setUserData("TopUp");
		
		rocrbtn3.setVisible(true);
		rocrbtn3.setText("Agent");
		rocrbtn3.setToggleGroup(rocOutRbtnGroup);
		rocrbtn3.setUserData("Agent");
		
		rocrbtn4.setVisible(true);
		rocrbtn4.setText("Branch");
		rocrbtn4.setToggleGroup(rocOutRbtnGroup);
		rocrbtn4.setUserData("Branch");
		
		rocrbtn5.setVisible(true);
		rocrbtn5.setText("Send Money");
		rocrbtn5.setToggleGroup(rocOutRbtnGroup);
		rocrbtn5.setUserData("Send Money");
	
	}
	
	
	private String rocGetSelectedRbtn() {
		try {
			if (roccmboTransactionType.getValue().equals("Personal")) {
				if (roccmboAmountNature.getValue().equals("Credit")) {
					return (String) rocInRbtnGroup.getSelectedToggle().getUserData();
				} else {
					return (String) rocOutRbtnGroup.getSelectedToggle().getUserData();
				}
			} else {
				if (roccmboAmountNature.getValue().equals("Credit")) {
					return (String) rocInRbtnGroup.getSelectedToggle().getUserData();
				} else {
					return (String) rocOutRbtnGroup.getSelectedToggle().getUserData();
				}
			}
		} catch (Exception e) {
			return "None";
		}
	}
	
	
	private void rocAction() {
		if (roccmboTransactionType.getValue().equals("Personal")) {
			if (roccmboAmountNature.getValue().equals("Credit")) {
				roclblBankChargeName.setText("Bank Charge");
				roclblAmountNature.setText("Cash Credited By");
				rocAmountValidationMsg.setText("");
				rocUpdatedRocBalanceShow();
				rocInRbtnShow();
				rocBankChargeShow();
			} else {
				roclblBankChargeName.setText("Bank Charge");
				roclblAmountNature.setText("Cash Debited By");
				rocAmountValidationMsg.setText("");
				rocOutRbtnShow();
				rocUpdatedRocBalanceShow();
				rocBankChargeShow();
			}
		} else {
			if (roccmboAmountNature.getValue().equals("Credit")) {
				roclblBankChargeName.setText("Bank Charge");
				roclblAmountNature.setText("Cash Credited By");
				rocAmountValidationMsg.setText("");
				rocUpdatedRocBalanceShow();
				rocInRbtnShow();
				rocBankChargeShow();
			} else {
				roclblBankChargeName.setText("Bank Charge");
				roclblAmountNature.setText("Cash Debited By");
				rocAmountValidationMsg.setText("");
				rocOutRbtnShow();
				rocUpdatedRocBalanceShow();
				rocBankChargeShow();
			}
		}
	}

	
/////////////////////// Personal /////////////////////////
	
	@FXML
	private void perAmountValidation() {
		if (!validAmount(pertxtAmount.getText())) {
			perAmountValidationMsg.setText(InvalidInput);
			pertxtAmount.clear();
		} else {
			perAmountValidationMsg.setText("");
		}
	}
	
	
	private void perLoadNature() {
		try {
			percmboAmountNature.setItems(bnkAmountNature());
			percmboAmountNature.getSelectionModel().selectFirst();
		} catch (Exception e) {}
	}
	
	
	private void perAccountBalanceShow() {
		perlblAccountBalance.setText(addThousandSeparator(getPerAccountBalance()));
	}
	
	
//////////// bnk function ///////////////
	private boolean bnkAdjustBtnPressed = false;
	String bnkAdjustBalAfter = null;
	String bnkAdjustAmount = null;
	
	@FXML
	private void bnkAdjustBalAction(ActionEvent event) {
		if (bnkSelectedTabName.equals("bKash")) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Adjust bKash Balance");
			dialog.setHeaderText("Provide Balance Status at Your bKash Account.");
			dialog.setContentText("Please enter the amount:");
			Stage MakeATransactionStage = (Stage) bkbtnAdjustBalance.getScene().getWindow();
			dialog.setX(MakeATransactionStage.getX() + 200);
			dialog.setY(MakeATransactionStage.getY() + 170);
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				String typedAmount = result.get();
				if (!validAmount(typedAmount)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText(InvalidInput);
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
					alert.showAndWait();
				} else if (amountIsZero(typedAmount)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText("Zero is not approved.");
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
					alert.showAndWait();
				} else {
					bnkAdjustBtnPressed = true;
					long dbbKashBalance = currentbKashBalance();
					long typedBalance = stringToLong(typedAmount);
					bnkAdjustBalAfter = typedAmount;
					if (dbbKashBalance<typedBalance) {
						bnkAdjustAmount = "added "+longToString(typedBalance - dbbKashBalance)+" to Account";
					} else if(dbbKashBalance>typedBalance) {
						bnkAdjustAmount = UnitConverter.longToString((dbbKashBalance - typedBalance));
					} else {
						bnkAdjustAmount = "0.00";
					}
					bnkSaveFunction();
				}
			}
			
		} else if(bnkSelectedTabName.equals("Rocket")) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Adjust Rocket Balance");
			dialog.setHeaderText("Provide Balance Status at Your Rocket Account.");
			dialog.setContentText("Please enter the amount:");
			Stage MakeATransactionStage = (Stage) rocbtnAdjustBalance.getScene().getWindow();
			dialog.setX(MakeATransactionStage.getX() + 200);
			dialog.setY(MakeATransactionStage.getY() + 170);
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				String typedAmount = result.get();
				if (!validAmount(typedAmount)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText(InvalidInput);
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
					alert.showAndWait();
				} else if (amountIsZero(typedAmount)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText("Zero is not approved.");
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
					alert.showAndWait();
				} else {
					bnkAdjustBtnPressed = true;
					long dbrocketBalance = currentRocketBalance();
					long typedBalance = stringToLong(typedAmount);
					bnkAdjustBalAfter = typedAmount;
					if (dbrocketBalance<typedBalance) {
						bnkAdjustAmount = "added "+longToString(typedBalance - dbrocketBalance)+" to Account";
					} else if(dbrocketBalance>typedBalance) {
						bnkAdjustAmount = UnitConverter.longToString((dbrocketBalance - typedBalance));
					} else {
						bnkAdjustAmount = "0.00";
					}
					bnkSaveFunction();
				}
			}
		}
		
		bnkAdjustBtnPressed = false;
	}
	
	
	@FXML
	private void bnkSaveBtn(ActionEvent event) {
		if (bnkSelectedTabName.equals("bKash")) {
			if (amountIsZero(bktxtAmount.getText())) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("Zero or Empty is not allowed");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			} else {
				bnkSaveFunction();
			}
		} else if(bnkSelectedTabName.equals("Rocket")) {
			if (amountIsZero(roctxtAmount.getText())) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("Zero or Empty is not allowed");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			} else {
				bnkSaveFunction();
			}
		} else {
			if (amountIsZero(pertxtAmount.getText())) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("Zero or Empty is not allowed");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			} else {
				bnkSaveFunction();
			}
		}

	}
	
	
	private void bnkSaveFunction() {
		Map<String, String> bnkData = new HashMap<>();
		
		if (bnkSelectedTabName.equals("bKash")) {
			
			try {
				bnkData.put("bkTime", timeToSave());
				bnkData.put("bkDate", (new DateFormatManager()).toString(bnkdateDate.getValue()));
				bnkData.put("bkMonth", monthToSave());
				bnkData.put("bkBalanceBefore", getbkAccountBalance());
				if (bnkAdjustBtnPressed) {
					bnkData.put("bkType", "Adjusted Balance");
					bnkData.put("bkNature", "Adjusted Balance");
					bnkData.put("bkAmount", bnkAdjustAmount);
					bnkData.put("bkBnkCharge", "None");
					bnkData.put("bkBalanceAfter", bnkAdjustBalAfter);
					
					(new Bkash()).saveBnkBkashData(bnkData);
					setCurrentbKashBalance(bnkAdjustBalAfter);
				} else {
					bnkData.put("bkType", bkcmboTransactionType.getValue());
					bnkData.put("bkNature", bkGetSelectedRbtn());
					bnkData.put("bkAmount", bktxtAmount.getText());
					bnkData.put("bkBnkCharge", bkBankChargeShow());
					bnkData.put("bkBalanceAfter", updatedbKashBalance(bktxtAmount.getText(), bkGetSelectedRbtn()));
					
					(new Bkash()).saveBnkBkashData(bnkData);
					setCurrentbKashBalance(updatedbKashBalance(bktxtAmount.getText(), bkGetSelectedRbtn()));
					if (bkcmboTransactionType.getValue().equals("Personal")) {
						if (bkcmboAmountNature.getValue().equals("Debit")) {
							setCurrentWalletBalance(gmWalletBalanceAfter(bktxtAmount.getText()));
						}
					}
				}
				
				bkInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Your transaction completed successfully.");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 170);
				confirmationMsg.showAndWait();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			}
			
		} else if(bnkSelectedTabName.equals("Rocket")) {

			try {
				bnkData.put("rocTime", timeToSave());
				bnkData.put("rocDate", (new DateFormatManager()).toString(bnkdateDate.getValue()));
				bnkData.put("rocMonth", monthToSave());
				bnkData.put("rocBalanceBefore", getRocAccountBalance());
				if (bnkAdjustBtnPressed) {
					bnkData.put("rocType", "Adjusted Balance");
					bnkData.put("rocNature", "Adjusted Balance");
					bnkData.put("rocAmount", bnkAdjustAmount);
					bnkData.put("rocBnkCharge", "None");
					bnkData.put("rocBalanceAfter", bnkAdjustBalAfter);
					
					(new Rocket()).saveBnkRocketData(bnkData);
					setCurrentRocketBalance(bnkAdjustBalAfter);
				} else {
					bnkData.put("rocType", roccmboTransactionType.getValue());
					bnkData.put("rocNature", rocGetSelectedRbtn());
					bnkData.put("rocAmount", roctxtAmount.getText());
					bnkData.put("rocBnkCharge", rocBankChargeShow());
					
					if (bkcmboTransactionType.getValue().equals("Personal")) {
						if (bkcmboAmountNature.getValue().equals("Credit")) {
							bnkData.put("rocBalanceAfter", updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn()));
							setCurrentRocketBalance(updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn()));
						} else {
							bnkData.put("rocBalanceAfter", updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn()));
							setCurrentRocketBalance(updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn()));
							setCurrentWalletBalance(gmWalletBalanceAfter(roctxtAmount.getText()));
						}
					} else {
						if (bkcmboAmountNature.getValue().equals("Credit")) {
							bnkData.put("rocBalanceAfter", updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn()));
							setCurrentRocketBalance(updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn()));
						} else {
							bnkData.put("rocBalanceAfter", updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn()));
							setCurrentRocketBalance(updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn()));
						}
					}
					(new Rocket()).saveBnkRocketData(bnkData);
				}
				
				rocInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Your transaction completed successfully.");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 170);
				confirmationMsg.showAndWait();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			}
			
		} else {
			try {
				bnkData.put("perTime", timeToSave());
				bnkData.put("perDate", (new DateFormatManager()).toString(bnkdateDate.getValue()));
				bnkData.put("perMonth", monthToSave());
				bnkData.put("perNature", percmboAmountNature.getValue());
				bnkData.put("perAmount", pertxtAmount.getText());
				bnkData.put("perBalanceBefore", getPerAccountBalance());
				
				if (percmboAmountNature.getValue().equals("Credit")) {
					bnkData.put("perBalanceAfter", updatedPersonalBalance(pertxtAmount.getText(), "Credit"));
					setCurrentWalletBalance(exWalletBalanceAfter(pertxtAmount.getText()));
				} else {
					bnkData.put("perBalanceAfter", updatedPersonalBalance(pertxtAmount.getText(), "Debit"));
					setCurrentWalletBalance(gmWalletBalanceAfter(pertxtAmount.getText()));
				}
				(new Personal()).saveBnkPersonalData(bnkData);
				
				perInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Your transaction completed successfully.");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 170);
				confirmationMsg.showAndWait();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) bnkbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
				alert.showAndWait();
			}
		}
	}
	
}























