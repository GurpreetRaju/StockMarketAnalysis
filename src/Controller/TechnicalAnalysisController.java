package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.TechnicalAnalysis;
import View.TechnicalAnalysisView;

public class TechnicalAnalysisController {
	
	private TechnicalAnalysisView taview;
	private TechnicalAnalysis tamodel;
	private String[] timeperiod;
	
	public TechnicalAnalysisController(TechnicalAnalysisView taview, TechnicalAnalysis tamodel, String[] period){
		this.tamodel = tamodel;
		this.timeperiod = period;
		this.taview = taview;
		this.taview.setChart(this.tamodel.performAnalysis(timeperiod));
		this.taview.AddBtnActionPerformed(new MAListener());	
	}
	
	private class MAListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			int maValue = taview.getSpinnerValue();
			tamodel.addMA(maValue);
		}
	}
	
	public static void main(String[] arg){
		String[] time = {"01,28,2016", "02,28,2017"};
		@SuppressWarnings("unused")
		TechnicalAnalysisController ta = new TechnicalAnalysisController(new TechnicalAnalysisView(), new TechnicalAnalysis(),time);
	}
}
