package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class SignInStage extends Application {
	@Override
	public void start(Stage SignInStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/SignIn.fxml"));
			Scene scene = new Scene(root,750,450);
			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			SignInStage.setScene(scene);
			SignInStage.setResizable(false);
			SignInStage.setTitle("Money Manager");
			SignInStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
