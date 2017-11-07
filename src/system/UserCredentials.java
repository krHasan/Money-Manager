package system;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DatabaseConnection;

public class UserCredentials extends DatabaseConnection {
	boolean userExist = UserBasic.checkUserPresence();
}
