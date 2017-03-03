package Main;

import Controller.LoginController;
import Model.Login;
import View.LoginView;

public class Main {
	public static void main(String[] arg){
		LoginView loginview = new LoginView();
		Login loginModel = new Login();
		LoginController login = new LoginController(loginview, loginModel);
		loginview.setVisible(true);
	}
}
