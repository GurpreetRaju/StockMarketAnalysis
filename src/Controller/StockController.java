package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Stock;
import View.StockView;

public class StockController {
	private StockView theview;
	private Stock themodel;
	
	public StockController(){
		this.theview =  new StockView(); ;
		this.themodel = new Stock();
		this.theview.nextBtnActionPerformed(new ListenerStock());
	}
	
	class ListenerStock implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String[] time = theview.getTime();
			String companyName = "CompanyName";
			String companyCode = themodel.getStockCode(theview.getStock());
			//String[] time = {"01,28,2016", "02,28,2017"};
			theview.setVisible(false);
	          @SuppressWarnings("unused")
			TechnicalAnalysisController taController = new TechnicalAnalysisController();
	    }
	}
}
