package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.JFreeChart;

import Model.TechnicalAnalysis;
import View.TechnicalAnalysisView;

import javax.swing.*;

public class TechnicalAnalysisController {
	
	private Date[] defaultPeriod = new Date[2];
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
				JFreeChart jfree = tamodel.performAnalysis(taview.getStockSelected(),timePeriod);
				taview.setChart(jfree);
			}
		};
		taview.addUdateBtnListner(updateBtnListener);

		shortCheckboxListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkState(20,e);
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
			String Isignal = tamodel.addMA(i);
			if(Isignal!=null){
				taview.setLabelText(Isignal);
			}
		}
		else{
			tamodel.removeMA(i);
		}
	};

	private void setChart(){
		String stock = this.taview.getStockSelected();
		System.out.print("Chechpoint stock" + stock);
		JFreeChart jfree = this.tamodel.performAnalysis(stock, defaultPeriod);
		this.taview.setChart(jfree);
	}

	private void defaultTimeperiod(){
		Calendar cal = Calendar.getInstance();
		defaultPeriod[1] = cal.getTime();
		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
		defaultPeriod[0] = cal.getTime();
	}
	
}
