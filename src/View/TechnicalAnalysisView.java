package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * @author Gurpreet
 */

// http://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
public class TechnicalAnalysisView extends JFrame {

    private static final long serialVersionUID = 494000442742952620L;
    private String[] listString = {"Google", "IBM", "Microsoft"};

    private JPanel stockPanel;

    private JPanel stockOptionsPanel;
    private JComboBox<String> stocklist;
    private JLabel from;
    private JTextField fromField;
    private JLabel to;
    private JTextField toField;

    private JPanel wChartPanel;
    private ChartPanel chartPanel;

    private JPanel analysisPanel;
    private JLabel analysisLabel;
    private JLabel resultLabel;
    private JCheckBox shortChBox;
    private JCheckBox midCBhox;
    private JCheckBox longChBox;

    private JSpinner MAbox;
    private JButton addMA;
    private JLabel MAlabel;

    private JPanel watchListPanel;
    private JLabel watchListPlaceholder;

    private JPanel controlsPanel;
    private JLabel errorMessage;
    private JButton closeBtn;


    private JButton nextBtn;
    private JButton BackBtn;
    private JButton addStockBtn;

    public TechnicalAnalysisView(String[] newListString) {
        initComponents(newListString);
    }

    private void initComponents(String[] newListString) {

        // Declare View
        stockPanel = new JPanel();
        stockPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        stockOptionsPanel = new JPanel();
        stockOptionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        from = new JLabel("From:");
        to = new JLabel("To:");
        stocklist = new JComboBox<String>(newListString);
        // :Todo change to dates http://docs.oracle.com/javase/tutorial/uiswing/components/spinner.html
        fromField = new JTextField("MM,DD,YYYY", 10);
        toField = new JTextField("MM,DD,YYYY", 10);

        wChartPanel = new JPanel();
        wChartPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        wChartPanel.setName("wChartPanel");
        wChartPanel.validate();
        wChartPanel.setPreferredSize(new Dimension(800, 600));
//        SpringLayout wChartPanelLayout = new SpringLayout();
//        wChartPanel.setLayout(wChartPanelLayout);


        analysisPanel = new JPanel();
        analysisPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        resultLabel = new JLabel("Results will be sown here");
        resultLabel.setName("AnalsysResult");

        analysisLabel = new JLabel("Analisis Lable placeholder");
        analysisLabel.setText("Analysis");
        analysisLabel.setName("analysisLabel");

        shortChBox = new JCheckBox("Short-term");
        midCBhox = new JCheckBox("Medium-term");
        longChBox = new JCheckBox("Long-term");


        MAlabel = new JLabel("Add Moving average");
        MAbox = new JSpinner(new SpinnerNumberModel(5, 0, 360, 1));
        addMA = new JButton();


        watchListPanel = new JPanel();
        watchListPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        watchListPlaceholder = new JLabel("Watch List Placeholder very very width .... " +
                "I'll add list with pictures.");


        controlsPanel = new JPanel();
        controlsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        closeBtn = new JButton();
        closeBtn.setText("Close");
        closeBtn.setName("Back");
        closeBtn.addActionListener(e -> System.exit(0));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //other
        nextBtn = new JButton();
        nextBtn.setText("Next");

        BackBtn = new JButton();
        addStockBtn = new JButton();
        addStockBtn.setText("Add Stock");

        BackBtn.setText("Back");
        addMA.setText("ADD");

        //Build view https://examples.javacodegeeks.com/desktop-java/swing/java-swing-layout-example/
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //https://docs.oracle.com/javase/7/docs/api/java/awt/GridBagConstraints.html
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        this.getContentPane().setLayout(layout);


        stockOptionsPanel.add(stocklist);
        stockOptionsPanel.add(from);
        stockOptionsPanel.add(fromField);
        stockOptionsPanel.add(to);
        stockOptionsPanel.add(toField);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(stockOptionsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
        this.add(wChartPanel,gbc);


        watchListPanel.add(watchListPlaceholder);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 9;
        this.add(watchListPanel, gbc);

        analysisPanel.add(analysisLabel);
        analysisPanel.add(shortChBox);
        analysisPanel.add(midCBhox);
        analysisPanel.add(longChBox);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        this.add(analysisPanel, gbc);

        controlsPanel.add(closeBtn);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        this.add(controlsPanel, gbc);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public int getSpinnerValue() {
        return (int) MAbox.getValue();
    }
    
    public String getStock() {		
		return (String) stocklist.getSelectedItem();
	}

    public void setChart(JFreeChart chart) {
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

}
