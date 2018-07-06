package operation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GoToRegistration {
	
	public void goToRegistration(Stage NewUserRegistrationStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/NewUserRegistration.fxml"));
			Scene scene = new Scene(root,800,550);
			NewUserRegistrationStage.setScene(scene);
			NewUserRegistrationStage.setTitle("New User Registration");
			NewUserRegistrationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToReRegistration(Stage RegistrationIssueStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrationIssue.fxml"));
			Scene scene = new Scene(root,800,550);
			RegistrationIssueStage.setScene(scene);
			RegistrationIssueStage.setTitle("Registration Issue");
			RegistrationIssueStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
