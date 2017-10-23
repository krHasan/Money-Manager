package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardStage extends Application {
	@Override
	public void start(Stage DashboardStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			DashboardStage.setScene(scene);
			DashboardStage.setResizable(false);
			DashboardStage.setTitle("Dashboard");
			DashboardStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
