package Model;

import org.jfree.chart.JFreeChart;

public class TechnicalAnalysis{
	//private SMAIndicator maIndicator = new SMAIndicator();
	private LineChart chart = null;
	private Stock newStock = new Stock();
		
	public JFreeChart performAnalysis(String companyName, String startDate, String currentDate){
		try{
			String[] timeperiod = new String[2];
			timeperiod[0] = startDate;
			timeperiod[1] = currentDate;
			System.out.print("Chechpoint 1" + newStock.getStockCode(companyName));
			chart = new LineChart(companyName, timeperiod, newStock.getStockCode(companyName));
		}
		catch(Exception e){
			System.out.print("Exception" + e);
		}     
		JFreeChart jfree = chart.getChart();
		return jfree;
	}
	
	public void addMA(int i){
		chart.updateDataset(i);
	}

	public String[] getStockList(){
		return newStock.getStockList();
	}
	
}
