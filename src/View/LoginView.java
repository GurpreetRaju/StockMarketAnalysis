package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Gurpreet
 */

public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel jMessage;

    private JPanel nameRow;
    private JLabel jLabelUsername;
    private JTextField jTextUsername;

    private JPanel passwordRow;
    private JLabel jLabelPassword;
    private JPasswordField jPassword;

    private JPanel buttonsRow;
    private JButton jLogin;
    private JButton jClose;

    private JPanel registrationRow;
    private JButton registrationBtn;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {

        jMessage = new JLabel("Enter login and password.");

        nameRow = new JPanel(new FlowLayout());
        jLabelUsername = new JLabel();
        jTextUsername = new JTextField();
        jTextUsername.setPreferredSize(new Dimension(200, 24));

        passwordRow = new JPanel(new FlowLayout());
        jLabelPassword = new JLabel();
        jPassword = new JPasswordField();
        jPassword.setPreferredSize(new Dimension(200, 24));

        buttonsRow = new JPanel(new FlowLayout());
        jLogin = new JButton();
        jClose = new JButton();

        registrationRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        registrationBtn = new JButton("Register new user");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jLabelUsername.setText("Username");
        jLabelPassword.setText("Password");

        jLogin.setText("Login");

        jClose.setText("Cancel");
        jClose.addActionListener(e -> System.exit(0));

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(jMessage);

        nameRow.add(jLabelUsername);
        nameRow.add(jTextUsername);
        this.add(nameRow);

        passwordRow.add(jLabelPassword);
        passwordRow.add(jPassword);
        this.add(passwordRow);

        buttonsRow.add(jLogin);
        buttonsRow.add(jClose);
        this.add(buttonsRow);

        registrationRow.add(registrationBtn);
        this.add(registrationRow);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    @SuppressWarnings("deprecation")
	public String getPassword() {
        return jPassword.getText();
    }

    public String getUsername() {
        return jTextUsername.getText();
    }

    public void jLoginActionPerformed(ActionListener evt) {
        jLogin.addActionListener(evt);
    }

    public void displayErrorMessage(String string) {
        jMessage.setText(string);
    }

    public void registrationActionPerformed(ActionListener evt) {
        registrationBtn.addActionListener(evt);
    }

}
