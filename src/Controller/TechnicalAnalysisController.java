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

public class TechnicalAnalysisController {
	
	private Date startDate = new Date();
	private Date currentDate = new Date();
	private TechnicalAnalysisView taview;
	private TechnicalAnalysis tamodel;
	
	public TechnicalAnalysisController(){
		this.tamodel = new TechnicalAnalysis();
		defaultTimeperiod();
		this.taview = new TechnicalAnalysisView(tamodel.getStockList());
		setChart();
		this.taview.setVisible(true);
		this.taview.AddBtnActionPerformed(new MAListener());
	}
	
	private void setChart(){
		String stock = this.taview.getStock();
		JFreeChart jfree = this.tamodel.performAnalysis(stock, toString(startDate), toString(currentDate));
		this.taview.setChart(jfree);
		
	}
	
	private void defaultTimeperiod(){
		Calendar cal = Calendar.getInstance();
		currentDate = cal.getTime();
		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
		startDate = cal.getTime();
	}
	
	private class MAListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			//int maValue = taview.getSpinnerValue();
			tamodel.addMA(21);
		}
		
	}
	
	private String toString(Date date){
		DateFormat df = new SimpleDateFormat("MM,dd,yyyy");
		String strDate  = df.format(date);		
		return strDate;
	}
	
	public static void main(String[] arg){
		//String[] time = {"01,28,2016", "02,28,2017"};
		//TechnicalAnalysisController ta = new TechnicalAnalysisController("Google", time, "GOOGL");
	}
}
