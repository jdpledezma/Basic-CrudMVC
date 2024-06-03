package main;

import java.sql.SQLException;

import controller.ControllerCrudMenu;
import controller.ControllerLogin;
import view.ViewCrudMenu;
import view.ViewLogin;

public class Main {
	
	public static void main(String[] args) throws SQLException{	
		ViewLogin viewLogin = new ViewLogin();
		ControllerLogin controllerLogin = new ControllerLogin(viewLogin);
		controllerLogin.showScreen();
	}
}
