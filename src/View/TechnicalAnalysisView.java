package View;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javafx.application.ConditionalFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Gurpreet
 */

// http://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
public class TechnicalAnalysisView extends JFrame {

    private static final long serialVersionUID = 494000442742952620L;

    private Dimension getScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

    // Set up the menus
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuExit;
    private JMenuItem configMenu;

    private JPanel stockPanel;

    private JPanel stockOptionsPanel;
    private JPanel stockOptionsPanelInner1;
    private JPanel stockOptionsPanelInner2;
    private JPanel stockOptionsPanelInnerLeft;
    private JPanel stockOptionsPanelInnerRight;
    private JComboBox<String> stocklist;
    private JLabel from;
    private JSpinner fromDate;
    private JLabel to;
    private JSpinner toDate;
    private JButton updateBtn;
    private JButton addToWishBtn;

    private JPanel wChartPanel;
    private ChartPanel chartPanel;

    private JLabel legengLable;
    private JLabel buyLable;
    private JLabel buyLableImage;
    private JLabel sellLable;
    private JLabel sellLableImage;
    private JLabel keepLable;
    private JLabel keepLableImage;
    private JLabel undefinedLable;
    private JLabel undefinedLableImage;

    private JPanel legendPanel;

    private JPanel analysisPanel;
    private JLabel analysisLabel;
    private JCheckBox shortChBox;
    private JLabel shortChBoxImage;
    private JCheckBox midCBhox;
    private JLabel midCBhoxImage;
    private JCheckBox longChBox;
    private JLabel longChBoxImage;

    private JPanel watchPanel;
    private JPanel watchListPanel;
    private JLabel watchListLabel;
    private JScrollPane scrollPane;
    private JPanel tempJPanel;

    private JPanel watchlistOptionPanel;
    private JButton delStock;

    //Todo Cite the icons.
    //License: Linkware (Backlink to http://www.visualpharm.com required)
    //Commercial usage: Allowed (Backlink to http://www.visualpharm.com required)

    private ImageIcon upImage;
    private String upImagePath = "resources/Stock-Index-Up-icon_16.png";
    private ImageIcon downImage;
    private String downImagePath = "resources/Stock-Index-Down-icon_16.png";
    private ImageIcon keepImage;
    private String keepImagePath = "resources/Stock-Index-Keep-icon_16.png";
    private ImageIcon unknownImage;
    private String unknownImagePath = "resources/Stock-Index-Unknown-icon_16.png";

    private JPanel controlsPanel;
    private JLabel messageLabel;
    private JButton closeBtn;

    public TechnicalAnalysisView(String[] stockList) {
        initComponents(stockList);
    }

    public static void main(String[] arg) {
        String[] stockList = {"Google", "Apple", "Intel"};
        String[][] watchlist = {{"Google", "buy"}, {"Apple", "sell"}, {"Intel", "buy"}};
        TechnicalAnalysisView tv = new TechnicalAnalysisView(stockList);
        tv.setWatchlist(watchlist);
        tv.setVisible(true);
        ActionListener delStockBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] boxes = tv.getSelectedCheckboxes();
                for (String s : boxes) {
                    System.out.println(s);
                }
            }
        };
        tv.delStockBtnListner(delStockBtnListener);
    }

    private void initComponents(String[] listString) {

        // Declare Views
        loadImages();

        // Set up the menus
        menuBar = new JMenuBar();

        //Create the menubar
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuExit = new JMenuItem("Exit");
        menuFile.add(menuExit);
        configMenu = new JMenuItem("Preferences");
        menuFile.add(configMenu);
        
        this.setJMenuBar(menuBar);

        // Stock Panel
        stockPanel = new JPanel();
        stockPanel.setLayout(new GridBagLayout());

        // Stock Panel : Stock, date and update botton.
        stockOptionsPanel = new JPanel();
        stockOptionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        stockOptionsPanelInner1 = new JPanel();
        stockOptionsPanelInner2 = new JPanel();
        stockOptionsPanelInnerLeft = new JPanel();
        stockOptionsPanelInnerRight = new JPanel();

        stocklist = new JComboBox<String>(listString);
        from = new JLabel("From:");

        Calendar calendar = new GregorianCalendar();
        Date toStockDate = calendar.getTime();

        calendar.add(Calendar.YEAR, -1);
        Date fromStockDate = calendar.getTime();

        calendar.add(Calendar.YEAR, -10);
        Date earliestStockDate = calendar.getTime();


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


        fromDate = new JSpinner();
        fromDate.setModel(fromSpinnerDateModel);

        to = new JLabel("To:");
        toDate = new JSpinner();
        toDate.setModel(toSpinnerDateModel);

        updateBtn = new JButton();
        updateBtn.setText("Update");
        updateBtn.setName("Update");

        addToWishBtn = new JButton("Add to Wishlist");
        addToWishBtn.setName("Add to Wishlist");

        // Stock Panel : Stock chart.


        wChartPanel = new JPanel();
        wChartPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        wChartPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);

        wChartPanel.setName("wChartPanel");
        wChartPanel.validate();
        wChartPanel.setSize(getScreenSize);


        legengLable = new JLabel("Legend:");
        buyLable = new JLabel("Buy");
        buyLableImage = new JLabel(upImage);
        sellLable = new JLabel("Sell");
        sellLableImage = new JLabel(downImage);
        keepLable = new JLabel("Keep");
        keepLableImage = new JLabel(keepImage);
        undefinedLable = new JLabel("No signal");
        undefinedLableImage = new JLabel(unknownImage);

        legendPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Stock Panel : Analysis panel, Recommendation label, strategy checkboxes.
        analysisPanel = new JPanel();
        analysisPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        analysisLabel = new JLabel("Analysis:");
        analysisLabel.setName("analysisLabel");


        shortChBox = new JCheckBox("Short-term");
        shortChBox.setName("shortChBox");
        shortChBoxImage = new JLabel(unknownImage);

        midCBhox = new JCheckBox("Medium-term");
        midCBhox.setName("midCBhox");
        midCBhoxImage = new JLabel(unknownImage);

        longChBox = new JCheckBox("Long-term");
        longChBox.setName("longChBox");
        longChBoxImage = new JLabel(unknownImage);


        // Watch Panel.

        watchPanel = new JPanel();
        watchPanel.setLayout(new BoxLayout(watchPanel, BoxLayout.PAGE_AXIS));
        watchPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        watchListLabel = new JLabel("Long Strategy watch list:");

        // Watch list Panel.
        watchListPanel = new JPanel();
        watchListPanel.setLayout(new BoxLayout(watchListPanel, BoxLayout.PAGE_AXIS));
        watchListPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        scrollPane = new JScrollPane(watchListPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        // Control Panel.
        controlsPanel = new JPanel();
        controlsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        messageLabel = new JLabel();

        watchlistOptionPanel = new JPanel();
        watchlistOptionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        delStock = new JButton("Remove selected");

        //Setting Panels

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        this.getContentPane().setLayout(layout);

        stockOptionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        stockOptionsPanelInnerLeft.setLayout(new BoxLayout(stockOptionsPanelInnerLeft, BoxLayout.PAGE_AXIS));

        stockOptionsPanelInner1.setLayout(new FlowLayout(FlowLayout.CENTER));
        stockOptionsPanelInner1.add(stocklist);
        stockOptionsPanelInner1.add(updateBtn);
        stockOptionsPanelInnerLeft.add(stockOptionsPanelInner1);

        stockOptionsPanelInner2.setLayout(new FlowLayout(FlowLayout.CENTER));
        stockOptionsPanelInner2.add(from);
        stockOptionsPanelInner2.add(fromDate);
        stockOptionsPanelInner2.add(to);
        stockOptionsPanelInner2.add(toDate);
        stockOptionsPanelInnerLeft.add(stockOptionsPanelInner2);

        stockOptionsPanelInnerRight.add(addToWishBtn);

        stockOptionsPanel.add(stockOptionsPanelInnerLeft);
        stockOptionsPanel.add(stockOptionsPanelInnerRight);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        stockPanel.add(stockOptionsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        gbc.weightx = 0.9;
        gbc.weighty = 0.9;
        stockPanel.add(wChartPanel, gbc);

        legendPanel.add(legengLable);
        legendPanel.add(new JLabel("   "));
        legendPanel.add(buyLableImage);
        legendPanel.add(buyLable);
        legendPanel.add(new JLabel("   "));
        legendPanel.add(keepLableImage);
        legendPanel.add(keepLable);
        legendPanel.add(new JLabel("   "));
        legendPanel.add(sellLableImage);
        legendPanel.add(sellLable);
        legendPanel.add(new JLabel("   "));
        legendPanel.add(undefinedLableImage);
        legendPanel.add(undefinedLable);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        stockPanel.add(legendPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 8;
        gbc.weightx = 0.9;
        gbc.weighty = 0.9;
        this.add(stockPanel, gbc);

        watchPanel.add(watchListLabel);
        watchPanel.add(scrollPane);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 7;
        gbc.weightx = 0.6;
        gbc.weighty = 0.6;

        this.add(watchPanel, gbc);


        analysisPanel.add(analysisLabel);

        analysisPanel.add(shortChBoxImage);
        analysisPanel.add(shortChBox);

        analysisPanel.add(midCBhoxImage);
        analysisPanel.add(midCBhox);

        analysisPanel.add(longChBoxImage);
        analysisPanel.add(longChBox);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        this.add(analysisPanel, gbc);

        watchlistOptionPanel.add(delStock);
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        this.add(watchlistOptionPanel, gbc);


        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Listeners
    public void addUdateBtnListner(ActionListener actionListener) {
        updateBtn.addActionListener(actionListener);
    }

    public void addToWishBtnListener(ActionListener actionListener) {
        addToWishBtn.addActionListener(actionListener);
    }

    public void addShortCheckboxListner(ActionListener actionListener) {
        shortChBox.addActionListener(actionListener);
    }

    public void addMidCheckboxListner(ActionListener actionListener) {
        midCBhox.addActionListener(actionListener);
    }

    public void addLongCheckboxListner(ActionListener actionListener) {
        longChBox.addActionListener(actionListener);
    }

    public void addMenuExitListner(ActionListener actionListener) {
        menuExit.addActionListener(actionListener);
    }
    
    public void addMenuConfigListner(ActionListener actionListener) {
        configMenu.addActionListener(actionListener);
    }

    public void delStockBtnListner(ActionListener actionListener) {
        delStock.addActionListener(actionListener);
    }

    //Setters and Getters
    public void resetChkboxes() {
        shortChBox.setSelected(false);
        midCBhox.setSelected(false);
        longChBox.setSelected(false);
        shortChBoxImage.setIcon(unknownImage);
        midCBhoxImage.setIcon(unknownImage);
        longChBoxImage.setIcon(unknownImage);

    }

    public void setLabelText(String text) {
        messageLabel.setText(text);
    }

    public ImageIcon convertSignal(String signal) {
        switch (signal) {
            case "buy":
                return upImage;
            case "sell":
                return downImage;
            case "keep":
                return keepImage;
            case "none":
                return unknownImage;
            default:
                return unknownImage;
        }
    }

    public void setShortChBoxImage(String signal) {
        shortChBoxImage.setIcon(convertSignal(signal));
    }

    public void setMidChBoxImage(String signal) {
        midCBhoxImage.setIcon(convertSignal(signal));
    }

    public void setLongChBoxImage(String signal) {
        longChBoxImage.setIcon(convertSignal(signal));
    }

    public Date[] getDates() {
        return new Date[]{(Date) fromDate.getValue(), (Date) toDate.getValue()};
    }

    public String getStockSelected() {
        return (String) stocklist.getSelectedItem();
    }

    public String[] getSelectedCheckboxes() {
        ArrayList<String> remstocks = new ArrayList<String>();
        for (JCheckBox c : checkBoxes) {
            if (c.isSelected()) {
                remstocks.add(c.getText());
            }
        }

        return remstocks.toArray(new String[remstocks.size()]);
    }

    private void loadImages() {
        upImage = new ImageIcon(upImagePath);
        downImage = new ImageIcon(downImagePath);
        keepImage = new ImageIcon(keepImagePath);
        unknownImage = new ImageIcon(unknownImagePath);
    }

    public void setChart(JFreeChart chart) {
        chartPanel = new ChartPanel(chart);
        chartPanel.setSize(getScreenSize);
        chartPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //chartPanel.updateUI();
            }
        });

        if (wChartPanel.getComponentCount() != 0) {
            wChartPanel.removeAll();
        }

        chartPanel.updateUI();
        wChartPanel.add(chartPanel);


        wChartPanel.revalidate();
        wChartPanel.repaint();
        wChartPanel.updateUI();
    }

    public void setWatchlist(String[][] watchListEntities) {
        if (watchListPanel.getComponentCount() != 0) {
            watchListPanel.removeAll();
            this.checkBoxes.clear();
        }
        GridBagConstraints gbc = new GridBagConstraints();
        for (String[] str : watchListEntities) {
            tempJPanel = new JPanel();
            tempJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            if (str[1].equals("buy")) {
                tempJPanel.add(new JLabel(upImage));
            } else if (str[1].equals("sell")) {
                tempJPanel.add(new JLabel(downImage));
            } else {    //no buy or sell
                tempJPanel.add(new JLabel(keepImage));
            }
            JCheckBox cb = new JCheckBox(str[0]);
            cb.setHorizontalTextPosition(SwingConstants.RIGHT);
            tempJPanel.add(cb);
            this.checkBoxes.add(cb);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 0.0;
            gbc.weighty = 0.0;

            watchListPanel.add(tempJPanel);
        }
        watchListPanel.revalidate();
        watchListPanel.repaint();
        watchListPanel.updateUI();
    }
}
