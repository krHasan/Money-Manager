package operation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GoToRegistration {
	
	public void goToRegistration(double positionX, double positionY) {
		try {
			Stage NewUserRegistrationStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/NewUserRegistration.fxml"));
			Scene scene = new Scene(root,800,550);
			NewUserRegistrationStage.setScene(scene);
			NewUserRegistrationStage.setResizable(false);
			NewUserRegistrationStage.setTitle("New User Registration");
			NewUserRegistrationStage.setX(positionX);
			NewUserRegistrationStage.setY(positionY);
			NewUserRegistrationStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void goToReRegistration(double positionX, double positionY) {
		try {
			Stage RegistrationIssueStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrationIssue.fxml"));
			Scene scene = new Scene(root,800,550);
			RegistrationIssueStage.setScene(scene);
			RegistrationIssueStage.setResizable(false);
			RegistrationIssueStage.setTitle("Registration Issue");
			RegistrationIssueStage.setX(positionX);
			RegistrationIssueStage.setY(positionY);
			RegistrationIssueStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
