package Model;

import org.jfree.chart.JFreeChart;
//import eu.verdelhan.ta4j.Decimal;
//import eu.verdelhan.ta4j.Rule;
//import eu.verdelhan.ta4j.Strategy;
//import eu.verdelhan.ta4j.TimeSeries;
//import eu.verdelhan.ta4j.TradingRecord;
//import eu.verdelhan.ta4j.analysis.criteria.TotalProfitCriterion;
//import eu.verdelhan.ta4j.indicators.oscillators.StochasticOscillatorKIndicator;
//import eu.verdelhan.ta4j.indicators.simple.ClosePriceIndicator;
//import eu.verdelhan.ta4j.indicators.trackers.SMAIndicator;
//import eu.verdelhan.ta4j.trading.rules.CrossedDownIndicatorRule;
//import eu.verdelhan.ta4j.trading.rules.CrossedUpIndicatorRule;
//import eu.verdelhan.ta4j.trading.rules.OverIndicatorRule;
//import eu.verdelhan.ta4j.trading.rules.StopGainRule;
//import eu.verdelhan.ta4j.trading.rules.StopLossRule;
//import eu.verdelhan.ta4j.trading.rules.UnderIndicatorRule;

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
	
	public void addMA(int i){
		chart.updateDataset(i);
	}
	
}
