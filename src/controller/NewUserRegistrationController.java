package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.NewUserRegistrationModel;
import operation.GoToOperation;

public class NewUserRegistrationController extends NewUserRegistrationModel {
	@FXML
	private TextField txtName;
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
	private Button btnRegistration;
	@FXML
	private Button btnCancel;
	
	@FXML
	private Label lblMsg;
	@FXML
	private Label lblMsg1;
///////////////////////// General Function //////////////
	@FXML
	public void initialize() {
		loadSQuestion();
	}
	
//////////////////////// Function ///////////////////////
	private void loadSQuestion() {
		cmboSecurityQuestion.setItems(getSecurityQuestion());
		cmboSecurityQuestion.getSelectionModel().selectFirst();
	}
	
	
	@FXML
	private void btnCancel(ActionEvent event) {
		Stage NewUserRegistrationStage = (Stage) btnCancel.getScene().getWindow();
		(new GoToOperation()).goToSignIn(NewUserRegistrationStage.getX(), NewUserRegistrationStage.getY());
		NewUserRegistrationStage.close();
	}
	

	@FXML
	private void txtName() {
		lblMsg1.setText("");
	}
	
	
	@FXML
	private void txtUsername() {
		if (containswhitespace(txtUsername.getText())) {
			lblMsg1.setText("Space isn't allowed for username");
			txtUsername.clear();
		} else {
			lblMsg1.setText("");
		}
	}
	
	
	@FXML
	private void passPassword() {
		if (containswhitespace(passPassword.getText())) {
			lblMsg1.setText("Space isn't allowed for password");
			passPassword.clear();
		} else {
			lblMsg1.setText("");
		}
	}
	
	
	@FXML
	private void passReTypePassword() {
		lblMsg1.setText("");
		if (passPassword.getText().length() <= passReTypePassword.getText().length()) {
			if (!passReTypePassword.getText().equals(passPassword.getText())) {
				lblMsg.setText("Password didn't match");
			}
		} else {
			lblMsg.setText("");
		}
	}
	
	
	@FXML
	private void txtAnswer() {
		if (containswhitespace(txtAnswer.getText())) {
			lblMsg1.setText("Space isn't allowed.");
			txtAnswer.clear();
		} else {
			lblMsg1.setText("");
		}
	}
	
	
	@FXML
	private void btnRegistration(ActionEvent event) {
		if (txtName.getText().isEmpty() || countWords(txtName.getText()) == 0) {
			lblMsg1.setText("Write your name");
			txtName.clear();
		} else if(txtUsername.getText().isEmpty()) {
			lblMsg1.setText("Set a Username");
		} else if(passPassword.getText().isEmpty()) {
			lblMsg1.setText("Set a Password");
		} else if(!passPassword.getText().equals(passReTypePassword.getText())) {
			lblMsg1.setText("Re-type Password Correctly");
		} else if(txtAnswer.getText().isEmpty()) {
			lblMsg1.setText("Set a Security Question Answer");
		} else {
			setUsername(txtUsername.getText());
			setUserFullName(txtName.getText());
			setPassword(passPassword.getText());
			setSecurityQuestion(cmboSecurityQuestion.getValue());
			setSecurityQuestionAnswer(txtAnswer.getText());

			Stage NewUserRegistrationStage = (Stage) btnRegistration.getScene().getWindow();
			(new GoToOperation()).goToSignIn(NewUserRegistrationStage.getX(), NewUserRegistrationStage.getY());
			NewUserRegistrationStage.close();
			
			Alert confirmationMsg = new Alert(AlertType.INFORMATION);
			confirmationMsg.setTitle("Operation Successful");
			confirmationMsg.setHeaderText(null);
			confirmationMsg.setContentText("Account Created Successfully");
			confirmationMsg.setX(NewUserRegistrationStage.getX() + 200);
			confirmationMsg.setY(NewUserRegistrationStage.getY() + 170);
			confirmationMsg.showAndWait();
		}
	}
	
	
}





















