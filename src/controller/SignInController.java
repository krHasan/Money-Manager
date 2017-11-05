package controller;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.SignInModel;
import operation.GoToRegistration;

public class SignInController extends SignInModel {
	@FXML
	private Label lblUserFullName;
	@FXML
	private Label lblApplicationName;
	@FXML
	private Label lblOutdateMsg;
	@FXML
	private Label lblWrongAuthentication;
	@FXML
	private Label lblForgetPassword;
	@FXML
	private Label lblNewUser;
	@FXML
	private Label lblForgetPassMsg;
	@FXML
	private Label lblSecurityQuetion;
	
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField passPassword;
	@FXML
	private TextField txtSQAnswer;
	
	@FXML
	private Button btnSignIn;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnCancel;
	
	@FXML
	private ImageView imgSignIn;
	
	@FXML
	public void initialize() {
		lblUserFullName.setText(getOwnerName());
		try {
			if(!checkUserPresence()) {
				txtUsername.setDisable(true);
				passPassword.setDisable(true);
				btnSignIn.setDisable(true);
				lblForgetPassword.setDisable(true);
			} else if(!openingDateUpdate()) {
				lblOutdateMsg.setText("Your computer date is outdated, please update it and restart the program");
				txtUsername.setDisable(true);
				passPassword.setDisable(true);
				btnSignIn.setDisable(true);
				lblForgetPassword.setDisable(true);
				lblNewUser.setDisable(true);
			}
		} catch (Exception e) {}
	}

	@FXML
	private void logIn(ActionEvent event) {
		if (authentication(txtUsername.getText(), passPassword.getText())) {
			updateLastAccessDate();
			Stage SignInStage = (Stage) btnSignIn.getScene().getWindow();
			goToDashboard(SignInStage.getX(), SignInStage.getY());
			SignInStage.hide();
		} else {
			lblWrongAuthentication.setText("Username or Password is Wrong");
			passPassword.clear();
		}
	}
	
	@FXML
	private void newUser(MouseEvent event) {
		if (checkUserPresence()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Only one user can use this at a time");
			alert.setContentText("User exists, Delete this one?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Stage SignInStage = (Stage) lblNewUser.getScene().getWindow();
				(new GoToRegistration()).goToReRegistration(SignInStage.getX(), SignInStage.getY());
				SignInStage.hide();
			}
		} else {
			Stage SignInStage = (Stage) lblNewUser.getScene().getWindow();
			(new GoToRegistration()).goToRegistration(SignInStage.getX(), SignInStage.getY());
			SignInStage.hide();
		}
	}
	
	@FXML
	private void forgotPassword(MouseEvent event) {
		imgSignIn.setVisible(false);
		lblForgetPassMsg.setText("Answer the security question");
		lblSecurityQuetion.setText(showSecurityQuestion());
		txtUsername.clear();
		passPassword.clear();
	}
	
	@FXML
	private void passwordChangeOk(ActionEvent event) {
		if (new SignInModel().securityQuestionAnswerIsOk(txtSQAnswer.getText())) {
			Stage SignInStage = (Stage) btnOk.getScene().getWindow();
			(new GoToRegistration()).goToReRegistration(SignInStage.getX(), SignInStage.getY());
			SignInStage.hide();
		} else {
			lblForgetPassMsg.setText("Answer didn't match");
			txtSQAnswer.clear();
		}
	}
	
	@FXML
	private void passwordChangeCancel(ActionEvent event) {
		imgSignIn.setVisible(true);
	}
	
	@FXML
	private void forgotPasswordtxtFieldFocus(MouseEvent event) {
		lblForgetPassMsg.setText("Answer the security question");
	}
	
}


































