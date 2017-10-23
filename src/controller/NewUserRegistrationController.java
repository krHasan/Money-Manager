package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewUserRegistrationController {
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
	private ComboBox cmboSecurityQuestion;
	
	@FXML
	private Button btnRegistration;
	@FXML
	private Button btnCancel;
	
	@FXML
	private Label lblMsg;
}
