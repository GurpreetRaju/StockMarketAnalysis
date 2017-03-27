
package View;

import java.awt.event.ActionListener;

/**
 *
 * @author Gurpreet
 */
import javax.swing.*;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public LoginView() {
        initComponents();
    }
 
    private void initComponents() {

        jLabelUsername = new JLabel();
        jTextUsername = new JTextField();
        jLabelPassword = new JLabel();
        jPassword = new JPasswordField();
        jLogin = new JButton();
        jClose = new JButton();
        jMessage = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelUsername.setText("Username");

        jLabelPassword.setText("Password");

        jLogin.setText("Login");
        
        jClose.setText("Cancel");
        
        jClose.addActionListener(e ->  System.exit(0));
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsername)
                            .addComponent(jLabelPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        	.addComponent(jMessage)
                        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextUsername)
                            .addComponent(jPassword, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLogin)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jClose)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(jTextUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogin)
                    .addComponent(jClose))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }
    
    @SuppressWarnings({ "deprecation" })
	public String getPassword() {                                            
    	return jPassword.getText();
    }
    
   
	public String getUsername(){
    	return jTextUsername.getText();
    }
	
	public void jLoginActionPerformed(ActionListener evt) {
    	jLogin.addActionListener(evt);
    }              
	
	public void displayErrorMessage(String string) {
		jMessage.setText(string);		
	}
	
    private JButton jLogin;
    private JButton jClose;
    private JLabel jLabelUsername;
    private JLabel jLabelPassword;
    private JTextField jTextUsername;
    private JPasswordField jPassword;
    private JLabel jMessage;                  
}
