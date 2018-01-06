package controller;

import java.util.Optional;

import help.Help;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import operation.GoToOperation;
import system.DateAndClock;
import tab.TabAccess;

public class HelpController extends DateAndClock {

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
	
	@FXML
	private TextArea txtInfoContainer;
	
////////////////////General Function //////////////////////////////
	@FXML
	public void initialize() {
		lblUserFullName.setText(userFullName()+" ");
		loadInfo();
	}
	
	private void loadInfo() {
			txtInfoContainer.setText(new Help().loadHelpInfo());
	}
	
////////////////////////////////////////////Menu Function ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------//
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToDashboard(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		HelpStage.close();
	}
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuUndo(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Action Failed");
		alert.setHeaderText("Undo Function Works Only From \"Make A Transaction\" and \"History\" Window");
		alert.setContentText("Press \"OK\" to go to \"Make A Transaction\" window");
		alert.setX(HelpStage.getX() + 60);
		alert.setY(HelpStage.getY() + 170);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			(new TabAccess()).setTabName("tabGetMoney"); //name of which Tab should open
			(new GoToOperation()).goToMakeATransaction(HelpStage.getX(), HelpStage.getY());
			HelpStage.close();
		}
	}

	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuAdvancedSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabAdvanced");
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuHowTo(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToHelp(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void mnuAbout(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToAbout(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage HelpStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(HelpStage.getX(), HelpStage.getY());
		HelpStage.close();
	}
	
	
	
}
