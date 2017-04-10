package View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.ConfigController;

public class ConfigSourceDialog extends JFrame {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton browse;
	private JCheckBox fileChkBx;
	private JButton ok;
	private JTextField fileAddress;
	
	public ConfigSourceDialog(ConfigController c) {
		
		    fileChkBx = new JCheckBox("File");
		    fileAddress = new JTextField();
		    
		    browse = new JButton("Browse");
		    Container cp = getContentPane();
		    cp.setLayout(new FlowLayout());
		    cp.add(fileChkBx);
		    cp.add(fileAddress);
		    cp.add(browse);
		    cp.add(new JLabel("File"));
		    addBrowseAction(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		JFileChooser chooser = new JFileChooser();
		    		int returnVal = chooser.showOpenDialog(null);
		    		if(returnVal == JFileChooser.APPROVE_OPTION) {
		    			setText(chooser.getSelectedFile().getAbsolutePath());
		    		}
		    	}
			});
		    ok = new JButton("OK");		    
		    
		    ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					c.updateConfig(getCheckboxVaue(),getText());
					dispose();
			    }
		    });
		    cp.add(ok);
		    setSize(150, 125);
		    this.setVisible(true);
	}
	
	
	public static void main(String[] arg){
		ConfigSourceDialog config = new ConfigSourceDialog(new ConfigController());
	}


	public void addBrowseAction(ActionListener actionListener) {
		// TODO Auto-generated method stub
		browse.addActionListener(actionListener);
	}
	public void addOKAction(ActionListener newaction){
		ok.addActionListener(newaction);
	}
	private void setText(String newfile){
		this.fileAddress.setText(newfile);
	}
	public String getText(){
		return this.fileAddress.getText();
	}
	public boolean getCheckboxVaue(){
		return fileChkBx.isSelected();
	}
}