package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * @author Gurpreet
 */
public class TechnicalAnalysisView extends javax.swing.JFrame {

	private static final long serialVersionUID = 494000442742952620L;
	public TechnicalAnalysisView() {
        initComponents();
    }

     private void initComponents() {

    	ResultLabel = new javax.swing.JLabel();
        AnalysisLabel = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        CloseBtn = new javax.swing.JButton();
        wChartPanel = new JPanel();
        wChartPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        wChartPanel.setPreferredSize(new Dimension(650, 650));
        wChartPanel.validate();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        wChartPanel.setName("wChartPanel"); 

        javax.swing.SpringLayout wChartPanelLayout = new javax.swing.SpringLayout();
        wChartPanel.setLayout(wChartPanelLayout);
        
        ResultLabel.setName("AnalsysResult");

        AnalysisLabel.setText("Analysis");
        AnalysisLabel.setName("AnalysisLabel"); 

        BackBtn.setText("Back");

        CloseBtn.setText("Close");
        CloseBtn.setName("Back");
        CloseBtn.addActionListener(e ->  System.exit(0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(wChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AnalysisLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(ResultLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(BackBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                .addComponent(CloseBtn)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(wChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn)
                    .addComponent(CloseBtn))
                .addGap(25, 25, 25))
        );

        pack();
        this.setVisible(true);
    }                    
     
    public void setChart(JFreeChart chart){
    	chartPanel = new ChartPanel(chart);
    	chartPanel.setPreferredSize(wChartPanel.getSize());
    	wChartPanel.add(chartPanel);
    	wChartPanel.revalidate();
    	wChartPanel.repaint();
    }
                   
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton CloseBtn;
    private javax.swing.JLabel ResultLabel;
    private javax.swing.JLabel AnalysisLabel;
    private JPanel wChartPanel;
    private ChartPanel chartPanel;
}
