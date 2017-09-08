package Controller;

import Model.ConfigModel;
import Model.TechnicalAnalysis;
import View.ConfigSourceDialog;
import View.TechnicalAnalysisView;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class TechnicalAnalysisController {

    private Date[] defaultPeriod = new Date[2];
    private TechnicalAnalysisView taview;
    private TechnicalAnalysis tamodel;
    private ActionListener updateBtnListener;
    private ActionListener addToWishBtnListener;
    private ActionListener delStockBtnListener;
    private ActionListener shortCheckboxListener;
    private ActionListener midCheckboxListener;
    private ActionListener longCheckboxListener;
    private ActionListener menuExitListner;
    private ActionListener menuConfigListener;
    private ActionListener menuRefListener;

    public TechnicalAnalysisController() {
        this.tamodel = new TechnicalAnalysis();
        defaultTimeperiod();
        this.taview = new TechnicalAnalysisView(tamodel.getStockList());
        setChart();
        //this.taview.setWatchlist(this.tamodel.getWatchlist());
        this.taview.setVisible(true);
//		this.taview.AddBtnActionPerformed(new MAListener());

        //Listeners
        updateBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date[] timePeriod = taview.getDates();
                //taview.setLabelText(taview.getStockSelected() + " from: " + timePeriod[0] + " to: " + timePeriod[1]);
                JFreeChart jfree = tamodel.performAnalysis(taview.getStockSelected(), timePeriod);
                taview.setChart(jfree);
                taview.resetChkboxes();
            }
        };
        taview.addUdateBtnListner(updateBtnListener);
        addToWishBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //taview.getStockSelected()
                tamodel.addToWishlist(taview.getStockSelected());
                taview.setWatchlist(tamodel.getWatchlist());
            }
        };
        taview.addToWishBtnListener(addToWishBtnListener);
        delStockBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //taview.getStockSelected()
                tamodel.removeFromWatchlist(taview.getSelectedCheckboxes());
                taview.setWatchlist(tamodel.getWatchlist());
            }
        };
        taview.delStockBtnListner(delStockBtnListener);

        shortCheckboxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkState(20, e);
            }

        };
        taview.addShortCheckboxListner(shortCheckboxListener);

        midCheckboxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkState(55, e);
            }
        };
        taview.addMidCheckboxListner(midCheckboxListener);

        longCheckboxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkState(100, e);
            }

        };
        taview.addLongCheckboxListner(longCheckboxListener);

        menuExitListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        taview.addMenuExitListner(menuExitListner);
        
        menuConfigListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigSourceDialog configDialog = new ConfigSourceDialog(new ConfigController());
            	//ConfigController c = new ConfigController();
            	//setChart();
            }
        };
        taview.addMenuConfigListner(menuConfigListener);
        menuRefListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChart();
            }
        };
        taview.addMenuRefListner(menuRefListener);
    }

    public void checkState(int i, ActionEvent e) {
        if (((AbstractButton) e.getSource()).isSelected()) {
            String iSignal = tamodel.addMA(i);
            if (iSignal != null) {
                taview.setLabelText(iSignal);
                switch (i) {
                    case 20:
                        taview.setShortChBoxImage(iSignal);
                        break;
                    case 55:
                        taview.setMidChBoxImage(iSignal);
                        break;
                    case 100:
                        taview.setLongChBoxImage(iSignal);
                        break;
                }
            }
        } else {
            tamodel.removeMA(i);
            switch (i) {
                case 20:
                    taview.setShortChBoxImage("none");
                    break;
                case 55:
                    taview.setMidChBoxImage("none");
                    break;
                case 100:
                    taview.setLongChBoxImage("none");
                    break;
            }
        }
    }

    ;

    private void setChart() {
    	JFreeChart jfree;
    	if(new ConfigModel().isSourceFile()){
    		jfree = this.tamodel.performAnalysis();
    	}
    	else{
    		String stock = this.taview.getStockSelected();
    		jfree = this.tamodel.performAnalysis(stock, defaultPeriod);
    	}
        this.taview.setChart(jfree);
    }

    private void defaultTimeperiod() {
        Calendar cal = Calendar.getInstance();
        defaultPeriod[1] = cal.getTime();
        cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
        defaultPeriod[0] = cal.getTime();
    }

}
