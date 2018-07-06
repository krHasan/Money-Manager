package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.RegistrationIssueModel;
import operation.GoToOperation;
import system.DeleteUserCredentials;
import tab.TabAccess;

public class RegistrationIssueController extends RegistrationIssueModel {
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField passPassword;
	@FXML
	private PasswordField passReTypePassword;
	@FXML
	private TextField txtAnswer;
	
	@FXML
	private ComboBox<String> cmboSecurityQuestion;
	
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnSave;
	
	@FXML
	private Label lblMsgPassword;
	@FXML
	private Label lblMsgInformation;
	@FXML
	private Label lblHeading;
	@FXML
	private Label lblReTypePassword;
	
/////////////////////////// General function ////////////////////////////	
	String lodingStatus = null;
	@FXML
	public void initialize() {
		lodingStatus = new TabAccess().getreRegistrationLodingStatus();
		if (lodingStatus.equals("deleteUser")) {
			lblHeading.setText("Provide Existing User Information");
			lblReTypePassword.setVisible(false);
			passReTypePassword.setVisible(false);
			loadSQuestion();
			btnSave.setManaged(false);
		} else if(lodingStatus.equals("forgotPassword")) {
			lblHeading.setText("Change Password and S.Q.");
			txtUsername.setText(getUsername());
			txtUsername.setDisable(true);
			loadSQuestion();
			btnDelete.setManaged(false);
		}
		
		btnCancel.setTooltip(new Tooltip("Cancel the process and take you to Sign In window"));
		btnSave.setTooltip(new Tooltip("Save your new password and security question"));
		btnDelete.setTooltip(new Tooltip("If all information is given correctly \n"
				+ "then this user will be deleted"));
		Tooltip.install(txtUsername, new Tooltip("Your Username"));
		Tooltip.install(passPassword, new Tooltip("Give a password, this should not contain space"));
		Tooltip.install(passReTypePassword, new Tooltip("Retype the password"));
		Tooltip.install(cmboSecurityQuestion, new Tooltip("Choose a security question"));
		Tooltip.install(txtAnswer, new Tooltip("Answer your question. Remember this answer.\n"
				+ "If you forget your password, this will \n"
				+ "help you to recover your account."));
	}
	
//////////////////////// Main Functionality /////////////////////////////
	@FXML
	private void btnCancel(ActionEvent event) {
		Stage RegistrationIssueStage = (Stage) btnCancel.getScene().getWindow();
		(new GoToOperation()).goToSignIn(RegistrationIssueStage);
	}
	
	
	private void loadSQuestion() {
		cmboSecurityQuestion.setItems(getSecurityQuestion());
		cmboSecurityQuestion.getSelectionModel().selectFirst();
	}
	
	
	@FXML
	private void txtUsername() {
		lblMsgInformation.setText("");
	}
	
	
	@FXML
	private void passPassword() {
		if (containswhitespace(passPassword.getText())) {
			lblMsgInformation.setText("Space isn't allowed for password");
			passPassword.clear();
		} else {
			lblMsgInformation.setText("");
		}
	}
	
	
	@FXML
	private void passReTypePassword() {
		lblMsgInformation.setText("");
		if (passPassword.getText().length() <= passReTypePassword.getText().length()) {
			if (!passReTypePassword.getText().equals(passPassword.getText())) {
				lblMsgPassword.setText("Password didn't match");
			}
		} else {
			lblMsgPassword.setText("");
		}
	}
	
	
	@FXML
	private void txtAnswer() {
		lblMsgInformation.setText("");
	}
	
	
	@FXML
	private void btnSave(ActionEvent event) {
		if (passPassword.getText().isEmpty()) {
			lblMsgInformation.setText("Password can't empty");
		} else if (!passReTypePassword.getText().equals(passPassword.getText())) {
			lblMsgInformation.setText("Re-type Your Password Correctly");
		} else if(txtAnswer.getText().isEmpty() || countWords(txtAnswer.getText()) == 0) {
			lblMsgInformation.setText("Answer the Security Question.");
		} else {
			setPassword(passPassword.getText());
			setSecurityQuestion(cmboSecurityQuestion.getValue());
			setSecurityQuestionAnswer(txtAnswer.getText());
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Operation Successful");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Information Updated Successfully");
			Stage RegistrationIssueStage = (Stage) btnSave.getScene().getWindow();
			confirmationMsg.setX(RegistrationIssueStage.getX() + 200);
			confirmationMsg.setY(RegistrationIssueStage.getY() + 170);
		    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
		    {
		        @Override
		        public void handle( ActionEvent event )
		        {
		        	confirmationMsg.hide();
		        }
		    } ) );
		    idlestage.setCycleCount( 1 );
		    idlestage.play();
		    confirmationMsg.showAndWait();
			
			(new GoToOperation()).goToSignIn(RegistrationIssueStage);
		}
	}
	
	
	@FXML
	private void btnDelete(ActionEvent event) {
		if (!txtUsername.getText().equals(getUsername())) {
			lblMsgInformation.setText("Information did't match");
			txtUsername.clear();
			passPassword.clear();
			loadSQuestion();
			txtAnswer.clear();
		} else if(!passPassword.getText().equals(getPassword())) {
			lblMsgInformation.setText("Information did't match");
			txtUsername.clear();
			passPassword.clear();
			loadSQuestion();
			txtAnswer.clear();
		} else if(!securityQuestionAnswerIsOk(txtAnswer.getText())) {
			lblMsgInformation.setText("Information did't match");
			txtUsername.clear();
			passPassword.clear();
			loadSQuestion();
			txtAnswer.clear();
		} else if(!cmboSecurityQuestion.getValue().equals(getSavedSecurityQuestion())) {
			lblMsgInformation.setText("Information did't match");
			txtUsername.clear();
			passPassword.clear();
			loadSQuestion();
			txtAnswer.clear();
		} else {
			new DeleteUserCredentials().initializeApplication();
			
			Stage RegistrationIssueStage = (Stage) btnDelete.getScene().getWindow();
			(new GoToOperation()).goToSignIn(RegistrationIssueStage);
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Operation Successful");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("User Information Deleted Successfully");
			confirmationMsg.setX(RegistrationIssueStage.getX() + 200);
			confirmationMsg.setY(RegistrationIssueStage.getY() + 170);
		    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(3), new EventHandler<ActionEvent>()
		    {
		        @Override
		        public void handle( ActionEvent event )
		        {
		        	confirmationMsg.hide();
		        }
		    } ) );
		    idlestage.setCycleCount( 1 );
		    idlestage.play();
		    confirmationMsg.showAndWait();
		}
	}
	

}







