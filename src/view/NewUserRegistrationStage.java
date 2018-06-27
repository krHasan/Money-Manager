package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewUserRegistrationStage extends Application {
	@Override
	public void start(Stage NewUserRegistrationStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/NewUserRegistration.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			NewUserRegistrationStage.setScene(scene);
			NewUserRegistrationStage.setResizable(false);
			NewUserRegistrationStage.setTitle("New User Registration");
			NewUserRegistrationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
