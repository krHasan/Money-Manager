package controller;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.SignInModel;
import operation.ComboboxList;
import operation.GoToRegistration;
import tab.TabAccess;

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
	private ComboBox<String> cmboSecurityQuetion;
	
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
		
		if (!isDBConnected()) {
			lblWrongAuthentication.setText("Database not found");
		}
		
		btnSignIn.setTooltip(new Tooltip("If Username and Password will \n"
				+ "correct you will be signed in"));
		btnCancel.setTooltip(new Tooltip("Cancel the action"));
		btnOk.setTooltip(new Tooltip("If your answer is matches, you will take to reset password window"));
		Tooltip.install(txtUsername, new Tooltip("Type your Username"));
		Tooltip.install(passPassword, new Tooltip("Enter password"));
		Tooltip.install(lblForgetPassword, new Tooltip("Press if you forget password"));
		Tooltip.install(lblNewUser, new Tooltip("Press if you are a new user or\n"
				+ "want to remove existing user and create new one"));
		Tooltip.install(cmboSecurityQuetion, new Tooltip("Choose your security question"));
		Tooltip.install(txtSQAnswer, new Tooltip("Answer what was your security question answer"));
	}
	
	@FXML
	private void logIn(ActionEvent event) {
		if (authentication(txtUsername.getText(), passPassword.getText())) {
			Stage SignInStage = (Stage) btnSignIn.getScene().getWindow();
			new ComboboxList().setAllMonth(getThisMonthName(), getYear());
			
			if (userIsNew()) {			
				goToDashboard(SignInStage.getX(), SignInStage.getY());
				SignInStage.close();
			} else {
				updateLastAccessDate();
				goToDashboard(SignInStage.getX(), SignInStage.getY());
				SignInStage.close();
			}
			
		} else {
			lblWrongAuthentication.setText("Username or Password is Wrong");
			passPassword.clear();
		}
	}
	
	@FXML
	private void newUser(MouseEvent event) {
		if (checkUserPresence()) {
			imgSignIn.setVisible(true);
			txtSQAnswer.clear();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Only one user can use this at a time");
			alert.setContentText("User exists, Delete this one?");
			Stage SignInStage = (Stage) lblNewUser.getScene().getWindow();
			alert.setX(SignInStage.getX()+200);
			alert.setY(SignInStage.getY()+170);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				(new TabAccess()).setreRegistrationLodingStatus("deleteUser");
				(new GoToRegistration()).goToReRegistration(SignInStage.getX(), SignInStage.getY());
				SignInStage.close();
			}
		} else {
			Stage SignInStage = (Stage) lblNewUser.getScene().getWindow();
			(new GoToRegistration()).goToRegistration(SignInStage.getX(), SignInStage.getY());
			SignInStage.close();
		}
	}
	
	private void showSecurityQuestion() {
		cmboSecurityQuetion.setItems(getSecurityQuestion());
		cmboSecurityQuetion.getSelectionModel().selectFirst();
	}
	
	@FXML
	private void forgotPassword(MouseEvent event) {
		imgSignIn.setVisible(false);
		lblForgetPassMsg.setText("Answer your security question");
		showSecurityQuestion();
		txtUsername.clear();
		passPassword.clear();
	}
	
	@FXML
	private void passwordChangeOk(ActionEvent event) {
		if (!new SignInModel().securityQuestionAnswerIsOk(txtSQAnswer.getText())) {
			lblForgetPassMsg.setText("Answer didn't match");
			txtSQAnswer.clear();
		} else if(!cmboSecurityQuetion.getValue().equals(getSavedSecurityQuestion())){
			lblForgetPassMsg.setText("Question didn't match");
			txtSQAnswer.clear();
		} else {
			(new TabAccess()).setreRegistrationLodingStatus("forgotPassword");
			Stage SignInStage = (Stage) btnOk.getScene().getWindow();
			(new GoToRegistration()).goToReRegistration(SignInStage.getX(), SignInStage.getY());
			SignInStage.close();
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
	
	@FXML
	private void txtUsername() {
		imgSignIn.setVisible(true);
		txtSQAnswer.clear();
	}
	
	@FXML
	private void passPassword() {
		imgSignIn.setVisible(true);
		txtSQAnswer.clear();
	}
	
}


































