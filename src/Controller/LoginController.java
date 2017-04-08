package Controller;

import Model.Login;
import View.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;
    private Login loginModel;

    public LoginController() {
        this.loginView = new LoginView();
        this.loginModel = new Login();
        this.loginView.setVisible(true);
        this.loginView.jLoginActionPerformed(new LoginListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                boolean authorize = loginModel.authenticate(loginView.getUsername(), loginView.getPassword());
                if (authorize) {
                    loginView.setVisible(false);
                    loginView.dispose();
                    @SuppressWarnings("unused")
                    TechnicalAnalysisController ta = new TechnicalAnalysisController();
                } else {
                    loginView.displayErrorMessage("Invalid Username or Password!");
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                loginView.displayErrorMessage("Error!");
            }
        }
    }

}
