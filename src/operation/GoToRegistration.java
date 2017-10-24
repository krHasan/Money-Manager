package operation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GoToRegistration {
	
	public void goToRegistration() {
		try {
			Stage RegistrationIssueStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/RegistrationIssue.fxml"));
			Scene scene = new Scene(root,800,550);
			RegistrationIssueStage.setScene(scene);
			RegistrationIssueStage.setResizable(false);
			RegistrationIssueStage.setTitle("Registration Issue");
			RegistrationIssueStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
