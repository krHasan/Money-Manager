package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AboutStage extends Application {
	@Override
	public void start(Stage AboutStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/About.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			AboutStage.setScene(scene);
			AboutStage.setResizable(false);
			AboutStage.setTitle("About");
			AboutStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
