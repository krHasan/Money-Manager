package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationIssueStage extends Application {
	@Override
	public void start(Stage RegistrationIssueStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/RegistrationIssue.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			RegistrationIssueStage.setScene(scene);
			RegistrationIssueStage.setResizable(false);
			RegistrationIssueStage.setTitle("Registration Issue");
			RegistrationIssueStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
