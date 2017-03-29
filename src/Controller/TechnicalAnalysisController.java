package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.JFreeChart;

import Model.TechnicalAnalysis;
import View.TechnicalAnalysisView;

import javax.swing.*;

public class TechnicalAnalysisController {
	
	private Date startDate = new Date();
	private Date currentDate = new Date();
	private TechnicalAnalysisView taview;
	private TechnicalAnalysis tamodel;
	private ActionListener updateBtnListener;
	private ActionListener shortCheckboxListener;
	private ActionListener midCheckboxListener;
	private ActionListener longCheckboxListener;
	private ActionListener menuExitListner;

	public TechnicalAnalysisController(){
		this.tamodel = new TechnicalAnalysis();
		defaultTimeperiod();
		this.taview = new TechnicalAnalysisView(tamodel.getStockList());
		setChart();
		this.taview.setVisible(true);
//		this.taview.AddBtnActionPerformed(new MAListener());

		//Listeners
		updateBtnListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date[] timePeriod = taview.getDates();
				//taview.setLabelText(taview.getStockSelected() + " from: " + timePeriod[0] + " to: " + timePeriod[1]);
				JFreeChart jfree = tamodel.performAnalysis(taview.getStockSelected(), TechnicalAnalysisController.this.toString(timePeriod[0]), TechnicalAnalysisController.this.toString(timePeriod[1]));
				taview.setChart(jfree);
			}
		};
		taview.addUdateBtnListner(updateBtnListener);

		shortCheckboxListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkState(21,e);
			}
			
		};
		taview.addShortCheckboxListner(shortCheckboxListener);
		
		midCheckboxListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkState(55,e);
			}
			
		};
		taview.addMidCheckboxListner(midCheckboxListener);
		
		longCheckboxListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkState(100,e);
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
	}
	
	public void checkState(int i, ActionEvent e){
		if(((AbstractButton) e.getSource()).isSelected()){
			tamodel.addMA(i);
			taview.setLabelText("Buy");
		}
		else{
			tamodel.removeMA(i);
		}
	};

	private void setChart(){
		String stock = this.taview.getStockSelected();
		System.out.print("Chechpoint stock" + stock);
		JFreeChart jfree = this.tamodel.performAnalysis(stock, toString(startDate), toString(currentDate));
		this.taview.setChart(jfree);
	}

	private void defaultTimeperiod(){
		Calendar cal = Calendar.getInstance();
		currentDate = cal.getTime();
		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
		startDate = cal.getTime();
	}


	private String toString(Date date){
		DateFormat df = new SimpleDateFormat("MM,dd,yyyy");
		String strDate  = df.format(date);		
		return strDate;
	}

}
