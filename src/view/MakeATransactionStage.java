package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MakeATransactionStage extends Application {
	@Override
	public void start(Stage MakeATransactionStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MakeATransaction.fxml"));
			Scene scene = new Scene(root,800,550);
			MakeATransactionStage.setScene(scene);
			MakeATransactionStage.setResizable(false);
			MakeATransactionStage.setTitle("Make A Transaction");
			MakeATransactionStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
