package operation;

import database.DatabaseConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GoToOperation extends DatabaseConnection {
	
	public void goToDashboard(double positionX, double positionY) {
		try {
			Stage DashboardStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
			Scene scene = new Scene(root,800,550);
			DashboardStage.setScene(scene);
			DashboardStage.setResizable(false);
			DashboardStage.setTitle("Dashboard");
			DashboardStage.setX(positionX);
			DashboardStage.setY(positionY);
			DashboardStage.show();
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
			SettingsStage.setTitle("Settings");
			SettingsStage.setX(positionX);
			SettingsStage.setY(positionY);
			SettingsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
