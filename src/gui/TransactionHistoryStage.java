package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransactionHistoryStage extends Application {
	@Override
	public void start(Stage TransactionHistoryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/gui/TransactionHistory.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			TransactionHistoryStage.setScene(scene);
			TransactionHistoryStage.setResizable(false);
			TransactionHistoryStage.setTitle("Transaction History");
			TransactionHistoryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
