package Model;

import java.util.LinkedList;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	private Data data = new Data();
	private SMAIndicator maIndicator = new SMAIndicator();
	
	public LinkedList<String[]> performAnalysis(String[] timeperiod){
//		JFreeChart chart = null;
		LinkedList<String[]> chart = new LinkedList<String[]>();
		try{
			System.out.println("Call to maIndicator");
//			chart = maIndicator.createChart(data.getData(timeperiod));
			chart = data.getData(timeperiod);
		}
		catch(Exception e){
			
		}
		return chart;
	}
	
}
