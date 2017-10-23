package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationIssueController {
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
	private Button btnDelete;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnRegister;
	
	@FXML
	private Label lblMsgPassword;
	@FXML
	private Label lblMsgDelete;
	@FXML
	private Label lblMsgInformation;
}