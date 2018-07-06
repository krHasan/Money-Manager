package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class SignInStage extends Application {
	@Override
	public void start(Stage SignInStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/SignIn.fxml"));
			Scene scene = new Scene(root,800,550);
			SignInStage.setScene(scene);
			SignInStage.setResizable(false);
//			SignInStage.getIcons().add(new Image(SignInStage.class.getResourceAsStream("/imges/purse_2_.ico")));
			SignInStage.getIcons().add(new Image(getClass().getResourceAsStream("/imges/purse.png")));
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
