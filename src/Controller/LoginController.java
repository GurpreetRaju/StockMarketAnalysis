package Controller;

import Model.Login;
import View.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;
    private Login loginModel;

    public LoginController() {
        new LoginController(new LoginView(), new Login());
    }

    public LoginController(LoginView theView, Login theModel) {
        this.loginView = theView;
        this.loginModel = theModel;
        this.loginView.jLoginActionPerformed(new LoginListener());
        this.loginView.registrationActionPerformed(new RegistrationListener());
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                boolean authorize = loginModel.authenticate(loginView.getUsername(), loginView.getPassword());
                if (authorize) {
                    loginView.setVisible(false);
                    loginView.dispose();
                    new TechnicalAnalysisController();
                } else {
                    loginView.displayErrorMessage("Invalid Username or Password!");
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                loginView.displayErrorMessage("Error!");
            }
        }
    }

    class RegistrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            loginView.setVisible(false);
            loginView.dispose();
            new RegistrationController();
        }
    }
}
