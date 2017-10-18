package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CashCalculateStage extends Application {
	@Override
	public void start(Stage CashCalculateStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/CashCalculate.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			CashCalculateStage.setScene(scene);
			CashCalculateStage.setResizable(false);
			CashCalculateStage.setTitle("Cash Calculate");
			CashCalculateStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
