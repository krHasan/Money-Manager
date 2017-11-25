package controller;

import javafx.event.ActionEvent;
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
		
		btnCancel.setTooltip(new Tooltip("Cancel the registration process and take you to Sign In Window"));
		btnRegistration.setTooltip(new Tooltip("If all data typed correctly, \n"
				+ "then you will register as a new user"));
		Tooltip.install(txtName, new Tooltip("Write your full name"));
		Tooltip.install(txtUsername, new Tooltip("Give a username, this will use at the time of login\n"
				+ "This should not contain space"));
		Tooltip.install(passPassword, new Tooltip("Give a password, this should not contain space"));
		Tooltip.install(passReTypePassword, new Tooltip("Retype the password"));
		Tooltip.install(cmboSecurityQuestion, new Tooltip("Choose a security question"));
		Tooltip.install(txtAnswer, new Tooltip("Answer your question. Remember this answer.\n"
				+ "If you forget your password, this will \n"
				+ "help you to recover your account."));
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
			boolean feedback = setUsername(txtUsername.getText());
			setUserFullName(txtName.getText());
			setPassword(passPassword.getText());
			setSecurityQuestion(cmboSecurityQuestion.getValue());
			setSecurityQuestionAnswer(txtAnswer.getText());

			Stage NewUserRegistrationStage = (Stage) btnRegistration.getScene().getWindow();
			(new GoToOperation()).goToSignIn(NewUserRegistrationStage.getX(), NewUserRegistrationStage.getY());
			NewUserRegistrationStage.close();
			
			if (feedback) {
				Alert confirmationMsg = new Alert(AlertType.INFORMATION);
				confirmationMsg.setTitle("Created User Successfully");
				confirmationMsg.setHeaderText(null);
				confirmationMsg.setContentText("Account Created Successfully");
				confirmationMsg.setX(NewUserRegistrationStage.getX() + 200);
				confirmationMsg.setY(NewUserRegistrationStage.getY() + 170);
				confirmationMsg.showAndWait();
			} else {
				Alert confirmationMsg = new Alert(AlertType.ERROR);
				confirmationMsg.setTitle("Sign Up Failed");
				confirmationMsg.setHeaderText("Sign Up Failed");
				confirmationMsg.setContentText("There have some problem.");
				confirmationMsg.setX(NewUserRegistrationStage.getX() + 200);
				confirmationMsg.setY(NewUserRegistrationStage.getY() + 170);
				confirmationMsg.showAndWait();
			}
		}
	}
	
	
}





















