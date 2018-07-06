package controller;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CashCalculateModel;
import operation.GoToOperation;
import tab.TabAccess;

public class CashCalculateController extends CashCalculateModel {
	//JavaFX Menu node object
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
	
//	button object
	@FXML
	private Button btnDashboard;
	@FXML
	private Button btnMakeATransaction;
	@FXML
	private Button btnSignOut;
	
//	Label object
	@FXML
	private Label lblLongClock;
	@FXML
	private Label lbl1000;
	@FXML
	private Label lbl500;
	@FXML
	private Label lbl100;
	@FXML
	private Label lbl50;
	@FXML
	private Label lbl20;
	@FXML
	private Label lbl10;
	@FXML
	private Label lbl5;
	@FXML
	private Label lbl2;
	@FXML
	private Label lbl1;
	@FXML
	private Label lblTotal;
	@FXML
	private Label lblWalletBalance;
	@FXML
	private Label lblUserFullName;
	@FXML
	private Label lblNote;
	@FXML
	private Label lblWarningMsg;
	@FXML
	private Label lblSub;
	
//	TextField object
	@FXML
	private TextField txt1000;
	@FXML
	private TextField txt500;
	@FXML
	private TextField txt100;
	@FXML
	private TextField txt50;
	@FXML
	private TextField txt20;
	@FXML
	private TextField txt10;
	@FXML
	private TextField txt5;
	@FXML
	private TextField txt2;
	@FXML
	private TextField txt1;
	
	
//////////////////// General Function //////////////////////////////
	@FXML
	public void initialize() {
		lblUserFullName.setText(userFullName()+" "); //show user full name on Menu
		lblWalletBalance.setText(addThousandSeparator(getWalletBalance())); //show current wallet balance
		CashCalculate(); //set all field initialize value to 0
		
//		add tooltip on mouse hover
		btnDashboard.setTooltip(new Tooltip("Will Take you to Dashboard"));
		btnMakeATransaction.setTooltip(new Tooltip("Will Take you to Expense"));
		btnSignOut.setTooltip(new Tooltip("Sign Out from Application"));
		Tooltip.install(lblWalletBalance, new Tooltip("Your wallet balance now"));
		Tooltip.install(lblUserFullName, new Tooltip("User's Full Name"));
		Tooltip.install(txt1000, new Tooltip("Number of 1000 Tk. Notes in your hand"));
		Tooltip.install(txt500, new Tooltip("Number of 500 Tk. Notes in your hand"));
		Tooltip.install(txt100, new Tooltip("Number of 100 Tk. Notes in your hand"));
		Tooltip.install(txt50, new Tooltip("Number of 50 Tk. Notes in your hand"));
		Tooltip.install(txt20, new Tooltip("Number of 20 Tk. Notes in your hand"));
		Tooltip.install(txt10, new Tooltip("Number of 10 Tk. Notes in your hand"));
		Tooltip.install(txt5, new Tooltip("Number of 5 Tk. Notes in your hand"));
		Tooltip.install(txt2, new Tooltip("Number of 2 Tk. Notes in your hand"));
		Tooltip.install(txt1, new Tooltip("Number of 1 Tk. Notes in your hand"));
	}
	
//////////////////////////////////////////// Menu Function ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------//
//	all menu function
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow(); //create this stage object
		(new GoToOperation()).goToDashboard(CashCalculateStage); //open expected stage
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");//define which tab should open
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(CashCalculateStage);
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(CashCalculateStage);
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(CashCalculateStage);
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(CashCalculateStage);
	}
	
	@FXML
	private void mnuSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(CashCalculateStage);
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(CashCalculateStage);
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		CashCalculateStage.close();
	}
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}
	
	@FXML
	private void mnuUndo(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Action Failed");
		alert.setHeaderText("Undo Function Works Only From \"Make A Transaction\" and \"History\" Window");
		alert.setContentText("Press \"OK\" to go to \"Make A Transaction\" window");
		alert.setX(CashCalculateStage.getX() + 60);
		alert.setY(CashCalculateStage.getY() + 170);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			(new TabAccess()).setTabName("tabGetMoney"); //name of which Tab should open
			(new GoToOperation()).goToMakeATransaction(CashCalculateStage);
		}
	}

	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}
	
	@FXML
	private void mnuAdvancedSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabAdvanced");
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(CashCalculateStage);
	}
	
	@FXML
	private void mnuHowTo(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToHelp(CashCalculateStage);
	}
	
	@FXML
	private void mnuAbout(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToAbout(CashCalculateStage);
	}
	
///////////////////// Button Function ///////////////////////////
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(CashCalculateStage);
	}
	
	@FXML
	private void btnMakeATransaction(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage CashCalculateStage = (Stage) btnMakeATransaction.getScene().getWindow();
		goToMakeATransaction(CashCalculateStage);
	}
	
	@FXML
	private void btnDashboard(ActionEvent event) {
		Stage CashCalculateStage = (Stage) btnDashboard.getScene().getWindow();
		(new GoToOperation()).goToDashboard(CashCalculateStage);
	}
	
	
///////////////////// Cash Calculate Function ///////////////////////////
	final String InvalidInput = "Invalid Input. Type within 0 to 9999";//message if input string is invalid
	
//	On Key Released Event for all textfield
	@FXML
	private void txt1000() {
		if (validAmount(txt1000.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt1000.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt500() {
		if (validAmount(txt500.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt500.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt100() {
		if (validAmount(txt100.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt100.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt50() {
		if (validAmount(txt50.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt50.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt20() {
		if (validAmount(txt20.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt20.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt10() {
		if (validAmount(txt10.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt10.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt5() {
		if (validAmount(txt5.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt5.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt2() {
		if (validAmount(txt2.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt2.setText("");
			lblNote.setText("");
		}
	}
	
	@FXML
	private void txt1() {
		if (validAmount(txt1.getText())) {
			CashCalculate();
			lblNote.setText("Number of Notes");
			lblWarningMsg.setText("");
		} else {
			lblWarningMsg.setText(InvalidInput);
			txt1.setText("");
			lblNote.setText("");
		}
	}
	
//	calculate amount of money
	public void CashCalculate() {
//		add zero if field is empty
		TextField zero[] = {txt1000, txt500, txt100, txt50, txt20, txt10, txt5, txt2, txt1};
		for (TextField textField : zero) {
			if (textField.getText().isEmpty()) {
				textField.setText("0");
			}
		}
//		main calculation
		int total1000 = stringToInt(txt1000.getText())*1000;
		lbl1000.setText(" = " + addThousandSeparator(intToString(total1000)));
		
		int total500 = stringToInt(txt500.getText())*500;
		lbl500.setText(" = " + addThousandSeparator(intToString(total500)));
		
		int total100 = stringToInt(txt100.getText())*100;
		lbl100.setText(" = " + addThousandSeparator(intToString(total100)));
		
		int total50 = stringToInt(txt50.getText())*50;
		lbl50.setText(" = " + addThousandSeparator(intToString(total50)));
		
		int total20 = stringToInt(txt20.getText())*20;
		lbl20.setText(" = " + addThousandSeparator(intToString(total20)));
		
		int total10 = stringToInt(txt10.getText())*10;
		lbl10.setText(" = " + addThousandSeparator(intToString(total10)));
		
		int total5 = stringToInt(txt5.getText())*5;
		lbl5.setText(" = " + addThousandSeparator(intToString(total5)));
		
		int total2 = stringToInt(txt2.getText())*2;
		lbl2.setText(" = " + addThousandSeparator(intToString(total2)));
		
		int total1 = stringToInt(txt1.getText())*1;
		lbl1.setText(" = " + addThousandSeparator(intToString(total1)));
		
		String totalCash = intToString(total1000+total500+total100+total50+total20+total10+total5+total2+total1);
		lblTotal.setText(addThousandSeparator(totalCash));
		
		if (stringToLong(totalCash) == 0) {
			lblSub.setText("");
		} else {
			lblSub.setText("-  "+addThousandSeparator(totalCash)+"  =  "+addThousandSeparator(intToString(longToint(currentWalletBalance())-stringToInt(totalCash))));
		}
	}
	
	
	
	
	
}














