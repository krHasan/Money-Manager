package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingsStage extends Application {
	@Override
	public void start(Stage SettingsStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/Settings.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			SettingsStage.setScene(scene);
			SettingsStage.setResizable(false);
			SettingsStage.setTitle("Settings");
			SettingsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
