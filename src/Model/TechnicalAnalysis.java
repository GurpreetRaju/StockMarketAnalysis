package Model;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	//private SMAIndicator maIndicator = new SMAIndicator();
	private LineChart chart = null;
		
	public JFreeChart performAnalysis(String[] timeperiod){
		try{
			System.out.println("Call to maIndicator");
			chart = new LineChart("Google", timeperiod);
		}
		catch(Exception e){
			
		}
		return chart.getChart();
	}
	
	public void addMA(int n){
		chart.updateDataset(n);
	}
	
}
