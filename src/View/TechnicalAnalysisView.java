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

    public TechnicalAnalysisView() {
        initComponents();
    }

    private void initComponents() {

        // Declare View
        stockPanel = new JPanel();
        stockPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        stockOptionsPanel = new JPanel();
        stockOptionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        from = new JLabel("From:");
        to = new JLabel("To:");
        stocklist = new JComboBox<String>(listString);
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




//        this.add(stocklist);
//        this.add(from);
//        this.add(to);
//        this.add(fromField);
//        this.add(toField);

//        this.add(wChartPanel);

//        this.add(analysisLabel);
//        this.add(resultLabel);
//        this.add(MAlabel);
//        this.add(MAbox);
//        this.add(addMA);
//        this.add(closeBtn);
//        this.add(BackBtn);
//
//        this.add(nextBtn);
//        this.add(addStockBtn);


//        layout.putConstraint(SpringLayout.NORTH, stockPanel, 10, SpringLayout.NORTH, contentPane);
//        layout.putConstraint(SpringLayout.WEST, stockPanel, 10, SpringLayout.WEST, contentPane);
//        layout.putConstraint(SpringLayout.EAST, stockPanel, -10, SpringLayout.WEST, watchListPanel);
//        layout.putConstraint(SpringLayout.SOUTH, stockPanel, -10, SpringLayout.NORTH, controlsPanel);
//
//
//        layout.putConstraint(SpringLayout.NORTH, stockOptionsPanel, 20, SpringLayout.NORTH, stockPanel);
//        layout.putConstraint(SpringLayout.WEST, stockOptionsPanel, 20, SpringLayout.WEST, stockPanel);
//
//        layout.putConstraint(SpringLayout.NORTH, stocklist, 10, SpringLayout.NORTH, stockOptionsPanel);
//        layout.putConstraint(SpringLayout.WEST, stocklist, 50, SpringLayout.WEST, stockOptionsPanel);
//
//        layout.putConstraint(SpringLayout.NORTH, from, 10, SpringLayout.NORTH, stockOptionsPanel);
//        layout.putConstraint(SpringLayout.WEST, from, 10, SpringLayout.EAST, stocklist);
//
//        layout.putConstraint(SpringLayout.NORTH, fromField, 10, SpringLayout.NORTH, stockOptionsPanel);
//        layout.putConstraint(SpringLayout.WEST, fromField, 10, SpringLayout.EAST, from);
//
//        layout.putConstraint(SpringLayout.NORTH, toField, 10, SpringLayout.NORTH, stockOptionsPanel);
//        layout.putConstraint(SpringLayout.WEST, toField, 10, SpringLayout.EAST, fromField);
//
//        layout.putConstraint(SpringLayout.NORTH, to, 10, SpringLayout.NORTH, stockOptionsPanel);
//        layout.putConstraint(SpringLayout.WEST, to, 10, SpringLayout.EAST, toField);
//
//        layout.putConstraint(SpringLayout.NORTH, wChartPanel, 10, SpringLayout.SOUTH, stockOptionsPanel);
//        layout.putConstraint(SpringLayout.WEST, wChartPanel, 10, SpringLayout.WEST, stockPanel);
//        layout.putConstraint(SpringLayout.EAST, wChartPanel, -10, SpringLayout.EAST, stockPanel);
////        layout.putConstraint(SpringLayout.SOUTH, wChartPanel, 200, SpringLayout.SOUTH, stockOptionsPanel);
//
//        layout.putConstraint(SpringLayout.NORTH, watchListPanel, 10, SpringLayout.NORTH, contentPane);
////        layout.putConstraint(SpringLayout.WEST, watchListPanel, 10, SpringLayout.EAST, stockPanel);
//        layout.putConstraint(SpringLayout.EAST, watchListPanel, -10, SpringLayout.EAST, contentPane);
//        layout.putConstraint(SpringLayout.SOUTH, watchListPanel, -10, SpringLayout.NORTH, controlsPanel);

//        layout.putConstraint(SpringLayout.NORTH, analysisPanel, 10, SpringLayout.SOUTH, stockPanel);
//        layout.putConstraint(SpringLayout.WEST, analysisPanel, 10, SpringLayout.WEST, contentPane);
//        layout.putConstraint(SpringLayout.EAST, analysisPanel, -10, SpringLayout.WEST, watchListPanel);
//        layout.putConstraint(SpringLayout.SOUTH, analysisPanel, -10, SpringLayout.NORTH, controlsPanel);
//
//        layout.putConstraint(SpringLayout.WEST, controlsPanel, 10, SpringLayout.WEST, contentPane);
//        layout.putConstraint(SpringLayout.EAST, controlsPanel, -10, SpringLayout.EAST, contentPane);
//        layout.putConstraint(SpringLayout.SOUTH, controlsPanel, -10, SpringLayout.WEST, contentPane);


//        layout.putConstraint(SpringLayout.NORTH, MAlabel, 10, SpringLayout.SOUTH, wChartPanel);
//        layout.putConstraint(SpringLayout.WEST, MAlabel, 50, SpringLayout.WEST, contentPane);
//
//        layout.putConstraint(SpringLayout.SOUTH, BackBtn, -50, SpringLayout.SOUTH, contentPane);
//        layout.putConstraint(SpringLayout.WEST, BackBtn, 50, SpringLayout.WEST, contentPane);
//
//        layout.putConstraint(SpringLayout.NORTH, analysisLabel, 0, SpringLayout.NORTH, wChartPanel);
//        layout.putConstraint(SpringLayout.EAST, analysisLabel, -50, SpringLayout.EAST, contentPane);
//
//        layout.putConstraint(SpringLayout.NORTH, resultLabel, 10, SpringLayout.SOUTH, analysisLabel);
//        layout.putConstraint(SpringLayout.WEST, resultLabel, 0, SpringLayout.WEST, analysisLabel);
//        layout.putConstraint(SpringLayout.EAST, resultLabel, 0, SpringLayout.EAST, analysisLabel);
//
//        layout.putConstraint(SpringLayout.NORTH, MAbox, 0, SpringLayout.NORTH, MAlabel);
//        layout.putConstraint(SpringLayout.WEST, MAbox, 10, SpringLayout.EAST, MAlabel);
//
//        layout.putConstraint(SpringLayout.NORTH, addMA, 0, SpringLayout.NORTH, MAbox);
//        layout.putConstraint(SpringLayout.WEST, addMA, 10, SpringLayout.EAST, MAbox);
//
//        layout.putConstraint(SpringLayout.SOUTH, closeBtn, -50, SpringLayout.SOUTH, contentPane);
//        layout.putConstraint(SpringLayout.EAST, closeBtn, -50, SpringLayout.EAST, contentPane);
//
//
//        layout.putConstraint(SpringLayout.NORTH, nextBtn, 10, SpringLayout.SOUTH, fromField);
//        layout.putConstraint(SpringLayout.WEST, nextBtn, 50, SpringLayout.WEST, contentPane);
//
//        layout.putConstraint(SpringLayout.NORTH, addStockBtn, 10, SpringLayout.SOUTH, nextBtn);
//        layout.putConstraint(SpringLayout.WEST, addStockBtn, 50, SpringLayout.WEST, contentPane);
//
//        layout.putConstraint(SpringLayout.NORTH, errorMessage, 10, SpringLayout.SOUTH, addStockBtn);
//        layout.putConstraint(SpringLayout.WEST, errorMessage, 50, SpringLayout.WEST, contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public int getSpinnerValue() {
        return (int) MAbox.getValue();
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
