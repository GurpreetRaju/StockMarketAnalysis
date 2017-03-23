package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import  javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * @author Gurpreet
 */
public class TechnicalAnalysisView extends JFrame {

	private static final long serialVersionUID = 494000442742952620L;
	public TechnicalAnalysisView() {
        initComponents();
    }

     private void initComponents() {

    	ResultLabel = new JLabel("Results will be sown here");
    	MAlabel = new JLabel("Add Moving average");
        AnalysisLabel = new JLabel();
        BackBtn = new JButton();
        MAbox = new JSpinner(new SpinnerNumberModel(5,0,360,1));
        addMA = new JButton();
        CloseBtn = new JButton();
        wChartPanel = new JPanel();
        //wChartPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        wChartPanel.validate();
        AnalysisLabel.setPreferredSize(new Dimension(400,30));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wChartPanel.setName("wChartPanel"); 

        SpringLayout wChartPanelLayout = new SpringLayout();
        wChartPanel.setLayout(wChartPanelLayout);
        
        ResultLabel.setName("AnalsysResult");

        AnalysisLabel.setText("Analysis");
        AnalysisLabel.setName("AnalysisLabel"); 

        BackBtn.setText("Back");
        addMA.setText("ADD");
        CloseBtn.setText("Close");
        CloseBtn.setName("Back");
        CloseBtn.addActionListener(e ->  System.exit(0));
        
        SpringLayout layout = new SpringLayout();
        Container contentPane = this.getContentPane();
        this.getContentPane().setLayout(layout);
        
        this.add(wChartPanel);
        this.add(AnalysisLabel);
        this.add(ResultLabel);
        this.add(MAlabel);
        this.add(MAbox);
        this.add(addMA);
        this.add(CloseBtn);
        this.add(BackBtn);
        
        layout.putConstraint(SpringLayout.WEST, wChartPanel, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.WEST, MAlabel, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.WEST, BackBtn, 50, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, wChartPanel, -30, SpringLayout.WEST, AnalysisLabel);
		layout.putConstraint(SpringLayout.EAST, AnalysisLabel, -50, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.WEST, ResultLabel, 0, SpringLayout.WEST, AnalysisLabel);
		layout.putConstraint(SpringLayout.EAST, ResultLabel, 0, SpringLayout.EAST, AnalysisLabel);
		layout.putConstraint(SpringLayout.WEST, MAbox, 10, SpringLayout.EAST, MAlabel);
		layout.putConstraint(SpringLayout.WEST, addMA, 10, SpringLayout.EAST, MAbox);
		layout.putConstraint(SpringLayout.EAST, CloseBtn, -50, SpringLayout.EAST, contentPane);
		
		layout.putConstraint(SpringLayout.NORTH, wChartPanel, 50, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, wChartPanel, -200, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.NORTH, AnalysisLabel, 0, SpringLayout.NORTH, wChartPanel);
		layout.putConstraint(SpringLayout.NORTH, ResultLabel, 10, SpringLayout.SOUTH, AnalysisLabel);
		layout.putConstraint(SpringLayout.NORTH, MAlabel, 10, SpringLayout.SOUTH, wChartPanel);
		layout.putConstraint(SpringLayout.NORTH, MAbox, 0, SpringLayout.NORTH, MAlabel);
		layout.putConstraint(SpringLayout.NORTH, addMA, 0, SpringLayout.NORTH, MAbox);
		layout.putConstraint(SpringLayout.SOUTH, BackBtn, -50, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, CloseBtn, -50, SpringLayout.SOUTH, contentPane);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
     
    public int getSpinnerValue(){
    	return (int) MAbox.getValue();
    }
     
    public void setChart(JFreeChart chart){
    	chartPanel = new ChartPanel(chart);
    	chartPanel.setSize(wChartPanel.getPreferredSize());
    	//chartPanel.setPreferredSize(new Dimension(300,300));
    	wChartPanel.add(chartPanel);
    	wChartPanel.revalidate();
    	wChartPanel.repaint();
    }
    
    public void AddBtnActionPerformed(ActionListener evt) {
    	addMA.addActionListener(evt);
    }
                   
    private JButton BackBtn;
    private JButton CloseBtn;
    private JSpinner MAbox;
    private JButton addMA;
    private JLabel ResultLabel;
    private JLabel MAlabel;
    private JLabel AnalysisLabel;
    private JPanel wChartPanel;
    private ChartPanel chartPanel;
}
