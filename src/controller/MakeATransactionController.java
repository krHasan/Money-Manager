package controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
import operation.GoToOperation;
import system.DateFormatManager;
import system.UnitConverter;
import tab.Bkash;
import tab.Expense;
import tab.GetMoney;
import tab.Rocket;
import tab.TabAccess;
import tableAndgraph.BorrowTableDataModel;
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
	
	final String InvalidInput = "Invalid Input. Type within 0.00 to 9999999.99";
	
	
	@FXML
	public void initialize() {
		
	}
	
	
	private void showWalletBalance() {
		try {
			gmlblWalletBalance.setText(getWalletBalance());
			exlblWalletBalance.setText(getWalletBalance());
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
				long typedBalance = UnitConverter.stringToLong(typedAmount);
				exAdjustBalAfter = typedAmount;
				if (dbWalletBalance<typedBalance) {
					exAdjustAmount = "added "+UnitConverter.longToString(typedBalance - dbWalletBalance)+" to Wallet";
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
		showBorroTblData();
		lenddateDate.setConverter(formatManager);
		lenddateDate.setValue(date);
		boLoadType();
		loadMethod();
		boBankChargeShow(botxtAmountWithCharge.getText());
		boLoadRepayPersonName();
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
		showLendTblData();
		lenddateDate.setConverter(formatManager);
		lenddateDate.setValue(date);
	}
	
	
	@FXML
	private void LendCancelBtn(ActionEvent event) {
		if (selectedTabName.equals("Borrow")) {
			boInitialize();
		} else {
			leInitialize();
		}
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
	
	
	@FXML
	private void boRepayPersonCmboAction(ActionEvent event) {
		
	}
	
	
	@FXML
	private void boTypeAction(ActionEvent event) {
		borrowAction();
	}
	
	
	@FXML
	private void boMethodAction(ActionEvent event) {
		borrowAction();
	}
	
	
	@FXML
	private void boRbtn1Action() {
		boBankChargeShow(botxtAmountWithCharge.getText());
	}
	
	
	@FXML
	private void boRbtn2Action() {
		boBankChargeShow(botxtAmountWithCharge.getText());
	}
	
	
	@FXML
	private void boRbtn3Action() {
		boBankChargeShow(botxtAmountWithCharge.getText());
	}
	
	
	@FXML
	private void boRbtn4Action() {
		boBankChargeShow(botxtAmountWithCharge.getText());
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
				boBankChargeShow(botxtAmountWithCharge.getText());				
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
				boBankChargeShow(botxtAmountWithCharge.getText());				
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
	
	
	private String boBankChargeShow(String amount) {
		String charge = null;
		try {
			if (bocmboType.getValue().equals("Money Take")) {
				if (amountIsZero(amount)) {
					if (bocmboMethod.getValue().equals("Hand to Hand")) {
						bolblBankCharge.setText("");
					} else {
						bolblBankCharge.setText("0.00");
					}
				} else {
					if (bocmboMethod.getValue().equals("bKash")) {
						charge = bkashBnkCharge(amount, "Cash In");
						bolblBankCharge.setText(charge);
					} else if(bocmboMethod.getValue().equals("Rocket")) {
						charge = rocketBnkCharge(amount, "Cash In", boGetSelectedrbtnName());
						bolblBankCharge.setText(charge);
					} else {
						bolblBankCharge.setText("");
					}
				}
				
			} else {
				
				if (amountIsZero(amount)) {
					if (bocmboMethod.getValue().equals("Hand to Hand")) {
						bolblBankCharge.setText("");
					} else {
						bolblBankCharge.setText("0.00");
					}
				} else {
					if (bocmboMethod.getValue().equals("bKash")) {
						charge = bkashBnkCharge(amount, boGetSelectedrbtnName());
						bolblBankCharge.setText(charge);
					} else if(bocmboMethod.getValue().equals("Rocket")) {
						charge = rocketBnkCharge(amount, "Cash Out", boGetSelectedrbtnName());
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
					bolblAmountWithCharge.setText("Borrowed Amount :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Exact Borrowed Amount :");
					bolblAmountNature.setText("");
					boRbtnHide();
					boBankChargeShow(botxtAmountWithCharge.getText());
					bocmboRepaidPerson.setVisible(false);
					botxtExactAmount.setVisible(true);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(true);
				} else if (bocmboMethod.getValue().equals("Rocket")) {
					bolblPersonName.setText("From Whom :");
					bolblAmountWithCharge.setText("Borrowed Amount :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Exact Borrowed Amount :");
					bolblAmountNature.setText("Cash In From");
					boBankChargeShow(botxtAmountWithCharge.getText());
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
					boBankChargeShow(botxtAmountWithCharge.getText());
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
					bolblAmountWithCharge.setText("Returnable Amount :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Exact Returnable Amount :");
					bolblAmountNature.setText("Cash Return Using");
					boBankChargeShow(botxtAmountWithCharge.getText());
					boBkRbtnShow();
					bocmboRepaidPerson.setVisible(true);
					boLoadRepayPersonName();
					botxtExactAmount.setVisible(true);
					bolblAmountValidationMsg.setText("");
					bolblAmountValidationMsg2.setText("");
					botxtFromWhom.setVisible(false);
				} else if (bocmboMethod.getValue().equals("Rocket")) {
					bolblPersonName.setText("Return to :");
					bolblAmountWithCharge.setText("Returnable Amount :");
					bolblBankChargeName.setText("Bank Charge");
					bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
					bolblExactAmount.setText("Exact Returnable Amount :");
					bolblAmountNature.setText("Cash Return Using");
					boBankChargeShow(botxtAmountWithCharge.getText());
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
					boBankChargeShow(botxtAmountWithCharge.getText());
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

////////////////////////////////////////////     Bank Function    ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	@FXML
	private void tabBank() {
		bnkdateDate.setConverter(formatManager);
		bnkdateDate.setValue(date);
	}
	
}























