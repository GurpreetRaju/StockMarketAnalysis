package Model;

import java.util.Date;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	//private SMAIndicator maIndicator = new SMAIndicator();
	private LineChart chart = null;
		
	public JFreeChart performAnalysis(String companyName, Date[] timeperiod){
			chart = null;
			try{
				stockListReader newStockList = new stockListReader();
				//System.out.print("Chechpoint 1" + newStockList.getStockCode(companyName));
				chart = new LineChart(companyName, timeperiod, newStockList.getStockCode(companyName));
			}
			catch(Exception e){
				System.out.print("Exception" + e);
			}     
			JFreeChart jfree = chart.getChart();
			return jfree;
	}
	
	public String addMA(int i){
		if(!chart.isSeriesExist(i)){
			chart.updateDataset(i);
			return chart.getIndicatorSignal(i);
		}
		return null;
	}

	public String[] getStockList(){
		stockListReader newStockList = new stockListReader();
		return newStockList.getStockList();
	}
	
	public void removeMA(int i) {
		if(chart.isSeriesExist(i)){
			chart.removeSeries(i);
		}		
	}
	
}
