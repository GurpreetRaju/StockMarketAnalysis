package View;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StockView extends JFrame{
	private static final long serialVersionUID = -1684508335936731588L;
	
	private JComboBox<String> stocklist;
	private JButton nextBtn;
	private JButton addStockBtn;
	private String[] listString = {"Google","IBM","Microsoft"};
	private JLabel from;
	private JLabel to;
	private JLabel errorMessage;
	private JTextField fromField;
	private JTextField toField;
	//private JPanel timePeriodPanel;

	
	public StockView(){
		initComponents();
	}
	
	private void initComponents(){
		from = new JLabel("From:");
		to = new JLabel("To:");
		stocklist = new JComboBox<String>(listString);
		fromField = new JTextField("MM,DD,YYYY",10);
		toField = new JTextField("MM,DD,YYYY",10);
		nextBtn = new JButton();
		addStockBtn = new JButton();
		errorMessage = new JLabel(" ");
		
		nextBtn.setText("Next");
		addStockBtn.setText("Add Stock");
		
		/*SpringLayout layoutPanel = new SpringLayout();
		
		timePeriodPanel = new JPanel(layoutPanel);
		timePeriodPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		timePeriodPanel.add(from);
		timePeriodPanel.add(to);
		timePeriodPanel.add(fromField);
		timePeriodPanel.add(toField);
		
		layoutPanel.putConstraint(SpringLayout.WEST, from, 10, SpringLayout.WEST, timePeriodPanel);
		layoutPanel.putConstraint(SpringLayout.WEST, fromField, 10, SpringLayout.WEST, timePeriodPanel);
		layoutPanel.putConstraint(SpringLayout.WEST, toField, 10, SpringLayout.EAST, fromField);
		layoutPanel.putConstraint(SpringLayout.WEST, to, 0, SpringLayout.EAST, toField);
		
		layoutPanel.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.NORTH, timePeriodPanel);
		layoutPanel.putConstraint(SpringLayout.NORTH, fromField, 10, SpringLayout.SOUTH, from);
		layoutPanel.putConstraint(SpringLayout.NORTH, toField, 0, SpringLayout.NORTH, fromField);
		layoutPanel.putConstraint(SpringLayout.NORTH, to, 0, SpringLayout.NORTH, from);*/
				
		Container contentPane = this.getContentPane();
		//Create new layout: SpringLayout
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		//Adding Components to frame
		this.add(stocklist);
		//this.add(timePeriodPanel);
		this.add(from);
		this.add(to);
		this.add(fromField);
		this.add(toField);
		
		this.add(nextBtn);
		this.add(addStockBtn);
		this.add(errorMessage);
		
		//Adding constraints to layout
		layout.putConstraint(SpringLayout.WEST, stocklist, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, stocklist, 50, SpringLayout.NORTH, contentPane);
		//layout.putConstraint(SpringLayout.WEST, timePeriodPanel, 50, SpringLayout.NORTH, contentPane);
		//layout.putConstraint(SpringLayout.NORTH, timePeriodPanel, 10, SpringLayout.SOUTH, stocklist);
		layout.putConstraint(SpringLayout.WEST, nextBtn, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, nextBtn, 10, SpringLayout.SOUTH, fromField);
		layout.putConstraint(SpringLayout.WEST, addStockBtn, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, addStockBtn, 10, SpringLayout.SOUTH, nextBtn);
		layout.putConstraint(SpringLayout.WEST, errorMessage, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, errorMessage, 10, SpringLayout.SOUTH, addStockBtn);
		
		layout.putConstraint(SpringLayout.WEST, from, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.WEST, fromField, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.WEST, toField, 10, SpringLayout.EAST, fromField);
		layout.putConstraint(SpringLayout.WEST, to, 0, SpringLayout.WEST, toField);
		
		layout.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.SOUTH, stocklist);
		layout.putConstraint(SpringLayout.NORTH, fromField, 10, SpringLayout.SOUTH, from);
		layout.putConstraint(SpringLayout.NORTH, toField, 0, SpringLayout.NORTH, fromField);
		layout.putConstraint(SpringLayout.NORTH, to, 0, SpringLayout.NORTH, from);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	public void nextBtnActionPerformed(ActionListener evt) {
    	nextBtn.addActionListener(evt);
    }
	
	public String[] getTime(){
		String[] time = new String[2];
		time[0] = fromField.getText();
		time[1] = toField.getText();
		return time;
	}
	
	public static void main(String[] arg){
		@SuppressWarnings("unused")
		StockView sv = new StockView();
	}

	public String getStock() {		
		return (String) stocklist.getSelectedItem();
	}
}
