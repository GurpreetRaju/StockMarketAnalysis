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
			chart = new LineChart(companyName, timeperiod, newStock.getStockCode(companyName));
		}
		catch(Exception e){
            System.out.println("performAnalysis Exception");
            System.out.println("startDate " + startDate);
            System.out.println("currentDate " + currentDate);

            String[] timeperiod = new String[2];
            timeperiod[0] = "03,28,2016";
            timeperiod[1] = "03,28,2017";

            chart = new LineChart("Google", timeperiod, "GOOG");
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
