package Model;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	private Data data = new Data();
	private SMAIndicator maIndicator = new SMAIndicator();
	
	public JFreeChart performAnalysis(String[] timeperiod){
		JFreeChart chart = null;
		try{
			System.out.println("Call to maIndicator");
			chart = maIndicator.createChart(data.getData(timeperiod));
		}
		catch(Exception e){
			
		}
		return chart;
	}
	
}
