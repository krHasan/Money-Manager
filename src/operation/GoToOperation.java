package operation;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import system.UnitConverter;

public class GoToOperation extends UnitConverter {

	public void goToSignIn(Stage SignInStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/SignIn.fxml"));
			Scene scene = new Scene(root, 800, 550);
			SignInStage.setScene(scene);
			SignInStage.setTitle("Money Manager");
			SignInStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToDashboard(Stage DashboardStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
			Scene scene = new Scene(root, 800, 550);
			DashboardStage.setScene(scene);
			DashboardStage.setTitle("Dashboard");
			DashboardStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToMakeATransaction(Stage MakeATransactionStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MakeATransaction.fxml"));
			Scene scene = new Scene(root, 800, 550);
			MakeATransactionStage.setScene(scene);
			MakeATransactionStage.setTitle("Make A Transaction");
			MakeATransactionStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToSettings(Stage SettingsStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Settings.fxml"));
			Scene scene = new Scene(root, 800, 550);
			SettingsStage.setScene(scene);
			SettingsStage.setTitle("Settings");
			SettingsStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToTransactionHistory(Stage TransactionHistoryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/TransactionHistory.fxml"));
			Scene scene = new Scene(root, 800, 550);
			TransactionHistoryStage.setScene(scene);
			TransactionHistoryStage.setTitle("Transaction History");
			TransactionHistoryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToCashCalculate(Stage CashCalculateStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/CashCalculate.fxml"));
			Scene scene = new Scene(root, 800, 550);
			CashCalculateStage.setScene(scene);
			CashCalculateStage.setTitle("Cash Calculate");
			CashCalculateStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToAbout(Stage AboutStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/About.fxml"));
			Scene scene = new Scene(root, 800, 550);
			AboutStage.setScene(scene);
			AboutStage.setTitle("About");
			AboutStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goToHelp(Stage HelpStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Help.fxml"));
			Scene scene = new Scene(root, 800, 550);
			HelpStage.setScene(scene);
			HelpStage.setTitle("Help");
			HelpStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
