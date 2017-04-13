package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		    fileAddress = new JTextField(c.getValues(),15);
		    //fileAddress.setPreferredSize(new Dimension(200, 24));
		    ok = new JButton("OK");	
		    setSize(200,200);
		    
		    browse = new JButton("Browse");
		    Container cp = getContentPane();
		    SpringLayout layout = new SpringLayout();
		    cp.setLayout(layout);
		    layout.putConstraint(SpringLayout.WEST, fileChkBx, 5, SpringLayout.WEST, this);
		    layout.putConstraint(SpringLayout.NORTH, fileChkBx, 5, SpringLayout.NORTH, this);
		    layout.putConstraint(SpringLayout.WEST, fileAddress, 5, SpringLayout.WEST, this);
		    //layout.putConstraint(SpringLayout.EAST, fileAddress, -5, SpringLayout.EAST, this);
		    layout.putConstraint(SpringLayout.NORTH, fileAddress, 5, SpringLayout.SOUTH, fileChkBx);
		    layout.putConstraint(SpringLayout.WEST, browse, 5, SpringLayout.WEST, this);
		    layout.putConstraint(SpringLayout.NORTH, browse, 5, SpringLayout.SOUTH, fileAddress);
		    layout.putConstraint(SpringLayout.WEST, ok, 5, SpringLayout.WEST, this);
		    layout.putConstraint(SpringLayout.NORTH, ok, 5, SpringLayout.SOUTH, browse);
		    
		    cp.add(fileChkBx);
		    cp.add(fileAddress);
		    cp.add(browse);
		    cp.add(new JLabel("File"));
		    addBrowseAction(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		JFileChooser chooser = new JFileChooser();
		    		FileNameExtensionFilter type = new FileNameExtensionFilter("CSV file", "csv");
		    		chooser.setFileFilter(type);
		    		int returnVal = chooser.showOpenDialog(null);
		    		if(returnVal == JFileChooser.APPROVE_OPTION) {
		    			setText(chooser.getSelectedFile().getAbsolutePath());
		    		}
		    	}
			});    
		    
		    ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					c.updateConfig(getCheckboxVaue(),getText());
					dispose();
			    }
		    });
		    cp.add(ok);
		    this.revalidate();
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