package operation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import system.UnitConverter;

public class GoToOperation extends UnitConverter {
	
	public void goToSignIn(double positionX, double positionY) {
		try {
			Stage SignInStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/SignIn.fxml"));
			Scene scene = new Scene(root,800,550);
			scene.getStylesheets().add(getClass().getResource("/css/SignIn.css").toExternalForm());
			SignInStage.setScene(scene);
			SignInStage.setResizable(false);
			SignInStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			SignInStage.setTitle("Money Manager");
			SignInStage.setX(positionX);
			SignInStage.setY(positionY);
			SignInStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToDashboard(double positionX, double positionY) {
		try {
			Stage DashboardStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
			Scene scene = new Scene(root,800,550);
			DashboardStage.setScene(scene);
			DashboardStage.setResizable(false);
			DashboardStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			DashboardStage.setTitle("Dashboard");
			DashboardStage.setX(positionX);
			DashboardStage.setY(positionY);
			DashboardStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToMakeATransaction(double positionX, double positionY) {
		try {
			Stage MakeATransactionStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/MakeATransaction.fxml"));
			Scene scene = new Scene(root,800,550);
			MakeATransactionStage.setScene(scene);
			MakeATransactionStage.setResizable(false);
			MakeATransactionStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			MakeATransactionStage.setTitle("Make A Transaction");
			MakeATransactionStage.setX(positionX);
			MakeATransactionStage.setY(positionY);
			MakeATransactionStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	public void goToSettings(double positionX, double positionY) {
		try {
			Stage SettingsStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Settings.fxml"));
			Scene scene = new Scene(root,800,550);
			SettingsStage.setScene(scene);
			SettingsStage.setResizable(false);
			SettingsStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			SettingsStage.setTitle("Settings");
			SettingsStage.setX(positionX);
			SettingsStage.setY(positionY);
			SettingsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void goToTransactionHistory(double positionX, double positionY) {
		try {
			Stage TransactionHistoryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/TransactionHistory.fxml"));
			Scene scene = new Scene(root,800,550);
			TransactionHistoryStage.setScene(scene);
			TransactionHistoryStage.setResizable(false);
			TransactionHistoryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			TransactionHistoryStage.setTitle("Transaction History");
			TransactionHistoryStage.setX(positionX);
			TransactionHistoryStage.setY(positionY);
			TransactionHistoryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToCashCalculate(double positionX, double positionY) {
		try {
			Stage CashCalculateStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/CashCalculate.fxml"));
			Scene scene = new Scene(root,800,550);
			CashCalculateStage.setScene(scene);
			CashCalculateStage.setResizable(false);
			CashCalculateStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			CashCalculateStage.setTitle("Cash Calculate");
			CashCalculateStage.setX(positionX);
			CashCalculateStage.setY(positionY);
			CashCalculateStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToAbout(double positionX, double positionY) {
		try {
			Stage AboutStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/About.fxml"));
			Scene scene = new Scene(root,800,550);
			AboutStage.setScene(scene);
			AboutStage.setResizable(false);
			AboutStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			AboutStage.setTitle("About");
			AboutStage.setX(positionX);
			AboutStage.setY(positionY);
			AboutStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToHelp(double positionX, double positionY) {
		try {
			Stage HelpStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Help.fxml"));
			Scene scene = new Scene(root,800,550);
			HelpStage.setScene(scene);
			HelpStage.setResizable(false);
			HelpStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
			HelpStage.setTitle("Help");
			HelpStage.setX(positionX);
			HelpStage.setY(positionY);
			HelpStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
