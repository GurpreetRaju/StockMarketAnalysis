package Controller;

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
	}
	
	public static void main(String[] arg){
		String[] time = {"01,28,2016", "02,28,2017"};
		TechnicalAnalysisController ta = new TechnicalAnalysisController(new TechnicalAnalysisView(), new TechnicalAnalysis(),time);
	}
}
