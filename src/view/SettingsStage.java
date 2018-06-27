package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingsStage extends Application {
	@Override
	public void start(Stage SettingsStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Settings.fxml"));
			Scene scene = new Scene(root,800,550);
//			scene.getStylesheets().add(getClass().getResource("SignIn.css").toExternalForm());
			SettingsStage.setScene(scene);
			SettingsStage.setResizable(false);
			SettingsStage.setTitle("Settings");
			SettingsStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

//	@Override
//	public void start( Stage stage )
//	{
//	    Scene scene = new Scene( new Group(), 200, 300 );
//
//	    Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
//	    alert.setTitle( "Confirmation Dialog" );
//	    alert.setHeaderText( "Look, a Confirmation Dialog" );
//	    alert.setContentText( "Are you ok with this?" );
//
//	    System.out.println( "timeline Started -" + Calendar.getInstance().getTime() );
//	    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(5 ), new EventHandler<ActionEvent>()
//	    {
//
//	        @Override
//	        public void handle( ActionEvent event )
//	        {
//	            alert.setResult(ButtonType.CANCEL);
//	            alert.hide();
//	        }
//	    } ) );
//	    idlestage.setCycleCount( 1 );
//	    idlestage.play();
//
//	    Optional<ButtonType> result = alert.showAndWait();
//
//	    if ( result.get() == ButtonType.OK )
//	    {
//	        System.out.println( "ok clicked" );
//	    }
//	    else if ( result.get() == ButtonType.CANCEL)
//	    {
//	        System.out.println( "cancel clicked" );
//	    }
//
//	    stage.setScene( scene );
//	    stage.show();
//	}
}
