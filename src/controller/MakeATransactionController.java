package controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.MakeATransactionModel;
import operation.BankIssue;
import operation.ComboboxList;
import operation.GoToOperation;
import system.DateFormatManager;
import system.Undo;
import system.UnitConverter;
import tab.Bkash;
import tab.Borrow;
import tab.Expense;
import tab.GetMoney;
import tab.Lend;
import tab.Personal;
import tab.Rocket;
import tab.Sector;
import tab.Source;
import tab.TabAccess;
import tableAndgraph.TableData;

public class MakeATransactionController extends MakeATransactionModel {
	
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
	private MenuItem mnuHowTo;
	@FXML
	private MenuItem mnuAbout;
	
	@FXML
	private Button btnSignOut;
	@FXML
	private Label lblUserFullName;
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
	private Button gmbtnSaveAdd;
	@FXML
	private Button gmbtnSave;

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
	
////////////////// Normal /////////////////
	@FXML
	private AnchorPane exAnchorPane;
	
	@FXML
	private Button exbtnCreateSector;
	@FXML
	private Button exbtnAdjustBalance;
	@FXML
	private Button exbtnSaveAndAdd;
	@FXML
	private Button exbtnSave;
	@FXML
	private Button exbtnGoToCashCalculate;
	
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

////////////////// Advanced /////////////////
	@FXML
	private Button exbtnGoToExpenseSettings;
	@FXML
	private Button exbtnAdvancedAdjustBalance;
	@FXML
	private Button exbtnAdvancedSaveAndAdd;
	@FXML
	private Button exbtnAdvancedSave;
	@FXML
	private Button exbtnGoToAdvancedCashCalculate;
	
	@FXML
	private DatePicker exdateAdvancedDate;
	
	@FXML
	private TextArea extxtAdvancedDescription;
	
	@FXML
	private Label exlblAdvWalletBalance;
	@FXML
	private Label exlblAdvLetterRemainmsg;
	@FXML
	private Label exlblAdvWarningMsg;
	@FXML
	private Label exlblAdvTotalExpensed;
	@FXML
	private Label exlblAdvSector1;
	@FXML
	private Label exlblAdvSector2;
	@FXML
	private Label exlblAdvSector3;
	@FXML
	private Label exlblAdvSector4;
	@FXML
	private Label exlblAdvSector5;
	@FXML
	private Label exlblAdvSector6;
	@FXML
	private Label exlblAdvSector7;
	
	@FXML
	private TextField extxtAdvSector1;
	@FXML
	private TextField extxtAdvSector2;
	@FXML
	private TextField extxtAdvSector3;
	@FXML
	private TextField extxtAdvSector4;
	@FXML
	private TextField extxtAdvSector5;
	@FXML
	private TextField extxtAdvSector6;
	@FXML
	private TextField extxtAdvSector7;
	
///////////////////////////////////  Lend  ////////////////////////////////
	@FXML
	private Tab tabLend;
	
	@FXML
	private Button lendbtnCancel;
	@FXML
	private Button lendbtnSave;
	
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
	private Label lendlblbkAccountBalanceName;
	@FXML
	private Label lendlblrocAccountBalanceName;
	
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
	private Button bkbtnCancel;
	@FXML
	private Button bkbtnSave;
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
	private Button rocbtnCancel;
	@FXML
	private Button rocbtnSave;
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
	private Button perbtnCancel;
	@FXML
	private Button perbtnSave;
	
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
		showTab();
		lblUserFullName.setText(userFullName()+" ");
		
		gmdateDate.setConverter(formatManager);
		gmdateDate.setValue(date);
		if (getWeekStatus()) {
			gmdateDate.setShowWeekNumbers(true);
		}
		
		exdateDate.setConverter(formatManager);
		exdateDate.setValue(date);
		if (getWeekStatus()) {
			exdateDate.setShowWeekNumbers(true);
		}
		
		exdateAdvancedDate.setConverter(formatManager);
		exdateAdvancedDate.setValue(date);
		if (getWeekStatus()) {
			exdateAdvancedDate.setShowWeekNumbers(true);
		}
		
		btnSignOut.setTooltip(new Tooltip("Sign Out from application"));
		Tooltip.install(lblUserFullName, new Tooltip("User's Full Name"));
		
		gmbtnCreateSource.setTooltip(new Tooltip("Create your income source where you get Tk."));
		gmbtnSettings.setTooltip(new Tooltip("Take you to Bank Settings"));
		gmbtnSaveAdd.setTooltip(new Tooltip("Save your data and let you do another transaction"));
		gmbtnSave.setTooltip(new Tooltip("Save your data and take you to dashboard"));
		Tooltip.install(gmdateDate, new Tooltip("Choose date when your transaction happend"));
		Tooltip.install(gmtxtAmount, new Tooltip("How much Tk. you have get"));
		Tooltip.install(gmtxtDescription, new Tooltip("Add a description of your transaction."));
		Tooltip.install(gmcmboSource, new Tooltip("Name of Income Sources, where from you get Tk."));
		Tooltip.install(gmcmboMethod, new Tooltip("In which way you get the money"));
		Tooltip.install(gmlblWalletBalance, new Tooltip("Your wallet balance now"));
		
		exbtnCreateSector.setTooltip(new Tooltip("Create your expenditure sector where you expense Tk."));
		exbtnAdjustBalance.setTooltip(new Tooltip("Let you set application Wallet Balance \n"
				+ "according to how much Tk. at your hand now."));
		exbtnGoToCashCalculate.setTooltip(new Tooltip("Calculate how much Tk. at your hand now"));
		exbtnSaveAndAdd.setTooltip(new Tooltip("Save your data and let you do another transaction"));
		exbtnSave.setTooltip(new Tooltip("Save your data and take you to dashboard"));
		Tooltip.install(exdateDate, new Tooltip("Choose date when your transaction happend"));
		Tooltip.install(extxtAmount, new Tooltip("How much Tk. you have expensed"));
		Tooltip.install(extxtDescription, new Tooltip("Add a description of your transaction."));
		Tooltip.install(excmboSector, new Tooltip("Name of Expenditure Sector, \n"
				+ "where you expense your Tk."));
		Tooltip.install(exlblWalletBalance, new Tooltip("Your wallet balance now"));
		
		exbtnGoToExpenseSettings.setTooltip(new Tooltip("Take you to Advanced Expense Settings"));
		exbtnAdvancedAdjustBalance.setTooltip(new Tooltip("Let you set application Wallet Balance \n"
				+ "according to how much Tk. at your hand now."));
		exbtnGoToAdvancedCashCalculate.setTooltip(new Tooltip("Calculate how much Tk. at your hand now"));
		exbtnAdvancedSaveAndAdd.setTooltip(new Tooltip("Save your data and let you do another transaction"));
		exbtnAdvancedSave.setTooltip(new Tooltip("Save your data and take you to dashboard"));
		Tooltip.install(exdateAdvancedDate, new Tooltip("Choose date when your transaction happend"));
		Tooltip.install(extxtAdvSector1, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(extxtAdvSector2, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(extxtAdvSector3, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(extxtAdvSector4, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(extxtAdvSector5, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(extxtAdvSector6, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(extxtAdvSector7, new Tooltip("How much Tk. you have expensed to this sector"));
		Tooltip.install(exlblAdvSector1, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvSector2, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvSector3, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvSector4, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvSector5, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvSector6, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvSector7, new Tooltip("Your choosed sector name"));
		Tooltip.install(exlblAdvTotalExpensed, new Tooltip("Total expensed Tk in this transaction"));
		Tooltip.install(extxtAdvancedDescription, new Tooltip("Add a description of your transaction."));
		Tooltip.install(exlblAdvWalletBalance, new Tooltip("Your wallet balance now"));
		
		lendbtnCancel.setTooltip(new Tooltip("Clear all input at lend tab"));
		lendbtnSave.setTooltip(new Tooltip("Save your data and let you do another transaction"));
		Tooltip.install(lenddateDate, new Tooltip("Choose date when your transaction happend"));
		Tooltip.install(lendlblBkBalance, new Tooltip("Your bKash account balance"));
		Tooltip.install(lendlblRocBalance, new Tooltip("Your Rocket account balance"));
		Tooltip.install(lendlblWalletBalance, new Tooltip("Your wallet balance now"));
		Tooltip.install(lendTable, new Tooltip("List of your Borrowed/Lended Tk."));
		Tooltip.install(lendlblTotalLendTk, new Tooltip("Your total Lended Tk."));
		Tooltip.install(lendlblTotalBorrowTk, new Tooltip("Your total Borrowed Tk."));
		Tooltip.install(bocmboType, new Tooltip("Define wheather you take tk or \n"
				+ "you are going to return a borrowed tk"));
		Tooltip.install(bocmboMethod, new Tooltip("In which way you borrowed/return the money"));
		Tooltip.install(botxtFromWhom, new Tooltip("From whom you borrowed the money"));
		Tooltip.install(bocmboRepaidPerson, new Tooltip("To whom you going to return the borrowed money"));
		Tooltip.install(botxtAmountWithCharge, new Tooltip("How much tk. you borrowed/returned"));
		Tooltip.install(botxtExactAmount, new Tooltip("If you borrowed tk. through bKash/Rocket \n"
				+ "then may the borrowed tk is different \n"
				+ "form transaction tk, because of the bank charge."));
		Tooltip.install(lecmboType, new Tooltip("Define wheather you give tk or \n"
				+ "you are going to take back the given tk"));
		Tooltip.install(lecmboMethod, new Tooltip("In which way you given/take the money"));
		Tooltip.install(letxtFromWhom, new Tooltip("To whom you given the money"));
		Tooltip.install(lecmboRepaidPerson, new Tooltip("From whom you going to take back given money"));
		Tooltip.install(letxtAmountWithCharge, new Tooltip("How much tk. you given/take"));
		Tooltip.install(letxtExactAmount, new Tooltip("If you given tk. through bKash/Rocket \n"
				+ "then may the given tk is different \n"
				+ "form transaction tk, because of the bank charge."));
		
		bnkbtnSettings.setTooltip(new Tooltip("Take you to Bank Settings"));
		perbtnSave.setTooltip(new Tooltip("Save data and let you do another transaction"));
		perbtnCancel.setTooltip(new Tooltip("Clear all input"));
		bkbtnSave.setTooltip(new Tooltip("Save data and let you do another transaction"));
		bkbtnCancel.setTooltip(new Tooltip("Clear all input"));
		rocbtnSave.setTooltip(new Tooltip("Save data and let you do another transaction"));
		rocbtnCancel.setTooltip(new Tooltip("Clear all input"));
		Tooltip.install(bnkWalletBalance, new Tooltip("Your wallet balance now"));
		Tooltip.install(bnkdateDate, new Tooltip("Choose date when your transaction happend"));
		Tooltip.install(perlblAccountBalance, new Tooltip("Personal account balance"));
		Tooltip.install(percmboAmountNature, new Tooltip("Select Tk. debited or credited"));
		Tooltip.install(pertxtAmount, new Tooltip("How much Tk. Debited/Credited"));
		bkbtnAdjustBalance.setTooltip(new Tooltip("Let you set this application bKash account balance \n"
				+ "according to how much Tk. at your original bKash account now."));
		Tooltip.install(bklblAccountBalance, new Tooltip("bKash Account Balance"));
		Tooltip.install(bkcmboTransactionType, new Tooltip("The transaction you are going to record \n"
				+ "wheather it is your personal or for other person"));
		Tooltip.install(bkcmboAmountNature, new Tooltip("Select Tk. debited or credited"));
		Tooltip.install(bktxtAmount, new Tooltip("How much Tk. Debited/Credited"));
		rocbtnAdjustBalance.setTooltip(new Tooltip("Let you set this application Rocket account balance \n"
				+ "according to how much Tk. at your original Rocket account now."));
		Tooltip.install(roclblAccountBalance, new Tooltip("Rocket Account Balance"));
		Tooltip.install(roccmboTransactionType, new Tooltip("The transaction you are going to record \n"
				+ "wheather it is your personal or for other person"));
		Tooltip.install(roccmboAmountNature, new Tooltip("Select Tk. debited or credited"));
		Tooltip.install(roctxtAmount, new Tooltip("How much Tk. Debited/Credited"));
	}

	
	public void showTab() {
		try {
			String tabName = (new TabAccess()).getTabName();
			if (tabName.equals("tabExpense")) {
				tabPane.getSelectionModel().select(tabExpense);
			} else if (tabName.equals("tabLend")){
				tabPane.getSelectionModel().select(tabLend);
			} else if (tabName.equals("tabBank")) {
				tabPane.getSelectionModel().select(tabBank);
			} else {
				tabPane.getSelectionModel().select(tabGetMoney);			
			}
		} catch (Exception e) {}
	}
	
	
	private void showWalletBalance() {
		try {
			gmlblWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			exlblWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			exlblAdvWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			lendlblWalletBalance.setText(addThousandSeparator(getWalletBalance()));
			bnkWalletBalance.setText(addThousandSeparator(getWalletBalance()));
		} catch (Exception e) {}
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

//////////////////////////////////////////// Menu Function ////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------//
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToDashboard(MakeATransactionStage);
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(MakeATransactionStage);
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(MakeATransactionStage);
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(MakeATransactionStage);
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(MakeATransactionStage);
	}
	
	@FXML
	private void mnuSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(MakeATransactionStage);
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(MakeATransactionStage);
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		MakeATransactionStage.close();
	}
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	@FXML
	private void mnuUndo(ActionEvent event) {
		String feedback = new Undo().actionUndo();
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Action Successful");
		alert.setHeaderText(null);
		alert.setContentText(feedback);
		alert.setX(MakeATransactionStage.getX() + 190);
		alert.setY(MakeATransactionStage.getY() + 29);
//		initialize();
		gmInitialize();
		exInitialize();
		leInitialize();
		bkInitialize();
		rocInitialize();
		perInitialize();
	    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
	    {
	        @Override
	        public void handle( ActionEvent event )
	        {
	        	alert.hide();
	        }
	    } ) );
	    idlestage.setCycleCount( 1 );
	    idlestage.play();
	    alert.showAndWait();
	}

	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	@FXML
	private void mnuAdvancedSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabAdvanced");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	@FXML
	private void mnuHowTo(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToHelp(MakeATransactionStage);
	}
	
	@FXML
	private void mnuAbout(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToAbout(MakeATransactionStage);
	}
	
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(MakeATransactionStage);
	}
	
////////////////////////////////////////////  Get Money Function ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	private boolean cancelbtnPressed = false;
	final ToggleGroup gmrbtnGroup = new ToggleGroup();
	
	
	@FXML
	private void tabGetMoney() {
		gmInitialize();
//		gmdateDate.setConverter(formatManager);
//		gmdateDate.setValue(date);
//		if (getWeekStatus()) {
//			gmdateDate.setShowWeekNumbers(true);
//		}
	}
	
	
	private void gmInitialize() {
		gmlblLetterRemainmsg.setText("");
		gmlblBalanceUpdateMsg.setText(" ");
		gmlblWarningMsg.setText("");
		gmtxtDescription.setEditable(true);
		gmLoadSource();
		loadMethod();
		gmRocInRbtnHide();
		showWalletBalance();
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
		(new TabAccess()).setTabName("tabBank");
		Stage MakeATransactionStage = (Stage) gmbtnSettings.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	
	@FXML
	private void gmCreateSourceBtn(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Create Income Source");
		dialog.setHeaderText("Create Income Source, Where from you get Tk.");
		dialog.setContentText("Please type a source name :");
		Stage MakeATransactionStage = (Stage) gmbtnCreateSource.getScene().getWindow();
		dialog.setX(MakeATransactionStage.getX() + 200);
		dialog.setY(MakeATransactionStage.getY() + 170);
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			String typedName = result.get();
			if (typedName.length() == 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Operation Falied");
				alert.setHeaderText(null);
				alert.setContentText("Write a Source Name Please");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else if (countWords(typedName) == 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Operation Falied");
				alert.setHeaderText(null);
				alert.setContentText("Write a Source Name Please");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else {
				new Source().createSource(typedName);
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Source "+typedName+" created successfully");
				Stage SettingsStage = (Stage) MakeATransactionStage.getScene().getWindow();
				confirmationMsg.setX(SettingsStage.getX() + 200);
				confirmationMsg.setY(SettingsStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
				
				gmLoadSource();
				gmcmboSource.getSelectionModel().selectLast();
			}
		}
	}
	
	
	@FXML
	private void gmbtnSaveAdd(ActionEvent event) {
		if (amountIsZero(gmtxtAmount.getText())) {
			gmlblWarningMsg.setText("Empty or Zero is not approved.");
		} else {
			try {
				Map<String, String> stringData = new HashMap<>();
				
				stringData.put("gmTime", timeToSave());
				stringData.put("gmDate", (new DateFormatManager()).toString(gmdateDate.getValue()));
				stringData.put("gmMonth", monthToSave(gmdateDate.getValue()));
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
				(new ComboboxList()).setAllMonth(monthToSave(gmdateDate.getValue()), yearToSave(gmdateDate.getValue()));
				(new ComboboxList()).setAllGmMonth(monthToSave(gmdateDate.getValue()), yearToSave(gmdateDate.getValue()));
				
				gmInitialize();
				gmtxtAmount.clear();
				gmtxtDescription.clear();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Successful");
				Stage MakeATransactionStage = (Stage) gmbtnSave.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 29);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
				
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) gmbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			}
		}
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
				stringData.put("gmMonth", monthToSave(gmdateDate.getValue()));
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
				(new ComboboxList()).setAllMonth(monthToSave(gmdateDate.getValue()), yearToSave(gmdateDate.getValue()));
				(new ComboboxList()).setAllGmMonth(monthToSave(gmdateDate.getValue()), yearToSave(gmdateDate.getValue()));

				gmInitialize();
				gmtxtAmount.clear();
				gmtxtDescription.clear();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Successful.");
				Stage MakeATransactionStage = (Stage) gmbtnSave.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 29);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
				
				(new GoToOperation()).goToDashboard(MakeATransactionStage);
				
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) gmbtnSave.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			}
		}

	}
	
	
	@FXML
	private void gmAmountValidation() {
		if (!validAmount(gmtxtAmount.getText())) {
			if (!gmtxtAmount.getText().isEmpty()) {
				gmlblWarningMsg.setText(InvalidInput);
				gmtxtAmount.clear();				
			}
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
			gmlblLetterRemainmsg.setText("Word remain: "+wordRemain+"/100");
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
//	default values
	private boolean adjustBtnPressed = false;
	String exAdjustBalAfter = null;
	String exAdjustAmount = null;
	
//	load methods when expense tab is selected
	@FXML
	private void tabExpense() {
		exInitialize();
//		exdateDate.setConverter(formatManager);
//		exdateDate.setValue(date);
//		if (getWeekStatus()) {
//			exdateDate.setShowWeekNumbers(true);
//		}
	}
	
//	initialize expense tab nodes state
	private void exInitialize() {
		exlblWarningMsg.setText("");
		exlblLetterRemainmsg.setText("");
		showWalletBalance();
		exLoadSector();
		
		exlblAdvWarningMsg.setText("");
		exlblAdvLetterRemainmsg.setText("");
		exlblAdvTotalExpensed.setText("");
		loadAdvancedExpenseSector();
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
			if (!extxtAmount.getText().isEmpty()) {
				exlblWarningMsg.setText(InvalidInput);
				extxtAmount.clear();				
			}
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
			exlblLetterRemainmsg.setText("Word remain: "+wordRemain+"/100");
		}
	}
	
	
	private boolean exIsDescripionEmpty() {
		if (letterCount(extxtDescription.getText()) == 100) {
			return true;
		} else {
			return false;
		}
	}
	
	
//	function for creating a sector
	@FXML
	private void exCreateSectorBtn(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Create Sector");
		dialog.setHeaderText("Create your expenditure sector, where you expense Tk.");
		dialog.setContentText("Please Type a Name :");
		Stage MakeATransactionStage = (Stage) exbtnCreateSector.getScene().getWindow();
		dialog.setX(MakeATransactionStage.getX() + 150);
		dialog.setY(MakeATransactionStage.getY() + 170);
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			String typedName = result.get();
			if (typedName.length() == 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Operation Failed");
				alert.setHeaderText(null);
				alert.setContentText("Write a Sector Name Please");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else if (countWords(typedName) == 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Operation Failed");
				alert.setHeaderText(null);
				alert.setContentText("Write a Sector Name Please");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else if(new Sector().createSector(typedName)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Operation Failed");
				alert.setHeaderText(null);
				alert.setContentText("Sector Name Already Exist");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();				
			} else {
				new Sector().createSector(typedName);
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Message");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Sector "+typedName+ " created successfully");
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
				
				exLoadSector();
				excmboSector.getSelectionModel().selectLast();
			}
		}
	}
	
	
//	this function will let user to adjust their balance
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
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else if (amountIsZero(typedAmount)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("Zero is not approved.");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
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
	private void exbtnGoToCashCalculate(ActionEvent event) {
		Stage MakeATransactionStage = (Stage) exbtnGoToCashCalculate.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(MakeATransactionStage);
	}
	
	
	@FXML
	private void exSaveBtn(ActionEvent event) {
		if (amountIsZero(extxtAmount.getText())) {
			exlblWarningMsg.setText("Empty or Zero is not approved.");
		} else {
			exSaveFunction();
			Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
			(new GoToOperation()).goToDashboard(MakeATransactionStage);
		}
	}
	
	
	@FXML
	private void exbtnSaveAndAdd(ActionEvent event) {
		if (amountIsZero(extxtAmount.getText())) {
			exlblWarningMsg.setText("Empty or Zero is not approved.");
		} else {
			exSaveFunction();
		}
	}
	
	
//	save user input values to database
	private void exSaveFunction() {
		try {
			Map<String, String> expenseData = new HashMap<>();
			
			expenseData.put("exTime", timeToSave());
			expenseData.put("exDate", (new DateFormatManager()).toString(exdateDate.getValue()));
			expenseData.put("exMonth", monthToSave(exdateDate.getValue()));
			
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
			(new ComboboxList()).setAllMonth(monthToSave(exdateDate.getValue()), yearToSave(exdateDate.getValue()));
			(new ComboboxList()).setAllExMonth(monthToSave(exdateDate.getValue()), yearToSave(exdateDate.getValue()));
			
			exInitialize();
			extxtAmount.clear();
			extxtDescription.clear();
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Successfull Transaction");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Successful");
			Stage MakeATransactionStage = (Stage) exbtnSave.getScene().getWindow();
			confirmationMsg.setX(MakeATransactionStage.getX() + 200);
			confirmationMsg.setY(MakeATransactionStage.getY() + 29);
		    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
		    {
		        @Override
		        public void handle( ActionEvent event )
		        {
		        	confirmationMsg.hide();
		        }
		    } ) );
		    idlestage.setCycleCount( 1 );
		    idlestage.play();
		    confirmationMsg.showAndWait();
			
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Transaction Failed");
			alert.setHeaderText(null);
			alert.setContentText("There something is wrong.");
			Stage MakeATransactionStage = (Stage) exbtnSave.getScene().getWindow();
			alert.setX(MakeATransactionStage.getX() + 200);
			alert.setY(MakeATransactionStage.getY() + 170);
		    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
		    {
		        @Override
		        public void handle( ActionEvent event )
		        {
		        	alert.hide();
		        }
		    } ) );
		    idlestage.setCycleCount( 1 );
		    idlestage.play();
		    alert.showAndWait();
		}
	}
	
	
///////////// Advanced Expense //////////////////////
	int total;
	
	private void loadAdvancedExpenseSector() {
		TextField AdvancedExtxt[] = {extxtAdvSector1, extxtAdvSector2, extxtAdvSector3, extxtAdvSector4, 
				extxtAdvSector5, extxtAdvSector6, extxtAdvSector7 };
		
		Label AdvancedExlbl[] = {exlblAdvSector1, exlblAdvSector2, exlblAdvSector3, exlblAdvSector4, 
				exlblAdvSector5, exlblAdvSector6, exlblAdvSector7 };
		
		String sectorName[] = new ComboboxList().getAdvancedSectorListActive();
		
		for (TextField textField : AdvancedExtxt) {
			textField.clear();
			textField.setVisible(false);
		}
		for (Label label : AdvancedExlbl) {
			label.setText("");
		}
		
		int indexLimit = new ComboboxList().getAdvancedSectorActiveArraySize();
		int index = 0;
		for (String string : sectorName) {
			if((indexLimit > 0) && (index < indexLimit)) {
				AdvancedExtxt[index].setVisible(true);
				AdvancedExlbl[index].setText(string);
				++index;
			}
		}
	}

	
	private void showAdvExTotalEx() {
		TextField AdvancedExtxt[] = {extxtAdvSector1, extxtAdvSector2, extxtAdvSector3, extxtAdvSector4, 
				extxtAdvSector5, extxtAdvSector6, extxtAdvSector7 };
		
		total = 0;
		for (TextField textField : AdvancedExtxt) {
			if (!textField.getText().isEmpty()) {
				total = total + stringToInt(textField.getText());
			}
		}
		exlblAdvTotalExpensed.setText(addThousandSeparator(intToString(total)));
	}
	
	
	@FXML
	private void extxtAdvSector1() {
		if (!validAmount(extxtAdvSector1.getText())) {
			if (!extxtAdvSector1.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector1.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	@FXML
	private void extxtAdvSector2() {
		if (!validAmount(extxtAdvSector2.getText())) {
			if (!extxtAdvSector2.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector2.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	@FXML
	private void extxtAdvSector3() {
		if (!validAmount(extxtAdvSector3.getText())) {
			if (!extxtAdvSector3.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector3.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	@FXML
	private void extxtAdvSector4() {
		if (!validAmount(extxtAdvSector4.getText())) {
			if (!extxtAdvSector4.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector4.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	@FXML
	private void extxtAdvSector5() {
		if (!validAmount(extxtAdvSector5.getText())) {
			if (!extxtAdvSector5.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector5.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	@FXML
	private void extxtAdvSector6() {
		if (!validAmount(extxtAdvSector6.getText())) {
			if (!extxtAdvSector6.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector6.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	@FXML
	private void extxtAdvSector7() {
		if (!validAmount(extxtAdvSector7.getText())) {
			if (!extxtAdvSector7.getText().isEmpty()) {
				exlblAdvWarningMsg.setText(InvalidInput);
				extxtAdvSector7.clear();				
			}
		} else {
			exlblAdvWarningMsg.setText("");
			showAdvExTotalEx();
		}
	}
	
	
	@FXML
	private void exAdvDescriptionValidation() {
		int wordRemain = letterCount(extxtAdvancedDescription.getText());
		
		if (wordRemain<0) {
			extxtAdvancedDescription.setEditable(false);
			exlblAdvLetterRemainmsg.setText("You cross the limit");
		} else {
			exlblAdvWarningMsg.setText("");
			exlblAdvLetterRemainmsg.setText("Word remain: "+wordRemain+"/100");
		}
	}
	
	private boolean exIsAdvDescripionEmpty() {
		if (letterCount(extxtAdvancedDescription.getText()) == 100) {
			return true;
		} else {
			return false;
		}
	}
	
	@FXML
	private void exbtnAdvancedAdjustBalance(ActionEvent event) {
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
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else if (amountIsZero(typedAmount)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("Zero is not approved.");
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			} else {
				long dbWalletBalance = currentWalletBalance();
				long typedBalance = stringToLong(typedAmount);
				String exAdvAdjustBalAfter = typedAmount;
				String exAdvAdjustAmount;
				if (dbWalletBalance<typedBalance) {
					exAdvAdjustAmount = "added "+longToString(typedBalance - dbWalletBalance)+" to Wallet";
				} else if(dbWalletBalance>typedBalance) {
					exAdvAdjustAmount = exWalletBalanceAfter(typedAmount);
				} else {
					exAdvAdjustAmount = "0.0";
				}
				try {
					Map<String, String> expenseData = new HashMap<>();
					
					expenseData.put("exTime", timeToSave());
					expenseData.put("exDate", (new DateFormatManager()).toString(exdateAdvancedDate.getValue()));
					expenseData.put("exMonth", monthToSave(exdateAdvancedDate.getValue()));
					expenseData.put("exAmount", exAdvAdjustAmount);
					if (exIsAdvDescripionEmpty()) {
						expenseData.put("exDescription", "You have adjusted your Wallet Balance");
					} else {
						expenseData.put("exDescription", extxtAdvancedDescription.getText());
					}
					expenseData.put("exSector", "Adjusted Balance");
					expenseData.put("exWalletBalanceBefore", getWalletBalance());
					expenseData.put("exWalletBalanceAfter", exAdvAdjustBalAfter);
					setCurrentWalletBalance(exAdvAdjustBalAfter);
					
					(new Expense()).saveExpenseData(expenseData);
					(new ComboboxList()).setAllMonth(monthToSave(exdateAdvancedDate.getValue()), yearToSave(exdateAdvancedDate.getValue()));
					(new ComboboxList()).setAllExMonth(monthToSave(exdateAdvancedDate.getValue()), yearToSave(exdateAdvancedDate.getValue()));
					
					exInitialize();
					extxtAdvancedDescription.clear();
					
					Alert confirmationMsg = new Alert(AlertType.INFORMATION);
					confirmationMsg.setTitle("Successfull Transaction");
					confirmationMsg.setHeaderText(null);
					confirmationMsg.setContentText("Successful");
					confirmationMsg.setX(MakeATransactionStage.getX() + 200);
					confirmationMsg.setY(MakeATransactionStage.getY() + 29);
				    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
				    {
				        @Override
				        public void handle( ActionEvent event )
				        {
				        	confirmationMsg.hide();
				        }
				    } ) );
				    idlestage.setCycleCount( 1 );
				    idlestage.play();
				    confirmationMsg.showAndWait();
					
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText("There something is wrong.");
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
				    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
				    {
				        @Override
				        public void handle( ActionEvent event )
				        {
				        	alert.hide();
				        }
				    } ) );
				    idlestage.setCycleCount( 1 );
				    idlestage.play();
				    alert.showAndWait();
				}
			}
		}
	}
	
	
	@FXML
	private void exbtnGoToExpenseSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabAdvanced");
		Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
	}
	
	
	@FXML
	private void exbtnAdvancedSave(ActionEvent event) {
		if (total == 0) {
			exlblAdvWarningMsg.setText("Empty or Zero is not approved.");
		} else {
			TextField AdvancedExtxt[] = {extxtAdvSector1, extxtAdvSector2, extxtAdvSector3, extxtAdvSector4, 
					extxtAdvSector5, extxtAdvSector6, extxtAdvSector7 };
			
			Label AdvancedExlbl[] = {exlblAdvSector1, exlblAdvSector2, exlblAdvSector3, exlblAdvSector4, 
					exlblAdvSector5, exlblAdvSector6, exlblAdvSector7 };
			
			int index = 0;
			for (TextField textField : AdvancedExtxt) {
				if ((!textField.getText().isEmpty()) && (!textField.getText().equals("0"))) {
					exAdvSaveFunction(textField.getText(), AdvancedExlbl[index].getText());
				}
				++index;
			}
			
			exInitialize();
			extxtAdvancedDescription.clear();
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Successful Transaction");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Successful");
			Stage MakeATransactionStage = (Stage) exbtnSave.getScene().getWindow();
			confirmationMsg.setX(MakeATransactionStage.getX() + 200);
			confirmationMsg.setY(MakeATransactionStage.getY() + 29);
		    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
		    {
		        @Override
		        public void handle( ActionEvent event )
		        {
		        	confirmationMsg.hide();
		        }
		    } ) );
		    idlestage.setCycleCount( 1 );
		    idlestage.play();
		    confirmationMsg.showAndWait();
			(new GoToOperation()).goToDashboard(MakeATransactionStage);
		}
	}
	
	
	@FXML
	private void exbtnAdvancedSaveAndAdd(ActionEvent event) {
		if (total == 0) {
			exlblAdvWarningMsg.setText("Empty or Zero is not approved.");
		} else {
			TextField AdvancedExtxt[] = {extxtAdvSector1, extxtAdvSector2, extxtAdvSector3, extxtAdvSector4, 
					extxtAdvSector5, extxtAdvSector6, extxtAdvSector7 };
			
			Label AdvancedExlbl[] = {exlblAdvSector1, exlblAdvSector2, exlblAdvSector3, exlblAdvSector4, 
					exlblAdvSector5, exlblAdvSector6, exlblAdvSector7 };
			
			int index = 0;
			for (TextField textField : AdvancedExtxt) {
				if ((!textField.getText().isEmpty()) && (!textField.getText().equals("0"))) {
					exAdvSaveFunction(textField.getText(), AdvancedExlbl[index].getText());
				}
				++index;
			}
			
			exInitialize();
			extxtAdvancedDescription.clear();
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Successfull Transaction");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Your transaction completed successfully.");
			Stage MakeATransactionStage = (Stage) exbtnSave.getScene().getWindow();
			confirmationMsg.setX(MakeATransactionStage.getX() + 200);
			confirmationMsg.setY(MakeATransactionStage.getY() + 29);
			Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
		    {
		        @Override
		        public void handle( ActionEvent event )
		        {
		        	confirmationMsg.hide();
		        }
		    } ) );
		    idlestage.setCycleCount( 1 );
		    idlestage.play();
			confirmationMsg.showAndWait();
		}
	}
	
		
	private void exAdvSaveFunction(String amount, String sectorName) {
		try {
			Map<String, String> expenseData = new HashMap<>();
			
			expenseData.put("exTime", timeToSave());
			expenseData.put("exDate", (new DateFormatManager()).toString(exdateAdvancedDate.getValue()));
			expenseData.put("exMonth", monthToSave(exdateAdvancedDate.getValue()));
			expenseData.put("exAmount", amount);
			if (exIsAdvDescripionEmpty()) {
				expenseData.put("exDescription", "None");
			} else {
				expenseData.put("exDescription", extxtAdvancedDescription.getText());
			}
			expenseData.put("exSector", sectorName);
			expenseData.put("exWalletBalanceBefore", getWalletBalance());
			expenseData.put("exWalletBalanceAfter", exWalletBalanceAfter(amount));
			setCurrentWalletBalance(exWalletBalanceAfter(amount));
			
			(new Expense()).saveExpenseData(expenseData);
			(new ComboboxList()).setAllMonth(monthToSave(exdateAdvancedDate.getValue()), yearToSave(exdateAdvancedDate.getValue()));
			(new ComboboxList()).setAllExMonth(monthToSave(exdateAdvancedDate.getValue()), yearToSave(exdateAdvancedDate.getValue()));
			
		} catch (Exception e) {}
	}
	
	
////////////////////////////////////////////     Lend Function    ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------------//
	private String selectedTabName = "Borrow";
	
	@FXML
	private void tabLend() {
		boInitialize();
		lenddateDate.setConverter(formatManager);
		lenddateDate.setValue(date);
		if (getWeekStatus()) {
			lenddateDate.setShowWeekNumbers(true);
		}
	}

	
	@FXML
	private void boInitialize() {
		selectedTabName = "Borrow";
		try {
			showBorroTblData();
		} catch (Exception e) {}
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
//		lenddateDate.setConverter(formatManager);
//		lenddateDate.setValue(date);
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
			if (BankIssue.isbKashActivated()) {
				lendlblbkAccountBalanceName.setVisible(true);
				lendlblBkBalance.setVisible(true);
				lendlblBkBalance.setText(addThousandSeparator(getbkAccountBalance()));
			} else {
				lendlblbkAccountBalanceName.setVisible(false);
				lendlblBkBalance.setVisible(false);
			}
		} catch (Exception e) {}
	}
	
	
	private void lendRocBalanceShow() {
		try {
			if (BankIssue.isRocketActivated()) {
				lendlblrocAccountBalanceName.setVisible(true);
				lendlblRocBalance.setVisible(true);
				lendlblRocBalance.setText(addThousandSeparator(getRocAccountBalance()));
			} else {
				lendlblrocAccountBalanceName.setVisible(false);
				lendlblRocBalance.setVisible(false);
			}
		} catch (Exception e) {}
	}
	
///////////////////////// Borrow ////////////////////////////
	final ToggleGroup boRocInRbtnGroup = new ToggleGroup();
	final ToggleGroup boBkRbtnGroup = new ToggleGroup();
	final ToggleGroup boRocOutRbtnGroup = new ToggleGroup();
	
	@SuppressWarnings("unchecked")
	private void showBorroTblData() {
		try {
			lendlblTableHeading.setText("Borrow Summary");
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
			if (!botxtAmountWithCharge.getText().isEmpty()) {
				bolblAmountValidationMsg.setText(InvalidInput);
				botxtAmountWithCharge.clear();				
			}
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
			if (!botxtExactAmount.getText().isEmpty()) {
				bolblAmountValidationMsg2.setText(InvalidInput);
				bolblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
				botxtExactAmount.clear();				
			}
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
		lendlblTableHeading.setText("Lend Summary");
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
			if (!letxtAmountWithCharge.getText().isEmpty()) {
				lelblAmountValidationMsg.setText(InvalidInput);
				letxtAmountWithCharge.clear();				
			}
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
			if (!letxtExactAmount.getText().isEmpty()) {
				lelblAmountValidationMsg2.setText(InvalidInput);
				lelblWarningMsg.setText("Due to Bank Charges, amount may not be accurate. Type exact Amount");
				letxtExactAmount.clear();				
			}
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							boleData.put("boTime", timeToSave());
							boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("boMonth", monthToSave(lenddateDate.getValue()));
							boleData.put("boType", bocmboType.getValue());
							boleData.put("boMethod", bocmboMethod.getValue());
							boleData.put("boWhom", botxtFromWhom.getText());
							boleData.put("boTk", botxtAmountWithCharge.getText());
							boleData.put("boNature", "None");
							boleData.put("boBnkCharge", boBankChargeShow());
							boleData.put("boBalanceBefore", longToString(totalBorrowTk()));
							boleData.put("boBalanceAfter", updatedTotalBorrowTk(botxtExactAmount.getText(), "Money Take"));
							boleData.put("boExactTk", botxtExactAmount.getText());
							boleData.put("bkBalanceBefore", longToString(currentbKashBalance()));
							boleData.put("bkBalanceAfter", updatedbKashBalance(botxtAmountWithCharge.getText(), "Cash In"));
							
							(new Borrow()).addBorrowSummaryData(boleData);
							(new Bkash()).saveBorrowBkashData(boleData);
							(new Borrow()).saveBorrowData(boleData);
							(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
							setCurrentbKashBalance(updatedbKashBalance(botxtAmountWithCharge.getText(), "Cash In"));
//							setCurrentbKashBalance(boBkBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Money Take"));
							setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(), "Money Take"));
							boInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Successful");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 29);
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	confirmationMsg.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							boleData.put("boTime", timeToSave());
							boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("boMonth", monthToSave(lenddateDate.getValue()));
							boleData.put("boType", bocmboType.getValue());
							boleData.put("boMethod", bocmboMethod.getValue());
							boleData.put("boWhom", botxtFromWhom.getText());
							boleData.put("boTk", botxtAmountWithCharge.getText());
							boleData.put("boNature", boGetSelectedrbtnName());
							boleData.put("boBnkCharge", boBankChargeShow());
							boleData.put("boBalanceBefore", longToString(totalBorrowTk()));
							boleData.put("boBalanceAfter", updatedTotalBorrowTk(botxtExactAmount.getText(), "Money Take"));
							boleData.put("boExactTk", botxtExactAmount.getText());
							boleData.put("rocBalanceBefore", longToString(currentRocketBalance()));
							boleData.put("rocBalanceAfter", updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash In", boGetSelectedrbtnName()));
							
							(new Borrow()).addBorrowSummaryData(boleData);
							(new Rocket()).saveBorrowRocketData(boleData);
							(new Borrow()).saveBorrowData(boleData);
							(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
							setCurrentRocketBalance(updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash In", boGetSelectedrbtnName()));
//							setCurrentRocketBalance(boRocBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Money Take"));
							setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(), "Money Take"));
							boInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Successful");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 29);
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	confirmationMsg.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							boleData.put("boTime", timeToSave());
							boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("boMonth", monthToSave(lenddateDate.getValue()));
							boleData.put("boType", bocmboType.getValue());
							boleData.put("boMethod", bocmboMethod.getValue());
							boleData.put("boWhom", botxtFromWhom.getText());
							boleData.put("boTk", botxtAmountWithCharge.getText());
							boleData.put("boNature", "None");
							boleData.put("boBnkCharge", "None");
							boleData.put("boBalanceBefore", longToString(totalBorrowTk()));
							boleData.put("boBalanceAfter", updatedTotalBorrowTk(botxtAmountWithCharge.getText(), "Money Take"));
							boleData.put("boExactTk", botxtAmountWithCharge.getText());
							boleData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
							boleData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(botxtAmountWithCharge.getText()));
							
							(new Borrow()).saveBorrowData(boleData);
							(new Borrow()).addBorrowSummaryData(boleData);
							// if it activate, then you have to change in Undo Class --> undoBorrow() method
//							(new GetMoney()).saveBorrowGMData(boleData);
							(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
							setCurrentWalletBalance(gmWalletBalanceAfter(botxtAmountWithCharge.getText()));
							setTotalBorrowTk(updatedTotalBorrowTk(botxtAmountWithCharge.getText(), "Money Take"));
							boInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Successful");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 29);
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	confirmationMsg.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							if (boRepayValidation(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
								boleData.put("boTime", timeToSave());
								boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("boMonth", monthToSave(lenddateDate.getValue()));
								boleData.put("boType", bocmboType.getValue());
								boleData.put("boMethod", bocmboMethod.getValue());
								boleData.put("boWhom", bocmboRepaidPerson.getValue());
								boleData.put("boTk", botxtAmountWithCharge.getText());
								boleData.put("boNature", boGetSelectedrbtnName());
								boleData.put("boBnkCharge", boBankChargeShow());
								boleData.put("boBalanceBefore", longToString(totalBorrowTk()));
								boleData.put("boBalanceAfter", updatedTotalBorrowTk(botxtExactAmount.getText(),"Return Borrowed Money"));
								boleData.put("boExactTk", botxtExactAmount.getText());
								boleData.put("bkBalanceBefore", longToString(currentbKashBalance()));
								boleData.put("bkBalanceAfter", updatedbKashBalance(botxtAmountWithCharge.getText(), boGetSelectedrbtnName()));
								
								if (boisTypedAmountLessThanBorrowed(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
									(new Borrow()).updateBorrowSummaryData(boleData);
								} else {
									(new Borrow()).deleteBorrowSummaryData(boleData);
								}
								(new Bkash()).saveBorrowBkashData(boleData);
								(new Borrow()).saveBorrowData(boleData);
								(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
								setCurrentbKashBalance(updatedbKashBalance(botxtAmountWithCharge.getText(), boGetSelectedrbtnName()));
//								setCurrentbKashBalance(boBkBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Return Borrowed Money"));
								setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(),"Return Borrowed Money"));
								boInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Successful");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 29);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	confirmationMsg.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
							    confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	alert.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							if (boRepayValidation(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
								boleData.put("boTime", timeToSave());
								boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("boMonth", monthToSave(lenddateDate.getValue()));
								boleData.put("boType", bocmboType.getValue());
								boleData.put("boMethod", bocmboMethod.getValue());
								boleData.put("boWhom", bocmboRepaidPerson.getValue());
								boleData.put("boTk", botxtAmountWithCharge.getText());
								boleData.put("boNature", boGetSelectedrbtnName());
								boleData.put("boBnkCharge", boBankChargeShow());
								boleData.put("boBalanceBefore", longToString(totalBorrowTk()));
								boleData.put("boBalanceAfter", updatedTotalBorrowTk(botxtExactAmount.getText(),"Return Borrowed Money"));
								boleData.put("boExactTk", botxtExactAmount.getText());
								boleData.put("rocBalanceBefore", longToString(currentRocketBalance()));
								boleData.put("rocBalanceAfter", updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash Out", boGetSelectedrbtnName()));
								
								if (boisTypedAmountLessThanBorrowed(botxtExactAmount.getText(), bocmboRepaidPerson.getValue())) {
									(new Borrow()).updateBorrowSummaryData(boleData);
								} else {
									(new Borrow()).deleteBorrowSummaryData(boleData);
								}
								(new Rocket()).saveBorrowRocketData(boleData);
								(new Borrow()).saveBorrowData(boleData);
								(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
								setCurrentRocketBalance(updatedRocketBalance(botxtAmountWithCharge.getText(), "Cash Out", boGetSelectedrbtnName()));
//								setCurrentRocketBalance(boRocBalanceAfter(botxtAmountWithCharge.getText(), boBankChargeShow(), "Return Borrowed Money"));
								setTotalBorrowTk(updatedTotalBorrowTk(botxtExactAmount.getText(),"Return Borrowed Money"));
								boInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Successful");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 29);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	confirmationMsg.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
							    confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	alert.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							if (boRepayValidation(botxtAmountWithCharge.getText(), bocmboRepaidPerson.getValue())) {
								boleData.put("boTime", timeToSave());
								boleData.put("boDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("boMonth", monthToSave(lenddateDate.getValue()));
								boleData.put("boType", bocmboType.getValue());
								boleData.put("boMethod", bocmboMethod.getValue());
								boleData.put("boWhom", bocmboRepaidPerson.getValue());
								boleData.put("boTk", botxtAmountWithCharge.getText());
								boleData.put("boNature", "None");
								boleData.put("boBnkCharge", "None");
								boleData.put("boBalanceBefore", longToString(totalBorrowTk()));
								boleData.put("boBalanceAfter", updatedTotalBorrowTk(botxtAmountWithCharge.getText(),"Return Borrowed Money"));
								boleData.put("boExactTk", botxtAmountWithCharge.getText());
								boleData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
								boleData.put("gmWalletBalanceAfter", exWalletBalanceAfter(botxtAmountWithCharge.getText()));
								
								(new Borrow()).saveBorrowData(boleData);
								if (boisTypedAmountLessThanBorrowed(botxtAmountWithCharge.getText(), bocmboRepaidPerson.getValue())) {
									(new Borrow()).updateBorrowSummaryData(boleData);
								} else {
									(new Borrow()).deleteBorrowSummaryData(boleData);
								}
								// if it activate, then you have to change in Undo Class --> undoBorrow() method
//								(new GetMoney()).saveBorrowGMData(boleData);
								(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
								setCurrentWalletBalance(exWalletBalanceAfter(botxtAmountWithCharge.getText()));
								setTotalBorrowTk(updatedTotalBorrowTk(botxtAmountWithCharge.getText(),"Return Borrowed Money"));
								boInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Successful");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 29);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	confirmationMsg.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
							    confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	alert.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							boleData.put("leTime", timeToSave());
							boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("leMonth", monthToSave(lenddateDate.getValue()));
							boleData.put("leType", lecmboType.getValue());
							boleData.put("leMethod", lecmboMethod.getValue());
							boleData.put("leWhom", letxtFromWhom.getText());
							boleData.put("leTk", letxtAmountWithCharge.getText());
							boleData.put("leNature", leGetSelectedrbtnName());
							boleData.put("leBnkCharge", leBankChargeShow());
							boleData.put("leBalanceBefore", longToString(totalLendTk()));
							boleData.put("leBalanceAfter", updatedTotalLendTk(letxtExactAmount.getText(), "Give Money"));
							boleData.put("leExactTk", letxtExactAmount.getText());
							boleData.put("bkBalanceBefore", longToString(currentbKashBalance()));
							boleData.put("bkBalanceAfter", updatedbKashBalance(letxtAmountWithCharge.getText(), leGetSelectedrbtnName()));
							
							(new Lend()).addLendSummaryData(boleData);
							(new Bkash()).saveLendBkashData(boleData);
							(new Lend()).saveLendData(boleData);
							(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
							setCurrentbKashBalance(updatedbKashBalance(letxtAmountWithCharge.getText(), leGetSelectedrbtnName()));
//							setCurrentbKashBalance(leBkBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Give Money"));
							setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(), "Give Money"));
							leInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Successful");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 29);
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	confirmationMsg.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							boleData.put("leTime", timeToSave());
							boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("leMonth", monthToSave(lenddateDate.getValue()));
							boleData.put("leType", lecmboType.getValue());
							boleData.put("leMethod", lecmboMethod.getValue());
							boleData.put("leWhom", letxtFromWhom.getText());
							boleData.put("leTk", letxtAmountWithCharge.getText());
							boleData.put("leNature", leGetSelectedrbtnName());
							boleData.put("leBnkCharge", leBankChargeShow());
							boleData.put("leBalanceBefore", longToString(totalLendTk()));
							boleData.put("leBalanceAfter", updatedTotalLendTk(letxtExactAmount.getText(), "Give Money"));
							boleData.put("leExactTk", letxtExactAmount.getText());
							boleData.put("rocBalanceBefore", longToString(currentRocketBalance()));
							boleData.put("rocBalanceAfter", updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash Out", leGetSelectedrbtnName()));
							
							(new Lend()).addLendSummaryData(boleData);
							(new Rocket()).saveLendRocketData(boleData);
							(new Lend()).saveLendData(boleData);
							(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
							setCurrentRocketBalance(updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash Out", leGetSelectedrbtnName()));
//							setCurrentRocketBalance(leRocBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Give Money"));
							setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(), "Give Money"));
							leInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Successful");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 29);
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	confirmationMsg.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							boleData.put("leTime", timeToSave());
							boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
							boleData.put("leMonth", monthToSave(lenddateDate.getValue()));
							boleData.put("leType", lecmboType.getValue());
							boleData.put("leMethod", lecmboMethod.getValue());
							boleData.put("leWhom", letxtFromWhom.getText());
							boleData.put("leTk", letxtAmountWithCharge.getText());
							boleData.put("leNature", "None");
							boleData.put("leBnkCharge", "None");
							boleData.put("leBalanceBefore", longToString(totalLendTk()));
							boleData.put("leBalanceAfter", updatedTotalLendTk(letxtAmountWithCharge.getText(), "Give Money"));
							boleData.put("leExactTk", letxtAmountWithCharge.getText());
							boleData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
							boleData.put("gmWalletBalanceAfter", exWalletBalanceAfter(letxtAmountWithCharge.getText()));
							
							(new Lend()).saveLendData(boleData);
							(new Lend()).addLendSummaryData(boleData);
//							(new GetMoney()).saveLendGMData(boleData);
							(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
							setCurrentWalletBalance(exWalletBalanceAfter(letxtAmountWithCharge.getText()));
							setTotalLendTk(updatedTotalLendTk(letxtAmountWithCharge.getText(), "Give Money"));
							leInitialize();
							
							Alert confirmationMsg = new Alert(AlertType.INFORMATION);
							confirmationMsg.setTitle("Successfull Transaction");
							confirmationMsg.setHeaderText(null);
							confirmationMsg.setContentText("Successful");
							Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
							confirmationMsg.setX(MakeATransactionStage.getX() + 200);
							confirmationMsg.setY(MakeATransactionStage.getY() + 29);
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	confirmationMsg.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							if (leRepayValidation(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
								boleData.put("leTime", timeToSave());
								boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("leMonth", monthToSave(lenddateDate.getValue()));
								boleData.put("leType", lecmboType.getValue());
								boleData.put("leMethod", lecmboMethod.getValue());
								boleData.put("leWhom", lecmboRepaidPerson.getValue());
								boleData.put("leTk", letxtAmountWithCharge.getText());
								boleData.put("leNature", leGetSelectedrbtnName());
								boleData.put("leBnkCharge", leBankChargeShow());
								boleData.put("leBalanceBefore", longToString(totalLendTk()));
								boleData.put("leBalanceAfter", updatedTotalLendTk(letxtExactAmount.getText(),"Take Back Lended Money"));
								boleData.put("leExactTk", letxtExactAmount.getText());
								boleData.put("bkBalanceBefore", longToString(currentbKashBalance()));
								boleData.put("bkBalanceAfter", updatedbKashBalance(letxtAmountWithCharge.getText(), "Cash In"));
								
								if (leisTypedAmountLessThanLended(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
									(new Lend()).updateLendSummaryData(boleData);
								} else {
									(new Lend()).deleteLendSummaryData(boleData);
								}
								(new Bkash()).saveLendBkashData(boleData);
								(new Lend()).saveLendData(boleData);
								(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
								setCurrentbKashBalance(updatedbKashBalance(letxtAmountWithCharge.getText(), "Cash In"));
//								setCurrentbKashBalance(leBkBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Take Back Lended Money"));
								setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(),"Take Back Lended Money"));
								leInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Successful");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 29);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	confirmationMsg.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
							    confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	alert.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							if (leRepayValidation(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
								boleData.put("leTime", timeToSave());
								boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("leMonth", monthToSave(lenddateDate.getValue()));
								boleData.put("leType", lecmboType.getValue());
								boleData.put("leMethod", lecmboMethod.getValue());
								boleData.put("leWhom", lecmboRepaidPerson.getValue());
								boleData.put("leTk", letxtAmountWithCharge.getText());
								boleData.put("leNature", leGetSelectedrbtnName());
								boleData.put("leBnkCharge", leBankChargeShow());
								boleData.put("leBalanceBefore", longToString(totalLendTk()));
								boleData.put("leBalanceAfter", updatedTotalLendTk(letxtExactAmount.getText(),"Take Back Lended Money"));
								boleData.put("leExactTk", letxtExactAmount.getText());
								boleData.put("rocBalanceBefore", longToString(currentRocketBalance()));
								boleData.put("rocBalanceAfter", updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash In", leGetSelectedrbtnName()));
								
								if (leisTypedAmountLessThanLended(letxtExactAmount.getText(), lecmboRepaidPerson.getValue())) {
									(new Lend()).updateLendSummaryData(boleData);
								} else {
									(new Lend()).deleteLendSummaryData(boleData);
								}
								(new Rocket()).saveLendRocketData(boleData);
								(new Lend()).saveLendData(boleData);
								(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
								setCurrentRocketBalance(updatedRocketBalance(letxtAmountWithCharge.getText(), "Cash In", leGetSelectedrbtnName()));
//								setCurrentRocketBalance(leRocBalanceAfter(letxtAmountWithCharge.getText(), leBankChargeShow(), "Take Back Lended Money"));
								setTotalLendTk(updatedTotalLendTk(letxtExactAmount.getText(),"Take Back Lended Money"));
								leInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Successful");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 29);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	confirmationMsg.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
							    confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than borrowed amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	alert.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
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
						    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
						    {
						        @Override
						        public void handle( ActionEvent event )
						        {
						        	alert.hide();
						        }
						    } ) );
						    idlestage.setCycleCount( 1 );
						    idlestage.play();
						    alert.showAndWait();
						} else {
							if (leRepayValidation(letxtAmountWithCharge.getText(), lecmboRepaidPerson.getValue())) {
								boleData.put("leTime", timeToSave());
								boleData.put("leDate", (new DateFormatManager()).toString(lenddateDate.getValue()));
								boleData.put("leMonth", monthToSave(lenddateDate.getValue()));
								boleData.put("leType", lecmboType.getValue());
								boleData.put("leMethod", lecmboMethod.getValue());
								boleData.put("leWhom", lecmboRepaidPerson.getValue());
								boleData.put("leTk", letxtAmountWithCharge.getText());
								boleData.put("leNature", "None");
								boleData.put("leBnkCharge", "None");
								boleData.put("leBalanceBefore", longToString(totalLendTk()));
								boleData.put("leBalanceAfter", updatedTotalLendTk(letxtAmountWithCharge.getText(),"Take Back Lended Money"));
								boleData.put("leExactTk", letxtAmountWithCharge.getText());
								boleData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
								boleData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(letxtAmountWithCharge.getText()));
								
								(new Lend()).saveLendData(boleData);
								if (leisTypedAmountLessThanLended(letxtAmountWithCharge.getText(), lecmboRepaidPerson.getValue())) {
									(new Lend()).updateLendSummaryData(boleData);
								} else {
									(new Lend()).deleteLendSummaryData(boleData);
								}
//								(new GetMoney()).saveLendGMData(boleData);
								(new ComboboxList()).setAllMonth(monthToSave(lenddateDate.getValue()), yearToSave(lenddateDate.getValue()));
								setCurrentWalletBalance(gmWalletBalanceAfter(letxtAmountWithCharge.getText()));
								setTotalLendTk(updatedTotalLendTk(letxtAmountWithCharge.getText(),"Take Back Lended Money"));
								leInitialize();
								
								Alert confirmationMsg = new Alert(AlertType.INFORMATION);
								confirmationMsg.setTitle("Successfull Transaction");
								confirmationMsg.setHeaderText(null);
								confirmationMsg.setContentText("Successful");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								confirmationMsg.setX(MakeATransactionStage.getX() + 200);
								confirmationMsg.setY(MakeATransactionStage.getY() + 29);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	confirmationMsg.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
							    confirmationMsg.showAndWait();
							} else {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Transaction Failed");
								alert.setHeaderText(null);
								alert.setContentText("Amount can't bigger than lended amount");
								Stage MakeATransactionStage = (Stage) lendbtnSave.getScene().getWindow();
								alert.setX(MakeATransactionStage.getX() + 200);
								alert.setY(MakeATransactionStage.getY() + 170);
							    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
							    {
							        @Override
							        public void handle( ActionEvent event )
							        {
							        	alert.hide();
							        }
							    } ) );
							    idlestage.setCycleCount( 1 );
							    idlestage.play();
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
		try {
			bnkdateDate.setConverter(formatManager);
			bnkdateDate.setValue(date);
			if (getWeekStatus()) {
				bnkdateDate.setShowWeekNumbers(true);
			}
		} catch (Exception e) {}
		if (!BankIssue.isbKashActivated()) {
			tabbKash.setDisable(true);
		} else {
			tabbKash.setDisable(false);
		}
		if (!BankIssue.isRocketActivated()) {
			tabRocket.setDisable(true);
		} else {
			tabRocket.setDisable(false);
		}
		if (BankIssue.isbKashActivated() && BankIssue.isRocketActivated()) {
			bkInitialize();
			rocInitialize();
			perInitialize();
		} else if (BankIssue.isRocketActivated()) {
			rocInitialize();
			perInitialize();
		} else if(BankIssue.isbKashActivated()){
			bkInitialize();
			perInitialize();
		} else {
			perInitialize();
		}
	}
	
	
	@FXML
	private void bkInitialize() {
		bnkSelectedTabName = "bKash";
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
//		try {
//			bnkdateDate.setConverter(formatManager);
//			bnkdateDate.setValue(date);
//			if (getWeekStatus()) {
//				bnkdateDate.setShowWeekNumbers(true);
//			}
//		} catch (Exception e) {}
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
//		try {
//			bnkdateDate.setConverter(formatManager);
//			bnkdateDate.setValue(date);
//			if (getWeekStatus()) {
//				bnkdateDate.setShowWeekNumbers(true);
//			}
//		} catch (Exception e) {}
		perLoadNature();
		perAccountBalanceShow();
		showWalletBalance();
		pertxtAmount.clear();
	}
	
	
	@FXML
	private void bnkSettingBtn(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage MakeATransactionStage = (Stage) bnkbtnSettings.getScene().getWindow();
		(new GoToOperation()).goToSettings(MakeATransactionStage);
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
			if (!bktxtAmount.getText().isEmpty()) {
				bkAmountValidationMsg.setText(InvalidInput);
				bktxtAmount.clear();
				bklblBankChargeName.setText("");
				bklblBankCharge.setText("");				
			}
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
			bklblBankCharge.setText("0.00");
			bkRbtnShow();
			bkUpdatedBkBalanceShow();
			bkBankChargeShow();
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
			if (!roctxtAmount.getText().isEmpty()) {
				rocAmountValidationMsg.setText(InvalidInput);
				roctxtAmount.clear();
				roclblBankChargeName.setText("");
				roclblBankCharge.setText("");				
			}
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

	
/////////////////////// Personal /////////////////////////
	
	@FXML
	private void perAmountValidation() {
		if (!validAmount(pertxtAmount.getText())) {
			if (!pertxtAmount.getText().isEmpty()) {
				perAmountValidationMsg.setText(InvalidInput);
				pertxtAmount.clear();				
			}
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
				    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
				    {
				        @Override
				        public void handle( ActionEvent event )
				        {
				        	alert.hide();
				        }
				    } ) );
				    idlestage.setCycleCount( 1 );
				    idlestage.play();
				    alert.showAndWait();
				} else if (amountIsZero(typedAmount)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText("Zero is not approved.");
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
				    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
				    {
				        @Override
				        public void handle( ActionEvent event )
				        {
				        	alert.hide();
				        }
				    } ) );
				    idlestage.setCycleCount( 1 );
				    idlestage.play();
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
				    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
				    {
				        @Override
				        public void handle( ActionEvent event )
				        {
				        	alert.hide();
				        }
				    } ) );
				    idlestage.setCycleCount( 1 );
				    idlestage.play();
				    alert.showAndWait();
				} else if (amountIsZero(typedAmount)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Transaction Failed");
					alert.setHeaderText(null);
					alert.setContentText("Zero is not approved.");
					alert.setX(MakeATransactionStage.getX() + 200);
					alert.setY(MakeATransactionStage.getY() + 170);
				    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
				    {
				        @Override
				        public void handle( ActionEvent event )
				        {
				        	alert.hide();
				        }
				    } ) );
				    idlestage.setCycleCount( 1 );
				    idlestage.play();
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
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
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
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
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
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
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
				bnkData.put("bkMonth", monthToSave(bnkdateDate.getValue()));
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
					if (bkcmboAmountNature.getValue().equals("Credit")) {
						bnkData.put("bkNature", "Credited by "+bkGetSelectedRbtn());						
					} else {
						bnkData.put("bkNature", "Debited by "+bkGetSelectedRbtn());
					}
					bnkData.put("bkAmount", bktxtAmount.getText());
					bnkData.put("bkBnkCharge", bkBankChargeShow());
					bnkData.put("bkBalanceAfter", updatedbKashBalance(bktxtAmount.getText(), bkGetSelectedRbtn()));
					
					if (bkcmboAmountNature.getValue().equals("Debit")) {
						if (bkcmboTransactionType.getValue().equals("Personal")) {
							bnkData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
							bnkData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(bktxtAmount.getText()));
							setCurrentWalletBalance(gmWalletBalanceAfter(bktxtAmount.getText()));
						} else if(bkcmboTransactionType.getValue().equals("Get Money")) {
							bnkData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
							bnkData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(bktxtAmount.getText()));
							(new GetMoney()).saveBnkBkashData(bnkData);
							setCurrentWalletBalance(gmWalletBalanceAfter(bktxtAmount.getText()));
						}
					}
					(new Bkash()).saveBnkBkashData(bnkData);
					setCurrentbKashBalance(updatedbKashBalance(bktxtAmount.getText(), bkGetSelectedRbtn()));
				}
				
				(new ComboboxList()).setAllMonth(monthToSave(bnkdateDate.getValue()), yearToSave(bnkdateDate.getValue()));
				bkInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successful Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Successful");
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 29);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			}
			
		} else if(bnkSelectedTabName.equals("Rocket")) {

			try {
				bnkData.put("rocTime", timeToSave());
				bnkData.put("rocDate", (new DateFormatManager()).toString(bnkdateDate.getValue()));
				bnkData.put("rocMonth", monthToSave(bnkdateDate.getValue()));
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
					if (roccmboAmountNature.getValue().equals("Credit")) {
						bnkData.put("rocNature", "Credited by "+rocGetSelectedRbtn());
					} else {
						bnkData.put("rocNature", "Debited by "+rocGetSelectedRbtn());
					}
					bnkData.put("rocAmount", roctxtAmount.getText());
					bnkData.put("rocBnkCharge", rocBankChargeShow());
					
					if (roccmboAmountNature.getValue().equals("Credit")) {

						bnkData.put("rocBalanceAfter", updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn()));
						setCurrentRocketBalance(updatedRocketBalance(roctxtAmount.getText(), "Cash In", rocGetSelectedRbtn()));

					} else {
						bnkData.put("rocBalanceAfter", updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn()));
						setCurrentRocketBalance(updatedRocketBalance(roctxtAmount.getText(), "Cash Out", rocGetSelectedRbtn()));
						
						if (roccmboTransactionType.getValue().equals("Personal")) {
							bnkData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
							bnkData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(roctxtAmount.getText()));
							setCurrentWalletBalance(gmWalletBalanceAfter(roctxtAmount.getText()));							
						} else if(roccmboTransactionType.getValue().equals("Get Money")) {
							bnkData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
							bnkData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(roctxtAmount.getText()));
							(new GetMoney()).saveBnkRocketData(bnkData);
							setCurrentWalletBalance(gmWalletBalanceAfter(roctxtAmount.getText()));								
						}
						
					}
					(new Rocket()).saveBnkRocketData(bnkData);
				}
				
				(new ComboboxList()).setAllMonth(monthToSave(bnkdateDate.getValue()), yearToSave(bnkdateDate.getValue()));
				rocInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Successful");
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 29);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			}
			
		} else {
			try {
				bnkData.put("perTime", timeToSave());
				bnkData.put("perDate", (new DateFormatManager()).toString(bnkdateDate.getValue()));
				bnkData.put("perMonth", monthToSave(bnkdateDate.getValue()));
				bnkData.put("perNature", percmboAmountNature.getValue());
				bnkData.put("perAmount", pertxtAmount.getText());
				bnkData.put("perBalanceBefore", getPerAccountBalance());
				
				if (percmboAmountNature.getValue().equals("Credit")) {
					bnkData.put("perBalanceAfter", updatedPersonalBalance(pertxtAmount.getText(), "Credit"));
					bnkData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
					bnkData.put("gmWalletBalanceAfter", exWalletBalanceAfter(pertxtAmount.getText()));
					setCurrentWalletBalance(exWalletBalanceAfter(pertxtAmount.getText()));
					setCurrentPersonalBalance(updatedPersonalBalance(pertxtAmount.getText(), "Credit"));
				} else {
					bnkData.put("perBalanceAfter", updatedPersonalBalance(pertxtAmount.getText(), "Debit"));
					bnkData.put("gmWalletBalanceBefore", longToString(currentWalletBalance()));
					bnkData.put("gmWalletBalanceAfter", gmWalletBalanceAfter(pertxtAmount.getText()));
					setCurrentWalletBalance(gmWalletBalanceAfter(pertxtAmount.getText()));
					setCurrentPersonalBalance(updatedPersonalBalance(pertxtAmount.getText(), "Debit"));
				}
				(new Personal()).saveBnkPersonalData(bnkData);
				
				(new ComboboxList()).setAllMonth(monthToSave(bnkdateDate.getValue()), yearToSave(bnkdateDate.getValue()));
				perInitialize();
				
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Successfull Transaction");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Successful");
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				confirmationMsg.setX(MakeATransactionStage.getX() + 200);
				confirmationMsg.setY(MakeATransactionStage.getY() + 29);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(2), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	confirmationMsg.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    confirmationMsg.showAndWait();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Transaction Failed");
				alert.setHeaderText(null);
				alert.setContentText("There something is wrong.");
				Stage MakeATransactionStage = (Stage) btnSignOut.getScene().getWindow();
				alert.setX(MakeATransactionStage.getX() + 200);
				alert.setY(MakeATransactionStage.getY() + 170);
			    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
			    {
			        @Override
			        public void handle( ActionEvent event )
			        {
			        	alert.hide();
			        }
			    } ) );
			    idlestage.setCycleCount( 1 );
			    idlestage.play();
			    alert.showAndWait();
			}
		}
	}
	
}

