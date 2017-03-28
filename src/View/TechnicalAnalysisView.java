package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    //    private JTextField fromField;
    private JSpinner fromDate;
    private JLabel to;
    //    private JTextField toField;
    private JSpinner toDate;
    private JButton updateBtn;

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
    private JLabel messageLable;
    private JButton closeBtn;


    private JButton nextBtn;
    private JButton BackBtn;
    private JButton addStockBtn;

    public TechnicalAnalysisView() {
        //initComponents();
    }

    public TechnicalAnalysisView(String[] stockList) {
        initComponents(stockList);
    }


    private void initComponents(String[] listString) {
        //Todo: move to function
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                boolean selected = abstractButton.getModel().isSelected();
                String el = new String();
                el = ((AbstractButton) actionEvent.getSource()).getName().toString();
                messageLable.setText(el);
//                System.out.println(selected);
//                System.out.println(el);
            }
        };

        // Declare View
        stockPanel = new JPanel();
        stockPanel.setBorder(BorderFactory.createLineBorder(Color.black));


        stockOptionsPanel = new JPanel();
        stockOptionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        stocklist = new JComboBox<String>(listString);
        // :Todo change to dates http://docs.oracle.com/javase/tutorial/uiswing/components/spinner.html
        from = new JLabel("From:");

        Calendar calendar = new GregorianCalendar();
        Date toStockDate = calendar.getTime();

        calendar.add(Calendar.YEAR, -1);
        Date fromStockDate = calendar.getTime();

        //Todo: change earliestDate to first date of stock history
        calendar.add(Calendar.YEAR, -10);
        Date earliestStockDate = calendar.getTime();


//        fromField = new JTextField("MM,DD,YYYY", 10);
//        toField = new JTextField("MM,DD,YYYY", 10);

        SpinnerDateModel toSpinnerDateModel = new SpinnerDateModel(
                toStockDate, //current
                earliestStockDate, //first
                toStockDate, //last
                Calendar.MONTH);

        SpinnerDateModel fromSpinnerDateModel = new SpinnerDateModel(
                fromStockDate,
                earliestStockDate,
                toStockDate,
                Calendar.MONTH);

//        ChangeListener dateListener = new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                System.out.println(fromDate.toString());
//                System.out.println(toDate.toString());
//            }
//        };
//        FocusListener myFocusListener = new FocusListener() {
//            public void focusGained(java.awt.event.FocusEvent focusEvent) {
//                System.out.println("focusGained");
//                System.out.println(fromDate.toString());
//                System.out.println(toDate.toString());
//            }
//
//            public void focusLost(java.awt.event.FocusEvent focusEvent) {
//                System.out.println("focusLost");
//                System.out.println(fromDate.toString());
//                System.out.println(toDate.toString());
//            }
//        };
        fromDate = new JSpinner();
        fromDate.setModel(fromSpinnerDateModel);
//        fromDate.addChangeListener(dateListener);
//        fromDate.addFocusListener(myFocusListener);

        to = new JLabel("To:");
        toDate = new JSpinner();
        toDate.setModel(toSpinnerDateModel);
//        toDate.addChangeListener(dateListener);
//        toDate.addFocusListener(myFocusListener);

        updateBtn = new JButton();
        updateBtn.setText("Update");
        updateBtn.setName("Update");
//        updateBtn.addActionListener(e -> System.out.println("Update Button"));
        updateBtn.addActionListener(actionListener);

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
        shortChBox.addActionListener(actionListener);
        shortChBox.setName("shortChBox");

        midCBhox = new JCheckBox("Medium-term");
        midCBhox.addActionListener(actionListener);
        midCBhox.setName("midCBhox");

        longChBox = new JCheckBox("Long-term");
        longChBox.addActionListener(actionListener);
        longChBox.setName("longChBox");


        MAlabel = new JLabel("Add Moving average");
        MAbox = new JSpinner(new SpinnerNumberModel(5, 0, 360, 1));
        addMA = new JButton();


        watchListPanel = new JPanel();
        watchListPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        watchListPlaceholder = new JLabel("Watch List Placeholder very very width .... " +
                "I'll add list with pictures.");


        controlsPanel = new JPanel();
        controlsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        messageLable = new JLabel();

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
//        stockOptionsPanel.add(fromField);
        stockOptionsPanel.add(fromDate);
        stockOptionsPanel.add(to);
//        stockOptionsPanel.add(toField);
        stockOptionsPanel.add(toDate);
        stockOptionsPanel.add(updateBtn);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(stockOptionsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 6;
        this.add(wChartPanel, gbc);


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

        controlsPanel.add(messageLable);
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

    public String getStock() {
        return (String) stocklist.getSelectedItem();
    }
}
