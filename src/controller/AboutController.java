package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import operation.GoToOperation;
import system.DateAndClock;
import tab.TabAccess;

public class AboutController extends DateAndClock {
	
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
	

//////////////////// General Function //////////////////////////////
	@FXML
	public void initialize() {
		lblUserFullName.setText(userFullName());
		
	}
	
//////////////////////////////////////////// Menu Function ////////////////////////////////////////////
//---------------------------------------------------------------------------------------------------//
	@FXML
	private void mnuDashboard(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToDashboard(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuGetMoney(ActionEvent event) {
		(new TabAccess()).setTabName("tabGetMoney");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}

	@FXML
	private void mnuExpense(ActionEvent event) {
		(new TabAccess()).setTabName("tabExpense");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}

	@FXML
	private void mnuLend(ActionEvent event) {
		(new TabAccess()).setTabName("tabLend");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}

	@FXML
	private void mnuBank(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToMakeATransaction(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuTransactionHistory(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToTransactionHistory(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuCashCalculate(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToCashCalculate(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuExit(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		AboutStage.close();
	}
	
	@FXML
	private void mnuCreateSource(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}

	@FXML
	private void mnuCreateSector(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}

	@FXML
	private void mnuBankSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabBank");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuSourceSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSource");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}

	@FXML
	private void mnuSectorSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSector");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuSystemSettings(ActionEvent event) {
		(new TabAccess()).setTabName("tabSystem");
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSettings(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuHowTo(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToHelp(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void mnuAbout(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToAbout(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	@FXML
	private void btnSignOut(ActionEvent event) {
		Stage AboutStage = (Stage) btnSignOut.getScene().getWindow();
		(new GoToOperation()).goToSignIn(AboutStage.getX(), AboutStage.getY());
		AboutStage.close();
	}
	
	
	@FXML
	private void hyperlinkLinkedin(ActionEvent event) {
	    openWebpage("https://www.linkedin.com/in/kr-hasan");
	}
	
	
	@FXML
	private void hyperlinkGit(ActionEvent event) {
	    openWebpage("https://github.com/krHasan");
	}
	
	
	public static void openWebpage(String url) {
	    try {
	        new ProcessBuilder("x-www-browser", url).start();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}








