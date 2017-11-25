package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelpStage extends Application {
	@Override
	public void start(Stage HelpStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Help.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			HelpStage.setScene(scene);
			HelpStage.setResizable(false);
			HelpStage.setTitle("Help");
			HelpStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	} 

}
