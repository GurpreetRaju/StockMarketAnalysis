package Controller;

import Model.Login;
import Model.Registration;
import View.LoginView;
import View.RegistrationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nikita on 2017-04-09.
 */
public class RegistrationController {

    private RegistrationView registrationView;
    private Registration registrationModel;

    public RegistrationController() {
        new RegistrationController(new RegistrationView(), new Registration());
    }

    public RegistrationController(RegistrationView theView, Registration theModel) {
        this.registrationView = theView;
        this.registrationModel = theModel;
        this.registrationView.registrationActionPerformed(new registrationListener());
        this.registrationView.backActionPerformed(new backActionListener());
        this.registrationView.setVisible(true);
    }

    class registrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (registrationModel.newRegistration(registrationView.getUsername(), registrationView.getPassword())) {
                registrationView.displayMessage("Registration Succeed!");
            } else {
                registrationView.displayMessage("Registration Error!");
            }
        }
    }

    class backActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            registrationView.setVisible(false);
            registrationView.dispose();
            new LoginController(new LoginView(), new Login());
        }
    }
}
