package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Nikita on 2017-04-09.
 */
public class RegistrationView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel nameRow;
    private JLabel usernameLabel;
    private JTextField usernameInput;

    private JPanel passwordRow;
    private JLabel passwordLabel;
    private JPasswordField passwordInput;

    private JPanel buttonsRow;
    private JButton registerBtn;
    private JButton backBtn;

    private JLabel messageLable;

    public RegistrationView() {
        initComponents();
    }

    private void initComponents() {

        messageLable = new JLabel("Enter new user credentials.");

        nameRow = new JPanel(new FlowLayout());
        usernameLabel = new JLabel();
        usernameLabel.setText("Username");
        usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(200, 24));


        passwordRow = new JPanel(new FlowLayout());
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordInput = new JPasswordField();
        passwordInput.setPreferredSize(new Dimension(200, 24));

        buttonsRow = new JPanel(new FlowLayout());
        registerBtn = new JButton();
        registerBtn.setText("Register");
        backBtn = new JButton();
        backBtn.setText("Back");

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(messageLable);

        nameRow.add(usernameLabel);
        nameRow.add(usernameInput);
        this.add(nameRow);

        passwordRow.add(passwordLabel);
        passwordRow.add(passwordInput);
        this.add(passwordRow);

        buttonsRow.add(registerBtn);
        buttonsRow.add(backBtn);
        this.add(buttonsRow);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public String getUsername() {
        return usernameInput.getText();
    }

    public String getPassword() {
        return passwordInput.getText();
    }

    public void registrationActionPerformed(ActionListener evt) {
        registerBtn.addActionListener(evt);
    }

    public void backActionPerformed(ActionListener evt) {
        backBtn.addActionListener(evt);
    }

    public void displayMessage(String string) {
        messageLable.setText(string);
    }
}