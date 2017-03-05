package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Stock;
import Model.TechnicalAnalysis;
import View.StockView;
import View.TechnicalAnalysisView;

public class StockController {
	private StockView theview;
	private Stock themodel;
	
	public StockController(StockView theview, Stock themodel){
		this.theview = theview;
		this.themodel = themodel;
		this.theview.nextBtnActionPerformed(new ListenerStock());
	}
	
	class ListenerStock implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String[] time = theview.getTime();
			theview.setVisible(false);
	          @SuppressWarnings("unused")
			TechnicalAnalysisController taController = new TechnicalAnalysisController(new TechnicalAnalysis(), time);
	    }
	}
}
