package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import database.SignInSQL;

public class SignInController extends SignInSQL {
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
		lblUserFullName.setText(ownerNameSQL());
		
	}
	
	
}


































