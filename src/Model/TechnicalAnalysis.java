package Model;

import org.jfree.chart.JFreeChart;/*
import eu.verdelhan.ta4j.TimeSeries;

import eu.verdelhan.ta4j.indicators.simple.ClosePriceIndicator;
import eu.verdelhan.ta4j.indicators.trackers.SMAIndicator;
import eu.verdelhan.ta4j.Trade;*/

public class TechnicalAnalysis{
	//private SMAIndicator maIndicator = new SMAIndicator();
	private LineChart chart = null;
		
	public JFreeChart performAnalysis(String companyName, String[] timeperiod, String companyCode){
		try{
			System.out.println("Call to maIndicator");
			chart = new LineChart(companyName, timeperiod, companyCode);
		}
		catch(Exception e){
			
		}
		JFreeChart jfree = chart.getChart();

		return jfree;
	}
	
	public void addMA(int n){
		chart.updateDataset(n);
	}
	
	/*public Boolean analysisMA(){
		TimeSeries seriesMA = (TimeSeries) new org.jfree.data.time.TimeSeries(n + " days MA");
		
		Rule buyingRule = new CrossedUpIndicatorRule(shortSma, seriesMA);

		// Selling rules
		// We want to sell:
		//  - if the 5-ticks SMA crosses under 30-ticks SMA
		//  - or if if the price looses more than 3%
		//  - or if the price earns more than 2%
		Rule sellingRule = new CrossedDownIndicatorRule(shortSma, longSma));
		
		return true;
	}*/
	
}
