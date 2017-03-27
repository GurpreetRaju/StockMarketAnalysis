package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.JFreeChart;

import Model.TechnicalAnalysis;
import View.TechnicalAnalysisView;

public class TechnicalAnalysisController {
	
	private TechnicalAnalysisView taview;
	private TechnicalAnalysis tamodel;
	private String[] timeperiod;
	
	public TechnicalAnalysisController(String companyName, String[] period, String companyCode){
		this.tamodel = new TechnicalAnalysis();
		this.timeperiod = period;
		System.out.print(this.timeperiod[0]);
		this.taview = new TechnicalAnalysisView();
		JFreeChart jfree = this.tamodel.performAnalysis(companyName, period, companyCode);
//		JFrame testframe = new JFrame();
//		ChartPanel cp = new ChartPanel(jfree) {
//
//            @Override
//            public Dimension getPreferredSize() {
//                return new Dimension(320, 240);
//            }
//        };
//        cp.setMouseWheelEnabled(true);
//        testframe.add(cp);
//        testframe.setDefaultCloseOperation(0);
//        testframe.pack();
//        testframe.setVisible(true);
		this.taview.setChart(jfree);
		//this.taview.validate();
		this.taview.setVisible(true);
		this.taview.AddBtnActionPerformed(new MAListener());
	}
	
	private class MAListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			//int maValue = taview.getSpinnerValue();
			tamodel.addMA(21);
		}
		
	}
	
	public static void main(String[] arg){
		String[] time = {"01,28,2016", "02,28,2017"};
		@SuppressWarnings("unused")
		TechnicalAnalysisController ta = new TechnicalAnalysisController("Google", time, "GOOGL");
	}
}
